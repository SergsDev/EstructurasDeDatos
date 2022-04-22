import java.util.Scanner;

public class Pila_clase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pila pila1 = new Pila();

        pila1.Push(15);
        pila1.Push(20);
        pila1.Push(25);
        pila1.Push(30);
        pila1.ImprimirPila();

        int suma = 0;
        while (!pila1.estaVacia()) {
            
        }
    }

    public static class Pila {
        private Nodo Primero;
        private int bandera = 0;
        private Nodo n = new Nodo();
        private Nodo puntero = new Nodo();
        public int tope;


        private void ActualizarTope(){
            
        }
        public void POP() {
            Nodo aux = new Nodo();
            Nodo aux1 = new Nodo();
            aux = Primero;
            if (aux != null)
                while (aux.siguiente != null) {
                    aux1 = aux;
                    aux = aux.siguiente;
                }

            else
                System.out.println("Pila vacia");
            aux1.siguiente = null;

        }

        public void Push(int a) {
            if (bandera == 0) {
                n = new Nodo();
                n.info = a;
                n.siguiente = null;
                puntero.siguiente = n;
                Primero = n;
                puntero = Primero;
                bandera = 1;
            } else {
                puntero = n;
                n = new Nodo();
                n.info = a;
                n.siguiente = null;
                puntero.siguiente = n;
                puntero = puntero.siguiente;
            }
            tope = a;
            System.out.println("Se ha apilado, increible");
            System.out.println("El tope es: " + tope);
        }
        public void ImprimirPila() {
            int contador = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                contador++;
                System.out.println("El Nodo en la posicion " + contador + " es: " + puntero.info);
                puntero = puntero.siguiente;
            }
        }


        public boolean estaVacia(){
            if(Primero == null){
                return true;
            } else {
                return false;
            }
        }

        public int Stacktop(){
            Nodo aux = new Nodo();
            aux = Primero;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            return aux.info;
        }

        
        public Nodo StacktopOverloaded(){
            Nodo aux = new Nodo();
            aux = Primero;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            return aux;
        }
    }

    public static class Nodo {

        int info;
        Nodo siguiente;
        

        public Nodo() {
        }

        public boolean EsPar() {
            if (info % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }

        public boolean EsImpar() {
            if (info % 2 != 0) {
                return true;
            } else {
                return false;
            }
        }

        public boolean EsPrimo() {
            int contador = 0;
            for (int i = 1; i <= info; i++) {
                if (info % i == 0) {
                    contador++;
                }
            }
            if (contador == 2) {
                return true;
            } else {
                return false;
            }
        }

        public boolean EsMultiplo(int a) {
            if (info % a == 0) {
                return true;
            } else {
                return false;
            }
        }

        public boolean EsNegativo() {
            if (info < 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
