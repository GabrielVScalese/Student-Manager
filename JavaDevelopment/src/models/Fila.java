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

    protected class No
    {
    	/**
    	 * Informa��o a ser guardada
    	 */
        protected X info;
        
        /**
         * Ponteiro da pr�xima informa��o
         */
        protected No prox;
        
        
        /**
         * Constr�i uma nova inst�ncia da classe no
         * @param i informa��o a ser guardada
         * @param p ponteiro da pr�xima informa��o
         */

        public No (X i, No p)
        {
            this.info = i;
            this.prox = p;
        }
        /**
         * Constr�i uma nova inst�ncia da classe no,este construtor � utilizado quando a estrutura de dados est� vazia
         * @param i informa��o a ser guardada
         */
        public No (X i)
        {
            this.info = i;
            this.prox = null;
        }
        /**
         * Retorna o dado do ponteiro atual
         * @return o dado guardado no ponteiro
         */
        public X getInfo ()
        {
            return this.info;
        }
        /**
         * Retorna o ponteiro do pr�ximo dado
         * @return o ponteiro do pr�ximo dado
         */
        public No getProx ()
        {
            return this.prox;
        }
        /**
         * Altera o dado guardado no ponteiro
         * @param i o dado a ser guardado
         */
        public void setInfo (X i)
        {
            this.info = i;
        }
        /**
         * Altera o ponteiro do pr�ximo dado
         * @param p o novo ponteiro
         */
        public void setProx (No p)
        {
            this.prox = p;
        }
    }
/**
 * Ponteiros do in�cio e do fim da estrutura de dados
 */
    protected No primeiro, ultimo;
/**
 * Insere um dado na fila
 * @param i O dado a ser inserido,seu tipo depende do tipo da fila
 * @throws Exception caso o par�metro seja nulo
 */
    public void insira (X i) throws Exception
    {
        if (i == null)
            throw new Exception ("Informacao ausente");

        if (this.primeiro == null && this.ultimo == null)
        {
            No novo = new No (i);
            this.primeiro = novo;
            this.ultimo = this.primeiro;
        }
        else
        {
            No valor = new No (i);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
            this.ultimo.setProx(null);
        }
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
        String ret = "{";

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getProx() != null)
                ret = ret + aux.getInfo() + ", ";
            else
                ret = ret + aux.getInfo();

            aux = aux.getProx();
        }

        return ret + "}";
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
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getInfo().hashCode();

            aux = aux.getProx();
        }

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

        No aux1 = this.primeiro;
        No aux2 = lis.primeiro;

        while (aux1 != null && aux2 != null)
        {
            if (aux1.getInfo().equals(aux2.getInfo()) == false)
                return false;

            aux1 = aux1.getProx();
            aux2 = aux2.getProx();
        }

        return true;
    }
    /**
     * Remove o primeiro dado na fila
     * @throws Exception caso a fila esteja vazia
     */
    public void removaDoInicio () throws Exception
    {
    	if (this.primeiro == null)
            throw new Exception ("Nada a remover");

        if (this.primeiro==this.ultimo)
        {
            this.primeiro=null;
            this.ultimo  =null;
            return;
        }

        this.primeiro = this.primeiro.getProx();
    }
    /**
     * Busca na fila o dado passado.Caso encontre retorna true,caso contr�rio false.
     * @param i O dado que se deseja buscar na fila
     * @return true caso exista o dado na fila e false caso contr�rio
     * @throws Exception caso o par�metro seja null
     */
    public boolean tem (X i) throws Exception
    {
        if (i == null)
            throw new Exception("Parametro ausente");

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getInfo() == null)
                aux = aux.getProx();
            else
            {
                if (aux.getInfo().equals(i) == true)
                {
                    return true;
                }
                else
                    aux = aux.getProx();
            }
        }

        return false;
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

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        No aux = this.primeiro;
        No aux2 = modelo.primeiro;
        while (aux != null)
        {
            aux.setInfo(aux2.getInfo());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }
/**
 * Constr�i uma nova inst�ncia da classe Fila
 */
    public Fila()
    {}

   /**
    * Retorna o elemento no in�cio da fila mas sem remover
    * @return o primeiro elemento caso a fila n�o esteja vazia, se estiver retorna null
    */
    public X getSemRemover()
    {
    	if (isVazia())
            return null;
    	
        return this.primeiro.getInfo();
    }
    /**
     * Retorna o primeiro elemento da fila,removendo-o no processo
     * @return o elemento no in�cio da fila
     * @throws Exception caso a fila esteja vazia
     */
    public X getInfo() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Fila esta vazia");

        No aux = new No (this.primeiro.getInfo(), this.primeiro.getProx());

        removaDoInicio();
        return aux.getInfo();
    }
    /**
     * Checa se a fila est� vazia retornando true em caso positivo e false em caso negativo
     * @return true caso n�o hajam elementos na fila e false em caso contr�rio
     */
    public boolean isVazia()
    {
        if (this.ultimo == null && this.primeiro == null)
            return true;
        else
            return false;
    }
    /**
     * Retorna a quantidade de elementos guardados na fila
     * @return quantos elementos est�o guardados na lista
     */
    public int getQtd ()
    {
        No aux = this.primeiro;
        int qtd = 0;
        while (aux != null)
        {
            qtd++;
            aux = aux.getProx();
        }

        return qtd;
    }
    /**
     * Retorna uma c�pia do elemento da fila que foi passado como par�metro
     * @param x o elemento a ser clonado
     * @return uma copia do elemento da fila
     */
    protected X meuCloneDeX (X x)
    {
        //return (X)x.clone();

        X ret=null;

        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tiposDosParms = null; // null pq clone nao tem parametros
            Method metodo = classe.getMethod("clone",tiposDosParms);
            Object[] parms = null; // null pq clone nao tem parametros
            ret = (X)metodo.invoke(x,parms);
        }
        catch (Exception erro)
        {} // pq sei que estou chamando clone de um objeto que é Cloneable e, portanto, nao há risco do método não existir ou de ser chamado com parametros errado

        return ret;
    }
}
