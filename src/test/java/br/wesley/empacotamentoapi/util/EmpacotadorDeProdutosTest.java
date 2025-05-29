package br.wesley.empacotamentoapi.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmpacotadorDeProdutosTest {

    @Test
    void deveEmpacotarProdutosEmCaixas() {
        EmpacotadorDeProdutos.Produto produto1 = new EmpacotadorDeProdutos.Produto("Produto A", 10, 10, 10); // 1000
        EmpacotadorDeProdutos.Produto produto2 = new EmpacotadorDeProdutos.Produto("Produto B", 20, 10, 10); // 2000
        EmpacotadorDeProdutos.Produto produto3 = new EmpacotadorDeProdutos.Produto("Produto C", 30, 10, 10); // 3000

        List<EmpacotadorDeProdutos.Produto> produtos = List.of(produto1, produto2, produto3);
        List<EmpacotadorDeProdutos.Caixa> caixas = EmpacotadorDeProdutos.empacotar(produtos);

        assertEquals(1, caixas.size(), "Espera-se uma única caixa");
        assertEquals(3, caixas.get(0).produtos.size(), "Todos os produtos devem caber na mesma caixa");
    }

    @Test
    void deveCriarCaixaSeparadaParaProdutoGrande() {
        // Volume = 50 * 40 * 40 = 80000 cm³ (dentro do limite de 100000)
        EmpacotadorDeProdutos.Produto produtoGrande = new EmpacotadorDeProdutos.Produto("Geladeira", 50, 40, 40);

        List<EmpacotadorDeProdutos.Produto> produtos = List.of(produtoGrande);
        List<EmpacotadorDeProdutos.Caixa> caixas = EmpacotadorDeProdutos.empacotar(produtos);

        assertNotNull(caixas, "A lista de caixas não deve ser nula");
        assertFalse(caixas.isEmpty(), "A lista de caixas não deve estar vazia");

        EmpacotadorDeProdutos.Caixa caixa = caixas.get(0);
        assertEquals(1, caixas.size(), "Deve haver apenas uma caixa");
        assertEquals(1, caixa.produtos.size(), "A caixa deve conter exatamente 1 produto");
        assertEquals("Geladeira", caixa.produtos.get(0).getNome(), "O produto da caixa deve ser 'Geladeira'");
    }
}
