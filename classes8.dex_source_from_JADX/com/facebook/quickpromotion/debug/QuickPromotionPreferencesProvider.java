package com.facebook.quickpromotion.debug;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.provider.IProvidePreferences;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: refetchAlbumDetails */
public class QuickPromotionPreferencesProvider implements IProvidePreferences {

    /* compiled from: refetchAlbumDetails */
    class QuickPromotionPreferences extends PreferenceCategory {
        public QuickPromotionPreferences(Context context) {
            super(context);
        }

        protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
            super.onAttachedToHierarchy(preferenceManager);
            setTitle("Promotions - Internal");
            Context context = getContext();
            Preference preference = new Preference(context);
            preference.setTitle("Quick Promotion Config");
            preference.setSummary("View quick promotion configuration");
            preference.setIntent(new Intent(context, QuickPromotionSettingsActivity.class));
            addPreference(preference);
            preference = new Preference(context);
            preference.setTitle("Segues");
            preference.setSummary("View/Launch view intent FB URIs a.k.a. segues");
            preference.setIntent(new Intent(context, SeguePreviewSettingsActivity.class));
            addPreference(preference);
        }
    }

    public static QuickPromotionPreferencesProvider m4493a(InjectorLike injectorLike) {
        return new QuickPromotionPreferencesProvider();
    }

    public final List<Preference> m4494a(Context context) {
        return ImmutableList.of(new QuickPromotionPreferences(context));
    }
}
