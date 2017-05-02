/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import com.google.gson.Gson;
import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.dataaccess.DABemanningslid;
import hbo5.it.www.dataaccess.DAFunctie;
import hbo5.it.www.dataaccess.DAPersoon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nickvandepaer
 */
@WebServlet(name = "FunctieServlet", urlPatterns = {"/api/functieservlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "c1039600")
    , @WebInitParam(name = "password", value = "5818 ")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class FunctieServlet extends HttpServlet {


    private DAFunctie dafunctie = null;
    
    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (dafunctie == null) {
                dafunctie = new DAFunctie(url, login, password, driver);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    public void destroy() {
        try {
            if (dafunctie != null) {
                dafunctie.close();
            }
        } catch (SQLException ex) {
            
        }
    }
    
//    private Bemanningslid parseRequest(HttpServletRequest request) {
//        Bemanningslid b = new Bemanningslid();
//        b.setId(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
//        
//        b.setLuchtvaartmaatschappij(new Luchtvaartmaatschappij(Integer.parseInt(request.getParameter("luchtvaartmaatschappij_id") == null ? 0: 
//                request.getParameter("luchtvaartmaatschappij[id]"))));
//        
//        b.setPersoon(new Persoon(Integer.parseInt(request.getParameter("persoon_id") == null ? 0: 
//                request.getParameter("persoon[id]"))));
//        
//        b.setFunctie(new Functie(Integer.parseInt(request.getParameter("functie_id") == null ? 0: 
//                request.getParameter("functie[id]"))));
//        
//        return b;
//        
//    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Functie> functies = dafunctie.listFuncties();
            
            Gson gson = new Gson();
            
            response.setContentType("application/json");
            
            response.getWriter().write(gson.toJson(functies));
        } catch (Exception e) {
            response.sendError(500);
            e.printStackTrace();
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}