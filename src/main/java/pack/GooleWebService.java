package pack;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GooleWebService {
    @GET("/")
    Call <String>home();
}
