package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "logout", value = "/logout")
public class logout extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        request.getRequestDispatcher("link.jsp").include(request, response);

        Cookie ck=new Cookie("name","");
        ck.setMaxAge(0);
        response.addCookie(ck);


        out.println(
                "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                        "<html>" +
                        "   <head></head>" +
                        "   <body bgcolor = \"#f0f0f0\">" +
                        "       <table border = \"1\">" +
                        "           <tr bgcolor = \"#949494\">" +
                        "               <th>You are successfully logged out!</th>" +
                        "           </tr>" +
                        "       </table>" +
                        "   </body>" +
                        "</html>"
        );

    }
    @Override
    public void destroy() {
    }
}