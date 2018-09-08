/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caroline Ignácio
 */
public class HashCriptografico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String senha = request.getParameter("algorithm");

        MessageDigest algorithm;
        String senhahex = "";
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            System.out.println(hexString.toString());
            senhahex = hexString.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashCriptografico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("senhahex", senhahex);
        request.getRequestDispatcher("HashCriptografico.jsp").forward(request, response);
        
        }
    
    }
