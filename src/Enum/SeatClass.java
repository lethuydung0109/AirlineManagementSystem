package Enum;

public enum SeatClass {
    FIRST("First"), BUSI("Business"), ECO("Economy");

    private String name;

    private SeatClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
