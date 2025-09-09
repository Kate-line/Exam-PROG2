import java.time.LocalDate;
import java.util.*;
 public abstract class Travailleur {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String numeroTelephone;
    protected List<Pointage> pointages;

    public Travailleur(int id, String nom, String prenom, String email, String numeroTelephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.pointages = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id; }
    public String getNom() {
        return nom;
    } }
    public String getPrenom() {
    return prenom; }
    public String getEmail() {
    return email; }
    public String getNumeroTelephone() { return
            numeroTelephone; }
    public List<Pointage> getPointages() {
    return pointages; }

