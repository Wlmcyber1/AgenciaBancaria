package Programa;

public class Usuario {

    private static int counter =1;
    private String nome;
    private String cpf;
    private String email;
    public Usuario(String nome, String cpf, String email){

        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        counter+=1;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString () {
        return "\nNome:" + this.getNome() + "\nCPF" + this.getcpf() +
                "\nE-mail" + this.getEmail();
    }

}
