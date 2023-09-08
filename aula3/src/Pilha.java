public class Pilha {
    private int topo;
    private int dados[];
    private int MAX;

    private int vertopo(){
        if (!this.vazia ()) {
            return topo;
        }
        System.out.println ( "Pilha está vazia" );
        return 0;
    }

    private boolean vazia(){
        if(this.topo == -1){
            return true;
        }
        return false;
    }

    public boolean cheia(){
        if(this.topo == MAX){
            return true;
        }
        return false;
    }

    public void empilhar(int elemento){
        if(this.topo< this.dados.length -1){
            this.dados[++topo] = elemento;
        }
    }

    public Object desempilhar(){
        if(vazia ()) {
            return 0;
        }
        return this.dados[this.topo--];
        }
    }

    public Pilha(int n) {
        this.topo = -1;//inicia pilha vazia
        this.dados = new int[n]; // criando a pilha
    }

    public void main(String args[]) {
        Pilha[] p = new Pilha[MAX];
        p[0] = new Pilha (1 );
    }

}
