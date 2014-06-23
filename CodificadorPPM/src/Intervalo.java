
public class Intervalo {
	private double inicio;
	private double fim;
	
	// Contrutor
	
	public Intervalo(double inicio, double fim){
		this.inicio = inicio;
		this.fim = fim;
	}
	
	// Getters e Setters
	
	public double getInicio() {
		return inicio;
	}
	public void setInicio(double inicio) {
		this.inicio = inicio;
	}
	public double getFim() {
		return fim;
	}
	public void setFim(double fim) {
		this.fim = fim;
	}
	
	// To String
	public String toString(){
		return "[" + inicio + ", " + fim + ")";
	}
	
}
