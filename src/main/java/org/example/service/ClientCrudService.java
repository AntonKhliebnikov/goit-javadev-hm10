package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.Client;
import org.example.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientCrudService {
    SessionFactory sessionFactory;

    public Client create(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        return client;
    }

    public Client getById(long id) {
        Session session = sessionFactory.openSession();
        return session.get(Client.class, id);
    }

    public Client setName(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(client);
        transaction.commit();
        return client;
    }

    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.remove(client);
        }
        transaction.commit();
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Client> query = builder.createQuery(Client.class);
        Root<Client> root = query.from(Client.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
}
