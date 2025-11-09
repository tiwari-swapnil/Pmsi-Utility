package swapnil.pmsiUtility_v1.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swapnil.pmsiUtility_v1.models.*;
import swapnil.pmsiUtility_v1.service.PmsService;

@Slf4j
@RestController()
@RequestMapping("/api/v1")
public class PmsController {

    @Autowired
    private PmsService pmsService;

    @PostMapping(value = "/checkIn", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> checkIn(@Valid @RequestBody CheckInDto checkInData){
      log.info("CheckIn :: Request received at checkIn controller");
      return pmsService.processCheckIn(checkInData);
    }

    @PostMapping(value = "/checkOut", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> checkOut(@Valid @RequestBody CheckoutDto checkOutData){
        log.info("CheckOut :: Request received at checkOut controller");
        return pmsService.processCheckOut(checkOutData);
    }

    @PostMapping(value = "/roomTransfer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> roomTransfer(@Valid @RequestBody RoomTransferDto roomTransferData){
        log.info("RoomTransfer :: Request Received at roomTransfer controller");
        return pmsService.processRoomTransfer(roomTransferData);
    }

    @PostMapping(value = "/infoUpdate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Response> infoUpdate(@Valid @RequestBody InfoUpdateDto infoUpdateData){
        log.info("InfoUpdate :: Request received at infoUpdate controller");
        return pmsService.processInfoUpdate(infoUpdateData);
    }
}
