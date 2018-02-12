package com.example.vurokraziapost;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jmartinez on 11/02/18.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticleHolder> {
    private  int layout;
    List<String> titlelist;
    List<String> bodylist;
    List<String> imagelist;
    private onItemclickListener itemclickListener;


    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        holder.bind(imagelist.get(position),titlelist.get(position),bodylist.get(position),itemclickListener);
    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public interface onItemclickListener{
        void onItemClick(String imagen,String title, String body, int position);
    }

    public ArticlesAdapter(int layout, List<String> titlelist, List<String> bodylist, List<String> imagelist, onItemclickListener itemclickListener) {
        this.layout = layout;
        this.titlelist = titlelist;
        this.bodylist = bodylist;
        this.imagelist = imagelist;
        this.itemclickListener = itemclickListener;
    }
}
