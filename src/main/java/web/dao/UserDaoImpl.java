package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        System.out.println("=== SAVING USER ===");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Lastname: " + user.getLastname());
        System.out.println("Age: " + user.getAge());
        entityManager.persist(user);
        return user;
    }
    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();
    }
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }
    @Override
    public void deleteUser(int id) {
       User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }
    @Override
    public User update(int id, User updatedUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
        userToBeUpdated.setAge(updatedUser.getAge());
        return updatedUser;
    }
}
