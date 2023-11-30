package com.mycompany.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ReservasPanel extends JFrame {

    private JTable JTableTablaDatos;
    private JButton JButtonCerrar;
    private ArrayList<Paciente> pacientes;

    public ReservasPanel(ArrayList<Paciente> pacientes) {
        setLayout(null);
        setTitle("Reservas de Horas Medicas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButtonCerrar = new JButton("Cerrar");
        JButtonCerrar.setBounds(200, 300, 90, 30);
        add(JButtonCerrar);

        JButtonCerrar.addActionListener(e -> {
            MainPanel mainPanel = new MainPanel(pacientes);
            mainPanel.setVisible(true);
            dispose();
        });

        this.pacientes = pacientes;

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.setColumnIdentifiers(new Object[]{"Nombre Medico", "Nombre Paciente", "Especialidad", "Horas Disponibles"});

        for (Paciente paciente : pacientes) {
            model.addRow(new Object[]{paciente.getNombreMedico(), paciente.getNombrePaciente(), paciente.getEspecialidad(), paciente.getHorasDisponibles()});

        }

        JTableTablaDatos = new JTable(model);

        JScrollPane jScrollPane = new JScrollPane(JTableTablaDatos);
        jScrollPane.setBounds(5, 10, 470, 250);
        add(jScrollPane);
    }
}
