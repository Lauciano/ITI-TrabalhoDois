
public class Instancia {

	private String simb;
	private int freq;
	private double prob;
	
	public Instancia(String s, int f){
		simb = s;
		freq = f;
	}
	
	public String getSymbol(){
		return simb;
	}
	
	public void setSymbol(String s){
		simb = s;
	}
	
	public int getFrequencia(){
		return freq;
	}
	
	public void setFrequencia(int f){
		freq = f;
	}
	
	public double getProbabilidade(){
		return prob;
	}
	
	public void setProbabilidade(double p){
		prob = p;
	}
}
