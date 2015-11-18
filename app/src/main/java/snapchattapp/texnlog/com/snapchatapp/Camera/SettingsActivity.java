package snapchattapp.texnlog.com.snapchatapp.Camera;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.app.ActionBar;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.MenuItem;

import snapchattapp.texnlog.com.snapchatapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends PreferenceActivity {

    private static Camera camera;

    private static Camera.Parameters params =camera.getParameters();
    private static List<Camera.Size> sizes =params.getSupportedPictureSizes();





    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            pictureSizeSelection();

    }
    private void pictureSizeSelection(){
         final ListPreference listPreference=(ListPreference)findPreference("sizelist");
        setListPreferenceData(listPreference);
        listPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                setListPreferenceData(listPreference);
                return false;
            }
        });
    }
    protected static void setListPreferenceData(ListPreference listPreferenceData){
        List<String > listSupportedPictureSizes=new ArrayList<String>();
        List<String>  entryvaluesStr=new ArrayList<String>();
        int m=0;
        String o=null;
       for(int i=0;i <sizes.size();i++){
           String strSize=String.valueOf(i) + " : "
                   +String.valueOf(sizes.get(i).height)+
                   " x "+
                   String.valueOf(sizes.get(i).width);
            listSupportedPictureSizes.add(strSize);
           m++;
       }


        CharSequence[] cs=listSupportedPictureSizes.toArray(new CharSequence[listSupportedPictureSizes.size()]);
        listPreferenceData.setEntries(cs);
        for(int l=0;l<m;l++)
        {
            o=Integer.toString(l);
            entryvaluesStr.add(o);
        }
        CharSequence[] ls=entryvaluesStr.toArray(new CharSequence[entryvaluesStr.size()]);
        listPreferenceData.setEntryValues(ls);
    }

}
