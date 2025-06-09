package biovitta.com.clinics.DTOs.login;

import biovitta.com.clinics.entities.Usuario;

public class BuscarUsuarioLogadoDTO {

    private String usuario;
    private String role;

    public BuscarUsuarioLogadoDTO() {}

    public BuscarUsuarioLogadoDTO(String usuario, String role) {
        this.usuario = usuario;
        this.role = role;
    }

    public BuscarUsuarioLogadoDTO(Usuario entity) {
        usuario = entity.getUsuario();
        role = entity.getRole().toString();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRole() {
        return role;
    }
}
