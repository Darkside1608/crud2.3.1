package crud.dao;

import crud.model.User;
import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    //public void createTable() {
      //  entityManager.createNativeQuery("create table IF NOT EXISTS spring_hiber.users\n" +
       //         "(\n" +
       //         "    id        bigint auto_increment,\n" +
       //         "    firstName     varchar(50) null,\n" +
       //         "    address varchar(50) null,\n" +
       //         "    email     varchar(50) null,\n" +
       //         "    constraint table_name_pk\n" +
        //        "        primary key (id)\n" +
        //        ");");
   // }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class,id);
    }
    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void removeUser(long id) {
        User user = readUser(id);
        entityManager.remove(user);
    }
}