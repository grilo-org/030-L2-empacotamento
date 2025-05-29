package br.wesley.empacotamentoapi.util;

import java.util.ArrayList;
import java.util.List;

public class EmpacotadorDeProdutos {

    private static final int COMPRIMENTO_CAIXA = 30;
    private static final int LARGURA_CAIXA = 30;
    private static final int ALTURA_CAIXA = 30;
    private static final int VOLUME_CAIXA = COMPRIMENTO_CAIXA * LARGURA_CAIXA * ALTURA_CAIXA;

    public static class Produto {
        private String nome;
        private int comprimento;
        private int largura;
        private int altura;

        public Produto(String nome, int comprimento, int largura, int altura) {
            this.nome = nome;
            this.comprimento = comprimento;
            this.largura = largura;
            this.altura = altura;
        }

        public int getVolume() {
            return comprimento * largura * altura;
        }

        public String getNome() {
            return nome;
        }

        public int getComprimento() {
            return comprimento;
        }

        public int getLargura() {
            return largura;
        }

        public int getAltura() {
            return altura;
        }

        @Override
        public String toString() {
            return nome + " (" + comprimento + "x" + largura + "x" + altura + ")";
        }
    }

    public static class Caixa {
        public List<Produto> produtos = new ArrayList<>();
        public int volumeUsado = 0;

        public boolean adicionarProduto(Produto produto) {
            if (volumeUsado + produto.getVolume() <= VOLUME_CAIXA) {
                produtos.add(produto);
                volumeUsado += produto.getVolume();
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Caixa com " + produtos.size() + " produto(s): " + produtos;
        }
    }

    public static List<Caixa> empacotar(List<Produto> produtos) {
        List<Caixa> caixas = new ArrayList<>();
        for (Produto produto : produtos) {

            // Caso o produto seja maior que a caixa, aloca sozinho
            if (produto.getVolume() > VOLUME_CAIXA) {
                Caixa caixaEspecial = new Caixa();
                caixaEspecial.produtos.add(produto);
                caixaEspecial.volumeUsado = produto.getVolume();
                caixas.add(caixaEspecial);
                continue;
            }

            boolean empacotado = false;
            for (Caixa caixa : caixas) {
                if (caixa.adicionarProduto(produto)) {
                    empacotado = true;
                    break;
                }
            }

            if (!empacotado) {
                Caixa novaCaixa = new Caixa();
                novaCaixa.adicionarProduto(produto);
                caixas.add(novaCaixa);
            }
        }
        return caixas;
    }
}
