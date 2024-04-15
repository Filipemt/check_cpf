package com.example.filipedev.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cep {
    private Connection connection;

    public Cep(Connection connection) {
        this.connection = connection;
    }

    public boolean cepAlreadyExists(String cep) throws SQLException {
        String query = "SELECT COUNT(*) FROM consulta_cep WHERE cep = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cep);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }

    public void insertCep(String cep, String uf, String bairro) throws SQLException{
        String query = "INSERT INTO consulta_cep (cep, uf, bairro) VALUES (?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cep);
            statement.setString(2, uf);
            statement.setString(3, bairro);
            statement.executeUpdate();

        }
    }
}
