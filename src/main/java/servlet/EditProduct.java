package servlet;

import com.proiectlab.bean.ProductBean;
import com.proiectlab.entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
public class EditProduct extends HttpServlet {

    @Inject
    ProductBean productBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("edited") == null) {
            int productId = Integer.parseInt(request.getParameter("productId"));

            Product productToEdit = productBean.findById(productId);
            request.setAttribute("product", productToEdit);

            request.getRequestDispatcher("/WEB-INF/pages/editProduct.jsp").forward(request, response);
        } 
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("price"));
            String unit = request.getParameter("unit");
            double qty = Double.parseDouble(request.getParameter("quantity"));
            
            Product product = productBean.findById(id);
            productBean.updateProduct(product, productName, price, unit, qty);
            
            response.sendRedirect("http://localhost:8080/proiectLab/AllProducts");

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
