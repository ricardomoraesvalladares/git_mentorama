package br.com.hospital.hospital.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    @NotNull
    private String nome;

    private String departamento;
    private String cargo;

    @Column(length = 11)
    private String telefone;

    @OneToMany(mappedBy = "profissional")
    private List<Internacao> interrnacoes;

    protected Profissional(){}

    public Profissional(String nome, String departamento, String cargo, String telefone) {
        this.nome = nome;
        this.departamento = departamento;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Profissional{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", departamento='" + departamento + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
