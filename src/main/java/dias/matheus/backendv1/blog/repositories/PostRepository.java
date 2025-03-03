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

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("Select p from Post p where p.title like ?1")
    List<Post> findByTitle(@Param("title") String title);

    @Query("Select p from Post p where p.id_user = ?1")
    List<Post> findByUserId(@Param("id") Integer id);

    @Query("Select p from Post p where p.id = ?1")
    Optional<Post> findById(@Param("id") Integer id);
    
    /* BUSCAR POST POR DESCRIÇÃO */
    @Query("Select p from Post p where p.description like ?1")
    List<Post> findByContent(@Param("content") String content);
    
}
