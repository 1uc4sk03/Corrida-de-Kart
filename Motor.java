public class Motor {

    private int cilindradas;
    private int cavalos;

    public Motor(int cilindradas, int cavalos) {

        this.cilindradas = cilindradas;
        this.cavalos = cavalos;

    }

    public int getCilindradas() {
        return cilindradas;
    }

    public int getCavalos() {
        return cavalos;
    }

    @Override
    public String toString() {

        return cilindradas + " cc - " + cavalos + " cv";

    }

}