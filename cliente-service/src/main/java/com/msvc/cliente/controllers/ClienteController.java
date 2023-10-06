package com.msvc.cliente.controllers;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.msvc.cliente.entity.Cliente;
import com.msvc.cliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController 
{
	@Autowired
	private ClienteService clienteService;
	@PostMapping
	public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente clienteRequest)
	{
		Cliente cliente = clienteService.saveCliente(clienteRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	@GetMapping("/clientId/{clientId}")
	public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long clientId)
	{
		Cliente cliente = clienteService.getCliente(clientId);
		return ResponseEntity.ok(cliente);
	}
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes()
	{
		List<Cliente> clientes = clienteService.getAllClientes();
		return ResponseEntity.ok(clientes);
	}
	@GetMapping("/personales")
	public ResponseEntity<List<Cliente>> listarClientesPersonales() 
	{
	    // Obtener una lista de todos los clientes desde el servicio
	    List<Cliente> todosLosClientes = clienteService.getAllClientes();
	    
	    // Utilizar una expresión lambda y streams para filtrar la lista de clientes personales
	    List<Cliente> clientesFiltrados = todosLosClientes.stream()
	            .filter(cliente -> cliente.getTipo().name().equalsIgnoreCase("PERSONAL"))
	            .collect(Collectors.toList());

	    // Crear una respuesta ResponseEntity con la lista de clientes filtrados y devolverla
	    return ResponseEntity.ok(clientesFiltrados);
	}

	@GetMapping("/empresariales")
	public ResponseEntity<List<Cliente>> listarClientesEmpresariales() 
	{
	    // Obtener una lista de todos los clientes desde el servicio
	    List<Cliente> todosLosClientes = clienteService.getAllClientes();
	    
	    // Utilizar una expresión lambda y streams para filtrar la lista de clientes empresariales
	    List<Cliente> clientesFiltrados = todosLosClientes.stream()
	    		.filter(cliente -> cliente.getTipo().name().equalsIgnoreCase("EMPRESARIAL"))
	            .collect(Collectors.toList());

	    // Crear una respuesta ResponseEntity con la lista de clientes filtrados y devolverla
	    return ResponseEntity.ok(clientesFiltrados);
	}


}