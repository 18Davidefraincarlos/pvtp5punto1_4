package com.example.modelos;

public class ModeloVenta {
         int id_venta;
         String fecha;
         String vendedor;
         int id_producto;
	
		public ModeloVenta(int id, String fecha, String vendedor, int id_producto) {
			super();
			this.id_venta = id;
			this.fecha = fecha;
			this.vendedor = vendedor;
			this.id_producto = id_producto;
		}
		//CONTRUCTOR VACIO CARGA UNA LISTA VACIA PARA PASARLO A HTML 
		public ModeloVenta() {
			
		}

		public int getId_venta() {
			return id_venta;
		}

		public void setId_venta(int id) {
			this.id_venta = id;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getVendedor() {
			return vendedor;
		}

		public void setVendedor(String vendedor) {
			this.vendedor = vendedor;
		}

		public int getId_producto() {
			return id_producto;
		}

		public void setId_producto(int id_producto) {
			this.id_producto = id_producto;
		}
		
	
         
}
