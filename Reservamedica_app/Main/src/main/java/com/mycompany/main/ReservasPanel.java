package com.mycompany.main;

// IMPORTES DE UTILIDADES QUE SE UTILIZARON
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ReservasPanel extends JFrame {
    //DEFINIMOS VARIABLES

    private JTable JTableTablaDatos;
    private JButton JButtonCerrar;
    private ArrayList<Paciente> pacientes;

    // Constructor
    public ReservasPanel(ArrayList<Paciente> pacientes) {
        // Configuración de la ventana
        setLayout(null);
        setTitle("Reservas de Horas Medicas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Boton cerrar
        JButtonCerrar = new JButton("Cerrar");
        JButtonCerrar.setBounds(200, 300, 90, 30);
        add(JButtonCerrar);

        // boton que cierra la ventana actual
        JButtonCerrar.addActionListener(e -> {
            MainPanel mainPanel = new MainPanel(pacientes);
            mainPanel.setVisible(true);
            dispose();
        });

        this.pacientes = pacientes;

        // Metodo para que los datos de las tablas no sean editables
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Colocar las columnas de la tabla
        model.setColumnIdentifiers(new Object[]{"Nombre Medico", "Nombre Paciente", "Especialidad", "Horas Disponibles"});

         // Llenar la tabla con datos de la lista de pacientes
        for (Paciente paciente : pacientes) {
            model.addRow(new Object[]{paciente.getNombreMedico(), paciente.getNombrePaciente(), paciente.getEspecialidad(), paciente.getHorasDisponibles()});

        }

        // Crear la tabla con el modelo de datos
        JTableTablaDatos = new JTable(model);

        // SCROLL PARA LA TABLA
        JScrollPane jScrollPane = new JScrollPane(JTableTablaDatos);
        jScrollPane.setBounds(5, 10, 470, 250);
        add(jScrollPane);
    }
}
