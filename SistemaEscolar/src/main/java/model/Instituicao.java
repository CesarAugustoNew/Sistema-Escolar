package model;

public class Instituicao {

    private String id;
    private String nome;
    private String cnpj;
    private String cidade;
    private String estado;
    private String email;
    private String telefone;

    // Construtor sem ID
    public Instituicao(
            String nome,
            String cnpj,
            String cidade,
            String estado,
            String email,
            String telefone
    ) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
    }

    // Construtor com ID
    public Instituicao(
            String id,
            String nome,
            String cnpj,
            String cidade,
            String estado,
            String email,
            String telefone
    ) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return String.format(
                "Instituição: id=%s - nome=%s - cnpj=%s - cidade=%s - estado=%s - email=%s - telefone=%s",
                id,
                nome,
                cnpj,
                cidade,
                estado,
                email,
                telefone
        );
    }
}