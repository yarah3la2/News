package com.example.taskandroid;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        getIncomingIntent();
    }

    private void getIncomingIntent()
    {
        if (getIntent().hasExtra("auther")&&getIntent().hasExtra("publish")&&getIntent().hasExtra("title")&&getIntent().hasExtra("url")&&getIntent().hasExtra("img")&&getIntent().hasExtra("description"))
        {
             String auther=getIntent().getStringExtra("auther");
            String publish=getIntent().getStringExtra("publish");
            String title=getIntent().getStringExtra("title");
            String url=getIntent().getStringExtra("url");
            String img=getIntent().getStringExtra("img");
            String description=getIntent().getStringExtra("description");
            setContent(auther,publish,title,url,img,description);
        }
    }

    private void setContent(String auther,String publish,String title,String url,String img,String description)
    {
        TextView auther_txt=(TextView)findViewById(R.id.auther);
        auther_txt.setText(auther);
        TextView publish_txt=(TextView)findViewById(R.id. publish);
        auther_txt.setText( publish);
        TextView title_txt=(TextView)findViewById(R.id.title);
        auther_txt.setText(title);
        TextView url_txt=(TextView)findViewById(R.id.url);
        auther_txt.setText(url);
        TextView description_txt=(TextView)findViewById(R.id.description);
        auther_txt.setText(description);
        ImageView image=(ImageView)findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(img)
                .into(image);

    }
}
