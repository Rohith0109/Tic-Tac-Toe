package com.example.tic_tac_toe3x3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText playerone = findViewById(R.id.player1);
        final EditText playertwo = findViewById(R.id.player2);
        final Button startGamebtn = findViewById(R.id.startGamebtn);

        startGamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1 = playerone.getText().toString();
                String player2 = playertwo.getText().toString();
                
                if (player1.length()>10||player2.length()>10){
                    Toast.makeText(addPlayers.this, "Player names must be less than 8 characters", Toast.LENGTH_SHORT).show();
                    playerone.setText("");
                    playertwo.setText("");
                    return;
                }

                if (player1.isEmpty() || player2.isEmpty()){
                    Toast.makeText(addPlayers.this, "Add player names", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(addPlayers.this, MainActivity.class);
                    intent.putExtra("PlayerOne", player1);
                    intent.putExtra("PlayerTwo", player2);
                    playerone.setText("");
                    playertwo.setText("");
                    startActivity(intent);
                }
            }
        });

    }
}