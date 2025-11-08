package swapnil.pmsiUtility_v1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import swapnil.pmsiUtility_v1.utils.PmsUtils;
import swapnil.pmsiUtility_v1.models.CheckInDto;
import swapnil.pmsiUtility_v1.models.CheckoutDto;
import swapnil.pmsiUtility_v1.models.InfoUpdateDto;
import swapnil.pmsiUtility_v1.models.RoomTransferDto;
import swapnil.pmsiUtility_v1.service.PmsService;

import java.util.Objects;

@Slf4j
@Service
public class PmsServiceImpl implements PmsService {

    @Override
    public void processCheckIn(CheckInDto checkInData) {
        if(Objects.isNull(checkInData)){
            log.error("CheckIn :: Received checkIn Data is Null, not processing further");
            return;
        }

        log.debug("CheckIn :: Received checkIn Data is : {} ", checkInData);
        String checkInString = PmsUtils.generateCheckInString(checkInData);
    }

    @Override
    public void processCheckOut(CheckoutDto checkOutData) {
        if(Objects.isNull(checkOutData)){
            log.error("CheckOut :: Received checkOut data is Null , not processing further");
            return;
        }

        log.debug("CheckOut :: Received checkout data is : {} ", checkOutData);
        String checkOutString = PmsUtils.generateCheckOutString(checkOutData);
    }

    @Override
    public void processRoomTransfer(RoomTransferDto roomTransferData) {
        if(Objects.isNull(roomTransferData)){
            log.error("RoomTransfer :: Received roomTransfer data is null, not processing further");
            return;
        }

        log.debug("RoomTransfer :: Received roomTransfer data is : {} ", roomTransferData);
        String roomTransferString = PmsUtils.generateRoomTransferString(roomTransferData);
    }

    @Override
    public void processInfoUpdate(InfoUpdateDto infoUpdateData) {
        if(Objects.isNull(infoUpdateData)){
            log.error("InfoUpdate :: Received infoUpdate data is null, not processing further");
            return;
        }

        log.debug("InfoUpdate :: Received infoUpdate data is : {} ", infoUpdateData);
        String infoUpdateString = PmsUtils.generateInfoUpdateString(infoUpdateData);
    }
}
