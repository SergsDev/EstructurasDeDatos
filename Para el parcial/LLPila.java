import java.util.Scanner;

public class LLPila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0, nodo = 0;

        Pila pila = new Pila();
        
        do {
            System.out.println("Menu de opciones \n\n"
            + "1. Insertar un nodo \n"
            + "2. Eliminar un nodo \n"
            + "3. Verificar si la pila esta vacia\n"
            + "4. Conocer ultimo valor ingresado a la pila \n"
            + "5. Conocer cuantos nodos tiene la pila \n"
            + "6. Vaciar pila \n"
            + "7. Mostrar el contenido de la pila \n"
            + "8. Salir \n\n"
            + "Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                //insertar un nodo
                    System.out.println("Ingrese el valor del nodo: ");
                    nodo = sc.nextInt();
                    pila.InsertarNodo(nodo);
                    break;
                
                case 2:
                //eliminar un nodo
                pila.EliminarNodo();
                if (!pila.Vacia()) {
                    System.out.println("Se ha eliminado el nodo con el valor: " + pila.EliminarNodo());
                } else {
                    System.out.println("La pila esta vacia");
                }
                    break;

                case 3:
                //verificar si la pila esta vacia
                if (pila.Vacia()) {
                    System.out.println("La pila esta vacia");
                    
                } else {
                    System.out.println("La pila NO esta vacia");
                }
                    break;
                
                case 4:
                //ultimo valor ingresado a la pila
                if (!pila.Vacia()) {
                    System.out.println("El ultimo valor ingresado a la pila es: " + pila.ultimoValorIngresado);
                } else {
                    System.out.println("La pila esta vacia");
                }
                    break;

                case 5:
                //cantidad de nodos
                System.out.println("La pila tiene " + pila.TamañoPila() + " nodos");
                    break;

                case 6:
                //vaciar pila
                if (!pila.Vacia()) {
                    pila.VaciarPila();
                    System.out.println("Se ha vaciado la pila");
                } else {
                    System.out.println("La pila esta vacia");
                }
                pila.VaciarPila();
                    break;

                case 7:
                //mostrar pila
                    pila.MostrarPila();    
                    break;

                case 8:
                    opcion = 8;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 8);
    }

    public static class Nodo {
        int info;
        Nodo siguiente;

        public Nodo(int valor) {
            info = valor;
            siguiente = null;
        }

        //metodo para determinar si el nodo es par
        public boolean EsPar() {
            if (info % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }

        //metodo para determinar si el nodo es impar
        public boolean EsImpar() {
            if (info % 2 != 0) {
                return true;
            } else {
                return false;
            }
        }

        //metodo para determinar si el nodo es primo
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

        //metodo para determinar si el nodo es negativo
        public boolean EsNegativo() {
            if (info < 0) {
                return true;
            } else {
                return false;
            }
        }

        //metoodo para determinar si el nodo es positivo
        public boolean EsPositivo() {
            if (info > 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static class Pila {

        private Nodo ultimoValorIngresado;
        int tamaño = 0;
        String Lista = "";

        public Pila() {
            ultimoValorIngresado = null;
            tamaño = 0;
        }

        // Metodo para conocer si la Pila esta vacia
        public boolean Vacia() {
            return ultimoValorIngresado == null;
        }

        //Metodo para insertar un Nodo en la pila
        public void InsertarNodo(int nodo){
            Nodo nuevo_nodo = new Nodo(nodo);
            nuevo_nodo.siguiente = ultimoValorIngresado;
            ultimoValorIngresado = nuevo_nodo;
            tamaño++;
        }

        //Metodo para eliminar un Nodo de la pila
        public int EliminarNodo(){
            int aux = ultimoValorIngresado.info;
            ultimoValorIngresado = ultimoValorIngresado.siguiente;
            tamaño--;
            return aux;
        }
 
        //Metodo para conocer el tamaño de la pila
        public int TamañoPila(){
            return tamaño;
        }

        //Metodo para vaciar la pila
        public void VaciarPila(){
            while(!Vacia()){
                EliminarNodo();
            }
        }

        public void MostrarPila(){
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                Lista += puntero.info + "\n";
                puntero = puntero.siguiente;
            }

            System.out.println(Lista);
            Lista = "";
        }

        //metodo para mostrar el ultimo valor ingresado a la pila
        public void MostrarUltimoValorIngresado(){
            System.out.println("El ultimo valor ingresado a la pila es: " + ultimoValorIngresado.info);
        }

        //metodo para mostrar el primer valor ingresado a la pila
        public void MostrarPrimerValorIngresado(){
            Nodo puntero = ultimoValorIngresado;
            while(puntero.siguiente != null){
                puntero = puntero.siguiente;
            }
            System.out.println("El primer valor ingresado a la pila es: " + puntero.info);
        }

        //metodo para saber cuantos numeros pares hay en la pila
        public void CantidadNumerosPares(){
            int contador = 0;
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsPar()){
                    contador++;
                }
                puntero = puntero.siguiente;
            }
            System.out.println("La cantidad de numeros pares en la pila es: " + contador);
        }

        //metodo para saber cuantos numeros impares hay en la pila
        public void CantidadNumerosImpares(){
            int contador = 0;
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsImpar()){
                    contador++;
                }
                puntero = puntero.siguiente;
            }
            System.out.println("La cantidad de numeros impares en la pila es: " + contador);
        }

        //metodo para saber cuantos numeros primos hay en la pila
        public void CantidadNumerosPrimos(){
            int contador = 0;
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsPrimo()){
                    contador++;
                }
                puntero = puntero.siguiente;
            }
            System.out.println("La cantidad de numeros primos en la pila es: " + contador);
        }

        //metodo para sumar el primer numero par y el ultimo impar de la pila
        public void PrimerParYUltimoImpar(){
            int suma = 0, bandera = 0;
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsPar() && bandera == 0){
                    suma += puntero.info;
                    bandera = 1;
                }
                puntero = puntero.siguiente;
            }
            puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsImpar()){
                    suma += puntero.info;
                }
                puntero = puntero.siguiente;
            }
            System.out.println("La suma de los numeros pares y los numeros impares es: " + suma);
        }

        //metodo para sumar el primer numero impar de la pila y el ultimo par de la pila
        public void PrimerImparYUltimoPar(){
            int suma = 0, bandera = 0;
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsImpar() && bandera == 0){
                    suma += puntero.info;
                    bandera = 1;
                    
                }
                puntero = puntero.siguiente;
            }
            puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsPar()){
                    suma += puntero.info;
                }
                puntero = puntero.siguiente;
            }
            System.out.println("La suma de los numeros impares y los numeros pares es: " + suma);
        }

        //metodo para sumar el primer numero primo de la pila con el ultimo impar de la pila 
        public void PrimerPrimoYUltimoImpar(){
            int suma = 0, bandera = 0;
            Nodo puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsPrimo() && bandera == 0){
                    suma += puntero.info;
                    bandera = 1;
                }
                puntero = puntero.siguiente;
            }
            puntero = ultimoValorIngresado;
            while(puntero != null){
                if(puntero.EsImpar()){
                    suma += puntero.info;
                }
                puntero = puntero.siguiente;
            }
            System.out.println("La suma de los numeros primos y los numeros impares es: " + suma);
        }
    }
}
