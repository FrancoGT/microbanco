package titularfirmantecontrollertest;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.mcvs.titularfirmante.controllers.TitularFirmanteController;
import com.mcvs.titularfirmante.entity.TitularFirmante;
import com.mcvs.titularfirmante.service.TitularFirmanteService;

// Importa las clases necesarias aquí

public class TitularFirmanteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TitularFirmanteService titularFirmanteService;

    @InjectMocks
    private TitularFirmanteController titularFirmanteController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(titularFirmanteController).build();
    }

    @Test
    public void testListarTitularesFirmantes() throws Exception {
        // Datos de ejemplo
        TitularFirmante titular1 = new TitularFirmante();
        titular1.setTitularId(1L);
        titular1.setCuentaId(101L);
        titular1.setClienteId(1001L);
        titular1.setTipoTitular(TitularFirmante.TipoTitular.titular);
        titular1.setFechaInicioVigencia(new Date());
        titular1.setFechaFinVigencia(new Date());

        TitularFirmante titular2 = new TitularFirmante();
        titular2.setTitularId(2L);
        titular2.setCuentaId(102L);
        titular2.setClienteId(1002L);
        titular2.setTipoTitular(TitularFirmante.TipoTitular.firmante);
        titular2.setFechaInicioVigencia(new Date());
        titular2.setFechaFinVigencia(new Date());

        List<TitularFirmante> titularesFirmantes = new ArrayList<>();
        titularesFirmantes.add(titular1);
        titularesFirmantes.add(titular2);

        // Configurar el servicio simulado para devolver los titulares y firmantes de ejemplo
        when(titularFirmanteService.getAllTitularesFirmantes()).thenReturn(titularesFirmantes);

        // Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/titularesfirmantes")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].titularId").value(1))
            .andExpect(jsonPath("$[0].cuentaId").value(101))
            .andExpect(jsonPath("$[0].clienteId").value(1001))
            .andExpect(jsonPath("$[0].tipoTitular").value("titular"))
            .andExpect(jsonPath("$[0].fechaInicioVigencia").exists())
            .andExpect(jsonPath("$[0].fechaFinVigencia").exists())
            .andExpect(jsonPath("$[1].titularId").value(2))
            .andExpect(jsonPath("$[1].cuentaId").value(102))
            .andExpect(jsonPath("$[1].clienteId").value(1002))
            .andExpect(jsonPath("$[1].tipoTitular").value("firmante"))
            .andExpect(jsonPath("$[1].fechaInicioVigencia").exists())
            .andExpect(jsonPath("$[1].fechaFinVigencia").exists());
    }
}
