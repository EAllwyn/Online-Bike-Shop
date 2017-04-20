package com.mit.shoppingcart;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mit.dao.ProductDAO;
import com.mit.model.Product;

@Controller
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/selAddProduct")
	public ModelAndView showProductAdd()
	{
		log.debug("Start method showProductAdd");
		ModelAndView mv=new ModelAndView("/AddProduct","command", new Product());
		log.debug("End of showProductAdd");
		return mv;
	}
	
	
	@RequestMapping(value="/addProduct",  method = RequestMethod.POST)
	public ModelAndView addProductFunction(@ModelAttribute Product product)
	{
		log.debug("Start of addProductFunction");
		productDAO.saveProduct(product);
		String path="C:\\Users\\DHANUSHA\\workspace1\\shoppingcart\\src\\main\\webapp\\Resources\\images";
		path=path+String.valueOf(product.getProductID())+".jpg";
		File f=new File(path);
		MultipartFile filedet= product.getProductImage();
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  FileOutputStream fos=new FileOutputStream(f);
              BufferedOutputStream bs=new BufferedOutputStream(fos);
              		bs.write(bytes);
              		bs.close();
              		log.debug("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				log.debug("Exception Arised"+e);
			}
		}
		else
		{
			log.debug("File is Empty not Uploaded");			
		}
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Product ADDED");
		log.debug("End of addProductFunction");
		return mv;
	}
	
	@RequestMapping("/selEditProduct")
	public ModelAndView showEditProduct(Map<String, Object> map)
	{
		log.debug("Start of showEditProduct");
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		ModelAndView mv=new ModelAndView("/EditProduct",map);
		log.debug("End of showEditProduct");
		return mv;
	}
	
	@RequestMapping("/findProduct")
	public ModelAndView findProduct(@RequestParam("pID") String prID, Map<String, Object> map)
	{
		log.debug("Start of findProduct");
		Product pr=productDAO.getProductById(prID);
		ModelAndView mv=new ModelAndView("/EditProduct2","command", new Product() );
		mv.addObject("prFound", pr);
		log.debug("End of findProduct");
		return mv;
	}
	
	@RequestMapping(value="/EditProduct",  method = RequestMethod.POST)
	public ModelAndView editProductFunction(@ModelAttribute Product product,@RequestParam("prID") String pID)
	{
		log.debug("Start of editProductFunction");
		product.setProductID(pID);
		productDAO.updateProduct(product);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Product Edited");
		log.debug("End of editProductFunction");
		return mv;
	}
	
	@RequestMapping("/selDeleteProduct")
	public ModelAndView deleteProductFunction()
	{
		log.debug("Start of deleteProductFunction");
		ModelAndView mv=new ModelAndView("/DeleteProduct");
		log.debug("End of deleteProductFunction");
		return mv;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("pID") String prID)
	{
		log.debug("Start of deleteProduct");
		productDAO.deleteProduct(prID);
		ModelAndView mv=new ModelAndView("/Admin");
		log.debug("End of deleteProduct");
		return mv;
	}
	
	@RequestMapping("/selViewProduct")
	public ModelAndView viewProduct(Map<String, Object> map)
	{
		log.debug("Start of viewProduct");
		String path="Resources/images/";
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		map.put("path", path);
		ModelAndView mv=new ModelAndView("/ViewProduct",map);
		log.debug("End of viewProduct");
		return mv;
	}
	
	@RequestMapping("/clickProducts")
	public ModelAndView showProducts()
	{
		log.debug("Start of viewProduct");
		List<Product> prList=productDAO.getAllProduct();
		String path="Resources/images/";
		ModelAndView mv=new ModelAndView("/Products");
		mv.addObject("prList", prList);
		mv.addObject("path",path);
		log.debug("End of viewProduct");
		return mv;
	}
	
}
  