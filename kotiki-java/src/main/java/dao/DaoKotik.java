package dao;

import entity.Kotik;
import entity.Master;
import hibernate.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public class DaoKotik {
    public Kotik findById(UUID id) {
        return HibernateSession.getSessionFactory().openSession().get(Kotik.class, id);
    }

    public void save(Kotik cat) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(cat);
        tx1.commit();
        session.close();
    }

    public void update(Kotik cat) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(cat);
        tx1.commit();
        session.close();
    }

    public void delete(Kotik cat) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(cat);
        tx1.commit();
        session.close();
    }

    public Master findMasterById(UUID id) {
        return HibernateSession.getSessionFactory().openSession().get(Master.class, id);
    }
}
