package dias.matheus.backendv1.blog.controllers;

import dias.matheus.backendv1.blog.classes.User;
import dias.matheus.backendv1.blog.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public HttpSession httpSession;


    public Long getUserId() {
        return (Long) httpSession.getAttribute("userId");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User userBody) {

        User email = this.userRepository.findByEmail(userBody.getEmail());

        if (email == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        if (!email.getPassword().equals(userBody.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong password");
        }

        httpSession.setAttribute("userId", email.getId());

        return ResponseEntity.ok("Logged in");
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity addUser(@RequestBody User userBody) {

        User email = this.userRepository.findByEmail(userBody.getEmail());

        if(email != null){
            return ResponseEntity.badRequest().body("User not found");
        }

        User user = new User();
        user.setEmail(userBody.getEmail());
        user.setName(userBody.getName());
        user.setPassword(userBody.getPassword());
        try {
        userRepository.save(user);
        return ResponseEntity.ok("Saved: " + user.getName() + " with id: " + user.getId());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}
