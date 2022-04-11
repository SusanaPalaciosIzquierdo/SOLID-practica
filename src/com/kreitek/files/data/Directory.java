package com.kreitek.files.data;

import com.kreitek.interfaces.FileChanges;

import java.util.ArrayList;
import java.util.List;


public class Directory extends FileSystemItemBase implements FileChanges {
    private final List<FileSystemItemBase> files;

    public Directory(String name) {
        super(name);
        files = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemItemBase file : getFiles()){
            size += file.getSize();
        }
        return size;
    }

    @Override
    public void addFile(FileSystemItemBase file) {
        if (!getFiles().contains(file)) {
            getFiles().add(file);
            file.setParent(this);
        }
    }

    public List<FileSystemItemBase> getFiles() {
        return files;
    }
}
