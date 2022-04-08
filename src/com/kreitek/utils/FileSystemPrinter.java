package com.kreitek.utils;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FilePathname;
import com.kreitek.files.FileSystemItemBase;
import com.kreitek.files.error.FileList;
import com.kreitek.files.error.FileOperations;
import com.kreitek.service.FileManager;

public class FileSystemPrinter {

    private final FileManager fileManager;

    public FileSystemPrinter() {
        this.fileManager = new FileManager();
    }

    public static void print(FileSystemItemBase item, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, item.getFullPath(), FileManager.calculateSize(item));
        System.out.println(message);

        if (item instanceof Directory) {
            for (FileSystemItemBase subitem: item.listFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
