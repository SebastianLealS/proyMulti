package modelo;

import java.util.Calendar;

/**
 *
 * @author Sebastian Leal S
 */
public class Hora {
    private int hh, mm, ss;

    public Hora(int hh, int mm, int ss) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
    }
    
    public Hora() {
        Calendar horaSist = Calendar.getInstance();
        this.hh = horaSist.get(Calendar.HOUR_OF_DAY);
        this.mm = horaSist.get(Calendar.MINUTE);
        this.ss = horaSist.get(Calendar.SECOND);
    }

    @Override
    public String toString() {
        return hh + ":" + mm + ":" + ss;
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }
    
    
}
