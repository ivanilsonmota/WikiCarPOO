package br.com.wikicar.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wikicar.connection.ConnectionFactory;
import br.com.wikicar.model.bean.Carro;
import br.com.wikicar.model.bean.Veiculo;


/**
 * @author Ivanilson P Mota
 */

public class CarroDAO {

    private Connection conn = null;

    public CarroDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public boolean save(Carro carro) {

        String q = "INSERT INTO tb_carro (marca_car, modelo_car, ano_lanc_car, ano_enc_car, estado_conserv_car, id_vei) VALUES (?,?,?,?,?,1)";

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(q);
            pstmt.setString(1, carro.getMarca());
            pstmt.setString(2, carro.getModelo());
            pstmt.setInt(3, carro.getAnoLancamento());
            pstmt.setInt(4, carro.getAnoEncerramento());
            pstmt.setString(5, carro.getEstadoConservacao());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt);
        }

    }

    public List<Carro> findAll() {

        String sql = "SELECT * FROM view_sel_car_vei";

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Carro> carros = new ArrayList<>();

        try {

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                Carro carro = new Carro();
                Veiculo veiculo = new Veiculo();
                
                carro.setId(rs.getInt("id_car"));
                carro.setMarca(rs.getString("marca_car"));
                carro.setModelo(rs.getString("modelo_car"));
                carro.setAnoLancamento(rs.getInt("ano_lanc_car"));
                carro.setAnoEncerramento(rs.getInt("ano_enc_car"));
                carro.setEstadoConservacao(rs.getString("estado_conserv_car"));
                veiculo.setNome(rs.getString("nome_vei"));
                veiculo.setCapacidade(rs.getDouble("capacidade_vei"));
                carro.setVeiculo(veiculo);
                carros.add(carro);
            }

        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt, rs);
        }
        return carros;
    }

    public boolean update(Carro carro) {

        String sql = "UPDATE carro SET marca_car = ?, modelo_car = ?, ano_lanc_car = ?, ano_enc_car = ?, estado_conserv_car = ?, id_vei = ? WHERE id_car = ?";

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, carro.getNome());
            pstmt.setDouble(2, carro.getCapacidade());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt);
        }
        
    }
    
    public boolean delete(Carro carro) {

        String q = "DELETE FROM carro WHERE id_car = ?";

        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(q);
            pstmt.setInt(1, carro.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, pstmt);
        }

    }
}
