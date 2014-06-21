import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {

	private BufferedReader br;
	private String linhaAtual;
	private int index;
	
	public Leitor(String nomeArq){
		
		linhaAtual = "";
		index = 0;
		
		try{
			br = new BufferedReader(new FileReader(nomeArq));
			linhaAtual = br.readLine();
			System.out.println("Linha lida = " + linhaAtual);
		}catch(FileNotFoundException e){
			System.err.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.err.println("Erro na leitura do arquivo!");
		}
	}
	
	public char getNextCharacter(){
		
		try {
			br.ready();
		} catch (IOException e1) {
			System.err.println("Arquivo ja foi fechado!");
			return '¬';
		}
		
		if(index == linhaAtual.length()){
			index = 0;
			try {
				linhaAtual = br.readLine();
				if(linhaAtual == null){
					br.close();
					return '¬';
				}
			} catch (IOException e) {
				System.out.println("Erro na leitura do arquivo!");
			}

		}
		
		return linhaAtual.charAt(index++);
		
	}
	
}
