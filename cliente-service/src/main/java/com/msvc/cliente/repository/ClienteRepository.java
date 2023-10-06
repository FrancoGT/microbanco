package com.msvc.cliente.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.msvc.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
	Optional<Cliente> findById(Long clientId); // Utiliza el nombre de columna personalizado
	@Query("SELECT c FROM Cliente c WHERE c.tipo = 'empresarial'")
    List<Cliente> findAllClientesEmpresariales();
}