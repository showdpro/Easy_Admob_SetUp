package ng.somoye.mylibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import ng.somoye.mylibrary.R;

//import ng.somoye.mylibrary.easyadmob.R;


public class AdmobSetUp extends AppCompatActivity {

    TextView tv;
    //Admob parameters
    private AdView madView;
    static InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Admob Banner
        madView = findViewById(R.id.adView);
        AllAdview.SetAd(madView); //usage: user specify this in their activity as AdmobSetUp.AllAdview.setAd(madView);
        MobileAds.initialize(this,"@string/app_id");

        // interstitial ads
        mInterstitialAd = new InterstitialAd(this);

        mInterstitialAd.setAdUnitId(getString(R.string.sample_interstitial_id)); //user specify adunit
        AllInterstitial.SetInterstitialAd(mInterstitialAd);


        //test interstitial
        tv = findViewById(R.id.tvsample);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllInterstitial.showInterstitial();
            }
        });
    }

    //Admob start here
    public static class AllAdview  {
        public static void SetAd(final AdView mAdView) {
            final AdRequest adRequest = new AdRequest.Builder().build();
            //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)


            mAdView.loadAd(adRequest);

            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    // Code to be executed when an ad finishes loading.
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    mAdView.loadAd(adRequest);
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                    Log.e("Ad is loaded", "Ad successfully loaded");
                }

                @Override
                public void onAdClicked() {
                    // Code to be executed when the user clicks on an ad.
                }

                @Override
                public void onAdLeftApplication() {
                    // Code to be executed when the user has left the app.
                }

                @Override
                public void onAdClosed() {
                    // Code to be executed when the user is about to return
                    // to the app after tapping on an ad.
                    mAdView.loadAd(adRequest);
                }
            });
        }
    }

    //usage : user call this method on any button on any activities as AdmobSetUp.SetInterstitial(mInterstitial);
    public static class AllInterstitial {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        public static void SetInterstitialAd(final InterstitialAd mInterstitialAd) {



            final AdRequest adRequest = new AdRequest.Builder()//.build();
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

            mInterstitialAd.loadAd(adRequest);

            mInterstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdLoaded() {
                    // Code to be executed when an ad finishes loading.
                    //showInterstitial();
                    Log.e("Ad is loaded", "Ad successfully loaded, Preparing to show Ad");
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    // Code to be executed when an ad request fails.
                    mInterstitialAd.loadAd(adRequest);
                    Log.e("Ad Failed", "Requesting new Ad");
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                    Log.e("Ad is opened", "Ad successfully opened");
                }

                @Override
                public void onAdClicked() {
                    // Code to be executed when the user clicks on an ad.
                    Log.e("Ad Clicked", "Ad was clicked by user");
                }

                @Override
                public void onAdLeftApplication() {
                    // Code to be executed when the user has left the app.
                    Log.e("Ad Clicked", "Ad is leaving App");
                    mInterstitialAd.loadAd(adRequest);
                }

                @Override
                public void onAdClosed() {
                    // Code to be executed when the user is about to return
                    // to the app after tapping on an ad.
                    Log.e("Ad is Closed", "Requesting next available Ad");
                    mInterstitialAd.loadAd(adRequest);
                }
            });
        }


        public static void showInterstitial() {
            // Show the ad if it's ready. Otherwise toast and restart the game.
            if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                //Toast.makeText(AdmobSetUp.this, "share with friends", Toast.LENGTH_SHORT).show();
                // startGame();
                //updateTime();
            }
        }

    }
    //Admob Ends here


}
