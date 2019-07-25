package com.example.taskandroid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskandroid.ArticleActivity;
import com.example.taskandroid.Data.Article;
import com.example.taskandroid.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyviewHolder>
        {
            Context context;
            List<Article> news_list;

            public NewsAdapter(Context context, List<Article>news_list) {
                this.context = context;
                this.news_list = news_list;
            }

            @NonNull
            @Override
            public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater= LayoutInflater.from(context);
                View view= layoutInflater.inflate(R.layout.news_item,null,false);
                return new MyviewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull final MyviewHolder holder, int position) {
                final Article article=news_list.get(position);
                  holder.headlines.setText(article.getTitle());
                  holder.description.setText(article.getDescription());
                  holder.share_btn.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          Intent i = new Intent(Intent.ACTION_SEND);
                          i.putExtra(Intent.EXTRA_TEXT,"let's see what news .."+article.getTitle() + article.getDescription());
                          i.setType("text/plain");
                          context.startActivity(Intent.createChooser(i,"send to"));
                      }
                  });
                  Intent intent = new Intent(context, ArticleActivity.class);
                  intent.putExtra("author",article.getAuthor());
                  intent.putExtra("publish",article.getPublishedAt());
                  intent.putExtra("title",article.getTitle());
                  intent.putExtra("url",article.getUrl());
                  intent.putExtra("img", article.getUrlToImage());
                  intent.putExtra("description",article.getDescription());
                  context.startActivity(intent);


            }

            public void getNews(List<Article> articles)
            {
                this.news_list=articles;
                notifyDataSetChanged();
            }

            @Override
            public int getItemCount() {
                return news_list.size();
            }

            public static class MyviewHolder extends RecyclerView.ViewHolder{
                Context context;
//                @BindView(R.id.news_headlines)
//                TextView headlines;
//                @BindView(R.id.news_description)
//                TextView description;
//                @BindView(R.id.share_btn)
//                ImageButton shere_btn;
                TextView headlines , description;
                ImageButton share_btn;


                public MyviewHolder(@NonNull View itemView) {
                    super(itemView);
                   headlines=(TextView)itemView.findViewById(R.id.news_headlines);
                   description=(TextView)itemView.findViewById(R.id.news_description);
                   share_btn=(ImageButton)itemView.findViewById(R.id.share_btn);

                }
            }
        }
