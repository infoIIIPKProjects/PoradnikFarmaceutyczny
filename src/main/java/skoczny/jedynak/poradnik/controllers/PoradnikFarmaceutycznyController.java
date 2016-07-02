package skoczny.jedynak.poradnik.controllers;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import skoczny.jedynak.poradnik.dataview.ChartDrawer;
import skoczny.jedynak.poradnik.model.*;
import skoczny.jedynak.poradnik.service.PoradnikFarmaceutycznyService;

import java.security.Principal;
import java.util.*;

@Controller
public class PoradnikFarmaceutycznyController {

    @Autowired(required = true)
    @Qualifier(value = "poradnikFarmaceutycznyService")
    private PoradnikFarmaceutycznyService service;

    public void setService(PoradnikFarmaceutycznyService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/user/delete-shopping-item{id}"}, method = RequestMethod.GET)
    public String deleteChoroba(@PathVariable String id) {
        service.removeChorobaByID(Integer.parseInt(id));
        return "redirect:/user/chorobaListPage.html";
    }

    @RequestMapping(value = {"/user/delete-lek{id}"}, method = RequestMethod.GET)
    public String deleteLek(@PathVariable String id) {
        service.removeLek(Integer.parseInt(id));
        return "redirect:/user/lekListPage.html";
    }

    @RequestMapping(value = "/user/lekListPage.html", method = RequestMethod.GET)
    public String getUserWelcomePage2(Model model, Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        model.addAttribute("user", user);
        model.addAttribute("leki", service.listLeki());
        return "lekListPage";
    }

    @RequestMapping(value = {"/user/edit-lek{id}"}, method = RequestMethod.GET)
    public String updateLek(@PathVariable String id, Model model, Principal principal) {
        Lek lek = service.getLekById(Integer.parseInt(id));

        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("lek", lek);
        model.addAttribute("lek_id", id);
        model.addAttribute("nazwa", lek.getLekName());
        model.addAttribute("cena", lek.getCena());
        model.addAttribute("dostepnosc", lek.isCzyDostepny());
        model.addAttribute("choroby", service.listLekiZchorobami().get(lek));
        model.addAttribute("user", user);

        return "editLekPage";
    }


    @RequestMapping(value = {"/user/editChorobaPage{id}"}, method = RequestMethod.GET)
    public String updateChoroba(@PathVariable String id, Model model, Principal principal) {
        Choroba choroba = service.getChorobaID(Integer.parseInt(id));

        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("choroba", choroba);
        model.addAttribute("choroba_id", id);
        model.addAttribute("nazwa", choroba.getNazwa());
        model.addAttribute("user", user);
        model.addAttribute("lek", service.listLeki());
        model.addAttribute("kategoriaChoroby", service.listCategories());
        model.addAttribute("opis", choroba.getDescription());

        return "editChorobaPage";
    }

    @RequestMapping(value = {"/admin/adminPage.html"}, method = RequestMethod.GET)
    public String updateUser(Model model, Principal principal) {
        User user = service.getUserByUserName(principal.getName());
        List<User> users = service.listUsers();
        List<String> roles = new ArrayList<String>();
        roles.addAll(LoginResultController.idRoles.keySet());
        model.addAttribute("users", users);
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "adminPage";
    }

    @RequestMapping(value = "/user/afterAddUser.html", method = RequestMethod.POST)
    public ModelAndView afterAddingUser(Principal principal,
                                        @RequestParam("role") String roleName,
                                        @RequestParam("user") String userName,
                                        @RequestParam(value = "updateOrDelete") String updateOrDelete) {
        User user = service.getUserByUserName(userName);
        if (updateOrDelete.equals("Update")) {
            Role role = user.getRole();
            role.setRoleName(roleName);
            role.setId(LoginResultController.idRoles.get(roleName));
            user.setRole(role);
            service.updateUserToDB(user);
        } else if (updateOrDelete.equals("Delete")) {
            service.removeUser(user);
        }
        return new ModelAndView("redirect:chorobaListPage.html");
    }

    @RequestMapping(value = "/user/afterEditingLek", method = RequestMethod.POST)
    public ModelAndView afterEditingLek(Principal principal,
                                        @RequestParam("nazwa") String nazwa,
                                        @RequestParam("lek_id") String lekId,
                                        @RequestParam("cena") String cena,
                                        @RequestParam("dostepnosc") String dostepnosc
    ) {
        Lek item = service.getLekById(Integer.parseInt(lekId));
        ModelAndView model;
        if (nazwa.isEmpty()) {
            model = new ModelAndView("editLekPage");
            model.addObject("error", "Nazwa leku jest pusta");
            model.addObject("lek_id", lekId);
        } else if ((!NumberUtils.isNumber(cena))) {
            model = new ModelAndView("editLekPage");
            model.addObject("lek_id", lekId);
            model.addObject("error", "Cena nie jest liczbą");
        } else {

            item.setLekName(nazwa.replace("<", "&lt;").replace(">", "&gt;"));
            item.setCena(Double.valueOf(cena));

            if (dostepnosc.equals("tak")) {
                item.setCzyDostepny(true);
            } else {
                item.setCzyDostepny(false);
            }
            service.updateLek(item);
            model = new ModelAndView("redirect:/user/lekListPage.html");
        }
        User user = service.getUserByUserName(principal.getName());
        model.addObject("user", user);
        model.addObject("lek", item);

        return model;
    }

    @RequestMapping(value = "/user/afterAddingLek", method = RequestMethod.POST)
    public ModelAndView afterAddingLek(Principal principal,
                                       @RequestParam("nazwa") String nazwa,
                                       @RequestParam("cena") String cena,
                                       @RequestParam("dostepnosc") String dostepnosc,
                                       @RequestParam("choroba") String chorobas_id
    ) {
        ModelAndView model;
        if (nazwa.isEmpty()) {
            model = new ModelAndView("addLekPage");
            model.addObject("error", "Nazwa leku jest pusta");
            model.addObject("choroba", service.listChoroba());
        } else if ((!NumberUtils.isNumber(cena))) {
            model = new ModelAndView("addLekPage");
            model.addObject("error", "Cena nie jest liczbą");
            model.addObject("choroba", service.listChoroba());
        } else {
            Lek item = new Lek();
            item.setLekName(nazwa.replace("<", "&lt;").replace(">", "&gt;"));
            item.setCena(Double.valueOf(cena));

            if (dostepnosc.equals("tak")) {
                item.setCzyDostepny(true);
            } else {
                item.setCzyDostepny(false);
            }

            Choroba choroba = service.getChorobaID(Integer.parseInt(chorobas_id));
            item.getChorobas().add(choroba);
            choroba.setLek(item);
            service.updateChorobaToDB(choroba);
            model = new ModelAndView("redirect:/user/lekListPage.html");
        }
        User user = service.getUserByUserName(principal.getName());
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/user/addChorobaPage.html", method = RequestMethod.GET)
    public String addChoroba(Model model, Principal principal) {
        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("nazwa", "");
        model.addAttribute("user", user);
        model.addAttribute("lek", service.listLeki());
        model.addAttribute("kategoriaChoroby", service.listCategories());
        model.addAttribute("opis", "");
        return "addChorobaPage";
    }


    @RequestMapping(value = "/user/addLekPage.html", method = RequestMethod.GET)
    public String addLek(Model model, Principal principal) {
        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("nazwa", "");
        model.addAttribute("cena", "");
        model.addAttribute("dostepnosc", "");
        model.addAttribute("choroba", service.listChoroba());
        return "addLekPage";
    }

    @RequestMapping(value = "/user/afterAddingChoroba.html", method = RequestMethod.POST)
    public ModelAndView afterAddingChoroba(Principal principal,
                                           @RequestParam("kategoriaChoroby") String kategoriaChorobyId,
                                           @RequestParam("lek") String lekId,
                                           @RequestParam("nazwa") String nazwa,
                                           @RequestParam("description") String description

    ) {
        Choroba item = new Choroba();
        item.setNazwa(nazwa.replace("<", "&lt;").replace(">", "&gt;"));

        KategoriaChoroby kategoriaChoroby = service.getKategoriaChorobyById(Integer.parseInt(kategoriaChorobyId));
        item.setKategoriaChoroby(kategoriaChoroby);

        Lek shop = service.getLekById(Integer.parseInt(lekId));
        item.setLek(shop);
        item.setDescription(description.replace("<", "&lt;").replace(">", "&gt;"));

        service.addChorobaToDB(item);
        ModelAndView model = new ModelAndView("redirect:chorobaListPage.html");
        return model;
    }

    @RequestMapping(value = "/user/afterEditingChoroba", method = RequestMethod.POST)
    public ModelAndView afterEditingChoroba(Principal principal,
                                            @RequestParam("kategoriaChoroby") String kategoriaChorobyId,
                                            @RequestParam("lek") String lekId,
                                            @RequestParam("description") String description,
                                            @RequestParam("choroba_id") String chorobaId,
                                            @RequestParam("nazwa") String nazwa
    ) {

        Choroba item = service.getChorobaID(Integer.parseInt(chorobaId));
        item.setNazwa(nazwa.replace("<", "&lt;").replace(">", "&gt;"));

        KategoriaChoroby kategoriaChoroby = service.getKategoriaChorobyById(Integer.parseInt(kategoriaChorobyId));
        item.setKategoriaChoroby(kategoriaChoroby);

        Lek lek = service.getLekById(Integer.parseInt(lekId));

        resolveNoDataChange(item, lek);

        item.setDescription(description.replace("<", "&lt;").replace(">", "&gt;"));

        service.updateChorobaToDB(item);

        ModelAndView model = new ModelAndView("redirect:chorobaListPage.html");
        return model;
    }

    private void resolveNoDataChange(Choroba item, Lek lek) {
        Set<String> names = new HashSet<String>();
        for (Choroba choroba : lek.getChorobas()) {
            names.add(choroba.getNazwa());
        }
        if (!names.contains(item.getNazwa())) {
            item.setLek(lek);
        }
    }

    @RequestMapping(value = "/user/viewReportPage{id}", method = RequestMethod.GET)
    public String viewUserReport(Model model, Principal principal) {
        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("user", user);

//        List<Choroba> kategoriaChorobies = service.listChoroba();
//        Map<String, Double> kategorieIlosc = prepareDataForKategorieChorob(kategoriaChorobies);
//        String kategorieObraz = ChartDrawer.createPieChartImageURIFromData(kategorieIlosc, "Choroby wedlug kategorii", true, false);

        List<Lek> leki = service.listLeki();
        Map<String, Double> dostepnoscLekow = prepareDataForDostepnoscLekow(leki);
        String dostepnoscObraz = ChartDrawer.createPieChartImageURIFromData(dostepnoscLekow, "Stan magazynu z lekami", true, true);

//        Map<Lek, List<Choroba>> listLekiZchorobami = service.listLekiZchorobami();
//        Map<String, Double> chorobyLeki = prepareDataForChorobyLeki(listLekiZchorobami);
//        String chorobyLekiObraz = ChartDrawer.createLineChartImageURIFromData(chorobyLeki, "Ilosc chorob na lek", "Leki", "Ilosc chorob");

        Map<String, Double> cenyLekow = prepareDataForCenyLekow(leki);
        String cenyLekowObraz = ChartDrawer.createBarChartImageURIFromData(cenyLekow, "Leki", "Nazwa", "Cena");

        //model.addAttribute("kategorieObraz", kategorieObraz);
        model.addAttribute("dostepnoscObraz", dostepnoscObraz);
        //model.addAttribute("chorobyLekiObraz", chorobyLekiObraz);
        model.addAttribute("cenyLekowObraz", cenyLekowObraz);
        return "viewReportPage";
    }

    private Map<String, Double> prepareDataForChorobyLeki(Map<Lek, List<Choroba>> listLekiZchorobami) {
        Map<String, Double> lekiChoroby = new HashMap<String, Double>();
        for (Map.Entry<Lek, List<Choroba>> entry : listLekiZchorobami.entrySet()) {
            lekiChoroby.put(entry.getKey().getLekName(), Double.valueOf(entry.getValue().size()));
        }
        return lekiChoroby;
    }

    private Map<String, Double> prepareDataForDostepnoscLekow(List<Lek> leki) {
        Map<String, Double> dostepnoscLekow = new HashMap<String, Double>();
        int counter = 0;
        int iloscLekow = leki.size();
        for (Lek lek : leki) {
            if (lek.isCzyDostepny()) {
                counter++;
            }
        }
        dostepnoscLekow.put("jest", (double) counter);
        dostepnoscLekow.put("brak", (double) (iloscLekow - counter));
        return dostepnoscLekow;
    }

    private Map<String, Double> prepareDataForKategorieChorob(List<Choroba> kategoriaChorobies) {
        Map<String, Double> kategorieIlosc = new HashMap<String, Double>();
        for (Choroba kategoriaChoroby : kategoriaChorobies) {
            String nazwa = kategoriaChoroby.getKategoriaChoroby().getKategoriaChorobyName();
            if (kategorieIlosc.containsKey(nazwa)) {
                Integer ilosc = kategorieIlosc.get(nazwa).intValue();
                ilosc++;
                kategorieIlosc.put(nazwa, ilosc.doubleValue());
            } else {
                kategorieIlosc.put(nazwa, 1d);
            }
        }
        return kategorieIlosc;
    }

    private Map<String, Double> prepareDataForCenyLekow(List<Lek> leki) {
        Map<String, Double> cenyLeki = new HashMap<String, Double>();
        for (Lek lek : leki) {
            cenyLeki.put(lek.getLekName(), lek.getCena());
        }
        return cenyLeki;
    }
}