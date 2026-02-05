package fr.pompey.cda24060.tp.repository;

import fr.pompey.cda24060.tp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

}
