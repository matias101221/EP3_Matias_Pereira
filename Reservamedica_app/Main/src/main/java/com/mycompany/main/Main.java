package com.mycompany.main;

import java.util.ArrayList;   // Import de la utilidad ArrayList

public class Main {

    public static void main(String[] args) {
       ArrayList<Paciente> pacientes = new ArrayList<>();  // Crear la lista de pacientes
        MainPanel panel = new MainPanel(pacientes);  // Pasar la lista al constructor
        panel.setVisible(true);  // Hacemos que panel sea visible
    }
}
