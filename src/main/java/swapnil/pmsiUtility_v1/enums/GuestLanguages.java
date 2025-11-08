package swapnil.pmsiUtility_v1.enums;

public enum GuestLanguages {
    ENGLISH("EA"),
    AMERICAN("EA"),
    FRENCH("FR"),
    GERMAN("GE"),
    ITALIAN("IT"),
    JAPANESE("JA"),
    SPANISH("SP");

    private final String code;

    GuestLanguages(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
