package productTest;

import Lesson5.POJO.Product;
import Lesson5.Services.ProductService;
import Lesson5.Utils.RetrofitUtils;
import okhttp3.ResponseBody;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ModifyProductTest {
    static ProductService productService;
    static int id;
    static Product product;
    static Product product1;

    @BeforeAll
    static void settingBeforeAll() {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @AfterAll
    static void cleanAfterTest() throws IOException {
        Response<ResponseBody> response =
                productService.deleteProduct(id).execute();
    }

    @BeforeAll
    static void createProd() throws IOException {
        product = new Product();
        product.setId(null);
        product.setTitle("Meat");
        product.setPrice(687);
        product.setCategoryTitle("Food");

        Response<Product> response =
                productService.createProduct(product).execute();
        id = response.body().getId();
        //System.out.println(id);
    }

    @Test
    void modifyProd() throws IOException {
        product1 = new Product();
        product1.setId(id);
        product1.setTitle("Beer");
        product1.setPrice(786);
        product1.setCategoryTitle("Food");

        Response<Product> response =
            productService.modifyProduct(product1).execute();

        String title = response.body().getTitle();

        //System.out.println(title);

        assertThat(title, equalTo("Beer"));

    }
}
