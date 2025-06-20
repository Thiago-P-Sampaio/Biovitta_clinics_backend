package biovitta.com.clinics.DTOs;

import biovitta.com.clinics.entities.Medico;
import jakarta.persistence.Column;

import java.util.List;
import java.util.stream.Collectors;

public class MedicoDTO {

    private String crm;
    private String nome;
    private String email;
    private String telefone;
    private String imgUrl;
    private String especialidades;

    public MedicoDTO() {
    }

    public MedicoDTO(String crm, String nome, String email, String telefone, String imgUrl, String  especialidades) {
        this.crm = crm;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.imgUrl = imgUrl;
        this.especialidades = especialidades;
    }

    public  MedicoDTO(Medico entity){
        crm = entity.getCrm();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        imgUrl = entity.getImgUrl();
        especialidades = entity.getEspecialidades();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
}
