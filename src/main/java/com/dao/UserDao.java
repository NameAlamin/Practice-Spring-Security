package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void store(User user){
        Session session = sessionFactory.getCurrentSession();
        try{
            session.save(user);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }
}
