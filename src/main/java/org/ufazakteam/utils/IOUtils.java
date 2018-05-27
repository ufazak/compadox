package org.ufazakteam.utils;

import java.io.File;

/**
 * Created by Toktar on 27.05.2018.
 */
public class IOUtils {

    public static boolean isDocFile(File file) {
        return getFileExtension(file.getName()).equals("doc");
    }

    public static boolean isDocxFile(File file) {
        return getFileExtension(file.getName()).equals("docx");
    }

    private static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}
