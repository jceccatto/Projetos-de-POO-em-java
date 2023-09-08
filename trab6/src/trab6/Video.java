package trab6;

public class Video extends Documento {
    public Video(String nome, int endereco, int blocos){
        super(nome, endereco, blocos);
    }
    public void abrir(){
        System.out.print("Media Player -");
        super.abrir();
    }
}
