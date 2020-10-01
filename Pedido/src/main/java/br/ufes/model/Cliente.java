package br.ufes.model;

public final class Cliente {

    private final String nome;
    private final String CNPJOuCPF;

    public Cliente(String nome, String codigo) {
        this.nome = nome;
        this.CNPJOuCPF = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCNPJOuCPF() {
        return CNPJOuCPF;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CNPJ/CPF = " + CNPJOuCPF;
    }

}
