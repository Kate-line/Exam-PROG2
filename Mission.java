public class Mission {
    private TypeTravail typeTravail;
    private double quotaTemps; // Entre 0 et 1
    private String description;
    private String couleur;

    public Mission(TypeTravail typeTravail, double quotaTemps, String description, String couleur) {
        this.typeTravail = typeTravail;
        this.quotaTemps = quotaTemps;
        this.description = description;
        this.couleur = couleur;
    }

    // Getters
    public TypeTravail getTypeTravail() { return typeTravail; }
    public double getQuotaTemps() { return quotaTemps; }
    public String getDescription() { return description; }
    public String getCouleur() { return couleur; }
}
