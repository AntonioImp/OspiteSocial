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

public class UtenteTest {
     private static Utente utenteController;
    
    @BeforeClass
    public static void setUp() throws ParseException{
        String cf = "DBLKS";
        String nome = "Kristian";
        String cognome = "Di Blasi";
        char sesso = 'M';
        Integer eta = 23;
        String citta = "Floridia";
        String cellulare = "3233333";
        String password = "KRI";
        
        utenteController=new Utente(cf, nome, cognome,citta,sesso,eta,cellulare,password);
    }
  
    @Test //inserisciAbitazione
    public void A() {
        System.out.println("inserisciAbitazione");
        String cf = "DBLKS";
        String indirizzo = "Siracusa";
        Double distanzaCentro = 2.0;
        Double distanzaStazione = 2.0;
        String citta="Siracusa";
       
        Abitazione result = utenteController.inserimentoAlloggio(indirizzo,distanzaCentro,distanzaStazione,citta);
        assertNotNull(result);
    }
    
    @Test //modificaDatiAlloggio
    public void B() {
        System.out.println("modificaDatiAlloggio");
        String indirizzo = "Siracusa";
        Double distanzaCentro = 3.0;
        Double distanzaStazione = 3.0;
       
        boolean result = utenteController.modificaDatiAlloggio(indirizzo,distanzaCentro,distanzaStazione);
        assertTrue(result);
    }
    
    @Test //visualizzaDatiAlloggio
    public void C() {
        System.out.println("visualizzaDatiAlloggio");
        String indirizzo = "Siracusa";
        
        Abitazione result = utenteController.visualizzaAlloggio(indirizzo);
        assertNotNull(result);
    }
    
    @Test //eliminaAlloggio
    public void D() {
        System.out.println("eliminaAlloggio");
        String indirizzo = "Siracusa";
       
        boolean result = utenteController.eliminaAlloggio(indirizzo);
        assertTrue(result);
    }
    
    
    
    
    
}
