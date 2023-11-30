
package com.mycompany.main;

public class Paciente {
    //Se definen variables
    private String nombrePaciente;
    private String nombreMedico;
    private String especialidad;
    private String horasDisponibles;

    //CONSTRUCTOR
    public Paciente(String nombrePaciente, String nombreMedico, String especialidad, String horasDisponibles) {
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.horasDisponibles = horasDisponibles;
    }
    
    //GETER AND SETER PARA TRAER Y SETEAR DATOS

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorasDisponibles() {
        return horasDisponibles;
    }

    public void setHorasDisponibles(String horasDisponibles) {
        this.horasDisponibles = horasDisponibles;
    }
    
    
   
}