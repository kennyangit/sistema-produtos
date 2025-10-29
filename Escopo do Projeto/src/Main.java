import model.Categoria;
import model.Produto;
import repository.CategoriaCollectionRepository;
import repository.ProdutoCollectionRepository;
import view.CategoriaView;
import view.Opcao;
import view.OpcaoView;
import view.ProdutoView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       Opcao opcao = null;

       do {
           opcao = OpcaoView.select();
           if (opcao == Opcao.CADASTRAR_CATEGORIA){
               cadastrarCategoria();
           }else if(opcao == Opcao.CADASTRAR_PRODUTO) {
               cadastrarProduto();
           }else if (opcao == Opcao.CONSULTAR_PRODUTO_POR_CATEGORIA) {
               consultarProdutoPorCategoria();
           }else if (opcao == Opcao.ENCERRAR_SISTEMA) {
               encerrarOSistema();
           }else if (opcao == Opcao.ALTERAR_PRODUTO) {
               alterarProduto();
           }
       }while (opcao != Opcao.ENCERRAR_SISTEMA);

    }

    private static void alterarProduto() {
        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }

    private static void encerrarOSistema() {
        System.exit(0);
    }

    private static void consultarProdutoPorCategoria() {

        Categoria categoria = CategoriaView.select(null);

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);

        if(produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não encontramos produtos com a categoria: " + categoria.getNome());
        }else {
            produtos.forEach(ProdutoView::show);
            produtos.forEach(System.out::println);
        }
    }

    private static void cadastrarProduto() {
        Produto produto = ProdutoView.form(new Produto());
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    private static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form(new Categoria());
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);

    }



}
