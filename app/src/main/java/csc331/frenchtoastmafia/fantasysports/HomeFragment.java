package csc331.frenchtoastmafia.fantasysports;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View home = inflater.inflate(R.layout.home, null);
        ImageView user_image = (ImageView) home.findViewById(R.id.home_user_image);
        user_image.setImageResource(R.drawable.profile);

        final Button button = (Button) home.findViewById(R.id.home_play_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Please enter the number of weeks: ");

                // Set up the input
                final EditText input = new EditText(getActivity());

                // Type of text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String number_of_weeks = "";
                        String empty = "";
                        boolean number = false;

                        number_of_weeks = input.getText().toString();

                        try {
                            Integer.parseInt(number_of_weeks);
                        }

                        catch (Exception e) {
                            new AlertDialog.Builder(getActivity())
                            .setTitle("Invalid Number")
                            .setMessage("You have entered an invalid number. Please press play again and enter a valid number.")

                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                        }

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }

        });

        return home;

    }

}


