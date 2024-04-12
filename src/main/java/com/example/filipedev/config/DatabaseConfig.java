package com.example.filipedev.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConfig {

    private Connection connection;

    public DatabaseConfig() {
        connect();
    }

    public void connect() {
        try {
            String url = "jdbc:postgresql://localhost:5433/postgres";
            String user = "postgres";
            String password = "Com@ndo2p4";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado ao banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Desconectado do banco de dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }

    public void insertData(String cep, String uf, String bairro) {
        try {
            String query = "INSERT INTO consulta_cep (cep, uf, bairro) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, cep);
            statement.setString(2, uf);
            statement.setString(3, bairro);
            statement.executeUpdate();
            System.out.println("Dados inseridos com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados no banco de dados: " + e.getMessage());
        }
    }
}