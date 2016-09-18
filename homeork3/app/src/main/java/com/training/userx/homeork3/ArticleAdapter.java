package com.training.userx.homeork3;
import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by UserX on 18.9.2016 г..
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHodler> {
Context context;
    ClickListener clickListener;
    private  LayoutInflater infalter;
    private List<Article> data = Collections.emptyList();
   FragmentTwo frTwo ;
    FragmentOne fr ;

    class MyViewHodler extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView text;
        ImageView image;
        TextView content;


        public MyViewHodler(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            text = (TextView) itemView.findViewById(R.id.listText);
            image = (ImageView) itemView.findViewById(R.id.listIcon);
            content= (TextView) itemView.findViewById(R.id.content);
        }

        @Override
        public void onClick(View view) {


           if (!frTwo.isAdded()){
            fr.getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,frTwo).commit();}
           if (frTwo.title!=null)
            frTwo.title.setText( text.getText().toString() );
            if (frTwo.content!=null)
                frTwo.content.setText( content.getText().toString() );
            if (frTwo.image!=null){

                frTwo.image.setImageResource(data.get( getLayoutPosition() ).iconId);
            }
        }
    }
    public ArticleAdapter(FragmentOne fr, List<Article> data){
this.fr=fr;
        this.data=data;
        frTwo=new FragmentTwo();

    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.article,parent,false);
        MyViewHodler holder = new MyViewHodler(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
             Article current = data.get(position);
          holder.text.setText(current.title);
        holder.image.setImageResource(current.iconId);
        holder.content.setText(current.content);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    interface ClickListener{
         void itemClicked(View view,int position);
    }
    public void setClickListener(ClickListener listener){
        this.clickListener = listener;
    }

}
