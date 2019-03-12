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

public class password extends AppCompatActivity {

    private Button btn_cancel = null;
    private Button btn_submit = null;

    private class myclickEvent implements View.OnClickListener{
        private String flag = null;
        private myclickEvent(String name){
            this.flag = name;
        }
        @Override
        public void onClick(View v) {
            if(this.flag=="cancel") {
                startActivity(new Intent(password.this, homeScreen.class));
            }
            if(this.flag=="submit") {
                startActivity(new Intent(password.this, homeScreen.class));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_setting_password);
        getSupportActionBar().hide();
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new myclickEvent("cancel"));
        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new myclickEvent("submit"));
    }
}
