package me.satyabrat.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.satyabrat.popularmovies.model.Movie;

import static me.satyabrat.popularmovies.MainActivity.IMG_BASE_URL;

/**
 * Created by princ on 5/7/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MyViewHolder> {

    List<Movie.ResultsBean> results;

    public MovieAdapter(List<Movie.ResultsBean> results) {
        this.results = results;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_movie, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.title.setText(results.get(position).getOriginal_title());
        String imageUrl = IMG_BASE_URL + results.get(position).getPoster_path();
        Picasso.with(holder.poster.getContext()).load(imageUrl).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView poster;
        public TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.list_movie_item_poster);
            title = (TextView) itemView.findViewById(R.id.list_movie_item_title);
        }
    }
}
