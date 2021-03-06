package cn.fintecher.print.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sun on 2017/4/25 0025.
 */
public interface MongoGenericManager<T, ID extends Serializable>{

    boolean exists(ID id);

    T findOne(ID id);

    T save(T object);

    Iterable<T> save(Iterable<T> entities);

    void delete(T object);

    void delete(ID id);

    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findAll(Iterable<ID> ids);

    List<T> findAll(Example<T> example);

    List<T> findAll(Example<T> example, Sort sort);

    Page<T> findAll(Pageable pageable);

    Page<T> findAll(Example<T> example, Pageable pageable);


}
