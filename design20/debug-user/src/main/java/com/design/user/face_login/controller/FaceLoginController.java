package com.design.user.face_login.controller;



import com.design.user.adapter.inbound.dto.UserDTO;
import com.design.user.application.inbound.UserUseCase;
import com.design.user.face_login.service.LoginService;
import com.design.user.face_login.Utils.GsonUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@SessionAttributes(value = "useinf")
@AllArgsConstructor
public class FaceLoginController {
    @Autowired
    LoginService loginService=null;
    @Autowired
    private final UserUseCase userUseCase;

    @GetMapping("/login/toFaceLogin")
    public String toFaceLogin(){
        return "faceLogin";
    }

    @RequestMapping("/login/jumpGetFace")
    public String adminLogin(@RequestParam("username")String username,
                             @RequestParam("password") String password,
                             Model model, HttpSession session){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(username);
        if(isNum.matches() && username.length()<11){
            int id = Integer.valueOf(username);
            UserDTO userById = userUseCase.findUserById(id,password);
            if(userById!=null){
                session.setAttribute("loginUser",userById);
                return "getface";  // redirect:/
            }else{
                model.addAttribute("msg","用户名或密码错误！");
                return "faceLogin";
            }
        }else {
            UserDTO userByPhone = userUseCase.findUserByPhone(username,password);
            if(userByPhone!=null){
                session.setAttribute("loginUser",userByPhone);
                return "getface";  // redirect:/
            }else{
                model.addAttribute("msg","用户名或密码错误！");
                return "faceLogin";
            }
        }
    }
    /*
     public String getface(){
        return "getface";
    }
     */


    @RequestMapping("/login/searchFace")
    @ResponseBody
    public  String searchface(@RequestBody @RequestParam(name = "imagebast64") StringBuffer imagebast64, Model model, HttpServletRequest request) throws IOException {
        Map<String, Object> searchface = loginService.searchface(imagebast64);
        if(searchface==null||searchface.get("user_id")==null){
            System.out.println("我进来了");
            String flag="fail";
            String s = GsonUtils.toJson(flag);
            return s;
        }
            String user_id = searchface.get("user_id").toString();
            String score=searchface.get("score").toString().substring(0,2);
            int i = Integer.parseInt(score);
            if(i>80){
                model.addAttribute("userinf",user_id);
                HttpSession session = request.getSession();
                session.setAttribute("userinf",user_id);
                //session.setAttribute("loginUser",user_id);
                System.out.println("存入session");
            }


        System.out.println(searchface);
        String s = GsonUtils.toJson(searchface);
        return s;


    }
    @RequestMapping("/login/faceSucceed")
    public String faceLoginSucceed(){
        System.out.println("success");
        return "redirect:/loginSuccess";
    }

}
