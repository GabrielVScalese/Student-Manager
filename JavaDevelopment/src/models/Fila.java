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

    protected class No
    {
    	/**
    	 * Informação a ser guardada
    	 */
        protected X info;
        
        /**
         * Ponteiro da próxima informação
         */
        protected No prox;
        
        
        /**
         * Constrói uma nova instância da classe no
         * @param i informação a ser guardada
         * @param p ponteiro da próxima informação
         */

        public No (X i, No p)
        {
            this.info = i;
            this.prox = p;
        }
        /**
         * Constrói uma nova instância da classe no,este construtor é utilizado quando a estrutura de dados está vazia
         * @param i informação a ser guardada
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
         * Retorna o ponteiro do próximo dado
         * @return o ponteiro do próximo dado
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
         * Altera o ponteiro do próximo dado
         * @param p o novo ponteiro
         */
        public void setProx (No p)
        {
            this.prox = p;
        }
    }
/**
 * Ponteiros do início e do fim da estrutura de dados
 */
    protected No primeiro, ultimo;
/**
 * Insere um dado na fila
 * @param i O dado a ser inserido,seu tipo depende do tipo da fila
 * @throws Exception caso o parâmetro seja nulo
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
	 * Produz e resulta uma instância da classe String que
	 * representa a instância à qual este método for aplicado.
	 * @return o String que representa o resultado chamante do
	 * método.
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
     * Busca na fila o dado passado.Caso encontre retorna true,caso contrário false.
     * @param i O dado que se deseja buscar na fila
     * @return true caso exista o dado na fila e false caso contrário
     * @throws Exception caso o parâmetro seja null
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
 * Constrói uma nova instância da classe Fila
 */
    public Fila()
    {}

   /**
    * Retorna o elemento no início da fila mas sem remover
    * @return o primeiro elemento caso a fila não esteja vazia, se estiver retorna null
    */
    public X getSemRemover()
    {
    	if (isVazia())
            return null;
    	
        return this.primeiro.getInfo();
    }
    /**
     * Retorna o primeiro elemento da fila,removendo-o no processo
     * @return o elemento no início da fila
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
     * Checa se a fila está vazia retornando true em caso positivo e false em caso negativo
     * @return true caso não hajam elementos na fila e false em caso contrário
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
     * @return quantos elementos estão guardados na lista
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
     * Retorna uma cópia do elemento da fila que foi passado como parâmetro
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
        {} // pq sei que estou chamando clone de um objeto que Ã© Cloneable e, portanto, nao hÃ¡ risco do mÃ©todo nÃ£o existir ou de ser chamado com parametros errado

        return ret;
    }
}
