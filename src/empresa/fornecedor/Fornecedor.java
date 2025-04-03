package empresa.fornecedor;

public class Fornecedor {
    private String nome;private long cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedor(long cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }

}
