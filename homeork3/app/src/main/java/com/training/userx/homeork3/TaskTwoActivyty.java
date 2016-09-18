package com.training.userx.homeork3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by UserX on 18.9.2016 г..
 */
public class TaskTwoActivyty extends AppCompatActivity implements View.OnClickListener {

Fragment3 fr3 = new Fragment3();
Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.task_two_layout);
          back =(Button)findViewById(R.id.back);
        back.setOnClickListener( this );
       addFragment();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent firtTask = new Intent(TaskTwoActivyty.this,MainActivity.class);


        if (item.getItemId() == R.id.switch_tasks) {
            startActivity(firtTask);
        }
        return  true;
    }
private void addFragment(){
    getFragmentManager().beginTransaction().replace(R.id.conteinerTwo,fr3 ).commit();
}
    @Override
    public void onClick(View v) {
   if (v.getId()==R.id.back){
      addFragment();
    }


    }
}
