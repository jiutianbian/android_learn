package jiutianbian.com.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.map.baidu.com/")
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<POWeather> weather = service.getWeather("广州","JSON","FK9mkfdQsloEngodbFl4FeY3");

        weather.enqueue(new Callback<POWeather>() {
            @Override
            public void onResponse(Call<POWeather> call, Response<POWeather> response) {
                Log.e("test",response.body().getMessage());
            }

            @Override
            public void onFailure(Call<POWeather> call, Throwable t) {

            }
        });
    }
}
