package cn.lp.mapper.account;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.lp.po.account.Dept;
@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    List<Dept> selectAllDept();
}