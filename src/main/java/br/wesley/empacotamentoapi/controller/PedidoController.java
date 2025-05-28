package br.wesley.empacotamentoapi.controller;

import br.wesley.empacotamentoapi.dto.PedidoDTO;
import br.wesley.empacotamentoapi.service.EmpacotamentoService;
import br.wesley.empacotamentoapi.util.EmpacotadorDeProdutos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "API para empacotar pedidos em caixas")
public class PedidoController {

    @Autowired
    private EmpacotamentoService empacotamentoService;

    // Armazena as caixas processadas do último pedido
    private final List<EmpacotadorDeProdutos.Caixa> caixasProcessadas = new ArrayList<>();

    @PostMapping("/empacotar")
    @Operation(summary = "Empacotar produtos de um pedido", description = "Retorna as caixas necessárias para empacotar os produtos enviados")
    public ResponseEntity<List<EmpacotadorDeProdutos.Caixa>> empacotar(@RequestBody PedidoDTO pedidoDTO) {
        caixasProcessadas.clear(); // Limpa antes de processar novo pedido
        caixasProcessadas.addAll(empacotamentoService.processarPedido(pedidoDTO));
        return ResponseEntity.ok(caixasProcessadas);
    }

    @GetMapping("/caixas")
    @Operation(summary = "Listar caixas empacotadas", description = "Retorna as caixas geradas no último pedido processado")
    public ResponseEntity<List<EmpacotadorDeProdutos.Caixa>> listarCaixasEmpacotadas() {
        return ResponseEntity.ok(caixasProcessadas);
    }
}
