package br.ufes.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class Pedido {

    protected Cliente cliente;
    protected double valor;
    protected final double desconto = 0.05;
    protected double valorDesconto;
    protected double valorAPagar;
    protected final ArrayList<ItemPedido> itens = new ArrayList<>();
    protected final LocalDate data;
    protected final LocalDate dataVencimento;

    public Pedido(Cliente cliente, Produto produto, double quantidade, LocalDate data) {
        if (cliente == null) {
            throw new RuntimeException("Informe um cliente válido");
        }
        this.cliente = cliente;
        this.data = data;
        this.dataVencimento = data.plusMonths(1);
        this.addItem(produto, quantidade);
    }

    public final void addItem(Produto produto, double quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException("Informe uma quantidade válida!");
        }
        if (this.getItemPorNome(produto.getNome()).isPresent()) {
            throw new RuntimeException("Produto já existe! Remova-o ou altere a quantidade");
        }
        itens.add(new ItemPedido(produto, quantidade));
        calcularValor();
    }

    protected Optional<ItemPedido> getItemPorNome(String nomeProduto) {
        Optional<ItemPedido> itemEncontrado = Optional.empty();
        for (ItemPedido item : itens) {
            if (item.getProduto().getNome().toLowerCase().equals(nomeProduto.toLowerCase())) {
                itemEncontrado = Optional.of(item);
            }
        }
        return itemEncontrado;
    }

    private void calcularValor() {
        valor = 0;
        for (ItemPedido item : itens) {
            valor += item.getValorItem();
        }
        aplicarDesconto();
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    private void aplicarDesconto() {
        this.valorDesconto = valor * desconto;
        this.valorAPagar = valor - valorDesconto;
    }

    public void removerItem(String nomeProduto) {

        Optional<ItemPedido> produtoEncontrado = getItemPorNome(nomeProduto);
        if (!produtoEncontrado.isPresent()) {
            throw new RuntimeException("Item " + nomeProduto + " não encontrado");
        }

        itens.remove(produtoEncontrado.get());
        calcularValor();
    }

    public LocalDate getData() {
        return data;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String retorno = "--------------- Pedido --------------\n";
        retorno += cliente + "\n";
        retorno += "Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", ";
        retorno += "Data de vencimento: " + dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n";
        retorno += "Valor sem desconto: R$ " + df.format(getValor()) + "\n";
        retorno += "Desconto: R$: " + df.format(valorDesconto) + " (" + desconto * 100 + "%)\n";
        retorno += "Valor a pagar: R$ " + df.format(valorAPagar) + "\n";
        retorno += "Itens do pedido:\n";
        for (ItemPedido item : itens) {
            retorno += "\t- " + item.toString() + "\n";
        }

        return retorno;
    }

}
