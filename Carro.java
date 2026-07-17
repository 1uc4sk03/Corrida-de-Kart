import javax.swing.JOptionPane;

public class Carro implements Derrapavel {

    private Personagem piloto; // Agregação
    private Motor motor;       // Composição

    private String modelo;
    private double potencia;
    private int numero;

    public Carro(
            Personagem piloto,
            String modelo,
            double potencia,
            int numero) {

        this.piloto = piloto;
        this.modelo = modelo;
        this.potencia = potencia;
        this.numero = numero;

        // Composição
       if (modelo.equals("Kart Padrão")) {

    motor = new Motor(1600, 250);

} else if (modelo.equals("Mach 8")) {

    motor = new Motor(1800, 280);

} else if (modelo.equals("Cat Cruiser")) {

    motor = new Motor(1500, 220);

} else if (modelo.equals("Badwagon")) {

    motor = new Motor(2200, 350);

} else if (modelo.equals("Yoshi Bike")) {

    motor = new Motor(1700, 260);

} else {

    motor = new Motor(1400, 200);

}
    }

    public Personagem getPiloto() {
        return piloto;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public int getNumero() {
        return numero;
    }

    public Motor getMotor() {
        return motor;
    }

    @Override
    public void derrapar() {

        JOptionPane.showMessageDialog(
                null,
                piloto.getNome() + " realizou uma derrapagem!");

    }

    @Override
    public String toString() {

        return "Modelo: " + modelo +
                "\nPotência: " + potencia + " cv" +
                "\nNúmero: " + numero +
                "\nMotor: " + motor +
                "\nPiloto: " + piloto.getNome();

    }

}