package com.design.user.adapter.inbound;

import com.design.user.adapter.inbound.dto.DeclareDTO;
import com.design.user.adapter.inbound.dto.ProjectDTO;
import com.design.user.application.inbound.CollectionUseCase;
import com.design.user.application.inbound.DeclareUseCase;
import com.design.user.application.inbound.ProjectUseCase;
import com.design.user.domain.Prize;
import com.design.user.utils.PrizeUploadUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
@AllArgsConstructor
public class DeclareController {
    @Autowired
    private final DeclareUseCase declareUseCase;
    @Autowired
    private final ProjectUseCase projectUseCase;
    @Autowired
    private final CollectionUseCase collectionUseCase;
    @Autowired
    private final PrizeUploadUtils prizeUploadUtils;

    //奖项申报页面
    @RequestMapping("/declare/{id}")
    public String toDeclare(@PathVariable("id")String id, Model model){
        int project_id = Integer.valueOf(id);
        ProjectDTO projectDTO = projectUseCase.detailProject(project_id);
        model.addAttribute("project",projectDTO);
        return "console/button";
    }

    //国际级奖项申报
    @GetMapping("/international/{id}")
    public String internationalDeclare(@PathVariable("id")String id, Model model){
        int project_id = Integer.valueOf(id);
        ProjectDTO projectDTO = projectUseCase.detailProject(project_id);
        model.addAttribute("project",projectDTO);
        List<DeclareDTO> declareDTO_international = declareUseCase.enableDeclareType("国际级");
        model.addAttribute("declare",declareDTO_international);
        return "console/declare_begin_international";
    }

    @PostMapping("/international")
    public String internationalUpload(String userId,String matchId, String projectId, MultipartFile f4) throws IOException {
        prizeUploadUtils.prizeUpload(userId, matchId, projectId, f4);
        System.out.println(userId);
        return "redirect:/user/prizeExamine/"+userId;
    }

    //国家级奖项申报
    @GetMapping("/country/{id}")
    public String countryDeclare(@PathVariable("id")String id, Model model){
        int project_id = Integer.valueOf(id);
        ProjectDTO projectDTO = projectUseCase.detailProject(project_id);
        model.addAttribute("project",projectDTO);
        List<DeclareDTO> declareDTO_country = declareUseCase.enableDeclareType("国家级");
        model.addAttribute("declare",declareDTO_country);
        return "console/declare_begin_country";
    }

    @PostMapping("/country")
    public String countryUpload(String userId,String matchId, String projectId, MultipartFile f4) throws IOException {
        prizeUploadUtils.prizeUpload(userId, matchId, projectId, f4);
        return "redirect:/user/prizeExamine/"+userId;
    }

    //省市级奖项申报
    @GetMapping("/province/{id}")
    public String provinceDeclare(@PathVariable("id")String id, Model model){
        int project_id = Integer.valueOf(id);
        ProjectDTO projectDTO = projectUseCase.detailProject(project_id);
        model.addAttribute("project",projectDTO);
        List<DeclareDTO> declareDTO_province = declareUseCase.enableDeclareType("省市级");
        model.addAttribute("declare",declareDTO_province);
        return "console/declare_begin_province";
    }

    @PostMapping("/province")
    public String provinceUpload(String userId,String matchId, String projectId, MultipartFile f4) throws IOException {
        prizeUploadUtils.prizeUpload(userId, matchId, projectId, f4);
        return "redirect:/user/prizeExamine/"+userId;
    }

    //地级奖项申报
    @GetMapping("/city/{id}")
    public String cityDeclare(@PathVariable("id")String id, Model model){
        int project_id = Integer.valueOf(id);
        ProjectDTO projectDTO = projectUseCase.detailProject(project_id);
        model.addAttribute("project",projectDTO);
        List<DeclareDTO> declareDTO_city = declareUseCase.enableDeclareType("地　 级");
        model.addAttribute("declare",declareDTO_city);
        return "console/declare_begin_city";
    }

    @PostMapping("/city")
    public String cityUpload(String userId,String matchId, String projectId, MultipartFile f4) throws IOException {
        prizeUploadUtils.prizeUpload(userId, matchId, projectId, f4);
        return "redirect:/user/prizeExamine/"+userId;
    }
}
