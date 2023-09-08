package trab6;

public class Arquivo {
    protected String nome;
    protected int endereco;
    protected int blocos;

    public Arquivo(String n, int e, int b){
        this.nome = n;
        this.endereco = e;
        this.blocos = b;
    }
    public String getNome(){
        return this.nome;
    }
    public void imprimirNome(){
        System.out.println("  . " + nome);
    }
    public void abrir(){
        System.out.println (this.nome);//confirmar se esta certo.
    }
}
