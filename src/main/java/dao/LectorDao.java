package dao;

import java.util.List;
import model.Lector;

public interface LectorDao extends EntityManager<Lector> {
    List<String> globalSearch(String template);
}
