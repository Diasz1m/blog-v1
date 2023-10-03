package dias.matheus.backendv1.blog.classes;

import dias.matheus.backendv1.blog.repositories.UserRepository;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Entity
public class Post {

    @Autowired
    public HttpSession httpSession;

    @Autowired
    private UserRepository userRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String content;

    private Date createdAt;

     @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "id", referencedColumnName = "id",  insertable = false, updatable = false)
    private User id_user;

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.id_user = getId_user();
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getId_user() {
        return id_user;
    }

    public void setUserId(User userId) {
        this.id_user = userId;

    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
