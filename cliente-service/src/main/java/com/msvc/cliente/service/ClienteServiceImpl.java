package com.msvc.cliente.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msvc.cliente.entity.Cliente;
import com.msvc.cliente.exception.ResourceNotFoundException;
import com.msvc.cliente.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService
{
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente saveCliente(Cliente cliente) 
	{
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> getAllClientes() 
	{
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getCliente(Long clientId) 
	{
		return clienteRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + clientId));
	}

	@Override
	public List<Cliente> getAllClientesEmpresariales() 
	{
		 return clienteRepository.findAllClientesEmpresariales();
	}
	
}