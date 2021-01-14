package ajax;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/servletAjax")
public class ServletAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ajax请求");
        User user = new User("a", "a", 1);
        User user1 = new User("1a", "a1", 11);

        ArrayList<User> us = new ArrayList<>();
        us.add(user);
        us.add(user1);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("re",jsonObject);
        System.out.println("jsonObject"+ jsonObject);
        response.setContentType("html/text;charset=UTF-8");
        response.getWriter().write(jsonObject.toJSONString(us));
        jsonObject.clear();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
