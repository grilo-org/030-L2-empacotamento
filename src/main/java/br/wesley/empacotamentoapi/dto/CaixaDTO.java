package br.wesley.empacotamentoapi.dto;

import java.util.List;

public class CaixaDTO {

    private int numeroDaCaixa;
    private int volumeUsado;
    private List<ProdutoDTO> produtos;

    public CaixaDTO() {
    }

    public CaixaDTO(int numeroDaCaixa, int volumeUsado, List<ProdutoDTO> produtos) {
        this.numeroDaCaixa = numeroDaCaixa;
        this.volumeUsado = volumeUsado;
        this.produtos = produtos;
    }

    public int getNumeroDaCaixa() {
        return numeroDaCaixa;
    }

    public void setNumeroDaCaixa(int numeroDaCaixa) {
        this.numeroDaCaixa = numeroDaCaixa;
    }

    public int getVolumeUsado() {
        return volumeUsado;
    }

    public void setVolumeUsado(int volumeUsado) {
        this.volumeUsado = volumeUsado;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}