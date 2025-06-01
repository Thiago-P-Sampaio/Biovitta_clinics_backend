package biovitta.com.clinics.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name =  "tb_especialidade")
public class Especialidades {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column( name = "especialidade_id", unique = true)
    private Long especialidadeId;
    @Column( name = "nome", unique = true)
    private String nome;

    @ManyToMany( mappedBy = "especialidades")
    private List<Medico> medicos;

    public Especialidades() {
    }

    public Especialidades(Long especialidadeId, String nome) {
        this.especialidadeId = especialidadeId;
        this.nome = nome;
    }

    public Long getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Long especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
