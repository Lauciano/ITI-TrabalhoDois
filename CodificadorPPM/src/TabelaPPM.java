import java.util.ArrayList;

public class TabelaPPM {
	private Contexto km1;
	private Contexto k0;
	private ArrayList<Contexto> k1;
	private ArrayList<Contexto> k2;
	private ArrayList<Character> alfabeto;
	
	// Construtores
	
	/* Construtor não vazio
	 * Passar a lista com os caracteres do alfabeto na forma de string */
	public TabelaPPM(ArrayList<Character> alfabeto){
		this.alfabeto = alfabeto;
		km1 = new Contexto("");
		k0 = new Contexto("");
		k1 = new ArrayList<Contexto>();
		k2 = new ArrayList<Contexto>();
		for(Character i : alfabeto){
			km1.addOcorrencia("" + i);
			km1.removeInstancia("ESC");
		}
	}
	
	/* Construtor vazio */
	public TabelaPPM(){
		km1 = new Contexto("");
		k0 = new Contexto("");
		k1 = new ArrayList<Contexto>();
		k2 = new ArrayList<Contexto>();
	}
	
	// Busca de Contexto
	public Contexto getContextoEmK1(String contexto){
		for(Contexto c : k1){
			if(c.getInstancia().equals(contexto)){
				return c;
			}
		}
		return null;
	}
	
	public Contexto getContextoEmK2(String contexto){
		for(Contexto c : k2){
			if(c.getInstancia().equals(contexto)){
				return c;
			}
		}
		return null;
	}
	
	// Gerando a Tabela
	public ArrayList<Intervalo> geraIntervalos(String arquivo){
		ArrayList<Intervalo> codigo = new ArrayList<Intervalo>();		
		Leitor leitor = new Leitor(arquivo);
		String lido, cpre = "", cprepre = "";
		Contexto caux;
		
		while(!(lido = "" + leitor.getNextCharacter()).equals("¬")){
			caux = getContextoEmK2(cprepre + cpre);
			if(caux != null){
				//Há contexto K2 cprepre cpre
				if(caux.temIndice(lido)){
					codigo.add(caux.getInstancia(lido).getIntervalo());
				} else {
					codigo.add(caux.getInstancia("ESC").getIntervalo());
				}
				caux.addOcorrencia(lido);
			} else if(!cprepre.equals("")){
				//Não há contexto K2, mas há cprepre
				//Portanto deve ser adicionado
				Contexto caux2 = new Contexto(cprepre + cpre);
				k2.add(caux2);
				caux2.addOcorrencia(lido);
			}
			
			caux = getContextoEmK1(cpre); //Esta linha será modificada com a remoção
			if(caux != null){
				//Há contexto K1 cpre
				if(caux.temIndice(lido)){
					codigo.add(caux.getInstancia(lido).getIntervalo());
				} else {
					codigo.add(caux.getInstancia("ESC").getIntervalo());
				}
				caux.addOcorrencia(lido);
			} else if(!cpre.equals("")){
				//Não há contexto K1, mas há cpre
				//Portanto deve ser adicionado
				Contexto caux2 = new Contexto(cpre);
				k1.add(caux2);
				caux2.addOcorrencia(lido);
			}
			
			//O k0 será modificado com a remoção
			if(k0.temIndice(lido)){
				codigo.add(k0.getInstancia(lido).getIntervalo());
			} else {
				if(k0.temIndice("ESC")){
					codigo.add(k0.getInstancia("ESC").getIntervalo());
				}
				codigo.add(km1.getInstancia(lido).getIntervalo());
				km1.removeInstancia(lido);
			}
			k0.addOcorrencia(lido);
			
			if(k0.v.size() == alfabeto.size() + 1){
				k0.removeInstancia("ESC");
			}
			
			for(Contexto c : k1){
				if(c.v.size() == alfabeto.size() + 1){
					c.removeInstancia("ESC");
				}
			}
			
			for(Contexto c : k2){
				if(c.v.size() == alfabeto.size() + 1){
					c.removeInstancia("ESC");
				}
			}
			
			cprepre = cpre;
			cpre = lido;
		}
		
		return codigo;
		
		/*if((s = "" + leitor.getNextCharacter()).equals("¬")) return null;
		codigo.add(km1.getInstancia(s).getIntervalo());
		k0.addOcorrencia(s);
		km1.removeInstancia(s);
		cpre = s;
		
		if((s = "" + leitor.getNextCharacter()).equals("¬")) return codigo;
		caux = getContextoEmK1(cpre);
		if(caux != null){
			if(caux.temIndice(s)){
				
			}
		} else {
			codigo.add(km1.getInstancia(s).getIntervalo());
			k0.addOcorrencia(s);
			km1.removeInstancia(s);
		}
		cprepre = cpre;
		cpre = s;*/
		
	}
	
	// Getters e Setters
	
	public Contexto getkm1() {
		return km1;
	}

	public void setkm1(Contexto km1) {
		this.km1 = km1;
	}

	public Contexto getK0() {
		return k0;
	}

	public void setK0(Contexto k0) {
		this.k0 = k0;
	}

	public ArrayList<Contexto> getK1() {
		return k1;
	}

	public void setK1(ArrayList<Contexto> k1) {
		this.k1 = k1;
	}

	public ArrayList<Contexto> getK2() {
		return k2;
	}

	public void setK2(ArrayList<Contexto> k2) {
		this.k2 = k2;
	}
	
}
