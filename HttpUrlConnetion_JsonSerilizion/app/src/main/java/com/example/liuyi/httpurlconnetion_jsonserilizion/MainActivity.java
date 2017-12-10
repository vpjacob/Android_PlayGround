package com.example.liuyi.httpurlconnetion_jsonserilizion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView responseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.send_request){
        sendRequestWithHttpUrlConnection();
        }
    }

    private void sendRequestWithHttpUrlConnection(){

        new Thread(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(MainActivity.this,"try",Toast.LENGTH_SHORT).show();

                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://192.168.1.199:9020/xk/appStartImg.do");
//                    URL url = new URL("http://api.dantangapp.com/v1/search/item?keyword=%E6%88%92%E6%8C%87&limit=20&offset=0&sort=");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    showResponse(response.toString());
//                    parseJsonWithJSONObject(response.toString());
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    if (reader != null){
                        try {
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }

    private  void parseJsonWithJSONObject (final String jsonData){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject = new JSONObject(jsonData);
                    JSONArray array = jsonObject.getJSONArray("data");
                    JSONObject arrayObject = array.getJSONObject(0);
                    String str = arrayObject.getString("imgUrl");
                    String allUrl = "http://192.168.1.199:8080" + str;
                    showResponse(allUrl);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


    }

    private void showResponse (final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }

}
