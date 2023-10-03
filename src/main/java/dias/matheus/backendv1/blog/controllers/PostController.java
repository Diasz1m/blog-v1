package dias.matheus.backendv1.blog.controllers;


import dias.matheus.backendv1.blog.classes.Post;
import dias.matheus.backendv1.blog.repositories.PostRepository;
import dias.matheus.backendv1.blog.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    @Autowired
    public PostRepository postRepository;

    @Autowired
    public HttpSession httpSession;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addPost(@RequestBody Post content) {
        Post post = new Post();
        post.setContent(content.getContent());
        post.setTitle(content.getTitle());
        post.setCreatedAt(new Date());
//        User user = userRepository.findById((Integer) httpSession.getAttribute("userId")).get();
        post.setUserId(userRepository.findById((Integer) httpSession.getAttribute("userId")).get());

        postRepository.save(post);

        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Post getPost(@PathVariable Integer id) {
        return postRepository.findById(id).get();
    }
}
