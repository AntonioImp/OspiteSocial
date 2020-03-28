package OspiteSocialTest;

import Classes.*;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OspiteSocialTest {
    private static OspiteSocial os;
    
    @BeforeClass
    public static void setUp() throws ParseException{
        os=OspiteSocial.getInstance();
        
        
        System.out.println((float)3/2);
        
        //Set per la procedura E
        String cf = "GRM";
        String nome = "Kristian";
        String cognome = "Di Blasi";
        char sesso = 'M';
        Integer eta = 23;
        String citta = "Floridia";
        String cellulare = "3233333";
        String password = "KRI";
        Utente result = os.iserisciUtente(cf, nome, cognome,citta,sesso,eta,cellulare,password);
        
        
        Abitazione abitazione = result.inserimentoAlloggio("Via SR", 1.0, 1.0, "Siracusa");
        abitazione.inserimentoDatiStanza(1,"doppia", "privata", 2);
        abitazione.inserimentoDatiStanza(2,"singola", "privata", 1);
        abitazione.inserimentoPeriodo(Date.valueOf("2020-03-1"),Date.valueOf("2020-03-28"));
        
        abitazione = result.inserimentoAlloggio("Via Flo", 1.0, 1.0, "Siracusa");
        abitazione.inserimentoDatiStanza(1,"doppia", "privata", 2);
        abitazione.inserimentoDatiStanza(2,"singola", "privata", 1);
        abitazione.inserimentoPeriodo(Date.valueOf("2020-03-1"),Date.valueOf("2020-03-28"));
        
        cf = "ANTO";
        result = os.iserisciUtente(cf, nome, cognome,citta,sesso,eta,cellulare,password);
        
    }
  
    @Test //AiserisciUtente
    public void A () {
        System.out.println("inserisciUtente");
        String cf = "DBLKS";
        String nome = "Kristian";
        String cognome = "Di Blasi";
        char sesso = 'M';
        Integer eta = 23;
        String citta = "Floridia";
        String cellulare = "3233333";
        String password = "KRI";
        
        Utente result = os.iserisciUtente(cf, nome, cognome,citta,sesso,eta,cellulare,password);
        assertNotNull(result); 
    }
    
    @Test //BLogIn
    public void B() {
        System.out.println("logIn");
        String cf = "DBLKS";
        String password = "KRI";
        
        boolean result=os.logIn(cf,password);
        assertTrue(result); 
    }
    
    
    @Test //modificaDatiUtente
    public void C() {
        System.out.println("ModificaUtente");
        String cf = "DBLKS";
        String nome = "Kristian";
        String cognome = "Di Blasi";
        char sesso = 'M';
        Integer eta = 23;
        String citta = "Floridia";
        String cellulare = "3233333";
        String password = "KRI";
        
        boolean result = os.modificaDatiUtente(cf, nome, cognome,citta,sesso,eta,cellulare,password);
        assertTrue(result);
    }
    
    @Test //vissualizzaInformazioniUtente
    public void  D() {
        System.out.println("visualizzaInformazioniUtente");
        String cf = "DBLKS";
       
        Utente result = os.vissualizzaInformazioniUtente(cf);
        assertNotNull(result);
    }
    
    @Test //richiestPrenotazione
    public void E() {
        System.out.println("richiestPrenotazione");
        List<Abitazione> abitazioni;
        List<String> ospiti=new ArrayList();
        boolean result=false;
        
        ospiti.add("DBLKS");
        ospiti.add("ANTO");
        
        abitazioni=os.ricercaAlloggio("Siracusa",2,Date.valueOf("2020-03-5"),Date.valueOf("2020-03-12"));
       
        if(!abitazioni.isEmpty())
             result = os.richiestaPrenotazione(abitazioni.get(0).getStanze(),ospiti,Date.valueOf("2020-03-5"),Date.valueOf("2020-03-12"),abitazioni.get(0));
        
        assertTrue(result);
    }
    
    @Test //ricercaAlloggio
    public void F() {
        System.out.println("ricercaAlloggio");
        List<Abitazione> abitazioni;
                                            // numero di persone ospitate
        abitazioni=os.ricercaAlloggio("Siracusa",2,Date.valueOf("2020-03-7"),Date.valueOf("2020-03-10"));
        
        assertNotEquals(0,abitazioni.size());
    }
    
    
    
    @Test //visualizzaRichieste
    public void G() {
        System.out.println("visualizzaRichieste");
        List<Prenotazione> prenotazioni;
          
        //simulazione logIn
        os.logIn("GRM","KRI");
        //
        prenotazioni=os.visualizzaRichieste();
        
        assertNotEquals(0,prenotazioni.size());
    }
    
    
    @Test //accettaRichieste
    public void H() {
        System.out.println("accettaRichieste");
        List<Prenotazione> prenotazioni;
        prenotazioni=os.visualizzaRichieste();
        
        boolean result=os.accettaRichiesta(prenotazioni.get(0));
   
        assertTrue(result);
    }
    
    
    @Test //eliminaUtente
    public void I() {
        System.out.println("eliminaUtente");
        String cf = "DBLKS";
       
        boolean result = os.eliminaUtente(cf);
        assertTrue(result);
    }
   
    
    @Test //checkIn
    public void L() {
        System.out.println("checkIn");
        
        //simulazione logIn
        os.logIn("ANTO","KRI");
        //
        OspiteSocial.getInstance().checkIn(OspiteSocial.getInstance().getPrenotazioni().get(0));
    }
    
    @Test //checkOut
    public void M() {
        System.out.println("checkOut");
        Prenotazione prenotazione=OspiteSocial.getInstance().getPrenotazioni().get(0);
        
        OspiteSocial.getInstance().checkOut(prenotazione,prenotazione.getDataFine());
    }
    
    
}
