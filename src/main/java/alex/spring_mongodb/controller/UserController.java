package alex.spring_mongodb.controller;

import alex.spring_mongodb.entityClass.User;
import alex.spring_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Validated @RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @Validated @RequestBody User updatedUser) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        return userRepository.save(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
