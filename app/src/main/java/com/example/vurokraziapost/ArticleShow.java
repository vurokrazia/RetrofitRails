package com.example.vurokraziapost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ArticleShow extends AppCompatActivity {
    TextView title, body, author;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_show);
        title = (TextView) findViewById(R.id.title);
        body = (TextView) findViewById(R.id.body);
        author = (TextView) findViewById(R.id.author);
        imageView = (ImageView) findViewById(R.id.image);
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            setToolbar(extras.getString("title"));
            body.setText(extras.getString("body"));
            author.setText("Autor: " + extras.getString("author") + "\nE-mail:" + extras.getString("email"));
            Picasso.with(getApplicationContext()).load(extras.getString("image")).into(imageView);
        }
    }
    private void setToolbar(String text) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView toolbar_title = findViewById(R.id.toolbar_title);
        if (text.length() > 20) {
            title.setText(text);
            toolbar_title.setText(text.substring(0, 20) + "...");
        }else {
            title.setVisibility(View.GONE);
            toolbar_title.setText(text);
        }
    }
}
