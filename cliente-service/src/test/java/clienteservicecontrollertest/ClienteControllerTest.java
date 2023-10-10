package clienteservicecontrollertest;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.msvc.cliente.controllers.ClienteController;
import com.msvc.cliente.entity.Cliente;
import com.msvc.cliente.entity.Cliente.TipoCliente;
import com.msvc.cliente.service.ClienteService;

public class ClienteControllerTest 
{

    private MockMvc mockMvc;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setup() 
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void testListarClientes() throws Exception 
    {
        // Datos de ejemplo
        Cliente cliente1 = new Cliente();
        cliente1.setClientId(1L);
        cliente1.setNombre("Cliente 1");
        cliente1.setTipo(TipoCliente.personal);
        cliente1.setFechaNacimiento(new Date());
        cliente1.setDireccion("Dirección 1");
        cliente1.setTelefono("123456789");
        cliente1.setCorreoElectronico("cliente1@example.com");

        Cliente cliente2 = new Cliente();
        cliente2.setClientId(2L);
        cliente2.setNombre("Cliente 2");
        cliente2.setTipo(TipoCliente.empresarial);
        cliente2.setFechaNacimiento(new Date());
        cliente2.setDireccion("Dirección 2");
        cliente2.setTelefono("987654321");
        cliente2.setCorreoElectronico("cliente2@example.com");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        // Configurar el servicio simulado para devolver los clientes de ejemplo
        when(clienteService.getAllClientes()).thenReturn(clientes);

        // Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/clientes"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].clientId").value(1))
            .andExpect(jsonPath("$[0].nombre").value("Cliente 1"))
            .andExpect(jsonPath("$[0].tipo").value("personal"))
            .andExpect(jsonPath("$[0].fechaNacimiento").exists())
            .andExpect(jsonPath("$[0].direccion").value("Dirección 1"))
            .andExpect(jsonPath("$[0].telefono").value("123456789"))
            .andExpect(jsonPath("$[0].correoElectronico").value("cliente1@example.com"))
            .andExpect(jsonPath("$[1].clientId").value(2))
            .andExpect(jsonPath("$[1].nombre").value("Cliente 2"))
            .andExpect(jsonPath("$[1].tipo").value("empresarial"))
            .andExpect(jsonPath("$[1].fechaNacimiento").exists())
            .andExpect(jsonPath("$[1].direccion").value("Dirección 2"))
            .andExpect(jsonPath("$[1].telefono").value("987654321"))
            .andExpect(jsonPath("$[1].correoElectronico").value("cliente2@example.com"));
    }
}