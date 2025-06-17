package Materia.controllers;
import Materia.models.Node;

public class ArbolBinario{
    private Node root;


    public ArbolBinario(){
        this.root=null;
    }
    
    public void insert(int value){
        root= insertRec(root,value);

    }
    //Metodo Recursivo para insertar un valor en el arbol binario
    private Node insertRec(Node padre, int value){
        if(padre==null){
            return new Node(value);
        }
        if(value < padre.getValue()){
            // ME VOY A LA IZQUIERDA
            padre.setLeft(insertRec(padre.getLeft(), value));



        }else if (value > padre.getValue()){
            //ME VOY A LA DERECHA

            padre.setRight(insertRec(padre.getRight(), value));
        }
        //  Tiene que retornar el padre
        /* 
         * 
         */
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

    public void imprimirArbol(){
        imprimir(root);
    }
    //Metodo recursivo para imprimir el arbol binario

    private void imprimir(Node node){
        if(node != null){
            imprimir(node.getLeft());
            System.out.print(node.getValue() + " ");
            imprimir(node.getRight());
        }
    }

    public boolean buscar(int value){
        return buscarRec(root,value);

    }
    private boolean buscarRec(Node node, int value){
        if(node == null) {
            return false;
        }else if (value == node.getValue()){
            return true;
        }else if (value < node.getValue()){
            return buscarRec(node.getLeft(),value);
        }else{
            return buscarRec(node.getRight(),value);

        }
        
    }
            


     
}