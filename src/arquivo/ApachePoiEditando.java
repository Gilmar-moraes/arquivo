package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\Users\\Junior\\eclipse-workspace\\arquivo\\src\\arquivo\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			
			Cell cell = linha.createCell(numeroCelulas);
			cell.setCellValue("5,000.00");
			}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		System.out.println("Planilha Atualizada!");
		}
	}
