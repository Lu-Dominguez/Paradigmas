package cuenta;

import java.math.BigDecimal;

public class TarjetaDeCredito extends Tarjeta {
	private BigDecimal acumulado = BigDecimal.ZERO;

	public TarjetaDeCredito(Cuenta cuenta) {
		super(cuenta);
	}

	public void comprar(BigDecimal monto) {
		BigDecimal total = monto.multiply(BigDecimal.valueOf(1.03));
	    acumulado = acumulado.add(total);
	}

	@Override
	public boolean pagar(BigDecimal monto) {
		boolean resultado = cuentaAsociada.retirar(acumulado);
	    if(resultado)
	    	acumulado = BigDecimal.ZERO;
	    return resultado;
	}

}
