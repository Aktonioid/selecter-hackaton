package com.hack.selectel.infrastucture.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hack.selectel.core.models.ScheduleModel;

@Repository
//это чисто для парсинга данных с апи
public class ScheduleRepository
{
    @Autowired
    SessionFactory sessionFactory;

    public boolean CreateSchedule(ScheduleModel model)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.persist(model);
            transaction.commit();
        }
        catch(HibernateException e)
        {
            transaction.rollback();
            System.out.println("saving sched in db");
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
}
