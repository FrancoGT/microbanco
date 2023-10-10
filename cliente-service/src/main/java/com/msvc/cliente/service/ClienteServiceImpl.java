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
	public Cliente updateCliente(Long clientId, Cliente cliente) 
	{
		Cliente clienteExistente = clienteRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + clientId));

        // Actualiza los campos del cliente existente con los valores proporcionados en el cliente recibido
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setTipo(cliente.getTipo());
        clienteExistente.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setCorreoElectronico(cliente.getCorreoElectronico());

        // Guarda y devuelve el cliente actualizado
        return clienteRepository.save(clienteExistente);
	}

	@Override
	public boolean deleteCliente(Long clientId) 
	{
		if (clienteRepository.existsById(clientId)) 
		{
            clienteRepository.deleteById(clientId);
            return true; // Éxito en la eliminación
        } 
		else 
		{
            return false; // Cliente no encontrado
        }
	}

	
}