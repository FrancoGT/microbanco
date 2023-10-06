package com.msvc.cliente.exception;
import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable 
{

    // Agregar serialVersionUID
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() 
    {
        super("Recurso no encontrado en el servidor !!!");
    }

    public ResourceNotFoundException(String message) 
    {
        super(message);
    }
}