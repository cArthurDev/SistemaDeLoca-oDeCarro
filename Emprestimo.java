class Emprestimo {
    private Cliente cliente;
    private Veiculo veiculo;
    private int renovacoes;
    private boolean finalizado;

    public Emprestimo(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.renovacoes = 0;
        this.finalizado = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void renovar() {
        this.renovacoes++;
    }

    public double finalizar() {
        this.finalizado = true;
        return veiculo.calcularValorTotal(renovacoes);
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getRenovacoes() {
        return renovacoes;
    }

    public void setRenovacoes(int renovacoes) {
        this.renovacoes = renovacoes;
    }
}
