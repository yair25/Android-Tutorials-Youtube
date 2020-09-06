package com.yair25.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView diceImageView;
    private Button rollDiceButton;

    private final int[] diceImageIDs = new int[] {
            R.drawable.dice1, R.drawable.dice2,
            R.drawable.dice3, R.drawable.dice4,
            R.drawable.dice5, R.drawable.dice6 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImageView = findViewById(R.id.dice_iv);
        rollDiceButton = findViewById(R.id.roll_dice_bt);

        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll();
            }
        });

        diceImageView.setImageResource(diceImageIDs[0]);
    }

    private void roll() {
        int index = (int)(Math.random() * 6);
        diceImageView.setImageResource(diceImageIDs[index]);

        diceImageView.setContentDescription("" + (index + 1));
        Toast.makeText(this, "You rolled a " + (index + 1), Toast.LENGTH_SHORT).show();
    }
}
