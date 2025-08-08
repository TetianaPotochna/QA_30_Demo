package enums;

public enum Gender {
    MALE("//*[@for='gender-radio-1']"),
    FEMALE("//*[@for='gender-radio-2']"),
    OTHER("//*[@for='gender-radio-3']");

    private String locator;

    Gender(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
