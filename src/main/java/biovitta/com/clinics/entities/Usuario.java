package biovitta.com.clinics.entities;

import jakarta.persistence.*;


@Entity
@Table (name ="tb_usuario")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", unique = true)
    private Long usuarioId;  // Não pode ser definido como UUID aqui
    @Column(name = "usuario", unique = true)
    private String usuario;
    @Column(name = "senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String usuario, String senha) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
