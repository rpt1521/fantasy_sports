//package csc331.frenchtoastmafia.testapp;
//
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.testng.annotations.Test;
//import static org.junit.Assert.*;
//
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.viewpager.widget.ViewPager;
//
//import csc331.frenchtoastmafia.fantasysports.MainActivity;
//import csc331.frenchtoastmafia.fantasysports.R;
//import csc331.frenchtoastmafia.fantasysports.HomeFragment;
//import csc331.frenchtoastmafia.fantasysports.LeaderboardFragment;
//import csc331.frenchtoastmafia.fantasysports.TeamFragment;
//
//public class TestFragments extends AppCompatActivity {
//
//    FragmentPagerAdapter adapterViewPager;
//
//    // Still required to layout the page and create an environment to test fragments
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
//        adapterViewPager = new TestFragments.MyPagerAdapter(getSupportFragmentManager());
//        vpPager.setAdapter(adapterViewPager);
//
//    }
//
//    public static class MyPagerAdapter extends FragmentPagerAdapter {
//
//        // Number of fragments to be created
//        private static int NUM_ITEMS = 3;
//
//        public MyPagerAdapter(FragmentManager fragmentManager) {
//            super(fragmentManager);
//        }
//
//        // Passes the number of fragments to create
//        @Override
//        public int getCount() {
//            return NUM_ITEMS;
//        }
//
//        // Creates a fragment and then uses the assert method from JUnit to test, if assertion passes, get the result and notify tester
//        @Override @Test
//        public Fragment getItem(int position) {
//            switch (position) {
//                case 0:
//                    // Creates the fragment and tests with the assert method
//                    HomeFragment testHomeFragment = new HomeFragment();
//                    assert(testHomeFragment == new HomeFragment());
//
//                    // Get the result and report it
//                    Result homeResult = JUnitCore.runClasses(HomeFragment.class);
//                    homeResult.getFailures();
//                    System.out.println(homeResult.wasSuccessful());
//                case 1:
//                    // Creates the fragment and tests with the assert method
//                    TeamFragment testTeamFragment = new TeamFragment();
//                    assert(testTeamFragment == new TeamFragment());
//
//                    // Get the result and report it
//                    Result teamResult = JUnitCore.runClasses(TeamFragment.class);
//                    teamResult.getFailures();
//                    System.out.println(teamResult.wasSuccessful());
//                case 2:
//                    // Creates the fragment and tests with the assert method
//                    LeaderboardFragment testLeaderboardFragment = new LeaderboardFragment();
//                    assert(testLeaderboardFragment == new LeaderboardFragment());
//
//                    // Get the result and report it
//                    Result leaderboardResult = JUnitCore.runClasses(LeaderboardFragment.class);
//                    leaderboardResult.getFailures();
//                    System.out.println(leaderboardResult.wasSuccessful());
//
//                default:
//                    return null;
//            }
//        }
//
//    }
//
//}
//
