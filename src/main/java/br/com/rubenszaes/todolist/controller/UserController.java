package br.com.rubenszaes.todolist.controller;

import br.com.rubenszaes.todolist.model.User;
import br.com.rubenszaes.todolist.respository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Operation(tags = "Users", summary = "Listar usuários cadastrados.")
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Operation(tags = "Users", summary = "Criar novo usuário.")
    @PostMapping()
    public ResponseEntity create(@RequestBody User user) {
        User byUsername = userRepository.findByUsername(user.getUsername());

        if (byUsername != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserName já cadastrado!");
        }

        User userCreated = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
