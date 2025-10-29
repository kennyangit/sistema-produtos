package repository;

import model.Categoria;
import model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

public class ProdutoCollectionRepository {
    private static List<Produto> produtos;

    static {
        produtos = new Vector<>();

        Produto celular = new Produto();
        celular.setNome("Iphone 14 Pro Max")
                .setDescricao("Aparelho Apple")
                .setCategoria(CategoriaCollectionRepository.findByID(2l))
                .setDataDecadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(12000));

        save(celular);
    }

    public static List<Produto>findAll() {
        return produtos;
    }

    public static Produto save(Produto produto) {

        if(!produtos.contains(produto)){
            produto.setId((long)produtos.size() + 1);
            produtos.add(produto);

            return produto;
        }else {
            JOptionPane.showMessageDialog(null, "Já existe produto cadastrado com o mesmo nome");
            return null;
        }

    }

    public static Produto findbyId(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Produto> findByCategoria(Categoria categoria) {

        return produtos.stream().filter(p->p.getCategoria().equals(categoria)).toList();
    }
}
