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

    @Column(name = "role", nullable = false)
    private Permissao role;

    public Usuario() {
    }

    public Usuario(Long usuarioId, String usuario, String senha, Permissao role) {
        this.usuarioId = usuarioId;
        this.usuario = usuario;
        this.senha = senha;
        this.role = role;
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

    public Permissao getRole() {
        return role;
    }

    public void setRole(Permissao role) {
        this.role = role;
    }
}
