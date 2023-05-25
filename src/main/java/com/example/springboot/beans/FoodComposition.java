package com.example.springboot.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foodcomposition")
public class FoodComposition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "glucides")
    private double glucides;

    @Column(name = "lipides")
    private double lipides;

    @Column(name = "proteins")
    private double proteins;

    @Column(name = "sugar")
    private double sugar;

}
