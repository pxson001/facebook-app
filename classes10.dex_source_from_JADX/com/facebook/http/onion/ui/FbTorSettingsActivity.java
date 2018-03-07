package com.facebook.http.onion.ui;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: visibleWidth */
public abstract class FbTorSettingsActivity extends FbPreferenceActivity {
    @Inject
    public OnionUtils f362a;
    private PreferenceScreen f363b;

    /* compiled from: visibleWidth */
    public class C00631 implements OnPreferenceChangeListener {
        final /* synthetic */ FbTorSettingsActivity f360a;

        public C00631(FbTorSettingsActivity fbTorSettingsActivity) {
            this.f360a = fbTorSettingsActivity;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            this.f360a.mo21a();
            this.f360a.mo22a(((Boolean) obj).booleanValue());
            FbTorSettingsActivity fbTorSettingsActivity = this.f360a;
            new TorStatusPopoverWindow(fbTorSettingsActivity).a(fbTorSettingsActivity.getListView());
            return true;
        }
    }

    /* compiled from: visibleWidth */
    public class C00642 implements OnPreferenceClickListener {
        final /* synthetic */ FbTorSettingsActivity f361a;

        public C00642(FbTorSettingsActivity fbTorSettingsActivity) {
            this.f361a = fbTorSettingsActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f361a.mo21a();
            return true;
        }
    }

    public static void m495a(Object obj, Context context) {
        ((FbTorSettingsActivity) obj).f362a = OnionUtils.a(FbInjector.get(context));
    }

    public abstract void mo21a();

    public abstract void mo22a(boolean z);

    protected void mo23c(Bundle bundle) {
        super.c(bundle);
        Class cls = FbTorSettingsActivity.class;
        m495a(this, this);
        this.f363b = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(this.f363b);
        PreferenceGroup preferenceGroup = this.f363b;
        TorEnabledPreference torEnabledPreference = new TorEnabledPreference(this);
        torEnabledPreference.setOnPreferenceChangeListener(new C00631(this));
        preferenceGroup.addPreference(torEnabledPreference);
        if (this.f362a.b()) {
            OnionRewriteEnabledPreference onionRewriteEnabledPreference = new OnionRewriteEnabledPreference(this);
            onionRewriteEnabledPreference.setOnPreferenceClickListener(new C00642(this));
            preferenceGroup.addPreference(onionRewriteEnabledPreference);
            onionRewriteEnabledPreference.setDependency(torEnabledPreference.getKey());
        }
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -142405702);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            preferenceScreen.removeAll();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 934126817, a);
    }
}
