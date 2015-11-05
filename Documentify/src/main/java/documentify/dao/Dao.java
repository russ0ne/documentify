package documentify.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T,ID extends Serializable> {
    public List<T> read();
    public T read(ID id);
    public T save(T t);
    public void delete(T t);
    public void commit();
}
