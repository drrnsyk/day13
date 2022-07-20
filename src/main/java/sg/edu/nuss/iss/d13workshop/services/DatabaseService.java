package sg.edu.nuss.iss.d13workshop.services;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Service;

import sg.edu.nuss.iss.d13workshop.models.Contact;

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

    // reading and saving should be done to a model (structure) to store data
	public boolean save(Contact contact) {
        File f = new File(this.dataDir, contact.getId());

        try (OutputStream out = new FileOutputStream(f)) {
            PrintWriter pw = new PrintWriter(out);
            pw.println(contact.getId());
            pw.println(contact.getName());
            pw.println(contact.getEmail());
            pw.println(contact.getPhone());
            pw.flush();
            return true;
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
            // ex.printStackTrace();
            return false;
        }
	}

	public Contact read(String fileId) {

        try {

            File f = new File(this.dataDir, fileId);
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
            Contact contact = new Contact();
            return contact;

        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
            // ex.printStackTrace();
            return null;
        }
	}

}
