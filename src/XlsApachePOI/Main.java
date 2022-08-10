package XlsApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFShapeFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import dao.DaoCliente;
import myclasses.Cliente;
import myclasses.Pessoas;

public class Main {

	public static void main(String[] args) throws IOException {

//		File arquivo = new File("/home/fesoalll/Documentos/0.java/JAVADEV/dados/at15.xls");
//
//		DaoCliente daocliente = new DaoCliente();
//		if(!arquivo.exists()) {
//			System.out.println("Arquivo não existe");
//			//arquivo.createNewFile();
//		}else {
//			System.out.println("Arquivo existe");
//		}
		/*
		 * FileWriter escreve_arquivo = new FileWriter(arquivo);
		 * 
		 * //******************************************************** Pessoas pessoa1 =
		 * new Pessoas(); pessoa1.setNome("fesoalll"); pessoa1.setSobrenome("fradeto");
		 * pessoa1.setEmail("fesoalll9@hotmail.com");
		 * 
		 * Pessoas pessoa2 = new Pessoas(); pessoa2.setNome("jacck");
		 * pessoa2.setSobrenome("spehow"); pessoa2.setEmail("jamenba@hotmail.com");
		 * 
		 * Pessoas pessoa3 = new Pessoas(); pessoa3.setNome("Mc");
		 * pessoa3.setSobrenome("spock"); pessoa3.setEmail("fesoalll3@hotmail.com");
		 * 
		 * List<Pessoas> pessoas = new ArrayList<Pessoas>();
		 * 
		 * pessoas.add(pessoa1); pessoas.add(pessoa2); pessoas.add(pessoa3);
		 * 
		 * HSSFWorkbook workbook = new HSSFWorkbook(); HSSFSheet sheet =
		 * workbook.createSheet("Planilha de treinamento JDev treinamento");
		 * 
		 * int numeroLinha = 0;
		 * 
		 * for(Pessoas p: pessoas ) {
		 * 
		 * 
		 * Row linha = sheet.createRow(numeroLinha++); int celula = 0;
		 * 
		 * Cell cellNome = linha.createCell(celula++);
		 * cellNome.setCellValue(p.getNome());
		 * 
		 * Cell cellSobrenome = linha.createCell(celula++);
		 * cellSobrenome.setCellValue(p.getSobrenome());
		 * 
		 * Cell cellEmail = linha.createCell(celula++);
		 * cellEmail.setCellValue(p.getEmail());
		 * 
		 * 
		 * 
		 * }
		 * 
		 * FileOutputStream saida = new FileOutputStream(arquivo);
		 * workbook.write(saida);
		 * 
		 * escreve_arquivo.flush(); escreve_arquivo.close();
		 */
		List<String> files = new ArrayList<String>();
		String file;
		
		for(int z = 1;z < 21; z++) {
			file = "/home/fesoalll/Documentos/0.java/JAVADEV/dados/at"+z+".xls";
			files.add(file);
		}
		
		
		
		
		for(int i = 0;i < files.size(); i++) {
			System.out.println(files.size());
		File arquivo = new File(files.get(i));

		DaoCliente daocliente = new DaoCliente();
		if(!arquivo.exists()) {
			System.out.println("Arquivo não existe");
			//arquivo.createNewFile();
		}else {
			System.out.println("Arquivo existe");
		}
		System.out.println("Reading the files now.");
		
		
		FileInputStream fileIn = new FileInputStream(arquivo);
		
		System.out.println("arquivo");
		try (HSSFWorkbook workbook2 = new HSSFWorkbook(fileIn)) {
			
			HSSFSheet sheet2 = workbook2.getSheetAt(0);
			
			FormulaEvaluator evaluator = workbook2.getCreationHelper().createFormulaEvaluator(); 
			System.out.println("arquivo");
			Iterator<Row> linha = sheet2.iterator();

			List<Cliente> clientes = new ArrayList<Cliente>();
			System.out.println("while");
			while(linha.hasNext()) {

				Row line2 = linha.next();
				Iterator<Cell> celula =  line2.iterator();
				Cliente cliente = new Cliente();

				
				
				while(celula.hasNext()) {
					Cell cell = celula.next();
					
					switch(cell.getColumnIndex()) {
					
					case 0:
						
						if (cell.getCellType() != CellType.FORMULA) {
							System.out.println("ok");
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setCpf(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setCpf(String.valueOf( (long)cell.getNumericCellValue()));
						        	
						            break;
						        case STRING:
						        	cliente.setCpf(cell.getStringCellValue());
						            break;
						    }
						}
						
						break;
					case 1:
						
						if (cell.getCellType() != CellType.FORMULA) {
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setContato1(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setContato1(String.valueOf((long)cell.getNumericCellValue()));
						            break;
						        case STRING:
						        	cliente.setContato1(cell.getStringCellValue());
						            break;
						    }
						}
						break;
					case 2:
						
						
						if (cell.getCellType() != CellType.FORMULA) {
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setContato2(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setContato2(String.valueOf((long)cell.getNumericCellValue()));
						            break;
						        case STRING:
						        	cliente.setContato2(cell.getStringCellValue());
						            break;
						    }
						}
						break;
					case 3:
						
						
						if (cell.getCellType() != CellType.FORMULA) {
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setContato3(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setContato3(String.valueOf((long)cell.getNumericCellValue()));
						            break;
						        case STRING:
						        	cliente.setContato3(cell.getStringCellValue());
						            break;
						    }
						}
						
						break;
						
						case 4:
						
						
						if (cell.getCellType() != CellType.FORMULA) {
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setClientenome(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setClientenome(String.valueOf((long)cell.getNumericCellValue()));
						            break;
						        case STRING:
						        	cliente.setClientenome(cell.getStringCellValue());
						            break;
						    }
						}
						
						break;	
						
					case 5:
						
						
						if (cell.getCellType() != CellType.FORMULA) {
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setEndereco(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setEndereco(String.valueOf((long)cell.getNumericCellValue()));
						            break;
						        case STRING:
						        	cliente.setEndereco(cell.getStringCellValue());
						            break;
						    }
						}
						
						break;
					case 6:
						
						if (cell.getCellType() != CellType.FORMULA) {
						    switch (cell.getCellType()) {
						        case BOOLEAN:
						        	cliente.setPonto_de_referencia(String.valueOf(cell.getBooleanCellValue()));
						            break;
						        case NUMERIC:
						        	cliente.setPonto_de_referencia(String.valueOf((long)cell.getNumericCellValue()));
						            break;
						        case STRING:
						        	cliente.setPonto_de_referencia(cell.getStringCellValue());
						            break;
						    }
						}
						
						
						break;
					}

				}
				
				
				
				try {
					clientes.add(cliente);
					daocliente.RecordCliente(cliente);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		
		fileIn.close();
		}
		
		System.out.println("clientes gravados");
		
		
		
		
		
		
		
		
		
		}//end for
		
		
		
		
		//inserindo valores em uma planilha
		/*
		 * FileInputStream fileInputStream = new FileInputStream(arquivo); HSSFWorkbook
		 * newWorkbook = new HSSFWorkbook(fileInputStream); HSSFSheet newSheet =
		 * newWorkbook.getSheetAt(0);
		 * 
		 * Iterator<Row> row = newSheet.iterator();
		 * 
		 * while(row.hasNext()) { Row newline = row.next();
		 * 
		 * int cellNumber = newline.getPhysicalNumberOfCells(); Cell newCell =
		 * newline.createCell(cellNumber);
		 * 
		 * newCell.setCellValue("5000");
		 * 
		 * 
		 * 
		 * } fileInputStream.close();
		 * 
		 * FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
		 * newWorkbook.write(fileOutputStream); fileOutputStream.flush();
		 * fileInputStream.close();
		 * 
		 * System.out.println("cell added.");
		 */
		
	}
}