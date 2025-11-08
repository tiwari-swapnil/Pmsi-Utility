package swapnil.pmsiUtility_v1.utils;

import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import swapnil.pmsiUtility_v1.constants.PmsConstants;
import swapnil.pmsiUtility_v1.enums.GuestLanguages;
import swapnil.pmsiUtility_v1.enums.PmsFields;
import swapnil.pmsiUtility_v1.enums.PmsOperations;
import swapnil.pmsiUtility_v1.models.CheckInDto;
import swapnil.pmsiUtility_v1.models.CheckoutDto;
import swapnil.pmsiUtility_v1.models.InfoUpdateDto;
import swapnil.pmsiUtility_v1.models.RoomTransferDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@UtilityClass
public class PmsUtils {

    public String generateCheckInString(CheckInDto data) {
        try {
            /*GI|G#1758632390672|RN1110|GSN|DA250925|GA250925|GD250930|GFADAM|GG|GLEA|GNHALL|GTMs.|A0306413|GV|NPN|TI140909|*/
            StringBuilder checkInString = new StringBuilder();

            checkInString.append(PmsOperations.CHECK_IN.getCode())
                    .append(PmsFields.GUEST_ID.getCode()).append(data.getGuestId())
                    .append("|").append(PmsFields.ROOM_NUMBER.getCode()).append(data.getRoomNumber())
                    .append("|").append(PmsFields.GUEST_NAME.getCode()).append(data.getGuestName())
                    .append("|").append(PmsFields.GUEST_SURNAME.getCode()).append(data.getGuestSurname())
                    .append("|").append(PmsFields.GUEST_TITLE.getCode()).append(data.getGuestTitle())
                    .append("|").append(PmsFields.GUEST_ARRIVAL_DATE.getCode()).append(data.getGuestArrivalDate())
                    .append("|").append(PmsFields.GUEST_DEPARTURE_DATE.getCode()).append(data.getGuestDepartureDate())
                    .append("|").append(PmsFields.DATE.getCode())
                    .append(LocalDate.now().format(DateTimeFormatter.ofPattern(PmsConstants.DATE_FORMAT)))
                    .append("|").append(PmsFields.TIME.getCode())
                    .append(LocalTime.now().format(DateTimeFormatter.ofPattern(PmsConstants.TIME_FORMAT)))
                    .append("|").append(PmsFields.GUEST_SHARER.getCode())
                    .append(Boolean.TRUE.equals(data.isSharer()) ? "Y" : "N")
                    .append("|").append(PmsFields.GUEST_LANGUAGE.getCode())
                    .append(GuestLanguages.valueOf(data.getGuestLanguage().toUpperCase()).getCode());

            appendIfNotBlank(checkInString, PmsFields.GUEST_GROUP.getCode(), data.getGuestGroupNumber());
            appendIfNotBlank(checkInString, PmsFields.VIP_STATUS.getCode(), data.getGuestVipStatus());
            appendIfNotBlank(checkInString, PmsFields.MINIBAR_RIGHTS.getCode(), data.getMinibarRights());
            appendIfNotBlank(checkInString, PmsFields.PAY_TV_RIGHTS.getCode(), data.getPayTvRights());
            appendIfNotBlank(checkInString, PmsFields.VIDEO_RIGHTS.getCode(), data.getVideoRights());
            appendIfNotBlank(checkInString, PmsFields.CLASS_OF_SERVICE.getCode(), data.getClassOfService());
            appendIfNotBlank(checkInString, PmsFields.NO_POST.getCode(), data.getNoPostStatus());
            appendIfNotBlank(checkInString, PmsFields.SWAP_FLAG.getCode(), data.getSwapFlag());
            appendIfNotBlank(checkInString, PmsFields.WORKSTATION_ID.getCode(), data.getWorkstationId());
            appendIfNotBlank(checkInString, PmsFields.UDF0.getCode(), data.getUdf0());
            appendIfNotBlank(checkInString, PmsFields.UDF1.getCode(), data.getUdf1());
            appendIfNotBlank(checkInString, PmsFields.UDF2.getCode(), data.getUdf2());
            appendIfNotBlank(checkInString, PmsFields.UDF3.getCode(), data.getUdf3());
            appendIfNotBlank(checkInString, PmsFields.UDF4.getCode(), data.getUdf4());
            appendIfNotBlank(checkInString, PmsFields.UDF5.getCode(), data.getUdf5());
            appendIfNotBlank(checkInString, PmsFields.UDF6.getCode(), data.getUdf6());
            appendIfNotBlank(checkInString, PmsFields.UDF7.getCode(), data.getUdf7());
            appendIfNotBlank(checkInString, PmsFields.UDF8.getCode(), data.getUdf8());
            appendIfNotBlank(checkInString, PmsFields.UDF9.getCode(), data.getUdf9());


            return checkInString.toString();
        } catch (Exception e) {
            log.error("CheckIn :: Exception occurred while generating checkIn string :", e);
        }
        return "";
    }

