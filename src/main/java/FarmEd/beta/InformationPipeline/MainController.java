package FarmEd.beta.InformationPipeline;

import FarmEd.beta.InformationPipeline.Users.User;
import FarmEd.beta.InformationPipeline.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/main")  // This means URL's start with /main (after Application path)

public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/isServerRunning")
    public @ResponseBody
    boolean sendTest() {
        return true;
    }

    @CrossOrigin(origins = "agriculturepipeline.com", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "/login/{username}/{password}")
    public @ResponseBody
    boolean logIn(@PathVariable String username, @PathVariable String password) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}

