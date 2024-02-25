package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class contas {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Connection connection = conexao.getConnection();

            System.out.println("Qual o tipo da conta que você quer criar?\n 1-Conta corrente\n 2-Conta Poupança\n 3-Conta Salário");
            int tipoConta = sc.nextInt();

            String sql = "INSERT INTO conta (id_tipo_conta,id_cliente) VALUES (?,?)";

            vinculos.vinculo_conta_cliente();

            try (PreparedStatement sintaxe = connection.prepareStatement(sql)) {
                sintaxe.setInt(1, tipoConta);
                sintaxe.setInt(2, vinculos); //estou puxando valor nadave
                int table = sintaxe.executeUpdate();

                System.out.println("Tabela conta afetada? (1 = sim)\n" + table);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
    }
}
