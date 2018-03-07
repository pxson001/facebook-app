package com.facebook.katana.prefs;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.facebook.common.util.TriState;
import com.facebook.messaging.forcemessenger.ForceMessengerPrefKeys;
import com.facebook.widget.prefs.OrcaListPreference;

/* compiled from: p2p_pay_button_clicked */
public class DiodePreferences extends PreferenceCategory {
    public Context f7569a;

    /* compiled from: p2p_pay_button_clicked */
    class C08421 implements OnPreferenceChangeListener {
        final /* synthetic */ DiodePreferences f7568a;

        C08421(DiodePreferences diodePreferences) {
            this.f7568a = diodePreferences;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            Toast.makeText(this.f7568a.getContext(), "Please restart the app to see the setting take effect.", 0).show();
            return true;
        }
    }

    public DiodePreferences(Context context) {
        super(context);
        this.f7569a = context;
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Diode experiment - internal");
        OrcaListPreference orcaListPreference = new OrcaListPreference(this.f7569a);
        orcaListPreference.setSummary("Set New User");
        orcaListPreference.setTitle("New User");
        orcaListPreference.setDialogTitle("New User");
        orcaListPreference.a(ForceMessengerPrefKeys.b);
        orcaListPreference.setDefaultValue(String.valueOf(TriState.UNSET.getDbValue()));
        orcaListPreference.setEntries(new String[]{"Unset (Use GK value)", "Yes", "No"});
        orcaListPreference.setEntryValues(new String[]{String.valueOf(TriState.UNSET.getDbValue()), String.valueOf(TriState.YES.getDbValue()), String.valueOf(TriState.NO.getDbValue())});
        addPreference(orcaListPreference);
        orcaListPreference = new OrcaListPreference(this.f7569a);
        orcaListPreference.setTitle("Set Is User in Diode");
        orcaListPreference.setSummary("Determines whether you are in the Diode Experiments");
        orcaListPreference.setDialogTitle("Is User in Diode?");
        orcaListPreference.a(ForceMessengerPrefKeys.c);
        orcaListPreference.setDefaultValue(String.valueOf(TriState.UNSET.getDbValue()));
        orcaListPreference.setEntries(new String[]{"Unset (Use GK value)", "Yes", "No"});
        orcaListPreference.setEntryValues(new String[]{String.valueOf(TriState.UNSET.getDbValue()), String.valueOf(TriState.YES.getDbValue()), String.valueOf(TriState.NO.getDbValue())});
        orcaListPreference.setOnPreferenceChangeListener(new C08421(this));
        addPreference(orcaListPreference);
    }
}
