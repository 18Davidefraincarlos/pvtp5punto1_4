package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.modelos.ModeloProductos;
@Controller
public class ControllerProducto {
	 List<ModeloProductos> listprod=new ArrayList<ModeloProductos>();
	 ModeloProductos aux=null;//variable para buscar 
	  @GetMapping ("/index")
     
	    public String index() {
				
				 return "index"; //llamar al archivo html 
			 }
	 
	 //*********MOSTRAR PRODUCTOS*************
	 @GetMapping("/producto")
	 public String producto(Model modelo) {
		 modelo.addAttribute("producto",listprod);//PASO LA LISTA Y EL NOMBRE QUE VA TENER
		 return "producto"; 
	 }
	 
	
	//********* AGREGAR PRODUCTO ****************** 
	 @GetMapping("/addproducto")
	 public String addproducto(Model modelo) {
	 	 
	 	ModeloProductos prod = new ModeloProductos();//crear un nuevo objeto
	 	modelo.addAttribute("producto",prod);//pasar a html producto de prod 
	 	return "addproducto";//html cargar producto 
	  }	
	//*************GUARDAR PRODUCTO********************
	 @PostMapping("/saveproducto")
		 public String saveproducto(@ModelAttribute ModeloProductos producto){
    	  
    	  aux=buscar(producto.getId_producto()); //si un objeto existe  id  no hace nada  
    	     if(aux==null) {
    	    	 listprod.add(producto);
    	     }else {//cuando existe un valor   esto para editar
    	 		int pos=listprod.indexOf(aux);
    			listprod.set(pos, producto);
    		}
    	  return "redirect:/producto";//volver a html producto
      }
	//********* EDITAR PRODUCTO ******************
	 @GetMapping("/edit/{id_producto}")
	 public String editproducto(@PathVariable("id_producto") int id_producto, Model modelo) {
	 	 ModeloProductos pro = buscar(id_producto);
	 	 modelo.addAttribute("producto",pro);
	 	 
	 	 return "addproducto";
	  }
	//********* ELIMINAR PRODUCTO ******************
	 @GetMapping("/del/{id_producto}")
	 public String delproducto(@PathVariable("id_producto") int id_producto, Model modelo) {
	 	 
	 	 ModeloProductos pro = buscar(id_producto);
	 	 listprod.remove(pro);
	 	 modelo.addAttribute("producto",listprod);
	 	 
	 	 return "redirect:/producto";
	 }
    //metodo busca si hay registro
	private ModeloProductos buscar(int id_producto) {
		// TODO Auto-generated method stub
		ModeloProductos aux=null;
		for (ModeloProductos prod: listprod) {
			if(id_producto==prod.getId_producto()) {
				aux=prod;
			}
		}
		return aux;
	}
  
}
    
