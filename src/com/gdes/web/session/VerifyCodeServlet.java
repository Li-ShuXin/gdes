package com.gdes.web.session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int wight = 100;
        int height = 50;

        //1.创建一个图片对象
        BufferedImage image = new BufferedImage(wight, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1填充背景色
        Graphics g  = image.getGraphics(); //画笔对象
        g.setColor(Color.PINK);  //画笔颜色
        g.fillRect(0,0, wight, height);

        //2.2画边框
        g.setColor(Color.black);  //画笔颜色
        g.drawRect(0,0, wight-1, height-1);

        //2.3.1生成随机值
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random ran = new Random();

        //2.3.2存储生成的字符
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 4; i++){
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            //2.3.3输出验证码
            g.drawString(ch+"", wight/5*i, height/2);
        }

        //2.3.4使用session存储同步验证码
        String verifyCode_session = sb.toString();
        request.getSession().setAttribute("verifyCode_session", verifyCode_session);


        //3.将图片输出到页面
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
