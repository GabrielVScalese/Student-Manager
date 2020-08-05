package models;

import java.lang.reflect.*;
/**
 *  Implementa��o de uma fila gen�rica utilizando ponteiros
 * @author Gabriel Villar Scalese, Vicente Pinto Tom�s Junior, Vitor Mugnol Estevam de Araujo.
 * @param <X> Recebe o tipo o qual a fila guardar�
 * @since 2020
 */
public class Fila<X> implements Cloneable
{
	/**
	 * Classe de gerenciamento de ponteiros respons�vel por auxiliar na implementa��o de outras estruturas de dados
	 * @author Gabriel Villar Scalese, Vicente Pinto Tom�s Junior, Vitor Mugnol Estevam de Araujo.
	 */

	protected ListaSimplesDesordenada<X> lis;
	
    /**
    * Insere um dado na fila
    * @param i O dado a ser inserido,seu tipo depende do tipo da fila
    * @throws Exception caso o par�metro seja nulo
    */
    public void insira (X i) throws Exception
    {
        lis.insiraNoFim(i);
    }
    /**
	 * Converte uma fila em um String.
	 * Produz e resulta uma inst�ncia da classe String que
	 * representa a inst�ncia � qual este m�todo for aplicado.
	 * @return o String que representa o resultado chamante do
	 * m�todo.
	 */
    public String toString ()
    {
        return lis.toString();
    }
    /**
	 * Calcula o c�digo de espalhamento (ou c�digo de hash) de uma
	 * Fila.
	 * Calcula e resulta o c�digo de espalhamento (ou c�digo de
	 * hash, ou ainda o hashcode) do resultado representado pela
	 * inst�ncia � qual o m�todo for aplicado.
	 * @return o c�digo de espalhamento do produto chamante do m�todo.
	 */
    public int hashCode ()
    {
        int ret = 17;
     
        ret = ret * 17 + this.lis.hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
	 * Verifica a igualdade entre duas Filas.
	 * Verifica se o Object fornecido como par�metro representa
	 * uma fila com conte�do id�ntico ao da inst�ncia � qual
	 * este m�todo for aplicado, resultando true em caso afirmativo,
	 * ou false, caso contr�rio.
	 * @return true, caso o Object fornecido ao m�todo e a inst�ncia
	 * chamante do m�todo representarem fra��es numericamente
	 * equivalentes, ou false, caso contr�rio.
	 */
    
    
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Fila<X> lis = (Fila)obj;

        if (this.getQtd() != lis.getQtd())
            return false;

       if (!this.lis.equals(lis.lis))
    	   return false;
       
       return true;
    }
    
    /**
     * Busca na fila o dado passado.Caso encontre retorna true,caso contr�rio false.
     * @param i O dado que se deseja buscar na fila
     * @return true caso exista o dado na fila e false caso contr�rio
     * @throws Exception caso o par�metro seja null
     */
    public boolean tem (X i) 
    {
    	boolean res = false;
    	try 
    	{
			res = lis.tem(i);
		} 
    	catch (Exception e) 
    	{
			System.out.println(e.getMessage());
		}
    	
    	return res;
    }
    /**
	 * Produz uma c�pia fiel de uma fila.
	 * Produz e resulta uma c�pia exata da fila � qual o m�todo for aplicado.
	 * @return a c�pia do resultado chamante do m�todo.
	 */
    public Object clone ()
    {
        Fila<X> ret = null;
        try
        {
            ret = new Fila<X>(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
    /**
   	 * Constroi uma nova inst�ncia da classe Fila.
   	 * Para tanto, deve ser fornecida uma fila que servir� como
   	 * modelo.
   	 * @param modelo a inst�ncia que servir� como modelo.
   	 * @throws Exception se o modelo for null.
   	 */
    public Fila(Fila<X> modelo) throws Exception
    {
        if (modelo == null)
        	throw new Exception ("Modelo ausente");
        
        this.lis = (ListaSimplesDesordenada)modelo.lis.clone();
    }
/**
 * Constr�i uma nova inst�ncia da classe Fila
 */
    public Fila()
    {
    	lis = new ListaSimplesDesordenada<X>();
    }

    /**
     * Retorna o primeiro elemento da fila,removendo-o no processo
     * @return o elemento no in�cio da fila
     * @throws Exception caso a fila esteja vazia
     */
    public X getInfo() throws Exception
    {
        X info = lis.getInfo();
        lis.removaDoInicio();
        return info;
    }
    /**
     * Checa se a fila est� vazia retornando true em caso positivo e false em caso negativo
     * @return true caso n�o hajam elementos na fila e false em caso contr�rio
     */
    public boolean isVazia()
    {
        return lis.isVazia();
    }
    /**
     * Retorna a quantidade de elementos guardados na fila
     * @return quantos elementos est�o guardados na lista
     */
    public int getQtd ()
    {
        return lis.getQtd();
    }
    /**
     * Retorna uma c�pia do elemento da fila que foi passado como par�metro
     * @param x o elemento a ser clonado
     * @return uma copia do elemento da fila
     */
    protected X meuCloneDeX (X x)
    {
        return lis.meuCloneDeX(x);
    }
}
