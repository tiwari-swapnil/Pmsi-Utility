package swapnil.pmsiUtility_v1.service;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import swapnil.pmsiUtility_v1.models.*;

public interface PmsService {

    ResponseEntity<Response> processCheckIn(@Valid CheckInDto checkInData);

    ResponseEntity<Response> processCheckOut(@Valid CheckoutDto checkOutData);

    ResponseEntity<Response> processRoomTransfer(@Valid RoomTransferDto roomTransferData);

    ResponseEntity<Response> processInfoUpdate(@Valid InfoUpdateDto infoUpdateData);
}
