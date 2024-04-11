package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT id_usuarios, usuario, password FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET usuario = ?, password = ? WHERE id_usuarios = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuarios = ?";
    
    
    public List<Usuario> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idUsuario = rs.getInt("id_usuarios");
                String user = rs.getString("usuario");
                String password = rs.getString("password");
                usuario = new Usuario(idUsuario, user, password);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }
    
    public int insert(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuario()); //Aca el metodo getUsuario va ahi ya que como segundo parametro de setString va el valor que quiera agregar, por ende el metodo getUsuario va a devolver lo que puse con usuario en el parametro que pase en el metodo insert
            stmt.setString(2, usuario.getPassword());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
             
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }
    
    public int update(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuarios());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registros;
    }
    
    public void delete(int idPersona){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn= getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idPersona);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
