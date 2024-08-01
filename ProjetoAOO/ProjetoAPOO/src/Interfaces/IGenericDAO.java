package Interfaces;

import java.util.List;

public interface IGenericDAO {
	<T> void add(T entity);
    <T> T get(int id);
    <T> List<T> getAll();
    <T> void update(T entity);
    void delete(int id);
}
