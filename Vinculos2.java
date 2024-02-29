package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class Vinculos {
    public static int vinculo_produto_fornecedor() {
        int retorno_fornecedor = 0; 

        try (Scanner sc = new Scanner(System.in);
             Connection connection = conexao.getConnection()) {

            System.out.println("Qual é o ID do vendedor deste produto?");
            String id_fornecedor = sc.nextLine();

            String sql = "SELECT id FROM fornecedores WHERE id = ?";
            try (PreparedStatement consultando_id = connection.prepareStatement(sql)) {
                consultando_id.setString(1, id_fornecedor);

                try (ResultSet query = consultando_id.executeQuery()) {
                    if (query.next()) {
                        retorno_fornecedor = query.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno_fornecedor;
    }

    public static int vinculo_venda_cliente(){
      int retorno_cliente = 0;

      try (Scanner sc = new Scanner(System.in);
      Connection connection = conexao.getConnection()){

        System.out.println("Qual é o nome do cliente da venda?");
        String id_cliente = sc.nextLine();

        String sql = "SELECT id FROM clientes WHERE id = ?";
        try (PreparedStatement consultando_id = connection.prepareStatement(sql)){
            consultando_id.setString(1,id_cliente);

            try(ResultSet query = consultando_id.executeQuery()){
                if (query.next()) {
                    retorno_cliente = query.getInt(1);
                }
            }
        }
      } catch (SQLException e){
        e.printStackTrace();
      }
       return retorno_cliente; 
    }  
    
}