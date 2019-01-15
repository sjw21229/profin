package com.qf.manager.web;

import com.qf.common.fdfs.FastDFSFile;
import com.qf.common.fdfs.FastDFSUtils;
import com.qf.manager.util.PropKit;
import com.qf.manager.util.StrKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@Controller
public class RedisFileOrImageAction {
    @GetMapping("toupdate")
    public String  toUPdate(){
        return "toupload";
    }
    @ResponseBody
    @PostMapping("uploadImage")
    public Map<String,Object> uploadImage(@RequestParam("file")MultipartFile file){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //获取到fdfs文件对象
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            String basePath=PropKit.use("fdfs_client.conf").get("fdfs_server");
            //b. 上传  "http://106.12.210.85/"  +  "group1/M00/00/00/xxxx.jpg"
            String shortname = FastDFSUtils.uploadFile(fastDFSFile);
            if(StrKit.notBlank(shortname)){
                //如果为true则正确
                map.put("code", 0);
                map.put("msg", "success");
                Map<String, Object> data = new HashMap<String,Object>();
                data.put("src", basePath + "/" + shortname);
                map.put("data", data);
            }
        }catch (Exception e){
            map.put("code", -1);
        }
        //2. 回显图片到富文本编辑器
        return map;
    }
}
