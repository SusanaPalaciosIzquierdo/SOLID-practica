package com.kreitek.interfaces;

import com.kreitek.files.data.FileSystemItemBase;

public interface FileOperations {

    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);
    void open();
    void close();

}
