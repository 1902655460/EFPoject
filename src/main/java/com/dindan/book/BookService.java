package com.dindan.book;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dindan.bookxq.BXq;
import com.dindan.bookxq.BXqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookMapper mapper;

    @Autowired
    private BXqMapper xqMapper;

    Map<String,Object> map;

    public Map selectPage(int limit,int page,int xid){
        map = new HashMap<>(0);
        Page<Book> pa = new Page<Book>(page,limit);
        IPage<Book> iPage = mapper.selectPage(pa,new QueryWrapper<Book>().eq("xid",xid));
        List<Book> list = iPage.getRecords();
        map.put("data",list);
        map.put("count",iPage.getTotal());
        map.put("code",0);
        return map;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Map insertGift(String name,int number,String cname,int xid){
        map = new HashMap<>(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Book g = new Book();
            g.setName(name);
            g.setNumber(number);
            g.setCdate(sdf.format(new Date()));
            g.setUdate(sdf.format(new Date()));
            g.setXid(xid);
            mapper.insert(g);
            BXq x = new BXq();
            x.setDate(sdf.format(new Date()));
            x.setSa(cname);
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
        xqMapper.delete(new QueryWrapper<BXq>().eq("gid",id));
        map.put("code",i);
        return map;
    }
}
