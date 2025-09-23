package cuenta;

import java.math.BigDecimal;

public abstract class Tarjeta {
    protected Cuenta cuentaAsociada;

    public Tarjeta(Cuenta cuenta) {
        this.cuentaAsociada = cuenta;
    }

    public abstract boolean pagar(BigDecimal monto);

}
