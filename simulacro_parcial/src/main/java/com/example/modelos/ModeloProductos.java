package com.example.modelos;

public class ModeloProductos {
     int id_producto;
     String descripcion;
     int PU;
	public ModeloProductos(int id_producto, String descripcion, int PU) {
		super();
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.PU = PU;
	}
	//CONTRUCTOR VACIO CARGA UNA LISTA VACIA PARA PASARLO A HTML 
	public ModeloProductos() {
		
	}

	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPU() {
		return PU;
	}
	public void setPU(int pU) {
		PU = pU;
	}
     
}
