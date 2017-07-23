package com.njfu.bstabletest.mapper;

import com.njfu.bstabletest.domain.Per;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PerMapper {

    // 查询
    List<Per> selectPers(Per per);

    // 新增
    int insertPer(Per per);

    // 修改
    int updatePer(Per per);

    // 删除
    int deletePerById(@Param("id") Integer id);
}
