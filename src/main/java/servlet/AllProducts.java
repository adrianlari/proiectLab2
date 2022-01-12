/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.proiectlab.bean.ProductBean;
import com.proiectlab.entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AllProducts", urlPatterns = {"/AllProducts"})
public class AllProducts extends HttpServlet {

    @Inject
    ProductBean productbean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productsToSend = null;
        
        if (request.getParameter("unit") == null || request.getParameter("unit").equals("none")) {
            if (request.getParameter("sort") != null && request.getParameter("sort").equals("true")){
                productsToSend = productbean.getAllProductsSortedByNameAndUnit();
            } else {
                productsToSend = productbean.getAllProducts();
            }
        } else {
            productsToSend = productbean.getAllProductsByUnit(request.getParameter("unit"));
        }

        request.setAttribute("allProducts", productsToSend);

        request.getRequestDispatcher("/WEB-INF/pages/allProducts.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
