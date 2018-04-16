package org.ufazakteam.core.impl;

import org.ufazakteam.core.api.Document;
import org.ufazakteam.core.api.DocumentReader;

import java.io.File;
import java.util.Objects;

/**
 * Created by Toktar on 14.04.2018.
 */
public class DefaultDocumentReader implements DocumentReader {

    private Document document = null;

    @Override
    public void read(File file) {
        String fileName = file.getName();
        document = fileName.endsWith(".doc")  ? getHWPFDocument(file):
                   fileName.endsWith(".docx") ? getXWPFDocument(file): null;

        if (Objects.nonNull(document)) document.run();
    }

    private Document getHWPFDocument(File file) {
        return new DefaultDocument(file, false);
    }

    private Document getXWPFDocument(File file) {
        return new DefaultDocument(file, true);
    }
}
