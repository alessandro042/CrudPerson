package mx.edu.utez.crud.service;

import mx.edu.utez.crud.model.dto.PersonDto;
import mx.edu.utez.crud.model.entity.PersonBean;

import java.util.List;

public interface IPerson {
    PersonBean save(PersonDto personDto);

    PersonBean findById(Integer id);

    List<PersonBean> findAll();

    void delete(PersonBean personBean);
}
