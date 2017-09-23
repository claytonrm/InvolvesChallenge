package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Reader;

public class ReaderTest {
	
	private static final String SEPARATOR = ",";
	
	private static String fileName;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fileName = "files/cidades.csv";
		//TODO XXX - Create a file, save, read.
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Delete file
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void shouldReadACsvFileWithoutHeader() {
		final Map<String, List<String[]>> content = Reader.readCsv(fileName, SEPARATOR);
		
		assertNull(content.get("header"));
		assertNotNull(content.get("content"));
	}
	
	@Test
	public void shouldReadACsvFileWithHeader() {
		final boolean containsHeader = true;
		final Map<String, List<String[]>> content = Reader.readCsv(fileName, SEPARATOR, containsHeader);
		
		assertNotNull(content.get("header"));
		assertNotNull(content.get("content"));
	}
	
	@Test
	public void shouldReturnAnError() {
		final boolean containsHeader = true;
		final String anotherFile = "files/cidadesx.csv";
		Reader.readCsv(anotherFile, SEPARATOR, containsHeader);
		
		Assert.assertEquals("Cannot read this file \"%s\".\n", errContent.toString());
		
	}
}
