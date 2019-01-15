package com.qf.manager.service.impl;

import com.qf.manager.dao.sysgallery;
import com.qf.manager.po.Sysgallery;
import com.qf.manager.service.CalleryService;
import com.qf.manager.service.JedisClient;
import com.qf.manager.util.JsonUtils;
import com.qf.manager.util.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalleryServiceImpl implements CalleryService {
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private sysgallery ssygallery;
    private Logger logger = LoggerFactory.getLogger(CalleryServiceImpl.class);
    public List<Sysgallery> listsSysgallery(String categoryid) {
//        1缓存中查询
//        从缓存中获取数据
//        2若缓存中不为空直接返回list
//          若缓存中不存在则在mysql中查询
//         3并将查询出的数据存放到缓存中
        try{
            //1缓存中查询
            String gallery_list = jedisClient.hget("GALLERY_LIST", categoryid);
            //判断查询出来的数据是否为空
            if(StrKit.notBlank(gallery_list)){
                //如果为true不为空
//                直接返回list后面放的是泛型的类型
                return JsonUtils.jsonToList(gallery_list,Sysgallery.class);
            }

        }catch (RuntimeException e){
            logger.debug(e.getMessage(),e);
        }
        //2. MySQL中查询
        //本方法主要内容，查询缓存不能影响到这个主业务
        List<Sysgallery> sysgalleries = ssygallery.listSysgallery();
        try {
            //将查询出来的list存放到缓存中
            jedisClient.hset("GALLERY_LIST", categoryid, JsonUtils.objectToJson(sysgalleries));
        }catch (RuntimeException e){
            logger.debug(e.getMessage(),e);
        }
        return sysgalleries;
    }
}
