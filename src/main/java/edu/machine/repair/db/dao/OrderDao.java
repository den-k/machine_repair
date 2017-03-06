package edu.machine.repair.db.dao;

import edu.machine.repair.db.entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class OrderDao {

    private SessionFactory sessionFactory;

    private CriteriaBuilder criteriaBuilder;

    @Autowired
    public OrderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        criteriaBuilder = sessionFactory.getCriteriaBuilder();
    }

    @Transactional
    public List<Order> list() {
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        criteriaQuery.from(Order.class);
        return sessionFactory.getCurrentSession()
                .createQuery(criteriaQuery)
                .list();
    }
}
