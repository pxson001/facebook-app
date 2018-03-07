package com.facebook.feed.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;

/* compiled from: admin_click_draft_post */
public class NativeFeedPreferences extends PreferenceCategory {
    public NativeFeedPreferences(Context context) {
        super(context);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        Context context = getContext();
        setTitle("Native Feed - internal");
        Preference preference = new Preference(context);
        preference.setTitle("Native Feed settings");
        preference.setSummary("View/Change Native feed settings for debugging");
        preference.setIntent(new Intent(context, NativeFeedSettingsActivity.class));
        addPreference(preference);
    }
}
