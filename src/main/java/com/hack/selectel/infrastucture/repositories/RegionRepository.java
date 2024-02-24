package com.hack.selectel.infrastucture.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hack.selectel.core.models.Region;
import com.hack.selectel.core.repositories.IRegionRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class RegionRepository implements IRegionRepo
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean CreateRegion(Region region)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.persist(region);
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
    public boolean CreateRegion(List<Region> region)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.persist(region);
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
    public boolean UpdateRegion(Region region)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.merge(region);
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
    public List<Region> GetAllRegions(int page) 
    {
        int pageSize = 20;

        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Region> cq = cb.createQuery(Region.class);
        Root<Region> root  = cq.from(Region.class);

        cq.select(root);
        Query<Region> query = session.createQuery(cq);

        query.setFirstResult((page-1) * pageSize); // задаем первую запись
        query.setMaxResults(pageSize); // задаем максимальное колличество элементов в ответе

        List<Region> regions = query.getResultList();

        return regions;
    }
    @Override
    public Region GetRegionById(int id) 
    {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Region> cq = cb.createQuery(Region.class);
        Root<Region> root  = cq.from(Region.class);

        cq.select(root).where(root.get("id").in(id));

        Region region = session.createQuery(cq).uniqueResult();

        session.close();

        return region;
    }
}
