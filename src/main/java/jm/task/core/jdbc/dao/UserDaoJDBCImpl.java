package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    private Connection connection = getConnection();
    private List<User> userList = new ArrayList<>();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE `mydbtest`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  `lastName` VARCHAR(100) NOT NULL,\n" +
                    "  `age` INT NULL,\n" +
                    "  PRIMARY KEY (`id`));");
            System.out.println("Table users created successfully\n");
        } catch (SQLException e) {
            System.out.println("Could not create table users\n");
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE `mydbtest`.`users`;");
            System.out.println("Table users was dropped successfully\n");
        } catch (SQLException e) {
            System.out.println("Was unable to drop table users\n");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement statement = connection.prepareStatement("insert into users(name,lastName,age) values(?,?,?);")) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            System.out.printf("User с именем Ц %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            System.out.printf("Could not create user %s %s of %d years old\n", name, lastName, age);
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement statement = connection.prepareStatement("delete from users where id = ?;")) {
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.printf("User with id = %d was deleted from table users\n", id);
        } catch (SQLException e) {
            System.out.printf("Could not delete user with id = %d\n", id);
        }
    }

    public List<User> getAllUsers() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users;")) {
            while (resultSet.next()) {
                userList.add(new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }
        } catch (SQLException e) {
            System.out.printf("Could get all users from table users\n");
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (PreparedStatement statement = connection.prepareStatement("delete from users;")) {
            statement.executeUpdate();
            System.out.printf("All users were deleted from table users\n");
        } catch (SQLException e) {
            System.out.printf("Could not delete all users from table users\n");
        }
    }
}
