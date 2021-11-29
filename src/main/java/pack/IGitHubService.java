package pack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGitHubService {
    @GET("users/{user}/repos")
    Call<String> getRepo(@Path("user") String userName);
}
