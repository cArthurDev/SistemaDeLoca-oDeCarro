class CarroPopular extends Veiculo {
    private boolean arCondicionado;

    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesPagas = Math.max(1, renovacoes - 1);
        return getValorLocacao() + (renovacoesPagas * getValorMulta());
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }
}
