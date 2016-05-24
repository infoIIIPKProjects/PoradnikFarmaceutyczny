package skoczny.jedynak.poradnik.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import skoczny.jedynak.poradnik.model.Choroba;
import skoczny.jedynak.poradnik.model.Role;
import skoczny.jedynak.poradnik.model.User;
import skoczny.jedynak.poradnik.service.PoradnikFarmaceutycznyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginResultController {
    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";

    private static Map<String, Integer> idRoles = new HashMap<String, Integer>() {{
        put("lekarz", 1);
        put("aptekarz", 2);
        put("magazyn", 3);
        put("kierownictwo", 4);
        put("admin", 5);
    }};

    @Autowired(required = true)
    @Qualifier(value = "poradnikFarmaceutycznyService")
    private PoradnikFarmaceutycznyService service;

    public void setService(PoradnikFarmaceutycznyService service) {
        this.service = service;
    }

    @RequestMapping(value = "/admin/chorobaListPage.html", method = RequestMethod.GET)
    public ModelAndView getAdminWelcomePage(Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        ModelAndView model = new ModelAndView("adminWelcomePage");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user/chorobaListPage.html", method = RequestMethod.GET)
    public ModelAndView getUserWelcomePage(Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        List<Choroba> chorobaList = service.listChoroba();
        ModelAndView model = new ModelAndView("chorobaListPage");
        model.addObject("chorobaList", chorobaList);
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "registerPage.html", method = RequestMethod.GET)
    public ModelAndView getUserRegisterPage() {
        User userForm = new User();
        ModelAndView model = new ModelAndView("registerPage");
        model.addObject("userForm", userForm);
        return model;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView processRegistration(@ModelAttribute("userForm") User user, String errorValue) {
        ModelAndView model;
        boolean exists = service.isInSession(user.getName());
        if (!exists) {
            if (!user.getPassword().matches(PASSWORD_PATTERN)) {
                errorValue = "Hasło musi mieć co najmniej 6 znaków, 1 wielką litere, 1 małą literę i 1 cyfrę.";
                model = new ModelAndView("registerPage");
                model.addObject("error", errorValue);
            } else {
                Role role = new Role();
                role.setId(idRoles.get("lekarz"));
                user.setRole(role);
                service.addUserToDB(user);
                model = new ModelAndView("redirect:/");
            }
        } else {
            errorValue = "Użytkownik o takim loginie już istnieje.\n wybierz inną nazwę";
            model = new ModelAndView("registerPage");
            model.addObject("error", errorValue);
        }
        return model;
    }
}
