package com.atguigu.gmall0218.publisher.service.impl;

import com.atguigu.gmall0218.publisher.mapper.DauMapper;
import com.atguigu.gmall0218.publisher.mapper.OrderMapper;
import com.atguigu.gmall0218.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    DauMapper dauMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public int getDauTotal(String date) {
        return dauMapper.getDauTotal(date);
    }

    @Override
    public Map getDauHour(String date) {
        HashMap dauHourMap=new HashMap();
        List<Map> dauHourList = dauMapper.getDauHour(date);
        for (Map map : dauHourList) {
            dauHourMap.put(map.get("LOGHOUR"),map.get("CT"));
        }

        return dauHourMap;
    }

    @Override
    public Double getOrderAmountTotal(String date) {
        return orderMapper.getOrderAmountTotal(date);
    }

    @Override
    public Map getOrderAmountHour(String date) {
        //调整一下map结构
        List<Map> orderAmountHourList = orderMapper.getOrderAmountHour(date);

        Map orderAmountMap=new HashMap();
        for (Map map : orderAmountHourList) {
            orderAmountMap.put( map.get("CREATE_HOUR"),map.get("ORDER_AMOUNT"));
        }

        return orderAmountMap;
    }

}
