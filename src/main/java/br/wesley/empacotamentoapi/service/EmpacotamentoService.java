package br.wesley.empacotamentoapi.service;

import br.wesley.empacotamentoapi.dto.PedidoDTO;
import br.wesley.empacotamentoapi.dto.ProdutoDTO;
import br.wesley.empacotamentoapi.util.EmpacotadorDeProdutos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpacotamentoService {

    public List<EmpacotadorDeProdutos.Caixa> processarPedido(PedidoDTO pedidoDTO) {
        List<EmpacotadorDeProdutos.Produto> produtos = new ArrayList<>();

        for (ProdutoDTO dto : pedidoDTO.getProdutos()) {
            produtos.add(new EmpacotadorDeProdutos.Produto(
                    dto.getNome(),
                    dto.getComprimento(),
                    dto.getLargura(),
                    dto.getAltura()
            ));
        }

        return EmpacotadorDeProdutos.empacotar(produtos);
    }
}
