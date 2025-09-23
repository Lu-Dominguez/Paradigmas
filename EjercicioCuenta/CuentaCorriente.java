package cuenta;

import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta {
	private BigDecimal montoDescubierto;
	
	public CuentaCorriente(BigDecimal montoDescubierto) {
		if(montoDescubierto.compareTo(BigDecimal.ZERO) < 0)
		    throw new IllegalArgumentException("El monto de descubierto no puede ser negativo.");
		this.montoDescubierto = montoDescubierto;

	}
	
    @Override
    public boolean retirar(BigDecimal monto) {
        if(monto.compareTo(BigDecimal.ZERO) <= 0)
        	return false;

        //uso el saldo q hay
        if (saldo.compareTo(monto) >= 0) {
            saldo = saldo.subtract(monto);
            return true;
        }

        //si no m alcanza con el saldo, uso el descubierto
        BigDecimal faltante = monto.subtract(saldo);
        if (faltante.compareTo(montoDescubierto) > 0) {
            return false;
        }

        saldo = BigDecimal.ZERO;
        montoDescubierto = montoDescubierto.subtract(faltante);
        this.registrarTransaccion("Retiro", monto);
        return true;
    }

}
