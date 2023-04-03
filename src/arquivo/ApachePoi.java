package arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\arquivo_excel.xls");
		if (!file.exists()) {
			file.createNewFile();
		}

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

		try (
			/**
			 * Usado para escrever a planilha
			 */
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook()) {
			/**
			 * Criar a planilha
			 */
			HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamentos");

			int numeroLinha = 0;
			for (Pessoa p : pessoas) {
				Row linha = linhasPessoa.createRow(numeroLinha++);/* criando linhas na planilha */

				int celula = 0;

				Cell celNome = linha.createCell(celula++);
				celNome.setCellValue(p.getNome());

				Cell celEmail = linha.createCell(celula++);
				celEmail.setCellValue(p.getEmail());

				Cell celIdade = linha.createCell(celula++);
				celIdade.setCellValue(p.getIdade());
			}
			
			FileOutputStream saida = new FileOutputStream(file);
			
			hssfWorkbook.write(saida);/*escreve a planilha em arquivo*/
			saida.flush();
			saida.close();
			
			System.out.println("Planilha foi criada");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
