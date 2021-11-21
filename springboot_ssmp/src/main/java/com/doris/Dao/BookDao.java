package com.doris.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doris.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {
//    @Select("select * from tbl_book where id=#{id}")
//    Book getById(Integer id);
}
