package org.gstu.domainmodel;

import java.util.List;

public interface IRepository<T> {
  List<T> getAll();
  T get(int id) throws Exception;
  T create(T obj) throws Exception;
  void delete(T obj) throws Exception;
  void update(T obj) throws Exception;
}
