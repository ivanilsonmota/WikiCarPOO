//package br.com.wikicar.model.teste;
//
//import br.com.wikicar.connection.ConnectionFactory;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import br.com.wikicar.model.bean.Categoria;
//
//public class ProdutoDAO {
//
//    private Connection conn = null;
//
//    public ProdutoDAO() {
//        conn = ConnectionFactory.getConnection();
//    }
//
//    public boolean save(Produto produto) {
//
//        String sql = "INSERT INTO produto (descricao, qtd, valor, categoria_id) VALUES (?,?,?,?)";
//
//        PreparedStatement pstmt = null;
//
//        try {
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, produto.getDescricao());
//            pstmt.setInt(2, produto.getQtd());
//            pstmt.setDouble(3, produto.getValor());
//            pstmt.setInt(4, produto.getCategoria().getId());
//            pstmt.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.err.println("ERROR: " + e);
//            return false;
//        } finally {
//            ConnectionFactory.closeConnection(conn, pstmt);
//        }
//
//    }
//
//    public List<Produto> findAll() {
//
//        String sql = "select * from vw_produtocategoria";
//
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        List<Produto> produtos = new ArrayList<>();
//
//        try {
//
//            pstmt = conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//
//                Produto produto = new Produto();
//
//                produto.setId(rs.getInt("pid"));
//                produto.setDescricao(rs.getString("pdesc"));
//                produto.setQtd(rs.getInt("qtd"));
//                produto.setValor(rs.getDouble("valor"));
//
//                Categoria categoria = new Categoria();
//                categoria.setId(rs.getInt("cid"));
//                categoria.setDescricao(rs.getString("cdesc"));
//
//                produto.setCategoria(categoria);
//
//                produtos.add(produto);
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erro: " + e);
//        } finally {
//            ConnectionFactory.closeConnection(conn, pstmt, rs);
//        }
//
//        return produtos;
//    }
//
//    public boolean update(Produto produto) {
//
//        String sql = "UPDATE produto SET descricao = ?, qtd = ?, valor = ?, categoria_id = ? WHERE id = ?";
//
//        PreparedStatement pstmt = null;
//
//        try {
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, produto.getDescricao());
//            pstmt.setInt(2, produto.getQtd());
//            pstmt.setDouble(3, produto.getValor());
//            pstmt.setInt(4, produto.getCategoria().getId());
//            pstmt.setInt(5, produto.getId());
//            pstmt.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            System.err.println("ERROR: " + e);
//            return false;
//        } finally {
//            ConnectionFactory.closeConnection(conn, pstmt);
//        }
//
//    }
//}
