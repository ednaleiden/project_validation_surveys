package com.encuestas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VOTO_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="OPCION_ID", nullable = false)
    private Opcion opcion;
}
