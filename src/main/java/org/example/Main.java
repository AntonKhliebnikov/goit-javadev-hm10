package org.example;

import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {


        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:~/mydbhw10", "", "")
                .load();
        flyway.migrate();


        ClientCrudService clientCrudService = new ClientCrudService();
        clientCrudService.getAllClients().forEach(System.out::println);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        planetCrudService.getAllPlanets().forEach(System.out::println);
    }
}
