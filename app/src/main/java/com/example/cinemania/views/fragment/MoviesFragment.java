package com.example.cinemania.views.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.example.cinemania.R;
import com.example.cinemania.data.model.Movies;
import com.example.cinemania.presenter.MoviePresenter;
import com.example.cinemania.views.MoviesView;
import com.example.cinemania.views.adapters.MoviesAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesFragment  extends Fragment implements MoviesView{
    private MoviesAdapter moviesAdapter;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    MoviePresenter moviePresenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list,container,false);
        moviePresenter = new MoviePresenter(this);
        moviePresenter.getMovies();

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater  inflater) {
        inflater.inflate(R.menu.menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_buscar);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                moviesAdapter.getFilter().filter(s);
                return false;
            }
        });
    }

    @Override
    public void moviesReady(ArrayList<Movies> movies) {

        for(Movies movie : movies){
            stringArrayList.add(moviePresenter.moviePathUrl(movie.getPoster_path()));
        }
        moviesAdapter = new MoviesAdapter(getContext(),stringArrayList,movies);
        recyclerView.setAdapter(moviesAdapter);
    }



}
