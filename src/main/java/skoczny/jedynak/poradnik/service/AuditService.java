package skoczny.jedynak.poradnik.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import skoczny.jedynak.poradnik.model.PageActivity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("auditService")
public class AuditService {
    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pageActivity");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Map<String, Integer> pagesVisits = new HashMap<String, Integer>();

    public void audit(String message) {
        entityManager.getTransaction().begin();
        if (pagesVisits.containsKey(message)) {
            pagesVisits.put(message, (pagesVisits.get(message)) + 1);
        } else {
            pagesVisits.put(message, 0);
        }
        PageActivity pageActivity = new PageActivity();
        pageActivity.setPageName(message);
        pageActivity.setDate(new Date());
        pageActivity.setCounter(pagesVisits.get(message));
        entityManager.persist(pageActivity);
        logger.info(pageActivity.toString());
        entityManager.getTransaction().commit();
    }
}