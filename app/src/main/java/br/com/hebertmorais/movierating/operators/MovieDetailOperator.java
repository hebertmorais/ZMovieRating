package br.com.hebertmorais.movierating.operators;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.squareup.picasso.Picasso;

import br.com.hebertmorais.movierating.R;
import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 28/04/16.
 */
public class MovieDetailOperator {

    private static void setZoomImageMetrics(PullToZoomScrollViewEx scrollView){
        Context context = scrollView.getContext();
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);

    }

    private static void setViews(PullToZoomScrollViewEx scrollView){
        Context context = scrollView.getContext();
        View headView = LayoutInflater.from(context).inflate(R.layout.movie_head_view, null, false);
        View zoomView = LayoutInflater.from(context).inflate(R.layout.movie_zoom_view, null, false);
        View contentView = LayoutInflater.from(context).inflate(R.layout.movie_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
    }

    public static void initZoomScrollView(PullToZoomScrollViewEx scrollViewEx){
        setZoomImageMetrics(scrollViewEx);
        setViews(scrollViewEx);
    }

    public static void bindMovieToView(Movie movie, PullToZoomScrollViewEx scrollView) {
        Context context = scrollView.getContext();
        ImageView bannerImageView = (ImageView) scrollView.findViewById(R.id.zoom_imageView);
        Picasso.with(context).load(movie.getBannerUrl()).centerCrop().fit().into(bannerImageView);
        TextView titleTextView = (TextView) scrollView.findViewById(R.id.title_textView);
        titleTextView.setText(movie.getTitle());
        TextView descriptionTextView = (TextView) scrollView.findViewById(R.id.description_textView);
        descriptionTextView.setText(movie.getDescription());
    }

    public static void favoriteListener(final ImageView heart, final Movie movie){
        final Context context = heart.getContext();

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movie.isFavorite()) {
                    heart.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_border_white_24dp));
                    movie.setIsFavorite(false);
                }else{
                    heart.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_white_24dp));
                    movie.setIsFavorite(true);

                }

            }
        });



    }
}
