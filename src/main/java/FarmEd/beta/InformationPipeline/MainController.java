package FarmEd.beta.InformationPipeline;

import FarmEd.beta.InformationPipeline.Models.*;
import FarmEd.beta.InformationPipeline.Queries.Question;
import FarmEd.beta.InformationPipeline.Queries.QuestionRepository;
import FarmEd.beta.InformationPipeline.Responses.Response;
import FarmEd.beta.InformationPipeline.Responses.ResponseRepository;
import FarmEd.beta.InformationPipeline.Responses.UserUpdateRespone;
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
    @LogExecutionTime
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
    @LogExecutionTime
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

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/user/update")
    public @ResponseBody
    void updateUser(@RequestBody UserUpdateRespone u) {
        userRepository.updateUser(u.getId(), u.getFarmName(), u.getProvince(), u.getDivision(), u.getExtent(), u.getC(), u.getN(), u.getP(), u.getK(), u.getpH(), u.isSoilTest(), u.getMicronutrients(), u.getWaterSource(), u.getAggrozone());
    }

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/user/find/{userId}")
    public @ResponseBody
    User getUser(@PathVariable int userId) {
        User user = userRepository.findById(userId);
        return user;
    }

    /**
     * Function to create a user
     * @param login
     * @return
     */
    @LogExecutionTime
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
    @LogExecutionTime
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

    @LogExecutionTime
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
            query.setPesticides(response.getPesticides());
            query.setFertilisers(response.getFertilisers());
            query.setLength(response.getLength());
            query.setFrequency(response.getFrequency());
            queryRepository.save(query);
            return "true";
        }
        catch(Exception e) {
            return e.toString();
        }
    }

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="query/{queryNum}/{reply}")
    public @ResponseBody
    boolean createReply(@PathVariable int queryNum, @PathVariable String reply) {
        Response response = new Response();
        response.setReply(reply);
        response.setQueryNum(queryNum);
        return true;
    }

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path="queryFind/{queryNum}")
    public @ResponseBody
    QuestionRequest getQuestion(@PathVariable String queryNum) {
        Question temp = queryRepository.findById(Integer.parseInt(queryNum));
        QuestionRequest qr = new QuestionRequest();
        qr.setFertilisers(temp.getFertilisers());
        qr.setFrequency(temp.getFrequency());
        qr.setImage(temp.getImage());
        qr.setK(temp.getK());
        qr.setLength(temp.getLength());
        qr.setN(temp.getN());
        qr.setP(temp.getP());
        qr.setPesticides(temp.getPesticides());
        qr.setpH(temp.getpH());
        qr.setQuestion(temp.getQuestion());
        qr.setLocation(temp.getLocation());
        qr.setUserNum(temp.getUserNum());
        User u = userRepository.findById(temp.getUserNum());
        qr.setUsername(u.getUserName());
        return qr;
    }

    @LogExecutionTime
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

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path="query/noImage/{state}")
    public @ResponseBody
    List<QuestionNoImageRequest> getQueriesNoImageByState(@PathVariable boolean state) {
        ArrayList<QuestionNoImageRequest> ret = new ArrayList<>();
        List<Question> qs = queryRepository.findByAnswered(state);
        for(Question q : qs) {
            QuestionNoImageRequest t = new QuestionNoImageRequest(q);
            //User u = userRepository.findById(q.getUserNum());
            //t.setUsername(u.getUserName());
            ret.add(t);
        }
        return ret;
    }

    @LogExecutionTime
    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path="query/all")
    public @ResponseBody
    Iterable<Question> getQueries() {
        return queryRepository.findAll();
    }

    @LogExecutionTime
    @PostMapping(path="getResponses/{userId}")
    public @ResponseBody
    List<ResponseResponse> getResponses(@PathVariable int userId) {
        ArrayList<ResponseResponse> responses = new ArrayList<>();
        List<Question> questions = queryRepository.findByUser(userId);
        for(Question q : questions) {
            if (q.isAnswered()) {
                Response r = responseRepository.findByQuery(q.getId());
                responses.add(new ResponseResponse(q.getId(), r.getReply(), q.getQuestion()));
            }
        }
        return responses;
    }

    @CrossOrigin(origins = "https://agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path="responses/add/{queryNum}/{response}")
    public @ResponseBody
    void addResponse(@PathVariable int queryNum, @PathVariable String response) {
        Question q = queryRepository.findById(queryNum);
        if(q.isAnswered()) {
            return;
        }
        Response r = new Response();
        r.setReply(response);
        r.setQueryNum(queryNum);
        queryRepository.setAnswered(queryNum);
        responseRepository.save(r);
    }


}

