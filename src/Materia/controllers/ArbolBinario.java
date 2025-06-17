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



        }else if (value < padre.getValue()){
            //ME VOY A LA DERECHA

            padre.setRight(insertRec(padre.getRight(), value));
        }
        //  Tiene que retornar el padre
        /* 
         * 
         */
        return padre;
    }

     
}