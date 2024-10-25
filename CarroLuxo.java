class CarroLuxo extends Veiculo {
    private int quantidadeAirbags;
    private String tamanhoPortaMalas;
    private boolean gpsIntegrado;

    public CarroLuxo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, int quantidadeAirbags, String tamanhoPortaMalas, boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesPagas = Math.max(1, renovacoes - 5);
        return getValorLocacao() + (renovacoesPagas * getValorMulta());
    }

    public int getQuantidadeAirbags() {
        return quantidadeAirbags;
    }

    public void setQuantidadeAirbags(int quantidadeAirbags) {
        this.quantidadeAirbags = quantidadeAirbags;
    }

    public String getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(String tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public boolean isGpsIntegrado() {
        return gpsIntegrado;
    }

    public void setGpsIntegrado(boolean gpsIntegrado) {
        this.gpsIntegrado = gpsIntegrado;
    }
}
