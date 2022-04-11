package com.kreitek.service;

import com.kreitek.files.data.FileSystemItemBase;

public class FileManager {

    public static int calculateSize(FileSystemItemBase fileItem) {
        return fileItem.getSize();
    }

}
