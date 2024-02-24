package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

            try (PreparedStatement sintaxe = connection.prepareStatement(sql)) {
                sintaxe.setString(1, nome);
                sintaxe.setString(2, sexo);
                sintaxe.setString(3, endereco);
                int table = sintaxe.executeUpdate();

                System.out.println("Tabela clientes afetada? (1 = sim)\n" + (table));

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
