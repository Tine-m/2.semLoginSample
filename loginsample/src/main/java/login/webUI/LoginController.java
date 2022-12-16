package login.webUI;

import login.repositories.UserRepositoryImpl;
import login.domain.services.LoginService;
import login.domain.LoginSampleException;
import login.domain.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LoginController {
 
    //Inversion of Control
    private LoginService loginService = new LoginService(new UserRepositoryImpl());

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @PostMapping("/login")
    public String loginUser(WebRequest request) throws LoginSampleException {
        //Retrieve values from HTML form via WebRequest
        String email = request.getParameter("email");
        String pwd = request.getParameter("password");

        // delegate work + data to login controller
        User user = loginService.login(email, pwd);

        // Set user and role in session
        request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
        request.setAttribute("role", user.getRole(), WebRequest.SCOPE_SESSION);

        return "userpages/" + user.getRole();
    }

    @PostMapping("/register")
    public String createUser(WebRequest request) throws LoginSampleException {
        //Retrieve values from HTML form via WebRequest
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        // If passwords match, work + data is delegated to login service
        if (password1.equals(password2)) {
            User user = loginService.createUser(email, password1);
            request.setAttribute("user", user, WebRequest.SCOPE_SESSION);

            // Go to page dependent on role
            return "userpages/" + user.getRole();

        } else { // If passwords don't match, an exception is thrown
            throw new LoginSampleException("The two passwords did not match");
        }
    }

    @GetMapping("/secret")
    public String getSecretPage(WebRequest request) {
        // Retrieve user from session
        User user = (User) request.getAttribute("user",WebRequest.SCOPE_SESSION);

        // If user object is found on session,
        // i.e. user is logged in, she/he can see secretstuff page
        if (user != null) {
            return "userpages/secretstuff";
        }
        else
            return "redirect:/";
    }

    @ExceptionHandler(LoginSampleException.class)
    public String handleError(Model model, Exception exception) {
        model.addAttribute("message",exception.getMessage());
        return "exceptionPage";
    }
}