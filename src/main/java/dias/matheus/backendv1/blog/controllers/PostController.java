package dias.matheus.backendv1.blog.controllers;


import dias.matheus.backendv1.blog.classes.Post;
import dias.matheus.backendv1.blog.repositories.PostRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    public PostRepository postRepository;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addPost(@RequestBody Post content) {
        Post post = new Post();
        post.setContent(content.getContent());
        post.setTitle(content.getTitle());
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
