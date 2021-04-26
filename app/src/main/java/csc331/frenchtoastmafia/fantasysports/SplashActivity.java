package csc331.frenchtoastmafia.fantasysports;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;

import csc331.frenchtoastmafia.entities.User;


public class SplashActivity extends AppCompatActivity {

    public static String username;
    public static String team_name;
    public static User mainUser;
    public static int avatar_choice;
    public static  int avatar_ID;
    public static User[] users = new User[9];
    public static Integer[] maleImageIDs = new Integer[] {R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4};
    public static Integer[] femaleImageIDs = new Integer[] {R.drawable.profile5, R.drawable.profile6, R.drawable.profile7, R.drawable.profile8};
    String teamNames[] = new String[] {"Destroyers", "Annihilators", "Almighty", "Supreme", "Invincible", "Unconquerable", "Powerhouse", "Undefeated"};
    String girlNames[] = new String[] {"Jessica", "Lacey", "Paige", "Janice", "Marie", "Judy", "Sophia"};


    // Default Constructor
    public SplashActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Collections.shuffle(Arrays.asList(teamNames));

        for (int i = 1; i < 9; i++)
        {
            String name = generateRandomUser();
            int imageID = 0;
            boolean not_found = true;
            for (int j = 0; (j < 7) && not_found; j++) {
                if (name.contains(girlNames[j]))
                {
                    imageID = femaleImageIDs[generateRandomNumber(0, 3)];
                    not_found = false;
                }

            }

            if (not_found)
            {
                imageID = maleImageIDs[generateRandomNumber(0, 3)];
            }

            users[i] = new User(name, "\nTeam " + teamNames[i-1], imageID);
        }

        ImageView user_image = (ImageView) findViewById(R.id.splash_image);
        user_image.setImageResource(R.drawable.profile0);

        final Button avatar_button = (Button) findViewById(R.id.splash_avatar_button);
        final Button continue_avatar_button = (Button) findViewById(R.id.splash_continue_avatar_button);
        final Button name_button = (Button) findViewById(R.id.splash_name_button);
        final Button team_name_button = (Button) findViewById(R.id.splash_team_name_button);
        final Button continue_button = (Button) findViewById(R.id.splash_continue_button);
        name_button.setVisibility(View.INVISIBLE);
        continue_avatar_button.setVisibility(View.INVISIBLE);
        team_name_button.setVisibility(View.INVISIBLE);
        continue_button.setVisibility(View.INVISIBLE);

        avatar_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                continue_avatar_button.setVisibility(View.VISIBLE);
                avatar_button.setText("Change Avatar");

                String[] options = {"Option One", "Option Two", "Option Three", "Option Four", "Option Five", "Option Six", "Option Seven", "Option Eight"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Select your avatar:");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        if ("Option One".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile1);
                            avatar_choice = 1;
                            avatar_ID = R.drawable.profile1;
                        }
                        else if ("Option Two".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile2);
                            avatar_choice = 2;
                            avatar_ID = R.drawable.profile2;
                        }
                        else if ("Option Three".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile3);
                            avatar_choice = 3;
                            avatar_ID = R.drawable.profile3;
                        }
                        else if ("Option Four".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile4);
                            avatar_choice = 4;
                            avatar_ID = R.drawable.profile4;
                        }
                        else if ("Option Five".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile5);
                            avatar_choice = 5;
                            avatar_ID = R.drawable.profile5;
                        }
                        else if ("Option Six".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile6);
                            avatar_choice = 6;
                            avatar_ID = R.drawable.profile6;
                        }
                        else if ("Option Seven".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile7);
                            avatar_choice = 7;
                            avatar_ID = R.drawable.profile7;
                        }
                        else if ("Option Eight".equals(options[choice])) {
                            user_image.setImageResource(R.drawable.profile8);
                            avatar_choice = 8;
                            avatar_ID = R.drawable.profile8;
                        }
                    }
                });

                builder.show();
                team_name_button.setVisibility(View.GONE);

            }

        });

        continue_avatar_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                avatar_button.setVisibility(View.GONE);
                continue_avatar_button.setVisibility(View.GONE);
                name_button.setVisibility(View.VISIBLE);
            }

        });

        name_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Please enter your name: ");

                final EditText input = new EditText(SplashActivity.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        username = input.getText().toString();
                    }

                });

                builder.show();
                name_button.setVisibility(View.GONE);
                team_name_button.setVisibility(View.VISIBLE);

            }

        });

        name_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Please enter your name: ");

                final EditText input = new EditText(SplashActivity.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        username = input.getText().toString();
                    }

                });

                builder.show();
                name_button.setVisibility(View.GONE);
                team_name_button.setVisibility(View.VISIBLE);

            }

        });

        team_name_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Please enter your team name: ");

                final EditText input = new EditText(SplashActivity.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        team_name = input.getText().toString();
                    }

                });

                builder.show();
                team_name_button.setVisibility(View.GONE);
                continue_button.setVisibility(View.VISIBLE);

            }

        });

        continue_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mainUser = new User(username, "\n" + team_name, avatar_ID);
                users[0] = mainUser;
                startActivity(new Intent(SplashActivity.this, DraftActivity.class));

            }

        });

    }

    public int generateRandomNumber() {
        int min = 0;
        int max = 14;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public int generateRandomNumber(int min, int max) {
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public String generateRandomUser() {
        String firstNames[] = new String[] {"Jessica", "Lacey", "Kevin", "Lawrence", "Paige", "Janice", "Albert", "Noah", "Marie", "Judy", "Gerald", "Roger", "Sophia", "Jack", "Gregory"};
        String lastNames[] = new String[] {"Martin", "Lee", "Thompson", "Harris", "Young", "Scott", "Campbell", "Phillips", "Kelly", "Patel", "Myers", "Foster", "Davis", "Garcia", "Smith"};

        String user = firstNames[generateRandomNumber()] + " " + lastNames[generateRandomNumber()];

        return user;
    }

    public String getUsername() {
        return username;
    }

    public String getTeamName() {
        return team_name;
    }

    public int getAvatarChoice() {
        return avatar_choice;
    }

    public User getUser(int iteration) {
        return users[iteration];
    }

    public User[] getUsers() {
        return users;
    }

    public int getMainUserWins() {
        return mainUser.wins;
    }

    public int getMainUserLosses() {
        return mainUser.losses;
    }

}
