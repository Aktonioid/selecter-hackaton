package com.hack.selectel.infrastucture.repositories;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hack.selectel.core.models.BloodGroup;
import com.hack.selectel.core.models.BloodGroupStatus;
import com.hack.selectel.core.models.DonationCenter;
import com.hack.selectel.core.repositories.IDonationCenterRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class DonationCenterRepository implements IDonationCenterRepo
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean CreateDonationCenter(DonationCenter center)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            System.out.println("saving donations in db");
            session.persist(center);
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
    public List<DonationCenter> GetDonationCentersByUserBlood(BloodGroup group, int cityId) 
    {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DonationCenter> cq = cb.createQuery(DonationCenter.class);
        Root<DonationCenter> root = cq.from(DonationCenter.class);
        
        cq.select(root);

        
        switch (group) 
        {
            case FIRST_POSITIVE -> {
                cq.where(root.get("o_plus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case FIRST_NEGATIVE -> {
                cq.where(root.get("o_minus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case SECOND_POSITIVE -> {
                cq.where(root.get("a_plus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case SECOND_NEGATIVE -> {
                cq.where(root.get("a_minus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case THIRD_POSITIVE -> {
                cq.where(root.get("b_plus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case THIRD_NEGATIVE -> {
                cq.where(root.get("b_minus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case FOURTH_NEGATIVE -> {
                cq.where(root.get("ab_plus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
            case FOURTH_POSITIVE -> {
                cq.where(root.get("ab_minus")
                        .in(Arrays.asList(BloodGroupStatus.NEED, BloodGroupStatus.UNKOWN)));
            }
                
        }

        if(cityId != 0)
        {
            cq.where(root.get("cityId").in(cityId));
        }

        List<DonationCenter> center = session.createQuery(cq).getResultList();

        session.close();

        return center;
    }

    @Override
    public DonationCenter DonationCenterById(int cneterId) 
    {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DonationCenter> cq = cb.createQuery(DonationCenter.class);
        Root<DonationCenter> root = cq.from(DonationCenter.class);
        
        cq.select(root).where(root.get("id").in(cneterId));

        DonationCenter center = session.createQuery(cq).uniqueResult();

        session.close();

        return center;
    }

    @Override
    public List<DonationCenter> GetByCityId(int cityId, int page) 
    {
        int pageSize =  20;

        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<DonationCenter> cq = cb.createQuery(DonationCenter.class);
        Root<DonationCenter> root = cq.from(DonationCenter.class);
        
        cq.select(root).where(root.get("cityId").in(cityId));

        Query<DonationCenter> query = session.createQuery(cq);
        query.setFirstResult((page-1) * pageSize); // задаем первую запись
        query.setMaxResults(pageSize); // задаем максимальное колличество элементов в ответе

        List<DonationCenter> donationCenters = query.getResultList();

        session.close();

        return donationCenters;
    }


}

