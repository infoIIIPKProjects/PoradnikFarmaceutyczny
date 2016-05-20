package skoczny.jedynak.poradnik.dao;

import skoczny.jedynak.poradnik.comparators.ChorobaComparator;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import skoczny.jedynak.poradnik.model.*;

import java.util.Collections;
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
    public List<Object[]> getUserKategoriaChorobyByDate(int id, String fromDate, String toDate) {
        Session session = this.sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("select kategoriaChoroby.name, sum(choroba.amount) from kategoriaChoroby inner join " +
                "choroba on kategoriaChoroby.id = choroba.kategoriaChoroby_id " +
                "where user_id=" + id + " and date(choroba.date) between '2000-01-01' and '2020-01-01' group by kategoriaChoroby.id");
        List<Object[]> categories = query.list();
        return categories;
    }

    @Override
    public boolean isInSession(Choroba choroba){
        Session session = this.sessionFactory.getCurrentSession();
        return session.contains(choroba.getId());
    }
}