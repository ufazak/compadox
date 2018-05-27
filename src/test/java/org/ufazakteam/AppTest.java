package org.ufazakteam;

import org.junit.*;
import org.ufazakteam.core.api.Document;
import org.ufazakteam.core.impl.DefaultDocument;
import org.ufazakteam.core.impl.DefaultDocumentReader;
import org.ufazakteam.utils.StringUtils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppTest {

	@BeforeClass
	public static void beforeClass() {
	}
	@AfterClass
	public static void afterClass() {
	}
	@After
	public void after() {
	}
	@Before
	public void before() {
	}

	@Test
	public void test() {
		DefaultDocumentReader reader = new DefaultDocumentReader();
		String docFile = "C:\\Users\\Toktar\\Downloads\\k1500000414.16-04-2018.rus.doc";
		String docxFile = "C:\\Users\\Toktar\\Downloads\\k1500000414.16-04-2018.rus.docx";
		String kzDocFile = "C:\\Users\\Toktar\\Downloads\\z1700000081.01-03-2018.kaz.doc";
		String kzDocxFile = "C:\\Users\\Toktar\\Downloads\\z1700000081.01-03-2018.kaz.docx";
		reader.read(new File(kzDocFile));

		Document doc = reader.getDocument();

		System.out.println("Lang: " + doc.getLang() + "\nTitle: " + doc.getTitle());
	}

}