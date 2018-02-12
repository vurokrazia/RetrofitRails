package com.example.vurokraziapost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vurokraziapost.Pojo.Article;
import com.example.vurokraziapost.Services.API;
import com.example.vurokraziapost.Services.RailsResponse;
import com.example.vurokraziapost.Services.WebServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    //List<RailsResponse> rails;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    Article article;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        article = new Article();
        setToolbar("Inicio");
        PeticionServer();
    }
    private void PeticionServer(){
        Retrofit retrofit = API.getApi();
        WebServices notices = retrofit.create(WebServices.class);
        Call<List<RailsResponse>> noticeCall = notices.allparse();
        noticeCall.enqueue(new Callback<List<RailsResponse>>() {
            @Override
            public void onResponse(Call<List<RailsResponse>> call, Response<List<RailsResponse>> response) {
                if(response.isSuccessful()) {
                    AddArticles(response.body());
                    adapter = new ArticlesAdapter(R.layout.item_article, article.getTitlelist(), article.getBodylist(), article.getImagelist(), new ArticlesAdapter.onItemclickListener() {
                        @Override
                        public void onItemClick(String imagen, String title, String body, int position) {
                            Intent intent = new Intent(MainActivity.this,ArticleShow.class);
                            intent.putExtra("title",title);
                            intent.putExtra("image",imagen);
                            intent.putExtra("body",body);
                            intent.putExtra("author",article.getAuthorlist().get(position));
                            intent.putExtra("email",article.getEmail().get(position));
                            startActivity(intent);
                        }
                    });
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, response.errorBody().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<RailsResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void AddArticles(List<RailsResponse> response) {
        for (int i = 0; i<response.size();i++){
            article.setIdlist(response.get(i).getId());
            article.setTitlelist(response.get(i).getTitle());
            article.setBodylist(response.get(i).getBody());
            article.setImagelist(response.get(i).getResource());
            article.setAuthorlist(response.get(i).getUser().getName());
            article.setUseridlist(response.get(i).getUser().getId());
            article.setHobbylist(response.get(i).getUser().getHobby());
            article.setEmail(response.get(i).getUser().getEmail());
        }
    }

    private void setToolbar(String text) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_title.setText(text);
    }
}
