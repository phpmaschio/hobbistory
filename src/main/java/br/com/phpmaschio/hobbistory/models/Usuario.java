package br.com.phpmaschio.hobbistory.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false, length = 50)
    @Max(value = 50, message = "login deve conter no máximo 50 caracteres")
    @Max(value = 3, message = "login deve conter no minimo 3 caracteres")
    @NotBlank(message = "O campo login não pode ser em branco")
    @NotNull(message = "O campo login é obrigatório")
    private String login;

    @Column(name = "criado_em", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime criadoEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public List<Passatempo> getPassatempos() {
        return passatempos;
    }

    public void setPassatempos(List<Passatempo> passatempos) {
        this.passatempos = passatempos;
    }

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Passatempo> passatempos;

    
}
