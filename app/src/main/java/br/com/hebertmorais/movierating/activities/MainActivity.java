package br.com.hebertmorais.movierating.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import br.com.hebertmorais.movierating.R;

public class MainActivity extends AppCompatActivity {

    private SliderLayout mSliderShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSliderShow = (SliderLayout) findViewById(R.id.slider);

        /*TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        mSliderShow.addSlider(textSliderView);*/



    }

    @Override
    protected void onStop() {
        mSliderShow.stopAutoCycle();
        super.onStop();
    }
}
