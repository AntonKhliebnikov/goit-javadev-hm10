package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.Planet;
import org.example.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlanetCrudService {
    SessionFactory sessionFactory;

    public Planet create(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        return planet;
    }

    public Planet getById(String id) {
        Session session = sessionFactory.openSession();
        return session.get(Planet.class, id);
    }

    public Planet setName(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(planet);
        transaction.commit();
        return planet;
    }

    public void deleteById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        if (planet != null) {
            session.remove(planet);
        }
        transaction.commit();
    }

    public List<Planet> getAllPlanets() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Planet> query = builder.createQuery(Planet.class);
        Root<Planet> root = query.from(Planet.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
}
