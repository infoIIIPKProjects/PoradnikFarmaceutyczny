package skoczny.jedynak.poradnik.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import skoczny.jedynak.poradnik.model.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DBLoader {
    private SessionFactory sessionFactory = SessionFactoryCreator.getSessionFactory();
    private Session session;

    private List<KategoriaChoroby> kategorie = new ArrayList<>();

    public void initDB() {
        session = sessionFactory.openSession();
        session.beginTransaction();


//===============  ROLE  ==============================
        Role admin = addRoleToDB("admin");

        Role user = addRoleToDB("user");
//===============  USER -> defaultUser ==============================
        User defaultUser = addUserToDB("user", "password", "default.user@gmail.com", new Date(), user);
//===============  LEK ==============================
        Lek aerius = addLekToDB(defaultUser, "Aerius", randomAvailability(), randomPrize());

        Lek acatarZatoki = addLekToDB(defaultUser, "Acatar Zatoki", randomAvailability(), randomPrize());

        Lek acidolac = addLekToDB(defaultUser, "Acidolac ", randomAvailability(), randomPrize());

        Lek albothyl = addLekToDB(defaultUser, "Albothyl ", randomAvailability(), randomPrize());

        Lek anafranil = addLekToDB(defaultUser, "Anafranil", randomAvailability(), randomPrize());

        Lek baikaderm = addLekToDB(defaultUser, "Baikaderm ", randomAvailability(), randomPrize());

        Lek baraclude = addLekToDB(defaultUser, "Baraclude", randomAvailability(), randomPrize());

        Lek bebilon = addLekToDB(defaultUser, "Bebilon ", randomAvailability(), randomPrize());

        Lek betadrin = addLekToDB(defaultUser, "Betadrin ", randomAvailability(), randomPrize());

        Lek biseptol = addLekToDB(defaultUser, "Biseptol", randomAvailability(), randomPrize());

        Lek cepastil = addLekToDB(defaultUser, "Cepastil ", randomAvailability(), randomPrize());

        Lek calcenato = addLekToDB(defaultUser, "Calcenato", randomAvailability(), randomPrize());

        Lek dicloabak = addLekToDB(defaultUser, "Dicloabak ", randomAvailability(), randomPrize());

        Lek daktarin = addLekToDB(defaultUser, "Daktarin", randomAvailability(), randomPrize());

        Lek grypolek = addLekToDB(defaultUser, "Grypolek ", randomAvailability(), randomPrize());

        Lek gaviscon = addLekToDB(defaultUser, "Gaviscon ", randomAvailability(), randomPrize());

        Lek fludara = addLekToDB(defaultUser, "Fludara", randomAvailability(), randomPrize());

        Lek fenistil = addLekToDB(defaultUser, "Fenistil ", randomAvailability(), randomPrize());

        Lek eprex = addLekToDB(defaultUser, "Eprex", randomAvailability(), randomPrize());

        Lek elobaza = addLekToDB(defaultUser, "Elo-baza ", randomAvailability(), randomPrize());

        Lek hascoderm = addLekToDB(defaultUser, "Hascoderm", randomAvailability(), randomPrize());

        Lek hydroskin = addLekToDB(defaultUser, "Hydroskin", randomAvailability(), randomPrize());

        Lek ibuprom = addLekToDB(defaultUser, "Ibuprom", randomAvailability(), randomPrize());

        Lek itragen = addLekToDB(defaultUser, "Itragen ", randomAvailability(), randomPrize());

        Lek javlor = addLekToDB(defaultUser, "Javlor ", randomAvailability(), randomPrize());

        Lek jovesto = addLekToDB(defaultUser, "Jovesto", randomAvailability(), randomPrize());

        Lek kamiren = addLekToDB(defaultUser, "Kamiren ", randomAvailability(), randomPrize());

        Lek klimicin = addLekToDB(defaultUser, "Klimicin", randomAvailability(), randomPrize());

        Lek laremid = addLekToDB(defaultUser, "Laremid", randomAvailability(), randomPrize());

        Lek logest = addLekToDB(defaultUser, "Logest ", randomAvailability(), randomPrize());

        Lek marbodin = addLekToDB(defaultUser, "Marbodin", randomAvailability(), randomPrize());

        Lek menopur = addLekToDB(defaultUser, "Menopur ", randomAvailability(), randomPrize());

        Lek nakom = addLekToDB(defaultUser, "Nakom", randomAvailability(), randomPrize());

        Lek nervosol = addLekToDB(defaultUser, "Nervosol", randomAvailability(), randomPrize());

        Lek oeparol = addLekToDB(defaultUser, "Oeparol", randomAvailability(), randomPrize());

        Lek optive = addLekToDB(defaultUser, "Optive ", randomAvailability(), randomPrize());

        Lek pentaglobin = addLekToDB(defaultUser, "Pentaglobin", randomAvailability(), randomPrize());

        Lek plavocorin = addLekToDB(defaultUser, "Plavocorin", randomAvailability(), randomPrize());

        Lek quatrum = addLekToDB(defaultUser, "Quatrum", randomAvailability(), randomPrize());

        Lek qumag = addLekToDB(defaultUser, "Qumag", randomAvailability(), randomPrize());

        Lek ramistad = addLekToDB(defaultUser, "Ramistad", randomAvailability(), randomPrize());

        Lek risperon = addLekToDB(defaultUser, "Risperon", randomAvailability(), randomPrize());

        Lek sclefic = addLekToDB(defaultUser, "Sclefic", randomAvailability(), randomPrize());

        Lek sulphera = addLekToDB(defaultUser, "Sulphera", randomAvailability(), randomPrize());

        Lek tacefur = addLekToDB(defaultUser, "Tacefur", randomAvailability(), randomPrize());

        Lek telmisartan = addLekToDB(defaultUser, "Telmisartan", randomAvailability(), randomPrize());

        Lek ulgix = addLekToDB(defaultUser, "Ulgix", randomAvailability(), randomPrize());

        Lek ursocam = addLekToDB(defaultUser, "Ursocam", randomAvailability(), randomPrize());

        Lek valsacor = addLekToDB(defaultUser, "Valsacor", randomAvailability(), randomPrize());

        Lek venomenhal = addLekToDB(defaultUser, "Venomenhal", randomAvailability(), randomPrize());

        Lek wegiel = addLekToDB(defaultUser, "Wegiel leczniczy", randomAvailability(), randomPrize());

        Lek wolarex = addLekToDB(defaultUser, "Wolarex", randomAvailability(), randomPrize());

        Lek xaloptic = addLekToDB(defaultUser, "Xaloptic Combi", randomAvailability(), randomPrize());

        Lek xylometazolin = addLekToDB(defaultUser, "Xylometazolin", randomAvailability(), randomPrize());

        Lek zajavit = addLekToDB(defaultUser, "Zajavit", randomAvailability(), randomPrize());

        Lek ziagen = addLekToDB(defaultUser, "Ziagen", randomAvailability(), randomPrize());

//===============  KATEGORIA CHOROBY ==============================

        KategoriaChoroby skory = addKategoriaChorobyToDB("Choroby skory?");
        kategorie.add(skory);
        KategoriaChoroby rzadkie = addKategoriaChorobyToDB("Rzadkie choroby?");
        kategorie.add(rzadkie);
        KategoriaChoroby reumatyczne = addKategoriaChorobyToDB("Choroby reumatyczne?");
        kategorie.add(reumatyczne);
        KategoriaChoroby psychosomatyczne = addKategoriaChorobyToDB("Choroby psychosomatyczne?");
        kategorie.add(psychosomatyczne);
        KategoriaChoroby pokarmowe = addKategoriaChorobyToDB("Choroby ukladu pokarmowego?");
        kategorie.add(pokarmowe);
        KategoriaChoroby oddechu = addKategoriaChorobyToDB("Choroby ukladu oddechowego");
        kategorie.add(oddechu);
        KategoriaChoroby nowotworowe = addKategoriaChorobyToDB("Choroby nowotworowe");
        kategorie.add(nowotworowe);
        KategoriaChoroby narzadowe = addKategoriaChorobyToDB("Niewydolnosc narzadowa?");
        kategorie.add(narzadowe);
        KategoriaChoroby nerwowe = addKategoriaChorobyToDB("Choroby ukladu nerwowego?");
        kategorie.add(nerwowe);
        KategoriaChoroby zmyslow = addKategoriaChorobyToDB("Choroby narzadow zmyslow");
        kategorie.add(zmyslow);
        KategoriaChoroby hematologiczne = addKategoriaChorobyToDB("Choroby hematologiczne");
        kategorie.add(hematologiczne);
        KategoriaChoroby genetyczne = addKategoriaChorobyToDB("Choroby genetyczne");
        kategorie.add(genetyczne);
        KategoriaChoroby cywilizacyjne = addKategoriaChorobyToDB("Choroby cywilizacyjne");
        kategorie.add(cywilizacyjne);
        KategoriaChoroby ruchu = addKategoriaChorobyToDB("Choroby ukladu ruchu?");
        kategorie.add(ruchu);
        KategoriaChoroby moczowe = addKategoriaChorobyToDB("Choroby ukladu moczowo-plciowego");
        kategorie.add(moczowe);
        KategoriaChoroby stanyNagle = addKategoriaChorobyToDB("Stany nagle w medycynie");
        kategorie.add(stanyNagle);
        KategoriaChoroby krazenia = addKategoriaChorobyToDB("Choroby ukladu krazenia?");
        kategorie.add(krazenia);
        KategoriaChoroby gospodarki = addKategoriaChorobyToDB("Zaburzenia gospodarki elektrolitowej");
        kategorie.add(gospodarki);
        KategoriaChoroby psychiczne = addKategoriaChorobyToDB("Zaburzenia psychiczne");
        kategorie.add(psychiczne);
        KategoriaChoroby rozwoju = addKategoriaChorobyToDB("Zaburzenia rozwoju");
        kategorie.add(rozwoju);
        KategoriaChoroby odpornosciowe = addKategoriaChorobyToDB("Zaburzenia ukladu odpornosciowego");
        kategorie.add(odpornosciowe);
        KategoriaChoroby metabolcizne = addKategoriaChorobyToDB("Zaburzenia wydzielania wewnetrznego");
        kategorie.add(metabolcizne);
        KategoriaChoroby zakazne = addKategoriaChorobyToDB("Choroby zakazne");
        kategorie.add(zakazne);
        KategoriaChoroby zapalenie = addKategoriaChorobyToDB("Zapalenia?");
        kategorie.add(zapalenie);
        KategoriaChoroby zawodowe = addKategoriaChorobyToDB("Choroby zawodowe");
        kategorie.add(zawodowe);
        KategoriaChoroby zespolowe = addKategoriaChorobyToDB("Zespoly chorobowe?");
        kategorie.add(zespolowe);
        KategoriaChoroby dekompresyjne = addKategoriaChorobyToDB("Choroba dekompresyjna");
        kategorie.add(dekompresyjne);
        KategoriaChoroby spoleczne = addKategoriaChorobyToDB("Choroby spoleczne");
        kategorie.add(spoleczne);
        KategoriaChoroby ukladowe = addKategoriaChorobyToDB("Choroby ukladowe");
        kategorie.add(ukladowe);
        KategoriaChoroby zwyrodnieniowe = addKategoriaChorobyToDB("Choroby zwyrodnieniowe");
        kategorie.add(zwyrodnieniowe);
//===============  CHOROBA  ==============================
        addChorobaToDB("Zapalenie ucha srodkowego", tacefur, randomCategory(), defaultUser, ChorobyOpisy.zapalenieUcha);
        addChorobaToDB("Zawal", tacefur, randomCategory(), defaultUser, ChorobyOpisy.zawal);
        addChorobaToDB("Wzdecia", ulgix, randomCategory(), defaultUser, ChorobyOpisy.wzdecia);
        addChorobaToDB("Pierwotna zolciowa marskosc watroby", ursocam, randomCategory(), defaultUser, ChorobyOpisy.marskosc);
        addChorobaToDB("Kaszel", ursocam, randomCategory(), defaultUser, ChorobyOpisy.kaszel);
        addChorobaToDB("Alergie", venomenhal, randomCategory(), defaultUser, ChorobyOpisy.alergie);
        addChorobaToDB("Problemy zoladkowe", wegiel, randomCategory(), defaultUser, ChorobyOpisy.problemyZoladkowe);
        addChorobaToDB("Niedoczynnosc tarczycy", wolarex, randomCategory(), defaultUser, ChorobyOpisy.niedoTarczycy);
        addChorobaToDB("Bol oka", venomenhal, randomCategory(), defaultUser, ChorobyOpisy.bolOka);
        addChorobaToDB("Zapalenie zatok przynosowych", xylometazolin, randomCategory(), defaultUser, ChorobyOpisy.zapalenieZatok);
        addChorobaToDB("Szkorbut", zajavit, randomCategory(), defaultUser, ChorobyOpisy.szkorbut);
        addChorobaToDB("HIV", ziagen, randomCategory(), defaultUser, ChorobyOpisy.hiv);
        addChorobaToDB("Parkinson", nakom, randomCategory(), defaultUser, ChorobyOpisy.parkinson);
        addChorobaToDB("Nerwica", nervosol, randomCategory(), defaultUser, ChorobyOpisy.nerwica);
        addChorobaToDB("Choroba serca", oeparol, randomCategory(), defaultUser, ChorobyOpisy.chorobaSrca);
        addChorobaToDB("Zespol suchego oka", optive, randomCategory(), defaultUser, ChorobyOpisy.sucheOko);
        addChorobaToDB("Zakazenia bakteryjne", pentaglobin, randomCategory(), defaultUser, ChorobyOpisy.zakazenieBakteryjne);
        addChorobaToDB("Miazdzyca", plavocorin, randomCategory(), defaultUser, ChorobyOpisy.maizdzyca);
        addChorobaToDB("Problemy zoladkowe", plavocorin, randomCategory(), defaultUser, ChorobyOpisy.problemyZoladkowe);
        addChorobaToDB("Problemy sercowo-naczyniowe", qumag, randomCategory(), defaultUser, ChorobyOpisy.chorobaSrca);
        addChorobaToDB("Cukrzyca", ramistad, randomCategory(), defaultUser, ChorobyOpisy.cukrzyca);
        addChorobaToDB("Schizofrenia", risperon, randomCategory(), defaultUser, ChorobyOpisy.schizofrenia);
        addChorobaToDB("Stwardnienie zanikowe boczne", sclefic, randomCategory(), defaultUser, ChorobyOpisy.stwardnienieBoczne);
        addChorobaToDB("Luszczyca", sulphera, randomCategory(), defaultUser, ChorobyOpisy.luszczyca);
        addChorobaToDB("Tradzik", hascoderm, randomCategory(), defaultUser, ChorobyOpisy.tradzi);
        addChorobaToDB("Sucha skora", hydroskin, randomCategory(), defaultUser, ChorobyOpisy.suchaSkora);
        addChorobaToDB("Bole wszelkiego rodzaju", ibuprom, randomCategory(), defaultUser, ChorobyOpisy.bole);
        addChorobaToDB("Grzybica skory", itragen, randomCategory(), defaultUser, ChorobyOpisy.grzybica);
        addChorobaToDB("Rak drog moczowych", javlor, randomCategory(), defaultUser, ChorobyOpisy.rakMocz);
        addChorobaToDB("Przerost gruczolu krokowego", jovesto, randomCategory(), defaultUser, ChorobyOpisy.przerostGr);
        addChorobaToDB("Bialaczka", kamiren, randomCategory(), defaultUser, ChorobyOpisy.bilaczka);
        addChorobaToDB("Zakazenia ukladu oddechowego", klimicin, randomCategory(), defaultUser, ChorobyOpisy.zakazenie);
        addChorobaToDB("Biegunka", laremid, randomCategory(), defaultUser, ChorobyOpisy.biegunka);
        addChorobaToDB("Antykoncepcja", logest, randomCategory(), defaultUser, ChorobyOpisy.anty);
        addChorobaToDB("Alzheimer", marbodin, randomCategory(), defaultUser, ChorobyOpisy.alzheimer);
        addChorobaToDB("Przeziebienie", cepastil, randomCategory(), defaultUser, ChorobyOpisy.przeziebienie);
        addChorobaToDB("Niedobor wapnia", calcenato, randomCategory(), defaultUser, ChorobyOpisy.niedoborWapnia);
        addChorobaToDB("Grzybica skory", dicloabak, randomCategory(), defaultUser, ChorobyOpisy.grzybicaSkory);
        addChorobaToDB("Grzybica skory", laremid, randomCategory(), defaultUser, ChorobyOpisy.grzybicaSkory);
        addChorobaToDB("Grypa", grypolek, randomCategory(), defaultUser, ChorobyOpisy.grypa);
        addChorobaToDB("Refluks zoladkowy", gaviscon, randomCategory(), defaultUser, ChorobyOpisy.refluks);
        addChorobaToDB("Bialaczka", fludara, randomCategory(), defaultUser, ChorobyOpisy.bialaczka);
        addChorobaToDB("Ukaszenie", fenistil, randomCategory(), defaultUser, ChorobyOpisy.ukaszenie);
        addChorobaToDB("Niewydolnosc nerek", eprex, randomCategory(), defaultUser, ChorobyOpisy.nerki);
        addChorobaToDB("Problemy skorne", elobaza, randomCategory(), defaultUser, ChorobyOpisy.skora);
        addChorobaToDB("Alergia blony sluzowej nosa", elobaza, randomCategory(), defaultUser, ChorobyOpisy.nosAlergia);
        addChorobaToDB("Katar", acatarZatoki, randomCategory(), defaultUser, ChorobyOpisy.katar);
        addChorobaToDB("Zaburzenia flory bakteryjnej", acidolac, randomCategory(), defaultUser, ChorobyOpisy.zaburzeniaFlory);
        addChorobaToDB("Zapalenie miejsc intymnych", albothyl, randomCategory(), defaultUser, ChorobyOpisy.zapalanieInt);
        addChorobaToDB("Depresja", anafranil, randomCategory(), defaultUser, ChorobyOpisy.depresja);
        addChorobaToDB("Zapalenie skory", elobaza, randomCategory(), defaultUser, ChorobyOpisy.zapalanie);
        addChorobaToDB("Zapalenie watroby", baraclude, randomCategory(), defaultUser, ChorobyOpisy.zapWatroby);
        addChorobaToDB("Niedobor witamin", bebilon, randomCategory(), defaultUser, ChorobyOpisy.wit);
        addChorobaToDB("Niezyt nosa", betadrin, randomCategory(), defaultUser, ChorobyOpisy.katar);
        addChorobaToDB("Zakazenie drog oddechowych", biseptol, randomCategory(), defaultUser, ChorobyOpisy.zakazenie);

        session.getTransaction().commit();
        session.close();
    }

    private void addChorobaToDB(String nazwa, Lek lek, KategoriaChoroby kategoriaChoroby, User user, String description) {
        Choroba choroba = new Choroba();
        choroba.setNazwa(nazwa);
        choroba.setUser(user);
        choroba.setLek(lek);
        choroba.setDescription(description);
        choroba.setKategoriaChoroby(kategoriaChoroby);
        session.save(choroba);
    }

    private Role addRoleToDB(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        session.save(role);

        return role;
    }

    private User addUserToDB(String userName, String password, String email, Date defaultReportDate, Role role) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDefaultReportDate(defaultReportDate);
        user.setRole(role);
        session.save(user);

        return user;
    }

    private KategoriaChoroby addKategoriaChorobyToDB(String categoryName) {
        KategoriaChoroby kategoriaChoroby = new KategoriaChoroby();
        kategoriaChoroby.setKategoriaChorobyName(categoryName);
        session.save(kategoriaChoroby);

        return kategoriaChoroby;
    }

    private Lek addLekToDB(User user, String lekName, boolean czyDostepny, double cena) {
        Lek lek = new Lek();
        lek.setUser(user);
        lek.setLekName(lekName);
        lek.setCena(cena);
        lek.setCzyDostepny(czyDostepny);
        session.save(lek);

        return lek;
    }

    private Double randomPrize() {
        return Double.valueOf(String.format(Locale.US, "%.2f", ThreadLocalRandom.current().nextDouble(0.1, 150.0)));
    }

    private boolean randomAvailability() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private KategoriaChoroby randomCategory() {
        Random random = new Random();
        return kategorie.get(random.nextInt(kategorie.size() - 1));
    }
}
