package com.example.vurokraziapost;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by jmartinez on 11/02/18.
 */

public class ArticleHolder  extends RecyclerView.ViewHolder{
    TextView titleview, bodyview;
    ImageView img;
    Context context;
    public ArticleHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        titleview = (TextView) itemView.findViewById(R.id.item_title);
        bodyview = (TextView) itemView.findViewById(R.id.item_body);
        img = (ImageView) itemView.findViewById(R.id.item_image);
    }

    public void bind(final String imagen, final String title, final String body, final ArticlesAdapter.onItemclickListener itemclickListener) {

        this.titleview.setText(title);
        this.bodyview.setText(maxlengt(body));
        Picasso.with(context).load(imagen).into(img);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemclickListener.onItemClick(imagen,title,body,getAdapterPosition());
            }
        });
    }
    private String maxlengt(String text){
        if (text.length() > 50){
            text = text.substring(0, 50) + "...";
        }
        return text;
    }
}
