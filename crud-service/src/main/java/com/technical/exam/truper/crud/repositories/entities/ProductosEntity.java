package com.technical.exam.truper.crud.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "productos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductosEntity {

    @Id
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
