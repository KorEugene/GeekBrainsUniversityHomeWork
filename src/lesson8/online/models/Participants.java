package lesson8.online.models;

public enum Participants {
    HUMAN("Human"),
    CAT("Cat"),
    ROBOT("Robot");

    private final String title;

    Participants(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
