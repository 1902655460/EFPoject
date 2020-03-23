package com.dindan.gift;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dindan.xq.Xq;
import com.dindan.xq.XqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GiftService {

    @Autowired
    private GiftMapper mapper;

    @Autowired
    private XqMapper xqMapper;

    Map<String,Object> map;

    public Map selectPage(int limit,int page){
        map = new HashMap<>(0);
        Page<Gift> pa = new Page<Gift>(page,limit);
        IPage<Gift> iPage = mapper.selectPage(pa,null);
        List<Gift> list = iPage.getRecords();
        map.put("data",list);
        map.put("count",iPage.getTotal());
        map.put("code",0);
        return map;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Map insertGift(String name,int number){
        map = new HashMap<>(0);
        try{
            Gift g = new Gift();
            g.setName(name);
            g.setNumber(number);
            mapper.insert(g);
            Xq x = new Xq();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            x.setDate(sdf.format(new Date()));
            x.setNumber(number);
            x.setGid(g.getId());
            xqMapper.insert(x);
            map.put("code",0);
            map.put("msg","新增成功！");
        }catch (Exception e){
            map.put("code",1);
            map.put("msg","程序错误，请联系十忆少女的梦！");
        }
        return map;
    }

    public Map delById(int id) {
        map = new HashMap<>(0);
        int i = mapper.deleteById(id);
        map.put("code",i);
        return map;
    }
}
