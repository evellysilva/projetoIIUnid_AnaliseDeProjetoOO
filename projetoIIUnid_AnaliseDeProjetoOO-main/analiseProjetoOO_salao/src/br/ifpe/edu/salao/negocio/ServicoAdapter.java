package br.ifpe.edu.salao.negocio;
public class ServicoAdapter implements IServicoAdapter {
    private static final double taxa_conversao = 5.49;;

    @Override
    public double getPrecoEmDolar(double precoEmReais) {
        return precoEmReais / taxa_conversao;
    }
}
