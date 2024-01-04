package mx.edu.utez.crud.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "person")
public class PersonBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer person_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "curp")
    private String curp;

    @Column(name = "fecha_nac")
    private String fecha_nac;

}
