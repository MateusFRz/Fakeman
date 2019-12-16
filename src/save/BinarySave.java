package save;

import java.io.*;

public class BinarySave implements Save {

    @Override
    public void save(String fileName, Object object) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(object);
    }

    @Override
    public Object load(String fileName) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        return in.readObject();
    }
}
