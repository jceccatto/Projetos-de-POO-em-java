package trab6;

public class Planilha extends Documento {
    public Planilha(String nome, int endereco, int blocos){
        super(nome, endereco, blocos);
    }
    public void abrir(){
        System.out.print("Media Player -");
        super.abrir();
    }
}