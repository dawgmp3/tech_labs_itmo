package dao;

import entity.Kotik;
import entity.Master;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernate.HibernateSession;
import java.util.List;
import java.util.UUID;

public class DaoMaster {
    public Master findById(int id) {
        return HibernateSession.getSessionFactory().openSession().get(Master.class, id);
    }

    public void save(Master master) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(master);
        tx1.commit();
        session.close();
    }

    public void update(Master master) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(master);
        tx1.commit();
        session.close();
    }

    public void delete(Master master) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(master);
        tx1.commit();
        session.close();
    }

    public Kotik findKotikById(UUID id) {
        return HibernateSession.getSessionFactory().openSession().get(Kotik.class, id);
    }

    public List<Master> findAll() {
        List<Master> masters = (List<Master>)  HibernateSession.getSessionFactory().openSession().createQuery("From Master").list();
        return masters;
    }
}
