import java.util.Scanner;

public class Lle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionL1 = 1;
        int opcionL2 = 1;
        int datoL1 = 0;
        int datoL2 = 0;

        Lista Lista1 = new Lista();
        Lista Lista2 = new Lista();

        Lista1.Primero = null;
        Lista2.Primero = null;

        Nodo puntero = new Nodo();
        Nodo n = new Nodo();

        System.out.println("PRIMERA LISTA");
        while (opcionL1 != 0) {
            System.out.println("Digite el valor del Nodo: ");
            datoL1 = sc.nextInt();
            Lista1.AgregarNodoFinal(datoL1);

            System.out.println("Desea Crear Otro Nodo? 1.Si 0.No");
            opcionL1 = sc.nextInt();
        }

        System.out.println("SEGUNDA LISTA");
        while (opcionL2 != 0) {
            System.out.println("Digite el valor del Nodo: ");
            datoL2 = sc.nextInt();
            Lista2.AgregarNodoFinal(datoL2);

            System.out.println("Desea Crear Otro Nodo? 1.Si 0.No");
            opcionL2 = sc.nextInt();
        }
        // Lista1.ImprimirLista();
        // Lista2.ImprimirLista();

        // System.out.println("******");
        // Lista1.EliminarPrimerNodo();
        // Lista1.ImprimirLista();

        // System.out.println("******");
        // Lista1.EliminarUltimoNodo();
        // Lista1.ImprimirLista();

        // System.out.println("******");
        // System.out.println("La cantidad de nodos en la lista es de: " +
        // Lista1.CantidadNodos());

        // System.out.println("La cantidad de numeros pares en la lista es de: " +
        // Lista1.CantidadPares());
        // System.out.println("La cantidad de numeros impares en la lista es de: " +
        // Lista1.CantidadImpares());

        // System.out.println("La suma del primer y ultimo nodo es de: " +
        // Lista1.SumaPrimeroUltimo());
        // System.out.println("La suma de los numeros primos es de: " +
        // Lista1.SumaPrimos());
        // System.out.println("La suma de los numeros pares es de: " +
        // Lista1.SumaPares());
        // System.out.println("La suma de los numeros impares es de: " +
        // Lista1.SumaImpares());

        // System.out.println("Digite el valor del nodo que desea agregar al final de la lista");
        // Lista1.AgregarNodoFinal(sc.nextInt());
        // Lista1.ImprimirLista();

        // System.out.println("Digite el valor del nodo que desea agregar al principio de la lista");
        // Lista1.AgregarNodoPrimero(sc.nextInt());
        // Lista1.ImprimirLista();

        // System.out.println("Digite el valor y la ubicacion del nodo a ingresar");
        // Lista1.AgregarNodoEnUbicacion(sc.nextInt(), sc.nextInt());
        // Lista1.ImprimirLista();
        
        // Lista1.ConcatenarListas(Lista2);
        // Lista1.ImprimirLista();
    }

    public static class Lista {
        Nodo Primero;
        private int bandera = 0;
        private Nodo n = new Nodo();
        private Nodo puntero = new Nodo();

        public void EliminarPrimerNodo() {
            if (Primero != null) {
                if (Primero.siguiente != null) {
                    Primero = Primero.siguiente;
                } else {
                    Primero = null;
                }
            } else {
                System.out.println("Lista vacia");
            }
        }

        public void EliminarUltimoNodo() {
            Nodo aux = new Nodo();
            Nodo aux1 = new Nodo();
            aux = Primero;
            if (aux != null)
                while (aux.siguiente != null) {
                    aux1 = aux;
                    aux = aux.siguiente;
                }

            else
                System.out.println("Lista vacia");
            aux1.siguiente = null;

        }

        public void AgregarNodoFinal(int a) {
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
        }

        public void AgregarNodoPrimero(int a) {
            Nodo k = new Nodo();
            k.info = a;
            k.siguiente = null;
            if (Primero == null) {
                Primero = k;
            } else {
                k.siguiente = Primero;
                Primero = null;
                Primero = k;
            }
        }

        public void AgregarNodoEnUbicacion(int info, int posicion) {
            Nodo k = new Nodo();
            k.info = info;
            k.siguiente = null;

            if (posicion < 1) {
                System.out.println("La posicion debe ser mayor a 1");
            } else if (posicion == 1) {
                k.siguiente = Primero;
                Primero = k;
            } else {
                Nodo aux = new Nodo();
                aux = Primero;
                for (int i = 0; i < posicion-1; i++) {
                    if (aux != null) {
                        aux = aux.siguiente;
                    }
                }
                if (aux != null) {
                    k.siguiente = aux.siguiente;
                    aux.siguiente = k;
                } else {
                    System.out.println("El nodo anterior es nulo");
                }
            }
        }

        // public void InsertarNodoUbicacion(int ubicacion, Nodo a) {
        //     int contador = 0;
        //     Nodo aux = new Nodo();
        //     aux = Primero;
        //     while (aux != null) {
        //         ++contador;
        //         aux = aux.siguiente;
        //         if (contador == ubicacion) {
        //             a.siguiente = aux;
        //             aux = a;
        //         }
        //     }
        // }

        public void ConcatenarListas(Lista w) {
            Lista Resultado = new Lista();
            Nodo aux = new Nodo();
            aux = Primero;
            while (aux != null) {
                Resultado.AgregarNodoFinal(aux.info);
                aux = aux.siguiente;
            }
            aux = w.Primero;
            while (aux != null) {
                Resultado.AgregarNodoFinal(aux.info);
                aux = aux.siguiente;
            }
            Primero = Resultado.Primero;
        }

        public Lista ConcatenarRetonarLista(Lista w) {
            Lista Resultado = new Lista();
            Nodo puntero = new Nodo();
            puntero = Primero;

            Resultado.Primero.info = puntero.info;

            while (puntero.siguiente != null) {
                Resultado.AgregarNodoFinal(puntero.info);
                puntero = puntero.siguiente;
            }
            return w;
        }

        public void ImprimirLista() {
            int contador = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                contador++;
                System.out.println("El Nodo en la posicion " + contador + " es: " + puntero.info);
                puntero = puntero.siguiente;
            }
        }

        public int CantidadNodos() {
            int c = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                ++c;
                puntero = puntero.siguiente;
            }
            return c;
        }

        public int CantidadPares() {
            int c = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                if (puntero.EsPar()) {
                    ++c;

                }
                puntero = puntero.siguiente;
            }
            return c;
        }

        public int CantidadImpares() {
            int c = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                if (puntero.EsImpar()) {
                    ++c;

                }
                puntero = puntero.siguiente;
            }
            return c;
        }

        public int UltimoNodo() {
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            return puntero.info;
        }

        public int SumaPrimeroUltimo() {
            int suma = 0;
            suma = Primero.info + UltimoNodo();
            return suma;
        }

        public int SumaPrimos() {
            int suma = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                if (puntero.EsPrimo()) {
                    suma = suma + puntero.info;

                }
                puntero = puntero.siguiente;
            }
            return suma;
        }

        public int SumaPares() {
            int suma = 0;
            Nodo puntero = new Nodo();
            puntero = Primero;
            while (puntero != null) {
                if (puntero.EsPar()) {
                    suma = suma + puntero.info;
                }
                puntero = puntero.siguiente;
            }
            return suma;
        }

    }

    public static class Nodo {

        int info;
        Nodo siguiente;
        Nodo anterior;

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