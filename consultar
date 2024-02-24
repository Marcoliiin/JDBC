package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class consultar {
    public static void main(String[] args) {
        try {
            Connection connection = conexao.getConnection();

            String sql = "SELECT * FROM clientes";
            PreparedStatement sintaxe = connection.prepareStatement(sql);

            ResultSet query = sintaxe.executeQuery();
            if (query.next()) {
                System.out.println("ID do cliente: " + query.getInt(1));
                System.out.println("Nome do cliente: " + query.getString(2));
                System.out.println("Sexo do cliente: " + query.getString(3));
                System.out.println("Endereço do cliente: " + query.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
