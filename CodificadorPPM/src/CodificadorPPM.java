
public class CodificadorPPM {
	public static void main(String[] args){
		System.out.println("************ Codificador PPM ***************");
		
		Leitor l = new Leitor("texto.txt");
		char c;
		
		while((c = l.getNextCharacter()) != '�'){
			System.out.println("lido = " + c + " and "  + (int)c);
		}
		
		Contexto abc = new Contexto("S");
		abc.addOcorrencia("S");
		abc.addOcorrencia("S");
		abc.addOcorrencia("A");
		
		Instancia a = abc.getInstancia("A");
		System.out.println("Freq = " + a.getFrequencia() + " Prob = " + a.getProbabilidade());
		Instancia s = abc.getInstancia("S");
		System.out.println("Freq = " + s.getFrequencia() + " Prob = " + s.getProbabilidade());
		Instancia esc = abc.getInstancia("S");
		System.out.println("Freq = " + esc.getFrequencia() + " Prob = " + esc.getProbabilidade());
		
		System.out.println("Total = " + abc.getTotal());
		
	}
}
