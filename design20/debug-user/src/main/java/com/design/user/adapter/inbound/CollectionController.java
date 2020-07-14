package com.design.user.adapter.inbound;

import com.design.user.application.inbound.CollectionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
@AllArgsConstructor
public class CollectionController {
    @Autowired
    private final CollectionUseCase collectionUseCase;

    //collectionUseCase调用部分被封装到utils包下的PrizeUploadUtils类下

}
