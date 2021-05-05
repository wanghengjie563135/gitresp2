package whj.edu.tjcu.web.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //解决响应乱码
      response.setContentType("application/json;charset=utf-8");
        //获取用户名
        String username = request.getParameter("username");
        //map对象
        Map<String,Object> map =new HashMap<String, Object>();
        //调用service判断用户名是否存在
        if("tom".equals(username)){
            //存在
            map.put("userExsit",true);
            map.put("msg","此用户名太受欢迎了，请重新换一个吧！");
        }else {
            //不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }
        //将map转化为json，并且转化到页面上,并且传递给客户端
        //json中jackson的核心类，objectMapper
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(map);
        response.getWriter().write(value);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
