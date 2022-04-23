package com.kreitek.files;

import com.kreitek.files.File.File;
import com.kreitek.files.error.InvalidFileFormatException;

public class AudioUtilities extends File {


    public AudioUtilities(FileSystemItem parent, String name){
        super(parent, name);
    }





    public FileSystemItem convertMp3ToWav() {
        if (!"mp3".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = getName().lastIndexOf(".");
        String nameWithoutExtension = getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItem result = new File(getParent(), newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    public FileSystemItem convertWavToMp3() {
        if (!"wav".equalsIgnoreCase(getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = getName().lastIndexOf(".");
        String nameWithoutExtension = getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemItem result = new File(getParent(), newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }
}
