package dias.matheus.backendv1.blog.repositories;

import dias.matheus.backendv1.blog.classes.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userReposotory;

    @Test
    @DisplayName("Return user by email")
     void findByEmail() {}

    @Test
    void findEmailUseCase()
    {
        User userDTO = new User("Matheus", "matheus@gmail.com", "123456");
//        User user = this.createUser(userDTO);

//        entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1");

        User userByEmail = this.userReposotory.findByEmail(userDTO.getEmail());

        Assertions.assertThat(userByEmail).isNotNull();
    }

  /*  @Test
    public User createUser(User userDTO) {
        User user = new User(userDTO);

        this.entityManager.persist(user);

//        entityManager.persist(user);
        return user;

    }
*/
}