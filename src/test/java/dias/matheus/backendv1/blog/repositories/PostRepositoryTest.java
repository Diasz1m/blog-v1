package dias.matheus.backendv1.blog.repositories;

import dias.matheus.backendv1.blog.classes.Post;
import dias.matheus.backendv1.blog.classes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    private Post post;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setId(1L);
        post = new Post("Test Title", "Test Content");
        post.setUserId(user);
        post.setCreatedAt(new Date());
        postRepository.save(post);
    }

    @Test
    void testFindByTitleWhenPostExistsThenReturnPost() {
        Iterable<Post> posts = postRepository.findByTitle("Test Title");
        assertThat(posts).isNotEmpty();
        assertThat(posts.iterator().next().getTitle()).isEqualTo("Test Title");
    }

    @Test
    void testFindByTitleWhenPostDoesNotExistThenReturnEmpty() {
        Iterable<Post> posts = postRepository.findByTitle("Nonexistent Title");
        assertThat(posts).isEmpty();
    }

    @Test
    void testFindByTitleWhenTitleIsNullThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> postRepository.findByTitle(null));
    }

    @Test
    void testFindByTitleWhenTitleIsEmptyThenThrowException() {
        assertThrows(IllegalArgumentException.class, () -> postRepository.findByTitle(""));
    }

    @Test
    void findByUserId() {
        Iterable<Post> posts = postRepository.findByUserId(1);
        assertThat(posts).isNotEmpty();
        assertThat(posts.iterator().next().getId_user().getId()).isEqualTo(1);
    }

    @Test
    void findByTitle() {
    }
}