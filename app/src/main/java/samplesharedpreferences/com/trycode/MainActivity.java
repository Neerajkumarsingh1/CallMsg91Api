package samplesharedpreferences.com.trycode;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText name,email,mobile,pass;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.username);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        pass=findViewById(R.id.password);
        b1=findViewById(R.id.signUp);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Gson gson = new GsonBuilder().setLenient().create();

                Retrofit retrofit= new Retrofit.Builder()
                        .baseUrl("http://api.msg91.com/api/")
                        .addConverterFactory(GsonConverterFactory.create(gson)).build();

                SendOtpSingup otpSingup = retrofit.create(SendOtpSingup.class);

                Call<String> call = otpSingup.reposForUser("MSGIND", "4", "7987001717", "",91, "Your Otp is 911701");
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(MainActivity.this,response.body(),Toast.LENGTH_LONG).show();



                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();



                    }
                });







/*
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://api.msg91.com/api/")
                            .client()
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();*/

                 //   Retrofit retrofit = builder.build();






               /* call.enqueue(new Callback<List<SendOtpSingup>>() {
                    @Override
                    public void onResponse(Call<List<SendOtpSingup>> call, Response<List<SendOtpSingup>> response) {
                      TextView textView= (TextView) response.body();
                      textView.setText((CharSequence) new SendOtpAdapter(MainActivity.this,textView));

                    }

                    @Override
                    public void onFailure(Call<List<SendOtpSingup>> call, Throwable t) {

                        Toast.makeText(MainActivity.this,"NoInterNet",Toast.LENGTH_SHORT).show();

                    }
                });*/

      //          Intent Intent = new Intent(MainActivity.this, SendOtpAdapter.class);
//                startActivity(Intent);


            }
        });

    }
}
