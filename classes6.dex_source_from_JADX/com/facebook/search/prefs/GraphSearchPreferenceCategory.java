package com.facebook.search.prefs;

import android.content.Context;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.search.common.errors.prefs.SearchErrorPrefKeys;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;

/* compiled from: event_ticket_order */
public class GraphSearchPreferenceCategory extends PreferenceCategory {
    public GraphSearchPreferenceCategory(Context context) {
        super(context);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Graph Search - internal");
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(getContext());
        checkBoxOrSwitchPreference.setTitle("Toast all Graph Search errors");
        checkBoxOrSwitchPreference.setSummary("Any Graph Search errors encountered (network, unexpected conditions, etc.) will appear in a toast");
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        checkBoxOrSwitchPreference.a(SearchErrorPrefKeys.f15854a);
        addPreference(checkBoxOrSwitchPreference);
    }
}
