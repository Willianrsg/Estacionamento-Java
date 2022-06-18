package Data;

import DB.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Willian
 */

public class MovimentacaoDao {
    Connection conn;
    Statement st;
    
        
    public boolean conectar(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/estacionamento", "root", "");
            st = conn.createStatement();
            
            return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        } 
        
       
    }
    
    public boolean salvar(Movimentacao movimentacao){
        
        DateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formataHora = new SimpleDateFormat("HH:mm");
        
        
        try {
            String sql;
                   //INSERT INTO tbl_movimentacao ( placa, modelo, data_entrada, hora_entrada) 
                   //VALUES ('gho-9087', 'Fusion', 2022-06-17, '12:01')    
            sql = "INSERT INTO tbl_movimentacao ( placa, modelo, data_entrada) VALUES('"
                    + movimentacao.getPlaca() + "','"
                    + movimentacao.getModelo() +"','"
                    + formataData.format(movimentacao.getData_entrada())+"'"
                    + ")";
                    //+"')";
            
            st.executeUpdate(sql);
             
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no insert "+ex, "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            
        }
    }
    
    
    public List<Movimentacao> listar(){
        
        List<Movimentacao> movimentacoes = new ArrayList<>();
        
        Connection conn = Conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try{
            pstm = conn.prepareStatement("SELECT * FROM tbl_movimentacao");
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Movimentacao movimentacao = new Movimentacao();
                
                movimentacao.setId_movimentacao(rs.getInt("id_movimentacao"));
                movimentacao.setPlaca(rs.getString("placa"));
                movimentacao.setModelo(rs.getString("modelo"));
                movimentacao.setData_entrada(rs.getDate("data_entrada"));
                movimentacao.setHora_entrada(rs.getTime("hora_entrada"));
             
                
                
                movimentacoes.add(movimentacao);
            }
        
        }catch(SQLException ErroSql){
            JOptionPane.showMessageDialog(null,"Erro ao listar dados: "+ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        finally{
             Conexao.closeConnection(conn, pstm, rs);
        }
        
        return movimentacoes;
    }

    public void alterar(Movimentacao movimentacao){
        
        try {
            //Objeto connection onde estamos conectando com o banco de dados
            conn = Conexao.getConnection();
            PreparedStatement pstm = null;
            
            pstm = conn.prepareStatement("UPDATE tbl_movimentacao SET placa=?, modelo=? WHERE id_movimentacao=? ");
            
            pstm.setString(1,movimentacao.getPlaca());
            pstm.setString(2,movimentacao.getModelo());
            pstm.setInt(3,movimentacao.getId_movimentacao());
           
            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Dados do Veículo alterados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar dados no banco de dados: "+ErroSql, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        finally{
             Conexao.closeConnection(conn);
        }
    }
    
    public void saida(Movimentacao movimentacao){
        
    }
    
  
}







































