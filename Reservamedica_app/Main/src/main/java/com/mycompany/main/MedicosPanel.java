package com.mycompany.main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MedicosPanel extends JFrame {
    //Se crean variables

    private JLabel Titulo;
    private JLabel JLabeltextoNombreDelMedico;
    private JLabel JLabeltextoNombreDelPaciente;
    private JLabel JLabeltextoEspecialidad;
    private JLabel JLabeltextoHorasDisponibles;
    private JLabel JLabeltextoValorHora;
    private JLabel JLabeltextoCobro;
    private JComboBox<String> JComboBoxseleccionNombreDelMedico;
    private JComboBox<String> JComboBoxseleccionEspecialidad;
    private JComboBox<String> JComboBoxseleccionHorasDisponibles;
    private JTextField JTextFieldcampoNombreDelPaciente;
    private JButton JButtonAceptar;
    private JButton JButtonCerrar;
    private ArrayList<Paciente> pacientes;
    private JFrame frame;

    // Constructor que recibe una lista de pacientes
    public MedicosPanel(ArrayList<Paciente> pacientes) {
        initializeUI();
        this.pacientes = pacientes;
        eventoAceptar();
    }

    // Método para inicializar la interfaz de usuario
    private void initializeUI() {
        setLayout(null);
        setTitle("Ingresa Datos del Medico");
        setSize(440, 327);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

         // Componentes de la interfaz con sus respectivas posiciones y tamaños
        JLabeltextoNombreDelMedico = new JLabel("Nombre del medico: ");
        JLabeltextoNombreDelMedico.setBounds(50, 10, 120, 50);
        add(JLabeltextoNombreDelMedico);

        String[] nombresMedicos = {"Juan meza", "Pedro pascal", "Juan fernandez", "Ricardo arraya", "Magdalena montes", "Isidora goyenechea"};
        JComboBoxseleccionNombreDelMedico = new JComboBox<>(nombresMedicos);
        JComboBoxseleccionNombreDelMedico.setBounds(230, 25, 140, 20);
        add(JComboBoxseleccionNombreDelMedico);

        JLabeltextoNombreDelPaciente = new JLabel("Nombre del paciente: ");
        JLabeltextoNombreDelPaciente.setBounds(50, 50, 140, 50);
        add(JLabeltextoNombreDelPaciente);

        JTextFieldcampoNombreDelPaciente = new JTextField();
        JTextFieldcampoNombreDelPaciente.setBounds(230, 65, 140, 20);
        add(JTextFieldcampoNombreDelPaciente);

        JLabeltextoEspecialidad = new JLabel("Especialidad: ");
        JLabeltextoEspecialidad.setBounds(50, 90, 120, 50);
        add(JLabeltextoEspecialidad);

        String[] Especialidad = {"Medicina General", "Pediatria", "Traumatologia", "Opstamologia", "Ginecologia", "Cardiologia"};
        JComboBoxseleccionEspecialidad = new JComboBox<>(Especialidad);
        JComboBoxseleccionEspecialidad.setBounds(230, 105, 140, 20);
        add(JComboBoxseleccionEspecialidad);

        JLabeltextoHorasDisponibles = new JLabel("Horas Disponibles: ");
        JLabeltextoHorasDisponibles.setBounds(50, 130, 120, 50);
        add(JLabeltextoHorasDisponibles);

        String[] HorasDis = {"10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00"};
        JComboBoxseleccionHorasDisponibles = new JComboBox<>(HorasDis);
        JComboBoxseleccionHorasDisponibles.setBounds(230, 145, 140, 20);
        add(JComboBoxseleccionHorasDisponibles);

        JLabeltextoValorHora = new JLabel("Valor Hora: ");
        JLabeltextoValorHora.setBounds(50, 170, 120, 50);
        add(JLabeltextoValorHora);

        JLabeltextoCobro = new JLabel("$7.000");
        JLabeltextoCobro.setBounds(120, 170, 120, 50);
        add(JLabeltextoCobro);

        // Botones para Aceptar y Cerrar
        JButtonAceptar = new JButton("Aceptar");
        JButtonAceptar.setBounds(110, 220, 100, 40);
        add(JButtonAceptar);

        JButtonCerrar = new JButton("Cerrar");
        JButtonCerrar.setBounds(230, 220, 100, 40);
        add(JButtonCerrar);
    }

    // Método para configurar el evento del botón "Aceptar"
    private void eventoAceptar() {
        JButtonAceptar.addActionListener(e -> {
            // Obtener datos ingresados por el usuario
            String nombreMedico = JComboBoxseleccionNombreDelMedico.getSelectedItem().toString();
            String nombrePaciente = JTextFieldcampoNombreDelPaciente.getText();
            String especialidad = JComboBoxseleccionEspecialidad.getSelectedItem().toString();
            String horaSeleccionada = JComboBoxseleccionHorasDisponibles.getSelectedItem().toString();

             // Crear un nuevo objeto Paciente y agregarlo a la lista
            Paciente nuevoPaciente = new Paciente(nombrePaciente, nombreMedico, especialidad, horaSeleccionada);
            nuevoPaciente.getNombreMedico();
            nuevoPaciente.getEspecialidad();
            nuevoPaciente.getHorasDisponibles();

            pacientes.add(nuevoPaciente);

            // Limpiar el campo de nombre del paciente
            JTextFieldcampoNombreDelPaciente.setText("");
            
            // Mostrar un mensaje con los detalles del paciente
            MessageAceptarMedicosPanel.showMessage(nombreMedico, especialidad, horaSeleccionada, nombrePaciente);

        });

        this.frame = new JFrame();
        frame.setVisible(true);

         // Configurar el evento del botón "Cerrar"
        JButtonCerrar.addActionListener(e -> {
            MainPanel mainPanel = new MainPanel(pacientes);
            mainPanel.setVisible(true);
            dispose();
        });
    }
}
