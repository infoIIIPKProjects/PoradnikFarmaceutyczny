package skoczny.jedynak.poradnik.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
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
import java.util.List;
import java.util.Map;

@Controller
public class LoginResultController {
    @Autowired(required = true)
    @Qualifier(value = "poradnikFarmaceutycznyService")
    private PoradnikFarmaceutycznyService service;

    public void setService(PoradnikFarmaceutycznyService service) {
        this.service = service;
    }

    @RequestMapping(value = "/admin/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView getAdminWelcomePage(Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        ModelAndView model = new ModelAndView("adminWelcomePage");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user/welcomePage.html", method = RequestMethod.GET)
    public ModelAndView getUserWelcomePage(Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        List<Choroba> chorobaList = service.listChoroba();
        ModelAndView model = new ModelAndView("userWelcomePage");
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

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String processRegistration(@ModelAttribute("userForm") User user) {
        Role role = new Role();
        role.setId(2);
        user.setRole(role);
//        List<Choroba> chorobaList = service.listChoroba();
//        for (Choroba choroba : chorobaList) {
//            choroba.setUser(user);
//        }
//        user.setChorobas(chorobaList);
        service.addUserToDB(user);
        return "mainPage";
    }
}
