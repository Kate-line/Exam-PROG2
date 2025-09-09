public class Test{
    public static void main(String[] args) {
        System.out.println(" Tests Application ASAred");

        // Créer un prestataire
        TravailleurPrestataire prestataire = new TravailleurPrestataire(
                1, "Marc", "Jean", "jean.marc@hei.mg", "0341234567", 50000.0
        );

        // Créer un salarié
        TravailleurSalarie salarie = new TravailleurSalarie(
                2, "Ando", "Ran", "Ando.ran@hei.mg", "0349876543", 800000.0
        );

        // Test 1: Pointage correct (total = 1)
        System.out.println("Test 1: Pointage correct");
        LocalDate date1 = LocalDate.of(2024, 1, 15);
        Pointage pointage1 = new Pointage(date1);
        pointage1.ajouterMission(new Mission(TypeTravail.ENSEIGNEMENT, 0.6, "Cours Java", "bleu"));
        pointage1.ajouterMission(new Mission(TypeTravail.ADMINISTRATION, 0.4, "Réunion", "rouge"));

        prestataire.ajouterPointage(pointage1);

        try {
            boolean resultat = prestataire.pointageRouge(date1);
            System.out.println("Résultat: " + resultat + " (attendu: true)");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        // Test 2: Pointage incorrect (total > 1)
        System.out.println(" Pointage incorrect (quota > 1)");
        LocalDate date2 = LocalDate.of(2024, 1, 16);
        Pointage pointage2 = new Pointage(date2);
        pointage2.ajouterMission(new Mission(TypeTravail.ENSEIGNEMENT, 1.5, "Cours trop long", "bleu"));

        prestataire.ajouterPointage(pointage2);

        try {
            boolean resultat = prestataire.pointageRouge(date2);
            System.out.println("Résultat: " + resultat);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception capturée (attendu): " + e.getMessage());
        }

        // Test 3: Calcul des jours prestés
        System.out.println("\nTest 3: Calcul des jours prestés");
        LocalDate date3 = LocalDate.of(2024, 1, 17);
        Pointage pointage3 = new Pointage(date3);
        pointage3.ajouterMission(new Mission(TypeTravail.RD, 0.5, "Recherche", "vert"));
        pointage3.ajouterMission(new Mission(TypeTravail.ABS_NON_PAYÉE, 0.5, "Congé", "gris"));

        prestataire.ajouterPointage(pointage3);

        LocalDate debut = LocalDate.of(2024, 1, 15);
        LocalDate fin = LocalDate.of(2024, 1, 17);
        double joursPreste = prestataire.getDaysRed(debut, fin);
        System.out.println("Jours prestés du " + debut + " au " + fin + ": " + joursPreste +
                " (attendu: 1.5 - 0.6+0.4+0.5 sans les absences)");

        // Test 4: Calcul salaire prestataire
        System.out.println("\nTest 4: Calcul salaire prestataire");
        double salaire = prestataire.calculerSalaire(debut, fin);
        System.out.println("Salaire prestataire: " + salaire + " Ar");
        System.out.println("Calcul: " + joursPreste + " jours × " + prestataire.getTJMActuel() + " Ar/jour");

        // Test 5: Calcul salaire salarié
        System.out.println("\nTest 5: Calcul salaire salarié");
        double salaireSalarie = salarie.calculerSalaire(debut, fin);
        System.out.println("Salaire salarié: " + salaireSalarie + " Ar (fixe mensuel)");

        System.out.println("Fin des tests:");
    }
}