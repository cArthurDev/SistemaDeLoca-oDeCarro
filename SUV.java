class SUV extends Veiculo {
    private String tamanhoPortaMalas;
    private String tipoTracao;
    private String tipoCombustivel;

    public SUV(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, String tamanhoPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesPagas = Math.max(1, renovacoes - 3);
        return getValorLocacao() + (renovacoesPagas * getValorMulta());
    }

    public String getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(String tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
}
