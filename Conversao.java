public class Conversao  extends ConversorMoedas{
    private double ValorOriginal;
    private String moedaDeOrigem;
    private String moedaDeDestino;
    private double valorConvertido;

    public Conversao(double valorOriginal, String moedaDeOrigem, String moedaDeDestino, double valorConvertido) {
        ValorOriginal = valorOriginal;
        this.moedaDeOrigem = moedaDeOrigem;
        this.moedaDeDestino = moedaDeDestino;
        this.valorConvertido = valorConvertido;

    }

    public double getValorOriginal() {
        return ValorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        ValorOriginal = valorOriginal;
    }

    public String getMoedaDeOrigem() {
        return moedaDeOrigem;
    }

    public void setMoedaDeOrigem(String moedaDeOrigem) {
        this.moedaDeOrigem = moedaDeOrigem;
    }

    public String getMoedaDeDestino() {
        return moedaDeDestino;
    }

    public void setMoedaDeDestino(String moedaDeDestino) {
        this.moedaDeDestino = moedaDeDestino;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    @Override
    public String toString() {
        return String.format("Conversao{valorOriginal=%.2f, moedaDeOrigem='%s', moedaDeDestino='%s', valorConvertido=%.2f}",
                ValorOriginal, moedaDeOrigem, moedaDeDestino, valorConvertido);
    }
}


