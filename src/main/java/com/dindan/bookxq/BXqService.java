package com.dindan.bookxq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dindan.book.Book;
import com.dindan.book.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BXqService {

    @Autowired
    private BXqMapper mapper;

    @Autowired
    private BookMapper giftMapper;

    Map<String,Object> map;

    public Map selectPage1(int limit,int page,int gid){
        map = new HashMap<>(0);
        Page<BXq> pa = new Page<BXq>(page,limit);
        IPage<BXq> iPage = mapper.selectPage(pa,new QueryWrapper<BXq>().eq("gid",gid));
        List<BXq> list = iPage.getRecords();
        map.put("data",list);
        map.put("count",iPage.getTotal());
        map.put("code",0);
        return map;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Map insertckXQ(String name,String tname,int gid,String sa){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String da = sdf.format(new Date());
        map = new HashMap<>(0);
        try{
            String[] na = name.split("-");
            for(int i=0;i<na.length;i++){
                BXq x = new BXq();
                x.setDate(da);
                x.setName(na[i]);
                x.setNumber(-1);
                x.setTname(tname);
                x.setGid(gid);
                x.setSa(sa);
                mapper.insert(x);
            }

            Book gi = giftMapper.selectById(gid);
            gi.setNumber(gi.getNumber()-na.length);
            gi.setUdate(da);
            giftMapper.updateById(gi);
            map.put("code",0);
            map.put("msg","新增成功！");
        }catch (Exception e){
            map.put("code",1);
            map.put("msg","程序错误，请联系十忆少女的梦！");
        }
        return map;
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Map insertXQ(String name,int number,String tname,int gid,String sa){
        map = new HashMap<>(0);
        try{
            BXq x = new BXq();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String da = sdf.format(new Date());
            x.setDate(da);
            x.setName(name);
            x.setNumber(number);
            x.setTname(tname);
            x.setGid(gid);
            x.setSa(sa);
            mapper.insert(x);
            Book gi = giftMapper.selectById(gid);
            gi.setNumber(gi.getNumber()+number);
            gi.setUdate(da);
            giftMapper.updateById(gi);
            map.put("code",0);
            map.put("msg","新增成功！");
        }catch (Exception e){
            map.put("code",1);
            map.put("msg","程序错误，请联系十忆少女的梦！");
        }
        return map;
    }

    public Map delXQById(int id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String da = sdf.format(new Date());
        map = new HashMap<>(0);
        BXq xq = mapper.selectById(id);
        int i = mapper.deleteById(id);
        Book g = giftMapper.selectById(xq.getGid());
        g.setNumber(g.getNumber()-xq.getNumber());
        g.setUdate(da);
        giftMapper.updateById(g);
        map.put("code",i);
        return map;
    }
}
