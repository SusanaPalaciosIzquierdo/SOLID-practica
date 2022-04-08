package com.kreitek.files.data;

import com.kreitek.interfaces.FileChanges;

public class Directory extends FileSystemItemBase implements FileChanges {

    public Directory(String name) {
        super(name);
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

    @Override
    public void removeFile(FileSystemItemBase file) {
        getFiles().remove(file);
    }

}
