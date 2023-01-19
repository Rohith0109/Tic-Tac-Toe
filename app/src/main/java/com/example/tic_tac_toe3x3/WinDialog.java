package com.example.tic_tac_toe3x3;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private final String msg1;
    private final MainActivity mainActivity;

    public WinDialog(@NonNull Context context, String msg1, MainActivity mainActivity) {
        super(context);
        this.msg1 = msg1;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);

        TextView msg = findViewById(R.id.message);
        Button restart = findViewById(R.id.restart);

        msg.setText(msg1);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.changeScreen();
                dismiss();
            }
        });

    }
}
