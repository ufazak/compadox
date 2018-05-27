package org.ufazakteam;

import org.junit.*;
import org.ufazakteam.core.api.Document;
import org.ufazakteam.core.impl.DefaultDocument;
import org.ufazakteam.core.impl.DefaultDocumentReader;

import java.io.File;

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
		reader.read(new File(docFile));

		Document doc = reader.getDocument();

		System.out.println("Lang: " + doc.getLang() + "\nTitle: " + doc.getTitle());
	}

}