package cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Cuenta {
	protected BigDecimal saldo = BigDecimal.ZERO;
	protected List<Transaccion> transacciones = new ArrayList<>();
	
	public Cuenta() {
		
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	
	protected void registrarTransaccion(String motivo, BigDecimal monto) {
	    transacciones.add(new Transaccion(motivo, monto));
	}
	
	public boolean depositar(BigDecimal monto) {
		if(monto.compareTo(BigDecimal.ZERO) <= 0)
			return false;
		
		this.saldo = this.saldo.add(monto);
		this.registrarTransaccion("Deposito", monto);
		return true;
	}
	
	public abstract boolean retirar(BigDecimal monto);
	
	public boolean transferirA(Cuenta otro, BigDecimal monto) {
		if(this.retirar(monto)) {
			otro.depositar(monto);
			this.registrarTransaccion("Transferencia", monto);
			return true;
		}
		return false;
	}
}
