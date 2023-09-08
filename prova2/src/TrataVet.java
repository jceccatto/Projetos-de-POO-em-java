public class TrataVet {
    private int[] array = new int[4];

    public void exibir(int k) throws ExcecaoIndiceNegativoJoao, ExcecaoVetorJoao {
        if(k>= this.array.length)
            throw new ExcecaoVetorJoao ( "Erro indice de vetor." );
        if (k<0)
            throw new ExcecaoIndiceNegativoJoao ( "Erro indice negativo de vetor." );
        System.out.println("Metodo exibidr(k): Array[k] = " + this.array[k]);
    }

    public static void main(String[] args) throws ExcecaoVetorJoao, ExcecaoIndiceNegativoJoao {
        TrataVet vetor = new TrataVet ();
        vetor.array[0]=0;
        vetor.array[1]=5;
        vetor.array[2]=10;
        vetor.array[3]=15;

        int k = -10;
        boolean impresso = false;
        while(!impresso){
            try {
                vetor.exibir (k);
                impresso=true;
            } catch (ExcecaoIndiceNegativoJoao e) {
                System.out.println("*** Erro: " + e.getMessage ());
                if (k<0)
                    k=-k;
            } catch (ExcecaoVetorJoao e){
                System.out.println("*** Erro: " + e.getMessage ());
                k = k/2;

            }finally {
                System.out.println("k = " + k);
            }
        }


    }
}
