package Classes;

public class Stanza {
    private String tipologiaStanza;
    private String tipologiaPostoLetto;
    private Integer numeroPostiLetto;
    private Integer numeroStanza;
    private boolean  visibilita;


    public Stanza(String tipologiaStanza, String tipologiaPostoLetto, Integer numeroPostiLetto, Integer numeroStanza) {
        this.tipologiaStanza = tipologiaStanza;
        this.tipologiaPostoLetto = tipologiaPostoLetto;
        this.numeroPostiLetto = numeroPostiLetto;
        this.numeroStanza = numeroStanza;
        this.visibilita=true;
    }
    
    

    public String getTipologiaStanza() {
        return tipologiaStanza;
    }

    public void setTipologiaStanza(String tipologiaStanza) {
        this.tipologiaStanza = tipologiaStanza;
    }

    public String getTipologiaPostoLetto() {
        return tipologiaPostoLetto;
    }

    public void setTipologiaPostoLetto(String tipologiaPostoLetto) {
        this.tipologiaPostoLetto = tipologiaPostoLetto;
    }

    public Integer getNumeroPostiLetto() {
        return numeroPostiLetto;
    }

    public void setNumeroPostiLetto(Integer numeroPostiLetto) {
        this.numeroPostiLetto = numeroPostiLetto;
    }

    public Integer getNumeroStanza() {
        return numeroStanza;
    }

    public void setNumeroStanza(Integer numeroStanza) {
        this.numeroStanza = numeroStanza;
    }
    
    public boolean getVisibilita() {
        return this.visibilita;
    }
    
    public void setVisibilita(boolean visibilita) {
        this.visibilita = visibilita;
    }

    @Override
    public String toString() {
        return "Stanza{" + "tipologiaStanza=" + tipologiaStanza + ", tipologiaPostoLetto=" + tipologiaPostoLetto + ", numeroPostiLetto=" + numeroPostiLetto + ", numeroStanza=" + numeroStanza + '}';
    }
    
    
}
