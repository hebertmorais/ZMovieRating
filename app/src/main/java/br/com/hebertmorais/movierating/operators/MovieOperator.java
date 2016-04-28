package br.com.hebertmorais.movierating.operators;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

import br.com.hebertmorais.movierating.activities.MovieDetail;
import br.com.hebertmorais.movierating.entities.Movie;

/**
 * Created by Lucas on 27/04/16.
 */
public class MovieOperator implements MovieOperatorsInterface {

    public static final String MOVIE_EXTRA = "movie";
    private List<Movie> movies;

    public MovieOperator(){
        this.movies = moviesCreator();
    }

    private List<Movie> moviesCreator() {

        ArrayList<Movie> response = new ArrayList<>();
        Movie movie1 = new Movie("Game of Thrones",
                                "Ned Stark, Lord of Winterfell, becomes the Hand of the King after the former Hand, Jon Arryn, has passed away. But before Ned goes to the capital, King's Landing, a letter arrives from his wife's sister Lysa, who was the wife of Jon Arryn. There it says that her husband was murdered, and it is up to Ned to find out what's going on. But that isn't everything. The White Walkers have been seen, and they seem to go down south",
                                "https://static.omelete.uol.com.br/media/extras/conteudos/gameofthrones_logo_mQkVfzJ_Tpf2KK9.jpg");

        Movie movie2 = new Movie("Breaking Bad",
                                "When chemistry teacher Walter White is diagnosed with Stage III cancer and given only two years to live, he decides he has nothing to lose. He lives with his teenage son, who has cerebral palsy, and his wife, in New Mexico. Determined to ensure that his family will have a secure future, Walt embarks on a career of drugs and crime. He proves to be remarkably proficient in this new world as he begins manufacturing and selling methamphetamine with one of his former students. The series tracks the impacts of a fatal diagnosis on a regular, hard working man, and explores how a fatal diagnosis affects his morality and transforms him into a major player of the drug trade. ",
                                "http://2.bp.blogspot.com/-Mfpl-9MdFmk/Vd44vG0OBEI/AAAAAAAAHHk/KFOs_dJLfZg/s620/Breaking-Bad-Season-5.jpg");

        Movie movie3 = new Movie("House MD",
                                "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House with only half a muscle in his right leg. He and his team of medical doctors try to cure very ill ordinary people in the United States of America.",
                                "http://i.onionstatic.com/avclub/5024/33/16x9/960.jpg");

        Movie movie4 = new Movie("Sons of Anarchy",
                                "Sons of Anarchy, aka SAMCRO, is a motorcycle club that operates both illegal and legal businesses in the small town of Charming. They combine gun-running and a garage, plus involvement in porn film. Clay, the president, likes it old school and violent; while Jax, his stepson and the club's VP, has thoughts about changing the way things are, based on his dead father's journal. Their conflict has effects on both the club and their personal relationships.",
                                "http://www.cutthecap.com/wp-content/uploads/2014/10/2684i59B5472A67FEB352.jpg");

        Movie movie5 = new Movie("Vikings",
                                "The adventures of Ragnar Lothbrok: the greatest hero of his age. The series tells the saga of Ragnar's band of Viking brothers and his family as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods: legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                                "https://static.hbonordic.com/1f10ced-0049c77cbf7/HBON-AAGBK-000-PGM-01-01-2500-HD-169-SR-1920x1080-50-6228414.jpg");

        Movie movie6 = new Movie("The Walking Dead",
                                "Rick Grimes is a former Sheriff's deputy who has been in a coma for several months after being shot while on duty. When he awakens he discovers that the world has been ravished by a zombie epidemic of apocalyptic proportions, and that he seems to be the only person still alive. After returning home to discover his wife and son missing, he heads for Atlanta to search for his family. Narrowly escaping death at the hands of the zombies on arrival in Atlanta he is aided by another survivor, Glenn, who takes Rick to a camp outside the town. There Rick finds his wife Lori and his son, Carl, along with his partner/best friend Shane and a small group of survivors who struggle to fend off the zombie hordes; as well as competing with other surviving groups who are prepared to do whatever it takes to survive in this harsh new world.",
                                "http://www.wallpapertycoon.com/download/4236/2016/02/the_walking_dead_s01e02_games_wallpaper-960x540.jpg/");

        Movie movie7 = new Movie("Friends",
                                "Friends Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are all friends, living off of one another in the heart of New York City. Over the course of ten years, this average group of buddies goes through massive mayhem, family trouble, past and future romances, fights, laughs, tears and surprises as they learn what it really means to be a friend.",
                                "http://static.omelete.uol.com.br/media/extras/conteudos/0aa3afb3cbe3468fc6e43e50070b0810_HQi5OtO.png");

        response.add(movie1);
        response.add(movie2);
        response.add(movie3);
        response.add(movie4);
        response.add(movie5);
        response.add(movie6);
        response.add(movie7);

        return response;
    }

    public void bindMoviesToSlider(SliderLayout slider, List<Movie> movies) {

        for ( Movie m : movies){
            TextSliderView textSliderView = new TextSliderView(slider.getContext());
            textSliderView
                    .description(m.getTitle())
                    .image(m.getBannerUrl());

            slider.addSlider(textSliderView);
        }

    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void addImagesToSlider(SliderLayout slider){
        bindMoviesToSlider(slider, getMovies());
    }

    @Override
    public void addMoviesToListView(ListView moviesListView) {
        final Context context = moviesListView.getContext();
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, getMoviesTitles(getMovies()));
        moviesListView.setAdapter(itemsAdapter);

        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, MovieDetail.class);
                i.putExtra(MOVIE_EXTRA, getMovies().get(position));
                context.startActivity(i);
            }
        });
    }

    private List<String> getMoviesTitles(List<Movie> movies){
        ArrayList<String> response = new ArrayList<>();

        for (Movie m: movies){
            response.add(m.getTitle());
        }

        return response;
    }
}
