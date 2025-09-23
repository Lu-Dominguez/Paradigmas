package cuenta;

import java.math.BigDecimal;

public class CuentaDeAhorros extends Cuenta {
	BigDecimal saldoSecundario = BigDecimal.ZERO;
	
	public boolean depositarSaldoSecundario(BigDecimal monto) {
		if(monto.compareTo(BigDecimal.ZERO) <= 0 || monto.compareTo(super.saldo) > 0)
			return false;
		
		super.saldo = super.saldo.subtract(monto);
		this.saldoSecundario = this.saldoSecundario.add(monto);
		this.registrarTransaccion("Deposito Secundario", monto);
		return true;
	}
	
	@Override
	public boolean retirar(BigDecimal monto) {

	    if(monto.compareTo(BigDecimal.ZERO) <= 0 || monto.compareTo(saldo) > 0) 
	    	return false;
	    
	    saldo = saldo.subtract(monto);
	    this.registrarTransaccion("Retiro", monto);
	    return true;
	}

	
	public void reintegrarSaldoSecundario() {
		super.saldo = super.saldo.add(saldoSecundario);
		this.registrarTransaccion("Reintegro", saldoSecundario);
	}
}
