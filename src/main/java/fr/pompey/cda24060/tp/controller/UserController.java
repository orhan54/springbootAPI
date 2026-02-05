package fr.pompey.cda24060.tp.controller;

import fr.pompey.cda24060.tp.model.User;
import fr.pompey.cda24060.tp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * POST /users - Créer un nouvel utilisateur
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * GET /users - Récupérer tous les utilisateurs
     */
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    /**
     * GET /users/{idUser} - Récupérer un utilisateur par son ID
     */
    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable int idUser) {
        Optional<User> user = userService.getIdUser(idUser);
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    /**
     * PUT /users/{idUser} - Mettre à jour un utilisateur
     */
    @PutMapping("/{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable int idUser, @RequestBody User user) {
        Optional<User> userOptional = userService.getIdUser(idUser);

        if (userOptional.isPresent()) {
            User updatedUser = userOptional.get();

            String userFirstName = user.getUser_first_name();
            if(userFirstName != null) {
                updatedUser.setUser_first_name(userFirstName);
            }

            String userLastName = user.getUser_last_name();
            if(userLastName != null) {
                updatedUser.setUser_last_name(userLastName);
            }

            userService.saveUser(updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /users/{idUser} - Supprimer un utilisateur
     */
    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable int idUser) {
        Optional<User> userOptional = userService.getIdUser(idUser);
        
        if (userOptional.isPresent()) {
            userService.deleteUser(idUser);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
