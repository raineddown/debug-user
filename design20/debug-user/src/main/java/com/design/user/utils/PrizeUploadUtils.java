package com.design.user.utils;

import com.design.user.application.inbound.CollectionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Component
public class PrizeUploadUtils {
    @Autowired
    private final CollectionUseCase collectionUseCase;

    public void prizeUpload(String userId,String matchId, String projectId, MultipartFile f4) throws IOException {
        int match_id = Integer.valueOf(matchId);
        int project_id = Integer.valueOf(projectId);
        int user_id = Integer.valueOf(userId);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //获取当前时间Date类型
        String collection_time = sdf.format(date);
        System.out.println("获取当前时间Date类型："+collection_time);
        String fileName;
        if(f4 == null){
            fileName = ".";
        }else{
            fileName = f4.getOriginalFilename();
        }

        assert fileName != null;
        int start = fileName.indexOf(".");
        String fileType = fileName.substring(start);
        String value = UUID.randomUUID().toString();


        File copyFile = new File("E:\\uploadRar\\upload1",value+fileType);

        //文件复制
        f4.transferTo(copyFile);
        collectionUseCase.addCollection(project_id,match_id,collection_time,"/upload1/"+value+fileType);
    }

}
