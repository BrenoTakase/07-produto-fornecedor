package empresa.produto;
import empresa.fornecedor.Fornecedor;

public class Produto {
    private String nome;
    private double valor;
    private int quantidade;
    private Fornecedor fornecedor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(double valor, String nome, int quantidade, Fornecedor fornecedor) {
        this.valor = valor;
        this.nome = nome;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }


}

