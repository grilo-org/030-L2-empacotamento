package br.wesley.empacotamentoapi.service;

import br.wesley.empacotamentoapi.dto.CaixaDTO;
import br.wesley.empacotamentoapi.dto.PedidoDTO;
import br.wesley.empacotamentoapi.dto.ProdutoDTO;
import br.wesley.empacotamentoapi.util.EmpacotadorDeProdutos;
import br.wesley.empacotamentoapi.util.EmpacotadorDeProdutos.Produto;
import br.wesley.empacotamentoapi.util.EmpacotadorDeProdutos.Caixa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmpacotamentoService {

    public List<CaixaDTO> processarPedido(PedidoDTO pedidoDTO) {
        List<Produto> produtos = new ArrayList<>();
        for (ProdutoDTO dto : pedidoDTO.getProdutos()) {
            produtos.add(new Produto(
                    dto.getNome(),
                    dto.getComprimento(),
                    dto.getLargura(),
                    dto.getAltura()
            ));
        }

        List<Caixa> caixas = EmpacotadorDeProdutos.empacotar(produtos);

        List<CaixaDTO> caixasDTO = new ArrayList<>();
        AtomicInteger contador = new AtomicInteger(1);
        for (Caixa caixa : caixas) {
            List<ProdutoDTO> produtosDTO = new ArrayList<>();
            for (Produto produto : caixa.produtos) {
                produtosDTO.add(new ProdutoDTO(
                        produto.getNome(),
                        produto.getComprimento(),
                        produto.getLargura(),
                        produto.getAltura()
                ));
            }

            caixasDTO.add(new CaixaDTO(
                    contador.getAndIncrement(),
                    caixa.volumeUsado,
                    produtosDTO
            ));
        }

        return caixasDTO;
    }
}
