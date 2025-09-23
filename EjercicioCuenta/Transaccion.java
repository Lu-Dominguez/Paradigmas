package cuenta;
import java.math.BigDecimal;

public class Transaccion {
    private String motivo;
    private BigDecimal monto;

    public Transaccion(String motivo, BigDecimal monto) {
        this.motivo = motivo;
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return motivo + ": " + monto;
    }
}
