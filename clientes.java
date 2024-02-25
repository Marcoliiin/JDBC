package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class clientes {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite seu nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite seu sexo: \n M para Masculino \n F para Feminino \n O para outros");
            String sexo = sc.nextLine();
            System.out.println("Digite seu endereço: ");
            String endereco = sc.nextLine();

            Connection connection = conexao.getConnection();

            String sql = "INSERT INTO clientes (nome,sexo,endereco) VALUES (?,?,?)";
            try (PreparedStatement inserindo_cliente = connection.prepareStatement(sql)) {
                inserindo_cliente.setString(1, nome);
                inserindo_cliente.setString(2, sexo);
                inserindo_cliente.setString(3, endereco);
                inserindo_cliente.executeUpdate();

                String consulta_nome = "SELECT id FROM clientes WHERE nome = ? ";
                try (PreparedStatement consultando_nome = connection.prepareStatement(consulta_nome);) {
                    consultando_nome.setString(1, nome);
                    ResultSet query = consultando_nome.executeQuery();
                    if (query.next()) {
                        System.out.println("O ID do seu perfil é: " + query.getInt(1));
                    }

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}

//connection.prepareStatement(sql) literalmente prepara a sql
//conectando com o banco de dados, utilizando o PreparedStatement,
//que seria uma interface do java que basicamente precompila uma SQL
//onde a variável statement recebe a SQL
