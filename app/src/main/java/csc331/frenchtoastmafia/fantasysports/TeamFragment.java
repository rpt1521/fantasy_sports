package csc331.frenchtoastmafia.fantasysports;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class TeamFragment extends Fragment {

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout "team_columns" and store it into the View "columns"
        View columns = inflater.inflate(R.layout.team_columns, null);

        ArrayList<Integer> player_image_ids = new ArrayList<Integer>();

        // Update loop with appropriate number of players from DB
        for (int i = 0; i <= 1; i++) {
            player_image_ids.add(getResources().getIdentifier("player" + i, "drawable", "csc331.frenchtoastmafia.fantasysports"));
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

        TableLayout main_columns = columns.findViewById(R.id.team_table_columns);

        // Update loop with appropriate number of rows based on players from DB
        for (int i = 0; i <= 1; i++) {

            // Inflate each row
            rows[i] = inflater.inflate(R.layout.team_rows, null);

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

        return columns;
    }

}