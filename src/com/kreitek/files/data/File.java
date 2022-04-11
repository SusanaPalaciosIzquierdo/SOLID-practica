package com.kreitek.files.data;

import com.kreitek.interfaces.FileOperations;

public  class File extends FileSystemItemBase implements FileOperations {
    private boolean isOpen = false;
    private int position = 0;
    private int size = 0;

    public File(String name) {
        super(name);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public void write(byte[] buffer) {
        size += buffer.length;
        position += buffer.length;
    }

    @Override
    public void close() {
        isOpen = false;
    }

}
