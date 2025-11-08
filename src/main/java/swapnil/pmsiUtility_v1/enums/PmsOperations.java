package swapnil.pmsiUtility_v1.enums;

public enum PmsOperations {
    CHECK_IN("GI"),
    CHECK_OUT("GO"),
    ROOM_TRANSFER("GC"),
    GUEST_INFO_UPDATE("GC");

    private final String code;

    PmsOperations(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
