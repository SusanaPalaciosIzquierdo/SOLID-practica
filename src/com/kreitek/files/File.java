package com.kreitek.files;

import com.kreitek.files.error.FileChanges;
import com.kreitek.files.error.FileOperations;
import com.kreitek.files.error.InvalidFileFormatException;

import java.util.List;

public  class File extends FileSystemItemBase implements FilePathname, FileOperations {
    private boolean isOpen = false;
    private int position = 0;
    private int size = 0;
    private List<FileSystemItemBase> files;

    public File(Directory parent, String name) {
        super(parent, name);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public String getExtension() {
        String extension = "";
        int indexOfLastDot = getName().lastIndexOf(".");
        if (indexOfLastDot > 0) {
            extension = getName().substring(indexOfLastDot + 1);
        }
        return extension;
    }

    @Override
    public void setPosition(int numberOfBytesFromBeginning) {
        if (!isOpen) {
            throw new UnsupportedOperationException("Debe abrir el fichero primero");
        }
        if (numberOfBytesFromBeginning > size) {
            throw new UnsupportedOperationException("La posición no puede ser mayor que el tamaño del fichero");
        }
        this.position = numberOfBytesFromBeginning;
    }

    @Override
    public List<FileSystemItemBase> listFiles() {
        return files;
    }

    @Override
    public void open() {
        isOpen = true;
    }

    @Override
    public byte[] read(int numberOfBytesToRead) {
        if (position + numberOfBytesToRead > size) {
            numberOfBytesToRead = size - position;
        }
        byte[] buffer = new byte[numberOfBytesToRead];
        position += numberOfBytesToRead;
        return buffer;
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


    /*public FileSystemItemBase convertMp3ToWav() {
        if (!"mp3".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItemBase result = new File(newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    public FileSystemItemBase convertWavToMp3() {
        if (!"wav".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = name.lastIndexOf(".");
        String nameWithoutExtension = name;
        if (indexOfLastDot > 0) {
            nameWithoutExtension = name.substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemItemBase result = new File(parent, newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }
*/



}
