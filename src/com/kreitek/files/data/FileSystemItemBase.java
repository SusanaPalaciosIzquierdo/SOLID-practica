package com.kreitek.files.data;

public abstract class FileSystemItemBase{
    private static final String PATH_SEPARATOR = "/";
    private final String name;
    private Directory parent;
    private String fullPath = PATH_SEPARATOR;

    protected FileSystemItemBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FileSystemItemBase getParent(){
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getFullPath() {
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            fullPath = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        fullPath = fullPath + getName();
        return fullPath;
    }

    public abstract int getSize();

}
