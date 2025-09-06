package circulo;

public class Circulo {
	private double radio;


	public Circulo(double radio) {

	this.radio = radio;

	}


	public double getRadio() {

	return radio;

	}


	public String mostrar() {

	return "El radio es: " + radio;

	}


	public double getArea() {

	return Math.PI *radio *radio;

	}


	public double getPerimetro() {

	return 2* Math.PI * radio;

	}


	/*public void aumentar(int aum) {

	this.radio *= aum;

	}*/

	public Circulo aumentar2(double aum) {

	return new Circulo(this.radio*aum);

	}


	public Circulo sumarInmutable(Circulo otro) {

	return new Circulo(Math.sqrt(this.getArea() + otro.getArea()) / Math.PI);

	}

}
