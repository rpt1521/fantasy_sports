//package csc331.frenchtoastmafia.testapp;
//
//import android.app.AlertDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//
//import csc331.frenchtoastmafia.fantasysports.R;
//import csc331.frenchtoastmafia.fantasysports.DraftActivity;
//import csc331.frenchtoastmafia.fantasysports.MainActivity;
//import csc331.frenchtoastmafia.fantasysports.SplashActivity;
//
//public class TestActivities extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
//
//        // Open activities one by one and display a notification of their success or failure
//        splashActivity();
//        draftActivity();
//        mainActivity();
//
//    }
//
//    private void splashActivity()
//    {
//
//        // Try to open the activity, if it succeeds, display notification of success
//        try {
//            startActivity(new Intent(TestActivities.this, SplashActivity.class));
//
//            Result result = JUnitCore.runClasses(SplashActivity.class);
//            result.getFailures();
//            System.out.println(result.wasSuccessful());
//
//            if (result.wasSuccessful() == true) {
//                new AlertDialog.Builder(TestActivities.this)
//                        .setTitle("Success")
//                        .setMessage("The splash activity opened successfully!")
//                        .show();
//            }
//        }
//
//        // If it fails, display notification of failure
//        catch (Exception e) {
//            new AlertDialog.Builder(TestActivities.this)
//                    .setTitle("Error")
//                    .setMessage("There was an error opening the splash activity.")
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    .show();
//        }
//    }
//
//    private void draftActivity()
//    {
//
//        // Try to open the activity, if it succeeds, display notification of success
//        try {
//            startActivity(new Intent(TestActivities.this, DraftActivity.class));
//
//            Result result = JUnitCore.runClasses(DraftActivity.class);
//            result.getFailures();
//            System.out.println(result.wasSuccessful());
//
//            if (result.wasSuccessful() == true) {
//                new AlertDialog.Builder(TestActivities.this)
//                        .setTitle("Success")
//                        .setMessage("The draft activity opened successfully!")
//                        .show();
//            }
//        }
//
//        // If it fails, display notification of failure
//        catch (Exception e) {
//            new AlertDialog.Builder(TestActivities.this)
//                    .setTitle("Error")
//                    .setMessage("There was an error opening the draft activity.")
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    .show();
//        }
//    }
//
//    private void mainActivity()
//    {
//
//        // Try to open the activity, if it succeeds, display notification of success
//        try {
//            startActivity(new Intent(TestActivities.this, MainActivity.class));
//
//            Result result = JUnitCore.runClasses(MainActivity.class);
//            result.getFailures();
//            System.out.println(result.wasSuccessful());
//
//            if (result.wasSuccessful() == true) {
//                new AlertDialog.Builder(TestActivities.this)
//                        .setTitle("Success")
//                        .setMessage("The main activity opened successfully!")
//                        .show();
//            }
//        }
//
//        // If it fails, display notification of failure
//        catch (Exception e) {
//            new AlertDialog.Builder(TestActivities.this)
//                    .setTitle("Error")
//                    .setMessage("There was an error opening the main activity.")
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    .show();
//        }
//    }
//
//}
