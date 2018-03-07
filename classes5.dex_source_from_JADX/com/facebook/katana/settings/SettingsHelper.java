package com.facebook.katana.settings;

import android.app.Activity;
import android.os.Build.VERSION;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceGroup;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.widget.SwitchCompat;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.prefs.OrcaCheckBoxPreference;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;

/* compiled from: TEST */
public class SettingsHelper {
    private AnalyticsLogger f14171a;
    private ViewGroup f14172b;
    public FbTitleBar f14173c;
    public TextView f14174d;
    public SwitchCompat f14175e;
    private ListView f14176f;

    /* compiled from: TEST */
    class C13672 implements OnPreferenceChangeListener {
        final /* synthetic */ SettingsHelper f14169a;

        C13672(SettingsHelper settingsHelper) {
            this.f14169a = settingsHelper;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f14169a.m23546a(preference, obj);
            return true;
        }
    }

    /* compiled from: TEST */
    class SettingChangedEvent extends HoneyClientEvent {
        final /* synthetic */ SettingsHelper f14170c;

        public SettingChangedEvent(SettingsHelper settingsHelper, String str, Object obj) {
            this.f14170c = settingsHelper;
            super(Actions.f14177a);
            this.e = str;
            this.d = UIElementsTypes.f14212b;
            this.c = "app_settings";
            b("value", obj.toString());
        }
    }

    public static SettingsHelper m23538b(InjectorLike injectorLike) {
        return new SettingsHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public static SettingsHelper m23535a(InjectorLike injectorLike) {
        return m23538b(injectorLike);
    }

    @Inject
    public SettingsHelper(AnalyticsLogger analyticsLogger) {
        this.f14171a = analyticsLogger;
    }

    public final void m23548a(FbPreferenceActivity fbPreferenceActivity) {
        this.f14176f = fbPreferenceActivity.getListView();
        this.f14176f.setBackgroundColor(-1);
        this.f14176f.setCacheColorHint(-1);
        this.f14176f.setDivider(null);
        this.f14176f.setPadding(0, this.f14176f.getPaddingTop(), 0, this.f14176f.getPaddingBottom());
        this.f14176f.setSelector(ContextUtils.f(fbPreferenceActivity, 16843003, 0));
        this.f14176f.setOverScrollMode(2);
        if (this.f14176f.getParent() != null && (this.f14176f.getParent() instanceof View)) {
            ((View) this.f14176f.getParent()).setPadding(0, 0, 0, 0);
        }
        this.f14172b = (ViewGroup) fbPreferenceActivity.getLayoutInflater().inflate(2130907074, null);
    }

    public final void m23550b(final FbPreferenceActivity fbPreferenceActivity) {
        ViewGroup viewGroup = (ViewGroup) fbPreferenceActivity.findViewById(16908290);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        if (viewGroup2 != this.f14172b) {
            viewGroup.removeView(viewGroup2);
            viewGroup.addView(this.f14172b);
            ((ViewGroup) this.f14172b.findViewById(2131559634)).addView(viewGroup2);
            FbTitleBarUtil.b(fbPreferenceActivity);
            this.f14173c = (FbTitleBar) fbPreferenceActivity.findViewById(2131558563);
            this.f14173c.a(new OnClickListener(this) {
                final /* synthetic */ SettingsHelper f14168b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1370480846);
                    fbPreferenceActivity.onBackPressed();
                    Logger.a(2, EntryType.UI_INPUT_END, 1014198274, a);
                }
            });
            ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(new ContextThemeWrapper(fbPreferenceActivity, 2131625236)).inflate(2130907075, null);
            this.f14174d = (TextView) viewGroup3.findViewById(2131559636);
            this.f14173c.setCustomTitleView(viewGroup3);
            this.f14175e = (SwitchCompat) viewGroup3.findViewById(2131559637);
        }
    }

    public final void m23544a(int i) {
        this.f14174d.setText(i);
    }

    public final void m23543a(float f) {
        if (VERSION.SDK_INT < 11) {
            Animation alphaAnimation = new AlphaAnimation(f, f);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.f14176f.startAnimation(alphaAnimation);
            return;
        }
        this.f14176f.setAlpha(f);
    }

    public final void m23547a(PreferenceGroup preferenceGroup) {
        for (int i = 0; i < preferenceGroup.getPreferenceCount(); i++) {
            Preference preference = preferenceGroup.getPreference(i);
            if (preference.getSummary() != null && preference.getLayoutResource() == 2130906362) {
                preference.setLayoutResource(2130906364);
            }
            if (preference instanceof PreferenceGroup) {
                m23547a((PreferenceGroup) preference);
            }
        }
    }

    public final OrcaCheckBoxPreference m23542a(FbPreferenceActivity fbPreferenceActivity, PrefKey prefKey, int i, boolean z) {
        return m23536a(fbPreferenceActivity, prefKey, i, 0, 2131233828, 2131233829, z);
    }

    public final OrcaCheckBoxPreference m23541a(FbPreferenceActivity fbPreferenceActivity, PrefKey prefKey, int i, int i2, boolean z) {
        return m23536a(fbPreferenceActivity, prefKey, i, i2, 0, 0, z);
    }

    public final OrcaCheckBoxPreference m23540a(FbPreferenceActivity fbPreferenceActivity, PrefKey prefKey, int i, int i2, int i3, boolean z) {
        return m23536a(fbPreferenceActivity, prefKey, i, 0, i2, i3, z);
    }

    private OrcaCheckBoxPreference m23536a(FbPreferenceActivity fbPreferenceActivity, PrefKey prefKey, int i, int i2, int i3, int i4, boolean z) {
        Preference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(fbPreferenceActivity);
        checkBoxOrSwitchPreference.m10571a(prefKey);
        checkBoxOrSwitchPreference.setTitle(i);
        if (i2 > 0) {
            checkBoxOrSwitchPreference.setSummary(i2);
        }
        if (i3 > 0) {
            checkBoxOrSwitchPreference.setSummaryOff(i3);
        }
        if (i4 > 0) {
            checkBoxOrSwitchPreference.setSummaryOn(i4);
        }
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(z));
        m23545a(checkBoxOrSwitchPreference);
        return checkBoxOrSwitchPreference;
    }

    public final void m23546a(Preference preference, Object obj) {
        m23549a(preference.getKey(), obj);
    }

    public final void m23549a(String str, Object obj) {
        this.f14171a.c(new SettingChangedEvent(this, str, obj));
    }

    public final void m23545a(Preference preference) {
        preference.setOnPreferenceChangeListener(new C13672(this));
    }

    public static void m23537a(Activity activity) {
        activity.overridePendingTransition(2130968751, 2130968615);
    }

    public static void m23539b(Activity activity) {
        activity.overridePendingTransition(2130968725, 2130968766);
    }
}
