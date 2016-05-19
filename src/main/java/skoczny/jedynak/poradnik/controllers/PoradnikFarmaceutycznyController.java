package skoczny.jedynak.poradnik.controllers;

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
import skoczny.jedynak.poradnik.model.Choroba;
import skoczny.jedynak.poradnik.model.KategoriaChoroby;
import skoczny.jedynak.poradnik.model.Lek;
import skoczny.jedynak.poradnik.model.User;
import skoczny.jedynak.poradnik.service.PoradnikFarmaceutycznyService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return "redirect:/user/welcomePage.html";
    }

    @RequestMapping(value = {"/user/delete-lek{id}"}, method = RequestMethod.GET)
    public String deleteLek(@PathVariable String id) {
        service.removeLek(Integer.parseInt(id));
        return "redirect:/user/userWelcomePage2.html";
    }

    @RequestMapping(value = "/user/userWelcomePage2.html", method = RequestMethod.GET)
    public String getUserWelcomePage2(Model model, Principal principal) {
        String userName = principal.getName();
        User user = service.getUserByUserName(userName);
        model.addAttribute("user", user);
        model.addAttribute("leki", service.listLeki());
        return "userWelcomePage2";
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

        return "editlek";
    }

    @RequestMapping(value = {"/user/editchoroba{id}"}, method = RequestMethod.GET)
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

        return "editchoroba";
    }

    @RequestMapping(value = "/user/aftereditingLek", method = RequestMethod.POST)
    public ModelAndView afterEditingLek(Principal principal,
                                        @RequestParam("nazwa") String nazwa,
                                        @RequestParam("lek_id") String lekId,
                                        @RequestParam("cena") String cena,
                                        @RequestParam("dostepnosc") String dostepnosc
    ) {
        Lek item = service.getLekById(Integer.parseInt(lekId));
        // service.removeChorobaByID(Integer.parseInt(id));
        // user
        item.setUser(service.getUserByUserName(principal.getName()));

        // nazwa
        item.setLekName(nazwa);

        // cena
        item.setCena(Double.valueOf(cena));

        if (dostepnosc.equals("tak")) {
            item.setCzyDostepny(true);
        } else {
            item.setCzyDostepny(false);
        }

        service.updateLek(item);

        ModelAndView model = new ModelAndView("redirect:/user/userWelcomePage2.html");

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

    @RequestMapping(value = "/user/addlek.html", method = RequestMethod.GET)
    public String addLek(Model model, Principal principal) {

        User user = service.getUserByUserName(principal.getName());
        model.addAttribute("nazwa", "");
        model.addAttribute("cena", "");
        model.addAttribute("dostepnosc", "");
        model.addAttribute("choroba", service.listChoroba());
        model.addAttribute("user", user);

        return "addlek";
    }


    @RequestMapping(value = "/user/afteraddingItem.html", method = RequestMethod.POST)
    public ModelAndView afterAddingChoroba(Principal principal,
                                           @RequestParam("kategoriaChoroby") String kategoriaChorobyId,
                                           @RequestParam("lek") String lekId,
                                           @RequestParam("nazwa") String nazwa,
                                           @RequestParam("description") String description

    ) {
        Choroba item = new Choroba();
        // service.removeChorobaByID(Integer.parseInt(id));
        // user
        item.setUser(service.getUserByUserName(principal.getName()));

        // nazwa
        item.setNazwa(nazwa);

        // kategoria
        KategoriaChoroby kategoriaChoroby = service.getKategoriaChorobyById(Integer.parseInt(kategoriaChorobyId));
        item.setKategoriaChoroby(kategoriaChoroby);

        // lek
        Lek shop = service.getLekById(Integer.parseInt(lekId));
        item.setLek(shop);

        // description
        item.setDescription(description);

        service.addChorobaToDB(item);

        ModelAndView model = new ModelAndView("redirect:welcomePage.html");

        return model;
    }

    @RequestMapping(value = "/user/afteraddingLek", method = RequestMethod.POST)
    public ModelAndView afterAddingLek(Principal principal,
                                       @RequestParam("nazwa") String nazwa,
                                       @RequestParam("cena") String cena,
                                       @RequestParam("dostepnosc") String dostepnosc,
                                       @RequestParam("choroba") String chorobas_id
    ) {
        Lek item = new Lek();
        // service.removeChorobaByID(Integer.parseInt(id));
        // user
        item.setUser(service.getUserByUserName(principal.getName()));

        // nazwa
        item.setLekName(nazwa);

        // cena
        item.setCena(Double.valueOf(cena));

        // dostepnosc
        if (dostepnosc.equals("tak")) {
            item.setCzyDostepny(true);
        } else {
            item.setCzyDostepny(false);
        }

        Choroba choroba = service.getChorobaID(Integer.parseInt(chorobas_id));
        item.getChorobas().add(choroba);

        //service.addLek(item);
        choroba.setLek(item);
        service.updateChorobaToDB(choroba);

        ModelAndView model = new ModelAndView("redirect:/user/userWelcomePage2.html");

        return model;
    }

    @RequestMapping(value = "/user/aftereditingItem", method = RequestMethod.POST)
    public ModelAndView afterEditingChoroba(Principal principal,
                                            @RequestParam("kategoriaChoroby") String kategoriaChorobyId,
                                            @RequestParam("lek") String lekId,
                                            @RequestParam("description") String description,
                                            @RequestParam("choroba_id") String chorobaId,
                                            @RequestParam("nazwa") String nazwa
    ) {
        Choroba item = service.getChorobaID(Integer.parseInt(chorobaId));
        // service.removeChorobaByID(Integer.parseInt(id));
        // user
        item.setUser(service.getUserByUserName(principal.getName()));

        // nazwa
        item.setNazwa(nazwa);

        // kategoria
        KategoriaChoroby kategoriaChoroby = service.getKategoriaChorobyById(Integer.parseInt(kategoriaChorobyId));
        item.setKategoriaChoroby(kategoriaChoroby);

        // lek
        Lek lek = service.getLekById(Integer.parseInt(lekId));
        item.setLek(lek);

        // description
        item.setDescription(description);

        service.updateChorobaToDB(item);

        ModelAndView model = new ModelAndView("redirect:welcomePage.html");

        return model;
    }

    @RequestMapping(value = "/user/viewreport{id}", method = RequestMethod.GET)
    public String viewUserReport(Model model) {

        List<Choroba> kategoriaChorobies = service.listChoroba();
        Map<String, Double> kategorieIlosc = prepareDataForKategorieChorob(kategoriaChorobies);
        String kategorieObraz = ChartDrawer.createPieChartImageURIFromData(kategorieIlosc, "Choroby wedlug kategorii", true, false);

        List<Lek> leki = service.listLeki();
        Map<String, Double> dostepnoscLekow = prepareDataForDostepnoscLekow(leki);
        String dostepnoscObraz = ChartDrawer.createPieChartImageURIFromData(dostepnoscLekow, "Dostepnosc lekow", true, true);

        Map<Lek, List<Choroba>> listLekiZchorobami = service.listLekiZchorobami();
        Map<String, Double> chorobyLeki = prepareDataForChorobyLeki(listLekiZchorobami);
        String chorobyLekiObraz = ChartDrawer.createLineChartImageURIFromData(chorobyLeki, "Ilosc chorob na lek", "Leki", "Ilosc chorob");

        Map<String, Double> cenyLekow = prepareDataForCenyLekow(leki);
        String cenyLekowObraz = ChartDrawer.createBarChartImageURIFromData(cenyLekow, "Ceny lekow", "Nazwa", "Cena");

        model.addAttribute("kategorieObraz", kategorieObraz);
        model.addAttribute("dostepnoscObraz", dostepnoscObraz);
        model.addAttribute("chorobyLekiObraz", chorobyLekiObraz);
        model.addAttribute("cenyLekowObraz", cenyLekowObraz);
        return "viewreport";
    }

    private Map<String, Double> prepareDataForChorobyLeki(Map<Lek, List<Choroba>> listLekiZchorobami) {
        Map<String, Double> lekiChoroby = new HashMap<>();
        for (Map.Entry<Lek, List<Choroba>> entry : listLekiZchorobami.entrySet()) {
            lekiChoroby.put(entry.getKey().getLekName(), Double.valueOf(entry.getValue().size()));
        }
        return lekiChoroby;
    }

    private Map<String, Double> prepareDataForDostepnoscLekow(List<Lek> leki) {
        Map<String, Double> dostepnoscLekow = new HashMap<>();
        int counter = 0;
        int iloscLekow = leki.size();
        for (Lek lek : leki) {
            if (lek.isCzyDostepny()) {
                counter++;
            }
        }

        dostepnoscLekow.put("dostepne", (double) counter);
        dostepnoscLekow.put("nie dostepne", (double) (iloscLekow - counter));
        return dostepnoscLekow;
    }

    private Map<String, Double> prepareDataForKategorieChorob(List<Choroba> kategoriaChorobies) {
        Map<String, Double> kategorieIlosc = new HashMap<>();
        for (int i = 0; i < kategoriaChorobies.size(); i++) {
            String nazwa = kategoriaChorobies.get(i).getKategoriaChoroby().getKategoriaChorobyName();
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
        Map<String, Double> cenyLeki = new HashMap<>();
        for (Lek lek : leki) {
            cenyLeki.put(lek.getLekName(), lek.getCena());
        }
        return cenyLeki;
    }
}