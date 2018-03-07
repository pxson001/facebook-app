package com.facebook.katana;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.FbInjector;
import com.facebook.katana.settings.SettingsHelper;
import com.facebook.katana.util.MutePushNotificationsHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.orca.prefs.preferences.NotificationEnabledPreference;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.prefs.OrcaRingtonePreference;
import com.facebook.widget.titlebar.FbActionBarUtil;

/* compiled from: via_chat_bar_auto_complete_section */
public class NotificationSettingsActivity extends FbPreferenceActivity implements AnalyticsActivity, UsesSimpleStringTitle {
    private FbSharedPreferences f642a;
    private boolean f643b;
    private LockScreenUtil f644c;
    private NotificationEnabledPreference f645d;
    private MutePushNotificationsHelper f646e;
    private OnionUtils f647f;
    public SettingsHelper f648g;
    private PreferenceScreen f649h;

    /* compiled from: via_chat_bar_auto_complete_section */
    class C00921 implements OnCheckedChangeListener {
        final /* synthetic */ NotificationSettingsActivity f641a;

        C00921(NotificationSettingsActivity notificationSettingsActivity) {
            this.f641a = notificationSettingsActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f641a.f648g.a(z ? 1.0f : 0.5f);
            this.f641a.m675a(z);
        }
    }

    protected final void m679a(Bundle bundle) {
        super.a(bundle);
        requestWindowFeature(1);
    }

    protected final void m680c(Bundle bundle) {
        super.c(bundle);
        FbInjector fbInjector = FbInjector.get(this);
        this.f642a = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        this.f644c = LockScreenUtil.a(fbInjector);
        this.f645d = new NotificationEnabledPreference((Context) fbInjector.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), NotificationSettingsUtil.b(fbInjector), FbActionBarUtil.a(fbInjector));
        this.f646e = MutePushNotificationsHelper.b(fbInjector);
        this.f647f = OnionUtils.a(fbInjector);
        this.f643b = Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector).booleanValue();
        this.f648g = SettingsHelper.b(fbInjector);
        this.f648g.a(this);
        this.f649h = getPreferenceManager().createPreferenceScreen(this);
        m676b(this.f649h);
        this.f648g.a(this.f649h);
        setPreferenceScreen(this.f649h);
    }

    protected void onStart() {
        boolean z;
        boolean z2 = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 708489445);
        super.onStart();
        this.f648g.b(this);
        this.f648g.a(2131236461);
        SettingsHelper settingsHelper = this.f648g;
        settingsHelper.e.setVisibility(0);
        settingsHelper.e.setClickable(null == null);
        boolean d = m677d();
        boolean c = this.f647f.c();
        SettingsHelper settingsHelper2 = this.f648g;
        if (c) {
            z = false;
        } else {
            z = true;
        }
        OnCheckedChangeListener c00921 = new C00921(this);
        settingsHelper2.e.setChecked(d);
        settingsHelper2.e.setEnabled(z);
        if (c00921 != null) {
            settingsHelper2.e.setOnCheckedChangeListener(c00921);
        }
        if (c || !d) {
            z2 = false;
        }
        this.f649h.setEnabled(z2);
        this.f648g.a(z2 ? 1.0f : 0.5f);
        LogUtils.c(1969523727, a);
    }

    private boolean m677d() {
        return this.f642a.a(NotificationsPreferenceConstants.i, true);
    }

    private void m675a(boolean z) {
        Editor edit = this.f642a.edit();
        edit.putBoolean(NotificationsPreferenceConstants.i, z);
        edit.commit();
        this.f648g.a(NotificationsPreferenceConstants.i.a(), Boolean.valueOf(z));
        this.f646e.a(!z);
        this.f649h.setEnabled(z);
    }

    private void m673a(PreferenceGroup preferenceGroup) {
        Preference preference = new Preference(this);
        preference.setLayoutResource(2130905056);
        preferenceGroup.addPreference(preference);
    }

    private void m676b(PreferenceGroup preferenceGroup) {
        if (this.f644c.a(false)) {
            preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.j, 2131233672, 2131230750, 2131230749, true));
        }
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.k, 2131236452, 2131236442, true));
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.l, 2131236451, 2131236450, true));
        OrcaRingtonePreference orcaRingtonePreference = new OrcaRingtonePreference(this);
        orcaRingtonePreference.setRingtoneType(2);
        orcaRingtonePreference.a.a(NotificationsPreferenceConstants.m);
        orcaRingtonePreference.setShowSilent(true);
        orcaRingtonePreference.setShowDefault(true);
        orcaRingtonePreference.setTitle(2131236449);
        orcaRingtonePreference.setSummary(2131236448);
        this.f648g.a(orcaRingtonePreference);
        preferenceGroup.addPreference(orcaRingtonePreference);
        m673a(preferenceGroup);
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.n, 2131236447, true));
        this.f645d.setTitle(2131236457);
        preferenceGroup.addPreference(this.f645d);
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.o, 2131236446, true));
        if (!this.f643b) {
            preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.p, 2131236456, true));
            preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.q, 2131236455, true));
        }
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.r, 2131236454, true));
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.s, 2131236445, true));
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.t, 2131236444, true));
        preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.u, 2131236443, true));
        if (!this.f643b) {
            preferenceGroup.addPreference(this.f648g.a(this, NotificationsPreferenceConstants.v, 2131236453, true));
        }
    }

    public final String m678a() {
        return null;
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        if (this.f648g != null) {
            SettingsHelper.a(this);
        }
    }

    public void finish() {
        super.finish();
        if (this.f648g != null) {
            SettingsHelper.b(this);
        }
    }

    public final String am_() {
        return "app_settings";
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1615403440);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.removeAll();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1252388962, a);
    }
}
