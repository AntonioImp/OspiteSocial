package Classes;

import java.sql.Date;
import javax.swing.JOptionPane;

public class Periodo {
    private Date dataInizio;
    private Date dataFine;

    public Periodo(Date dataInizio, Date dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }
    
    public boolean confrontaPeriodo(Date inizio,Date fine){
        if( (inizio.after(dataInizio) || inizio.toString().compareTo(dataInizio.toString())==0) && (fine.before(dataFine) || fine.toString().compareTo(dataFine.toString())==0)){
           return true;
        }else{
           return false;
        }
           
    }

    public Date getDataInizio() {
        return dataInizio;
    }

   
    public Date getDataFine() {
        return dataFine;
    }
    
    public void setDataInizio(Date inizio) {
        this.dataInizio=inizio;
    }

   
    public void setDataFine(Date fine) {
        this.dataFine=fine;
    }
    

    @Override
    public String toString() {
        return "Periodo{" + "dataInizio=" + dataInizio + ", dataFine=" + dataFine +'}';
    }
}
