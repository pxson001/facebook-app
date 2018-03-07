package com.facebook.greetingcards.create;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.provider.IProvidePreferences;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: {campaign_type} */
public class GreetingCardsPreferencesProvider implements IProvidePreferences {

    /* compiled from: {campaign_type} */
    class GreetingCardsPreferences extends PreferenceCategory {
        public GreetingCardsPreferences(Context context) {
            super(context);
        }

        protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
            super.onAttachedToHierarchy(preferenceManager);
            setTitle("Greeting Cards - Internal");
            Context context = getContext();
            Preference preference = new Preference(context);
            preference.setTitle("Prefilled card");
            preference.setSummary("Go to your prefilled card.");
            preference.setIntent(new Intent(context, PreviewCardActivity.class));
            addPreference(preference);
        }
    }

    public static GreetingCardsPreferencesProvider m128a(InjectorLike injectorLike) {
        return new GreetingCardsPreferencesProvider();
    }

    public final List<Preference> m129a(Context context) {
        return ImmutableList.of(new GreetingCardsPreferences(context));
    }
}
