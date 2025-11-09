package swapnil.pmsiUtility_v1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckInDto {

    @NotBlank(message = "GuestName is required")
    private String guestName;

    @NotBlank(message = "GuestSurname is required")
    private String guestSurname;

    @NotBlank(message = "GuestId is required")
    private String guestId;

    @NotBlank(message = "RoomNumber is required")
    private String roomNumber;

    @NotNull(message = "IsSharer is required")
    private boolean isSharer;

    @NotBlank(message = "GuestLanguage is required")
    private String guestLanguage;

    @NotBlank(message = "GuestTitle is required")
    private String guestTitle;

    @JsonFormat(pattern = "yyMMdd")
    private Date currentDate;

    @JsonFormat(pattern = "yyMMdd")
    @NotNull(message = "Guest arrival date is required")
    private Date guestArrivalDate;

    @JsonFormat(pattern = "yyMMdd")
    @NotNull(message = "Guest departure date is required")
    private Date guestDepartureDate;

    @JsonFormat(pattern = "HHmmss")
    private Time currentTime;

    private String guestGroupNumber;
    private String guestVipStatus;
    private String minibarRights;
    private String payTvRights;
    private String videoRights;
    private String classOfService;
    private String noPostStatus;
    private String swapFlag;
    private String workstationId;
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
