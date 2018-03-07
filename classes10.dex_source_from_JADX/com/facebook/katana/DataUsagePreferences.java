package com.facebook.katana;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.device.DataUsageProperties;
import com.facebook.device.resourcemonitor.DataUsageInfo;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.katana.util.AlertDialogs;
import com.facebook.ultralight.Inject;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import javax.inject.Provider;

/* compiled from: via_chat_bar_unknown_section */
public class DataUsagePreferences extends PreferenceCategory {
    @Inject
    public Provider<ResourceManager> f527a;

    public static void m620a(Object obj, Context context) {
        ((DataUsagePreferences) obj).f527a = IdBasedSingletonScopeProvider.a(FbInjector.get(context), 1066);
    }

    public DataUsagePreferences(Context context) {
        super(context);
        Class cls = DataUsagePreferences.class;
        m620a(this, getContext());
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        final Context context = getContext();
        setTitle("Data Usage - internal");
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(context);
        checkBoxOrSwitchPreference.a(DataUsageProperties.b);
        checkBoxOrSwitchPreference.setTitle("Limit Data Usage");
        checkBoxOrSwitchPreference.setSummary("Limit the amount of data that can be transferred per hour");
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        addPreference(checkBoxOrSwitchPreference);
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(context);
        orcaEditTextPreference.a(DataUsageProperties.c);
        orcaEditTextPreference.getEditText().setInputType(2);
        orcaEditTextPreference.setTitle("Hourly Limit");
        orcaEditTextPreference.setSummary("Amount of data (in K) allowed per hour");
        orcaEditTextPreference.setDefaultValue("1024");
        addPreference(orcaEditTextPreference);
        Preference preference = new Preference(context);
        preference.setTitle("Reset Data");
        preference.setSummary("Reset Data Usage for session");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ DataUsagePreferences f526b;

            public boolean onPreferenceClick(Preference preference) {
                ResourceManager resourceManager = (ResourceManager) this.f526b.f527a.get();
                DataUsageInfo b = resourceManager.b();
                resourceManager.c();
                Long.valueOf(b.a() / 1024);
                AlertDialogs.a(context, "Data usage reset", 17301543, StringFormatUtil.formatStrLocaleSafe("Usage up to this point: %d kb", Long.valueOf(b.a() / 1024)), context.getString(2131230756), null, null, null, null, true).show();
                return true;
            }
        });
        addPreference(preference);
    }
}
