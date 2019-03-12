package org.cyclaps.cyclaps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
    public void Register(View view){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void login(View view){
        Intent intent=new Intent(this, GuideActivity.class);
        startActivity(intent);
    }
    }
