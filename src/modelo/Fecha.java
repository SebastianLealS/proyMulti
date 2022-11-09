
package modelo;
import java.util.Calendar;
/**
 *
 * @author Sebastian Leal S
 */
public class Fecha {
    private int dd, mm, aa;

    public Fecha(int dd, int mm, int aa) {
        this.dd = dd;
        this.mm = mm;
        this.aa = aa;
    }
    public Fecha() {
        Calendar fechaSist = Calendar.getInstance();
        this.dd = fechaSist.get(Calendar.DAY_OF_MONTH);
        this.mm = (fechaSist.get(Calendar.MONTH) + 1);
        this.aa = fechaSist.get(Calendar.YEAR);
    }

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return dd + "/" + mm + "/" + aa;
    }
    
}
