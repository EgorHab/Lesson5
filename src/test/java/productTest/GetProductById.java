package productTest;

import Lesson5.POJO.Category;
import Lesson5.POJO.Product;
import Lesson5.Services.CategoryService;
import Lesson5.Services.ProductService;
import Lesson5.Utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductById {
    static ProductService productService;

    @BeforeAll
    static void bfa() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @Test
    void getProduct() throws IOException {
        Response<Product> response =
                productService.getProductById(1000).execute();

        assertThat(response.code(), equalTo(404));
    }
}