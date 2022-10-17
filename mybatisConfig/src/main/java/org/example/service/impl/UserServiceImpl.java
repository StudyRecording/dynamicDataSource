package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.aop.MultiTransactional;
import org.example.mapper.r.RUserMapper;
import org.example.mapper.w.WUserMapper;
import org.example.pojo.UserPojo;
import org.example.service.UserService;
import org.example.service.transaction.DbTxConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Author: hpc
 * Date: 2022/10/17 10:57
 * FileName: UserServiceImpl
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RUserMapper rUserMapper;

    @Autowired
    private WUserMapper wUserMapper;

    @Autowired
    TransactionTemplate wTransactionTemplate;
    @Autowired
    TransactionTemplate rTransactionTemplate;

    @Override
    public List<UserPojo> listR() {
        return rUserMapper.select();
    }

    @Override
    public List<UserPojo> listW() {
        return wUserMapper.select();
    }

    @Override
    public boolean saveR(UserPojo userPojo) {
        rUserMapper.insert(userPojo);
        return true;
    }

    @Override
    public boolean saveW(UserPojo userPojo) {
        wUserMapper.insert(userPojo);
        return true;
    }

    /**
     * value 包含两个事务时，都会回滚，仅包含一个事务时，仅回滚包含的事务
     * @param userPojo
     */
    @MultiTransactional(value = {DbTxConstants.DB1_TX, DbTxConstants.DB2_TX})
    @Override
    public void saveAll(UserPojo userPojo) {
        saveR(userPojo);
        saveW(userPojo);
        int i = 1 / 0;
    }


    public void saveAll2(UserPojo userPojo) {
        wTransactionTemplate.execute((wstatus) -> {
            rTransactionTemplate.execute((rstatus) -> {
                try {
                    saveW(userPojo);
                    saveR(userPojo);
                    //int a = 1 / 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    wstatus.setRollbackOnly();
                    rstatus.setRollbackOnly();
                    return false;
                }
                return true;
            });
            return true;
        });
    }
}
