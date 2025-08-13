package com.technical.exam.truper.crud.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ordenes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdenesEntity {

    @Id
    @SequenceGenerator(name = "orden_id_seq", sequenceName = "orden_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orden_id_seq")
    Long ordenId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", foreignKey = @ForeignKey(name = "id_sucursal_fk"))
    SucursalesEntity sucursal;

    @Column(name = "date")
    LocalDate fecha;

    @Column(name = "total")
    Double total;

}
