package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("---------------------------------------------------");
        System.out.println("------------Bem vindo(a) a nossa Agência-----------");
        System.out.println("***** Selecione a operação que deseja realizar *****");
        System.out.println("|             Opção 1 : Criar conta          |");
        System.out.println("|             Opção 2 : Depositar            |");
        System.out.println("|             Opção 3 : Sacar                |");
        System.out.println("|             Opção 4 : Transferir           |");
        System.out.println("|             Opção 5 : Listar               |");
        System.out.println("|             Opção 6 : Sair                 |");
        int operacao = input.nextInt();
        input.nextLine(); // consome quebra de linha

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Até mais!");
                System.exit(0);
                break;
            default:
                System.out.println("Digite apenas números disponíveis para as operações");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome:");
        String nome = input.nextLine();

        System.out.println("\nCPF:");
        String cpf = input.nextLine(); // agora CPF é String ✅

        System.out.println("\nE-mail:");
        String email = input.nextLine();

        Usuario cliente = new Usuario(nome, cpf, email);
        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso! Pode comemorar 🎉");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta para depósito:");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual seria o valor que deseja depositar?");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("O valor foi depositado com sucesso :)");
        } else {
            System.out.println("A conta não foi encontrada.");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Número da conta para saque:");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual seria o valor que deseja sacar?");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("A conta não foi encontrada.");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Número da conta do remetente:");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário:");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if (contaDestinatario != null) {
                System.out.println("Qual o valor da transferência?");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Conta do destinatário não encontrada.");
            }
        } else {
            System.out.println("Conta do remetente não encontrada.");
        }
        operacoes();
    }

    public static void listar() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Sem contas cadastradas.");
        }
        operacoes();
    }
}
