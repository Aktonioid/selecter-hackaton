package com.hack.selectel.infrastucture.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hack.selectel.core.models.UserModel;
import com.hack.selectel.core.repositories.IUserRepo;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class UserRepo implements IUserRepo
{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean CreateUser(UserModel model) 
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
    public UserModel GetUserByUserName(String username) 
    {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserModel> cq = cb.createQuery(UserModel.class);
        Root<UserModel> root = cq.from(UserModel.class);

        cq.select(root).where(root.get("username").in(username));
        
        UserModel userModel = session.createQuery(cq).uniqueResult();

        session.close();

        return userModel;
    }

    @Override
    public boolean UpdateUser(UserModel model) 
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();

        try
        {
            transaction.begin();
            session.merge(model);
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
    
}
