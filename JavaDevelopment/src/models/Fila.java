package models;

import java.lang.reflect.*;
/**
 *  Implementação de uma fila genérica utilizando ponteiros
 * @author Gabriel Villar Scalese, Vicente Pinto Tomás Junior, Vitor Mugnol Estevam de Araujo.
 * @param <X> Recebe o tipo o qual a fila guardará
 * @since 2020
 */
public class Fila<X> implements Cloneable
{
	/**
	 * Classe de gerenciamento de ponteiros responsável por auxiliar na implementação de outras estruturas de dados
	 * @author Gabriel Villar Scalese, Vicente Pinto Tomás Junior, Vitor Mugnol Estevam de Araujo.
	 */

	protected ListaSimplesDesordenada<X> lis;
	
    /**
    * Insere um dado na fila
    * @param i O dado a ser inserido,seu tipo depende do tipo da fila
    * @throws Exception caso o parâmetro seja nulo
    */
    public void insira (X i) throws Exception
    {
        lis.insiraNoFim(i);
    }
    /**
	 * Converte uma fila em um String.
	 * Produz e resulta uma instância da classe String que
	 * representa a instância à qual este método for aplicado.
	 * @return o String que representa o resultado chamante do
	 * método.
	 */
    public String toString ()
    {
        return lis.toString();
    }
    /**
	 * Calcula o código de espalhamento (ou código de hash) de uma
	 * Fila.
	 * Calcula e resulta o código de espalhamento (ou código de
	 * hash, ou ainda o hashcode) do resultado representado pela
	 * instância à qual o método for aplicado.
	 * @return o código de espalhamento do produto chamante do método.
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
	 * Verifica se o Object fornecido como parâmetro representa
	 * uma fila com conteúdo idêntico ao da instância à qual
	 * este método for aplicado, resultando true em caso afirmativo,
	 * ou false, caso contrário.
	 * @return true, caso o Object fornecido ao método e a instância
	 * chamante do método representarem frações numericamente
	 * equivalentes, ou false, caso contrário.
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
     * Busca na fila o dado passado.Caso encontre retorna true,caso contrário false.
     * @param i O dado que se deseja buscar na fila
     * @return true caso exista o dado na fila e false caso contrário
     * @throws Exception caso o parâmetro seja null
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
	 * Produz uma cópia fiel de uma fila.
	 * Produz e resulta uma cópia exata da fila à qual o método for aplicado.
	 * @return a cópia do resultado chamante do método.
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
   	 * Constroi uma nova instância da classe Fila.
   	 * Para tanto, deve ser fornecida uma fila que servirá como
   	 * modelo.
   	 * @param modelo a instância que servirá como modelo.
   	 * @throws Exception se o modelo for null.
   	 */
    public Fila(Fila<X> modelo) throws Exception
    {
        if (modelo == null)
        	throw new Exception ("Modelo ausente");
        
        this.lis = (ListaSimplesDesordenada)modelo.lis.clone();
    }
/**
 * Constrói uma nova instância da classe Fila
 */
    public Fila()
    {
    	lis = new ListaSimplesDesordenada<X>();
    }

    /**
     * Retorna o primeiro elemento da fila,removendo-o no processo
     * @return o elemento no início da fila
     * @throws Exception caso a fila esteja vazia
     */
    public X getInfo() throws Exception
    {
        X info = lis.getInfo();
        lis.removaDoInicio();
        return info;
    }
    /**
     * Checa se a fila está vazia retornando true em caso positivo e false em caso negativo
     * @return true caso não hajam elementos na fila e false em caso contrário
     */
    public boolean isVazia()
    {
        return lis.isVazia();
    }
    /**
     * Retorna a quantidade de elementos guardados na fila
     * @return quantos elementos estão guardados na lista
     */
    public int getQtd ()
    {
        return lis.getQtd();
    }
    /**
     * Retorna uma cópia do elemento da fila que foi passado como parâmetro
     * @param x o elemento a ser clonado
     * @return uma copia do elemento da fila
     */
    protected X meuCloneDeX (X x)
    {
        return lis.meuCloneDeX(x);
    }
}
