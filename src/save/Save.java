package save;

public interface Save {

    void save(String fileName, Object object) throws Exception;

    Object load(String fileName) throws Exception;
}
