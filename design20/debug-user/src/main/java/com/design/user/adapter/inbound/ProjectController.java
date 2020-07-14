package com.design.user.adapter.inbound;

import com.design.user.adapter.inbound.dto.ProjectDTO;
import com.design.user.application.inbound.ProjectUseCase;
import com.design.user.application.inbound.UserUseCase;
import com.design.user.domain.IdMessage;
import com.design.user.utils.InterceptUtils;
import com.design.user.utils.UserViewUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
@AllArgsConstructor
public class ProjectController {
    @Autowired
    private final ProjectUseCase projectUseCase;

    @Autowired
    private final InterceptUtils interceptUtils;


    //账户项目页面//
    @GetMapping("/userProject/{id}")
    public String userProject(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userAllProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("allProject",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table";
        }

    }

    //账户未审核项目页面//
    @GetMapping("/notExaminedProject/{id}")
    public String notExaminedProject(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userNewProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("notExaminedProject",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_notexamined";
        }
    }

    //账户审核中项目页面//
    @GetMapping("/examiningProject/{id}")
    public String examiningProject(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userExamineProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("examiningProject",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_examining";
        }

    }

    //账户审核完毕项目页面//
    @GetMapping("/examinedProject/{id}")
    public String examinedProject(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userFinalProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("examinedProject",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_examined";
        }

    }


    //账户信息-----账户项目页面//
    @GetMapping("/userPro/{id}")
    public String userProject_project(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userAllProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("messageAllProject",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_1";
        }

    }

    //项目信息-----账户未审核项目页面//
    @GetMapping("/notExaminedProjectM/{id}")
    public String notExaminedProjectM(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userNewProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("messageNotExamined",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_1_notexamined";
        }

    }

    //项目信息-----账户审核中项目页面//
    @GetMapping("/examiningProjectM/{id}")
    public String examiningProjectM(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userExamineProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("messageExamining",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_1_examining";
        }

    }

    //项目信息-----账户审核完毕项目页面//
    @GetMapping("/examinedProjectM/{id}")
    public String examinedProjectM(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS= projectUseCase.userFinalProject(user_id);
        System.out.println(projectDTOS);
        model.addAttribute("messageExamined",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/editable_table_1_examined";
        }

    }
    //上传项目页面//
    @GetMapping("/uploadProject/{id}")
    public String uploadProject(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/form_component_project";
        }

    }
    //上传项目//
    @PostMapping("/uploadProject")
    public String toUploadProject(String name, String information, String type, String address, String time, String id, MultipartFile f3)throws IOException {
        System.out.println(id);
        String fileName;
        if(f3 == null){
            fileName = ".";
            return "/user/uploadProject/"+id;
        }else{
            fileName = f3.getOriginalFilename();
        }

        assert fileName != null;
        int start = fileName.indexOf(".");
        String fileType = fileName.substring(start);
        String value = UUID.randomUUID().toString();


        File copyFile = new File("E:\\uploadRar",value+fileType);

        //文件复制
        f3.transferTo(copyFile);
        int user_id = Integer.valueOf(id);
        projectUseCase.userSubmission(name,information,type,address,"/projectDocuments/"+value+fileType,time,user_id);
        System.out.println("/projectDocuments/"+value+fileType);
        System.out.println(user_id);
        System.out.println(projectUseCase.userSubmission(name,information,type,address,"/projectDocuments/"+value+fileType,time,user_id));

        return "redirect:/user/userPro/"+id;
    }

    //获奖项目 ---prizeController//


    //账户信息----项目更新//
    @RequestMapping("/userUpdateProject")
    public String userUpdateProject(String uid ,String pid ,String name ,String type ,String address ,String time){
        int user_id = Integer.valueOf(uid);
        int project_id = Integer.valueOf(pid);
        projectUseCase.userUpdateProject(name,type,address,time,project_id,user_id);
        System.out.println(projectUseCase.userUpdateProject(name,type,address,time,project_id,user_id));
        return "redirect:/user/userPro/"+user_id;
    }

    //奖项申报//
    @GetMapping("/prizeUpload/{id}")
    public String prizeUpload(@PathVariable("id") String id , Model model){
        projectUseCase.checkDeclare();
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<ProjectDTO> projectDTOS = projectUseCase.userFinalProject(user_id);
        model.addAttribute("oneExaminedProject",projectDTOS);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/advanced_upload_prize";   //form_wizard
        }

    }

    //项目详情//
    @GetMapping("/detailProject/{id}")
    public String detailProject(@PathVariable("id") String id , Model model){
        int project_id = Integer.valueOf(id);
        ProjectDTO projectDTO = projectUseCase.detailProject(project_id);
        model.addAttribute("project",projectDTO);
        return "console/form_validation";
    }

    //项目删除//
    @PostMapping("/deletedProject/{id}")
    public String deletedProject(@PathVariable("id") String id , Model model){
        int project_id = Integer.valueOf(id);
        projectUseCase.deletedProject(project_id);
        return "redirect:/user/userPro/"+id;
    }
}
