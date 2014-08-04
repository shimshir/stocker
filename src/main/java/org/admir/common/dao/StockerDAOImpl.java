package org.admir.common.dao;

import org.admir.company.employee.model.Employee;
import org.admir.company.model.Company;
import org.admir.company.stock.model.Stock;
import org.admir.security.model.DbUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by memicadm on 19.05.2014.
 */
public class StockerDAOImpl implements StockerDAO {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;
    protected Session currentSession;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        if (currentSession == null || !currentSession.isOpen()) {
            currentSession = sessionFactory.openSession();
        }
        return currentSession;
    }

    @Override
    public <T> void delete(T object) {
        Transaction tx = getSession().beginTransaction();
        try {
            getSession().delete(object);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            getSession().close();
        }
    }

    @Override
    public <T> void update(T object) {
        Transaction tx = getSession().beginTransaction();
        try {
            getSession().update(object);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            getSession().close();
        }
    }

    @Override
    public <T> void save(T object) {
        Transaction tx = getSession().beginTransaction();
        try {
            getSession().save(object);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            getSession().close();
        }
    }

    @Override
    public Company findByCompanyCode(String companyCode) {
        Query query = getSession().createQuery("from Company where companyCode = :code");
        List list = query.setParameter("code", companyCode).list();
        return (Company) list.get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Company> getCompanies() {
        return getSession().createQuery("from Company").list();
    }

    @Override
    public Employee findByLastName(String lastName) {
        Query query = getSession().createQuery("from Employee where lastName = :lastName");
        List list = query.setParameter("lastName", lastName).list();
        return (Employee) list.get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployees() {
        return getSession().createQuery("from Employee").list();
    }

    @Override
    public Stock findByStockCode(String stockCode) {
        Query query = getSession().createQuery("from Stock where stockCode = :code");
        List list = query.setParameter("code", stockCode).list();
        return (Stock) list.get(0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Stock> getStocks() {
        return getSession().createQuery("from Stock").list();
    }

    @Override
    public DbUser getUserByUsername(String username) {
        Query query = getSession().createQuery("from DbUser where username = :username");
        List list = query.setParameter("username", username).list();
        return (DbUser) list.get(0);
    }
}
