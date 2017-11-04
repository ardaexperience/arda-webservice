package br.com.ardaexperience.modelo;

public class Cliente {

    private Long id;

    private String cpf;

    private String nome;

    private Contato contato;

    private Endereco endereco;

    private CartaoCredito cartaoCredito;

    private Usuario usuario;

    public Cliente() {
    
    }

    public Cliente(String cpf, String nome, Contato contato, Endereco endereco, 
            CartaoCredito cartaoCredito, Usuario usuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
        this.cartaoCredito = cartaoCredito;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
