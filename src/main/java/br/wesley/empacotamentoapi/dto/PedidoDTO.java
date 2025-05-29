package br.wesley.empacotamentoapi.dto;

import java.util.List;

public class PedidoDTO {

    private List<ProdutoDTO> produtos;

    public PedidoDTO() {

    }

    public PedidoDTO(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
