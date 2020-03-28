package Classes;

import java.time.temporal.ChronoUnit;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OspiteSocial {
    private static OspiteSocial instance;
    private Utente utente;
    private List<Utente> utenti;
    private List<Prenotazione> prenotazioni;

    private OspiteSocial() {
        utenti=new ArrayList();
        prenotazioni=new ArrayList();
        utente=null;
        
        //VALORI DI SUPPORTO PER EVITARE DEGLI INSERIMENTI, DA COMMENTARE PER USARE I TEST!
        this.iserisciUtente("GRM", "Kristian", "Di Blasi","Floridia",'M',23,"3233333","KRI");
        this.iserisciUtente("DBLKS", "Kristian", "Di Blasi","Floridia",'M',23,"3233333","KRI");
        this.iserisciUtente("ANTO", "Kristian", "Di Blasi","Floridia",'M',23,"3233333","KRI");
        
        Abitazione abitazione = utenti.get(0).inserimentoAlloggio("Via SR", 1.0, 1.0, "Siracusa");
        abitazione.inserimentoDatiStanza(1,"doppia", "privata", 2);
        abitazione.inserimentoDatiStanza(2,"singola", "privata", 1);
        abitazione.inserimentoPeriodo(Date.valueOf("2020-03-1"),Date.valueOf("2020-03-28"));
        
        abitazione = utenti.get(0).inserimentoAlloggio("Via Flo", 1.0, 1.0, "Siracusa");
        abitazione.inserimentoDatiStanza(1,"doppia", "privata", 2);
        abitazione.inserimentoDatiStanza(2,"singola", "privata", 1);
        abitazione.inserimentoPeriodo(Date.valueOf("2020-03-1"),Date.valueOf("2020-03-28"));
        
        List<Abitazione> abitazioni;
        List<String> ospiti=new ArrayList();
        
        this.logIn("ANTO","KRI");
        
        ospiti.add("DBLKS");
        ospiti.add("ANTO");
        
       // abitazioni=this.ricercaAlloggio("Siracusa",2,Date.valueOf("2020-03-1"),Date.valueOf("2020-03-8"));
     //   this.richiestaPrenotazione(abitazioni.get(0).getStanze(),ospiti,Date.valueOf("2020-03-1"),Date.valueOf("2020-03-8"),abitazioni.get(0));
        
    }
    
    public static OspiteSocial getInstance() {
            if ( instance == null ){
                System.err.println("Istanza creata");
                instance = new OspiteSocial();
            }
        return instance;
    }
    
    public Utente iserisciUtente(String cf,String nome,String cognome,String citta,char sesso,Integer eta,String cellulare,String password){
        Utente utente; 
            if( cf.isEmpty() || nome.isEmpty() || cognome.isEmpty() || citta.isEmpty() || cellulare.isEmpty() || password.isEmpty() || (sesso!='M' && sesso!='F') || eta<=0 ){
                return null;
            }
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getCf().compareTo(cf)==0){
                    return null;
                }
            }
        utente=new Utente(cf,nome,cognome,citta,sesso,eta,cellulare,password);
        utenti.add(utente);
        return utente;
    }
    
    public boolean modificaDatiUtente(String cf,String nome,String cognome,String citta,char sesso,Integer eta,String cellulare,String password){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getCf().compareTo(cf)==0){
                    utenti.get(i).setNome(nome);
                    utenti.get(i).setCognome(cognome);
                    utenti.get(i).setCitta(citta);
                    utenti.get(i).setSesso(sesso);
                    utenti.get(i).setEta(eta);
                    utenti.get(i).setCellulare(cellulare);
                    utenti.get(i).setPassword(password);
                    this.utente=utenti.get(i);
                    return true;
                }
            }
        return false;
    }
    
    public Utente vissualizzaInformazioniUtente(String cf){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getCf().compareTo(cf)==0){
                    return utenti.get(i);
                }
            }
        return null;
    }
    
    public boolean logIn(String cf,String password){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getCf().compareTo(cf)==0 && utenti.get(i).getPassword().compareTo(password)==0){
                    this.utente=utenti.get(i);
                    return true;
                }
            }
        return false;
    }
    
    public boolean eliminaUtente(String cf){
            for(int i=0;i<utenti.size();i++){
                if(utenti.get(i).getCf().compareTo(cf)==0){
                    utenti.remove(i);
                    utente=null;
                    return true;
                }
            }
        return false;
    }
    
    public String cfLoggato(){
        return this.utente.getCf();
    }
    
    
    public List<Abitazione> ricercaAlloggio(String citta,Integer numeroPostiLetto,Date dataInizioSoggiorno,Date dataFineSoggiorno){
        List<Abitazione> abitazioni=new ArrayList();
        Abitazione abitazioneTmp;
        Integer posti;
       
        List<Integer> indici=new ArrayList();
        List<Abitazione> abitazioniNew=new ArrayList();
        
        
            for(int z=0;z<utenti.size();z++){        
                List<Abitazione> listaAbitazioniTmp=utenti.get(z).getAbitazioni();
                    for(int j=0;j<listaAbitazioniTmp.size();j++){
                        abitazioni.add(listaAbitazioniTmp.get(j));
                           for(int i=0;i<listaAbitazioniTmp.get(j).getStanze().size();i++){
                                listaAbitazioniTmp.get(j).getStanze().get(i).setVisibilita(true);
                            }
                    }
            }
            
          
            for(int i=0;i<abitazioni.size();i++){
                abitazioneTmp=abitazioni.get(i);
                    if( abitazioneTmp.getCitta().compareTo(citta)==0 && utente.getAbitazioni().contains(abitazioneTmp)==false){
                         
                        if(abitazioneTmp.verificaDisponibilita(dataInizioSoggiorno,dataFineSoggiorno)){
                            posti=abitazioneTmp.getNumeroPostiLetto();
                               for(int j=0;j<prenotazioni.size();j++){
                                    Prenotazione prenotazione=prenotazioni.get(j);
                                        if(prenotazione.getStato().compareTo("Confermata")==0 || prenotazione.getStato().compareTo("In corso")==0 || prenotazione.getStato().compareTo("Da confermare")==0){
                                            if( prenotazione.getAbitazione().equals(abitazioneTmp) ){
                                                Integer postiPrec=posti;
                                                posti=prenotazione.controlloPostiLetto(posti,dataInizioSoggiorno,dataFineSoggiorno);
                                                List<Stanza> stanzePrenotate=prenotazione.getStanze();
                                                    if(prenotazione.controlloPeriodo(dataInizioSoggiorno,dataFineSoggiorno)==true){
                                                        for(int k=0;k<stanzePrenotate.size();k++){
                                                                for(int l=0;l<abitazioni.get(i).getStanze().size();l++){
                                                                       if(abitazioni.get(i).getStanze().get(l).getNumeroStanza().intValue()==stanzePrenotate.get(k).getNumeroStanza().intValue() && abitazioni.get(i).getIndirizzo().compareTo(prenotazione.getAbitazione().getIndirizzo())==0){
                                                                           abitazioni.get(i).getStanze().get(l).setVisibilita(false);
                                                                        }
                                                                }
                                                        }
                                                    }
                                            }
                                        }
                               }
                             
                            if(posti<numeroPostiLetto){
                                indici.add(i);
                            }
                        }else indici.add(i);
                    }else indici.add(i);
                    
            }
           
            for(Integer z=0;z<abitazioni.size();z++){
                if(!indici.contains(z))
                abitazioniNew.add(abitazioni.get(z));
            }
            
        return abitazioniNew;
    }
    
    public boolean richiestaPrenotazione(List<Stanza> stanze,List<String> ospiti,Date dataArrivo,Date dataPartenza,Abitazione abitazione){
        Utente utenteTmp=null;
        Utente ospitante=null;
        List<Utente> listaOspiti=new ArrayList();
        boolean presente=false;
        
        
        
            //Dati non nulli e data coerente
            if(ospiti.isEmpty() || stanze.isEmpty() || dataArrivo.after(dataPartenza))return false;
            //controlla se esiste l'abitazione correlata a quell'ospitante
            for(int i=0;i<utenti.size();i++){
                utenteTmp=utenti.get(i);
                
                    if(utenteTmp.getAbitazioni().contains(abitazione)==true)
                          ospitante=utenteTmp;
            }
            if(ospitante==null)return false;
            
            
            //controllo se il numero di ospitanti coincide con la reale disponibilità di posti letto nell'abitazione
            Integer posti=0;
            for(int i=0;i<stanze.size();i++){
                posti+=stanze.get(i).getNumeroPostiLetto();
            }
            if( ! (posti==ospiti.size() || posti==(ospiti.size()+1))  )return false;
            
            //cotrollo se gli utenti inseriti sono registrati sulla piattaforma
            for(int i=0;i<ospiti.size();i++){
                    for(int j=0;j<utenti.size();j++){
                        if(utenti.get(j).getCf().compareTo(ospiti.get(i))==0){
                            listaOspiti.add(utenti.get(j));
                            if(utenti.get(j).getCf().compareTo(this.cfLoggato())==0){
                                presente=true;
                                    //crediti insufficienti
                                    if(utenti.get(j).getCredito()<=0)return false;
                            }
                            //non si può indicare l'ospitante fra gli ospiti
                            if(ospitante.getCf().compareTo(utenti.get(j).getCf())==0)return false;
                        }
                    }
            } 
            if(listaOspiti.size()!=ospiti.size())return false;
            
            //deve esistere fra gli sopiti l'utente loggato
            if(presente==false)return false;
            
        //Prenotazione
        Prenotazione prenotazione;
        prenotazione=new Prenotazione(dataArrivo,dataPartenza,ospitante,abitazione,listaOspiti,stanze);
        prenotazioni.add(prenotazione);
        
       
        return true;
    }
    
    public List<Prenotazione> visualizzaRichieste(){
        List<Prenotazione> prenotazioniNew=new ArrayList();
       
        Prenotazione prenotazione;
            for(int i=0;i<prenotazioni.size();i++){
                prenotazione=prenotazioni.get(i);
                    if(prenotazione.getOspitante().getCf().compareTo(this.cfLoggato())==0){
                        prenotazioniNew.add(prenotazione);
                    }
            }
        return prenotazioniNew;
    }
    
    public List<Prenotazione> storicoPrenotazioni(){
        List<Prenotazione> prenotazioniNew=new ArrayList();
       
        Prenotazione prenotazione;
            for(int i=0;i<prenotazioni.size();i++){
                prenotazione=prenotazioni.get(i);
                    if(prenotazione.getOspiti().contains(this.utente)==true){
                        prenotazioniNew.add(prenotazione);
                    }
            }
        return prenotazioniNew;
    }
    
    public boolean accettaRichiesta(Prenotazione prenotazione){
           if(prenotazione.getOspitante().getCf().compareTo(this.cfLoggato())!=0)return false;
           if(prenotazione.getStato().compareTo("Da confermare")!=0)return false;
        prenotazione.setStato("Confermata");
        return true;
    }
    
    public boolean rifiutaRichiesta(Prenotazione prenotazione,String motivazione){
           if(prenotazione.getOspitante().getCf().compareTo(this.cfLoggato())!=0)return false;
           if(prenotazione.getStato().compareTo("Da confermare")!=0)return false;
        prenotazione.setStato("Rifiutata");
        prenotazione.setMotivazione(motivazione);
        return true;
    }
    
    public void calcolaCrediti(Prenotazione prenotazione){
        long credito=0;
        List<Utente> ospiti=prenotazione.getOspiti();
        credito=prenotazione.getAbitazione().getTariffaGiornaliera().intValue()*ChronoUnit.DAYS.between(prenotazione.getCheckIn().toLocalDate(),prenotazione.getCheckOut().toLocalDate());          
            for(int i=0;i<utenti.size();i++){       
                    for(int j=0;j<ospiti.size();j++){
                        if(utenti.get(i).getCf().compareTo(ospiti.get(j).getCf())==0){
                                utenti.get(i).setCredito(utenti.get(i).getCredito()-credito);
                            }
                    }
            }
        prenotazione.getOspitante().setCredito(prenotazione.getOspitante().getCredito()+(credito*ospiti.size()));
    }

    public Utente getUtente() {
        return utente;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
    
    public boolean checkIn(Prenotazione prenotazione){
            if(prenotazione==null)return false;
        prenotazione.setStato("In corso");
        prenotazione.setCheckIn(prenotazione.getDataInizio());
        return true;
    }
    
    public boolean checkOut(Prenotazione prenotazione,Date dataFine){
            if(prenotazione==null)return false;
            if(dataFine.before(prenotazione.getCheckIn()) || dataFine.toString().compareTo(prenotazione.getCheckIn().toString())==0)return false;
        prenotazione.setStato("Terminata");
        prenotazione.setCheckOut(dataFine);
        this.calcolaCrediti(prenotazione);
        return true;
    }
    
}
