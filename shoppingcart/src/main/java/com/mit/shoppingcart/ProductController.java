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
	public ModelAndView showPAdd()
	{
		log.debug("Start go to addproduct");
		ModelAndView mv=new ModelAndView("/AddProduct","command", new Product());
		log.debug("End to");
		return mv;
	}
	
	
	@RequestMapping(value="/addProduct",  method = RequestMethod.POST)
	public ModelAndView addProductFunction(@ModelAttribute Product product)
	{
		log.debug("Start of Product add");
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
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              BufferedOutputStream bs=new BufferedOutputStream(fos);
              		bs.write(bytes);
              		bs.close();
             		System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}


		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Product ADDED");
		log.debug("End of Product add");
		return mv;
	}
	
	@RequestMapping("/selEditProduct")
	public ModelAndView showEditProduct(Map<String, Object> map)
	{
		log.debug("Start go to editproduct");
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		ModelAndView mv=new ModelAndView("/EditProduct",map);
		log.debug("End to editproduct");
		return mv;
	}
	
	@RequestMapping("/findProduct")
	public ModelAndView findProduct(@RequestParam("pID") String prID, Map<String, Object> map)
	{
		log.debug("Start to addproduct");
		Product pr=productDAO.getProductById(prID);
		ModelAndView mv=new ModelAndView("/EditProduct2","command", new Product() );
		mv.addObject("prFound", pr);
		log.debug("End of addproduct");
		return mv;
	}
	
	@RequestMapping(value="/EditProduct",  method = RequestMethod.POST)
	public ModelAndView editProductFunction(@ModelAttribute Product product,@RequestParam("prID") String pID)
	{
		product.setProductID(pID);
		productDAO.updateProduct(product);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Product Edited");
		return mv;
	}
	
	@RequestMapping("/selDeleteProduct")
	public ModelAndView deleteProductFunction()
	{
		ModelAndView mv=new ModelAndView("/DeleteProduct");
		return mv;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("pID") String prID)
	{
		productDAO.deleteProduct(prID);
		ModelAndView mv=new ModelAndView("/Admin");
		return mv;
	}
	
	@RequestMapping("/selViewProduct")
	public ModelAndView viewProduct(Map<String, Object> map)
	{
		String path="Resources/images/";
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		map.put("path", path);
		ModelAndView mv=new ModelAndView("/ViewProduct",map);
		return mv;
	}
	
	@RequestMapping("/clickProducts")
	public ModelAndView showProducts()
	{
		System.out.println("Inside Product view");
		List<Product> prList=productDAO.getAllProduct();
		String path="Resources/images/";
		ModelAndView mv=new ModelAndView("/Products");
		mv.addObject("prList", prList);
		mv.addObject("path",path);
		System.out.println("Leaving Product view");
		return mv;
	}



}
  