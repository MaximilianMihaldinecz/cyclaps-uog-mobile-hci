package org.cyclaps.cyclaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class setting extends AppCompatActivity {

    private Button btn_cancel = null;
    private Button btn_username = null;
    private Button btn_password = null;

    private class myclickEvent implements View.OnClickListener{

        private String flag = null;

        private myclickEvent(String name){
            this.flag = name;
        }
        @Override
        public void onClick(View v) {
            if(this.flag=="cancel") {
                startActivity(new Intent(setting.this, homeScreen.class));
            }
            else if (this.flag=="username"){
                startActivity(new Intent(setting.this, username.class));
            }
            else if(this.flag=="password"){
                startActivity(new Intent(setting.this, password.class));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_setting);
        getSupportActionBar().hide();
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new myclickEvent("cancel"));
        btn_username = (Button)findViewById(R.id.btn_username);
        btn_username.setOnClickListener(new myclickEvent(("username")));
        btn_password = (Button)findViewById(R.id.btn_password);
        btn_password.setOnClickListener(new myclickEvent("password"));
    }
}
