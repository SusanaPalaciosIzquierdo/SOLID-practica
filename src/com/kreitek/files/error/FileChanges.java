package com.kreitek.files.error;

import com.kreitek.files.File;
import com.kreitek.files.FileSystemItemBase;

import java.util.List;

public interface FileChanges {
    void addFile(FileSystemItemBase file);
    void removeFile(FileSystemItemBase file);
}
