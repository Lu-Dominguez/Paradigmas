package rango;

//final es que su valor se asigna una sola vez y no puede cambiar desp de la inicializacion en el constructor
public class Rango {
	private final double r1;
	private final double r2;
	private final boolean l1;
	private final boolean l2;
	
	private Rango(double r1, double r2, boolean l1, boolean l2) {
		this.l1 = l1;
		this.l2 = l2;
		this.r1 = r1;
		this.r2 = r2;
	}
	//el metodo estatico indice q pertenece a la clase en si misma, no a los objetos. Se llama con el nombre de la clase.
	//en cambio, los metodos no estaticos se llaman a traves de un objeto creado previamente si o si.
	public static Rango cerrado(double r1, double r2) {
		return new Rango(r1, r2, false, false);
	}
	
	public static Rango abierto(double r1, double r2) {
		return new Rango(r1, r2, true, true);
	}
	public static Rango abiertoIzq(double r1, double r2) {
		return new Rango(r1, r2, true, false);
	}
	
	public static Rango abiertoDer(double r1, double r2) {
		return new Rango(r1, r2, false, true);
	}
	
	public boolean numeroEnRango(double n) {
		boolean rangoIzq = l1? n>= r1 : n> r1;
		boolean rangoDer = l2 ? n<= r2 : n < r2;
		return rangoIzq && rangoDer;
	}
	
	public boolean rangoEnRango(Rango otro) {
		boolean rangoIzq = this.l1 ? otro.r1 >= this.r1 : otro.r1 > this.r1; 
		boolean rangoDer = this.l2 ? otro.r2 <= this.r2 : otro.r2 < this.r2;
		return rangoIzq && rangoDer;
	}
	
	//(5, 12) y (3, 10) se intersectan en (3, 10)
	//(1, 4) (6, 9)
	public boolean hayInterseccion(Rango otro) {
		if(this.r2 < otro.r1 || this.r1 > otro.r2) {
			return false;
		}
		
		if(this.r2 == otro.r1) {
			return this.l2 && otro.l1; //solo si son abiertos cumple
		}
		
		if(this.r1 == otro.r2) {
			return this.l1 && otro.l2;
		}
		
		return true;
	}
	
	public boolean rangosIguales(Rango otro) {
		if(otro.l1 != this.l1 || otro.l2 != this.l2)
			return false;
		
		if(otro.r1 != this.r1 || otro.r2 != this.r2)
			return false;
		return true;
	}
	
	// -1 si this va antes que otro
	// 0 si son iguales
	// 1 si otro va antes que this
	public int ordenarRangos(Rango otro) {
		if(this.r1 == otro.r1) {
			if(this.r2 == otro.r2) {
				if(this.l1 != otro.l1) {
					return !this.l1 ? -1 : 1;
				}
				if(this.l2 != otro.l2) {
					return !this.l1 ? -1 : 1;
				}
				return 0;
			}
			return this.r2 > otro.r2 ? 1 : -1;
		}
		return this.r1 > otro.r1 ? 1 : -1;
	}
	
	public String imprimirString() {
		String izq = l1 ? "[" : "(";
		String der = l2 ? "]" : ")";
		return izq + r1 + " , " + r2 + der;
	}
	
	public static Rango abarcarRangos(Rango ran1, Rango ran2) {
	    double ra1 = ran1.r1 < ran2.r1 ? ran1.r1 : ran2.r1;
	    boolean la1;
	    if(ran1.r1 < ran2.r1) 
	    	la1 = ran1.l1;
	    else if(ran1.r1 > ran2.r1) 
	    	la1 = ran2.l1;
	    else
	    	la1 = ran1.l1 ? ran1.l1 : ran2.l1; // si son iguales, cierro con el q este abierto

	    double ra2 = ran1.r2 > ran2.r2 ? ran1.r2 : ran2.r2;
	    boolean la2;
	    if(ran1.r2 > ran2.r2) 
	    	la2 = ran1.l2;
	    else if(ran1.r2 < ran2.r2)
	    	la2 = ran2.l2;
	    else
	    	la2 = ran1.l2 ? ran1.l2 : ran2.l2;

	    return new Rango(ra1, ra2, la1, la2);
	}
	
	public Rango sumarRangos(Rango otro) {
		double ran1 = this.r1;
		boolean la1 = this.l1;
		
		double ran2 = otro.r2;
		boolean la2 = otro.l2;
		return new Rango(ran1, ran2, la1, la2);
	}
	public Rango devolverInterseccion(Rango otro) {
		if(!this.hayInterseccion(otro))
			return new Rango(0,0,false, false);
		
		double ranRes1;
		boolean laRes1;
		if(this.r1 == otro.r1) {
			laRes1 = !this.l1 ? this.l1 : otro.l1;
			ranRes1 = this.r1;
		}
		else {
			ranRes1 = this.r1 > otro.r1 ? this.r1 : otro.r1;
			laRes1 = this.r1 > otro.r1 ? this.l1 : otro.l1;
		}
		
		double ranRes2;
		boolean laRes2;
		if(this.r2 == otro.r2) {
			laRes2 = !this.l2 ? this.l2 : otro.l2;
			ranRes2 = this.r2;
		}
		else {
			ranRes2 = this.r2 < otro.r2 ? this.r2 : otro.r2;
			laRes2 = this.r2 < otro.r2 ? this.l2 : otro.l2;
		}
		
		return new Rango(ranRes1, ranRes2, laRes1, laRes2);
	}
	
	public Rango desplazar(int num) {
		double ran1 = num + this.r1;
		double ran2 = num + this.r2;
		
		return new Rango(ran1, ran2, this.l1, this.l2);
	}
}

