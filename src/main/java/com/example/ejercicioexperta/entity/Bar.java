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
public class Bar {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idBar;
     private String nombre;
     private String domicilio;
     private Integer puntuacion;
     private String email;
     private Integer telefono;
     private Integer cuit;
     private String horario;
     private Boolean estacionamiento;

     public Bar(Integer idBar, String nombre, String domicilio, Integer puntuacion, String email, Integer telefono, Integer cuit, String horario, Boolean estacionamiento) {
          this.idBar = idBar;
          this.nombre = nombre;
          this.domicilio = domicilio;
          this.puntuacion = puntuacion;
          this.email = email;
          this.telefono = telefono;
          this.cuit = cuit;
          this.horario = horario;
          this.estacionamiento = estacionamiento;
     }

     public Bar(String nombre, String domicilio, Integer puntuacion, String email, Integer telefono, Integer cuit, String horario, Boolean estacionamiento) {
          this.nombre = nombre;
          this.domicilio = domicilio;
          this.puntuacion = puntuacion;
          this.email = email;
          this.telefono = telefono;
          this.cuit = cuit;
          this.horario = horario;
          this.estacionamiento = estacionamiento;
     }

     public Bar() {
     }
}
