package csc331.frenchtoastmafia.fantasysports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView user_image = (ImageView) findViewById(R.id.splash_image);
        user_image.setImageResource(R.drawable.splash);

        final Button button = (Button) findViewById(R.id.splash_play_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, DraftActivity.class));
            }

        });

    }

}
