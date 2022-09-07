package com.proyecto.sistemagestion.enums;

public enum Enum_Rol {
    OPERATIVO ("Operativo"),
    ADMINISTRADOR ("Administrador");

    private String name;
    Enum_Rol(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
