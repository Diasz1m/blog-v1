package dias.matheus.backendv1.blog.repositories;

import dias.matheus.backendv1.blog.classes.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> { }
