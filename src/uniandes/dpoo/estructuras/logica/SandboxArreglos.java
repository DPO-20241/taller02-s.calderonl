package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre
 * arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y
 * arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas
 * como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos {
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero
     * vacíos (tamaño 0)
     */
    public SandboxArreglos() {
        arregloEnteros = new int[] {};
        arregloCadenas = new String[] {};
    }

    private static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] <= right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo
     * tamaño que contiene copias de los valores del arreglo original
     * 
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros() {

        int[] copyArray = new int[arregloEnteros.length];
        
        for (int i = 0; i < arregloEnteros.length; i++) {
            copyArray[i] = arregloEnteros[i];
        }

        return copyArray;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo
     * tamaño que contiene copias de los valores del arreglo original
     * 
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas() {
        String[] copyArray = new String[arregloCadenas.length];

        for (int i = 0; i < arregloCadenas.length; i++) {
            copyArray[i] = arregloCadenas[i];
        }

        return copyArray;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * 
     * @return
     */
    public int getCantidadEnteros() {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * 
     * @return
     */
    public int getCantidadCadenas() {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
     * debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero(int entero) {
        int[] originalArray = getCopiaEnteros();
        arregloEnteros = new int[originalArray.length + 1];

        for (int i = 0; i < originalArray.length; i++) {
            arregloEnteros[i] = originalArray[i];
        }

        arregloEnteros[arregloEnteros.length - 1] = entero;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
     * debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena(String cadena) {
        String[] originalArray = getCopiaCadenas();
        arregloCadenas = new String[originalArray.length + 1];

        for (int i = 0; i < originalArray.length; i++) {
            arregloCadenas[i] = originalArray[i];
        }

        arregloCadenas[arregloCadenas.length - 1] = cadena;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de
     * enteros
     * 
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero(int valor) {

        int newSize = 0;

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != valor) {
                newSize++;
            }
        }

        int[] newArray = new int[newSize];

        int newIndex = 0;

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != valor) {
                newArray[newIndex] = arregloEnteros[i];
                newIndex++;
            }
        }

        arregloEnteros = newArray.clone();

        // NOTE No se si es la mejor solución al problema, pero no se me ocurrio una
        // diferente
        // debido al problema de arrays de tamanio fijo. Si hay una mejor solucion me
        // gustaria
        // poder sabela :)

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de
     * cadenas
     * 
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena(String cadena) {
        int newSize = 0;

        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i] != cadena) {
                newSize++;
            }
        }

        String[] newArray = new String[newSize];

        int newIndex = 0;

        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i] != cadena) {
                newArray[newIndex] = arregloCadenas[i];
                newIndex++;
            }
        }

        arregloCadenas = newArray.clone();
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero   El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo
     *                 aumentado. Si la posición es menor a 0, se inserta el valor
     *                 en la primera posición. Si la
     *                 posición es mayor que el tamaño del arreglo, se inserta el
     *                 valor en la última posición.
     */
    public void insertarEntero(int entero, int posicion) {
        // Create a new array with one more position
        int[] newArr = new int[arregloEnteros.length + 1];
        int additional = 0;
        if (posicion < 0) {
            newArr[0] = entero;
            additional = 1;
        } else if (posicion >= arregloEnteros.length) {
            newArr[newArr.length - 1] = entero;
        }

        // Copy elements from old array to the new array
        for (int i = 0, j = 0 + additional; i < arregloEnteros.length; i++, j++) {
            // When the position is reached, insert the new element
            if (i == posicion) {
                newArr[j] = entero;
                j++; // Increment the position for the new array
            }
            newArr[j] = arregloEnteros[i];
        }

        // If the position is greater than the size of the array, add the new element at
        // the end
        

        // Replace old array with the new array
        arregloEnteros = newArr.clone();
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * 
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si
     *                 el parámetro posicion no corresponde a ninguna posición del
     *                 arreglo de enteros, el método
     *                 no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion(int posicion) {
        // Check if the position is valid
        if (posicion < 0 || posicion >= arregloEnteros.length) {
            return; // If the position is invalid, do nothing
        }

        // Create a new array with one less position
        int[] newArr = new int[arregloEnteros.length - 1];

        // Copy elements from old array to the new array
        for (int i = 0, j = 0; i < arregloEnteros.length; i++) {
            // Skip the element at the given position
            if (i == posicion) {
                continue;
            }
            newArr[j++] = arregloEnteros[i];
        }

        arregloEnteros = newArr;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del
     * parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería
     * quedar el entero 3.
     * 
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros(double[] valores) {
        arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            arregloEnteros[i] = (int) valores[i];
        }
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los
     * objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * 
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas(Object[] objetos) {
        arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            arregloCadenas[i] = objetos[i].toString();
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar
     * el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos() {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] *= -1;
            }
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados
     * de menor a mayor.
     */
    public void organizarEnteros() {
        arregloEnteros = mergeSort(arregloEnteros);

    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados
     * lexicográficamente.
     */
    public void organizarCadenas() {
        bubbleSort(arregloCadenas);

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de
     * enteros
     * 
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones(int valor) {
        int count = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo
     * de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * 
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones(String cadena) {
        int count = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            if (arregloCadenas[i].equalsIgnoreCase(cadena)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se
     * recibe en el parámetro
     * 
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros
     *         en las que se encuentra el valor buscado. Si el valor no se
     *         encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero(int valor) {
        int[] positions = new int[0];

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                int[] newArr = new int[positions.length + 1];
                System.arraycopy(positions, 0, newArr, 0, positions.length);
                newArr[positions.length] = i;
                positions = newArr;
            }
        }

        return positions;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * 
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el
     *         valor mínimo en el arreglo de enteros; en la segunda posición, debe
     *         estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un
     *         arreglo vacío.
     */
    public int[] calcularRangoEnteros() {

        if (arregloEnteros.length == 0) {
            return new int[] {};
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < min) {
                min = arregloEnteros[i];
            }
            if (arregloEnteros[i] > max) {
                max = arregloEnteros[i];
            }
        }

        return new int[] { min, max };
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve
     * como un mapa donde las llaves son los valores del arreglo y los valores son
     * la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * 
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> histogram = new HashMap<>();
        for (int i : arregloEnteros) {
            if (histogram.containsKey(i)) {
                histogram.put(i, histogram.get(i) + 1);
            } else {
                histogram.put(i, 1);
            }
        }
        return histogram;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * 
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos() {
        int count = 0;
        HashMap<Integer, Integer> histogram = calcularHistograma();
        for (int i : histogram.values()) {
            if (i > 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son
     * iguales, es decir que contienen los mismos elementos exactamente en el mismo
     * orden.
     * 
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros(int[] otroArreglo) {
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != otroArreglo[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que
     * tengan los mismos elementos, aunque podría ser en otro orden.
     * 
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros(int[] otroArreglo) {
        if (arregloEnteros.length != otroArreglo.length) {
            return false;
        }
        HashMap<Integer, Integer> histogram = calcularHistograma();
        for (int i : otroArreglo) {
            if (!histogram.containsKey(i)) {
                return false;
            }
            if (histogram.get(i) == 0) {
                return false;
            }
            histogram.put(i, histogram.get(i) - 1);
        }
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores
     * generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando
     * Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * 
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo   El valor mínimo para los números generados
     * @param maximo   El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int minimo, int maximo) {
        arregloEnteros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            int integer = (int) (Math.random() * (maximo - minimo + 1)) + minimo;  
            arregloEnteros[i] = integer;
            
        }

    }

}
