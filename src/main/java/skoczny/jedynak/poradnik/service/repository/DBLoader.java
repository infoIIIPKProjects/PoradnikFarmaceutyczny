package skoczny.jedynak.poradnik.service.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import skoczny.jedynak.poradnik.model.*;
import skoczny.jedynak.poradnik.util.ChorobyOpisy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DBLoader {
    private SessionFactory sessionFactory = SessionFactoryCreator.getSessionFactory();
    private Session session;

    private List<KategoriaChoroby> kategorie = new ArrayList<>();

    public void initDB() {
        session = sessionFactory.openSession();
        session.beginTransaction();


//===============  ROLE  ==============================
        Role lekarz = addRoleToDB("lekarz");

        Role aptekarz = addRoleToDB("aptekarz");

        Role magazyn = addRoleToDB("magazyn");

        Role kierownictwo = addRoleToDB("kierownictwo");

        Role admin = addRoleToDB("admin");

        // Role user = addRoleToDB("user");
//===============  USER -> defaultUser ==============================
        User defaultUser = addUserToDB("admin", "Admin1", "default.user@gmail.com", admin);
//===============  LEK ==============================
        Lek aerius = addLekToDB("Aerius", randomAvailability(), randomPrize());
        Lek acatarZatoki = addLekToDB("Acatar Zatoki", randomAvailability(), randomPrize());
        Lek acidolac = addLekToDB("Acidolac ", randomAvailability(), randomPrize());
        Lek albothyl = addLekToDB("Albothyl ", randomAvailability(), randomPrize());
        Lek anafranil = addLekToDB("Anafranil", randomAvailability(), randomPrize());
        Lek baikaderm = addLekToDB("Baikaderm ", randomAvailability(), randomPrize());
        Lek baraclude = addLekToDB("Baraclude", randomAvailability(), randomPrize());
        Lek bebilon = addLekToDB("Bebilon ", randomAvailability(), randomPrize());
        Lek betadrin = addLekToDB("Betadrin ", randomAvailability(), randomPrize());
        Lek biseptol = addLekToDB("Biseptol", randomAvailability(), randomPrize());
        Lek cepastil = addLekToDB("Cepastil ", randomAvailability(), randomPrize());
        Lek calcenato = addLekToDB("Calcenato", randomAvailability(), randomPrize());
        Lek dicloabak = addLekToDB("Dicloabak ", randomAvailability(), randomPrize());
        Lek daktarin = addLekToDB("Daktarin", randomAvailability(), randomPrize());
        Lek grypolek = addLekToDB("Grypolek ", randomAvailability(), randomPrize());
        Lek gaviscon = addLekToDB("Gaviscon ", randomAvailability(), randomPrize());
        Lek fludara = addLekToDB("Fludara", randomAvailability(), randomPrize());
        Lek fenistil = addLekToDB("Fenistil ", randomAvailability(), randomPrize());
        Lek eprex = addLekToDB("Eprex", randomAvailability(), randomPrize());
        Lek elobaza = addLekToDB("Elo-baza ", randomAvailability(), randomPrize());
        Lek hascoderm = addLekToDB("Hascoderm", randomAvailability(), randomPrize());
        Lek hydroskin = addLekToDB("Hydroskin", randomAvailability(), randomPrize());
        Lek ibuprom = addLekToDB("Ibuprom", randomAvailability(), randomPrize());
        Lek itragen = addLekToDB("Itragen ", randomAvailability(), randomPrize());
        Lek javlor = addLekToDB("Javlor ", randomAvailability(), randomPrize());
        Lek jovesto = addLekToDB("Jovesto", randomAvailability(), randomPrize());
        Lek kamiren = addLekToDB("Kamiren ", randomAvailability(), randomPrize());
        Lek klimicin = addLekToDB("Klimicin", randomAvailability(), randomPrize());
        Lek laremid = addLekToDB("Laremid", randomAvailability(), randomPrize());
        Lek logest = addLekToDB("Logest ", randomAvailability(), randomPrize());
        Lek marbodin = addLekToDB("Marbodin", randomAvailability(), randomPrize());
        Lek menopur = addLekToDB("Menopur ", randomAvailability(), randomPrize());
        Lek nakom = addLekToDB("Nakom", randomAvailability(), randomPrize());
        Lek nervosol = addLekToDB("Nervosol", randomAvailability(), randomPrize());
        Lek oeparol = addLekToDB("Oeparol", randomAvailability(), randomPrize());
        Lek optive = addLekToDB("Optive ", randomAvailability(), randomPrize());
        Lek pentaglobin = addLekToDB("Pentaglobin", randomAvailability(), randomPrize());
        Lek plavocorin = addLekToDB("Plavocorin", randomAvailability(), randomPrize());
        Lek quatrum = addLekToDB("Quatrum", randomAvailability(), randomPrize());
        Lek qumag = addLekToDB("Qumag", randomAvailability(), randomPrize());
        Lek ramistad = addLekToDB("Ramistad", randomAvailability(), randomPrize());
        Lek risperon = addLekToDB("Risperon", randomAvailability(), randomPrize());
        Lek sclefic = addLekToDB("Sclefic", randomAvailability(), randomPrize());
        Lek sulphera = addLekToDB("Sulphera", randomAvailability(), randomPrize());
        Lek tacefur = addLekToDB("Tacefur", randomAvailability(), randomPrize());
        Lek telmisartan = addLekToDB("Telmisartan", randomAvailability(), randomPrize());
        Lek ulgix = addLekToDB("Ulgix", randomAvailability(), randomPrize());
        Lek ursocam = addLekToDB("Ursocam", randomAvailability(), randomPrize());
        Lek valsacor = addLekToDB("Valsacor", randomAvailability(), randomPrize());
        Lek venomenhal = addLekToDB("Venomenhal", randomAvailability(), randomPrize());
        Lek wegiel = addLekToDB("Wegiel leczniczy", randomAvailability(), randomPrize());
        Lek wolarex = addLekToDB("Wolarex", randomAvailability(), randomPrize());
        Lek xaloptic = addLekToDB("Xaloptic Combi", randomAvailability(), randomPrize());
        Lek xylometazolin = addLekToDB("Xylometazolin", randomAvailability(), randomPrize());
        Lek zajavit = addLekToDB("Zajavit", randomAvailability(), randomPrize());
        Lek ziagen = addLekToDB("Ziagen", randomAvailability(), randomPrize());

//===============  KATEGORIA CHOROBY ==============================

        // KategoriaChoroby skory = addKategoriaChorobyToDB("Choroby skory?");
        //kategorie.add(skory);
        KategoriaChoroby rzadkie = addKategoriaChorobyToDB("Rzadkie choroby?");
        kategorie.add(rzadkie);
        KategoriaChoroby reumatyczne = addKategoriaChorobyToDB("Choroby reumatyczne?");
        kategorie.add(reumatyczne);
        // KategoriaChoroby psychosomatyczne = addKategoriaChorobyToDB("Choroby psychosomatyczne?");
        //kategorie.add(psychosomatyczne);
        //KategoriaChoroby pokarmowe = addKategoriaChorobyToDB("Choroby ukladu pokarmowego?");
        //kategorie.add(pokarmowe);
        KategoriaChoroby oddechu = addKategoriaChorobyToDB("Choroby ukladu oddechowego");
        kategorie.add(oddechu);
        KategoriaChoroby nowotworowe = addKategoriaChorobyToDB("Choroby nowotworowe");
        kategorie.add(nowotworowe);
        //KategoriaChoroby narzadowe = addKategoriaChorobyToDB("Niewydolnosc narzadowa?");
        //kategorie.add(narzadowe);
        KategoriaChoroby nerwowe = addKategoriaChorobyToDB("Choroby ukladu nerwowego");
        kategorie.add(nerwowe);
        KategoriaChoroby zmyslow = addKategoriaChorobyToDB("Choroby narzadow zmyslow");
        kategorie.add(zmyslow);
        KategoriaChoroby hematologiczne = addKategoriaChorobyToDB("Choroby hematologiczne");
        kategorie.add(hematologiczne);
        KategoriaChoroby genetyczne = addKategoriaChorobyToDB("Choroby genetyczne");
        kategorie.add(genetyczne);
        KategoriaChoroby cywilizacyjne = addKategoriaChorobyToDB("Choroby cywilizacyjne");
        kategorie.add(cywilizacyjne);
        // KategoriaChoroby ruchu = addKategoriaChorobyToDB("Choroby ukladu ruchu");
        //kategorie.add(ruchu);
        KategoriaChoroby moczowe = addKategoriaChorobyToDB("Choroby ukladu moczowo-plciowego");
        kategorie.add(moczowe);
        KategoriaChoroby stanyNagle = addKategoriaChorobyToDB("Stany nagle w medycynie");
        kategorie.add(stanyNagle);
        KategoriaChoroby krazenia = addKategoriaChorobyToDB("Choroby ukladu krazenia");
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
        KategoriaChoroby zapalenie = addKategoriaChorobyToDB("Zapalenia");
        kategorie.add(zapalenie);
        //KategoriaChoroby zawodowe = addKategoriaChorobyToDB("Choroby zawodowe");
        //kategorie.add(zawodowe);
        // KategoriaChoroby zespolowe = addKategoriaChorobyToDB("Zespoly chorobowe?");
        //kategorie.add(zespolowe);
        //KategoriaChoroby dekompresyjne = addKategoriaChorobyToDB("Choroba dekompresyjna");
        //kategorie.add(dekompresyjne);
        KategoriaChoroby spoleczne = addKategoriaChorobyToDB("Choroby spoleczne");
        kategorie.add(spoleczne);
        KategoriaChoroby ukladowe = addKategoriaChorobyToDB("Choroby ukladowe");
        kategorie.add(ukladowe);
        KategoriaChoroby zwyrodnieniowe = addKategoriaChorobyToDB("Choroby zwyrodnieniowe");
        kategorie.add(zwyrodnieniowe);
//===============  CHOROBA  ==============================
        addChorobaToDB("Zapalenie ucha srodkowego", tacefur, randomCategory(), ChorobyOpisy.zapalenieUcha);
        addChorobaToDB("Zawal", tacefur, randomCategory(), ChorobyOpisy.zawal);
        addChorobaToDB("Wzdecia", ulgix, randomCategory(), ChorobyOpisy.wzdecia);
        addChorobaToDB("Pierwotna zolciowa marskosc watroby", ursocam, randomCategory(), ChorobyOpisy.marskosc);
        addChorobaToDB("Kaszel", ursocam, randomCategory(), ChorobyOpisy.kaszel);
        addChorobaToDB("Alergie", venomenhal, randomCategory(), ChorobyOpisy.alergie);
        addChorobaToDB("Problemy zoladkowe", wegiel, randomCategory(), ChorobyOpisy.problemyZoladkowe);
        addChorobaToDB("Niedoczynnosc tarczycy", wolarex, randomCategory(), ChorobyOpisy.niedoTarczycy);
        addChorobaToDB("Bol oka", venomenhal, randomCategory(), ChorobyOpisy.bolOka);
        addChorobaToDB("Zapalenie zatok przynosowych", xylometazolin, randomCategory(), ChorobyOpisy.zapalenieZatok);
        addChorobaToDB("Szkorbut", zajavit, randomCategory(), ChorobyOpisy.szkorbut);
        addChorobaToDB("HIV", ziagen, randomCategory(), ChorobyOpisy.hiv);
        addChorobaToDB("Parkinson", nakom, randomCategory(), ChorobyOpisy.parkinson);
        addChorobaToDB("Nerwica", nervosol, randomCategory(), ChorobyOpisy.nerwica);
        addChorobaToDB("Choroba serca", oeparol, randomCategory(), ChorobyOpisy.chorobaSrca);
        addChorobaToDB("Zespol suchego oka", optive, randomCategory(), ChorobyOpisy.sucheOko);
        addChorobaToDB("Zakazenia bakteryjne", pentaglobin, randomCategory(), ChorobyOpisy.zakazenieBakteryjne);
        addChorobaToDB("Miazdzyca", plavocorin, randomCategory(), ChorobyOpisy.maizdzyca);
        addChorobaToDB("Problemy zoladkowe", plavocorin, randomCategory(), ChorobyOpisy.problemyZoladkowe);
        addChorobaToDB("Problemy sercowo-naczyniowe", qumag, randomCategory(), ChorobyOpisy.chorobaSrca);
        addChorobaToDB("Cukrzyca", ramistad, randomCategory(), ChorobyOpisy.cukrzyca);
        addChorobaToDB("Schizofrenia", risperon, randomCategory(), ChorobyOpisy.schizofrenia);
        addChorobaToDB("Stwardnienie zanikowe boczne", sclefic, randomCategory(), ChorobyOpisy.stwardnienieBoczne);
        addChorobaToDB("Luszczyca", sulphera, randomCategory(), ChorobyOpisy.luszczyca);
        addChorobaToDB("Tradzik", hascoderm, randomCategory(), ChorobyOpisy.tradzi);
        addChorobaToDB("Sucha skora", hydroskin, randomCategory(), ChorobyOpisy.suchaSkora);
        addChorobaToDB("Bole wszelkiego rodzaju", ibuprom, randomCategory(), ChorobyOpisy.bole);
        addChorobaToDB("Grzybica skory", itragen, randomCategory(), ChorobyOpisy.grzybica);
        addChorobaToDB("Rak drog moczowych", javlor, randomCategory(), ChorobyOpisy.rakMocz);
        addChorobaToDB("Przerost gruczolu krokowego", jovesto, randomCategory(), ChorobyOpisy.przerostGr);
        addChorobaToDB("Bialaczka", kamiren, randomCategory(), ChorobyOpisy.bilaczka);
        addChorobaToDB("Zakazenia ukladu oddechowego", klimicin, randomCategory(), ChorobyOpisy.zakazenie);
        addChorobaToDB("Biegunka", laremid, randomCategory(), ChorobyOpisy.biegunka);
        addChorobaToDB("Antykoncepcja", logest, randomCategory(), ChorobyOpisy.anty);
        addChorobaToDB("Alzheimer", marbodin, randomCategory(), ChorobyOpisy.alzheimer);
        addChorobaToDB("Przeziebienie", cepastil, randomCategory(), ChorobyOpisy.przeziebienie);
        addChorobaToDB("Niedobor wapnia", calcenato, randomCategory(), ChorobyOpisy.niedoborWapnia);
        addChorobaToDB("Grzybica skory", dicloabak, randomCategory(), ChorobyOpisy.grzybicaSkory);
        addChorobaToDB("Grzybica skory", laremid, randomCategory(), ChorobyOpisy.grzybicaSkory);
        addChorobaToDB("Grypa", grypolek, randomCategory(), ChorobyOpisy.grypa);
        addChorobaToDB("Refluks zoladkowy", gaviscon, randomCategory(), ChorobyOpisy.refluks);
        addChorobaToDB("Bialaczka", fludara, randomCategory(), ChorobyOpisy.bialaczka);
        addChorobaToDB("Ukaszenie", fenistil, randomCategory(), ChorobyOpisy.ukaszenie);
        addChorobaToDB("Niewydolnosc nerek", eprex, randomCategory(), ChorobyOpisy.nerki);
        addChorobaToDB("Problemy skorne", elobaza, randomCategory(), ChorobyOpisy.skora);
        addChorobaToDB("Alergia blony sluzowej nosa", elobaza, randomCategory(), ChorobyOpisy.nosAlergia);
        addChorobaToDB("Katar", acatarZatoki, randomCategory(), ChorobyOpisy.katar);
        addChorobaToDB("Zaburzenia flory bakteryjnej", acidolac, randomCategory(), ChorobyOpisy.zaburzeniaFlory);
        addChorobaToDB("Zapalenie miejsc intymnych", albothyl, randomCategory(), ChorobyOpisy.zapalanieInt);
        addChorobaToDB("Depresja", anafranil, randomCategory(), ChorobyOpisy.depresja);
        addChorobaToDB("Zapalenie skory", elobaza, randomCategory(), ChorobyOpisy.zapalanie);
        addChorobaToDB("Zapalenie watroby", baraclude, randomCategory(), ChorobyOpisy.zapWatroby);
        addChorobaToDB("Niedobor witamin", bebilon, randomCategory(), ChorobyOpisy.wit);
        addChorobaToDB("Niezyt nosa", betadrin, randomCategory(), ChorobyOpisy.katar);
        addChorobaToDB("Zakazenie drog oddechowych", biseptol, randomCategory(), ChorobyOpisy.zakazenie);

        session.getTransaction().commit();
        session.close();
    }

    private void addChorobaToDB(String nazwa, Lek lek, KategoriaChoroby kategoriaChoroby, String description) {
        Choroba choroba = new Choroba();
        choroba.setNazwa(nazwa);
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

    private User addUserToDB(String userName, String password, String email, Role role) {
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
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

    private Lek addLekToDB(String lekName, boolean czyDostepny, double cena) {
        Lek lek = new Lek();
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
