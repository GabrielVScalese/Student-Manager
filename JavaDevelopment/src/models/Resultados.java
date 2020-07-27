package models;

public class Resultados implements Cloneable
{
    protected int ra;
    protected int cod;
    protected float nota;
    protected float freq;

    public Resultados(int ra, int cod, float nota, float freq) throws Exception 
    {
        setRa(ra);
        setCod(cod);
        setNota(nota);
        setFreq(freq);
    }
    
    public void setRa(int ra) throws Exception 
    {
        if (ra < 0)
            throw new Exception("RA invalido");

        this.ra = ra;
    }

    public void setCod(int cod) throws Exception 
    {
        if (cod < 0)
            throw new Exception("Codigo invalido");

        this.cod = cod;
    }

    public void setNota(float nota) throws Exception 
    {
        if (nota < 0 || nota > 10)
            throw new Exception("Nota invalida");

        this.nota = nota;
    }

    public void setFreq(float freq) throws Exception 
    {
        if (freq < 0 || freq > 1)
            throw new Exception("Frequencia invalida");

        this.freq = freq;
    }

    public int getRa() 
    {
        return this.ra;
    }

    public int getCod() 
    {
        return this.cod;
    }

    public float getNota() 
    {
        return this.nota;
    }

    public float getFreq() 
    {
        return this.freq;
    }

    public boolean equals(Object obj) 
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        Resultados mat = (Resultados) obj;

        if (this.ra != mat.ra)
            return false;

        if (this.cod != mat.cod)
            return false;

        if (this.nota != mat.nota)
            return false;

        if (this.freq != mat.freq)
            return false;

        return true;
    }

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

    public String toString() 
    {
        return "RA: " + this.ra + " | " + "Cod: " + this.cod + " | " + "Nota: " + this.nota + " | " + "Freq: " + this.freq;
    }

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
