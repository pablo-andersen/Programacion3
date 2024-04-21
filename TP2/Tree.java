package TP2;

import java.util.ArrayList;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
    public int getRoot() throws Exception{
        if (this.root != null){
            return this.root.getValue();
        }
        else {
            throw new Exception("El arbol esta vacio");
        }
    }

    public boolean hasElem(int value) throws Exception{
        if(this.root != null) {
            return hasElem(this.root, value);
        }
        else {
            throw new Exception("El arbol está vacio");
        }
    }

    private boolean hasElem(TreeNode node, int value){ 
        if (node.getValue() == value){
            return true;
        }
        else if (node.getValue() > value){
            if (node.getLeft() != null){
                return hasElem(node.getLeft(), value);
            }
            else {
                return false;
            }
        }
        else {
            if (node.getRight() != null){
                return hasElem(node.getRight(), value);
            }
            else {
                return false;
            }
        }
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public int getHeight() throws Exception{
        if (this.root != null){
            return getHeight(this.root);
        }
        else {
            throw new Exception("El arbol esta vacio");
        }
    }

    private int getHeight(TreeNode node){
        if (node.getLeft() == null && node.getRight() == null){
            return 0;
        }
        else {
            int heightLeft = 0;
            int heightRight = 0;
            if (node.getLeft() != null){
                heightLeft = getHeight(node.getLeft());
            }
            if (node.getRight() != null){
                heightRight = getHeight(node.getRight());
            }
            if (heightLeft > heightRight){
                return 1 + heightLeft;
            }
            else {
                return 1 + heightRight;
            }            
        }
    }

    public ArrayList<Integer> getLongestBranch(){
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        if (this.root != null) {
            resultado.addAll(getLongestBranch(this.root));
        }
        return resultado;
    }

    private ArrayList<Integer> getLongestBranch(TreeNode node) {
        ArrayList<Integer> resultadoParcial = new ArrayList<Integer>();
        resultadoParcial.add(node.getValue());
        if(node.getRight() == null && node.getLeft() == null){
            return resultadoParcial;
        }
        else { 
            ArrayList<Integer> resultadoParcialDerecha = new ArrayList<Integer>();
            ArrayList<Integer> resultadoParcialIzquierda = new ArrayList<Integer>();
            if (node.getRight() != null){
                resultadoParcialDerecha = getLongestBranch(node.getRight());
            }
            if(node.getLeft() != null) {
                resultadoParcialIzquierda = getLongestBranch(node.getLeft());
            }
            if (resultadoParcialDerecha.size() > resultadoParcialIzquierda.size()){
                resultadoParcial.addAll(resultadoParcialDerecha);
            }
            else {
                resultadoParcial.addAll(resultadoParcialIzquierda);
            }
            return resultadoParcial;
        }
    }

    public ArrayList<Integer> getFrontera (){
        ArrayList<Integer>resultado = new ArrayList<Integer>();
        if (this.root != null){
            resultado.addAll(getFrontera(this.root));
        }
        return resultado;
    }   

    private ArrayList<Integer> getFrontera(TreeNode node){
        ArrayList<Integer> resultado  = new ArrayList<Integer>();
        if(node.getRight() == null && node.getLeft() == null){
            resultado.add(node.getValue());
        }
        else {
            if(node.getLeft() != null){
                resultado.addAll(getFrontera(node.getLeft()));
            }
            if(node.getRight() != null){
                resultado.addAll(getFrontera(node.getRight()));
            }
        }
        return resultado;
    }

    public int getMaxElement() throws Exception{
        if (this.root != null){
            return getMaxElement(this.root);
        }
        else {
            throw new Exception("El arbol esta vacio");
        }
    }

    private int getMaxElement(TreeNode node){
        if(node.getRight() == null){
            return node.getValue();
        }
        else{
            return getMaxElement(node.getRight());
        }
    }

    public int getMinElement() throws Exception{
        if(this.root  != null){
            return getMinElement(this.root);
        }
        else {
            throw new Exception("El arbol esta vacio");
        }
    }

    private int getMinElement(TreeNode node){
        if(node.getLeft() == null){
            return node.getValue();
        }
        else{
            return getMinElement(node.getLeft());
        }
    }

    public ArrayList<Integer> getElementAtLevel(int level) throws Exception{
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        if (this.root != null){
            resultado.addAll(getElementAtLevel(this.root, level));
        }
        else {
            throw new Exception("El arbol esta vacio");
        }
        return resultado;
    }

    private ArrayList<Integer> getElementAtLevel(TreeNode node, int level){
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        if (level == 0){
            resultado.add(node.getValue());
        }
        else {
            if (node.getLeft() != null){
                resultado.addAll(getElementAtLevel(node.getLeft(), level - 1));
            }
            if (node.getRight() != null){
                resultado.addAll(getElementAtLevel(node.getRight(), level - 1));
            }
        }
        return resultado;
    }

    public boolean delete(int value){
        if (this.root != null){
            return delete(this.root, null, value);
        }
        return false;
    }
    
    private boolean delete(TreeNode node, TreeNode previous, int value){
        if(node.getValue()== value){
            //hacer borrado
            if (node.getRight() == null && node.getLeft() == null){   //Caso 1 : soy una hoja
                if (previous == null){                                  //Caso 1.1 : ademas de una hoja, soy la raiz
                    this.root = null;                                   //"this.raiz = null" es equivalente a "actual = null" ???
                }
                else if(previous.getValue() > value){                   //Caso 1.2 : soy una hoja y mi padre tiene un valor mayor
                    previous.setLeft(null);
                }
                else {
                    previous.setRight(null);                              //Caso 1.3 : soy una hoja y mi padre tiene un valor menor
                }
            }
            else if (node.getRight() != null && node.getLeft() != null){  //Caso 2 : soy un nodo interno y tengo dos hijos
                int temp = getMinElement(node.getRight());                      //Busco el menor elemento del subarbol derecho
                node.setValue(temp);                                          // Reemplazo el valor del nodo a borrar por el menor del subarbol derecho
                return delete(node.getRight(), node, temp);                          // Llamo a borrar el menor elemento del subarbol derecho
            }
            else {
                if(node.getRight() != null) {                           //Caso 3 : soy un nodo interno y tengo un hijo derecho  
                    if(previous == null){                               //Caso 3.1 : Si anterior es null, soy la raiz
                        this.root = node.getRight();                    //Mi hijo derecho se convierte en la raiz
                    }                                                   //Si anterior no es null, soy un nodo interno (no la raiz)
                    else if(previous.getValue() > value){               //Caso 3.2 : soy un nodo interno con un hijo derecho y mi padre tiene un valor mayor
                        previous.setLeft(node.getRight());               // Mi hijo derecho se convierte en hijo izquierdo de mi padre
                    }
                    else {                                              //Caso 3.3 : soy un nodo interno con un hijo derecho y mi padre tiene un valor menor
                        previous.setRight(node.getRight());               // Mi hijo derecho se convierte en hijo derecho de mi padre
                    }                
                }                                              
                else {                                                  //Caso 4 : soy un nodo interno y tengo un hijo izquierdo
                    if(previous == null){                               //Caso 4.1 : Si anterior es null, soy la raiz
                        this.root = node.getLeft();                    //Mi hijo izquierdo se convierte en la raiz
                    }                                                   //Si anterior no es null, soy un nodo interno (no la raiz)
                    else if(previous.getValue() > value){              //Caso 4.2 : soy un nodo interno con un hijo izquierdo y mi padre tiene un valor mayor
                        previous.setLeft(node.getLeft());               // Mi hijo izquierdo se convierte en hijo izquierdo de mi padre
                    }
                    else {                                              //Caso 4.3 : soy un nodo interno con un hijo izquierdo y mi padre tiene un valor menor
                        previous.setRight(node.getLeft());               // Mi hijo izquierdo se convierte en hijo derecho de mi padre
                    }                            
                }
            }
            return true;
        } 
        else if(node.getValue() < value){                             //El valor del nodo actual es menor que el valor a borrar
            if(node.getRight()!= null){                                 //Si tengo hijo derecho, invoco a delete con el hijo derecho
                return delete(node.getRight(), node, value);
            }
            return false;
        }
        else {                                                          //El valor del nodo actual es mayor que el valor a borrar
            if(node.getLeft()!=null){                                  //Si tengo hijo izquierdo, invoco a delete con el hijo izquierdo
                return delete(node.getLeft(), node, value);
            }
            return false;
        }
    }
    
    public int sumaNodosInteriores() throws Exception{
        if (this.root != null){
            return sumaNodosInteriores(this.root);
        }
        else {
            throw new Exception("El arbol esta vacio");
        }
    }

    private int sumaNodosInteriores (TreeNode node){
        int resultadoParcial = 0;
        if(node.getRight() != null){
            resultadoParcial += sumaNodosInteriores(node.getRight());
        }
        if(node.getLeft() != null){
            resultadoParcial += sumaNodosInteriores(node.getLeft());
        }   
        if(node.getRight() != null || node.getLeft() != null){
            resultadoParcial += node.getValue();
        }
        return resultadoParcial;
    }
}