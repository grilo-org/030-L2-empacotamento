package br.wesley.empacotamentoapi.dto;

public class ProdutoDTO {

    private String nome;
    private int comprimento;
    private int largura;
    private int altura;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, int comprimento, int largura, int altura) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
