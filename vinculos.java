package jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class vinculos {
    public static void vinculo_conta_cliente() {
        try  {
            Connection connection = conexao.getConnection();


            String sql = "SELECT id FROM clientes where id = ?";
            try (PreparedStatement consultando_id = connection.prepareStatement(sql)) {
                consultando_id.setString(1, nome);
            }

            PreparedStatement sintaxe = connection.prepareStatement(sql);

            ResultSet query = sintaxe.executeQuery();
            if (query.next()) {
                System.out.println("ID do cliente: " + query.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
