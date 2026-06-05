package io.github.gamelmw.database;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcDemo {
    private static Connection getConnection() throws Exception {
        Properties properties = new Properties();
        try (InputStream inputStream = JdbcDemo.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("找不到配置文�?database.properties");
            }
            properties.load(inputStream);
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String passwordEnv = properties.getProperty("db.password.env");
        String password = System.getenv(passwordEnv);

        if (password == null) {
            throw new IllegalStateException("请先设置环境变量: " + passwordEnv);
        }
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws Exception {
        query();
        System.out.println("-------");
        deleteDepartment(100);
        query();
        System.out.println("-------");
        insertDepartment(100, "场地部");
        query();
    }

    private static void query() throws Exception {

        String sql = "select d_id, d_name from department";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("d_id");
                String name = resultSet.getString("d_name");
                System.out.println("部门ID: " + id + ", 部门名称: " + name);
            }
        }
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("select now()")) {
//
//            if (resultSet.next()) {
//                System.out.println("当前数据库时�? " + resultSet.getString(1));
//            }
//        }
    }

    private static void insertDepartment(int id, String name) throws Exception {
        String sql = "insert into department (d_id, d_name) values (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);

            int rows = statement.executeUpdate();
            System.out.println("插入记录�? " + rows);
        }
    }

    private static void deleteDepartment(int id) throws Exception {
        String sql = "DELETE FROM department WHERE d_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rows = statement.executeUpdate();
            System.out.println("删除记录�? " + rows);
        }
    }
}
