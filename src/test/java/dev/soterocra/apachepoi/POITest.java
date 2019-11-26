package dev.soterocra.apachepoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.soterocra.apachepoi.entities.People;

class POITest {

	private static final String FILE_NAME = "C:\\Users\\rsoteror\\Documents\\Workspace\\Lab\\apache-poi\\src\\test\\resources\\Sample.xlsx";
	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	void readExcelFile() throws IOException {

		List<People> peopleList = new ArrayList<>();

		FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));

		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet peopleDataSheet = workbook.getSheet("people-data");

		Iterator<Row> iterator = peopleDataSheet.iterator();

		List<String> headers = null;
		List<HashMap<String, Object>> result = null;

		while (iterator.hasNext()) {
			Row currentRow = iterator.next();

			if (headers == null) {
				headers = generateHeaders(currentRow);
				continue;
			}

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

			Map<String, Object> tmpPeopleMap = new HashMap<>();

			for (int i = 0; i < headers.size(); i++) {
				tmpPeopleMap.put(headers.get(i), tmpAccumulate.get(i));
			}

			peopleList.add(mapper.convertValue(tmpPeopleMap, People.class));
		}

		System.out.println(new ObjectMapper().writeValueAsString(peopleList));
		
	}

	List<String> generateHeaders(Row firstRow) {

		List<String> headers = new ArrayList<>();
		Iterator<Cell> cellIterator = firstRow.iterator();

		while (cellIterator.hasNext()) {
			headers.add(cellIterator.next().getStringCellValue());
		}

		return headers;
	}

}
