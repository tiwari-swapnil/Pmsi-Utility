package swapnil.pmsiUtility_v1.service;

import jakarta.validation.Valid;
import swapnil.pmsiUtility_v1.models.CheckInDto;
import swapnil.pmsiUtility_v1.models.CheckoutDto;
import swapnil.pmsiUtility_v1.models.InfoUpdateDto;
import swapnil.pmsiUtility_v1.models.RoomTransferDto;

public interface PmsService {

    void processCheckIn(@Valid CheckInDto checkInData);

    void processCheckOut(@Valid CheckoutDto checkOutData);

    void processRoomTransfer(@Valid RoomTransferDto roomTransferData);

    void processInfoUpdate(@Valid InfoUpdateDto infoUpdateData);
}
