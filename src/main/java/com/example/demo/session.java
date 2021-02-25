package com.example.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet(value = "/session")
public class session extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);


        String title = "Welcome Back";
        Integer visitCount = new Integer(0);
        String visitCountKey = new String("visitCount");
        String userIDKey = new String("userID");
        String userID = new String("USER_26279");


        if (session.isNew()) {
            title = "Welcome!";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = session.getAttribute(visitCountKey) != null
                    ? (Integer)session.getAttribute(visitCountKey)
                    : visitCount;
            visitCount = visitCount + 1;
            userID = (String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey,  visitCount);


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">" +
                        "<html>" +
                        "   <head><title>" + title + "</title></head>" +
                        "   <body bgcolor = \"#f0f0f0\">" +
                        "       <h1 align = \"center\">" + title + "</h1>" +
                        "       <h2 align = \"center\">Session Infomation</h2>" +
                        "       <table border = \"1\" align = \"center\">" +
                        "           <tr bgcolor = \"#949494\">" +
                        "               <th>Session info</th>" +
                        "               <th>value</th>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>id</td>" +
                        "               <td>" + session.getId() + "</td>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>User ID</td>" +
                        "               <td>" + userID + "  </td>" +
                        "           </tr>" +
                        "           <tr>" +
                        "               <td>Number of visits</td>" +
                        "               <td>" + visitCount + "</td>" +
                        "           </tr>" +
                        "       </table>" +
                        "   </body>" +
                        "</html>"
        );
    }
}