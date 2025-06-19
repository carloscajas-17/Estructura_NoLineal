package Materia.controllers;
import Materia.models.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }
        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRec(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderRec(node.getLeft());
            preOrderRec(node.getRight());
        }
    }

    public void imprimirArbol() {
        imprimir(root);
        System.out.println();
    }

    private void imprimir(Node node) {
        if (node != null) {
            imprimir(node.getLeft());
            System.out.print(node.getValue() + "(H = " + getHeightRec(node) + ")");
            imprimir(node.getRight());
        }
    }

    public void imprimirBf() {
        imprimirBFRec(root);
        System.out.println();
    }

    private void imprimirBFRec(Node node) {
        if (node != null) {
            imprimirBFRec(node.getLeft());
            int bf = factorEquilibrioRec(node);
            System.out.print(node.getValue() + "(BF = " + bf + ")");
            imprimirBFRec(node.getRight());
        }
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node node, int value) {
        if (node == null) {
            return false;
        } else if (value == node.getValue()) {
            return true;
        } else if (value < node.getValue()) {
            return buscarRec(node.getLeft(), value);
        } else {
            return buscarRec(node.getRight(), value);
        }
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) return 0;
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int peso() {
        return pesoRec(root);
    }

    private int pesoRec(Node node) {
        if (node == null) return 0;
        return 1 + pesoRec(node.getLeft()) + pesoRec(node.getRight());
    }

    public int factorEquilibrio() {
        return factorEquilibrioRec(root);
    }

    
    private int factorEquilibrioRec(Node node) {
        if (node == null) return 0;
        int alturaIzq = getHeightRec(node.getLeft());
        int alturaDer = getHeightRec(node.getRight());
        return alturaIzq - alturaDer;
    }

    public boolean arbolEquilibrio() {
        return arbolEquilibrioRec(root);
    }

    private boolean arbolEquilibrioRec(Node node) {
        if (node == null) return true;
        int bf = factorEquilibrioRec(node);
        return (bf >= -1 && bf <= 1) &&
               arbolEquilibrioRec(node.getLeft()) &&
               arbolEquilibrioRec(node.getRight());
    }

    
    public void imprimirNodosDesequilibrados() {
        System.out.print("Nodos desequilibrados: ");
        imprimirNodosDesequilibradosRec(root);
        System.out.println();
    }

    private void imprimirNodosDesequilibradosRec(Node node) {
        if (node != null) {
            imprimirNodosDesequilibradosRec(node.getLeft());

            int bf = factorEquilibrioRec(node);
            if (Math.abs(bf) > 1) {
                System.out.print(node.getValue() + "(fE = " + bf + ") ");
            }

            imprimirNodosDesequilibradosRec(node.getRight());
        }
    }
}
