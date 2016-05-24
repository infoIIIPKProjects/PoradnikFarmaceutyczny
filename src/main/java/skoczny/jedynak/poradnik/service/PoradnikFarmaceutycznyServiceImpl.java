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
    private PoradnikFarmaceutycznyDAO poradnikFarmaceutycznyDAO;

    public void setPoradnikFarmaceutycznyDAO(PoradnikFarmaceutycznyDAO poradnikFarmaceutycznyDAO) {
        this.poradnikFarmaceutycznyDAO = poradnikFarmaceutycznyDAO;
    }

    @Override
    @Transactional
    public void updateChorobaToDB(Choroba choroba) {
        poradnikFarmaceutycznyDAO.updateChorobaToDB(choroba);
    }

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        return poradnikFarmaceutycznyDAO.getUserByUserName(userName);
    }

    @Override
    @Transactional
    public void addChorobaToDB(Choroba choroba) {
        poradnikFarmaceutycznyDAO.addChorobaToDB(choroba);
    }

    @Override
    @Transactional
    public void addUserToDB(User user) {
        poradnikFarmaceutycznyDAO.addUserToDB(user);
    }

    @Override
    @Transactional
    public boolean isInSession(String userName) {
        return poradnikFarmaceutycznyDAO.isInSession(userName);
    }

    @Override
    @Transactional
    public void addLek(Lek lek) {
        this.poradnikFarmaceutycznyDAO.addLek(lek);
    }

    @Override
    @Transactional
    public void updateLek(Lek lek) {
        this.poradnikFarmaceutycznyDAO.updateLek(lek);
    }

    @Override
    @Transactional
    public List<KategoriaChoroby> listCategories() {
        return this.poradnikFarmaceutycznyDAO.listCategories();
    }

    @Override
    @Transactional
    public KategoriaChoroby getKategoriaChorobyById(int id) {
        return this.poradnikFarmaceutycznyDAO.getKategoriaChorobyById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Lek> listLeki() {
        return this.poradnikFarmaceutycznyDAO.listLeki();
    }

    @Override
    @Transactional
    public Map<Lek, List<Choroba>> listLekiZchorobami() {
        return this.poradnikFarmaceutycznyDAO.listLekiZchorobami();
    }

    @Override
    @Transactional
    public Lek getLekById(int id) {
        return this.poradnikFarmaceutycznyDAO.getLekById(id);
    }

    @Override
    @Transactional
    public void removeLek(int id) {
        this.poradnikFarmaceutycznyDAO.removeLek(id);
    }

    @Override
    @Transactional
    public Choroba getChorobaID(int id) {
        return poradnikFarmaceutycznyDAO.getChorobaByID(id);
    }

    @Override
    @Transactional
    public List<Choroba> listChoroba() {
        return poradnikFarmaceutycznyDAO.listChoroba();
    }

    @Override
    @Transactional
    public void removeChorobaByID(int id) {
        poradnikFarmaceutycznyDAO.removeChorobaByID(id);
    }

    @Override
    @Transactional
    public List<Object[]> getUserKategoriaChorobyByDate(int id, String fromDate, String toDate) {
        return poradnikFarmaceutycznyDAO.getUserKategoriaChorobyByDate(id, fromDate, toDate);
    }
}