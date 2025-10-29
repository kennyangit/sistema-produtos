package view;

import javax.swing.*;

public class OpcaoView {
    public static Opcao select(){

        Opcao ret = (Opcao) JOptionPane.showInputDialog(
          null, // componente pai. Como não temos será null
                "Selecione uma opção",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, // icone
                Opcao.values(), // numero da opção
                Opcao.CADASTRAR_PRODUTO);
        return ret != null ? ret : Opcao.ENCERRAR_SISTEMA;
    }
}
