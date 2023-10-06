package com.msvc.cliente.service;
import com.msvc.cliente.entity.Cliente;
import java.util.List;

public interface ClienteService 
{
	Cliente saveCliente(Cliente cliente);
	List<Cliente> getAllClientes();
	Cliente getCliente(Long clientId);
	List<Cliente> getAllClientesEmpresariales();
}
