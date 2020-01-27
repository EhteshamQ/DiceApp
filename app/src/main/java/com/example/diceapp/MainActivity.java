package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button rolldice;
    private ImageView imageView;
   final int images[]={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rolldice=findViewById(R.id.RollDice);
        rolldice.setOnClickListener(this);
        imageView =findViewById(R.id.image);
        getSupportActionBar().hide();
        mediaPlayer=MediaPlayer.create(this,R.raw.dicesound);
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.start();
        Random random=new Random();
        int randomnumber=random.nextInt(6);//leaving 7
        imageView.setImageResource(images[randomnumber]);
        YoYo.with(Techniques.Tada)
                .duration(400)
                .repeat(0)
                .playOn(findViewById(R.id.image));

        Log.i("APP","The Number is "+randomnumber);

    }
}
