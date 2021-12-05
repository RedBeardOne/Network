package pack;

import com.google.gson.annotations.SerializedName;

public class TinyUrlResponce {
    public String state;

    @SerializedName("longurl")
    public String longUrl;

    @SerializedName("shorturl")
    public String shortUrl;
}
