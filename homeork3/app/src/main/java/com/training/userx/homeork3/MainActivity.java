package com.training.userx.homeork3;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 ArticleAdapter articleAdapter;
  FragmentTwo fragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent firtTask = new Intent(MainActivity.this,TaskTwoActivyty.class);


        if (item.getItemId() == R.id.switch_tasks) {
            startActivity(firtTask);
        }
        return  true;
    }
}
