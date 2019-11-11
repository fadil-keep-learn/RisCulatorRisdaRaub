package com.riscu.risculatorrisdaraub;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

interface TodoService {
    @GET("select.php")
    Call<List<SelectPhp>> getTodo();
}

public class MainActivity extends AppCompatActivity {

    Button btnn;
    EditText et2, et3, et4;
    TextView tv ,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        TextView textViewdate = findViewById(R.id.txtDate);
        textViewdate.setText(currentDate);


        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);

        btnn = findViewById(R.id.button2);

        tv = findViewById(R.id.textView12);
        tv2 = findViewById(R.id.textView13);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://risculatorapps.000webhostapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService service = retrofit.create(TodoService.class);

        Call<List<SelectPhp>> repos = service.getTodo();
        repos.enqueue(new Callback<List<SelectPhp>>() {
            @Override
            public void onResponse(Call<List<SelectPhp>> call, Response<List<SelectPhp>> response) {
                // Handle success
                List<SelectPhp> myItem = response.body();
                et2.setText(myItem.get(0).getHargaSemasa());
                tv2.setText(myItem.get(0).getTrksemasa());
            }

            @Override
            public void onFailure(Call<List<SelectPhp>> call, Throwable t) {
                //Handle failure
            }
        });

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float percentage = Float.parseFloat(et2.getText().toString());

                float percentage2 = Float.parseFloat(et3.getText().toString());
                float sum = percentage - percentage2;
                float dec = sum / 100;
                float total = dec * Float.parseFloat(et4.getText().toString());
                tv.setText(Float.toString(total));
            }
        });

    }
}