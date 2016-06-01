package skoczny.jedynak.poradnik.dao;

import skoczny.jedynak.poradnik.model.*;

import java.util.List;
import java.util.Map;

public interface PoradnikFarmaceutycznyDAO {
    void addLek(Lek p);

    void updateLek(Lek p);

    public Map<Lek, List<Choroba>> listLekiZchorobami();

    List<Lek> listLeki();

    Lek getLekById(int id);

    void removeLek(int id);

    void addChorobaToDB(Choroba choroba);

    public User getUserByUserName(String userName);

    List<KategoriaChoroby> listCategories();

    public Choroba getChorobaByID(int id);

    List<Choroba> listChoroba();

    void removeChorobaByID(int id);

    public KategoriaChoroby getKategoriaChorobyById(int id);

    void updateChorobaToDB(Choroba choroba);

    void addUserToDB(User user);

    boolean isInSession(String userName);

    List<User> listUsers();

    void updateUserToDB(User user);

    void removeUser(User user);
}

