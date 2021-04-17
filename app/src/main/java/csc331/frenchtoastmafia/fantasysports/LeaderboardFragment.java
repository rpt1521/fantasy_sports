package csc331.frenchtoastmafia.fantasysports;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;


public class LeaderboardFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View columns = inflater.inflate(R.layout.rank_columns, null);

        TableLayout main_columns = columns.findViewById(R.id.rank_table_columns);

        View rows = inflater.inflate(R.layout.rank_rows, null);
        TextView rank = (TextView) rows.findViewById(R.id.rank);
        ImageView user_image = (ImageView) rows.findViewById(R.id.user_image);
        user_image.setImageResource(R.drawable.profile);
        rank.setText("1");

        main_columns.addView(rows);

        return columns;
    }

}