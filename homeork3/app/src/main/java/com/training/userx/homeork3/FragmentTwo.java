package com.training.userx.homeork3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by UserX on 18.9.2016 г..
 */
public class FragmentTwo extends Fragment {

  TextView title , content;
    ImageView image;


    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout=inflater.inflate(R.layout.fragment_two_layout, container, false);
         title = (TextView) layout.findViewById( R.id.textView );
          content = (TextView) layout.findViewById( R.id.textView2 );
         image = (ImageView) layout.findViewById( R.id.imageView);
        return layout;
    }





}
