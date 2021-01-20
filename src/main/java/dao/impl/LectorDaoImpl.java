package dao.impl;

import dao.LectorDao;
import model.Lector;
import org.springframework.stereotype.Repository;

@Repository
public class LectorDaoImpl extends EntityManagerImpl<Lector> implements LectorDao {
}
