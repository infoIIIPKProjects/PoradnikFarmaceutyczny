package skoczny.jedynak.poradnik.service;

import skoczny.jedynak.poradnik.model.Choroba;
import skoczny.jedynak.poradnik.model.KategoriaChoroby;
import skoczny.jedynak.poradnik.model.Lek;
import skoczny.jedynak.poradnik.model.User;

import java.util.List;
import java.util.Map;

public interface PoradnikFarmaceutycznyService {
    void addChorobaToDB(Choroba choroba);

    public User getUserByUserName(String userName);

    void addLek(Lek p);

    void updateLek(Lek p);

    List<KategoriaChoroby> listCategories();

    KategoriaChoroby getKategoriaChorobyById(int id);

    List<Lek> listLeki();

    List<Choroba> listChoroba();

     Map<Lek, List<Choroba>> listLekiZchorobami();

    Lek getLekById(int id);

    void removeLek(int id);

    public Choroba getChorobaID(int id);

    void removeChorobaByID(int id);

    void updateChorobaToDB(Choroba choroba);

    void addUserToDB(User user);

    boolean isInSession(String userName);

    List<User> listUsers();
    void updateUserToDB(User user);

    void removeUser(User user);
}
