package com.example.tic_tac_toe3x3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<int[]> combinations = new ArrayList<int[]>();

    private int [] boxPositions = {0,0,0,0,0,0,0,0,0};
    int flag = 1;
    int playerTurn = 0;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    LinearLayout player1layout, player2layout;
    TextView player1name, player2name;
    int totalboxesselected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        // Retrieving names from the previous intent
        String player_1 = getIntent().getStringExtra("PlayerOne");
        String player_2 = getIntent().getStringExtra("PlayerTwo");
        player1name.setText(player_1);
        player2name.setText(player_2);

        combinations.add(new int[]{0,1,2});
        combinations.add(new int[]{3,4,5});
        combinations.add(new int[]{6,7,8});
        combinations.add(new int[]{0,3,6});
        combinations.add(new int[]{1,4,7});
        combinations.add(new int[]{2,5,8});
        combinations.add(new int[]{0,4,8});
        combinations.add(new int[]{2,4,6});

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(0)){
                    performAction(image1, 0);
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(1)){
                    performAction(image2, 1);
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(2)){
                    performAction(image3, 2);
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(3)){
                    performAction(image4, 3);
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(4)){
                    performAction(image5, 4);
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(5)){
                    performAction(image6, 5);
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(6)){
                    performAction(image7, 6);
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(7)){
                    performAction(image8, 7);
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isboxselectable(8)){
                    performAction(image9, 8);
                }
            }
        });
    }

    public void init(){
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        player1layout = findViewById(R.id.player1layout);
        player2layout = findViewById(R.id.player2layout);
        player1name = findViewById(R.id.player1name);
        player2name = findViewById(R.id.player2name);
    }

    public boolean checkWin(){
        for (int[] combination: combinations){
            if (boxPositions[combination[0]]==boxPositions[combination[1]] && boxPositions[combination[2]]==boxPositions[combination[1]] && boxPositions[combination[1]]!=0)
                return true;
        }
        return false;
    }

    public void performAction(ImageView image, int boxPosition){

        boxPositions[boxPosition] = flag;
        if (flag==1){
            image.setImageResource(R.drawable.x);
            if (checkWin()){
                Dialog windialog = new WinDialog(MainActivity.this, player1name.getText().toString().toUpperCase()+" Won the game", MainActivity.this);
                windialog.show();
            } else if (totalboxesselected==9){
                Dialog windialog = new WinDialog(MainActivity.this, "It's draw", MainActivity.this);
                windialog.show();
            }else{
                changePlayerTurn(2);
                totalboxesselected++;
            }
        }
        else {
            image.setImageResource(R.drawable.o);
            if (checkWin()){
                Dialog windialog = new WinDialog(MainActivity.this, player2name.getText().toString().toUpperCase()+" Won the game", MainActivity.this);
                windialog.show();
            } else if (totalboxesselected==9){
                Dialog windialog = new WinDialog(MainActivity.this, "It's draw", MainActivity.this);
                windialog.show();
            }else{
                changePlayerTurn(1);
                totalboxesselected++;
            }
        }
    }

    public void changePlayerTurn(int turn){
        flag = turn;
        if (flag==1){
            player1layout.setBackgroundResource(R.drawable.card_border);
            player2layout.setBackgroundResource(R.drawable.card);
        }
        else{
            player2layout.setBackgroundResource(R.drawable.card_border);
            player1layout.setBackgroundResource(R.drawable.card);
        }
    }

    public boolean isboxselectable(int boxPosition){
        boolean response = false;
        if (boxPositions[boxPosition]==0){
            response = true;
        }
        return response;
    }
    public void changeScreen(){
        Intent intent = new Intent(MainActivity.this, addPlayers.class);
        startActivity(intent);
        finish();
    }
}