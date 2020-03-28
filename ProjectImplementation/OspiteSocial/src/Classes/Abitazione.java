
package Classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Abitazione {
    private String indirizzo;
    private Double ditanzaCentro;
    private Double distanzaStazione;
    private String citta;
    private Integer numeroPostiLetto;
    private Integer tariffaGiornaliera;
    private List<Periodo> calendario;
    private List<Stanza> stanze;

    public Abitazione(String indirizzo, Double ditanzaCentro, Double distanzaStazione, String citta) {
        this.indirizzo = indirizzo;
        this.ditanzaCentro = ditanzaCentro;
        this.distanzaStazione = distanzaStazione;
        this.citta=citta;
        this.numeroPostiLetto=0;
        this.tariffaGiornaliera=5;
        stanze = new ArrayList();
        calendario = new ArrayList();
    }
    
    public boolean inserimentoPeriodo(Date inizio,Date fine){
         Periodo periodo; 
                for(int i=0;i<calendario.size();i++){
                    if(!inizio.before(fine)  || (inizio.after(calendario.get(i).getDataInizio())  && inizio.before(calendario.get(i).getDataFine()) || inizio.compareTo(calendario.get(i).getDataInizio())==0) || (fine.after(calendario.get(i).getDataInizio()) && fine.before(calendario.get(i).getDataFine()) || fine.compareTo(calendario.get(i).getDataFine())==0) ){
                        return false;
                    }
                }
        periodo=new Periodo(inizio,fine);
        calendario.add(periodo);
        return true;
    }
    
    public Periodo visualizzaPeriodo(Integer indicePeriodo){ 
            if(indicePeriodo>=calendario.size())return null;
        return calendario.get(indicePeriodo);
    }
    
    public boolean modificaPeriodo(Integer indicePeriodo,Date inizio,Date fine){
            for(int i=0;i<calendario.size();i++){
                if(indicePeriodo!=i)
                if(!inizio.before(fine)  || (inizio.after(calendario.get(i).getDataInizio()) && inizio.before(calendario.get(i).getDataFine())) || (fine.after(calendario.get(i).getDataInizio()) && fine.before(calendario.get(i).getDataFine())) ){
                    return false;
                }
            }
        calendario.get(indicePeriodo).setDataInizio(inizio);
        calendario.get(indicePeriodo).setDataFine(fine);
        return true;
    }

    public void setStanza(List<Stanza> stanze) {
        this.stanze = stanze;
    }
     
    public boolean eliminaPeriodo(int indicePeriodo){
            if(indicePeriodo>=calendario.size())return false;
        calendario.remove(indicePeriodo);
        return true;
    }
    
    public boolean inserimentoDatiStanza(Integer numeroStanza,String tipologiaStanza,String tipologiaPostoLetto,Integer numeroPostiLetto){
        Stanza stanza; 
            if( tipologiaStanza.isEmpty() || tipologiaPostoLetto.isEmpty() || numeroPostiLetto==0){
                return false;
            }
            for(int i=0;i<stanze.size();i++){
                if(stanze.get(i).getNumeroStanza().compareTo(numeroStanza)==0){
                    return false;
                }
            }
            if(numeroPostiLetto>2)return false;
        stanza=new Stanza(tipologiaStanza,tipologiaPostoLetto,numeroPostiLetto,numeroStanza);
        stanze.add(stanza);
        this.aggiornaNumeroPostiLetto(numeroPostiLetto);
        return true;
    }
    
    public boolean modificaDatiStanza(Integer numeroStanza,String tipologiaStanza,String tipologiaPostoLetto,Integer numeroPostiLetto){ 
            if( tipologiaStanza.isEmpty() || tipologiaPostoLetto.isEmpty() || numeroPostiLetto==0){
                return false;
            }
             for(int i=0;i<stanze.size();i++){
                if(stanze.get(i).getNumeroStanza().compareTo(numeroStanza)==0){
                     stanze.get(i).setNumeroPostiLetto(numeroPostiLetto);
                     stanze.get(i).setTipologiaPostoLetto(tipologiaPostoLetto);
                     stanze.get(i).setTipologiaStanza(tipologiaStanza);
                     return true;
                }
            }
        return false;
    }
    
    public Stanza visualizzaStanza(Integer numeroStanza){ 
         for(int i=0;i<stanze.size();i++){
                if(stanze.get(i).getNumeroStanza().intValue()==numeroStanza.intValue()){
                    return stanze.get(i);
                }
            }
        return null;
    }
    
    public boolean eliminaStanza(Integer numeroStanza){
            for(int i=0;i<stanze.size();i++){
                if(stanze.get(i).getNumeroStanza().compareTo(numeroStanza)==0){
                     this.numeroPostiLetto-=stanze.get(i).getNumeroPostiLetto();
                     stanze.remove(i);
                     return true;
                }
            }
        return false;
    }
    
    public boolean verificaDisponibilita(Date inizio,Date fine){
            for(int i=0;i<calendario.size();i++){
                if(calendario.get(i).confrontaPeriodo(inizio,fine)==true)
                    return true;
            }
        return false;
    }
    
    private boolean aggiornaNumeroPostiLetto(Integer numero){
        this.numeroPostiLetto+=numero;
        return true;
    }
    
    public Integer getNumeroPostiLetto() {
        return numeroPostiLetto;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Double getDitanzaCentro() {
        return ditanzaCentro;
    }

    public void setDitanzaCentro(Double ditanzaCentro) {
        this.ditanzaCentro = ditanzaCentro;
    }

    public Double getDistanzaStazione() {
        return distanzaStazione;
    }

    public void setDistanzaStazione(Double distanzaStazione) {
        this.distanzaStazione = distanzaStazione;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Stanza> getStanze() {
        return stanze;
    }

    public List<Periodo> getCalendario() {
        return calendario;
    }
    
    public Integer getTariffaGiornaliera() {
        return tariffaGiornaliera;
    }
    
    @Override
    public String toString() {
        return "Abitazione{" + "indirizzo=" + indirizzo + ", ditanzaCentro=" + ditanzaCentro + ", distanzaStazione=" + distanzaStazione + ", citta=" + citta + ", numeroPostiLetto=" + numeroPostiLetto +'}';  
    }

  
    
}
