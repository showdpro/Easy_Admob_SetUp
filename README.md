"# Easy_Admob_SetUp" 

<b>Usage:</b>

<b>Required:</b>

 Project Build.gradle
 add 
 <b>classpath {url 'https://jetpack.io'}</b>

in app Build.gradle (implement firebase ads)

<b>implementation 'com.github.fafara:Easy_Admob_SetUp:1.7.0'</b>


<b>To Implement Banner ads</b>

<b>For Test Banner</b>

Apply the Adview in your XML file
and in corresponding Java Class:

<b>Import ng.somoye.mylibrary.AdmobSetUp;</b>

You may define the Adview adview; however if you dont it will call the default adview and app_id from this library.

in the onCreate, use the below codes to call the Adview method

<b>AdmobSetUp.AllAdview.SetAd(mAdview);</b>

Note banner id is defined in this lib as sample_banner_id


Dont forget to implement below in AndroidManifest.xml

<meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="@string/app_id" />
            
<b>For Real Banner</b>

use the above test method but change the app_id to myapp_id to avoid conflicting ids
and add all your real banner_id

<b>For Interstitial ads</b>

define the 
Interstitial mInterstitial;

in your java class and attach it to all buttons in any activities in your app with the below codes.

<b>AdmobSetUp.AllInterstitial.SetInterstitial(mInterstitial);</b>

<b>AdmobSetUp.AllInterstitial.showInterstitial();</b>


[![](https://jitpack.io/v/fafara/Easy_Admob_SetUp.svg)](https://jitpack.io/#fafara/Easy_Admob_SetUp)
