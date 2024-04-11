package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestUsuariosDAO {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
//        Usuario usuarioInsert = new Usuario("LeoMessi", "goat");
//        usuarioDAO.insert(usuarioInsert);

        Usuario userActualizado = new Usuario(1, "mateocava1", "123.123");
        usuarioDAO.update(userActualizado);
        
        List<Usuario> usuarios = usuarioDAO.select();
        usuarios.forEach(usuario -> {
            System.out.println("usuario" + usuario);
        });
    
    
    }
        
}
