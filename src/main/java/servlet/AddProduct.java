package servlet;

import com.proiectlab.bean.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {

    @Inject
    ProductBean productBean;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        if (request.getParameter("productName") == null){
            request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
        }else {
            //vom adauga produs
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("price"));
            String unit = request.getParameter("unit");
            double qty = Double.parseDouble(request.getParameter("quantity"));
            
            productBean.createProduct(productName, price, unit, qty);
            
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
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
