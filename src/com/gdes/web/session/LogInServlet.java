package com.gdes.web.session;

import com.gdes.domain.User;
import com.gdes.service.UserService;
import com.gdes.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/logInServlet")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置request编码
        request.setCharacterEncoding("utf-8");

        //2.获取数据
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");

        String verifycode = request.getParameter("verifycode");

        //3.1获取生成的验证码
        HttpSession session = request.getSession();
        String verifyCode_session = (String) session.getAttribute("verifyCode_session");
        //删除sessin中存储的验证码
        session.removeAttribute("verifyCode_session");


        //3.2判断验证码是否正确，忽略大小写
        if (verifyCode_session != null && verifyCode_session.equalsIgnoreCase(verifycode)){
            //3.2.1验证码正确，判断账号密码是否正确
            //3.2.2
            Map<String, String[]> map = request.getParameterMap();

            //2.1封装User对象
            User user = new User();
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //2.2调用Service查询
            UserService service = new UserServiceImpl();
            User loginUser = service.login(user);
            //3.2.2查询sql   （需要修改！！！）
            if (loginUser != null){
                //登陆成功
                session.setAttribute("user", loginUser);
                //重定向到首页index.jsp
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                //登陆失败
                request.setAttribute("login_error", "用户名或密码错误");
                //转发到登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else{
            //验证码不正确
            request.setAttribute("vc_error", "验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
