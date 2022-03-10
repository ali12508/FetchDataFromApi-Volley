package com.chat.fetchdatafromapi_volley;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private Context context;
    private List movieList;

    public MovieAdapter(Context context , List movies){
        this.context = context;
        movieList = movies;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list , parent , false);
        return new MovieHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Movie movie = (Movie) movieList.get(position);
        holder.rating.setText(movie.getRating().toString());
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        Glide.with(context).load(movie.getPoster()).into(holder.imageView);

        holder.clayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DeatailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title" , movie.getTitle());
                bundle.putString("overview" , movie.getOverview());
                bundle.putString("poster" , movie.getPoster());
                bundle.putDouble("rating" , movie.getRating());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{

   CircleImageView imageView;
        TextView title , overview , rating;
      RelativeLayout clayout;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
             clayout=itemView.findViewById(R.id.rlayout);
            imageView = itemView.findViewById(R.id.testimg);
            title = itemView.findViewById(R.id.title_tv);
            overview = itemView.findViewById(R.id.overview);
            rating = itemView.findViewById(R.id.rating);
            clayout = itemView.findViewById(R.id.rlayout);
        }
    }
}