import java.util.ArrayList;

class Locadora {
    private String nome;
    private String endereco;
    private String telefone;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Emprestimo> emprestimos;

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarEmprestimo(Cliente cliente, Veiculo veiculo) {
        if (cliente instanceof PessoaFisica) {
            for (Emprestimo e : emprestimos) {
                if (e.getCliente().equals(cliente) && !e.isFinalizado()) {
                    System.out.println("Pessoas físicas só podem ter um empréstimo ativo por vez.");
                    return;
                }
            }
        }

        for (Emprestimo e : emprestimos) {
            if (e.getVeiculo().equals(veiculo) && !e.isFinalizado()) {
                System.out.println("Este veículo já está alugado para outro cliente.");
                return;
            }
        }

        Emprestimo emprestimo = new Emprestimo(cliente, veiculo);
        emprestimos.add(emprestimo);
        veiculos.remove(veiculo);
        System.out.println("Empréstimo realizado com sucesso.");
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        emprestimo.renovar();
    }

    public double finalizarEmprestimo(Emprestimo emprestimo) {
        double valorTotal = emprestimo.finalizar();
        emprestimos.remove(emprestimo);
        veiculos.add(emprestimo.getVeiculo());
        return valorTotal;
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimoPorClienteEVeiculo(Cliente cliente, String placa) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getCliente().equals(cliente) && emprestimo.getVeiculo().getPlaca().equals(placa)) {
                return emprestimo;
            }
        }
        return null;
    }

    public void listarVeiculosDisponiveis() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
        } else {
            System.out.println("Veículos disponíveis:");
            for (Veiculo veiculo : veiculos) {
                System.out.println("Marca: " + veiculo.getMarca() + ", Modelo: " + veiculo.getModelo() + ", Placa: " + veiculo.getPlaca());
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
