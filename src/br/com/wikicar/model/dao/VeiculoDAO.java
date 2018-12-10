package br.com.wikicar.model.dao;

import br.com.wikicar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wikicar.model.bean.Veiculo;

/**
 * @author Ivanilson P Mota
 */

public class VeiculoDAO {

    private Connection conn = null;

    public VeiculoDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public boolean save(Veiculo veiculo) {

        String sql = "INSERT INTO tb_veiculo (nome_vei, capacidade_vei) VALUES (?, ?)";

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, veiculo.getNome());
            pstmt.setDouble(2, veiculo.getCapacidade());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt);
        }

    }

    public List<Veiculo> findAll() {

        String q = "SELECT * FROM tb_veiculo";

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();

        try {

            pstmt = conn.prepareStatement(q);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setId(rs.getInt("id_vei"));
                veiculo.setNome(rs.getString("nome_vei"));
                veiculo.setCapacidade(rs.getDouble("capacidade_vei"));

                veiculos.add(veiculo);
            }

        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt, rs);
        }

        return veiculos;
    }

    public boolean update(Veiculo veiculo) {

        String sql = "UPDATE tb_veiculo SET nome_vei = ?, capacidade_vei = ? WHERE id_vei = ?;";

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, veiculo.getNome());
            pstmt.setDouble(2, veiculo.getCapacidade());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt);
        }
        
    }
    
    public boolean delete(Veiculo veiculo) {

        String sql = "DELETE FROM veiculo WHERE id_veiculo = ?;";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, veiculo.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }
}
