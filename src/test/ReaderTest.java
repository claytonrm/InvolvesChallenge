package test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.Reader;

public class ReaderTest {

	@Test
	public void shouldReadACsvFileWithoutHeader() {
		final String fileName = "files/cidades.csv";
		final String splitter = ",";
		final Map<String, List<String[]>> content = Reader.readCsv(fileName, splitter);
		
		assertNull(content.get("header"));
		assertNotNull(content.get("content"));
	}
	
	@Test
	public void shouldReadACsvFileWithHeader() {
		final Map<String, List<String[]>> content = Reader.readCsv("files/cidades.csv", ",", true);
		
		assertNotNull(content.get("header"));
		assertNotNull(content.get("content"));
	}

}
