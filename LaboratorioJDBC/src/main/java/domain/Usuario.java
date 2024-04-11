package domain;

public class Usuario {
    private int idUsuarios;
    private String usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    

    public Usuario(int idUsuarios, String usuario, String password) {
        this.idUsuarios = idUsuarios;
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario {");
        sb.append("idUsuarios= ").append(idUsuarios);
        sb.append(", usuario= ").append(usuario);
        sb.append(", password= ").append(password);
        sb.append('}');
        return sb.toString();
    }
    
    
}
