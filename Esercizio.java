//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static void visualizzaVettore(int[] V, int N) {
        int i;
        i = 0;
        while (i<N) {
            System.out.println(V[i]);
            ++i;
        }
    }

    public static void bubbleSort(int[] V, int N) {
        int i, j, temp;
        boolean ordinato;
        i = 0;
        ordinato = false;
        while (i<N && !ordinato) {
            ordinato = true;
            j = 0;
            while (j<N-1-i) {
                if (V[j]>V[j+1]) {
                    temp = V[j];
                    V[j] = V[j+1];
                    V[j+1] = temp;
                    ordinato = false;
                }
                ++j;
            }
            ++i;
        }
    }

    public static int merge (int[] V1, int N1, int[] V2, int N2, int[] V) {
        int i, j, k;
        i = 0;
        j = 0;
        k = 0;
        while (i<N1 && j<N2) {
            if (V1[i]>=V2[j]) {
                V[k] = V2[j];
                ++j;
            } else {
                V[k] = V1[i];
                ++i;
            }
            ++k;
        }
        while (i<N1) {
            V[k] = V1[i];
            ++i;
            ++k;
        }
        while (j<N2) {
            V[k] = V2[j];
            ++j;
            ++k;
        }
        return k;
    }

    public static int ricercaBinaria (int[] V, int N, int val) {
        int inizio, fine, centro, idx;
        inizio = 0;
        fine = N-1;
        idx = -1;
        while (idx==-1 && inizio<=fine) {
            centro = inizio + (fine-inizio)/2;
            if (V[centro]>val) {
                fine = centro-1;
            } else if (V[centro]<val) {
                inizio = centro+1;
            } else {
                idx = centro;
            }
        }
        return idx;
    } 

    public static void main(String args[]) {
        
        //PRIMA PARTE
        Scanner in = new Scanner( System.in );
        int i, N, NP, ND, x, idx, val;
        System.out.println("Inserire il numero di numeri da generare: ");
        do {
            N = Integer.parseInt(in.nextLine());
        } while (N<0);
        int [] P = new int[N];
        int [] D = new int[N];
        Random random = new Random();
        NP = 0;
        ND = 0;
        i = 0;
        while (i<N) {
            x = random.nextInt(N*100)+1;
            if (x%2==0) {
                P[NP] = x;
                ++NP;
            } else {
                D[ND] = x;
                ++ND;
            }
            ++i;
        }
        System.out.println("------ VISUALIZZAZIONE VETTORI STATO INIZIALE ------");
        visualizzaVettore(P, NP);
        System.out.println("\n");
        visualizzaVettore(D, ND);
        //SECONDA PARTE
        bubbleSort(P, NP);
        bubbleSort(D, ND);
        System.out.println("------ VISUALIZZAZIONE VETTORI DOPO ORDINAMENTO ------");
        visualizzaVettore(P, NP);
        System.out.println("\n");
        visualizzaVettore(D, ND);
        int [] V = new int[N];
        N = merge(P, NP, D, ND, V);
        System.out.println("------ VISUALIZZAZIONE VETTORE UNICO DOPO MERGE ------");
        visualizzaVettore(V, N);
        System.out.println("Inserire valore da cercare: ");
        do {
            val = Integer.parseInt(in.nextLine());
        } while (val<0);
        idx = ricercaBinaria(V, N, val);
        System.out.println("Il valore " + val + " si trova in posizione " + idx);
        in.close();
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md