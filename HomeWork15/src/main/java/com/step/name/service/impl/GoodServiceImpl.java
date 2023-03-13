package com.step.name.service.impl;


import com.step.name.dao.GoodDao;
import com.step.name.dao.impl.GoodDaoImpl;
import com.step.name.model.Good;
import com.step.name.service.GoodService;

import java.util.ArrayList;
import java.util.List;

public class GoodServiceImpl implements GoodService {
    private final GoodDao goodDao = new GoodDaoImpl();


    @Override
    public List<Good> printGoods() {
        List<Good> list = goodDao.getAll();
      /*  List<String> result = new ArrayList<>();
        for (Good good : list) {
            result.add(good.getTitle() +
                    " (" +
                    good.getPrice().toString().replace(".", ",") +
                   "$)");
        }*/
        return list;
    }
}
