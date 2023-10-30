package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Andrew", "Holywood", (byte)12);
        userServiceImpl.saveUser("Mikle", "Zotov", (byte)44);
        userServiceImpl.saveUser("Marina", "Bianka", (byte)33);
        userServiceImpl.saveUser("Konstantin", "Simonov", (byte)60);
        userServiceImpl.getAllUsers().stream().forEach(System.out::println);
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}
