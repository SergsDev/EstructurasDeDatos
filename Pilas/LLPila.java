import javax.swing.JOptionPane;

public class LLPila {
    public static void main(String[] args) {
        int opcion = 0, nodo = 0;

        Pila pila = new Pila();
        

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu de opciones \n\n"
            + "1. Insertar un nodo \n"
            + "2. Eliminar un nodo \n"
            + "3. Verificar si la pila esta vacia\n"
            + "4. Conocer ultimo valor ingresado a la pila \n"
            + "5. Conocer cuantos nodos tiene la pila \n"
            + "6. Vaciar pila \n"
            + "7. Mostrar el contenido de la pila \n"
            + "8. Salir \n\n"
            + "Seleccione una opcion: "));

            switch (opcion) {
                case 1:
                //insertar un nodo
                    nodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el valor del nodo a insertar:"));
                    pila.InsertarNodo(nodo);
                    break;
                
                case 2:
                //eliminar un nodo
                pila.EliminarNodo();
                if (!pila.Vacia()) {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado un nodo con el valor: " + pila.EliminarNodo());
                } else {
                    JOptionPane.showMessageDialog(null, "La pila esta vacia");
                }

                    break;

                case 3:
                //verificar si la pila esta vacia
                if (pila.Vacia()) {
                    JOptionPane.showMessageDialog(null, "La pila esta vacia");
                } else {
                    JOptionPane.showMessageDialog(null, "La pila NO esta vacia");
                }
                    break;
                
                case 4:
                //ultimo valor ingresado a la pila
                if (!pila.Vacia()) {
                    JOptionPane.showMessageDialog(null, "El ultimo valor ingresado a la pila es: " + pila.ultimoValorIngresado);    
                } else {
                    JOptionPane.showMessageDialog(null, "La pila esta vacia");
                }
                    break;

                case 5:
                //cantidad de nodos
                JOptionPane.showMessageDialog(null,"La pila tiene " + pila.TamañoPila() + " nodos");
                    break;

                case 6:
                //vaciar pila
                if (!pila.Vacia()) {
                    pila.VaciarPila();
                    JOptionPane.showMessageDialog(null,"Se ha vaciado la pila");
                } else {
                    JOptionPane.showMessageDialog(null,"La pila esta vacia");
                }

                pila.VaciarPila();
                    break;

                case 7:
                //mostrar pila
                    pila.MostrarPila();    
                    break;

                case 8:
                    opcion = 8;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Opcion incorrecta, vuelva a intentarlo");
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
 
        //Metodo para conocer el ultimo valor ingresado
        public int MostrarUltimoValorIngresado(){
            return ultimoValorIngresado.info;
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

            JOptionPane.showMessageDialog(null, Lista);
            Lista = "";
        }

    }
}
