package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.modelos.ModeloVenta;
@Controller
public class ControllerVenta {
	 List<ModeloVenta> listventas=new ArrayList<ModeloVenta>();
	 ModeloVenta aux=null;//variable para buscar 
	 
	 //*********MOSTRAR VENTAS*************
	 @GetMapping("/ventas")
	 public String venta(Model modelo) {
		 modelo.addAttribute("venta",listventas);//PASO LA LISTA Y EL NOMBRE QUE VA TENER
		 return "ventas"; 
	 }
	 
	//********* AGREGAR VENTA ****************** 
	 @GetMapping("/addventa")
	 public String addventa(Model modelo) {
	 	 
	 	ModeloVenta vent = new ModeloVenta();//crear un nuevo objeto
	 	modelo.addAttribute("venta",vent);//pasar a html venta de vent 
	 	return "addventa";//html cargar producto 
	  }	
	//*************GUARDAR VENTAS********************
	 @PostMapping("/saveventa")
		 public String saveventa(@ModelAttribute ModeloVenta venta){
    	  aux=buscarventa(venta.getId_venta()); //si un objeto existe  id  no hace nada  
    	     if(aux==null) {
    	    	 listventas.add(venta);
    	     }else {//cuando existe un valor   esto para editar
    	 		int pos=listventas.indexOf(aux);
    			listventas.set(pos, venta);
    		}
    	  return "redirect:/ventas";//volver a html venta
      }
	//********* EDITAR VENTAS ******************
	 @GetMapping("/editventa/{id_venta}")
	 public String editventa(@PathVariable("id_venta") int id_venta, Model modelo) {
	 	 ModeloVenta vent = buscarventa(id_venta);
	 	 modelo.addAttribute("venta",vent);
	 	 
	 	 return "addventa";
	  }
	//********* ELIMINAR VENTAS ******************
	 @GetMapping("/delventa/{id_venta}")
	 public String delproducto(@PathVariable("id_venta") int id_venta, Model modelo) {
	 	  ModeloVenta vent = buscarventa(id_venta);
	 	 listventas.remove(vent);
	 	 modelo.addAttribute("venta",listventas);
	 	 
	 	 return "redirect:/ventas";
	 }
    //metodo busca si hay registro
	private ModeloVenta buscarventa(int id_venta) {
		// TODO Auto-generated method stub
		ModeloVenta aux=null;
		for (ModeloVenta vent: listventas) {
			if(id_venta== vent.getId_venta()) {
				aux=vent;
			}
		}
		return aux;
	}
  
}
    
