package com.mcvs.productocredito.exception;

@SuppressWarnings("serial")
public class ProductoCreditoNotFoundException extends RuntimeException 
{

    public ProductoCreditoNotFoundException(String message) 
    {
        super(message);
    }

    public ProductoCreditoNotFoundException(String message, Throwable cause) 
    {
        super(message, cause);
    }
}