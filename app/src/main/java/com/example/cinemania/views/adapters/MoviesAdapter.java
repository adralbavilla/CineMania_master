package com.example.cinemania.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.Constraints;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cinemania.R;
import com.example.cinemania.data.model.Movies;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Movies> mMovies;
    private ArrayList<Movies> mMoviesFull;
    private ArrayList<String> mimageUrls;
    private Context mContext;

    public MoviesAdapter(Context context,ArrayList<String> imageUrls,ArrayList<Movies> movies) {
        mContext = context;
        mimageUrls = imageUrls;
        mMovies =movies;
        mMoviesFull = new ArrayList<>(movies);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.titleMovie.setText(mMovies.get(i).getTitle());
        Picasso.get()
                .load(mimageUrls.get(i))
                .fit()
                .centerCrop()
                .into(myViewHolder.imgMovie);

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter(){
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           List<Movies> filteredList = new ArrayList<>();

           if(constraint == null || constraint.length() == 0 ){
                filteredList.addAll(mMoviesFull);
           }else{
               String filterPattern = constraint.toString().toLowerCase().trim();

               for(Movies movie : mMoviesFull){
                   if(movie.getTitle().toLowerCase().contains(filterPattern)){
                       filteredList.add(movie);
                   }
               }
           }

            FilterResults results = new FilterResults();
           results.values = filteredList;

           return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mMovies.clear();
            mMovies.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.movie_poster)
        ImageView imgMovie;
        @BindView(R.id.titleMovie)
        TextView titleMovie;


        public MyViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
