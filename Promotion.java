public class Promotion {
    private LocalDate date;
    private double montant;
    private String raison;

    public Promotion(LocalDate date, double montant, String raison) {
        this.date = date;
        this.montant = montant;
        this.raison = raison;
    }

    // Getters
    public LocalDate getDate() {
        return date; }
    public double getMontant() {
        return montant; }
    public String getRaison() {
        return raison; }
}