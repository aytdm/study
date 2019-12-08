package com.aytdm.kotlinbootdoma.domain.dao;

import com.aytdm.kotlinbootdoma.domain.entity.CustomerEntity;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface CustomerDao {

    @Select
    List<CustomerEntity> selectAll();

    @Select
    CustomerEntity selectById(int id);

    @Insert
    int insert(CustomerEntity entity);

    @Update
    int update(CustomerEntity entity);

    @Delete
    int delete(CustomerEntity entity);
}
