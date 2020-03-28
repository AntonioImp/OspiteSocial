
package Classes;

import java.util.ArrayList;
import java.util.List;

public class Utente {
     private String cf;
     private String nome;
     private String cognome;
     private String citta;
     private char sesso;
     private Integer eta;
     private String cellulare;
     private String password;
     private long credito;
     private List<Abitazione> abitazioni;


    public Utente(String cf, String nome, String cognome, String citta, char sesso,Integer eta, String cellulare,String password) {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
        this.sesso = sesso;
        this.eta = eta;
        this.cellulare = cellulare;
        this.password = password;
        this.credito = 20;
        abitazioni = new ArrayList();
    }

    public Abitazione inserimentoAlloggio(String indirizzo, Double ditanzaCentro, Double distanzaStazione, String citta){
            Abitazione abitazione; 
                if(indirizzo.isEmpty() || ditanzaCentro<0 || distanzaStazione<0){
                    return null;
                }
                for(int i=0;i<abitazioni.size();i++){
                    if(abitazioni.get(i).getIndirizzo().compareTo(indirizzo)==0){
                        return null;
                    }
                }
        abitazione=new Abitazione(indirizzo,ditanzaCentro,distanzaStazione,citta);
        this.abitazioni.add(abitazione);
        return abitazione;
    }
    
    public boolean modificaDatiAlloggio(String indirizzo, Double ditanzaCentro, Double distanzaStazione){
            for(int i=0;i<abitazioni.size();i++){
                if(abitazioni.get(i).getIndirizzo().compareTo(indirizzo)==0){
                    abitazioni.get(i).setDitanzaCentro(ditanzaCentro);
                    abitazioni.get(i).setDistanzaStazione(distanzaStazione);
                    return true;
                }
            }
        return false;
    }
    
    public boolean eliminaAlloggio(String indirizzo){
            for(int i=0;i<abitazioni.size();i++){
                if(abitazioni.get(i).getIndirizzo().compareTo(indirizzo)==0){
                    abitazioni.remove(i);
                    return true;
                }
            }
        return false;
    }
   
    public Abitazione visualizzaAlloggio(String indirizzo){
            for(int i=0;i<abitazioni.size();i++){
                if(abitazioni.get(i).getIndirizzo().compareTo(indirizzo)==0){
                    return abitazioni.get(i);
                }
            }
        return null;
    }

    public Integer getEta() {
        return eta;
    }

    public String getPassword() {
        return password;
    }

    public String getCf() {
        return cf;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCitta() {
        return citta;
    }

    public char getSesso() {
        return sesso;
    }

    public String getCellulare() {
        return cellulare;
    }

    public long getCredito() {
        return credito;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public void setCredito(long credito) {
        this.credito = credito;
    }
     
    public void setPassword(String password) {
        this.password = password;
    }
     
    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public List<Abitazione> getAbitazioni() {
        return abitazioni;
    }
    
 
}
