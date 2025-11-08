package swapnil.pmsiUtility_v1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutDto {

    @NotBlank(message = "GuestId is required")
    private String guestId;

    @NotBlank(message = "RoomNumber is required")
    private String roomNumber;

    @NotBlank(message = "isSharer is required")
    private boolean isSharer;

    @NotBlank(message = "swapFlag is required")
    private String swapFlag;

    @JsonFormat(pattern = "yyMMdd")
    private Date currentDate;

    @JsonFormat(pattern = "HHmmss")
    private Time currentTime;

    private String workstationId;
}
