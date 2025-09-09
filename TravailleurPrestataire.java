public class TravailleurPrestataire extends Travailleur {
    private List<Promotion> promotionsTJM;

    public TravailleurPrestataire(int id, String nom, String prenom, String email,
                                  String numeroTelephone, double tjmInitial) {
        super(id, nom, prenom, email, numeroTelephone);
        this.promotionsTJM = new ArrayList<>();
        // Ajouter le TJM initial
        this.promotionsTJM.add(new Promotion(LocalDate.now(), tjmInitial, "TJM initial"));
    }

    public void ajouterPromotionTJM(Promotion promotion) {
        this.promotionsTJM.add(promotion);
    }

    public double getTJMActuel() {
        return promotionsTJM.get(promotionsTJM.size() - 1).getMontant();
    }

    @Override
    public double calculerSalaire(LocalDate dateDebut, LocalDate dateFin) {
        double joursPreste = getDaysRed(dateDebut, dateFin);
        return joursPreste * getTJMActuel();
    }
}
