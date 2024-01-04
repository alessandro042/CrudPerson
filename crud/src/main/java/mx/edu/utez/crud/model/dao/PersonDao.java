package mx.edu.utez.crud.model.dao;

import mx.edu.utez.crud.model.entity.PersonBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<PersonBean, Integer> {
}
