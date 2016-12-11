package com.springmvc;

public interface AbstractDao<E> {

	public abstract  void save(E obj);

	public abstract  void update(E obj);

	public abstract  void delete(E obj);

}