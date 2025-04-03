package empresa.util;

import empresa.produto.Produto;
import empresa.fornecedor.Fornecedor;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class Util {

    private Produto[] produto = new Produto[2];
    private Fornecedor[] fornecedor = new Fornecedor[2];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    public void menu(){
        int opcao;
        String menu = "1. Cadastrar Produto \n2. Pesquisar produto por nome \n" +
                "3. Pesquisar fornecedor por CNPJ \n4. Finalizar";

        while(true){
            opcao = parseInt(showInputDialog(menu));
            if(opcao == 4){
                return;
            }
            switch (opcao){
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisarFornecedor();
                    break;
                default:
                    showInputDialog(null, "Opção invalida");
                    break;
            }

        }

    }

    private void cadastrarProduto(){
        String nome;
        int quantiadadeEstoque;
        double valor;
        Fornecedor fornecedor = pesquisarFornecedor();
        if(fornecedor == null){
            fornecedor= cadastrarFornecedor();
        }
        nome = showInputDialog("Nome do produto");
        quantiadadeEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        valor = parseDouble(showInputDialog("Valor unitário"));
        produto[idxProduto] = new Produto(valor, nome, quantiadadeEstoque, fornecedor);
        idxProduto++;
    }

    private void pesquisarProduto(){
        String aux = "Produto não encontrado";
        String nome = showInputDialog("Nome do Produto");
        for(int i=0; i<idxProduto; i++){
            if (produto[i].getNome().equalsIgnoreCase(nome)){
                aux = "";
                aux += "Nome do produto: " + nome + "\n";
                aux += "Valor unitário: R$ " + produto[i].getValor() + "\n";
                aux += "Quantidade de produtos: " + produto[i].getQuantidade() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome() + "\n";
            }
        }
        showMessageDialog(null, aux);
    }

    //Vai retornar o Objeto
    private Fornecedor pesquisarFornecedor(){
        long cnpj = parseLong(showInputDialog("CNPJ do Fornecedor: "));
        for (int i=0; i<idxFornecedor; i++){
            if (fornecedor[i].getCnpj() == cnpj){
                return fornecedor[i];
            }
        }
        showMessageDialog(null, "CNPJ não cadastrado");
        return null;
    }

    private Fornecedor cadastrarFornecedor(){
        long cnpj = parseLong(showInputDialog("CNPJ do fornecedor"));
        String nome = showInputDialog("Nome");
        fornecedor[idxFornecedor] = new Fornecedor(cnpj, nome);
        idxFornecedor++;
        return fornecedor[idxFornecedor-1];
    }
}
