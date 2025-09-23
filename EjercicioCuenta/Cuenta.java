package cuenta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    protected BigDecimal saldo = BigDecimal.ZERO;
    protected List<Transaccion> transacciones = new ArrayList<>();
	
    public Cuenta() { }

    public BigDecimal getSaldo() {
        return saldo;
    }
	
    protected void registrarTransaccion(String motivo, BigDecimal monto) {
        transacciones.add(new Transaccion(motivo, monto));
    }
	
    public boolean depositar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0)
            return false;
		
        this.saldo = this.saldo.add(monto);
        this.registrarTransaccion("Depósito", monto);
        return true;
    }
	
    public boolean retirar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0)
            return false;

        if (this.saldo.compareTo(monto) >= 0) {
            this.saldo = this.saldo.subtract(monto);
            this.registrarTransaccion("Retiro", monto.negate());
            return true;
        }
        return false;
    }
	
    public boolean transferirA(Cuenta otro, BigDecimal monto) {
        if (this.retirar(monto)) {
            otro.depositar(monto);
            this.registrarTransaccion("Transferencia", monto.negate());
            return true;
        }
        return false;
    }
}
