package com.joe.getdatos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {
private TextView tv_imprimir;
private Button btn_traer;

private RequestQueue queue;
private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_imprimir = findViewById(R.id.tv_imprimir);
        btn_traer = findViewById(R.id.btn_traer);

        queue = Volley.newRequestQueue(this);
        url = "http://192.168.43.116:3000/Posts/";

        btn_traer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Aqui", Toast.LENGTH_SHORT);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tv_imprimir.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    tv_imprimir.setText(error.getMessage().toString());
                    }
                });
                queue.add(stringRequest);
            }
        });
    }
}
