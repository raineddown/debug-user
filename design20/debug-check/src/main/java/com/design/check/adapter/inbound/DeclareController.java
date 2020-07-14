package com.design.check.adapter.inbound;

import com.design.check.application.inbound.DeclareUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class DeclareController {
    @Autowired
    private final DeclareUseCase declareUseCase;

    @RequestMapping("/user/check")
    public void checkDeclare() throws ParseException {
        List<DeclareDTO> declareDTOList = declareUseCase.findAllId();
        int size = declareDTOList.size();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //获取当前时间Date类型
        Date time_date = null;
        try {
            time_date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("获取当前时间Date类型："+time_date);

        java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (DeclareDTO declareDTO : declareDTOList) {
            int begin_id = declareDTO.getBegin_id();
            Date begin = formatter.parse(declareDTO.getDeclare_begin());
            Date end = formatter.parse(declareDTO.getDeclare_end());
            assert time_date != null;
            if (begin.before(time_date) && end.after(time_date)) {
                declareUseCase.checkDeclare(begin_id);
            }else {
                declareUseCase.backDeclare(begin_id);
            }
        }
    }
}
