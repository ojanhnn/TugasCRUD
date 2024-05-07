package DAOImplements;
import java.util.List;
import Movie.*;
/**
 * @RozaanHP
 * **/
public interface DAOMovie {
    public void create(dataMovie p);
    public void update(dataMovie p);
    public void delete(dataMovie p);
    List<dataMovie> getALL();
}
