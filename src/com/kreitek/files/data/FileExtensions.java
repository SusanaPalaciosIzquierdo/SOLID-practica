package com.kreitek.files.data;

import com.kreitek.interfaces.FilePathname;

public class FileExtensions implements FilePathname {

    @Override
    public String getExtension(File file) {
        String extension = "";
        int indexOfLastDot = file.getName().lastIndexOf(".");
        if (indexOfLastDot > 0) {
            extension = file.getName().substring(indexOfLastDot + 1);
        }
        return extension;
    }



}
