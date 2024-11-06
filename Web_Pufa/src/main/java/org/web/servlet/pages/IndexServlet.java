package org.web.servlet.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;
import org.web.entity.User;
import org.web.utils.ThymeleafUtil;

import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user =(User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());

        ThymeleafUtil.process("index.html",new Context(),resp.getWriter());
    }
}
