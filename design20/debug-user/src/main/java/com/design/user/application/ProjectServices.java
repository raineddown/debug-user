package com.design.user.application;

import com.design.user.adapter.inbound.dto.ProjectDTO;
import com.design.user.application.inbound.ProjectUseCase;
import com.design.user.application.outbound.ProjectRepository;
import com.design.user.domain.Prize;
import com.design.user.domain.Project;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
public class ProjectServices implements ProjectUseCase {
    @Autowired
    private final ProjectRepository projectRepository;

    @Override
    public boolean userSubmission(String name,String information,String type,String address,String images,String time,int user_id) {
        return projectRepository.userSubmission(name, information, type, address, images, time, user_id);
    }

    @Override
    public boolean userUpdateProject(String name,String type,String address,String time,int project_id,int user_id) {
        return projectRepository.userUpdateProject(name, type, address, time, project_id, user_id);
    }

    @Override
    public List<ProjectDTO> userAllProject(int user_id) {
        return projectRepository.userAllProject(user_id).stream()
                .map(Project::makeProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> userNewProject(int user_id) {
        return projectRepository.userNewProject(user_id).stream()
                .map(Project::makeProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> userExamineProject(int user_id) {
        return projectRepository.userExamineProject(user_id).stream()
                .map(Project::makeProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectDTO> userFinalProject(int user_id) {
        return projectRepository.userFinalProject(user_id).stream()
                .map(Project::makeProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO detailProject(int project_id) {
        Project project = projectRepository.detailProject(project_id);
        return project.makeProjectDTO();
    }

    @Override
    public boolean deletedProject(int project_id) {
        return projectRepository.deletedProject(project_id);
    }

    @Override
    public boolean checkDeclare() {
        String url = "http://localhost:8081/user/check";
        String param = "";
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);

            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();

            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());

            // 发送请求参数
            out.print(param);

            // flush输出流的缓冲
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }

        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return true;
    }

}
