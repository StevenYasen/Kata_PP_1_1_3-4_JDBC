package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
        System.out.println("Table users was created successfully");
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
        System.out.println("Table users was dropped successfully");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
        System.out.printf("User с именем Ц %s добавлен в базу данных\n", name);
    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
        System.out.printf("User with id = %d was deleted from table users\n", id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
        System.out.printf("All users were deleted from table users\n");
    }
}
