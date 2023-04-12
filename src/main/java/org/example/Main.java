package org.example;

import org.example.entity.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;
import org.example.storage.HibernateUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:~/mydbhw10", "", "")
                .load();
        flyway.migrate();


        SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

        ClientCrudService clientCrudService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetCrudService = new PlanetCrudService(sessionFactory);
        TicketCrudService ticketCrudService = new TicketCrudService(sessionFactory);

        Ticket ticket = new Ticket();
        ticket.setClient(clientCrudService.getById(12L));
        ticket.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        ticket.setFromPlanet(planetCrudService.getById("NEP"));
        ticket.setToPlanet(planetCrudService.getById("JUP"));
        ticketCrudService.save(ticket);
        sessionFactory.close();
    }
}
