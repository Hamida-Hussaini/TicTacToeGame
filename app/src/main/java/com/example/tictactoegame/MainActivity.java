package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true ;
    boolean win=false;

    // player representation
    //0 - x
    //1 - o
    int activePlayer=0;
    int[] gameState={2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 };
    // state meanings
    // 0 - x
    // 1 - o
    // 2 - null
    int[][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                          {0,3,6},{1,4,7},{2,5,8},
                          {0,4,8},{2,4,6}};

    public  void playerTab(View view)
    {
        ImageView img=(ImageView) view;
        int tabbedImg=Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            resetGame(view);
        }
        if(gameState[tabbedImg]==2)
        {
            gameState[tabbedImg]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.o);
                activePlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);

        }
        for(int[] winPosition:winPositions)
        {
            if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]]!=2)
            {
                String winnerString;
                gameActive=false;
                if(gameState[winPosition[0]]==0)
                {
                    winnerString="O has won";
                }
                else
                {
                    winnerString="X has won";
                }

                TextView status=findViewById(R.id.status);
                status.setText(winnerString);


            }

        }

            if(gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 && gameState[7]!=2 && gameState[8]!=2)
            {
                TextView status=findViewById(R.id.status);
                status.setText("Tab to play again no one win..");
            }


    }

    public  void resetGame(View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status=findViewById(R.id.status);
        status.setText("O's Turn - Tap to play");

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}