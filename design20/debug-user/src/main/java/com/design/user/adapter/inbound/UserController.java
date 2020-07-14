package com.design.user.adapter.inbound;

import com.design.user.adapter.inbound.dto.CollectionDTO;
import com.design.user.application.inbound.UserUseCase;
import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.application.outbound.CollectionRepository;
import com.design.user.domain.*;
import com.design.user.utils.InterceptUtils;
import com.design.user.utils.UserViewUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    //用户信息、页面跳转、用户登录与注册//

    @Autowired
    private final UserUseCase userUseCase;

    @Autowired
    private final UserViewUtils userViewUtils;

    @Autowired
    private final InterceptUtils interceptUtils;

    @Autowired
    private final CollectionRepository collectionRepository;

    @RequestMapping("/findMessage")
    public String findUserMessage(Model model){
        UserDTO users = userUseCase.userMessage(1);
        model.addAttribute("userMessage",users);
        return "test";
    }

    @RequestMapping("/register")
    public String registerUser(String username ,String password ,String phone){
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String registerTime = date.format(fmt);
        UserDTO userDTO = new UserDTO(username, password ,phone ,registerTime);
        userUseCase.addUser(userDTO);
        return "redirect:/user/login";
    }

    //去登录页面//
    @GetMapping("/login")
    public String testUserLogin(){
        return "login";
    }

    //登录成功页面//
    @RequestMapping("/loginSuccess")
    public String testTrueLogin(@RequestParam("username")String username,
                                @RequestParam("password") String password,
                                Model model, HttpSession session){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(username);
        if(isNum.matches() && username.length()<11){
            int id = Integer.valueOf(username);
            UserDTO userById = userUseCase.findUserById(id,password);
            if(userById!=null){
                session.setAttribute("loginUser",userById);
                return "redirect:/loginSuccess";  // redirect:/
            }else{
                model.addAttribute("msg","用户名或密码错误！");
                return "login";
            }
        }else {
            UserDTO userByPhone = userUseCase.findUserByPhone(username,password);
            if(userByPhone!=null){
                session.setAttribute("loginUser",userByPhone);
                return "redirect:/loginSuccess";  // redirect:/
            }else{
                model.addAttribute("msg","用户名或密码错误！");
                return "login";
            }
        }

    }

    @GetMapping("/successReturn")
    public String loginReturn(){
        return "success";
    }

    //协会介绍页面//
    @GetMapping("/association")
    public String features(){
        return "features";
    }

    //平台介绍页面//
    @GetMapping("/platform")
    public String platform(){
        return "tour";
    }
    //项目展览页面//

    //奖项介绍页面//
    @GetMapping("/prize")
    public String prize(){
        return "pricing";
    }

    //申报流程页面//
    @GetMapping("/process")
    public String process(){
        return "contact";
    }

    //控制台模式页面//
    //控制台主页面//
    @GetMapping("/console/{id}")
    public String console(@PathVariable("id") String id,Model model){
        userViewUtils.viewUser(id,model);
        int user = collectionRepository.countUser();
        int project = collectionRepository.countProject();
        int expert = collectionRepository.countExpert();
        int prize = collectionRepository.countPrize();
        model.addAttribute("userNumber",user);
        model.addAttribute("projectNumber",project);
        model.addAttribute("expertNumber",expert);
        model.addAttribute("prizeNumber",prize);
        return "console/index";
    }

    //账号信息页面//
    @GetMapping("/userMessage/{id}")
    public String userMessage(@PathVariable("id") String id,Model model){
        userViewUtils.viewUser(id,model);
        return "console/profile";
    }

    //账户修改上传头像
    @PostMapping("/uploadHead/{id}")
    public String uploadHeadImage(MultipartFile f1,@PathVariable("id") String id) throws IOException {
        String fileName;
        if(f1 == null) fileName = "/img/profile-avatar.jpg";
        else fileName = f1.getOriginalFilename();

        System.out.println("fileName:"+fileName);


        int start = fileName.indexOf(".");
        String fileType = fileName.substring(start);
        String value = UUID.randomUUID().toString();


        File copyFile = new File("E:\\upload\\img",value+fileType);

        //文件复制
        f1.transferTo(copyFile);
        int user_id = Integer.valueOf(id);
        userUseCase.uploadHead(user_id,"/upload/"+value+fileType);
        System.out.println(userUseCase.uploadHead(user_id,"/upload/"+value+fileType));
        System.out.println("/upload/"+value+fileType);
        System.out.println(user_id);
        return "redirect:/user/userMessage/{id}";
    }

    //账户信息修改页面//
    @GetMapping("/userChange/{id}")
    public String userChange(@PathVariable("id") String id,Model model){
        userViewUtils.viewUser(id,model);
        return "console/profile-edit";
    }

    //账号信息修改//
    @PostMapping("/userChange")
    public String changeMessage(String id,String username){
        int user_id = Integer.valueOf(id);
        userUseCase.updateUserMessage(user_id,username);
        System.out.println("-->"+userUseCase.updateUserMessage(user_id,username));
        System.out.println("-->"+user_id);
        System.out.println("-->"+username);
        return "redirect:/user/userChange/"+id;//"redirect:/user/userChange/"+user_id;
    }
    //账号绑定号码修改

    //账号密码修改//

    //企业认证上传执照页面//
    @GetMapping("/uploadCompany/{id}")
    public String uploadCompany(@PathVariable("id") String id,Model model){
        int user_id = Integer.valueOf(id);
        UserDTO userDTO = userUseCase.findUserOnlyId(user_id);
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        model.addAttribute("user",userDTO);
        return "console/form_component";
    }

    @PostMapping("/companyLicense")
    public String companyLicense(String id, String password, String workplace , MultipartFile f2) throws IOException{
        System.out.println(id);
        String fileName;
        if(f2 == null){
            fileName = ".";
            return "/user/uploadCompany/"+id;
        }else{
            fileName = f2.getOriginalFilename();
        }

        assert fileName != null;
        int start = fileName.indexOf(".");
        String fileType = fileName.substring(start);
        String value = UUID.randomUUID().toString();


        File copyFile = new File("E:\\upload\\companyLicense",value+fileType);

        //文件复制
        f2.transferTo(copyFile);
        int user_id = Integer.valueOf(id);
        userUseCase.userUpload(user_id, password, workplace, "/companyLicense/"+value+fileType);
        System.out.println("/companyLicense/"+value+fileType);
        System.out.println(user_id);
        System.out.println(userUseCase.userUpload(user_id, password, workplace, "/companyLicense/"+value+fileType));
        return "redirect:/user/userMessage/"+id;
    }
    //账户项目页面  ProjectController//


    //奖项介绍页面//
    @GetMapping("/introductionPrize/{id}")
    public String introductionPrize(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        return "console/image_cropping_prize";
    }

    //申报流程页面//
    @GetMapping("/prizeProcess/{id}")
    public String prizeProcess(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        return "console/image_cropping";
    }

    //奖项申报------ProjectController//


    //审核状态页面//
    @GetMapping("/prizeExamine/{id}")
    public String prizeExamine(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        int user_id = Integer.valueOf(id);
        List<CollectionDTO> collectionDTO = collectionRepository.findCollection(user_id);
        model.addAttribute("collections",collectionDTO);
        int min = 1;
        int max = 100;
        int threadIntBound = ThreadLocalRandom.current().nextInt(min, max);
        model.addAttribute("number",threadIntBound);
        if(!interceptUtils.intercept(id)){
            return "redirect:/user/blank";
        }else{
            return "console/general";
        }

    }

    //账户项目页面   ProjectController//

    //上传项目    ProjectController//

    //获奖项目     ProjectController//


    //奖项展示//
    @GetMapping("/viewPrize/{id}")
    public String viewPrize(@PathVariable("id") String id , Model model){
        IdMessage idMessage = new IdMessage(id);
        model.addAttribute("idMessage",idMessage);
        return "console/gallery";
    }

    //奖项查询页面-------prizeController//


    //平台锁页面//
    @GetMapping("/lock/{id}")
    public String lock(@PathVariable("id") String id , Model model){
        userViewUtils.viewUser(id,model);
        return "console/lock_screen";
    }

    //平台锁解锁//
    @GetMapping("/unlock")
    public String unlock(String id ,String password){
        int user_id = Integer.valueOf(id);
        UserDTO userDTO= userUseCase.findUserOnlyId(user_id);
        if(password.equals(userDTO.getPassword())){
            return "redirect:/user/console/"+ id;
        }else {
            return "redirect:/user/lock/"+ id;
        }
    }

    //登出//
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    //用户非企业认证类型拦截//
    @GetMapping("/blank")
    public String blank(){
        return "console/blank";
    }

    //未登入浏览平台页面//
    //协会介绍页面//
    @GetMapping("/noAssociation")
    public String noFeatures(){
        return "noLoginFeatures";
    }

    //平台介绍页面//
    @GetMapping("/noPlatform")
    public String noPlatform(){
        return "noLoginTour";
    }
    //项目展览页面//

    //奖项介绍页面//
    @GetMapping("/noPrize")
    public String noPrize(){
        return "noLoginPricing";
    }

    //申报流程页面//
    @GetMapping("/noProcess")
    public String noProcess(){
        return "noLoginContact";
    }

    //未登录不能进入控制台页面//
    @GetMapping("/noConsole")
    public String noConsole(Model model){
        model.addAttribute("msg","请先登录！");
        return "login";
    }



    @GetMapping("/test")
    public String test620(){
        return "dynamic_table";
    }
}
