package models;

/** Classe com o objetivo de representar os resultados de um aluno ap�s a conclus�o de uma mat�ria.
 * @author Gabriel Villar Scalese, Vicente Pinto Tom�s Junior, Vitor Mugnol Estevam de Araujo.
 * @since 2020
 */
public class Resultados implements Cloneable
{
	/**
	 * RA do aluno.
	 */
    protected int ra;
    
    /**
     * C�digo da mat�ria.
     */
    protected int cod;
    
    /**
     * Nota do aluno.
     */
    protected float nota;
    
    /**
     * Frequ�ncia do aluno.
     */
    protected float freq;
    
    /**
     * Constroi uma inst�ncia da classe Resultados, disparando exce��o quando necess�rio.
     * @param ra , RA a ser atribu�do.
     * @param cod , c�digo de mat�ria a ser atribu�do.
     * @param nota , nota a ser atribu�da.
     * @param freq , frequ�ncia a ser atribu�da.
     * @throws Exception , quando um dos par�metros passados est� incorreto.
     */
    public Resultados(int ra, int cod, float nota, float freq) throws Exception 
    {
        setRa(ra);
        setCod(cod);
        setNota(nota);
        setFreq(freq);
    }
    
    /**
     * Atribiu um valor para o atributo ra.
     * @param ra , RA a ser atribu�do.
     * @throws Exception , caso o par�metro estiver incorreto.
     */
    public void setRa(int ra) throws Exception 
    {
        if (ra < 0)
            throw new Exception("RA invalido");

        this.ra = ra;
    }

    /**
     * Atribiu um valor para o atributo cod.
     * @param cod , c�digo de mat�ria a ser atribu�do.
     * @throws Exception , caso o par�metro estiver incorreto.
     */
    public void setCod(int cod) throws Exception 
    {
        if (cod < 0)
            throw new Exception("Codigo invalido");

        this.cod = cod;
    }
    
    /**
     * Atribiu um valor para o atributo nota.
     * @param nota , nota a ser atribu�da.
     * @throws Exception , caso o par�metro estiver incorreto.
     */
    public void setNota(float nota) throws Exception 
    {
        if (nota < 0 || nota > 10)
            throw new Exception("Nota invalida");

        this.nota = nota;
    }

    /**
     * Atribiu um valor para o atributo freq.
     * @param freq , frequ�ncia a ser atribu�da.
     * @throws Exception , caso o par�metro estiver incorreto.
     */
    public void setFreq(float freq) throws Exception 
    {
        if (freq < 0 || freq > 1)
            throw new Exception("Frequencia invalida");

        this.freq = freq;
    }

    /**
     * Obtem o valor do atributo ra.
     * @return o RA do aluno
     */
    public int getRa() 
    {
        return this.ra;
    }

    /**
     * Obtem o valor do atributo cod.
     * @return o c�digo de mat�ria do aluno.
     */
    public int getCod() 
    {
        return this.cod;
    }

    /**
     * Obtem o valor do atributo nota.
     * @return a nota do aluno.
     */
    public float getNota() 
    {
        return this.nota;
    }

    /**
     * Obtem o valor do atributo freq.
     * @return a frequ�ncia do aluno.
     */
    public float getFreq() 
    {
        return this.freq;
    }

    /**
	 * Verifica a igualdade entre dois Resultados.
	 * Verifica se o Object fornecido como par�metro representa
	 * um resultado com conte�do id�ntico ao da inst�ncia � qual
	 * este m�todo for aplicado, resultando true em caso afirmativo,
	 * ou false, caso contr�rio.
	 * @return true, caso o Object fornecido ao m�todo e a inst�ncia
	 * chamante do m�todo representarem fra��es numericamente
	 * equivalentes, ou false, caso contr�rio.
	 */
    public boolean equals(Object obj) 
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        Resultados res = (Resultados) obj;

        if (this.ra != res.ra)
            return false;

        if (this.cod != res.cod)
            return false;

        if (this.nota != res.nota)
            return false;

        if (this.freq != res.freq)
            return false;

        return true;
    }

    /**
	 * Calcula o c�digo de espalhamento (ou c�digo de hash) de um
	 * Resultado.
	 * Calcula e resulta o c�digo de espalhamento (ou c�digo de
	 * hash, ou ainda o hashcode) do resultado representado pela
	 * inst�ncia � qual o m�todo for aplicado.
	 * @return o c�digo de espalhamento do produto chamante do m�todo.
	 */
    public int hashCode() 
    {
        int ret = 17;

        ret = ret * 17 + Integer.valueOf(this.ra).hashCode();
        ret = ret * 17 + Integer.valueOf(this.cod).hashCode();
        ret = ret * 17 + Float.valueOf(this.nota).hashCode();
        ret = ret * 17 + Float.valueOf(this.freq).hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
	 * Converte um resultado em um String.
	 * Produz e resulta uma inst�ncia da classe String que
	 * representa a inst�ncia � qual este m�todo for aplicado.
	 * @return o String que representa o resultado chamante do
	 * m�todo.
	 */
    public String toString() 
    {
        return "RA: " + this.ra + " | " + "Cod: " + this.cod + " | " + "Nota: " + this.nota + " | " + "Freq: " + this.freq;
    }

    /**
	 * Produz uma c�pia fiel de um resultado.
	 * Produz e resulta uma c�pia exata do resultado � qual o m�todo for aplicado.
	 * @return a c�pia do resultado chamante do m�todo.
	 */
    public Object clone (Object obj)
    {
    	Resultados ret = null;
    	try
    	{
    		ret = new Resultados (this);
    	}
    	catch (Exception e)
    	{}
    	
    	return ret;
    }
    
    /**
	 * Constroi uma nova inst�ncia da classe Resultado.
	 * Para tanto, deve ser fornecida um resultado que servir� como
	 * modelo.
	 * @param modelo a inst�ncia que servir� como modelo.
	 * @throws Exception se o modelo for null.
	 */
    public Resultados (Resultados modelo) throws Exception
    {
    	if (modelo == null)
    		throw new Exception ("Modelo ausente");
    	
    	this.ra = modelo.ra;
    	this.cod = modelo.cod;
    	this.nota = modelo.nota;
    	this.freq = modelo.freq;
    }
}
