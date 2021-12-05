package pack;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IGoogleWebService {

    @GET("/")
    Call <String>home();
}
