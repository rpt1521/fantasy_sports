package csc331.frenchtoastmafia.fantasysports;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Arrays;

import csc331.frenchtoastmafia.entities.Player;
import csc331.frenchtoastmafia.entities.User;

public class HomeFragment extends Fragment {

    public static int current_week;
    static final int TOTAL_WEEKS = 16;
    int weeks_remaining = TOTAL_WEEKS - current_week;

    DraftActivity draftActivity = new DraftActivity();
    Player[] playerList = draftActivity.getTeam();

    SplashActivity splashActivity = new SplashActivity();
    User[] users = splashActivity.getUsers();

    TextView wins;
    TextView losses;
    TextView week_header;

    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View home = inflater.inflate(R.layout.home, null);

        wins = (TextView) home.findViewById(R.id.home_win_count);
        losses = (TextView) home.findViewById(R.id.home_loss_count);


        ImageView user_image = (ImageView) home.findViewById(R.id.home_user_image);

        week_header = (TextView) home.findViewById(R.id.home_week);

        switch (splashActivity.getAvatarChoice()) {
            case 1:
                user_image.setImageResource(R.drawable.profile1);
                break;
            case 2:
                user_image.setImageResource(R.drawable.profile2);
                break;
            case 3:
                user_image.setImageResource(R.drawable.profile3);
                break;
            case 4:
                user_image.setImageResource(R.drawable.profile4);
                break;
            case 5:
                user_image.setImageResource(R.drawable.profile5);
                break;
            case 6:
                user_image.setImageResource(R.drawable.profile6);
                break;
            case 7:
                user_image.setImageResource(R.drawable.profile7);
                break;
            case 8:
                user_image.setImageResource(R.drawable.profile8);
                break;
            default:
                user_image.setImageResource(R.drawable.profile0);
        }

        TextView username = (TextView) home.findViewById(R.id.home_username);
        username.setText(splashActivity.getUsername());

        TextView teamName = (TextView) home.findViewById(R.id.home_team_name);
        teamName.setText(splashActivity.getTeamName());

        button = (Button) home.findViewById(R.id.home_play_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (weeks_remaining != 0) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Please enter the number of weeks " + "(1-" + weeks_remaining + "): ");

                    // Set up the input
                    final EditText input = new EditText(getActivity());

                    // Type of text
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

                    // Set up the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String number_of_weeks_string = "";
                            int number_of_weeks = 0;
                            String empty = "";
                            boolean number = false;

                            number_of_weeks_string = input.getText().toString();

                            try {
                                number_of_weeks = Integer.parseInt(number_of_weeks_string);

                                if ((current_week + number_of_weeks > TOTAL_WEEKS) || (weeks_remaining - number_of_weeks < 0)) {
                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Too Many Weeks")
                                            .setMessage("The season only runs for 16 weeks! Please enter a lower number.")

                                            .setIcon(android.R.drawable.ic_dialog_alert)
                                            .show();
                                } else {
                                    current_week = current_week + number_of_weeks;
                                    weeks_remaining = weeks_remaining - number_of_weeks;

                                    if (weeks_remaining == 0) {
                                        button.setText("Reset");
                                    }

                                    if (weeks_remaining == 0) {
                                        week_header.setText("Season Has Ended");
                                    }

                                    else
                                    {
                                        week_header.setText("Week Number: " + current_week);
                                    }

                                    // Update Player Stats
                                    for (int i = 0; i < 11; i++) {
                                        for (int j = 0; j < number_of_weeks; j++) {
                                            playerList[i].addGP(generateRandomNumber(0, 1));
                                            playerList[i].addCMP(generateRandomNumber(0, 5));
                                            playerList[i].addATT(generateRandomNumber(0, 8));
                                            playerList[i].addCMP_Percent(generateRandomNumber(0, 4) + (generateRandomNumber(0, 9)/10.0));
                                            playerList[i].addYDS(generateRandomNumber(0, 66));
                                            playerList[i].addAVG(generateRandomNumber(0, 9)/10.0);
                                            playerList[i].addYDS_G(generateRandomNumber(0, 31) + (generateRandomNumber(0, 9)/10.0));
                                            playerList[i].addLNG(generateRandomNumber(0, 4));
                                            playerList[i].addTD(generateRandomNumber(0, 1));
                                            playerList[i].addINT(generateRandomNumber(0, 1));
                                            playerList[i].addSACK(generateRandomNumber(0, 1));
                                            playerList[i].addSYL(generateRandomNumber(0, 5));
                                            playerList[i].addQBR(generateRandomNumber(0, 5) + (generateRandomNumber(0, 9)/10.0));
                                            playerList[i].addRTG(generateRandomNumber(0, 6) + (generateRandomNumber(0, 9)/10.0));
                                            playerList[i].addBIG(generateRandomNumber(0, 1));
                                            playerList[i].addFUM(generateRandomNumber(0, 1));
                                            playerList[i].addLST(generateRandomNumber(0, 1));
                                            playerList[i].addFD(generateRandomNumber(0, 1));
                                            playerList[i].addREC(generateRandomNumber(0, 2));
                                            playerList[i].addTGTS(generateRandomNumber(0, 2));
                                            playerList[i].addYAC(generateRandomNumber(0, 12));
                                        }
                                    }


                                    for (int i = 0; i < number_of_weeks; i++) {
                                        for (int j = 0; j < 9; j++) {
                                            int wins = 0;
                                            wins = generateRandomNumber(0, 1);
                                            if (wins == 0) {
                                                users[j].addLosses(1);
                                            }

                                            else {
                                                users[j].addWins(wins);
                                            }
                                        }
                                    }

                                    sortUsers();
                                    wins.setText("" + Integer.toString(splashActivity.getMainUserWins()));
                                    losses.setText("" + Integer.toString(splashActivity.getMainUserLosses()));

                                }

                            } catch (Exception e) {
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

                else
                {
                    current_week = 0;
                    weeks_remaining = 16;

                    button.setText("Play");
                    week_header.setText("Week Number: " + current_week);

                    for (int i = 0; i < 9; i++) {
                        users[i].resetWinsLosses();
                    }

                    wins.setText("" + Integer.toString(splashActivity.getMainUserWins()));
                    losses.setText("" + Integer.toString(splashActivity.getMainUserLosses()));

                    for (int i = 0; i < 11; i++)
                    {
                        playerList[i].resetStats();
                    }

                }

            }



        });

        return home;
    }

    public int generateRandomNumber(int min, int max) {
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public void sortUsers() {
        Arrays.sort(users);
    }

    @Override
    public void onResume() {
        super.onResume();
        wins.setText("" + Integer.toString(splashActivity.getMainUserWins()));
        losses.setText("" + Integer.toString(splashActivity.getMainUserLosses()));
        if (weeks_remaining == 0) {
            button.setText("Reset");
        }

        else
        {
            button.setText("Play");
        }

        if (weeks_remaining == 0) {
            week_header.setText("Season Has Ended");
        }

        else
        {
            week_header.setText("Week Number: " + current_week);
        }

    }

}


