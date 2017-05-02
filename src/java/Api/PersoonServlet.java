/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import com.google.gson.Gson;
import hbo5.it.www.beans.Persoon;
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
@WebServlet(name = "PersoonServlet", urlPatterns = {"/api/persoonservlet"}, initParams = {
    @WebInitParam(name = "url", value = "jdbc:oracle:thin:@ti-oracledb06.thomasmore.be:1521:XE")
    , @WebInitParam(name = "login", value = "c1039600")
    , @WebInitParam(name = "password", value = "5818 ")
    , @WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver")})
public class PersoonServlet extends HttpServlet {
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        
//    }

    private DAPersoon dapersoon = null;
    
    @Override
    public void init() throws ServletException {
        try {
            String url = getInitParameter("url");
            String password = getInitParameter("password");
            String login = getInitParameter("login");
            String driver = getInitParameter("driver");
            if (dapersoon == null) {
                dapersoon = new DAPersoon(url, login, password, driver);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    public void destroy() {
        try {
            if (dapersoon != null) {
                dapersoon.close();
            }
        } catch (SQLException ex) {
            
        }
    }
    
    private Persoon parseRequest(HttpServletRequest request) {
        Persoon p = new Persoon();
        p.setId(request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")));
        
        p.setFamilienaam(request.getParameter("familienaam"));
        p.setVoornaaam(request.getParameter("voornaam"));
        p.setStraat(request.getParameter("straat"));
        p.setHuisnr(request.getParameter("huisnr"));
        p.setPostcode(request.getParameter("postcode"));
        p.setWoonplaats(request.getParameter("woonplaats"));
        p.setLand(request.getParameter("land"));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date parsed = format.parse(request.getParameter("geboortedatum"));
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
        } catch (Exception e) {
        }
        p.setLogin(request.getParameter("login"));
        p.setPaswoord(request.getParameter("paswoord"));
        return p;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Persoon> personen = dapersoon.ListPersonen();
            
            Gson gson = new Gson();
            
            response.setContentType("application/json");
            
            response.getWriter().write(gson.toJson(personen));
        } catch (Exception e) {
            response.sendError(500);
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Persoon p = parseRequest(request);
            
//            //Autonummering id
//            p.setFamilienaam(request.getParameter("txt1"));
//            p.setVoornaaam(request.getParameter("txt2"));
//            p.setStraat("LAngebaan");
//            p.setHuisnr("16");
//            p.setPostcode("2568");
//            p.setWoonplaats("Shakaa");
//            p.setLand("Belgie");
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//            try {
////                java.util.Date parsed = format.parse("05/05/1988");
//                    java.util.Date parsed = format.parse(request.getParameter("datum"));
//                java.sql.Date sql = new java.sql.Date(parsed.getTime());
//                p.setGeboortedatum(sql);
//            } catch (Exception e) {
//                System.out.println("fout");
//            }
//            
//            p.setLogin("test");
//            p.setPaswoord("test");

            p.setId(Integer.parseInt(request.getParameter("id")));
                    
            Gson gson = new Gson();
            
            String type = request.getQueryString();
            
            switch (type) {
                case "update": {
                    dapersoon.doUpdate(p);
                    break;
                }
                case "delete": {
                    dapersoon.doDelete(p);
                    break;
                }
                case "create": {
                    p.setId(dapersoon.doCreate(p));
                    response.getWriter().write(gson.toJson(p));
                    
                    break;
                }
            }
        } catch (Exception e) {
            //fout?
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
