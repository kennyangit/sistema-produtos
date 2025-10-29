package view;
import model.Categoria;
import repository.CategoriaCollectionRepository;
import javax.swing.*;

public class CategoriaView {

    static CategoriaCollectionRepository repository;

    public static Categoria select(Categoria categoria){
        //@formater: off
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null, "Selecione uma categoria", "Menu", JOptionPane.QUESTION_MESSAGE,null,repository.findAll().toArray(),
                categoria == null ? 1 : categoria);
        return ret;

    }

    public void sucesso() {
        JOptionPane.showMessageDialog(null,"Categoria foi salva com Sucesso");
    }

    public void sucesso(Categoria categoria) {
        JOptionPane.showMessageDialog(null,"Categoria " + categoria + " foi salva com Sucesso");
    }

    public static Categoria form(Categoria categoria) {
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da categoria: ", categoria != null ? categoria.getNome() : "");
        return new Categoria(nome);
    }


}
