package com.facebook.abtest.qe.preferences;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.abtest.qe.settings.QuickExperimentListActivity;
import com.facebook.widget.prefs.OrcaGatedPreference;
import com.google.common.base.Preconditions;
import javax.inject.Provider;

/* compiled from: totalClicks */
public class QuickExperimentPreferences extends PreferenceCategory implements OrcaGatedPreference {
    private final Provider<Boolean> f1733a;

    public QuickExperimentPreferences(Context context, Provider<Boolean> provider) {
        super(context);
        this.f1733a = (Provider) Preconditions.checkNotNull(provider);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("A/B Testing - internal");
        if (((Boolean) this.f1733a.get()).booleanValue()) {
            Preference preference = new Preference(getContext());
            preference.setTitle("Quick Experiment");
            preference.setSummary("View/Override/Expire QE configuration");
            preference.setIntent(QuickExperimentListActivity.m2463a(getContext()));
            addPreference(preference);
        }
    }

    public final boolean mo475a() {
        return ((Boolean) this.f1733a.get()).booleanValue();
    }
}
