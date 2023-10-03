package dias.matheus.backendv1.blog.repositories;

/*
* CRUD operations:
* C - Create
* R - Read
* U - Update
* D - Delete
*
* */

import dias.matheus.backendv1.blog.classes.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("Select p from Post p where p.title like ?1")
    Iterable<Post> findByTitle(@Param("title") String title);

    @Query("Select p from Post p where p.id_user = ?1")
    Iterable<Post> findByUserId(@Param("id") Integer id);
}
