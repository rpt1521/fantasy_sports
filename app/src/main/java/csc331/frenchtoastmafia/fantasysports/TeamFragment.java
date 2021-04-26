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

import csc331.frenchtoastmafia.entities.Player;

public class TeamFragment extends Fragment {

    DraftActivity draftActivity = new DraftActivity();
    Player[] playerList = draftActivity.getTeam();
    TextView[] gps = new TextView[11];
    TextView[] cmps = new TextView[11];
    TextView[] atts = new TextView[11];
    TextView[] cmp_ps = new TextView[11];
    TextView[] ydss = new TextView[11];
    TextView[] avgs = new TextView[11];
    TextView[] yds_gs = new TextView[11];
    TextView[] lngs = new TextView[11];
    TextView[] tds = new TextView[11];
    TextView[] inters = new TextView[11];
    TextView[] sacks = new TextView[11];
    TextView[] syls = new TextView[11];
    TextView[] qbrs = new TextView[11];
    TextView[] rtgs = new TextView[11];
    TextView[] bigs  = new TextView[11];
    TextView[] fums = new TextView[11];
    TextView[] lsts = new TextView[11];
    TextView[] fds = new TextView[11];
    TextView[] recs = new TextView[11];
    TextView[] tgtss = new TextView[11];
    TextView[] yacs = new TextView[11];

    public TeamFragment() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            updateStats();
        } else {

        }
    }

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
        for (int i = 0; i < 11; i++) {
            player_image_ids.add(getResources().getIdentifier("player" + i, "drawable", "csc331.frenchtoastmafia.fantasysports"));
        }

        // Update amount of rows needed based on number of players from DB
        View[] rows = new View[11];

        TableLayout main_columns = columns.findViewById(R.id.team_table_columns);

        // Update loop with appropriate number of rows based on players from DB
        for (int i = 0; i < 11; i++) {

            // Inflate each row
            rows[i] = inflater.inflate(R.layout.team_rows, null);

            // Edit row information
            TextView position = (TextView) rows[i].findViewById(R.id.position);
            position.setText(playerList[i].pos);

            ImageView image = (ImageView) rows[i].findViewById(R.id.player_image);
            image.setImageResource(player_image_ids.get(draftActivity.getPlayerImageValues(i)));

            TextView information = (TextView) rows[i].findViewById(R.id.information);
            information.setText(playerList[i].name);

            // Stats

            // GP
            gps[i] = (TextView) rows[i].findViewById(R.id.num_gp);

            // CMP
            cmps[i] = (TextView) rows[i].findViewById(R.id.num_cmp);

            // ATT
            atts[i] = (TextView) rows[i].findViewById(R.id.num_att);

            // CMP%
            cmp_ps[i] = (TextView) rows[i].findViewById(R.id.num_cmp_p);

            // YDS
            ydss[i] = (TextView) rows[i].findViewById(R.id.num_yds);

            // AVG
            avgs[i] = (TextView) rows[i].findViewById(R.id.num_avg);

            // YDS/G
            yds_gs[i] = (TextView) rows[i].findViewById(R.id.num_yds_g);

            // LNG
            lngs[i] = (TextView) rows[i].findViewById(R.id.num_lng);

            // TD
            tds[i] = (TextView) rows[i].findViewById(R.id.num_td);

            // INT
            inters[i] = (TextView) rows[i].findViewById(R.id.num_int);

            // SACK
            sacks[i] = (TextView) rows[i].findViewById(R.id.num_sack);

            // SYL
            syls[i] = (TextView) rows[i].findViewById(R.id.num_syl);

            // QBR
            qbrs[i] = (TextView) rows[i].findViewById(R.id.num_qbr);

            // RTG
            rtgs[i] = (TextView) rows[i].findViewById(R.id.num_rtg);

            // BIG
            bigs[i] = (TextView) rows[i].findViewById(R.id.num_big);

            // FUM
            fums[i] = (TextView) rows[i].findViewById(R.id.num_fum);

            // LST
            lsts[i] = (TextView) rows[i].findViewById(R.id.num_lst);

            // FD
            fds[i] = (TextView) rows[i].findViewById(R.id.num_fd);

            // REC
            recs[i] = (TextView) rows[i].findViewById(R.id.num_rec);

            // TGTS
            tgtss[i] = (TextView) rows[i].findViewById(R.id.num_tgts);

            // YAC
            yacs[i] = (TextView) rows[i].findViewById(R.id.num_yac);

            main_columns.addView(rows[i]);
        }

        return columns;

    }

    public void updateStats() {

        for (int i = 0; i < 11; i++) {
            gps[i].setText(Integer.toString(playerList[i].gp));
            cmps[i].setText(Integer.toString(playerList[i].cmp));
            atts[i].setText(Integer.toString(playerList[i].att));
            cmp_ps[i].setText(Double.toString(playerList[i].cmp_percent));
            ydss[i].setText(Integer.toString(playerList[i].yds));
            avgs[i].setText(Double.toString(playerList[i].avg));
            yds_gs[i].setText(Double.toString(playerList[i].yds_g));
            lngs[i].setText(Integer.toString(playerList[i].lng));
            tds[i].setText(Integer.toString(playerList[i].td));
            inters[i].setText(Integer.toString(playerList[i].inter));
            sacks[i].setText(Integer.toString(playerList[i].sack));
            syls[i].setText(Integer.toString(playerList[i].syl));
            qbrs[i].setText(Double.toString(playerList[i].qbr));
            rtgs[i].setText(Double.toString(playerList[i].rtg));
            bigs[i].setText(Integer.toString(playerList[i].big));
            fums[i].setText(Integer.toString(playerList[i].fum));
            lsts[i].setText(Integer.toString(playerList[i].lst));
            fds[i].setText(Integer.toString(playerList[i].fd));
            recs[i].setText(Integer.toString(playerList[i].rec));
            tgtss[i].setText(Integer.toString(playerList[i].tgts));
            yacs[i].setText(Integer.toString(playerList[i].yac));
        }

    };

}