import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Corrida {

    // Método estático (requisito do projeto)
    public static final int[] PONTOS = {10, 6, 4};

    // Registrar uma corrida com 3 pilotos
    public void registrarCorrida(
            Personagem primeiro,
            Personagem segundo,
            Personagem terceiro) {

        primeiro.adicionarPontos(PONTOS[0]);
        segundo.adicionarPontos(PONTOS[1]);
        terceiro.adicionarPontos(PONTOS[2]);

    }

    // Sobrecarga
    public void registrarCorrida(List<Personagem> chegada) {

        if (chegada.size() >= 3) {

            registrarCorrida(
                    chegada.get(0),
                    chegada.get(1),
                    chegada.get(2));

        }

    }

    // Simulação aleatória
    public void simularCorrida(List<Personagem> personagens) {

        Collections.shuffle(personagens, new Random());

        registrarCorrida(personagens);

    }

    // Ranking
    public void mostrarRanking(List<Personagem> personagens) {

        Collections.sort(

                personagens,

                Comparator.comparingInt(Personagem::getPontos)

                        .reversed());

    }

    // Retorna ranking em texto
    public String gerarRanking(List<Personagem> personagens) {

        mostrarRanking(personagens);

        StringBuilder texto = new StringBuilder();

        texto.append("===== RANKING =====\n\n");

        int posicao = 1;

        for (Personagem p : personagens) {

            texto.append(posicao)

                    .append("º - ")

                    .append(p.getNome())

                    .append(" - ")

                    .append(p.getPontos())

                    .append(" pontos\n");

            posicao++;

        }

        return texto.toString();

    }

}