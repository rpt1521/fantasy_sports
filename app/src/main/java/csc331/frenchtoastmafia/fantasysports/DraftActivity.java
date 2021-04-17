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

public class DraftActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"", "Richard Tran", "Tyler Landau", "DJ Taylor", "Player 1", "Player 2", "Player 3", "Player 4", "Player 5", "Player 6", "Player 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draft);

        spinner = (Spinner) findViewById(R.id.draft_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DraftActivity.this, android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // action here
                break;
            case 1:
                // action here
                break;
            case 2:
                // action here
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // action here
    }

}
