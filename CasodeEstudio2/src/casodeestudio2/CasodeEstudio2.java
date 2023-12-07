/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casodeestudio2;

import javax.swing.JOptionPane;

/**
 *
 * @author mtorr
 */
public class CasodeEstudio2 {

      public static void main(String[] args) {

        Participante[] participantes = {
            new Participante("Joshua", 100.0),
            new Participante("Greivin", 100.0),
            new Participante("Guillermo", 100.0),
            new Participante("Andres", 100.0),
            new Participante("Tavo", 100.0),
            new Participante("David", 100.0)
        };

        Gastos gastosViajeModificado = new Gastos(participantes);

        int numeroCuenta = 1;

        boolean salir = false;
        while (!salir) {
            String cuenta = " " + numeroCuenta;

            String descripcion = obtenerInput("Descripcion:");

            int cantidadParticipantes = obtenerCantidadParticipantes();

            String nombresParticipantes = obtenerNombresParticipantesJOptionPane(cantidadParticipantes, cuenta);

            String quienPago = obtenerQuienPago(participantes, nombresParticipantes);

            double total = Double.parseDouble(obtenerInput("Monto Total:"));

            realizarDivisionEquitativa(participantes, nombresParticipantes, total);

            System.out.println("Movimiento: Cuenta " + cuenta);
            System.out.println("Descripcion: " + descripcion);
            System.out.println("Participantes: " + nombresParticipantes);
            System.out.println("Quien Pago: " + quienPago);
            System.out.println("Monto total: $" + total);
            System.out.println("Moneda: Dolares");

            mostrarDeudas(participantes, nombresParticipantes, quienPago);

            int opcion = mostrarDialogoContinuar();
            if (opcion == JOptionPane.NO_OPTION) {
                salir = true;
            }

            numeroCuenta++;
        }

        mostrarDialogoPresupuestos(obtenerPresupuestos(participantes));
        gastosViajeModificado.mostrarMovimientos();
    }

    private static String obtenerInput(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    private static int mostrarDialogoContinuar() {
        return JOptionPane.showConfirmDialog(null, "¿Desea agregar otro gasto?", "Continuar", JOptionPane.YES_NO_OPTION);
    }

    private static void mostrarDialogoPresupuestos(String presupuestos) {
        JOptionPane.showMessageDialog(null, "Presupuestos finales:\n" + presupuestos);
    }

    private static int obtenerCantidadParticipantes() {
        String cantidadStr = obtenerInput("Ingrese la cantidad de participantes:");
        return Integer.parseInt(cantidadStr);
    }

    private static String obtenerNombresParticipantesJOptionPane(int cantidad, String cuenta) {
        StringBuilder nombresBuilder = new StringBuilder();

        for (int i = 0; i < cantidad; i++) {
            String nombre = obtenerInput("Ingrese el nombre del participante " + (i + 1) + " en la cuenta " + cuenta);
            nombresBuilder.append(nombre).append(", ");
        }

        return nombresBuilder.toString().trim().replaceAll(",$", "");
    }

    private static String obtenerQuienPago(Participante[] participantes, String nombresParticipantes) {
        String quienPago = "";
        boolean esValido = false;
        while (!esValido) {
            quienPago = obtenerInput("Quien pago la cuenta?");
            for (Participante participante : participantes) {
                if (participante.getNombre().equalsIgnoreCase(quienPago)) {
                    esValido = true;
                    break;
                }
            }
        }
        return quienPago;
    }

    private static void realizarDivisionEquitativa(Participante[] participantes, String nombresParticipantes, double total) {
        String[] nombres = nombresParticipantes.split(", ");
        double divisionEquitativa = total / nombres.length;

        for (Participante participante : participantes) {
            for (String nombre : nombres) {
                if (nombre.trim().equalsIgnoreCase(participante.getNombre())) {
                    participante.reducirPresupuesto(divisionEquitativa);
                }
            }
        }
    }

    private static void mostrarDeudas(Participante[] participantes, String nombresParticipantes, String quienPago) {
        String[] nombres = nombresParticipantes.split(", ");

        for (Participante participante : participantes) {
            for (String nombre : nombres) {
                if (nombre.trim().equalsIgnoreCase(participante.getNombre())) {
                    if (!nombre.equalsIgnoreCase(quienPago)) {
                    }
                }
            }
        }
    }

    private static String obtenerPresupuestos(Participante[] participantes) {
        StringBuilder resultado = new StringBuilder("Nombre\tPresupuesto\n");
        for (Participante participante : participantes) {
            resultado.append(participante.getNombre()).append("\t$").append(participante.getPresupuesto()).append("\n");
        }
        return resultado.toString();
    }
}
