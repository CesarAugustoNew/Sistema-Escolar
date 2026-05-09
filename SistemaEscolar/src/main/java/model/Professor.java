package model;

public class Professor {

    private String id;
    private int instituicaoId;
    private String nome;
    private String cpf;
    private String email;
    private String titulacao;

    // Construtor sem ID
    public Professor(int instituicaoId, String nome, String cpf, String email, String titulacao) {
        this.instituicaoId = instituicaoId;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.titulacao = titulacao;
    }

    // Construtor com ID
    public Professor(String id, int instituicaoId, String nome, String cpf, String email, String titulacao) {
        this.id = id;
        this.instituicaoId = instituicaoId;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.titulacao = titulacao;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(int instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String toString() {
        return String.format(
                "Professor: id=%s - instituicaoId=%d - nome=%s - cpf=%s - email=%s - titulacao=%s",
                id, instituicaoId, nome, cpf, email, titulacao
        );
    }
}