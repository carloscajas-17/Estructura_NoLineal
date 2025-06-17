import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab= new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

        ab.imprimirArbol();

        System.out.println("inOrder:");
        ab.inOrderTraversal();

        System.out.println("preOrder:");
        ab.preOrderTraversal();

        int valorBuscado = 23;
        System.out.println(valorBuscado + "? " + (ab.buscar(valorBuscado) ? "Encontrado " : "No encontrado "));

        valorBuscado = 100;
        System.out.println(valorBuscado + (ab.buscar(valorBuscado) ? "Encontrado" : " No encontrado "));

        
    }
   
}
