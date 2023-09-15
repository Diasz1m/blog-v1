package dias.matheus.backendv1.blog.controllers;

import dias.matheus.backendv1.blog.classes.User;
import dias.matheus.backendv1.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @PostMapping("/add")
    public @ResponseBody String addUser(@RequestParam String name,
                                        @RequestParam String email,
                                        @RequestParam String senha) {
        User user = new User(name, email, senha);

        userRepository.save(user);

        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

}
