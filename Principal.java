import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Locadora locadora = new Locadora("Localiza AI", "Rua Do Cristo, 343", "3495-9090");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("======== LOCALIZA AI ========");
            System.out.println("Escolha uma operação:");
            System.out.println("1 | Cadastrar novo veículo");
            System.out.println("2 | Listar veículos disponíveis");
            System.out.println("3 | Cadastrar cliente");
            System.out.println("4 | Realizar empréstimo");
            System.out.println("5 | Renovar empréstimo");
            System.out.println("6 | Finalizar empréstimo");
            System.out.println("7 | Sair");
            System.out.println("==============================");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o tipo de veículo (popular, suv, luxo):");
                    String tipoVeiculo = scanner.nextLine();
                    System.out.println("Digite a marca:");
                    String marca = scanner.nextLine();
                    System.out.println("Digite o modelo:");
                    String modelo = scanner.nextLine();
                    System.out.println("Digite a placa:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o ano:");
                    int ano = scanner.nextInt();
                    System.out.println("Digite o valor da locação:");
                    double valorLocacao = scanner.nextDouble();
                    System.out.println("Digite o valor da multa:");
                    double valorMulta = scanner.nextDouble();
                    scanner.nextLine();

                    Veiculo veiculo = null;
                    if (tipoVeiculo.equalsIgnoreCase("popular")) {
                        System.out.println("Possui ar-condicionado? (true/false):");
                        boolean arCondicionado = scanner.nextBoolean();
                        veiculo = new CarroPopular(marca, modelo, placa, ano, valorLocacao, valorMulta, arCondicionado);
                    } else if (tipoVeiculo.equalsIgnoreCase("suv")) {
                        scanner.nextLine();
                        System.out.println("Digite o tamanho do porta-malas:");
                        String tamanhoPortaMalas = scanner.nextLine();
                        System.out.println("Digite o tipo de tração:");
                        String tipoTracao = scanner.nextLine();
                        System.out.println("Digite o tipo de combustível:");
                        String tipoCombustivel = scanner.nextLine();
                        veiculo = new SUV(marca, modelo, placa, ano, valorLocacao, valorMulta, tamanhoPortaMalas, tipoTracao, tipoCombustivel);
                    } else if (tipoVeiculo.equalsIgnoreCase("luxo")) {
                        System.out.println("Digite a quantidade de airbags:");
                        int quantidadeAirbags = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o tamanho do porta-malas:");
                        String tamanhoPortaMalas = scanner.nextLine();
                        System.out.println("Possui GPS integrado? (true/false):");
                        boolean gpsIntegrado = scanner.nextBoolean();
                        veiculo = new CarroLuxo(marca, modelo, placa, ano, valorLocacao, valorMulta, quantidadeAirbags, tamanhoPortaMalas, gpsIntegrado);
                    }

                    if (veiculo != null) {
                        locadora.cadastrarVeiculo(veiculo);
                        System.out.println("Veículo cadastrado com sucesso.");
                    }
                    break;

                case 2:
                    locadora.listarVeiculosDisponiveis();
                    break;

                case 3:
                    System.out.println("Digite o tipo de cliente (fisico, juridico):");
                    String tipoCliente = scanner.nextLine();
                    System.out.println("Digite o nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o telefone:");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite o endereço:");
                    String endereco = scanner.nextLine();

                    Cliente cliente = null;
                    if (tipoCliente.equalsIgnoreCase("fisico")) {
                        System.out.println("Digite o CPF:");
                        String cpf = scanner.nextLine();
                        cliente = new PessoaFisica(nome, telefone, endereco, cpf);
                    } else if (tipoCliente.equalsIgnoreCase("juridico")) {
                        System.out.println("Digite o CNPJ:");
                        String cnpj = scanner.nextLine();
                        System.out.println("Digite o nome do representante:");
                        String nomeRepresentante = scanner.nextLine();
                        cliente = new PessoaJuridica(nome, telefone, endereco, cnpj, nomeRepresentante);
                    }

                    if (cliente != null) {
                        locadora.cadastrarCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do cliente:");
                    nome = scanner.nextLine();
                    Cliente clienteEmprestimo = locadora.buscarClientePorNome(nome);
                    System.out.println("Digite a placa do veículo:");
                    String placaVeiculo = scanner.nextLine();
                    Veiculo veiculoEmprestimo = locadora.buscarVeiculoPorPlaca(placaVeiculo);

                    if (clienteEmprestimo != null && veiculoEmprestimo != null) {
                        locadora.realizarEmprestimo(clienteEmprestimo, veiculoEmprestimo);
                    } else {
                        System.out.println("Cliente ou veículo não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome do cliente:");
                    nome = scanner.nextLine();
                    System.out.println("Digite a placa do veículo:");
                    placaVeiculo = scanner.nextLine();

                    Emprestimo emprestimoRenovacao = locadora.buscarEmprestimoPorClienteEVeiculo(locadora.buscarClientePorNome(nome), placaVeiculo);
                    if (emprestimoRenovacao != null) {
                        locadora.renovarEmprestimo(emprestimoRenovacao);
                        System.out.println("Empréstimo renovado com sucesso.");
                    } else {
                        System.out.println("Empréstimo não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Digite o nome do cliente:");
                    nome = scanner.nextLine();
                    System.out.println("Digite a placa do veículo:");
                    placaVeiculo = scanner.nextLine();

                    Emprestimo emprestimoFinalizar = locadora.buscarEmprestimoPorClienteEVeiculo(locadora.buscarClientePorNome(nome), placaVeiculo);
                    if (emprestimoFinalizar != null) {
                        double valorTotal = locadora.finalizarEmprestimo(emprestimoFinalizar);
                        System.out.println("Empréstimo finalizado. Valor total: " + valorTotal);
                    } else {
                        System.out.println("Empréstimo não encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
