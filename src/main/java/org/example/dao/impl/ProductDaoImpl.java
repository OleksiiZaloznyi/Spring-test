package org.example.dao.impl;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't save product to DB");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }
//
//    @Override
//    public Product get(Long id) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            return session.get(Product.class, id);
//        }
//    }
//
//    @Override
//    public Product remove(Product product) {
//        return null;
//    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> getAllProductsQuery = session.createQuery(
                    "from Product", Product.class);
            return getAllProductsQuery.getResultList();
        }
    }

}
