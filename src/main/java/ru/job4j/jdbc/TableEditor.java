package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            properties.load(new FileInputStream(
                    "src/main/resources/jdbc/app.properties"));
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void creationRequest(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String rsl = String.format("create table if not exists %s();", tableName);
        creationRequest(rsl);
    }

    public void dropTable(String tableName) {
        String rsl = String.format("drop table if exists %s", tableName);
        creationRequest(rsl);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String rsl = String.format("alter table %s add %s %s;",
                tableName,
                columnName,
                type
        );
        creationRequest(rsl);
    }

    public void dropColumn(String tableName, String columnName) {
        String rsl = String.format("alter table %s drop column %s;",
                tableName,
                columnName

        );
        creationRequest(rsl);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String rsl = String.format("alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        );
        creationRequest(rsl);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        TableEditor table = new TableEditor(properties);
        table.createTable("test_id");
        table.dropTable("test_id");
        table.close();
    }
}