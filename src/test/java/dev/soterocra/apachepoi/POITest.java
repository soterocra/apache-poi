package dev.soterocra.apachepoi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import ch.qos.logback.core.joran.conditional.IfAction;
import dev.soterocra.apachepoi.entities.People;

class POITest {

	private static final String FILE_NAME = "C:\\Users\\rsoteror\\Documents\\Workspace\\Lab\\apache-poi\\src\\test\\resources\\Sample.xlsx";

	@Test
	void readExcelFile() throws IOException {
		
		List<People> peopleList = new ArrayList<>();

		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));

		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet peopleDataSheet = workbook.getSheet("people-data");

		Iterator<Row> iterator = peopleDataSheet.iterator();

		while (iterator.hasNext()) {

			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			
			People people = new People();

			while (cellIterator.hasNext()) {

				Cell currentCell = cellIterator.next();

				if (currentCell.getCellType() == CellType.STRING) {
					System.out.println(currentCell.getStringCellValue() + ",");
				} else if (currentCell.getCellType() == CellType.NUMERIC) {
					if (DateUtil.isCellDateFormatted(currentCell)) {
						System.out.println(currentCell.getDateCellValue());
					} else {
						System.out.println(currentCell.getNumericCellValue() + ",");						
					}
				}
			}
			
			System.out.println();

		}

	}

}
