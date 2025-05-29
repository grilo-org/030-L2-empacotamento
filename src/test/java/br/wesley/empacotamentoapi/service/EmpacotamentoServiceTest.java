package br.wesley.empacotamentoapi.service;

import br.wesley.empacotamentoapi.dto.CaixaDTO;
import br.wesley.empacotamentoapi.dto.PedidoDTO;
import br.wesley.empacotamentoapi.dto.ProdutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpacotamentoServiceTest {

    @InjectMocks
    private EmpacotamentoService empacotamentoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveEmpacotarProdutosRetornandoCaixasDTO() {
        ProdutoDTO p1 = new ProdutoDTO("Livro", 10, 5, 2);
        ProdutoDTO p2 = new ProdutoDTO("Mouse", 15, 10, 5);
        PedidoDTO pedido = new PedidoDTO(List.of(p1, p2));

        List<CaixaDTO> caixas = empacotamentoService.processarPedido(pedido);

        assertNotNull(caixas);
        assertFalse(caixas.isEmpty());
        assertEquals(1, caixas.get(0).getNumeroDaCaixa());
        assertTrue(caixas.get(0).getVolumeUsado() > 0);
        assertEquals(2, caixas.get(0).getProdutos().size());
    }
}
