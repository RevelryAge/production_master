package cn.lp.mapper.account;

import org.apache.ibatis.annotations.Mapper;
import cn.lp.po.account.Account;
@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

	Account login(Account account);
//	List<Account> show();
}