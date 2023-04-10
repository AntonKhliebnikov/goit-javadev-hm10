package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.storage.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {

    public void create(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public String getById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet.getName();
    }

    public void setName(String id, String name) {
        Planet planet = new Planet();
        planet.setId(id);
        planet.setName(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(planet);
        transaction.commit();
        session.close();
    }

    public void deleteById(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        if (planet != null) {
            session.remove(planet);
        }
        transaction.commit();
        session.close();
    }

    public List<Planet> getAllPlanets() {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Planet> query = builder.createQuery(Planet.class);
        Root<Planet> root = query.from(Planet.class);
        query.select(root);
        List<Planet> planets = session.createQuery(query).getResultList();
        session.close();
        return planets;
    }
}
