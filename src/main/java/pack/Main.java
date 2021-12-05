package pack;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Main().runTiny();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        IGoogleWebService service = new Retrofit.Builder()
                .baseUrl("https://google.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(IGoogleWebService.class);
        Response<String> response = service.home().execute();
        if (response != null && response.isSuccessful()) {
            System.out.println(response.body());
        } else {
            System.out.println(response.errorBody().string());
        }
    }

    private void runGitHub() throws IOException {
        IGitHubService serviceGit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(IGitHubService.class);

        Response<String> response = serviceGit.getRepo("RedBeardOne").execute();
        if (response.isSuccessful()) {
            System.out.println(response.body());
        } else System.out.println(response.errorBody().string());
    }


    private void runTiny() throws IOException {
        ITinyUrlService service = new Retrofit.Builder()
                .baseUrl("http://tiny-url.info/api/v1/")
                //.addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ITinyUrlService.class);
        Response<TinyUrlResponce> response = service.makeShortUrl("json", "https://www.google.com/maps/place/%D0%B2%D1%83%D0%BB%D0%B8%D1%86%D1%8F+%D0%9A%D0%BE%D1%80%D0%BE%D0%BB%D0%B5%D0%BD%D0%BA%D0%B0,+10,+%D0%A5%D0%B0%D1%80%D0%BA%D1%96%D0%B2,+%D0%A5%D0%B0%D1%80%D0%BA%D1%96%D0%B2%D1%81%D1%8C%D0%BA%D0%B0+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C,+61000/@49.9909392,36.2356877,19.25z/data=!4m8!1m2!2m1!1z0LrQsNGA0YLQsA!3m4!1s0x4127a0f19389479f:0xe322eb1514fa7880!8m2!3d49.9908373!4d36.2356296").execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().shortUrl);
        } else System.out.println(response.errorBody().string());
    }
}
