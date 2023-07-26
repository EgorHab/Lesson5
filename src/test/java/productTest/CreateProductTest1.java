package productTest;

import Lesson5.POJO.Product;
import Lesson5.Services.ProductService;
import Lesson5.Utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateProductTest1 {
    static ProductService productService;
    Product product;
    static int id;

    @BeforeAll
    static void settingBeforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }



    @AfterAll
    static void cleanAfterTest() throws IOException {
        Response <ResponseBody> response =
                productService.deleteProduct(id).execute();

    }

    @Test
    void createProductTest() throws IOException {
        product = new Product();
        product.setId(null);
        product.setTitle("Fish");
        product.setPrice(777);
        product.setCategoryTitle("Food");

        Response<Product> response =
                productService.createProduct(product).execute();
        id = response.body().getId();
        System.out.println(id);
        assertThat(id, Matchers.not(0));
    }
}
