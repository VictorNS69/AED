package aed.recursion;

import aed.positionlist.*;


/**
 * Defines a number of recursive methods.
 */
public class RecursiveMethods {


    /**
     * Calculates a^n using recursion.
     * It is assumed that n>=0.
     * @return a^n.
     */
    public static int power(int a, int n) {
    	if(n==0){
    		return 1;
    	}
    	if(n==1){
    		return a;
    	}
    	if(n%2==0){
    		int b = power(a,n/2);
    		return b*b;
    	}
    	else{
    		return a * power(a,n-1);
    	}
    }

    /**
     * Returns the indice of a peak element in arr.
     * It is assumed that arr is not empty.
     */
    static public int findPeak(MyInteger[] arr) {
    	if(arr.length==1)
    		return 0;
    	if(arr.length==2){
    		if(arr[0].compareTo(arr[1])>=0)
    			return 0;
    		else
    			return 1;
    	}
    	
    	else{
    		int pos= arr.length/2;
    		return findMid(pos,arr);
    	}
    }
    static private int findMid (int pos, MyInteger[] arr){
    	int compLeft;
    	int compRight;
    	//Primero nos aseguramos que no estamos en el "borde" del vector
    		//Primero al comparar con un elemento a la izq
	    	if(pos!=0)
	    		compLeft = arr[pos].compareTo(arr[pos-1]);
	    	else
	    		compLeft = 1;
	    	//Luego con el elemento a su derecha
	    	if(!(pos+1>=arr.length))
	    		compRight = arr[pos].compareTo(arr[pos+1]);
	    	else
	    		compRight = 1;
    	
    	//Posibles situaciones en las que nos podemos encontrar
	    	//Que sea el elemento M un pico
    	if(compLeft>=0 && compRight>=0)
    		return pos;
    		//Que el elemento a su izq sea mayor que él
    	if(compLeft<0)
    		return findLeft(pos-1,arr);
    		//Que el elemento a su derecha sea mayor que él
    	if(compRight<0)
    		return findRight(pos+1,arr);
    	//Debería de salir por alguno de los ifs anteriores, pero añadimos este ultimo
    	//Para evitar problemas con el compilador
    	return -5;
    }
    static private int findLeft(int pos, MyInteger[]arr){
    	if(pos==0)
    		return pos;
    	else{
    		int compLeft = arr[pos].compareTo(arr[pos-1]);
        	if(compLeft>=0)
        		return pos;
        	else
        		return findLeft(pos-1,arr);
    	}
    	
    }
    static private int findRight (int pos, MyInteger[]arr){
    	if(pos==arr.length-1)
    		return pos;
    	int compRight = arr[pos].compareTo(arr[pos+1]);
    	if(compRight>=0)
    		return pos;
    	else
    		return findRight(pos+1,arr);
    	
    }

    /**
     * Returns a new list corresponding to the multiset which is
     * the result of merging the multiset arguments l1 and l2.
     * It is assumed that l1 and l2 are sorted in ascending order,
     * and it is required that the result is sorted in ascending order.
     */
    static public PositionList<Pair<Integer,Integer>> mergeMultisets
    	(PositionList<Pair<Integer,Integer>> l1, 
		   PositionList<Pair<Integer,Integer>> l2) {
    	PositionList<Pair<Integer,Integer>> nuevaLista;
    	//Primero de todo creamos una nueva lista en la que insertar los elementos
    	//Necesitaremos tambien un metodo auxiliar para realizar la recursividad
    	int compFirst=l1.first().element().getLeft().compareTo(l2.first().element().getLeft());
    	if(compFirst>0)
    		nuevaLista= new PositionList(l1.first());
    	if(compFirst<0)
    		nuevaLista = new PositionList(l2.first());
    	else{
    		nuevaLista = new PositionList(new Pair(l1.first(),l1.first().element().getRight()+l2.first().element().getRight()));
    	}
    		
    	PositionList<Pair<Integer,Integer>> nuevaLista()
	return null;
    }
}
