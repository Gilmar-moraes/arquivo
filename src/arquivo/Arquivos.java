package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		//A TODO Auto-generated method stub
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Gilmar Moraes");
		pessoa.setEmail("gilmar@email.com");
		pessoa.setIdade(26);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Maria Moraes");
		pessoa2.setEmail("maria@email.com");
		pessoa2.setIdade(26);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Gilmara Moraes");
		pessoa3.setEmail("gilmara@email.com");
		pessoa3.setIdade(26);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		//File arquivo = new File("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\arquivo.txt");
		File arquivo = new File("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\arquivo.csv");
		
		if (arquivo.exists()) {
			arquivo.createNewFile();
		}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			//escrever_no_arquivo.write("######################### \nNome: " + p.getNome() + ";\n" + "E-mai: " + p.getEmail() + ";\n" + "Idade: " + p.getIdade() + "\n");
			escrever_no_arquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
	}

}
