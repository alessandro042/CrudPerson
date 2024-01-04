package mx.edu.utez.crud.model.dto;

import lombok.*;
import mx.edu.utez.crud.model.entity.PersonBean;
import org.springframework.data.repository.CrudRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDto  {

    private Integer person_id;
    private String nombre;
    private String apellidos;
    private String curp;
    private String fecha_nac;

}
