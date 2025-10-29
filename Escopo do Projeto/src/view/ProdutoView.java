package view;

import model.Categoria;
import model.Produto;
import repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {
    public static Produto form(Produto produto) {

        Categoria categoria = null;

        do {
            categoria = CategoriaView.select(produto.getCategoria());
        } while (categoria == null);

        String nome = "";

        do {
            nome = JOptionPane.showInputDialog(null, "Informe o Nome do Produto", produto.getNome());
        } while (nome.equals(""));

        String descricao = "";

        do {
            descricao = JOptionPane.showInputDialog(null, "Informe a Descrição do Produto", produto.getDescricao());
        } while (descricao.equals(""));

        double preco = 0;

        do {
            try {
                preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o Preço do Produto", produto.getPreco()));
            } catch (Exception e) {

                preco = 0;
            }
        } while (preco <= 0);

        Produto ret = produto;

        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataDecadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;
    }


    public void sucesso() {
        JOptionPane.showMessageDialog(null, "Produto foi salvo com Sucesso");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto " + produto.getNome() + " salvo com Sucesso!");
    }

    public static Produto select(Produto produto){
        //@formater: off
        Produto ret = (Produto) JOptionPane.showInputDialog(
                null, "Selecione um Produto", "Menu", JOptionPane.QUESTION_MESSAGE,null, ProdutoCollectionRepository.findAll().toArray(),
                produto == null ? 1 : produto);
        return ret;

    }

    public static void update(Produto produto) {
        form(produto);
        sucesso(produto);
        show(produto);
    }

    public static void show(Produto produto) {
        System.out.println(produto);
        String textoFormatado = String.format("PRODUTO: " + produto.getNome() + System.lineSeparator() + "DESCRIÇÃO: " + produto.getDescricao() + System.lineSeparator() + "CATEGORIA: " + produto.getCategoria().toString() + System.lineSeparator() + "PREÇO: %.2f", produto.getPreco());
        JOptionPane.showMessageDialog(null, textoFormatado);
    }
}
