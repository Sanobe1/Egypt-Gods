package com.egyptsgods.deity;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;     
    int[] gameState={2,2,2,2,2,2,2,2,2,2};
    int[] xarray={1,1,1,1,1,1,1,1,1};
    int[] yarray={1,1,1,1,1,1,1,1,1};

    public int checkWon(int[] arr)
    {
        if(((arr[0]==0)&&(arr[4]==0)&&(arr[8]==0))||((arr[2]==0)&&(arr[4]==0)&&(arr[6]==0))||((arr[0]==0)&&(arr[1]==0)&&(arr[2]==0))||((arr[3]==0)&&(arr[4]==0)&&(arr[5]==0))||((arr[6]==0)&&(arr[7]==0)&&(arr[8]==0))||((arr[0]==0)&&(arr[3]==0)&&(arr[6]==0))||((arr[1]==0)&&(arr[4]==0)&&(arr[7]==0))||((arr[2]==0)&&(arr[5]==0)&&(arr[8]==0)))
        {
            return 1;
        }
        else
            return 0;
    }

    @SuppressLint("SetTextI18n")
    public void drop(View view)
    {
        int flag=1;

        TextView finalText=(TextView)findViewById(R.id.tf);


        ImageView counter=(ImageView)view;
        int tagToRemove= Integer.parseInt(counter.getTag().toString());

        if(gameState[tagToRemove]==2){
            gameState[tagToRemove]=activePlayer;
            if((activePlayer==0)) {
                counter.setImageResource(R.drawable.el4);
                counter.animate().rotationBy(720f).alpha(1f).setDuration(2000);
                activePlayer=1;
                gameState[tagToRemove]=0;
                yarray[tagToRemove]=0;
                if(checkWon(yarray)==1) {
                    Toast.makeText(this, "Scarab player wins!", Toast.LENGTH_SHORT).show();
                    finalText.setText("The player with Scarab has won!");
                    showDialog();

                }

            }
            else {
                counter.setImageResource((R.drawable.el5));
                counter.animate().rotationBy(720f).alpha(1f).setDuration(2000);
                activePlayer=0;
                gameState[tagToRemove]=0;
                xarray[tagToRemove]=0;
                if (checkWon(xarray)==1) {
                    Toast.makeText(this, "Cross player wins!", Toast.LENGTH_SHORT).show();
                    finalText.setText("The player with Cross has won!");
                    showDialog();
                }
            }}
        else
        {
            for (int i=1;i<=8;i++)
            {
                if(gameState[i]!=0)
                { flag=0;break;}
            }
            if(flag==1)
            {finalText.setText("Draw!");
                showDialog();}


        }
    }

    public void showDialog()
    {
        LinearLayout finalScreen=(LinearLayout)findViewById(R.id.linearLayout);
        finalScreen.setVisibility(View.VISIBLE);
    }



    public void btnGoToMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Player with Scarab starts First!", Toast.LENGTH_SHORT).show();
    }
}
