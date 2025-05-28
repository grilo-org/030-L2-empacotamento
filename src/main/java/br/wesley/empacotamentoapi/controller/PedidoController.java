package br.wesley.empacotamentoapi.controller;

import br.wesley.empacotamentoapi.dto.PedidoDTO;
import br.wesley.empacotamentoapi.service.EmpacotamentoService;
import br.wesley.empacotamentoapi.util.EmpacotadorDeProdutos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "API para empacotar pedidos em caixas")
public class PedidoController {

    @Autowired
    private EmpacotamentoService empacotamentoService;

    @PostMapping("/empacotar")
    @Operation(summary = "Empacotar produtos de um pedido", description = "Retorna as caixas necessárias para empacotar os produtos enviados")
    public ResponseEntity<List<EmpacotadorDeProdutos.Caixa>> empacotar(@RequestBody PedidoDTO pedidoDTO) {
        List<EmpacotadorDeProdutos.Caixa> caixas = empacotamentoService.processarPedido(pedidoDTO);
        return ResponseEntity.ok(caixas);
    }
}
