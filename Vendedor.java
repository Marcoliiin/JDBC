package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class vendedor {
    public static void main(String[] args) {
    }

    public static void criar_vendedor() {
        try {
            Connection connection = conexao.getConnection();

            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o nome vendedor: ");
            String nome = sc.nextLine();

            String sql = "INSERT INTO vendedor (nome) VALUES (?)";
            try (PreparedStatement inserindo_cliente = connection.prepareStatement(sql)) {
                inserindo_cliente.setString(1, nome);

                inserindo_cliente.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}
