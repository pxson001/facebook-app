package com.facebook.katana;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.datasensitivity.analytics.DsmAnalyticsEventLogger;
import com.facebook.datasensitivity.pref.DataSensitivityPreferenceConstants;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.settings.SettingsHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: TEST_FOLLOW_TOOL */
public class DataSavingsModeSettingsActivity extends FbPreferenceActivity {
    public SettingsHelper f14163a;
    public DsmAnalyticsEventLogger f14164b;
    private PreferenceScreen f14165c;
    public DataSensitivitySettingsPrefUtil f14166d;

    /* compiled from: TEST_FOLLOW_TOOL */
    class C13641 implements OnPreferenceChangeListener {
        final /* synthetic */ DataSavingsModeSettingsActivity f14161a;

        C13641(DataSavingsModeSettingsActivity dataSavingsModeSettingsActivity) {
            this.f14161a = dataSavingsModeSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f14161a.f14163a.m23546a(preference, obj);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f14161a.f14166d.d(booleanValue);
            if (booleanValue) {
                this.f14161a.f14164b.f();
            } else {
                this.f14161a.f14164b.g();
            }
            return true;
        }
    }

    /* compiled from: TEST_FOLLOW_TOOL */
    class C13652 implements OnPreferenceChangeListener {
        final /* synthetic */ DataSavingsModeSettingsActivity f14162a;

        C13652(DataSavingsModeSettingsActivity dataSavingsModeSettingsActivity) {
            this.f14162a = dataSavingsModeSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f14162a.f14163a.m23546a(preference, obj);
            if (((Boolean) obj).booleanValue()) {
                this.f14162a.f14164b.h();
            } else {
                this.f14162a.f14164b.i();
            }
            return true;
        }
    }

    private static <T extends Context> void m23525a(Class<T> cls, T t) {
        m23526a((Object) t, (Context) t);
    }

    public static void m23526a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((DataSavingsModeSettingsActivity) obj).m23524a(DsmAnalyticsEventLogger.a(injectorLike), SettingsHelper.m23538b(injectorLike), DataSensitivitySettingsPrefUtil.a(injectorLike));
    }

    @Inject
    private void m23524a(DsmAnalyticsEventLogger dsmAnalyticsEventLogger, SettingsHelper settingsHelper, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil) {
        this.f14164b = dsmAnalyticsEventLogger;
        this.f14163a = settingsHelper;
        this.f14166d = dataSensitivitySettingsPrefUtil;
    }

    protected final void mo1282a(Bundle bundle) {
        super.mo1282a(bundle);
        requestWindowFeature(1);
    }

    protected final void mo472c(Bundle bundle) {
        super.mo472c(bundle);
        this.f14165c = getPreferenceManager().createPreferenceScreen(this);
        Class cls = DataSavingsModeSettingsActivity.class;
        m23526a((Object) this, (Context) this);
        setPreferenceScreen(this.f14165c);
        this.f14163a.m23548a((FbPreferenceActivity) this);
        m23523a(this.f14165c);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1411570321);
        super.onStart();
        this.f14163a.m23550b((FbPreferenceActivity) this);
        this.f14163a.m23544a(2131233809);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 692592952, a);
    }

    private void m23523a(PreferenceGroup preferenceGroup) {
        m23528b(preferenceGroup);
        m23530c(preferenceGroup);
        if (this.f14166d.c()) {
            m23532e(preferenceGroup);
            m23531d(preferenceGroup);
        }
    }

    private void m23528b(PreferenceGroup preferenceGroup) {
        Preference a = this.f14163a.m23540a(this, DataSensitivityPreferenceConstants.f11770b, 2131233809, 2131233811, 2131233810, false);
        preferenceGroup.addPreference(a);
        a.setOnPreferenceChangeListener(new C13641(this));
    }

    private void m23530c(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setLayoutResource(2130907320);
        preference.setSummary(2131233812);
        preferenceGroup.addPreference(preference);
    }

    private void m23531d(PreferenceGroup preferenceGroup) {
        Preference a = this.f14163a.m23540a(this, DataSensitivityPreferenceConstants.f11771c, 2131233813, 2131233815, 2131233814, false);
        preferenceGroup.addPreference(a);
        a.setDependency(DataSensitivityPreferenceConstants.f11770b.a());
        a.setOnPreferenceChangeListener(new C13652(this));
    }

    private void m23532e(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setLayoutResource(2130905056);
        preferenceGroup.addPreference(preference);
    }
}
