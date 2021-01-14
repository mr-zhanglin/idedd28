import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取下载的文件名
        String filename = request.getParameter("filename");
        //获取web的域对象
        ServletContext context = request.getServletContext();
        //找到文件服务器路径
        String path = context.getRealPath("/img/" + filename);
        System.out.println("realPath" + path);
        System.out.println(context.getContextPath()+"PATH");

        //获取文件的mime类型
        String mimeType = context.getMimeType(filename);
        System.out.println("mimeType" + mimeType);
        //设置response响应头 content-type   告诉浏览器响应文件的类型  不会影响下载
        response.setHeader("content-type",mimeType);

        //解决中文文件名
        //获取user-agent   因为不同的浏览器agent不同  设置中文编码的方式有所不同
        //String agent = request.getHeader("user-agent");


        //进行编码  文件名中文乱码   不同的浏览器设置的方式有所不同  需要根据user-agent来进行判断
        filename = URLEncoder.encode(filename,"UTF-8");


        //设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);

        //使用直接输入流，加载文件进内存
        FileInputStream input = new FileInputStream(path);
        //将输入流的数据写到输出流中
        ServletOutputStream output = response.getOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while((len = input.read(b)) != -1){
            output.write(b,0,len);
            output.flush();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
