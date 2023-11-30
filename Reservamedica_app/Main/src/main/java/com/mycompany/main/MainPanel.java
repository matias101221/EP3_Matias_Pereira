package com.mycompany.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JLabel;

// Constructor que recibe una lista de pacientes
public class MainPanel extends JFrame {
    private JLabel Titulo;
    private JButton JButtonMedico;
    private JButton JButtonReservas;
    private JButton JButtonCerrar;
    private ArrayList<Paciente> pacientes;
    
    
    // Método para inicializar la interfaz de usuario
    public MainPanel(ArrayList<Paciente> pacientes) {
        setLayout(null);
        setTitle("Reserva de Horas Médicas");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Etiqueta del título
        Titulo = new JLabel("Reserva De Hora Medica");
        Titulo.setBounds(140, -60, 200, 200);
        add(Titulo);

        // Botón para acceder a la sección de médicos
        JButtonMedico = new JButton("Medico");
        JButtonMedico.setBounds(30, 100, 100, 45);
        add(JButtonMedico);

        // Botón para acceder a la sección de reservas
        JButtonReservas = new JButton("Reservas");
        JButtonReservas.setBounds(150, 100, 100, 45);
        add(JButtonReservas);

        // Botón para cerrar la aplicación
        JButtonCerrar = new JButton("Cerrar");
        JButtonCerrar.setBounds(270, 100, 100, 45);
        add(JButtonCerrar);
        JButtonCerrar.addActionListener(e -> System.exit(0));

        this.pacientes = pacientes;

        // Acción asociada al botón "Medico" para abrir la sección de médicos
        JButtonMedico.addActionListener(e -> {
            MedicosPanel panelMedicosPanel = new MedicosPanel(pacientes);
            panelMedicosPanel.setVisible(true);
        });

        // Acción asociada al botón "Reservas" para abrir la sección de reservas
        JButtonReservas.addActionListener(e -> {
            ReservasPanel reservasPanel = new ReservasPanel(pacientes);
            reservasPanel.setVisible(true);
        });
    }
}