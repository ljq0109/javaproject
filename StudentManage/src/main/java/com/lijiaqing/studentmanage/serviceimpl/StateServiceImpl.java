package com.lijiaqing.studentmanage.serviceimpl;

import com.lijiaqing.studentmanage.dao.StateDao;
import com.lijiaqing.studentmanage.entity.State;
import com.lijiaqing.studentmanage.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateDao stateDao;

    @Override
    public List<State> selectAll() {
        return stateDao.selectAll();
    }
}
