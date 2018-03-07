package com.facebook.video.settings;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.util.TriState;
import com.facebook.graphql.calls.DeviceAutoplaySettingUpdateInputData.UpdateType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.video.settings.VideoPrefs.AutoPlaySettingValue;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.widget.prefs.OrcaEditTextPreference;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.google.android.gms.maps.model.internal.IPolygonDelegate */
public class VideoAutoPlaySettingsActivity extends FbPreferenceActivity {
    @Inject
    AnalyticsLogger f19613a;
    @Inject
    VideoAutoplaySettingsServerMigrationHelper f19614b;
    @Inject
    @IsAutoplaySettingsMigrationEnabled
    Provider<TriState> f19615c;
    @Inject
    FbSharedPreferences f19616d;
    @Inject
    @DefaultAutoPlaySettingsFromServer
    AutoPlaySettingValue f19617e;
    public OrcaCheckBoxPreference f19618f;
    public OrcaCheckBoxPreference f19619g;
    public OrcaCheckBoxPreference f19620h;

    /* compiled from: com.google.android.gms.maps.model.internal.IPolygonDelegate */
    /* synthetic */ class C14621 {
        static final /* synthetic */ int[] f19611a = new int[AutoPlaySettingValue.values().length];

        static {
            try {
                f19611a[AutoPlaySettingValue.ON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19611a[AutoPlaySettingValue.WIFI_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: com.google.android.gms.maps.model.internal.IPolygonDelegate */
    public class PreferenceChangeListener implements OnPreferenceChangeListener {
        final /* synthetic */ VideoAutoPlaySettingsActivity f19612a;

        public PreferenceChangeListener(VideoAutoPlaySettingsActivity videoAutoPlaySettingsActivity) {
            this.f19612a = videoAutoPlaySettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                return false;
            }
            String key = preference.getKey();
            if (key.equals(VideoPrefs.d.toString())) {
                this.f19612a.m28328a(AutoPlaySettingValue.ON);
                this.f19612a.m28318a(this.f19612a.f19618f);
            } else if (key.equals(VideoPrefs.e.toString())) {
                this.f19612a.m28328a(AutoPlaySettingValue.WIFI_ONLY);
                this.f19612a.m28318a(this.f19612a.f19619g);
            } else if (key.equals(VideoPrefs.f.toString())) {
                this.f19612a.m28328a(AutoPlaySettingValue.OFF);
                this.f19612a.m28318a(this.f19612a.f19620h);
            }
            return true;
        }
    }

    private static <T extends Context> void m28321a(Class<T> cls, T t) {
        m28322a((Object) t, (Context) t);
    }

    public static void m28322a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoAutoPlaySettingsActivity) obj).m28319a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), VideoAutoplaySettingsServerMigrationHelper.a(fbInjector), IdBasedProvider.a(fbInjector, 812), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), AutoPlaySettingValue_DefaultAutoPlaySettingsFromServerMethodAutoProvider.a(fbInjector));
    }

    private void m28319a(AnalyticsLogger analyticsLogger, VideoAutoplaySettingsServerMigrationHelper videoAutoplaySettingsServerMigrationHelper, Provider<TriState> provider, FbSharedPreferences fbSharedPreferences, AutoPlaySettingValue autoPlaySettingValue) {
        this.f19613a = analyticsLogger;
        this.f19614b = videoAutoplaySettingsServerMigrationHelper;
        this.f19615c = provider;
        this.f19616d = fbSharedPreferences;
        this.f19617e = autoPlaySettingValue;
    }

    public final void m28329c(Bundle bundle) {
        super.c(bundle);
        setTitle(getString(2131236187));
        Class cls = VideoAutoPlaySettingsActivity.class;
        m28322a((Object) this, (Context) this);
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        OrcaEditTextPreference orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setSummary(getString(2131236191) + "\n\n" + getString(2131236192));
        orcaEditTextPreference.setEnabled(false);
        createPreferenceScreen.addPreference(orcaEditTextPreference);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(getString(2131236193));
        createPreferenceScreen.addPreference(preferenceCategory);
        this.f19618f = m28315a(createPreferenceScreen, VideoPrefs.d, getString(2131236190));
        this.f19619g = m28315a(createPreferenceScreen, VideoPrefs.e, getString(2131236189));
        this.f19620h = m28315a(createPreferenceScreen, VideoPrefs.f, getString(2131236188));
        m28317a();
        orcaEditTextPreference = new OrcaEditTextPreference(this);
        orcaEditTextPreference.setSummary(getString(2131236194));
        orcaEditTextPreference.setEnabled(false);
        createPreferenceScreen.addPreference(orcaEditTextPreference);
        createPreferenceScreen.addPreference(new PreferenceCategory(this));
        this.f19618f.setOnPreferenceChangeListener(new PreferenceChangeListener(this));
        this.f19619g.setOnPreferenceChangeListener(new PreferenceChangeListener(this));
        this.f19620h.setOnPreferenceChangeListener(new PreferenceChangeListener(this));
    }

    public final void m28328a(AutoPlaySettingValue autoPlaySettingValue) {
        VideoAutoPlayListPreferenceSettings.a(this.f19616d, autoPlaySettingValue);
        m28327c(autoPlaySettingValue);
    }

    public static Intent m28314a(Context context) {
        return new Intent(context, VideoAutoPlaySettingsActivity.class);
    }

    private OrcaCheckBoxPreference m28315a(PreferenceScreen preferenceScreen, PrefKey prefKey, String str) {
        OrcaCheckBoxPreference orcaCheckBoxPreference = new OrcaCheckBoxPreference(this);
        orcaCheckBoxPreference.a(prefKey);
        orcaCheckBoxPreference.setTitle(str);
        preferenceScreen.addPreference(orcaCheckBoxPreference);
        return orcaCheckBoxPreference;
    }

    @TargetApi(14)
    private void m28317a() {
        AutoPlaySettingValue b = m28324b();
        VideoAutoPlayListPreferenceSettings.a(this.f19616d, b);
        Preference preference = (OrcaCheckBoxPreference) m28323b(b);
        preference.setChecked(true);
        m28318a(preference);
    }

    private Preference m28323b(AutoPlaySettingValue autoPlaySettingValue) {
        switch (C14621.f19611a[autoPlaySettingValue.ordinal()]) {
            case 1:
                return this.f19618f;
            case 2:
                return this.f19619g;
            default:
                return this.f19620h;
        }
    }

    @TargetApi(14)
    private void m28318a(Preference preference) {
        if (preference == this.f19618f) {
            this.f19618f.setChecked(true);
            this.f19619g.setChecked(false);
            this.f19620h.setChecked(false);
        } else if (preference == this.f19619g) {
            this.f19619g.setChecked(true);
            this.f19618f.setChecked(false);
            this.f19620h.setChecked(false);
        } else if (preference == this.f19620h) {
            this.f19620h.setChecked(true);
            this.f19619g.setChecked(false);
            this.f19618f.setChecked(false);
        }
    }

    private void m28327c(AutoPlaySettingValue autoPlaySettingValue) {
        if (this.f19615c.get() == TriState.YES) {
            this.f19614b.a(this.f19616d, AutoPlaySettingValue.valueOf(autoPlaySettingValue.toString()), UpdateType.SETTING_CHANGE);
            return;
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("autoplay_setting_changed");
        honeyClientEvent.c = "video";
        this.f19613a.c(honeyClientEvent.b("autoplay_setting_value", autoPlaySettingValue.toString().toLowerCase(Locale.US)).b("source", "settings"));
    }

    private AutoPlaySettingValue m28324b() {
        return this.f19614b.a(this.f19617e, this.f19616d);
    }
}
