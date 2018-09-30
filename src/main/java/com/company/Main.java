package com.company;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pets", "root", "ruut")){
//            boolean b = connection.isValid(1000);
//            System.out.print(b);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/pets");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("ruut");
        hikariConfig.addDataSourceProperty("useSSL", false);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        final String SQL_Query = "select * from cats";
        List<Pets>  pets;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            System.out.print(connection.isValid(1000));

            pets = new ArrayList<>();
            Pets pet;
            while(resultSet.next()){
                pet = new Pets();
                pet.setId(resultSet.getInt("id"));
                pet.setBirth(resultSet.getString("birth"));
                pet.setName(resultSet.getString("name"));
                pet.setOwnwer(resultSet.getString("owner"));

                pets.add(pet);
            }

            for(Pets p : pets) {
                System.out.println(p.toString());
            }

            Pets one = new Pets();
            one.setBirth("1998-09-09");
            one.setName("Jaci");
            one.setOwnwer("David");
            String SQL_Insert = "INSERT INTO cats(birth, name, owner) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(SQL_Insert);
            ps.setString(1, one.getBirth());
            ps.setString(2, one.getName());
            ps.setString(3, one.getOwnwer());
            ps.executeUpdate();
            pets.add(one);

        }catch(SQLException ig){
            JOptionPane.showMessageDialog(null, "Connection Timed Out!!" + ig.getMessage());
        }
    }

    private static void insertData(){
        final String SQL_Insert = "insert into cats(birth, name, owner) values(?, ?, ?)";
    }
}
