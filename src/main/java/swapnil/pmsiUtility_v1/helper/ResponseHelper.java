package swapnil.pmsiUtility_v1.helper;


import org.springframework.stereotype.Component;
import swapnil.pmsiUtility_v1.models.Response;

@Component
public class ResponseHelper
{
    public Response buildResponse(String message)
    {
        Response response = new Response();
        response.setMessage(message);
        return response;
    }

}
