package clases;

import java.util.Scanner;

public class ClasePrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0, nodo_informacion = 0;
        Cola cola = new Cola();

        do {

            System.out.println("Menú de Opciones\n\n"
            + "1. Insertar un nodo\n"
            + "2. Extraer un nodo\n"
            + "3. Mostrar contenido de la Cola\n"
            + "4. Mostrar la cantidad de numeros primos de la cola\n"
            + "5. Sumar el primer elemento par con el ultimo elemento impar de la cola\n"
            + "6. Sumar el primer elemento y el elemento mas grande de la cola\n"
            + "7. Salir.\n\n");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el valor del nodo a insertar: ");
                    nodo_informacion = sc.nextInt();
                    cola.Push(nodo_informacion);

                    break;
                case 2:
                    if (!cola.ColaVacia()) {
                        System.out.println("El valor del nodo extraido es: " + cola.Pop());
                    } else {
                        System.out.println("La cola está vacía");
                    }
                    break;
                case 3:
                    cola.MostrarContenido();
                    break;

                case 4:
                    System.out.println("La cantidad de numeros primos de la cola es: " + cola.CantidadNumerosPrimos());
                    break;

                case 5:
                    System.out.println("La suma del primer elemento par con el ultimo elemento impar de la cola es: " + cola.PrimerParUltimoImpar());
                    break;

                case 6:
                    System.out.println("La suma del primer elemento y el elemento mas grande de la cola es: " + cola.SumaPrimeroYMasGrande());
                    break;
                case 7:
                    opcion = 7;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != 7);
    }

    public static class Nodo {
        int info;
        Nodo siguiente;

        // metodo para saber si el nodo es par
        public boolean EsPar() {
            if (info % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }

        // metodo para saber si el nodo es multiplo
        public boolean EsMultiplo(int info) {
            if (info % 3 == 0) {
                return true;
            } else {
                return false;
            }
        }

        // metodo para saber si el nodo es negativo
        public boolean EsNegativo(int info) {
            if (info < 0) {
                return true;
            } else {
                return false;
            }
        }

        // metodo para saber si el nodo es positivo
        public boolean EsPositivo(int info) {
            if (info > 0) {
                return true;
            } else {
                return false;
            }
        }

        // metodo para saber si el nodo es primo
        public boolean EsPrimo(int info) {
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

        // metodo para saber el nodo es impar
        public boolean EsImpar(int info) {
            if (info % 2 != 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    
    public static class Cola {

        private Nodo front, rear;
        String Cola = "";

        public Cola() {
            front = null;
            rear = null;
        }

        // Método para saber si la cola esta vacia
        public boolean ColaVacia() {
            if (front == null) {
                return true;
            } else {
                return false;
            }
        }

        // Método para insertar a la cola
        public void Push(int info) {
            Nodo nuevo_nodo = new Nodo();
            nuevo_nodo.info = info;
            nuevo_nodo.siguiente = null;

            if (ColaVacia()) {
                front = nuevo_nodo;
                rear = nuevo_nodo;
            } else {
                rear.siguiente = nuevo_nodo;
                rear = nuevo_nodo;
            }
        }

        // Método para extraer de la cola
        public int Pop() {
            if (!ColaVacia()) {
                int info = front.info;

                if (front == rear) {
                    front = null;
                    rear = null;
                } else {
                    front = front.siguiente;
                }
                return info;
            } else {
                return 0;
            }
        }

        // Método para mostrar el contenido de la cola
        public void MostrarContenido() {
            Nodo recorrido = front;
            String ColaInvertida = "";

            while (recorrido != null) {
                Cola += recorrido.info + " ";
                recorrido = recorrido.siguiente;
            }

            String cadena[] = Cola.split(" ");

            for (int i = cadena.length - 1; i >= 0; i--) {
                ColaInvertida += " " + cadena[i];
            }

            System.out.println("El contenido de la cola es: " + ColaInvertida);
            Cola = "";
        }

        // metodo para mostrar el primer dato de la cola
        public void MostrarPrimerDato() {
            if (!ColaVacia()) {
                System.out.println("El primer dato de la cola es: " + front.info);
            } else {
                System.out.println("La cola está vacía");
            }
        }

        // metodo para mostrar el ultimo dato de la cola
        public void MostrarUltimoDato() {
            if (!ColaVacia()) {
                System.out.println("El ultimo dato de la cola es: " + rear.info);
            } else {
                System.out.println("La cola está vacía");
            }
        }

        // metodo para saber cuantos numeros primos hay en la cola
        public int CantidadNumerosPrimos() {
            int contador = 0;
            if (!ColaVacia()) {
                Nodo recorrido = front;
                while (recorrido != null) {
                    if (recorrido.EsPrimo(recorrido.info)) {
                        contador++;
                    }
                    recorrido = recorrido.siguiente;
                }
            } else {
                System.out.println("La cola está vacía");
            }
            return contador;
        }

        // metodo para obtener el numero mas grande de la cola
        public int NumeroMasGrande() {
            int numero = 0;
            if (!ColaVacia()) {
                Nodo recorrido = front;
                while (recorrido != null) {
                    if (recorrido.info > numero) {
                        numero = recorrido.info;
                    }
                    recorrido = recorrido.siguiente;
                }
            } else {
                System.out.println("La cola está vacía");
                
            }
            return numero;
        }
        //Metodo para sumar el primer Elemento par con el ultimo elemento impar de la cola
        public int PrimerParUltimoImpar() {
            int par = 0, impar = 0;
            Nodo puntero = front;
            int bandera = 0;
            
            while (puntero != null) {
              if (bandera != 1) {
                if (puntero.EsPar()) {
                  par = puntero.info;
                  bandera = 1;
                }
              }
              
              if (puntero.EsImpar(puntero.info)) {
                impar = puntero.info;
              }
              
              puntero = puntero.siguiente;
            }
            
            return par + impar;
          }

          //Metodo para sumar el primer elemento y el elemento mas grande de la cola
        public int SumaPrimeroYMasGrande() {
            int masGrande = 0;
            Nodo puntero = front.siguiente;

            while (puntero != null) {
                if (puntero.info > masGrande) {
                    if (puntero.EsPar()) {
                        masGrande = puntero.info;
                    }
                }

                puntero = puntero.siguiente;
            }

            return front.info + masGrande;
        }

    }

}
