package br.wesley.empacotamentoapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "Pedidos", description = "Endpoints relacionados ao empacotamento de pedidos")
public class PedidoController {

    @GetMapping("/teste")
    @Operation(summary = "Endpoint de teste", description = "Retorna uma mensagem de confirmação de funcionamento do Swagger")
    public ResponseEntity<String> testar() {
        return ResponseEntity.ok("Swagger funcionando!");
    }
}
