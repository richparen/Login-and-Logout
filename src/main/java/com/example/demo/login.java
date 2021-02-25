package com.example.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("link.jsp").include(request, response);

        String userName=request.getParameter("userName");
        String password=request.getParameter("password");

        if(password.equals("admin") && !userName.equals("")){

            out.println(
                    "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                            "<html>" +
                            "   <head></head>" +
                            "   <body bgcolor = \"#f0f0f0\">" +
                            "       <table border = \"1\">" +
                            "           <tr bgcolor = \"#949494\">" +
                            "               <th>You are successfully logged in!</th>" +
                            "               <th>Successfully logged in!</th>" +
                            "           </tr>" +
                            "       </table>" +
                            "   </body>" +
                            "</html>"
            );



           /* System.out.println("Successfully logged in!");*/

            out.println(
                    "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                            "<html>" +
                            "   <head></head>" +
                            "   <body bgcolor = \"#f0f0f0\">" +
                            "       <table border = \"1\">" +
                            "           <tr bgcolor = \"#949494\">" +
                            "               <th><br>Welcome!</th>" + userName +
                            "           </tr>" +
                            "       </table>" +
                            "   </body>" +
                            "</html>"
            );



            Cookie ck=new Cookie("userName",userName);
            ck.setMaxAge(30*60);
            response.addCookie(ck);
        }else{
            out.println(
                    "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                            "<html>" +
                            "   <head></head>" +
                            "   <body bgcolor = \"#f0f0f0\">" +
                            "       <table border = \"1\">" +
                            "           <tr bgcolor = \"#949494\">" +
                            "               <th>sorry, username or password error!!</th>" +
                            "           </tr>" +
                            "       </table>" +
                            "   </body>" +
                            "</html>"
            );
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

        out.close();
    }
    @Override
    public void destroy() {
    }
}
