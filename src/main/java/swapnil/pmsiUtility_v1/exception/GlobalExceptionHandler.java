package swapnil.pmsiUtility_v1.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import swapnil.pmsiUtility_v1.helper.ResponseHelper;
import swapnil.pmsiUtility_v1.models.Response;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{
   @Autowired
   private ResponseHelper responseHelper;

   @ExceptionHandler({
            BadRequestException.class,
            ForbiddenException.class,
            NotFoundException.class,
            InternalServerException.class,
   })
   public final ResponseEntity<Response> handleException(Exception ex)
   {
      log.error("Handling exception: {}", ex.getMessage());

      if (ex instanceof BadRequestException)
      {
         Response response = responseHelper.buildResponse(ex.getMessage());
         return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
      }
      else if (ex instanceof ForbiddenException)
      {
         Response response = responseHelper.buildResponse(ex.getMessage());
         return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
      }
      else if (ex instanceof NotFoundException)
      {
         Response response = responseHelper.buildResponse(ex.getMessage());
         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      }
      else if (ex instanceof InternalServerException)
      {
         Response response = responseHelper.buildResponse(ex.getMessage());
         return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }


      Response response = responseHelper.buildResponse(ex.getMessage());
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public final ResponseEntity<Response> handleValidationExceptions(MethodArgumentNotValidException ex) {
      log.error("Validation failed: {}", ex.getMessage());

      String errorMessage = ex.getBindingResult().getFieldErrors().stream()
              .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
              .findFirst()
              .orElse("Invalid input data");

      Response response = responseHelper.buildResponse(errorMessage);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
   }


}
