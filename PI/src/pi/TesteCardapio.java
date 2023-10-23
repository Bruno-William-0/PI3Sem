package pi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pi.Controller.Conexao;

public class TesteCardapio {
	int numObj = 30;
	int i = 0;
	Produto[] p = new Produto[numObj];
	public void listar() {
		try {
			String sql = "Select * from produto";
			PreparedStatement ps = null;
            ResultSet rs = null;
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
            	p[i] = new Produto(
            			rs.getInt("cod_produto"),
            			rs.getString ("nome"),
            			rs.getDouble ("preco"),
            			rs.getString("descricao"),
            			rs.getString ("tipo")
            			);
            	p[i].toString();
            	System.out.println(p[i]);
            	i++;
            }
            
            
		}
		catch(SQLException e) { System.out.println(e);
			
		}
	}
}
