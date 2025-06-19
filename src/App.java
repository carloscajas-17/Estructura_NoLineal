import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();

        
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        
        System.out.println(" Nombre : Andres Cajas T");

        ab.imprimirArbol();
        System.out.println(" Tamaño del Arbol " + ab.getHeight());
        System.out.println(" Peso del Arbol " + ab.peso());

       
        System.out.println("inOrder:");
        ab.inOrderTraversal();

        System.out.println("preOrder:");
        ab.preOrderTraversal();

       
        int valorBuscado = 23;
        System.out.println(valorBuscado + "? " + (ab.buscar(valorBuscado) ? " Encontrado " : "No encontrado "));

        valorBuscado = 100;
        System.out.println(valorBuscado + (ab.buscar(valorBuscado) ? " Encontrado" : " No encontrado "));

        
        System.out.println(" Arbol InOrder con alturas");
        ab.imprimirArbol();

        
        System.out.println("Arbol InOrder con factor de equilibrio");
        ab.imprimirBf();

        System.out.println("Arbol esta equilibrado = " + String.valueOf(ab.arbolEquilibrio()).toUpperCase());

        if (!ab.arbolEquilibrio()) {
            ab.imprimirNodosDesequilibrados();
        }

        
        System.out.println(" Agregamos el valor = 15 ");
        ab.insert(15);

        System.out.println("\nArbol InOrder con factor de equilibrio después de insertar 15:");
        ab.imprimirBf();

        System.out.println("Arbol esta equilibrado = " + String.valueOf(ab.arbolEquilibrio()).toUpperCase());

        if (!ab.arbolEquilibrio()) {
            ab.imprimirNodosDesequilibrados();
        }
    }
}
