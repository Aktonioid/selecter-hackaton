package com.hack.selectel.infrastucture.repositories;

import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hack.selectel.core.models.DonationPlan;
import com.hack.selectel.core.models.UserModel;
import com.hack.selectel.core.repositories.IDonationPlanRepo;
import com.hack.selectel.core.repositories.IUserRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class DonationPlanRepository  implements IDonationPlanRepo
{
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    IUserRepo userRepo;

    @Override
    public boolean CreateDonationPlan(DonationPlan donation) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.persist(donation);
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
    public boolean UpdateDonationPlan(DonationPlan donation) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.merge(donation);
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
    public List<DonationPlan> GetDonationByUser(String username, int page) 
    {
        int pageSize = 20;

        Session session =sessionFactory.openSession();
        
        UserModel model = userRepo.GetUserByUserName(username);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DonationPlan> cq = cb.createQuery(DonationPlan.class);
        Root<DonationPlan> root = cq.from(DonationPlan.class);
        
        cq.select(root).where(root.get("userId").in(model.getId()));

        Query<DonationPlan> query = session.createQuery(cq);

        query.setFirstResult((page-1) * pageSize); // задаем первую запись
        query.setMaxResults(pageSize); // задаем максимальное колличество элементов в ответе

        List<DonationPlan> donations = query.getResultList();
        session.close();
        return donations;
    }

    @Override
    public DonationPlan GetDonationById(UUID id) 
    {
        Session session =sessionFactory.openSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DonationPlan> cq = cb.createQuery(DonationPlan.class);
        Root<DonationPlan> root = cq.from(DonationPlan.class);
    
        cq.select(root).where(root.get("id").in(id));
        DonationPlan donation = session.createQuery(cq).uniqueResult();

        session.close();

        return donation;
    }
}
