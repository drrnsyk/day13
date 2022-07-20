package sg.edu.nuss.iss.d13workshop.services;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    
    private File dataDir = new File("some directory");

    public File getDataDir() {
        return dataDir;
    }

    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

    public boolean isDataDirValid() {
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }
}
