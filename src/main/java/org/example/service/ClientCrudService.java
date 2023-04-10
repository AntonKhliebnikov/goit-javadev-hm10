package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.Client;
import org.example.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    public void create(String name) {
        Client client = new Client();
        client.setName(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public String getById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client.getName();
    }

    public void setName(long id, String name) {
        Client client = new Client();
        client.setId(id);
        client.setName(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(client);
        transaction.commit();
        session.close();
    }

    public void deleteById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.remove(client);
        }
        transaction.commit();
        session.close();
    }

    public List<Client> getAllClients() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        Root<Client> root = query.from(Client.class);
        query.select(root);
        List<Client> clients = session.createQuery(query).getResultList();
        session.close();
        return clients;
    }
}
