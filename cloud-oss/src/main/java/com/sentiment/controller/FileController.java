package com.sentiment.controller;

import com.sentiment.constant.OssConstant;
import com.sentiment.utils.Result;
import com.sentiment.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Fwt
 * @version 1.0
 * @date 2022/8/18 14:19
 */
@RestController
@RequestMapping("/oss/image")
public class FileController {


    @Value("${picture.dir}")
    private String uploadFolder;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file,@RequestParam("userId") String userId){
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        //使用UUID生成唯一标识文件名
        String randomNumber = UUID.randomUUID().toString().replace("-", "");
        //获取文件的原始名
        String oldFilename = file.getOriginalFilename();
        //获取文件后缀 .jpg
        String extension = oldFilename.substring(oldFilename.lastIndexOf("."));
        //生成新的文件名
        String newFileName = randomNumber + extension;
        String format = sdf.format(new Date());
        String realPath="/image/"+userId+format;
        File dateDir = new File(uploadFolder+realPath);
        if (!dateDir.exists()) {
            //判断目录是否存在，不存在则直接创建
            boolean mkdirs = dateDir.mkdirs();
            if(!mkdirs){
                return OssConstant.FILE_CREATION_FAILED;
            }
        }
        try {
            file.transferTo(new File(dateDir, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return OssConstant.PICTURE_UPLOAD_FAILED;
        }
        return realPath+newFileName;
    }

}
