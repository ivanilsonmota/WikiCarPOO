package br.com.wikicar.model.teste;

import br.com.wikicar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.wikicar.model.bean.Categoria;

/**
 * @author Ivanilson P Mota
 */
public class CategoriaDAO {

    private Connection conn = null;

    public CategoriaDAO() {
        conn = ConnectionFactory.getConnection();
    }

	public boolean save(Categoria categoria) {

        String sql = "INSERT INTO categoria (descricao) VALUES (?)";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

    public List<Categoria> findAll() {

        String sql = "SELECT * FROM categoria";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> categorias = new ArrayList<>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }

        return categorias;
    }

    public boolean update(Categoria categoria) {

        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

    public boolean delete(Categoria categoria) {

        String sql = "DELETE FROM categoria WHERE id = ?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoria.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }

    }

}
