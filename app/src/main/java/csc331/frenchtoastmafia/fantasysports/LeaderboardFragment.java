package csc331.frenchtoastmafia.fantasysports;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import csc331.frenchtoastmafia.entities.User;


public class LeaderboardFragment extends Fragment {

    SplashActivity splashActivity = new SplashActivity();
    User[] users = splashActivity.getUsers();
    TextView[] ranks = new TextView[9];
    TextView[] wins = new TextView[9];
    TextView[] losses = new TextView[9];

    public LeaderboardFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View columns = inflater.inflate(R.layout.rank_columns, null);

        TableLayout main_columns = columns.findViewById(R.id.rank_table_columns);

        View rows[] = new View[9];

        for (int i = 0; i < 9; i++) {

            rows[i] = inflater.inflate(R.layout.rank_rows, null);

            TextView user_information = (TextView) rows[i].findViewById(R.id.user_information);
            user_information.setText(users[i].name + users[i].teamName);

            ImageView user_image = (ImageView) rows[i].findViewById(R.id.user_image);
            user_image.setImageResource(users[i].image_id);

            ranks[i] = (TextView) rows[i].findViewById(R.id.rank);

            wins[i] = (TextView) rows[i].findViewById(R.id.wins);

            losses[i] = (TextView) rows[i].findViewById(R.id.losses);

            main_columns.addView(rows[i]);
        }

        return columns;
    }

    public void updateRanks() {
        for (int i = 0; i < 9; i++) {

            wins[i].setText(Integer.toString(users[i].wins));
            losses[i].setText(Integer.toString(users[i].losses));
        }

        for (int i = 0, j = 1; i < 9; i++) {

            // First rank, always 1
            if (i == 0) {
                ranks[i].setText(Integer.toString(j));
                j++;
                // Else, compare the previous user to current user
            } else if (i > 0) {
                // If they're the same, then
                if (users[i - 1].wins == users[i].wins) {
                    // The current user's rank needs to be the same as the previous user's
                    ranks[i].setText(Integer.toString(j-1));

                } else {
                    ranks[i].setText(Integer.toString(j));
                    j++;
                }

            }

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        updateRanks();
    }


}