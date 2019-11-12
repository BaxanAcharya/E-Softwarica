package com.biplav.e_softwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biplav.e_softwarica.models.User;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etuser;
    private EditText etpass;
    private Button btnlogin;
    static List<User> users = new ArrayList<>();
    final User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etuser = findViewById(R.id.etuser);
        etpass = findViewById(R.id.etpass);
        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ;
        user.setUsername("Biplab");
        user.setPassword("170039");
        users.add(user);
        user.setUserList(users);
        if (TextUtils.isEmpty(etuser.getText().toString())) {
            etuser.setError("please enter username");
        } else if (TextUtils.isEmpty(etpass.getText().toString())) {
            etpass.setError("please enter password");
        }else {
            String username=etuser.getText().toString().trim();
            String password=etpass.getText().toString().trim();

            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            Boolean status=user.userLogin();
            if(status){
                Intent intent=new Intent(this, DashboardActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Username or password dont match", Toast.LENGTH_SHORT).show();
                etuser.setText("");
                etpass.setText("");
            }

        }
    }

}
