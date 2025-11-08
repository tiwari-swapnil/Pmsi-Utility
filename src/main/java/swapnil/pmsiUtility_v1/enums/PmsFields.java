package swapnil.pmsiUtility_v1.enums;

public enum PmsFields {
    GUEST_ID("G#"),
    ROOM_NUMBER("RN"),
    GUEST_NAME("GN"),
    GUEST_SURNAME("GF"),
    GUEST_TITLE("GT"),
    GUEST_ARRIVAL_DATE("GA"),
    GUEST_DEPARTURE_DATE("GD"),
    DATE("DA"),
    TIME("TI"),
    GUEST_SHARER("GS"),
    GUEST_LANGUAGE("GL"),
    GUEST_GROUP("GG"),
    VIP_STATUS("GV"),
    MINIBAR_RIGHTS("MR"),
    PAY_TV_RIGHTS("TV"),
    VIDEO_RIGHTS("VR"),
    CLASS_OF_SERVICE("CS"),
    NO_POST("NP"),
    SWAP_FLAG("SF"),
    WORKSTATION_ID("WS"),
    UDF0("A0"),
    UDF1("A1"),
    UDF2("A2"),
    UDF3("A3"),
    UDF4("A4"),
    UDF5("A5"),
    UDF6("A6"),
    UDF7("A7"),
    UDF8("A8"),
    UDF9("A9"),
    OLD_ROOM_NUMBER("RO");

    private final String code;

    PmsFields(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
