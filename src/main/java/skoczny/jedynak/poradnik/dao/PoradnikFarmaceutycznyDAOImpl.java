package skoczny.jedynak.poradnik.dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import skoczny.jedynak.poradnik.model.Choroba;
import skoczny.jedynak.poradnik.model.KategoriaChoroby;
import skoczny.jedynak.poradnik.model.Lek;
import skoczny.jedynak.poradnik.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PoradnikFarmaceutycznyDAOImpl implements PoradnikFarmaceutycznyDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addChorobaToDB(Choroba choroba) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(choroba);
    }

    @Override
    public void updateChorobaToDB(Choroba choroba) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(choroba);
    }

    @Override
    public User getUserByUserName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where name= :name ");
        query.setString("name", name);
        User user = (User) query.uniqueResult();

        user.getRole().toString();
        return user;
    }

    @Override
    public void addUserToDB(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUserToDB(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void addLek(Lek lek) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(lek);
    }

    @Override
    public void updateLek(Lek lek) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(lek);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Lek> listLeki() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lek> leki = session.createQuery("from lek ").list();
        leki.size();
        return leki;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<Lek, List<Choroba>> listLekiZchorobami() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Lek> leki = session.createQuery("from lek ").list();
        leki.size();
        Map<Lek, List<Choroba>> lekiChoroby = new HashMap<Lek, List<Choroba>>();
        for (Lek lek : leki) {
            List<Choroba> choroby = (List<Choroba>) lek.getChorobas();
            lekiChoroby.put(lek, choroby);
        }
        return lekiChoroby;
    }

    @Override
    public Lek getLekById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Lek lek = (Lek) session.load(Lek.class, new Integer(id));
        lek.getChorobas().size();
        return lek;
    }

    @Override
    public List<Choroba> listChoroba() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Choroba> chorobyList = session.createQuery("from choroba ").list();
        chorobyList.size();
        return chorobyList;
    }

    @Override
    public void removeLek(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Lek lek = (Lek) session.load(Lek.class, new Integer(id));
        if (null != lek) {
            session.delete(lek);
        }
    }

    @Override
    public List<KategoriaChoroby> listCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        List<KategoriaChoroby> categoriesList = session.createQuery("from kategoriachoroby ").list();
        categoriesList.size();
        return categoriesList;
    }

    public KategoriaChoroby getKategoriaChorobyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        KategoriaChoroby kategoriaChoroby = (KategoriaChoroby) session.load(KategoriaChoroby.class, new Integer(id));
        return kategoriaChoroby;
    }


    @Override
    public Choroba getChorobaByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        Choroba choroba = (Choroba) session.load(Choroba.class, new Integer(id));
        choroba.getLek().getChorobas().size();
        return choroba;
    }

    public void removeChorobaByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Choroba choroba = (Choroba) session.load(Choroba.class, new Integer(id));
        if (null != choroba) {
            session.delete(choroba);
        }
    }

    @Override
    @Transactional
    public void removeUser(User user){
        Session session = this.sessionFactory.getCurrentSession();
        User tempUser = (User) session.load(User.class, new Integer(user.getId()));
        if (null != tempUser) {
            session.delete(tempUser);
        }
    }

    @Override
    public boolean isInSession(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where name= :name ");
        query.setString("name", name);
        User user = (User) query.uniqueResult();
        return user != null;
    }

    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User ").list();
        users.size();
        return users;
    }
}