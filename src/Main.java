import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Definição de input
        Scanner leitura = new Scanner(System.in);

        // Declaração de variáveis e leitura de valores
        System.out.println("Nome do Cliente:");
        String nomeDoCliente = leitura.nextLine();
        System.out.println("Tipo da Conta:");
        String tipoDaConta = leitura.nextLine();
        System.out.println("Saldo Inicial:");
        float saldoDaConta = leitura.nextFloat();
        float controleDeSaldo;
        String operacoes = """
                           \n******************************
                           Operações:
                            1 - Consultar Saldo;
                            2 - Depositar Valor;
                            3 - Tranferir Valor;
                            4 - Sacar Valor;
                            5 - Sair.
                           ******************************

                           Digite a opção desejada:""";
        byte operacaoEscolhida = 0;

        // Controle da execução da aplicação
        while (operacaoEscolhida != 5) {
            // Operação escolhida
            System.out.println(operacoes);
            operacaoEscolhida = leitura.nextByte();
            // "switch case" para realizar operação
            switch (operacaoEscolhida) {
                case 1:
                    System.out.println("Saldo da Conta: " + saldoDaConta);
                    break;
                case 2:
                    System.out.println("Digite um valor para depósito: ");
                    saldoDaConta += leitura.nextFloat();
                    System.out.println("Saldo Atual da Conta: " + saldoDaConta);
                    break;
                case 3:
                    System.out.println("Digite um valor para transferência: ");
                    controleDeSaldo = leitura.nextFloat();
                    // Condicional que impede saída de recursos maior que saldo disponível
                    if (controleDeSaldo > saldoDaConta) {
                        System.out.println(String.format("Saldo de %.2f, é insulficiente!", saldoDaConta));
                    } else {
                        saldoDaConta -= controleDeSaldo;
                        System.out.println("Saldo Atual da Conta: " + saldoDaConta);
                    }
                    break;
                case 4:
                    System.out.println("Digite um valor para saque: ");
                    controleDeSaldo = leitura.nextFloat();
                    // Condicional que impede saída de recursos maior que saldo disponível
                    if (controleDeSaldo > saldoDaConta) {
                        System.out.println(String.format("Saldo de %.2f, é insulficiente!", saldoDaConta));
                    } else {
                        saldoDaConta -= controleDeSaldo;
                        System.out.println("Saldo Atual da Conta: " + saldoDaConta);
                    }
                    break;
            }
        }

        // Mensagem de saída do sistema
        String saidaDoSistema = """
                                ******************************
                                O cliente %s, que possui conta do tipo %s,
                                cujo saldo disponível é %.2f, está saindo do
                                sistema bancário!
                                ******************************
                                """.formatted(nomeDoCliente, tipoDaConta, saldoDaConta);
        System.out.println(saidaDoSistema);
    }
}