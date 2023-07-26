package Lesson5.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitUtils {
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://localhost:8189/market/api/v1/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
