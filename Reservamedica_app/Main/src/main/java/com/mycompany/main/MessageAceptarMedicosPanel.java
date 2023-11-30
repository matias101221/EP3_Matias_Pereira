package com.mycompany.main;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MessageAceptarMedicosPanel {

    public static void showMessage(String nombreMedico, String especialidad, String horaSeleccionada, String nombrePaciente) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null,
                    "Seleccionaste:\nNombre Médico: " + nombreMedico
                            + "\nEspecialidad: " + especialidad
                            + "\nHora Disponible: " + horaSeleccionada
                            + "\nNombre Paciente: " + nombrePaciente,
                    "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
}