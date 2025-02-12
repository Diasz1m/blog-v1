package dias.matheus.backendv1.blog.controllers;


import dias.matheus.backendv1.blog.classes.Message;
import dias.matheus.backendv1.blog.classes.Post;
import dias.matheus.backendv1.blog.repositories.PostRepository;
import dias.matheus.backendv1.blog.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public Message addPost(@RequestBody Post content) {
        Post post = new Post();
        post.setContent(content.getContent());
        post.setTitle(content.getTitle());
        post.setCreatedAt(new Date());

        post.setUserId(content.getId_user());

        try {
            postRepository.save(post);
        } catch (Exception e) {
            return new Message("Erro ao salvar post", Message.ERROR);
        }

        return new Message("Post salvo com sucesso", Message.SUCCESS);
    }

    @GetMapping("/all")
    public @ResponseBody List<Post> getAllPosts() {

        try {
            return postRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get/{id}")
    public @ResponseBody Post getPost(@PathVariable Integer id) {

        try {
            return postRepository.findById(id).get();
        }catch (
                Exception e) {
            throw new RuntimeException(e);
            }
    }
}
