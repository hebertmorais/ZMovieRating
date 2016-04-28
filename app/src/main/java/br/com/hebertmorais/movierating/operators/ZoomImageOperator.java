package br.com.hebertmorais.movierating.operators;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

import br.com.hebertmorais.movierating.R;

/**
 * Created by Lucas on 28/04/16.
 */
public class ZoomImageOperator {

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
}
