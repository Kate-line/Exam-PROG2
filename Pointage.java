public class Pointage {
    private LocalDate date;
    private List<Mission> missions;

    public Pointage(LocalDate date) {
        this.date = date;
        this.missions = new ArrayList<>();
    }

    public void ajouterMission(Mission mission) {
        this.missions.add(mission);
    }

    // Getters
    public LocalDate getDate() { return date; }
    public List<Mission> getMissions() { return missions; }
}



