package productocreditoservicecontrollertest;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mcvs.productocredito.controllers.ProductoCreditoController;
import com.mcvs.productocredito.entity.ProductoCredito;
import com.mcvs.productocredito.service.ProductoCreditoService;

// Importa las clases necesarias aquí

public class ProductoCreditoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductoCreditoService productoCreditoService;

    @InjectMocks
    private ProductoCreditoController productoCreditoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productoCreditoController).build();
    }

    @Test
    public void testListarTodosLosProductosCredito() throws Exception {
        // Datos de ejemplo
        ProductoCredito producto1 = new ProductoCredito();
        producto1.setCreditoId(1L);
        producto1.setClienteId(101L);
        producto1.setTipoCredito(ProductoCredito.TipoCredito.personal);
        producto1.setTasaInteres(new BigDecimal("0.05"));
        producto1.setPlazo(12);
        producto1.setFechaVencimiento(new Date());

        ProductoCredito producto2 = new ProductoCredito();
        producto2.setCreditoId(2L);
        producto2.setClienteId(102L);
        producto2.setTipoCredito(ProductoCredito.TipoCredito.empresarial);
        producto2.setTasaInteres(new BigDecimal("0.06"));
        producto2.setPlazo(24);
        producto2.setFechaVencimiento(new Date());

        List<ProductoCredito> productosCredito = new ArrayList<>();
        productosCredito.add(producto1);
        productosCredito.add(producto2);

        // Configurar el servicio simulado para devolver los productos de crédito de ejemplo
        when(productoCreditoService.getAllProductosCredito()).thenReturn(productosCredito);

        // Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/productoscredito")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].creditoId").value(1))
            .andExpect(jsonPath("$[0].clienteId").value(101))
            .andExpect(jsonPath("$[0].tipoCredito").value("personal"))
            .andExpect(jsonPath("$[0].tasaInteres").value(0.05))
            .andExpect(jsonPath("$[0].plazo").value(12))
            .andExpect(jsonPath("$[0].fechaVencimiento").exists())
            .andExpect(jsonPath("$[1].creditoId").value(2))
            .andExpect(jsonPath("$[1].clienteId").value(102))
            .andExpect(jsonPath("$[1].tipoCredito").value("empresarial"))
            .andExpect(jsonPath("$[1].tasaInteres").value(0.06))
            .andExpect(jsonPath("$[1].plazo").value(24))
            .andExpect(jsonPath("$[1].fechaVencimiento").exists());
    }
}