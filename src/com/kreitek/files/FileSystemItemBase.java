package com.kreitek.files;

import com.kreitek.files.Directory.Directory;

public abstract class FileSystemItemBase implements FileSystemItem {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected FileSystemItem parent;

    protected FileSystemItemBase(FileSystemItem parent, String name) {
        setName(name);
        setParent(parent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
       this.name = name;
    }

    public FileSystemItem getParent() {
        return parent;
    }


    public void setParent(FileSystemItem directory) {
        if (directory != null && !(directory instanceof Directory)) {
            throw new IllegalArgumentException("El padre solo puede ser un directorio");
        }
        if (this.parent != directory) {
            if (this.parent != null) this.parent.removeFile(this);
            this.parent = directory;
            if (directory != null) directory.addFile(this);
        }
    }

    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }
}
