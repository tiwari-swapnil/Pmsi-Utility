package swapnil.pmsiUtility_v1.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import swapnil.pmsiUtility_v1.exception.BadRequestException;
import swapnil.pmsiUtility_v1.helper.ResponseHelper;
import swapnil.pmsiUtility_v1.models.*;
import swapnil.pmsiUtility_v1.socket.PmsSocket;
import swapnil.pmsiUtility_v1.utils.PmsUtils;
import swapnil.pmsiUtility_v1.service.PmsService;

import java.util.Objects;

@Slf4j
@Service
public class PmsServiceImpl implements PmsService {

    @Autowired
    private ResponseHelper responseHelper;

    @Autowired
    private PmsSocket pmsSocket;

    @Override
    public ResponseEntity<Response> processCheckIn(CheckInDto checkInData) {
        if(Objects.isNull(checkInData)){
            log.error("CheckIn :: Received checkIn Data is Null, not processing further");
            throw new BadRequestException("Request Body is required");
        }

        log.debug("CheckIn :: Received checkIn Data is : {} ", checkInData);
        String checkInString = PmsUtils.generateCheckInString(checkInData);
        log.info("CheckIn :: CheckInString generated is : {} ", checkInString);

        pmsSocket.writeCommand(checkInString);

        Response response = responseHelper.buildResponse("CheckIn message sent successfully ");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Response> processCheckOut(CheckoutDto checkOutData) {
        if(Objects.isNull(checkOutData)){
            log.error("CheckOut :: Received checkOut data is Null , not processing further");
            throw new BadRequestException("Request Body is required");
        }

        log.debug("CheckOut :: Received checkout data is : {} ", checkOutData);
        String checkOutString = PmsUtils.generateCheckOutString(checkOutData);
        log.info("CheckOut :: CheckOutString generated is : {} ", checkOutString);

        pmsSocket.writeCommand(checkOutString);

        Response response = responseHelper.buildResponse("CheckOut message sent successfully ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> processRoomTransfer(RoomTransferDto roomTransferData) {
        if(Objects.isNull(roomTransferData)){
            log.error("RoomTransfer :: Received roomTransfer data is null, not processing further");
            throw new BadRequestException("Request Body is required");
        }

        log.debug("RoomTransfer :: Received roomTransfer data is : {} ", roomTransferData);
        String roomTransferString = PmsUtils.generateRoomTransferString(roomTransferData);
        log.info("RoomTransfer :: RoomTransferString generated is : {} ", roomTransferString);

        pmsSocket.writeCommand(roomTransferString);

        Response response = responseHelper.buildResponse("RoomTransfer message sent successfully ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> processInfoUpdate(InfoUpdateDto infoUpdateData) {
        if(Objects.isNull(infoUpdateData)){
            log.error("InfoUpdate :: Received infoUpdate data is null, not processing further");
            throw new BadRequestException("Request Body is required");
        }

        log.debug("InfoUpdate :: Received infoUpdate data is : {} ", infoUpdateData);
        String infoUpdateString = PmsUtils.generateInfoUpdateString(infoUpdateData);
        log.info("InfoUpdate :: InfoUpdateString generated is : {} ", infoUpdateString);

        pmsSocket.writeCommand(infoUpdateString);
        Response response = responseHelper.buildResponse("InfoUpdate message sent successfully ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
