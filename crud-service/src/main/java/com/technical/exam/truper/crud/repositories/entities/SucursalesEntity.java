package com.technical.exam.truper.crud.repositories.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sucursales")
@Getter
@Setter
public class SucursalesEntity { //cmmartinezs@truper.com, aarcer@truper.com

    @Id
    @SequenceGenerator(name = "id_sucursal_seq", sequenceName = "id_sucursal_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sucursal_seq")
    @Column(name = "id_sucursal")
    Long idSucursal;

    @Column(name = "nombre")
    private String nombre;
}
