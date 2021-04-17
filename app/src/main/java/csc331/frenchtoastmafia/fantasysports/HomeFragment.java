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

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"", "Richard Tran", "Tyler Landau", "DJ Taylor", "Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View home = inflater.inflate(R.layout.home, null);
        ImageView user_image = (ImageView) home.findViewById(R.id.splash_image);
        user_image.setImageResource(R.drawable.splash);

        spinner = (Spinner) home.findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Button button = (Button) home.findViewById(R.id.play_button);
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
                        String number_of_weeks;
                        if (input.getText().equals("")) {
                            number_of_weeks = "0";
                            Integer.parseInt(number_of_weeks);
                        }

                        else {
                            number_of_weeks = input.getText().toString();
                            Integer.parseInt(number_of_weeks);
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


