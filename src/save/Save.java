package save;


/** This is a saving interface to permit extends on multiple interface type */
public interface Save {

    void save(String fileName, Object object) throws Exception;

    Object load(String fileName) throws Exception;
}
