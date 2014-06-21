import java.util.ArrayList;

public class Contexto {

	public ArrayList<Instancia> v;
	private String instancia;
	
	public Contexto(String inst){
		instancia = inst;
		v = new ArrayList<Instancia>();
	}
	
	public String getInstancia(){
		return instancia;
	}
	
	public int getTotal(){
		int total = 0;
		for(int i = 0; i < v.size(); i++){
			total += v.get(i).getFrequencia();
		}
		return total;
	}
	
	private void atualizaProbs(){
		double total = getTotal();
		
		for(int i = 0; i < v.size(); i++){
			v.get(i).setProbabilidade(((double)v.get(i).getFrequencia())/total);
		}
		
	}
	
	public void addOcorrencia(String s){
		
		if(!temIndice(s)){
			Instancia newInst1 = new Instancia(s, 1);
			if(!s.equals("ESC")) addOcorrencia("ESC");
			v.add(newInst1);
			atualizaProbs();
		}else{
			for(int i = 0; i < v.size(); i++){
				if(v.get(i).getSymbol().equals(s)){
					v.get(i).setFrequencia(v.get(i).getFrequencia() + 1);
					atualizaProbs();
					break;
				}
			}
		}
		
		v.sort(Instancia.InstanciaComparator);
	}
	
	public boolean temIndice(String s){
		for(int i = 0; i < v.size(); i++){
			if(v.get(i).getSymbol().equals(s)){
				return true;
			}
		}
		return false;
	}
	
	public Instancia getInstancia(String s){
		for(int i = 0; i < v.size(); i++){
			if(v.get(i).getSymbol().equals(s)){
				return v.get(i);
			}
		}
		return null;
	}
	
}
