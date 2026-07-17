public abstract class Piloto {

    protected String nome;
    protected int numero;
    protected int pontos;

    public Piloto(String nome, int numero) {

        this.nome = nome;
        this.numero = numero;
        this.pontos = 0;

    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int pontos) {

        this.pontos += pontos;

    }

    // Polimorfismo
    public abstract String habilidadeEspecial();

    @Override
    public String toString() {

        return nome + " - " + pontos + " pontos";

    }

}