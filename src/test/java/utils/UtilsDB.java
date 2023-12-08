package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilsDB {
    private static Connection connection = null;

    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://sbri1zb1apsem0brscomm001.postgres.database.azure.com:5432/pgho171";
        String username = "emuser@sbri1zb1apsem0brscomm001.postgres.database.azure.com";
        String password = "XXASAS";
        connection = DriverManager.getConnection(url, username, password);

    }

    public static List<String> queryRetornaQuiz() throws SQLException {
        List<String> quizData = new ArrayList<>();
        if (connection == null) {
            throw new SQLException("Conexão com o banco de dados não estabelecida. Chame connectToDB() primeiro.");
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM TABELA")) {

            while (rs.next()) {
                // Substitua o índice (1) pelo número da coluna que você deseja salvar como string.
                String value = rs.getString(1);
                quizData.add(value);
            }
        }

        return quizData;
    }



}