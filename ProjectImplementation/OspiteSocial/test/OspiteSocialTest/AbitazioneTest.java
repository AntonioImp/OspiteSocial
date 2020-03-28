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

public class AbitazioneTest {
     private static Abitazione abitazioneController;
    
    @BeforeClass
    public static void setUp() throws ParseException{
        String indirizzo = "Siracusa";
        Double distanzaCentro = 1.0;
        Double distanzaStazione = 1.0;
        String citta="Siracusa";
        
        abitazioneController=new Abitazione(indirizzo,distanzaCentro,distanzaStazione,citta);
    }
  
    @Test //inserimentoPeriodo
    public void A() {
        System.out.println("inserimentoPeriodo");
        Date inizio = Date.valueOf("2020-03-1");
        Date fine =  Date.valueOf("2020-03-5");
       
        boolean result = abitazioneController.inserimentoPeriodo(inizio,fine);
        assertTrue(result);
    }
   
    @Test //inserimentoDatiStanza
    public void B() {
        System.out.println("inserimentoDatiStanza");
        String tipologiaStanza="privata";
        String tipologiaPostoLetto="doppia";
        Integer numeroPostiLetto=2;
        Integer numeroStanza=1;
       
        boolean result = abitazioneController.inserimentoDatiStanza(numeroStanza,tipologiaStanza,tipologiaPostoLetto,numeroPostiLetto);
        assertTrue(result);
    }
    
    @Test //modificaDatiStanza
    public void C() {
        System.out.println("modificaDatiStanza");
        String tipologiaStanza="privata";
        String tipologiaPostoLetto="singola";
        Integer numeroPostiLetto=1;
        Integer numeroStanza=1;
        Stanza stanza=abitazioneController.visualizzaStanza(numeroStanza);
       
        boolean result = abitazioneController.modificaDatiStanza(numeroStanza,tipologiaStanza,tipologiaPostoLetto,numeroPostiLetto);
        assertTrue(result);
    }
    
    @Test //visualizzaStanza
    public void D() {
        System.out.println("visualizzaStanza");
        Integer numeroStanza=1;
       
        Stanza result=abitazioneController.visualizzaStanza(numeroStanza);
        assertNotNull(result);
    }
    
    @Test //modificaPeriodo
    public void E() {
        System.out.println("modificaPeriodo");
        Date inizio = Date.valueOf("2020-03-1");
        Date fine =  Date.valueOf("2020-03-5");
       
        boolean result = abitazioneController.modificaPeriodo(0,inizio, fine);
        assertTrue(result);
    }
     
    @Test //eliminaStanza
    public void F() {
        System.out.println("eliminaStanza");
        Integer numeroStanza=1;
        
        boolean result = abitazioneController.eliminaStanza(numeroStanza);
        assertTrue(result);
    }
    
    @Test //visualizzaPeriodo
    public void G() {
        System.out.println("visualizzaPeriodo");
        
        Periodo result = abitazioneController.visualizzaPeriodo(0);
        assertNotNull(result);
    }
    
    @Test //eliminaPeriodo
     public void H() {
        System.out.println("elimaPeriodo");
        
        boolean result = abitazioneController.eliminaPeriodo(0);
        assertTrue(result);
    }
    
}
