package cuentaservicecontrollertest;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.cuenta.controller.CuentaController;
import com.mvc.cuenta.entity.Cuenta;
import com.mvc.cuenta.service.CuentaService;

// Importa las clases necesarias aquí

public class CuentaControllerTest 
{

    private MockMvc mockMvc;

    @Mock
    private CuentaService cuentaService;

    @InjectMocks
    private CuentaController cuentaController;

    @BeforeEach
    public void setup() 
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(cuentaController).build();
    }

    @Test
    public void testGetAllCuentas() throws Exception 
    {
        // Datos de ejemplo
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setCuentaId(1L);
        cuenta1.setClienteId(101L);
        cuenta1.setTipoCuenta(Cuenta.TipoCuenta.ahorro);
        cuenta1.setComisionMantenimiento(new BigDecimal("10.00"));
        cuenta1.setLimiteMovimientosMensuales(20);
        cuenta1.setDiaMovimiento(5);
        cuenta1.setFechaApertura(new Date());
        cuenta1.setFechaCierre(new Date());
        cuenta1.setSaldoInicial(new BigDecimal("1000.00"));

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setCuentaId(2L);
        cuenta2.setClienteId(102L);
        cuenta2.setTipoCuenta(Cuenta.TipoCuenta.cuenta_corriente);
        cuenta2.setComisionMantenimiento(new BigDecimal("15.00"));
        cuenta2.setLimiteMovimientosMensuales(30);
        cuenta2.setDiaMovimiento(10);
        cuenta2.setFechaApertura(new Date());
        cuenta2.setFechaCierre(new Date());
        cuenta2.setSaldoInicial(new BigDecimal("2000.00"));

        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);

        // Configurar el servicio simulado para devolver las cuentas de ejemplo
        when(cuentaService.getAllCuentas()).thenReturn(cuentas);

        // Realizar la solicitud GET al endpoint
        mockMvc.perform(get("/cuentas"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].cuentaId").value(1))
            .andExpect(jsonPath("$[0].clienteId").value(101))
            .andExpect(jsonPath("$[0].tipoCuenta").value("ahorro"))
            .andExpect(jsonPath("$[0].comisionMantenimiento").value(10.00))
            .andExpect(jsonPath("$[0].limiteMovimientosMensuales").value(20))
            .andExpect(jsonPath("$[0].diaMovimiento").value(5))
            .andExpect(jsonPath("$[0].fechaApertura").exists())
            .andExpect(jsonPath("$[0].fechaCierre").exists())
            .andExpect(jsonPath("$[0].saldoInicial").value(1000.00))
            .andExpect(jsonPath("$[1].cuentaId").value(2))
            .andExpect(jsonPath("$[1].clienteId").value(102))
            .andExpect(jsonPath("$[1].tipoCuenta").value("cuenta_corriente"))
            .andExpect(jsonPath("$[1].comisionMantenimiento").value(15.00))
            .andExpect(jsonPath("$[1].limiteMovimientosMensuales").value(30))
            .andExpect(jsonPath("$[1].diaMovimiento").value(10))
            .andExpect(jsonPath("$[1].fechaApertura").exists())
            .andExpect(jsonPath("$[1].fechaCierre").exists())
            .andExpect(jsonPath("$[1].saldoInicial").value(2000.00));
    }
}