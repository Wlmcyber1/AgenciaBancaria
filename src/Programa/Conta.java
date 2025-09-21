package Programa;

import Utilitarios.Utils;

public class Conta {
    private static int countConta = 1;

    private int numeroConta;
    private Usuario usuario;
    private Double saldo = 0.0;

    public Conta( Usuario usuario){
        this.numeroConta = countConta;
        this.usuario=usuario;
        countConta +=1;

    }

    public Conta(int numeroContaRemetente) {
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString (){
        return "\nNumero da conta :"+ this.getNumeroConta()+
        "\nNome:"+ this.usuario.getNome() +
        "\nCPF:"+ this.usuario.getcpf() +
        "\nE-mail"+ this.usuario.getEmail() +
        "\nSaldo:"+ Utils.doubleToString(this.getSaldo());

    }
public void depositar (Double valor){
        if (valor >0){
            setSaldo(getSaldo()+ valor);
            System.out.println("Seu depósito foi concluido com sucesso! ");
        } else {
            System.out.println("Não foi possivel realizar o depósito");
        }

}
public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi concluido com sucesso! ");
        }else {
            System.out.println("Não foi possivel realizar o saque ");
        }
}

public void transferir(Conta contaParaDeposito, Double valor){
        if (valor > 0 && this.getSaldo()>= valor){
            setSaldo(getSaldo()- valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Tranferência realizada com sucesso");
        }else {
            System.out.println("Não foi possivel realizar a transferência");
        }
}
}
