package ra.business.design;

import java.util.List;

public interface IGenericDesign<T, E> {
    List<T> findAll();
    void save(T entity);
    void delete(E id);
    T findById(E id);

}
