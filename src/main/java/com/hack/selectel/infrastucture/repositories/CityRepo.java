package com.hack.selectel.infrastucture.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hack.selectel.core.models.City;
import com.hack.selectel.core.repositories.ICityRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class CityRepo implements ICityRepo
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean CreateCity(City city)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.persist(city);
            transaction.commit();
        }
        catch(HibernateException e)
        {
            transaction.rollback();
            session.close();
            return false;
        }
        catch(Exception e)
        {
            transaction.rollback();
            session.close();
            throw e;
        }

        session.close();
        return true;
    }

    @Override
    public boolean UpdateCity(City city) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.merge(city);
            transaction.commit();
        }
        catch(HibernateException e)
        {
            transaction.rollback();
            session.close();
            return false;
        }
        catch(Exception e)
        {
            transaction.rollback();
            session.close();
            throw e;
        }

        session.close();
        return true;
    }

    @Override
    public City GetCityById(int id) 
    {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root  = cq.from(City.class);

        cq.select(root).where(root.get("id").in(id));

        City city = session.createQuery(cq).uniqueResult();

        session.close();
        return city;
    }

    @Override
    public List<City> GetAllCities(int page) 
    {
        int pageSize = 20;

        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root  = cq.from(City.class);

        cq.select(root);
        Query<City> query = session.createQuery(cq);

        query.setFirstResult((page-1) * pageSize); // задаем первую запись
        query.setMaxResults(pageSize); // задаем максимальное колличество элементов в ответе

        List<City> cities = query.getResultList();

        session.close();
        return cities;
    }

    @Override
    public List<City> FindCityByName(String name) 
    {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<City> cq = cb.createQuery(City.class);
        Root<City> root  = cq.from(City.class);

        cq.select(root).where(cb.like(root.get("title"), name+"%"));

        List<City> cities = session.createQuery(cq).getResultList();

        session.close();
        return cities;
    }
}
