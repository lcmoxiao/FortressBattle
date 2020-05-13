package web.mservlet;

import base.classLoader.MyClassLoader;
import base.compile.MyCompiler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt = req.getParameter("opt");
        String content = req.getParameter("content");
        if (opt.equals("0")) {
            //String content = "package play; public class Test{ public static void main(String[] args){System.out.println(\"base.compile test.\");} }";
            Class<?> cls = MyCompiler.compile("play.Test", content);
        } else {
            MyClassLoader myClassLoader = new MyClassLoader();
            try {
                Class c = myClassLoader.loadClass("playcache.Test");
                Method method = c.getMethod("main", String[].class);
                method.invoke(null, new Object[]{new String[]{}});
                req.setAttribute("resp", "成功运行真棒");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
