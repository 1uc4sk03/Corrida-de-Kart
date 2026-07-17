import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class MarioKartSelecao {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Mario Kart");

        janela.setSize(700, 500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new FlowLayout());

        // ===============================
        // PERSONAGENS
        // ===============================

        List<Personagem> personagens = new ArrayList<>();

        personagens.add(new Personagem("Mario", 8, 7, 6, 1));
        personagens.add(new Personagem("Luigi", 7, 8, 5, 2));
        personagens.add(new Personagem("Peach", 6, 9, 4, 3));
        personagens.add(new Personagem("Bowser", 10, 4, 10, 4));
        personagens.add(new Personagem("Yoshi", 7, 7, 5, 5));
        personagens.add(new Personagem("Toad", 5, 10, 3, 6));

        String[] nomes = {

                "Mario",
                "Luigi",
                "Peach",
                "Bowser",
                "Yoshi",
                "Toad"

        };

        JComboBox<String> personagensBox = new JComboBox<>(nomes);

        JButton selecionar = new JButton("Selecionar");

        JButton derrapar = new JButton("Derrapar");

        JButton btnCorrida = new JButton("Simular Corrida");

        JTextArea area = new JTextArea(15, 30);

        area.setEditable(false);

        JLabel imagem = new JLabel();

        JScrollPane scroll = new JScrollPane(area);

        janela.add(personagensBox);

        janela.add(selecionar);

        janela.add(derrapar);

        janela.add(btnCorrida);

        janela.add(imagem);

        janela.add(scroll);

        // Guarda o carro selecionado
        final Carro[] carroAtual = new Carro[1];

        Corrida campeonato = new Corrida();

        // ===============================
// BOTÃO SELECIONAR
// ===============================

selecionar.addActionListener(e -> {

    int escolha = personagensBox.getSelectedIndex();

    Personagem selecionado = personagens.get(escolha);

    // Carrega a imagem do personagem
    ImageIcon icon = new ImageIcon(
            "imagens/" + selecionado.getNome().toLowerCase() + ".png");

    Image img = icon.getImage().getScaledInstance(
            180,
            180,
            Image.SCALE_SMOOTH);

    imagem.setIcon(new ImageIcon(img));

    // Cria o kart correspondente
    if (selecionado.getNome().equals("Mario")) {

        carroAtual[0] = new Carro(
                selecionado,
                "Kart Padrão",
                150,
                11);

    } else if (selecionado.getNome().equals("Luigi")) {

        carroAtual[0] = new Carro(
                selecionado,
                "Mach 8",
                160,
                22);

    } else if (selecionado.getNome().equals("Peach")) {

        carroAtual[0] = new Carro(
                selecionado,
                "Cat Cruiser",
                140,
                33);

    } else if (selecionado.getNome().equals("Bowser")) {

        carroAtual[0] = new Carro(
                selecionado,
                "Badwagon",
                180,
                44);

    } else if (selecionado.getNome().equals("Yoshi")) {

        carroAtual[0] = new Carro(
                selecionado,
                "Yoshi Bike",
                155,
                55);

    } else {

        carroAtual[0] = new Carro(
                selecionado,
                "Pipe Frame",
                145,
                66);

    }

    area.setText(

            "===== PERSONAGEM =====\n\n"

                    + "Nome: " + selecionado.getNome()

                    + "\nEspecial: " + selecionado.habilidadeEspecial()

                    + "\nVelocidade: " + selecionado.getVelocidade()

                    + "\nAceleração: " + selecionado.getAceleracao()

                    + "\nPeso: " + selecionado.getPeso()

                    + "\nPontos: " + selecionado.getPontos()

                    + "\n\n===== KART =====\n\n"

                    + carroAtual[0]);

});
// ===============================
// BOTÃO DERRAPAR
// ===============================

derrapar.addActionListener(e -> {

    if (carroAtual[0] != null) {

        carroAtual[0].derrapar();

    } else {

        JOptionPane.showMessageDialog(
                janela,
                "Selecione um personagem primeiro!");

    }

});

// ===============================
// BOTÃO SIMULAR CORRIDA
// ===============================

btnCorrida.addActionListener(e -> {

    campeonato.simularCorrida(personagens);

    String ranking = campeonato.gerarRanking(personagens);

    area.setText(
            "🏁 RESULTADO DA CORRIDA 🏁\n\n"
                    + ranking);

});

// ===============================
// EXIBIR JANELA
// ===============================

janela.setLocationRelativeTo(null);

janela.setVisible(true);

    }

}