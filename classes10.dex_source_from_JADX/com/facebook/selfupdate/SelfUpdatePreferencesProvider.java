package com.facebook.selfupdate;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.provider.IProvidePreferences;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.prefs.OrcaListPreferenceWithSummaryValue;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: has_installed_launcher */
public class SelfUpdatePreferencesProvider implements IProvidePreferences {
    private final SelfUpdateChecker f10025a;
    private final SelfUpdateManager f10026b;

    /* compiled from: has_installed_launcher */
    class SelfUpdatePreferences extends PreferenceCategory {
        private final SelfUpdateChecker f10023a;
        public final SelfUpdateManager f10024b;

        public SelfUpdatePreferences(Context context, SelfUpdateManager selfUpdateManager, SelfUpdateChecker selfUpdateChecker) {
            super(context);
            this.f10024b = selfUpdateManager;
            this.f10023a = selfUpdateChecker;
        }

        protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
            super.onAttachedToHierarchy(preferenceManager);
            setTitle("Update - Internal");
            final Context context = getContext();
            Preference preference = new Preference(context);
            preference.setTitle("Force App Update");
            preference.setSummary("Download and install the latest version right now (bypasses WiFi/version checks)");
            preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ SelfUpdatePreferences f10022b;

                public boolean onPreferenceClick(Preference preference) {
                    Toast.makeText(context, "Preparing to download", 1).show();
                    this.f10022b.f10024b.a(true);
                    return true;
                }
            });
            addPreference(preference);
            CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(context);
            checkBoxOrSwitchPreference.setTitle("Allow On Local Builds");
            checkBoxOrSwitchPreference.a(SelfUpdateConstants.D);
            checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
            checkBoxOrSwitchPreference.setSummary("Enable selfupdate on local (developer) builds");
            addPreference(checkBoxOrSwitchPreference);
            OrcaListPreferenceWithSummaryValue orcaListPreferenceWithSummaryValue = new OrcaListPreferenceWithSummaryValue(context);
            orcaListPreferenceWithSummaryValue.setTitle("Update Source");
            orcaListPreferenceWithSummaryValue.a(SelfUpdateConstants.E);
            String str = this.f10023a.c() ? "Oxygen" : "App Channels";
            orcaListPreferenceWithSummaryValue.setEntries(new CharSequence[]{"Default (" + str + ")", "App Channels (ie, FQL)", "Oxygen"});
            orcaListPreferenceWithSummaryValue.setEntryValues(new CharSequence[]{"default", "fql", "oxygen"});
            orcaListPreferenceWithSummaryValue.setDefaultValue("default");
            addPreference(orcaListPreferenceWithSummaryValue);
        }
    }

    public static SelfUpdatePreferencesProvider m10106a(InjectorLike injectorLike) {
        return new SelfUpdatePreferencesProvider(SelfUpdateChecker.b(injectorLike), SelfUpdateManager.a(injectorLike));
    }

    @Inject
    public SelfUpdatePreferencesProvider(SelfUpdateChecker selfUpdateChecker, SelfUpdateManager selfUpdateManager) {
        this.f10025a = selfUpdateChecker;
        this.f10026b = selfUpdateManager;
    }

    public final List<Preference> m10107a(Context context) {
        return ImmutableList.of(new SelfUpdatePreferences(context, this.f10026b, this.f10025a));
    }
}
