package com.example.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "profile", value = "/profile")
public class profile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("link.jsp").include(request, response);

        Cookie ck[]=request.getCookies();
        for(int i=0;i<ck.length;i++){
            System.out.println("<br>"+ck[i].getName()+" "+ck[i].getValue());
        }

        if(ck!=null){
            String userName=ck[0].getValue();
            if(!userName.equals("")||userName!=null){

                out.println(
                        "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                                "<html>" +
                                "   <head></head>" +
                                "   <body bgcolor = \"#f0f0f0\">" +
                                "       <table border = \"1\">" +
                                "           <tr bgcolor = \"#949494\">" +
                                "               <th>Welcome to Profile!</th>" + "<br>" +
                                "               <th>Welcome </th>" + userName + "<br>" +
                                "               <th> Your are in profile</th>" +
                                "           </tr>" +
                                "       </table>" +
                                "   </body>" +
                                "</html>"
                );
            }
        }else{
            out.print("Please login first");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        out.close();
    }
    @Override
    public void destroy() {
    }
}
