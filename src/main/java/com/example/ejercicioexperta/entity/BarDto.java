package com.example.ejercicioexperta.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Table(name="bar")
@Entity
@Setter
@Getter
@ToString
public class BarDto {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idBar;
     private String nombre;
     private String domicilio;
     private Integer puntuacion;

     public BarDto(Integer idBar, String nombre, String domicilio, Integer puntuacion) {
          this.idBar = idBar;
          this.nombre = nombre;
          this.domicilio = domicilio;
          this.puntuacion = puntuacion;

     }

     public BarDto() {
     }
}
