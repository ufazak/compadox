package org.ufazakteam.core.impl;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.ufazakteam.core.api.Document;
import org.ufazakteam.core.api.DocumentReader;
import org.ufazakteam.utils.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Objects;

/**
 * Created by Toktar on 14.04.2018.
 */
public class DefaultDocumentReader implements DocumentReader {

    private Document document = null;

    @Override
    public void read(File file) {
        document = IOUtils.isDocFile(file)  ? getHWPFDocument(file):
                   IOUtils.isDocxFile(file) ? getXWPFDocument(file): null;

        if (Objects.nonNull(document)) document.init();
    }

    private Document getHWPFDocument(File file) {
        try {
            HWPFDocument doc = new HWPFDocument(new FileInputStream(file));
            WordExtractor extractor = new WordExtractor(doc);
            return new DefaultDocument(extractor.getText());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Document getXWPFDocument(File file) {
        try {
            XWPFDocument docx = new XWPFDocument(new FileInputStream(file));
            List<XWPFParagraph> paragraphs = docx.getParagraphs();
            StringBuilder builder = new StringBuilder();
            paragraphs.forEach(p-> builder.append(p.getText()));
            return new DefaultDocument(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
