package edu.machine.repair.db.dao;

import edu.machine.repair.db.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class UserDao {

    private SessionFactory sessionFactory;

    private CriteriaBuilder criteriaBuilder;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        criteriaBuilder = sessionFactory.getCriteriaBuilder();
    }

    @Transactional
    public List<User> list() {
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        criteriaQuery.from(User.class);
        return sessionFactory.getCurrentSession()
                .createQuery(criteriaQuery)
                .list();
    }
}
