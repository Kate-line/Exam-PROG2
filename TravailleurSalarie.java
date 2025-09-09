// Classe TravailleurSalarie
public class TravailleurSalarie extends Travailleur {
    private List<Promotion> promotionsSalaire;

    public TravailleurSalarie(int id, String nom, String prenom, String email,
                              String numeroTelephone, double salaireInitial) {
        super(id, nom, prenom, email, numeroTelephone);
        this.promotionsSalaire = new ArrayList<>();
        // Ajouter le salaire initial comme première "promotion"
        this.promotionsSalaire.add(new Promotion(LocalDate.now(), salaireInitial, "Salaire initial"));
    }

    public void ajouterPromotion(Promotion promotion) {
        this.promotionsSalaire.add(promotion);
    }

    public double getSalaireActuel() {
        return promotionsSalaire.get(promotionsSalaire.size() - 1).getMontant();
    }

    @Override
    public double calculerSalaire(LocalDate dateDebut, LocalDate dateFin) {
        // Pour un salarié, le salaire reste le même chaque mois
        return getSalaireActuel();
    }
}