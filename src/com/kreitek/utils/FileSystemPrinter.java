package com.kreitek.utils;

import com.kreitek.files.data.Directory;
import com.kreitek.files.data.FileSystemItemBase;
import com.kreitek.service.FileManager;

public class FileSystemPrinter {

    public static void print(FileSystemItemBase item, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, item.getFullPath(), FileManager.calculateSize(item));
        System.out.println(message);

        if (item instanceof Directory) {
            for (FileSystemItemBase subitem: ((Directory) item).getFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
