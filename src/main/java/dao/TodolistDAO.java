package dao;

import entity.Todolist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marisha on 30/10/16.
 */

@Repository
public class TodolistDAO {

    @PersistenceContext(name = "todolist")
    private EntityManager entityManager;


    public List<Todolist> find (Boolean predicate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Todolist> cq = cb.createQuery(Todolist.class);
        Root<Todolist> from = cq.from(Todolist.class);
        cq = cq.select(from);
        if (predicate != null) {
            Predicate predicate1 = cb.equal(from.get("done"), predicate);
            cq.where(predicate1);
        }
        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public Todolist save(Todolist todolist) {
        entityManager.persist( todolist );
        return todolist;
    }
}
