package fr.pompey.cda24060.tp.service;

import fr.pompey.cda24060.tp.model.User;
import fr.pompey.cda24060.tp.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getIdUser(Integer idUser) {
        return userRepository.findById(idUser);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer idUser) {
        userRepository.deleteById(idUser);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
