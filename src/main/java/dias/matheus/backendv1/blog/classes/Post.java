package dias.matheus.backendv1.blog.classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Post {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Getter
    private String title;
    @Setter
    private String content;

    private String description;

    private Date createdAt;

     @OneToOne()
    @PrimaryKeyJoinColumn()
     private User id_user;

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.id_user = getId_user();
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
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
