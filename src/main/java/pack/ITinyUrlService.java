package pack;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ITinyUrlService {
    @POST("random")
    @FormUrlEncoded
    Call<TinyUrlResponce> makeShortUrl(@Field ("format") String format, @Field("url") String url);
}
