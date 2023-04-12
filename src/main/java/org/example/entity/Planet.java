package org.example.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Table(name = "Planet")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Planet {
    @Id
    @Column(name = "id", length = 20, nullable = false)
    String id;

    @Column(name = "name", length = 500, nullable = false)
    String name;

    @OneToMany(mappedBy="fromPlanet")
    Set<Ticket> ticketsFromPlanet;

    @OneToMany(mappedBy="toPlanet")
    Set<Ticket> ticketsToPlanet;

}
