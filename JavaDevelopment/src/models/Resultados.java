package models;

/** Classe com o objetivo de representar os resultados de um aluno após a conclusão de uma matéria.
 * @author Gabriel Villar Scalese, Vicente Pinto Tomás Junior, Vitor Mugnol Estevam de Araujo.
 * @since 2020
 */
public class Resultados implements Cloneable
{
	/**
	 * RA do aluno.
	 */
    protected int ra;
    
    /**
     * Código da matéria.
     */
    protected int cod;
    
    /**
     * Nota do aluno.
     */
    protected float nota;
    
    /**
     * Frequência do aluno.
     */
    protected float freq;
    
    /**
     * Constroi uma instância da classe Resultados, disparando exceção quando necessário.
     * @param ra , RA a ser atribuído.
     * @param cod , código de matéria a ser atribuído.
     * @param nota , nota a ser atribuída.
     * @param freq , frequência a ser atribuída.
     * @throws Exception , quando um dos parâmetros passados está incorreto.
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
     * @param ra , RA a ser atribuído.
     * @throws Exception , caso o parâmetro estiver incorreto.
     */
    public void setRa(int ra) throws Exception 
    {
        if (ra < 0)
            throw new Exception("RA invalido");

        this.ra = ra;
    }

    /**
     * Atribiu um valor para o atributo cod.
     * @param cod , código de matéria a ser atribuído.
     * @throws Exception , caso o parâmetro estiver incorreto.
     */
    public void setCod(int cod) throws Exception 
    {
        if (cod < 0)
            throw new Exception("Codigo invalido");

        this.cod = cod;
    }
    
    /**
     * Atribiu um valor para o atributo nota.
     * @param nota , nota a ser atribuída.
     * @throws Exception , caso o parâmetro estiver incorreto.
     */
    public void setNota(float nota) throws Exception 
    {
        if (nota < 0 || nota > 10)
            throw new Exception("Nota invalida");

        this.nota = nota;
    }

    /**
     * Atribiu um valor para o atributo freq.
     * @param freq , frequência a ser atribuída.
     * @throws Exception , caso o parâmetro estiver incorreto.
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
     * @return o código de matéria do aluno.
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
     * @return a frequência do aluno.
     */
    public float getFreq() 
    {
        return this.freq;
    }

    /**
	 * Verifica a igualdade entre dois Resultados.
	 * Verifica se o Object fornecido como parâmetro representa
	 * um resultado com conteúdo idêntico ao da instância à qual
	 * este método for aplicado, resultando true em caso afirmativo,
	 * ou false, caso contrário.
	 * @return true, caso o Object fornecido ao método e a instância
	 * chamante do método representarem frações numericamente
	 * equivalentes, ou false, caso contrário.
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
	 * Calcula o código de espalhamento (ou código de hash) de um
	 * Resultado.
	 * Calcula e resulta o código de espalhamento (ou código de
	 * hash, ou ainda o hashcode) do resultado representado pela
	 * instância à qual o método for aplicado.
	 * @return o código de espalhamento do produto chamante do método.
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
	 * Produz e resulta uma instância da classe String que
	 * representa a instância à qual este método for aplicado.
	 * @return o String que representa o resultado chamante do
	 * método.
	 */
    public String toString() 
    {
        return "RA: " + this.ra + " | " + "Cod: " + this.cod + " | " + "Nota: " + this.nota + " | " + "Freq: " + this.freq;
    }

    /**
	 * Produz uma cópia fiel de um resultado.
	 * Produz e resulta uma cópia exata do resultado à qual o método for aplicado.
	 * @return a cópia do resultado chamante do método.
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
	 * Constroi uma nova instância da classe Resultado.
	 * Para tanto, deve ser fornecida um resultado que servirá como
	 * modelo.
	 * @param modelo a instância que servirá como modelo.
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
