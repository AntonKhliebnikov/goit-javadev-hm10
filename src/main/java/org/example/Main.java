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

        TicketCrudService ticketCrudService = new TicketCrudService(sessionFactory);


        Ticket ticket = new Ticket();
        ticket.setClient(new ClientCrudService(sessionFactory).getById(11L));
        ticket.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        ticket.setFromPlanet(new PlanetCrudService(sessionFactory).getById("NEP"));
        ticket.setToPlanet(new PlanetCrudService(sessionFactory).getById("JUP"));
        ticketCrudService.save(ticket);
        sessionFactory.close();
    }
}
