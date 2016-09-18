package com.training.userx.homeork3;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by UserX on 18.9.2016 г..
 */
public class FragmentOne extends Fragment implements ArticleAdapter.ClickListener {

    public RecyclerView recyclerView;
   public ArticleAdapter articleAdapter;
    private ArrayList<Article> data= new ArrayList<>();
   FragmentTwo fragmentTwo;
    private  void getData(){

        int[] images={R.drawable.icon2,R.drawable.icon3,R.drawable.icon4,R.drawable.icon5};
        for (int i = 0; i <30 ; i++) {
            Article art = new Article();
            art.iconId=images[i%4];
            art.title = "Title"+i;
            art.content="This is article no"+i+" content";
            data.add(art);
        }

    }


    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
   getData();
     View layout=inflater.inflate(R.layout.fragment_one_layout, container, false);
        recyclerView= (RecyclerView) layout.findViewById(R.id.drawerSide);
        articleAdapter = new ArticleAdapter(this,data);
        articleAdapter.setClickListener(this);
        recyclerView.setAdapter(articleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fragmentTwo = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragmentTwo);
        return layout;
    }


    @Override
    public void itemClicked(View view, int position) {
if (fragmentTwo !=null){
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer,fragmentTwo).commit();
    Toast.makeText(getActivity(), "clicked", Toast.LENGTH_LONG).show();
        }
    }

}
