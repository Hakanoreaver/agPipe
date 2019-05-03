package FarmEd.beta.InformationPipeline;

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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/main")  // This means URL's start with /main (after Application path)
@CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository queryRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ResponseRepository responseRepository;


    @GetMapping(path = "/isServerRunning")
    public @ResponseBody
    boolean sendTest() {
        return true;
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "/login/{username}/{password}")
    public @ResponseBody
    int logIn(@PathVariable String username, @PathVariable String password) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            return -1;
        }
        if (user.getPassword().equals(password)) {
            return user.getId();
        } else {
            return -1;
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "/loginAdmin/{username}/{password}")
    public @ResponseBody
    boolean logInAdmin(@PathVariable String username, @PathVariable String password) {
        Admin admin = adminRepository.findByUserName(username);
        if (admin == null) {
            return false;
        }
        if (admin.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping(path="query/{n}/{p}/{k}/{pH}/{date}/{location}/{userNum}/{question}/{image}")
    public @ResponseBody
    boolean makeQuery(@PathVariable double n, @PathVariable double p, @PathVariable double k, @PathVariable double pH,
                      @PathVariable Date d, @PathVariable String location, @PathVariable int userNum, @PathVariable String question,
                      @PathVariable String image) {
        Question query = new Question();
        query.setAnswered(false);
        query.setN(n);
        query.setP(p);
        query.setK(k);
        query.setpH(pH);
        query.setDate(d);
        query.setLocation(location);
        query.setUserNum(userNum);
        query.setQuestion(question);
        query.setImage(image);
        queryRepository.save(query);
        return true;
    }

    @PostMapping(path="query/{username}/{password}")
    public @ResponseBody
    boolean createAccount(@PathVariable String username, @PathVariable String password) {
        User user = new User();
        user.setPassword(password);
        user.setUserName(username);
        userRepository.save(user);
        return true;
    }

    @PostMapping(path="query/{queryNum}/{reply}")
    public @ResponseBody
    boolean createReply(@PathVariable int queryNum, @PathVariable String reply) {
        Response response = new Response();
        response.setReply(reply);
        response.setQueryNum(queryNum);
        return true;
    }

    @GetMapping(path="query/{state}")
    public @ResponseBody
    List<Question> getQueries(@PathVariable boolean state) {
        return queryRepository.findByAnswered(state);
    }

    @GetMapping(path="getResponses/{userId}")
    public @ResponseBody
    List<String> getResponses(@PathVariable int userId) {
        ArrayList<String> strings = new ArrayList<>();
        List<Question> questions = queryRepository.findByUser(userId);
        for(Question q : questions) {
            if (q.isAnswered()) {
                Response r = responseRepository.findByQuery(q.getId());
                String string = q.getId() + "," + q.getUserNum() + "," + q.getK() + "," + q.getN() + "," + q.getP()
                        + "," + q.getDate() + "," +  q.getImage() + "," +  q.getLocation() + "," + q.getQuestion()
                        + "," + r.getId() + "," +  r.getQueryNum() + "," +  r.getReply();
                strings.add(string);
            }
        }
        return strings;
    } 


}

