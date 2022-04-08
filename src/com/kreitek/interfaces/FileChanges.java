package com.kreitek.interfaces;

import com.kreitek.files.data.FileSystemItemBase;


public interface FileChanges {
    void addFile(FileSystemItemBase file);
    void removeFile(FileSystemItemBase file);
}
