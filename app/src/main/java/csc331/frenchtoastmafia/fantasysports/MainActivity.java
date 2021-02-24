package csc331.frenchtoastmafia.fantasysports;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();

        // Add columns to main view
        TableLayout main = findViewById(R.id.table_layout);
        View columns = inflater.inflate(R.layout.columns, null);

        main.addView(columns);

        ArrayList<Integer> player_image_ids = new ArrayList<Integer>();

        // Update loop with appropriate number of players from DB
        for(int i = 0; i <= 1; i++)
        {
            player_image_ids.add(getResources().getIdentifier( "player" + i,  "drawable", "csc331.frenchtoastmafia.fantasysports"));
        }

        // Temporary dummy data until able to pull from DB
        String[] player_names = new String[2];
        player_names[0] = "Leonard Fournette\nLA LSU A";
        player_names[1] = "Alvin Kamara\nTE NOS A";

        String[] player_positions = new String[2];
        player_positions[0] = "QB";
        player_positions[1] = "RB";

        // Update amount of rows needed based on number of players from DB
        View[] rows = new View[32];

        TableLayout main_columns = findViewById(R.id.table_columns);

        // Update loop with appropriate number of rows based on players from DB
        for(int i = 0; i <= 1; i++) {

            // Inflate each row
            rows[i] = inflater.inflate(R.layout.row, null);

            // Edit row information
            TextView position = (TextView) rows[i].findViewById(R.id.position);
            position.setText(player_positions[i]);

            ImageView image = (ImageView) rows[i].findViewById(R.id.player_image);
            image.setImageResource(player_image_ids.get(i));

            TextView information = (TextView) rows[i].findViewById(R.id.information);
            information.setText(player_names[i]);

            // Add new row to view
            main_columns.addView(rows[i]);

        }

    }

}