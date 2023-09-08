package trab6;

import java.util.ArrayList;

public class Compactado extends Arquivo {
    private ArrayList<Arquivo> arquivos;

    public Compactado(String nome, int endereco, int blocos){
        super(nome, endereco, blocos);
        arquivos = new ArrayList<Arquivo>();
    }
    public void compactarArquivo(Arquivo a){
        arquivos.add(a);
    }
    public void abrir(Disco d){
        Pasta pastaDescompactada = d.criarPasta(this.nome);
        for(Arquivo a : arquivos){
            pastaDescompactada.inserir(a);
        }
    }
}
