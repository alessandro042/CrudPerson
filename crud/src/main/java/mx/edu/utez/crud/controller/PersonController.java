package mx.edu.utez.crud.controller;

import mx.edu.utez.crud.model.dto.PersonDto;
import mx.edu.utez.crud.model.entity.PersonBean;
import mx.edu.utez.crud.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("crud/person")
public class PersonController {
    @Autowired
    private IPerson personService;

    @GetMapping("/")
    public List<PersonBean> getCards() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonBean showById(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @PostMapping("/")
    public PersonDto create(@RequestBody PersonDto personDto) {
        PersonBean personSave = personService.save(personDto);
        return PersonDto.builder()
                .person_id(personSave.getPerson_id())
                .nombre(personSave.getNombre())
                .apellidos(personSave.getApellidos())
                .curp(personSave.getCurp())
                .fecha_nac(personSave.getFecha_nac())
                .build();
    }
    @PutMapping("/")
    public PersonDto update(@RequestBody PersonDto personDto) {
        PersonBean personUpdate = personService.save(personDto);
        return PersonDto.builder()
                .person_id(personDto.getPerson_id())
                .nombre(personDto.getNombre())
                .apellidos(personDto.getApellidos())
                .curp(personDto.getCurp())
                .fecha_nac(personDto.getFecha_nac())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            PersonBean  personDelete= personService.findById(id);
            personService.delete(personDelete);
            return new ResponseEntity<>(personDelete, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Borrado correctamente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
