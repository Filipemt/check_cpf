package com.example.filipedev.config;

import com.example.filipedev.model.Cep;

import java.sql.*;

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
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }

    public void insertData(String cep, String uf, String bairro) {
        try {
            Cep cep1 = new Cep(connection);
            if (cep1.cepAlreadyExists(cep)) {
                System.out.println("CEP já cadastrado!");
            } else {
                cep1.insertCep(cep, uf, bairro);
                System.out.println("Dados inseridos com sucesso.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados no banco de dados: " + e.getMessage());
        }
    }
}