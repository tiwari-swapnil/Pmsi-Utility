package swapnil.pmsiUtility_v1.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import swapnil.pmsiUtility_v1.models.CheckInDto;
import swapnil.pmsiUtility_v1.models.CheckoutDto;
import swapnil.pmsiUtility_v1.models.InfoUpdateDto;
import swapnil.pmsiUtility_v1.models.RoomTransferDto;
import swapnil.pmsiUtility_v1.service.PmsService;

@Slf4j
@RestController("/api/v1")
public class PmsController {

    @Autowired
    private PmsService pmsService;

    @PostMapping(value = "/checkIn", consumes = "application/json", produces = "application/json")
    public void checkIn(@Valid CheckInDto checkInData){
      log.info("CheckIn :: Request received at checkIn controller");
      pmsService.processCheckIn(checkInData);
    }

    @PostMapping(value = "/checkOut", consumes = "application/json", produces = "application/json")
    public void checkOut(@Valid CheckoutDto checkOutData){
        log.info("CheckOut :: Request received at checkOut controller");
        pmsService.processCheckOut(checkOutData);
    }

    @PostMapping(value = "/roomTransfer", consumes = "application/json", produces = "application/json")
    public void roomTransfer(@Valid RoomTransferDto roomTransferData){
        log.info("RoomTransfer :: Request Received at roomTransfer controller");
        pmsService.processRoomTransfer(roomTransferData);
    }

    @PostMapping(value = "/infoUpdate", consumes = "application/json", produces = "application/json")
    public void infoUpdate(@Valid InfoUpdateDto infoUpdateData){
        log.info("InfoUpdate :: Request received at infoUpdate controller");
        pmsService.processInfoUpdate(infoUpdateData);
    }
}
