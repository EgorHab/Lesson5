package productTest;

import Lesson5.POJO.Category;
import Lesson5.Services.CategoryService;
import Lesson5.Services.ProductService;
import Lesson5.Utils.RetrofitUtils;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class GetCategoryTest1 {
    static CategoryService categoryService;
    static ProductService productService;

    @BeforeAll
    static void bfa() {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);

    }

    @Test
    void getCategoryTest() throws IOException {
        Response <Category> response =
                categoryService.getCategory(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }


}
