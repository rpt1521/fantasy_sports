package csc331.frenchtoastmafia.fantasysports;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import csc331.frenchtoastmafia.entities.Player;

public class DraftActivity extends AppCompatActivity{

    public static Player playerList[] = new Player[11];
    public static Integer player_image_values[] = new Integer[11];

    // Default Constructor
    public DraftActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draft);

        SplashActivity splashActivity = new SplashActivity();

        for (int i = 0; i < 11; i++) {
            player_image_values[i] = i;
        }

        Collections.shuffle(Arrays.asList(player_image_values));

        ImageView draft_image = (ImageView) findViewById(R.id.draft_image);
        draft_image.setImageResource(R.drawable.draft);

        TextView draft_header = (TextView) findViewById(R.id.draft_header);
        TextView draft_team_name = (TextView) findViewById(R.id.draft_team_name);
        draft_team_name.setText(splashActivity.getTeamName());
        draft_team_name.setVisibility(View.INVISIBLE);

        final Button begin_button = (Button) findViewById(R.id.draft_begin_button);
        final Button continue_button = (Button) findViewById(R.id.draft_continue_button);
        begin_button.setVisibility(View.VISIBLE);
        continue_button.setVisibility(View.INVISIBLE);

        begin_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                createPlayers();


                draft_header.setText("Drafting Complete");
                begin_button.setVisibility(View.GONE);
                draft_team_name.setVisibility(View.VISIBLE);
                continue_button.setVisibility(View.VISIBLE);

                LayoutInflater inflater = getLayoutInflater();
                LinearLayout main = findViewById(R.id.draft_linear_layout);
                View columns = inflater.inflate(R.layout.team_columns, null);
                main.addView(columns);

                TableLayout main_columns = findViewById(R.id.team_table_columns);

                View[] draftees = new View[11];

                ArrayList<Integer> player_image_ids = new ArrayList<Integer>();
                for (int i = 0; i < 11; i++) {
                    player_image_ids.add(getResources().getIdentifier("player" + i, "drawable", "csc331.frenchtoastmafia.fantasysports"));
                }

                for (int i = 0; i < 11; i++) {
                    View row = inflater.inflate(R.layout.team_rows, null);

                    TextView position = (TextView) row.findViewById(R.id.position);
                    position.setText(playerList[i].pos);

                    ImageView player_image = (ImageView) row.findViewById(R.id.player_image);
                    player_image.setImageResource(player_image_ids.get(player_image_values[i]));

                    TextView information = (TextView) row.findViewById(R.id.information);
                    information.setText(playerList[i].name);

                    main_columns.addView(row);
                }


            }

        });

        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(DraftActivity.this, MainActivity.class));
            }
        });

    }

    public void createPlayers() {
        Player qb = new Player("QB", generateRandomName("QB"));
        playerList[0] = qb;

        Player rb = new Player("RB", generateRandomName("RB"));
        playerList[1] = rb;

        Player fb = new Player("FB", generateRandomName("FB"));
        playerList[2] = fb;

        Player te = new Player("TE", generateRandomName("TE"));
        playerList[3] = te;

        Player wr_1 = new Player("WR", generateRandomName("WR"));
        playerList[4] = wr_1;

        Player wr_2 = new Player("WR", generateRandomName("WR"));
        playerList[5] = wr_2;

        Player rt = new Player("RT", generateRandomName("RT"));
        playerList[6] = rt;

        Player lt = new Player("LT", generateRandomName("LT"));
        playerList[7] = lt;

        Player rg = new Player("RG", generateRandomName("RG"));
        playerList[8] = rg;

        Player lg = new Player("LG", generateRandomName("LG"));
        playerList[9] = lg;

        Player c = new Player("C", generateRandomName("C"));
        playerList[10] = c;
    }

    public String generateRandomName(String pos) {
        String firstNames[] = new String[] {"Liam", "Joshua", "Ezra", "Hudson", "Charles", "Caleb", "Isaiah", "Ryan", "Nathan", "Adrian", "Christian", "Maverick", "Colton", "Elias", "Aaron"};
        String lastNames[] = new String[] {"Smith", "Hall", "Stewart", "Price", "Bennett", "Reed", "Wilson", "Moore", "Green", "Adams", "Rivera", "Patterson", "Hughes", "Bailey", "Cooper"};
        String teamAcronyms[] = new String[] {"ARZ", "ATL", "BLT", "BUF", "CLV", "HST", "IND", "MIA", "NO", "MIN", "NE", "WAS", "TEN", "SEA", "PIT"};

        String name = firstNames[generateRandomNumber()] + " " + lastNames[generateRandomNumber()] + "\n" + teamAcronyms[generateRandomNumber()] + " " + pos;
        return name;
    }


    public int generateRandomNumber() {
        int min = 0;
        int max = 14;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public Player[] getTeam() {
        return playerList;
    }

    public Player getPlayer(int iteration) {
        return playerList[iteration];
    }

    public int getPlayerImageValues(int iteration) {
        return player_image_values[iteration];
    }

}
