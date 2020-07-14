package com.design.user.adapter.inbound;

import com.design.user.adapter.inbound.dto.MatchDTO;
import com.design.user.application.inbound.PrizeUseCase;
import com.design.user.domain.IdMessage;
import com.design.user.utils.InterceptUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
@AllArgsConstructor
public class PrizeController {
    @Autowired
    private final PrizeUseCase prizeUseCase;

    @Autowired
    private final InterceptUtils interceptUtils;

    //获奖项目//
    @GetMapping("/prizeProject/{id}")
    public String prizeProject(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int usr_id = Integer.valueOf(id);
        List<MatchDTO> matchDTOS= prizeUseCase.userPrize(usr_id);
        model.addAttribute("userPrize",matchDTOS);
        System.out.println(matchDTOS);
        for (MatchDTO clazz : matchDTOS) {
            System.out.println(clazz);
        }
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/advanced_table";
        }

    }


    //奖项查询页面//
    @GetMapping("/findPrize/{id}")
    public String findPrize(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        List<MatchDTO> matchDTOS = prizeUseCase.findAllPrize();
        model.addAttribute("allPrize",matchDTOS);
        return "console/dynamic_table";
    }
}
