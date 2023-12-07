/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casodeestudio2;

/**
 *
 * @author mtorr
 */
public class Gastos {
    private Participante[] participantes;
    private StringBuilder movimientos;

    public Gastos(Participante[] participantes) {
        this.participantes = participantes;
        this.movimientos = new StringBuilder();
    }

    public void agregarMovimiento(String movimiento) {
        movimientos.append(movimiento).append("\n");
    }

    public void mostrarMovimientos() {
        System.out.println("Movimientos:\n" + movimientos.toString());
    }
}

