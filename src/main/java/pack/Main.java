package pack;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Main().run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void run() throws IOException {
        GooleWebService service = new Retrofit.Builder()
                .baseUrl("https://google.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(GooleWebService.class);
        Response<String> response =service.home().execute();
        if (response.isSuccessful()){
            System.out.println(response.body());
        }
        else {
            System.out.println(response.errorBody().string());
        }
    }
    private void runGitHub(){
        IGitHubService serviceGit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(IGitHubService.class);
    }
}
