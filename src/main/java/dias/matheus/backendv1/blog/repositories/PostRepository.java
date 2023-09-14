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
 import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> { }
