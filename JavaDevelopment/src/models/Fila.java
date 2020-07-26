package models;

import java.lang.reflect.*;

public class Fila<X> implements Cloneable
{
    protected class No
    {
        protected X info;
        protected No prox;

        public No (X i, No p)
        {
            this.info = i;
            this.prox = p;
        }

        public No (X i)
        {
            this.info = i;
            this.prox = null;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    }

    protected No primeiro, ultimo;

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

    public void removaDoInicio () throws Exception
    {
    	if (this.primeiro==null /*&& this.ultimo==null*/)
            throw new Exception ("Nada a remover");

        if (this.primeiro==this.ultimo) //so 1 elemento
        {
            this.primeiro=null;
            this.ultimo  =null;
            return;
        }

        this.primeiro = this.primeiro.getProx();
    }

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

    public Fila(Fila<X> modelo) throws Exception // refatorar
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

    public Fila()
    {}

   
    public X getSemRemover()
    {
    	if (isVazia())
            return null;
    	
        if (this.primeiro.getInfo() instanceof Cloneable)
            return meuCloneDeX(this.primeiro.getInfo());
        else
           return this.primeiro.getInfo();
    }
    
    public X getInfo() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        No aux = new No (this.primeiro.getInfo(), this.primeiro.getProx());

        if (this.primeiro.getInfo() instanceof Cloneable)
        {
            removaDoInicio();
            return meuCloneDeX(aux.getInfo());
        }
        else
        {
            removaDoInicio();
            return aux.getInfo();
        }
    }

    public boolean isVazia()
    {
        if (this.ultimo == null && this.primeiro == null)
            return true;
        else
            return false;
    }

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
