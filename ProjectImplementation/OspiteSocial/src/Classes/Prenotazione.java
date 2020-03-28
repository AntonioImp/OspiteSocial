package Classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Prenotazione {
    private Date dataInizio;
    private Date dataFine;
    private Utente ospitante;
    private String stato;
    private Abitazione abitazione;
    private List<Utente> ospiti;
    private List<Stanza> stanze;
    private String motivazione;
    private Date checkIn;
    private Date checkOut;

    public Prenotazione(Date dataInizio, Date dataFine, Utente ospitante, Abitazione abitazione, List<Utente> ospiti, List<Stanza> stanze) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.ospitante = ospitante;
        this.abitazione = abitazione;
        this.ospiti = ospiti;
        this.stanze = stanze;
        this.motivazione="";
        checkIn=null;
        checkOut=null;
        this.stato="Da confermare";
    }

    
    
    public Integer controlloPostiLetto(Integer posti,Date inizio,Date fine){
        Integer postiLetto=0;
        if( (inizio.after(dataInizio) && inizio.before(dataFine) || inizio.compareTo(dataInizio)==0) || (fine.after(dataInizio) && fine.before(dataFine) || fine.compareTo(dataFine)==0)){
                for(int i=0;i<stanze.size();i++)postiLetto+=stanze.get(i).getNumeroPostiLetto();
            return posti-postiLetto;
        }
        return posti;
    }
    
    public boolean controlloPeriodo(Date inizio,Date fine){
        if( (inizio.after(dataInizio) && inizio.before(dataFine) || inizio.compareTo(dataInizio)==0) || (fine.after(dataInizio) && fine.before(dataFine) || fine.compareTo(dataFine)==0)){
            return true;
        }
        return false;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public Utente getOspitante() {
        return ospitante;
    }

    public String getStato() {
        return stato;
    }

    public Abitazione getAbitazione() {
        return abitazione;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    
    public List<Stanza> getStanze() {
        return this.stanze;
    }
    
    public List<Utente> getOspiti() {
        return this.ospiti;
    }
   
    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public String getMotivazione() {
        return motivazione;
    }
    

    @Override
    public String toString() {
        return "Prenotazione{" + ", ospitante=" + ospitante.getCf() + ", stato=" + stato + ", abitazione=" + abitazione + ", ospiti=" + ospiti + ", stanze=" + stanze + '}';
    }

   
    
}
