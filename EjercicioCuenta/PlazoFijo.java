package cuenta;

import java.math.BigDecimal;

public class PlazoFijo {
    private BigDecimal montoFijo;
    private Cuenta cuentaAsociada;
    private double interesMensual = 0.03; //36% anual aprox 3% mensual

    public PlazoFijo(Cuenta cuenta, BigDecimal monto) {
        this.cuentaAsociada = cuenta;
        this.montoFijo = monto;
        cuenta.retirar(monto); //pone el monto en plazo fijo
    }

    public void acreditar() {
        BigDecimal montoConInteres = montoFijo.multiply(BigDecimal.valueOf(1 + interesMensual));
        cuentaAsociada.depositar(montoConInteres);
    }

}
