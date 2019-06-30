package FarmEd.beta.InformationPipeline;

import FarmEd.beta.InformationPipeline.Models.CreateRequest;
import FarmEd.beta.InformationPipeline.Models.QuestionRequest;
import FarmEd.beta.InformationPipeline.Models.ResponseResponse;
import FarmEd.beta.InformationPipeline.Models.UserResponse;
import FarmEd.beta.InformationPipeline.Queries.Question;
import FarmEd.beta.InformationPipeline.Queries.QuestionRepository;
import FarmEd.beta.InformationPipeline.Responses.Response;
import FarmEd.beta.InformationPipeline.Responses.ResponseRepository;
import FarmEd.beta.InformationPipeline.Users.Admin;
import FarmEd.beta.InformationPipeline.Users.AdminRepository;
import FarmEd.beta.InformationPipeline.Users.User;
import FarmEd.beta.InformationPipeline.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.io.Console;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/main")  // This means URL's start with /main (after Application path)
@CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository queryRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ResponseRepository responseRepository;

    /**
     * Function to 'ping' the server and check if it is running
     * @return
     */
    @GetMapping(path = "/isServerRunning")
    public @ResponseBody
    boolean sendTest() {
        return true;
    }

    /**
     * Function to log in a user
     * @param login
     * @return
     */
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/user/login")
    public @ResponseBody
    int logIn(@RequestBody UserResponse login) {
        User user = userRepository.findByUserName(login.getUsername());
        if (user == null) {
            return -1;
        }
        if (user.getPassword().equals(login.getPassword())) {
            return user.getId();
        } else {
            return -2;
        }
    }

    /**
     * Function to create a user
     * @param login
     * @return
     */
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/user/create")
    public @ResponseBody
    int createUser(@RequestBody CreateRequest login) {
        if(!login.getPin().equals("2019")) {
            return -2;
        }
        User user = userRepository.findByUserName(login.getUsername());
        if (user == null) {
            User newUser = new User();
            newUser.setUserName(login.getUsername());
            newUser.setPassword(login.getPassword());
            userRepository.save(newUser);
            return newUser.getId();
        }
        else {
            return -1;
        }
    }

    /**
     * Function to log in an admin
     * @param login
     * @return
     */
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/admin/login")
    public @ResponseBody
    boolean logInAdmin(@RequestBody UserResponse login) {
        Admin admin = adminRepository.findByUserName(login.getUsername());
        if (admin == null) {
            return false;
        }
        if (admin.getPassword().equals(login.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="query/add")
    public @ResponseBody
    String addQuery(@RequestBody QuestionRequest response) {
        try {
            Question query = new Question();
            query.setAnswered(false);
            query.setN(response.getN());
            query.setP(response.getP());
            query.setK(response.getK());
            query.setpH(response.getpH());
            query.setDate(new Date(System.currentTimeMillis()));
            query.setLocation(response.getLocation());
            query.setUserNum(response.getUserNum());
            query.setQuestion(response.getQuestion());
            query.setImage(response.getImage());
            queryRepository.save(query);
            return "true";
        }
        catch(Exception e) {
            return e.toString();
        }
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="query/{username}/{password}")
    public @ResponseBody
    boolean createAccount(@PathVariable String username, @PathVariable String password) {
        User user = new User();
        user.setPassword(password);
        user.setUserName(username);
        userRepository.save(user);
        return true;
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="query/{queryNum}/{reply}")
    public @ResponseBody
    boolean createReply(@PathVariable int queryNum, @PathVariable String reply) {
        Response response = new Response();
        response.setReply(reply);
        response.setQueryNum(queryNum);
        return true;
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path="queryFind/{queryNum}")
    public @ResponseBody
    Question getQuestion(@PathVariable String queryNum) {
        Question temp = queryRepository.findById(Integer.parseInt(queryNum));
        return temp;
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="queryFind/{image}")
    public void postTest(@RequestBody QuestionRequest response) {
        System.out.println(response.getImage());
    }

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path="query/{state}")
    public @ResponseBody
    List<Question> getQueriesByState(@PathVariable boolean state) {
        return queryRepository.findByAnswered(state);
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path="query/all")
    public @ResponseBody
    Iterable<Question> getQueries() {
        return queryRepository.findAll();
    }

    @PostMapping(path="getResponses/{userId}")
    public @ResponseBody
    List<String> getResponses(@PathVariable int userId) {
        ArrayList<String> strings = new ArrayList<>();
        List<Question> questions = queryRepository.findByUser(userId);
        for(Question q : questions) {
            if (q.isAnswered()) {
                Response r = responseRepository.findByQuery(q.getId());
                String string = q.getId() + "^" +  q.getQuestion() + "^" +  r.getReply();
                strings.add(string);
            }
        }
        return strings;
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="responses/add/{queryNum}/{response}")
    public @ResponseBody
    void addResponse(@PathVariable int queryNum, @PathVariable String response) {
        Response r = new Response();
        r.setReply(response);
        r.setQueryNum(queryNum);
        queryRepository.setAnswered(queryNum);
        responseRepository.save(r);
    }


}

