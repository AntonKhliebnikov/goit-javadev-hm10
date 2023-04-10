package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

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




}
