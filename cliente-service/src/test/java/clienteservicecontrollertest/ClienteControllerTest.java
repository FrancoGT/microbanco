package clienteservicecontrollertest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.msvc.cliente.ClienteServiceApplication;
import com.msvc.cliente.controllers.ClienteController;
import com.msvc.cliente.entity.Cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@SpringBootTest(classes = ClienteServiceApplication.class)
public class ClienteControllerTest 
{
    @Autowired
    private ClienteController clienteController;

    @Test
    public void testListarClientes() 
    {
        ResponseEntity<List<Cliente>> response = clienteController.listarClientes();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue()); // Verifica que la respuesta sea un código 200 (OK)
        assertNotNull(response.getBody()); // Verifica que el cuerpo de la respuesta no sea nulo
        // Puedes realizar más aserciones según tu lógica de negocio
    }
}