
public class CodificadorPPM {
	public static void main(String[] args){
		System.out.println("************ Codificador PPM ***************");
		
		Leitor l = new Leitor("texto.txt");
		char c;
		
		while((c = l.getNextCharacter()) != '¬'){
			System.out.println("lido = " + c + " and "  + (int)c);
		}
	}
}
