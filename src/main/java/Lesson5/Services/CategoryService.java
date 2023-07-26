package Lesson5.Services;

import Lesson5.POJO.Category;
import Lesson5.POJO.Product;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CategoryService {
    @GET("categories/{id}")
    Call <Category> getCategory(@Path("id") int id);



}
