package swapnil.pmsiUtility_v1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfoUpdateDto {

    @NotBlank(message = "GuestId is required")
    private String guestId;

    @NotBlank(message = "RoomNumber is required")
    private String roomNumber;

    @NotBlank(message = "isSharer is required")
    private boolean isSharer;

    @JsonFormat(pattern = "yyMMdd")
    private Date guestArrivalDate;

    @JsonFormat(pattern = "yyMMdd")
    private Date guestDepartureDate;

    @JsonFormat(pattern = "yyMMdd")
    private Date currentDate;

    @JsonFormat(pattern = "HHmmss")
    private Time currentTime;

    private String swapFlag;
    private String workstationId;
    private String minibarRights;
    private String payTvRights;
    private String videoRights;
    private String classOfService;
    private String noPostStatus;
    private String guestName;
    private String guestSurname;
    private String guestGroupNumber;
    private String guestLanguage;
    private String guestTitle;
    private String guestVipStatus;
    private String udf0;
    private String udf1;
    private String udf2;
    private String udf3;
    private String udf4;
    private String udf5;
    private String udf6;
    private String udf7;
    private String udf8;
    private String udf9;
}
