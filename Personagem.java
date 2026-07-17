public class Personagem extends Piloto {

    private int velocidade;
    private int aceleracao;
    private int peso;

    public Personagem(
            String nome,
            int velocidade,
            int aceleracao,
            int peso,
            int numero) {

        super(nome, numero);

        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.peso = peso;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getAceleracao() {
        return aceleracao;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String habilidadeEspecial() {

        switch (nome) {

            case "Mario":
                return "Cogumelo";

            case "Luigi":
                return "Super Pulo";

            case "Peach":
                return "Coração Protetor";

            case "Bowser":
                return "Casco Espinhoso";

            case "Yoshi":
                return "Ovo Gigante";

            case "Toad":
                return "Turbo";

            default:
                return "Habilidade desconhecida";
        }

    }

    @Override
    public String toString() {

        return "Personagem: " + nome +
               "\nNúmero: " + numero +
               "\nVelocidade: " + velocidade +
               "\nAceleração: " + aceleracao +
               "\nPeso: " + peso +
               "\nPontos: " + pontos +
               "\nEspecial: " + habilidadeEspecial();

    }

}