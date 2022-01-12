package com.proiectlab.bean;

import com.proiectlab.entity.Product;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class ProductBean {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getAllProducts() {
        try {
            TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public List<Product> getAllProductsByUnit(String unit) {
        try {
            Query query = em.createQuery("SELECT p FROM Product p WHERE p.unit = :unit")
            .setParameter("unit", unit);
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
     public List<Product> getAllProductsSortedByNameAndUnit() {
        try {
            Query query = em.createQuery("SELECT p FROM Product p ORDER BY p.productName, p.unit");
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public Product findById(Integer productId) {
        Product product = em.find(Product.class, productId);
        return product;
    }

    public Product findByName(String productName) {
        TypedQuery<Product> query = em.createNamedQuery("Product.findByProductName", Product.class);
        query.setParameter("productName", productName);
        Product result = query.getSingleResult();

        return result;
    }

    public void createProduct(String productName, Double price, String unit, Double quantity) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Product product = new Product();
        product.setProductName(productName);
        product.setUnit(unit);
        product.setPrice(price);
        product.setQuantity(quantity);

        em.persist(product);
    }

    public void updateProduct(Product product, String newProductName, Double newPrice, String newUnit, Double quantity) {
        if (!em.contains(product)) {
            product = em.merge(product);
        }
        if (newProductName != null) {
            product.setProductName(newProductName);
        }
        if (newPrice != null) {
            product.setPrice(newPrice);
        }
        if (newUnit != null) {
            product.setUnit(newUnit);
        }
        if (quantity != null) {
            product.setQuantity(quantity);
        }
    }
    
    public void deleteProductById(Integer id){
        Product productToDelete = findById(id);
        
        deleteProduct(productToDelete);
    }

    public void deleteProduct(Product product) {
        if (!em.contains(product)) {
            product = em.merge(product);
        }
        em.remove(product);
    }
}

