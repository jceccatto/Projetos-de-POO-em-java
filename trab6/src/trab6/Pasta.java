package trab6;

import java.util.ArrayList;

public class Pasta {
    private String nome;
    private ArrayList<Arquivo> arquivos;

    public Pasta(String n){
        this.nome = n;
        arquivos = new ArrayList<Arquivo>();
    }

    public String getNome(){
        return this.nome;
    }

    public void inserir(Arquivo arq){
        arquivos.add (arq);
    }

    public void remover(String nomeArq){
        Arquivo arq = encontraArq(nomeArq);
        if (arq != null)
            arquivos.remove (arq);
        else
            System.out.println("Arquivo [" + nomeArq + "] inexistente");
    }
    public void duplicar(String nomeArq){
        Arquivo arq = encontraArq(nomeArq);
        if(arq != null){
            Arquivo arqDuplicado = new Arquivo(arq.nome + "(copia)", 0,arquivos.size ()) ;
            arquivos.add(arqDuplicado);
        }else
            System.out.println("Arquivo [" + nomeArq + "] inexistente");
    }
    private Arquivo encontraArq(String nomeArq){
        Arquivo arq = null;
        for (Arquivo a : arquivos){
            if (a.getNome().equals(nomeArq)){
                arq = a;
            }
        }return arq;
    }
    public void listar() {
        System.out.println("- Pasta [" + nome + "] ");
        for (Arquivo a : arquivos){
            a.imprimirNome();
        }
    }

    public Compactado compactar (){
        Compactado c = new Compactado ( this.nome, 0, arquivos.size ());
        for (Arquivo a : arquivos){
            c.compactarArquivo (a);
        }
        return c;
    }
    public void abrirTodosArquivos(){
        System.out.println("- Pasta [" + nome + "] ");
        for (Arquivo a: arquivos){
            System.out.print("  Abrindo arquivo: ");
            a.abrir ();
        }
    }
    public void imprimirNome(){
        System.out.println("Pasta: " + nome);
    }
}
