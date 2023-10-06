package tarjetacreditoservicecontrollertest;
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

import com.mvc.tarjetacredito.controller.TarjetaCreditoController;
import com.mvc.tarjetacredito.entity.TarjetaCredito;
import com.mvc.tarjetacredito.entity.service.TarjetaCreditoService;

// Importa las clases necesarias aquí

public class TarjetaCreditoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TarjetaCreditoService tarjetaCreditoService;

    @InjectMocks
    private TarjetaCreditoController tarjetaCreditoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tarjetaCreditoController).build();
    }

    @Test
    public void testListarTodasLasTarjetasCredito() throws Exception {
        // Datos de ejemplo
        TarjetaCredito tarjeta1 = new TarjetaCredito();
        tarjeta1.setTarjetaId(1L);
        tarjeta1.setClienteId(101L);
        tarjeta1.setTipoTarjeta(TarjetaCredito.TipoTarjeta.personal);
        tarjeta1.setLimiteCredito(new BigDecimal("5000.00"));
        tarjeta1.setSaldoActual(new BigDecimal("2000.00"));
        tarjeta1.setFechaVencimiento(new Date());
        tarjeta1.setNumeroDeCuotas(6);

        TarjetaCredito tarjeta2 = new TarjetaCredito();
        tarjeta2.setTarjetaId(2L);
        tarjeta2.setClienteId(102L);
        tarjeta2.setTipoTarjeta(TarjetaCredito.TipoTarjeta.empresarial);
        tarjeta2.setLimiteCredito(new BigDecimal("8000.00"));
        tarjeta2.setSaldoActual(new BigDecimal("3000.00"));
        tarjeta2.setFechaVencimiento(new Date());
        tarjeta2.setNumeroDeCuotas(12);

        List<TarjetaCredito> tarjetasCredito = new ArrayList<>();
        tarjetasCredito.add(tarjeta1);
        tarjetasCredito.add(tarjeta2);

        // Configurar el servicio simulado para devolver las tarjetas de crédito de ejemplo
        when(tarjetaCreditoService.getAllTarjetasCredito()).thenReturn(tarjetasCredito);

        // Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/tarjetascredito")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].tarjetaId").value(1))
            .andExpect(jsonPath("$[0].clienteId").value(101))
            .andExpect(jsonPath("$[0].tipoTarjeta").value("personal"))
            .andExpect(jsonPath("$[0].limiteCredito").value(5000.00))
            .andExpect(jsonPath("$[0].saldoActual").value(2000.00))
            .andExpect(jsonPath("$[0].fechaVencimiento").exists())
            .andExpect(jsonPath("$[0].numeroDeCuotas").value(6))
            .andExpect(jsonPath("$[1].tarjetaId").value(2))
            .andExpect(jsonPath("$[1].clienteId").value(102))
            .andExpect(jsonPath("$[1].tipoTarjeta").value("empresarial"))
            .andExpect(jsonPath("$[1].limiteCredito").value(8000.00))
            .andExpect(jsonPath("$[1].saldoActual").value(3000.00))
            .andExpect(jsonPath("$[1].fechaVencimiento").exists())
            .andExpect(jsonPath("$[1].numeroDeCuotas").value(12));
    }
}
