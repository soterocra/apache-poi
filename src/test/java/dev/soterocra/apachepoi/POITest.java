package dev.soterocra.apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import dev.soterocra.apachepoi.entities.People;

class POITest {

	private static final String FILE_NAME = "C:\\Users\\rsoteror\\Documents\\Workspace\\Lab\\apache-poi\\src\\test\\resources\\Sample.xlsx";

	@Test
	void readExcelFile() throws IOException {
		
		TreeMap<String, String> testeHashMap = new TreeMap<>();
		
		testeHashMap.put("oi1", "1");
		testeHashMap.put("oi2", "2");

		List<People> peopleList = new ArrayList<>();

		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));

		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet peopleDataSheet = workbook.getSheet("people-data");
		
		Iterator<Row> iterator = peopleDataSheet.iterator();

		TreeMap<String, Object> headers = null;
		List<TreeMap<String, Object>> result = null;

		while (iterator.hasNext()) {
			Row currentRow = iterator.next();

			if (headers == null)
				headers = generateHeaders(currentRow);

			Iterator<Cell> cellIterator = currentRow.iterator();

			List<Object> tmpAccumulate = new ArrayList<>();

			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();

				if (currentCell.getCellType() == CellType.STRING) {
					tmpAccumulate.add(currentCell.getStringCellValue());
				} else if (currentCell.getCellType() == CellType.NUMERIC) {
					if (DateUtil.isCellDateFormatted(currentCell)) {
						tmpAccumulate.add(currentCell.getDateCellValue());
					} else {
						tmpAccumulate.add(currentCell.getNumericCellValue());
					}
				} else if (currentCell.getCellType() == CellType.BOOLEAN) {
					tmpAccumulate.add(currentCell.getBooleanCellValue());
				} else {
					tmpAccumulate.add("");
				}
			}

			TreeMap<String, Object> tmpPeopleMap = SerializationUtils.clone(headers);
			
			tmpPeopleMap.entrySet().stream().forEach(k -> tmpPeopleMap.put(k.getKey(), tmpAccumulate.remove(0)));
			System.out.println();
		}

	}

	TreeMap<String, Object> generateHeaders(Row firstRow) {

		TreeMap<String, Object> headers = new TreeMap<>();
		Iterator<Cell> cellIterator = firstRow.iterator();

		while (cellIterator.hasNext()) {
			headers.put(cellIterator.next().getStringCellValue(), null);
		}

		return headers;
	}

}
