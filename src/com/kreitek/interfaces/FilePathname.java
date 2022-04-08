package com.kreitek.interfaces;

import com.kreitek.files.data.File;

public interface FilePathname {
    String getExtension(File file);
    void setPosition(int numberOfBytesFromBeginning, File file);
}
