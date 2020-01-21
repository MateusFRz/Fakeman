package save;

import java.io.*;


/**
 * This is class save object into binary file
 *
 * @see Save
 * */
public class BinarySave implements Save {

    /**
     * Save a object in a file
     *
     * @param fileName The name of the file
     * @param object Object saved in the file
     * */
    @Override
    public void save(String fileName, Object object) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(object);
    }

    /**
     * Read a object in a file
     *
     * @param fileName The name of the file
     * @return object Object read
     * */
    @Override
    public Object load(String fileName) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        return in.readObject();
    }
}
