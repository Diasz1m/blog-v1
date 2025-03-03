package dias.matheus.backendv1.blog.controllers;

import dias.matheus.backendv1.blog.classes.Message;
import dias.matheus.backendv1.blog.classes.MessageLogin;
import dias.matheus.backendv1.blog.classes.User;
import dias.matheus.backendv1.blog.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public HttpSession httpSession;


    public Long getUserId() {
        return (Long) httpSession.getAttribute("userId");
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<MessageLogin> login(@RequestBody User userBody) {

        User email = this.userRepository.findByEmail(userBody.getEmail());

        if (email == null) {
            return ResponseEntity.badRequest().body(new MessageLogin("Usuario nao encontrado", Message.ERROR, null, null));
        }

        if (!email.getPassword().equals(userBody.getPassword())) {
            return ResponseEntity.badRequest().body(new MessageLogin("Senha incorreta", Message.ERROR, null, null));
        }

        httpSession.setAttribute("userId", email.getId());
        return ResponseEntity.ok(new MessageLogin("Login realizado com sucesso", Message.SUCCESS, email.getRole(), email.getId()));
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<String> addUser(@RequestBody User userBody) {

        User email = this.userRepository.findByEmail(userBody.getEmail());

        if(email != null){
            return ResponseEntity.badRequest().body("Email ja cadastrado");
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
        try
        {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get/{id}")
    public @ResponseBody User getUser(@PathVariable Integer id) {
        try
        {

            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
