package skoczny.jedynak.poradnik.service;

import skoczny.jedynak.poradnik.dao.PoradnikFarmaceutycznyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skoczny.jedynak.poradnik.model.*;

import java.util.List;
import java.util.Map;

@Service
public class PoradnikFarmaceutycznyServiceImpl implements PoradnikFarmaceutycznyService {
    @Autowired
    private PoradnikFarmaceutycznyDAO poradnikFarmaceutycznyDAOMySQL;

    @Autowired
    private PoradnikFarmaceutycznyDAO poradnikFarmaceutycznyDAOMSSQL;

    public void setPoradnikFarmaceutycznyDAOMSSQL(PoradnikFarmaceutycznyDAO poradnikFarmaceutycznyDAOMSSQL) {
        this.poradnikFarmaceutycznyDAOMSSQL = poradnikFarmaceutycznyDAOMSSQL;
    }

    public void setPoradnikFarmaceutycznyDAOMySQL(PoradnikFarmaceutycznyDAO poradnikFarmaceutycznyDAOMySQL) {
        this.poradnikFarmaceutycznyDAOMySQL = poradnikFarmaceutycznyDAOMySQL;
    }

    @Override
    @Transactional
    public void updateChorobaToDB(Choroba choroba) {
        poradnikFarmaceutycznyDAOMSSQL.updateChorobaToDB(choroba);
    }

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        return poradnikFarmaceutycznyDAOMySQL.getUserByUserName(userName);
    }

    @Override
    @Transactional
    public void addChorobaToDB(Choroba choroba) {
        poradnikFarmaceutycznyDAOMSSQL.addChorobaToDB(choroba);
    }

    @Override
    @Transactional
    public void addUserToDB(User user) {
        poradnikFarmaceutycznyDAOMySQL.addUserToDB(user);
    }

    @Override
    @Transactional
    public boolean isInSession(String userName) {
        return poradnikFarmaceutycznyDAOMySQL.isInSession(userName);
    }

    @Override
    @Transactional
    public void addLek(Lek lek) {
        this.poradnikFarmaceutycznyDAOMSSQL.addLek(lek);
    }

    @Override
    @Transactional
    public void updateLek(Lek lek) {
        this.poradnikFarmaceutycznyDAOMSSQL.updateLek(lek);
    }

    @Override
    @Transactional
    public List<KategoriaChoroby> listCategories() {
        return this.poradnikFarmaceutycznyDAOMSSQL.listCategories();
    }

    @Override
    @Transactional
    public KategoriaChoroby getKategoriaChorobyById(int id) {
        return this.poradnikFarmaceutycznyDAOMSSQL.getKategoriaChorobyById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Lek> listLeki() {
        return this.poradnikFarmaceutycznyDAOMSSQL.listLeki();
    }

    @Override
    @Transactional
    public Map<Lek, List<Choroba>> listLekiZchorobami() {
        return this.poradnikFarmaceutycznyDAOMSSQL.listLekiZchorobami();
    }

    @Override
    @Transactional
    public Lek getLekById(int id) {
        return this.poradnikFarmaceutycznyDAOMSSQL.getLekById(id);
    }

    @Override
    @Transactional
    public void removeLek(int id) {
        this.poradnikFarmaceutycznyDAOMSSQL.removeLek(id);
    }

    @Override
    @Transactional
    public Choroba getChorobaID(int id) {
        return poradnikFarmaceutycznyDAOMSSQL.getChorobaByID(id);
    }

    @Override
    @Transactional
    public List<Choroba> listChoroba() {
        return poradnikFarmaceutycznyDAOMSSQL.listChoroba();
    }

    @Override
    @Transactional
    public void removeChorobaByID(int id) {
        poradnikFarmaceutycznyDAOMSSQL.removeChorobaByID(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return poradnikFarmaceutycznyDAOMySQL.listUsers();
    }

    @Override
    @Transactional
    public void updateUserToDB(User user) {
        poradnikFarmaceutycznyDAOMySQL.updateUserToDB(user);
    }

    @Override
    @Transactional
    public void removeUser(User user){
        poradnikFarmaceutycznyDAOMySQL.removeUser(user);
    }
}