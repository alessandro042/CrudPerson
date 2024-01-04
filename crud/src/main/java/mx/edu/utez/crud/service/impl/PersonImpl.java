package mx.edu.utez.crud.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.crud.model.dao.PersonDao;
import mx.edu.utez.crud.model.dto.PersonDto;
import mx.edu.utez.crud.model.entity.PersonBean;
import mx.edu.utez.crud.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonImpl implements IPerson {
    @Autowired
    private final PersonDao personDao;

    @Override
    @Transactional
    public PersonBean save(PersonDto personDto) {
        PersonBean person = PersonBean.builder()
                .person_id(personDto.getPerson_id())
                .nombre(personDto.getNombre())
                .apellidos(personDto.getApellidos())
                .fecha_nac(personDto.getFecha_nac())
                .curp(personDto.getCurp())
                .build();
        return personDao.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonBean findById(Integer id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonBean> findAll() {
        return (List<PersonBean>) personDao.findAll();
    }

    @Override
    @Transactional
    public void delete(PersonBean personBean) {
        personDao.delete(personBean);
    }
}
