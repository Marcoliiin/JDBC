package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class clientes {
    public static void main(String[] args) {
    }

    public static void criar_cliente() {
        try {
            Connection connection = conexao.getConnection();

            Scanner sc = new Scanner(System.in);
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite seu sexo: \n M para Masculino \n F para Feminino \n O para outros");
            String sexo = sc.nextLine();
            System.out.println("Digite seu endereço: ");
            String endereco = sc.nextLine();

            String sql = "INSERT INTO clientes (nome,sexo,endereco) VALUES (?,?,?)";
            try (PreparedStatement inserindo_cliente = connection.prepareStatement(sql)) {
                inserindo_cliente.setString(1, nome);
                inserindo_cliente.setString(2, sexo);
                inserindo_cliente.setString(3, endereco);
                inserindo_cliente.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

    public static void consultar_nome_cliente() {
        try {
            Connection connection = conexao.getConnection();

            String consulta_nome = "SELECT id FROM clientes WHERE nome = ? ";
            try (PreparedStatement consultando_nome = connection.prepareStatement(consulta_nome)) {
                consultando_nome.setString(1, nome);
                ResultSet query = consultando_nome.executeQuery();
                if (query.next()) {
                    System.out.println("O ID do seu perfil é: " + query.getInt(1));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}
