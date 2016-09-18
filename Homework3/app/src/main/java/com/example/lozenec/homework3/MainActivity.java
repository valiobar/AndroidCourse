package com.example.lozenec.homework3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IRecycleViewSelected {
    TextView mTextView;
    Context mCtx;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mBtnInsertData;
    private ArrayList<String> data;


    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<String>();

        for (int index = 0; index < 30; index++) {
            data.add(index, String.valueOf(index));
        }



        // use a linear layout manager





    }


    ItemTouchHelper mIth = new ItemTouchHelper(
            new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                    ItemTouchHelper.RIGHT) {

                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    int elementPosition = viewHolder.getAdapterPosition();

                    data.remove(elementPosition);

                    mAdapter.notifyItemRemoved(elementPosition);
                }


            });

    @Override
    public void onItemSelected(int position) {
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_LONG).show();
    }
}
