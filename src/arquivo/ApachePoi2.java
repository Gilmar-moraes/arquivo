package arquivo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream entrada = new FileInputStream("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\arquivo_excel.xls");
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while (linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while (celulas.hasNext()) {
				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				default:
					break;
				}
				
			}
			
			pessoas.add(pessoa);
		}
		
		entrada.close();
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

}
