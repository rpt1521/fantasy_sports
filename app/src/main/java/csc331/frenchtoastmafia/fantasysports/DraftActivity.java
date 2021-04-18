package csc331.frenchtoastmafia.fantasysports;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class DraftActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draft);

        ImageView user_image = (ImageView) findViewById(R.id.draft_image);
        user_image.setImageResource(R.drawable.draft);

        final Button button = (Button) findViewById(R.id.draft_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(DraftActivity.this, MainActivity.class));
            }

        });

    }

}
