package com.technical.exam.truper.crud.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "productos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductosEntity {

    @Id
    @SequenceGenerator(name = "producto_id_seq", sequenceName = "producto_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_id_seq")
    Long id;

    @Column(name = "id_producto")
    Long idProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", foreignKey = @ForeignKey(name = "orden_id_fk"))
    OrdenesEntity ordenesEntity;

    @Column(name = "descripcion")
    String descripcion;

    @Column(name = "precio")
    Double precio;

}
