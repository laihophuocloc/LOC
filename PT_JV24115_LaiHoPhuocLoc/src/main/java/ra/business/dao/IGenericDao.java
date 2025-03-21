package ra.business.dao;

import java.util.List;

public interface IGenericDao<T, E> {
    List<T> findAll();
    void save(T entity);
    void delete(E id);
    T findById(E id);

}