    private void appendIfNotBlank(StringBuilder sb, String prefix, String value) {
        if (StringUtils.isNotBlank(value)) {
            sb.append("|").append(prefix).append(value);
        }
    }

    public String generateCheckOutString(CheckoutDto data){
        try{
            //GO|RN1110|G#1758632390672|GSN|
            StringBuilder checkOutString = new StringBuilder();
            checkOutString.append(PmsOperations.CHECK_OUT.getCode()).append(PmsFields.ROOM_NUMBER.getCode()).append(data.getRoomNumber())
                    .append(PmsFields.GUEST_ID.getCode()).append(data.getGuestId())
                    .append(PmsFields.GUEST_SHARER.getCode()).append(Boolean.TRUE.equals(data.isSharer()) ? "Y" : "N");

            return checkOutString.toString();
        }
        catch (Exception e){
            log.error("CheckOut :: Exception occurred while generating checkOut string : ", e);
        }
        return "";
    }

    public String generateInfoUpdateString(InfoUpdateDto data){
        try{
            StringBuilder infoUpdateString = new StringBuilder();

            infoUpdateString.append(PmsOperations.GUEST_INFO_UPDATE.getCode())
                    .append(PmsFields.GUEST_ID.getCode()).append(data.getGuestId())
                    .append("|").append(PmsFields.ROOM_NUMBER.getCode()).append(data.getRoomNumber())
                    .append("|").append(PmsFields.GUEST_SHARER.getCode())
                    .append(Boolean.TRUE.equals(data.isSharer()) ? "Y" : "N");

                    appendIfNotBlank(infoUpdateString, PmsFields.GUEST_NAME.getCode(), data.getGuestName());
                    appendIfNotBlank(infoUpdateString, PmsFields.GUEST_SURNAME.getCode(), data.getGuestSurname());
                    appendIfNotBlank(infoUpdateString, PmsFields.GUEST_TITLE.getCode(), data.getGuestTitle());
                    appendIfNotBlank(infoUpdateString, PmsFields.GUEST_ARRIVAL_DATE.getCode(), data.getGuestArrivalDate().toString());
                    appendIfNotBlank(infoUpdateString, PmsFields.GUEST_DEPARTURE_DATE.getCode(), data.getGuestDepartureDate().toString());

                    appendIfNotBlank(infoUpdateString, PmsFields.DATE.getCode(), LocalDate.now().format(DateTimeFormatter.ofPattern(PmsConstants.DATE_FORMAT)));
                    appendIfNotBlank(infoUpdateString, PmsFields.TIME.getCode(), LocalTime.now().format(DateTimeFormatter.ofPattern(PmsConstants.TIME_FORMAT)));
                    appendIfNotBlank(infoUpdateString, PmsFields.GUEST_LANGUAGE.getCode(), GuestLanguages.valueOf(data.getGuestLanguage().toUpperCase()).getCode());

            appendIfNotBlank(infoUpdateString, PmsFields.GUEST_GROUP.getCode(), data.getGuestGroupNumber());
            appendIfNotBlank(infoUpdateString, PmsFields.VIP_STATUS.getCode(), data.getGuestVipStatus());
            appendIfNotBlank(infoUpdateString, PmsFields.MINIBAR_RIGHTS.getCode(), data.getMinibarRights());
            appendIfNotBlank(infoUpdateString, PmsFields.PAY_TV_RIGHTS.getCode(), data.getPayTvRights());
            appendIfNotBlank(infoUpdateString, PmsFields.VIDEO_RIGHTS.getCode(), data.getVideoRights());
            appendIfNotBlank(infoUpdateString, PmsFields.CLASS_OF_SERVICE.getCode(), data.getClassOfService());
            appendIfNotBlank(infoUpdateString, PmsFields.NO_POST.getCode(), data.getNoPostStatus());
            appendIfNotBlank(infoUpdateString, PmsFields.SWAP_FLAG.getCode(), data.getSwapFlag());
            appendIfNotBlank(infoUpdateString, PmsFields.WORKSTATION_ID.getCode(), data.getWorkstationId());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF0.getCode(), data.getUdf0());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF1.getCode(), data.getUdf1());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF2.getCode(), data.getUdf2());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF3.getCode(), data.getUdf3());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF4.getCode(), data.getUdf4());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF5.getCode(), data.getUdf5());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF6.getCode(), data.getUdf6());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF7.getCode(), data.getUdf7());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF8.getCode(), data.getUdf8());
            appendIfNotBlank(infoUpdateString, PmsFields.UDF9.getCode(), data.getUdf9());


            return infoUpdateString.toString();
        }
        catch (Exception e){
            log.error("InfoUpdate :: Exception occurred while generating infoUpdate string : ", e);
        }
        return "";
    }

    public String generateRoomTransferString(RoomTransferDto data){
        try{

            StringBuilder roomTransferString = new StringBuilder();

            roomTransferString.append(PmsOperations.GUEST_INFO_UPDATE.getCode())
                    .append(PmsFields.GUEST_ID.getCode()).append(data.getGuestId())
                    .append("|").append(PmsFields.ROOM_NUMBER.getCode()).append(data.getRoomNumber())
                    .append("|").append(PmsFields.GUEST_SHARER.getCode())
                    .append(Boolean.TRUE.equals(data.isSharerForNewRoom()) ? "Y" : "N")
                    .append("|").append(PmsFields.OLD_ROOM_NUMBER.getCode()).append(data.getOldRoom())
                    .append("|").append(PmsFields.GUEST_SHARER.getCode())
                    .append(Boolean.TRUE.equals(data.isSharerForNewRoom()) ? "Y" : "N");

            appendIfNotBlank(roomTransferString, PmsFields.GUEST_NAME.getCode(), data.getGuestName());
            appendIfNotBlank(roomTransferString, PmsFields.GUEST_SURNAME.getCode(), data.getGuestSurname());
            appendIfNotBlank(roomTransferString, PmsFields.GUEST_TITLE.getCode(), data.getGuestTitle());
            appendIfNotBlank(roomTransferString, PmsFields.GUEST_ARRIVAL_DATE.getCode(), data.getGuestArrivalDate().toString());
            appendIfNotBlank(roomTransferString, PmsFields.GUEST_DEPARTURE_DATE.getCode(), data.getGuestDepartureDate().toString());

            appendIfNotBlank(roomTransferString, PmsFields.DATE.getCode(), LocalDate.now().format(DateTimeFormatter.ofPattern(PmsConstants.DATE_FORMAT)));
            appendIfNotBlank(roomTransferString, PmsFields.TIME.getCode(), LocalTime.now().format(DateTimeFormatter.ofPattern(PmsConstants.TIME_FORMAT)));
            appendIfNotBlank(roomTransferString, PmsFields.GUEST_LANGUAGE.getCode(), GuestLanguages.valueOf(data.getGuestLanguage().toUpperCase()).getCode());

            appendIfNotBlank(roomTransferString, PmsFields.GUEST_GROUP.getCode(), data.getGuestGroupNumber());
            appendIfNotBlank(roomTransferString, PmsFields.VIP_STATUS.getCode(), data.getGuestVipStatus());
            appendIfNotBlank(roomTransferString, PmsFields.MINIBAR_RIGHTS.getCode(), data.getMinibarRights());
            appendIfNotBlank(roomTransferString, PmsFields.PAY_TV_RIGHTS.getCode(), data.getPayTvRights());
            appendIfNotBlank(roomTransferString, PmsFields.VIDEO_RIGHTS.getCode(), data.getVideoRights());
            appendIfNotBlank(roomTransferString, PmsFields.CLASS_OF_SERVICE.getCode(), data.getClassOfService());
            appendIfNotBlank(roomTransferString, PmsFields.NO_POST.getCode(), data.getNoPostStatus());
            appendIfNotBlank(roomTransferString, PmsFields.SWAP_FLAG.getCode(), data.getSwapFlag());
            appendIfNotBlank(roomTransferString, PmsFields.WORKSTATION_ID.getCode(), data.getWorkstationId());
            appendIfNotBlank(roomTransferString, PmsFields.UDF0.getCode(), data.getUdf0());
            appendIfNotBlank(roomTransferString, PmsFields.UDF1.getCode(), data.getUdf1());
            appendIfNotBlank(roomTransferString, PmsFields.UDF2.getCode(), data.getUdf2());
            appendIfNotBlank(roomTransferString, PmsFields.UDF3.getCode(), data.getUdf3());
            appendIfNotBlank(roomTransferString, PmsFields.UDF4.getCode(), data.getUdf4());
            appendIfNotBlank(roomTransferString, PmsFields.UDF5.getCode(), data.getUdf5());
            appendIfNotBlank(roomTransferString, PmsFields.UDF6.getCode(), data.getUdf6());
            appendIfNotBlank(roomTransferString, PmsFields.UDF7.getCode(), data.getUdf7());
            appendIfNotBlank(roomTransferString, PmsFields.UDF8.getCode(), data.getUdf8());
            appendIfNotBlank(roomTransferString, PmsFields.UDF9.getCode(), data.getUdf9());

            return roomTransferString.toString();
        }
        catch (Exception e){
            log.error("RoomTransfer :: Exception occurred while generating roomTransfer string : ", e);
        }
        return "";
    }
}
