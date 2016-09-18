package com.training.userx.homeork3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by UserX on 18.9.2016 г..
 */
public class Fragment3 extends Fragment implements View.OnClickListener {
    Button btn1 ,btn2;
    FragmentTwo fr2 = new FragmentTwo();
    FragmentOne fr1 = new FragmentOne();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_3_layout, container, false);
       btn1= (Button) layout.findViewById( R.id.button );
        btn2 = (Button) layout.findViewById( R.id.button2 );
        btn1.setOnClickListener( this );
        btn2.setOnClickListener( this );
        return layout;
    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.button){
            getFragmentManager().beginTransaction().replace(R.id.conteinerTwo,fr1 ).commit();
            getFragmentManager().beginTransaction().remove(this ).commit();
        }
        if (v.getId()==R.id.button2){
            getFragmentManager().beginTransaction().replace(R.id.conteinerTwo,fr2 ).commit();
        }
    }
}
