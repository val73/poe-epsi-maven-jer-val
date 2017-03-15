package fr.epsi.poe.hardis.tu;

/**
 * Projet : Restaurant
 * Créé par jerome le 28/02/17.
 */
public class Restaurant {
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
    private String menu;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays.toUpperCase();
    }

    private String pays;

    private boolean ouvert;

    public Restaurant() {
        setOuvert(true);
        setVille("");
    }

    public Restaurant(String nom, String adresse, String codePostal, String ville, String telephone) {
        this();
        this.nom = nom;
        this.adresse = adresse;
        this.setCodePostal(codePostal);
        this.ville = ville;
        this.setTelephone(telephone);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom.toLowerCase();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
        this.adresse += "FRANCE";
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone != null && telephone.startsWith("+33")) {
            this.telephone = telephone;
        }
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    public String getDepartement() {
        return getCodePostal().substring(0, 2);
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pays='" + pays + '\'' +
                ", ouvert=" + ouvert +
                '}';
    }
}
