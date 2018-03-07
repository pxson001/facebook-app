package com.facebook.orca.prefs.preferences;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.NotificationState;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.widget.BetterSwitch;
import com.facebook.widget.prefs.BetterOnPreferenceChangeListener;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.facebook.widget.titlebar.FbActionBarUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: new_id */
public class NotificationEnabledPreference extends CheckBoxOrSwitchPreference {
    private final FbSharedPreferences f6299a;
    private final NotificationSettingsUtil f6300b;
    private NotificationSetting f6301c = this.f6300b.a();
    private BetterOnPreferenceChangeListener f6302d;
    private boolean f6303e;
    private final boolean f6304f;
    @Nullable
    private ThreadKey f6305g;

    /* compiled from: new_id */
    class C09521 implements OnCheckedChangeListener {
        final /* synthetic */ NotificationEnabledPreference f6298a;

        C09521(NotificationEnabledPreference notificationEnabledPreference) {
            this.f6298a = notificationEnabledPreference;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f6298a.callChangeListener(Boolean.valueOf(z))) {
                this.f6298a.setChecked(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    @Inject
    public NotificationEnabledPreference(Context context, FbSharedPreferences fbSharedPreferences, NotificationSettingsUtil notificationSettingsUtil, FbActionBarUtil fbActionBarUtil) {
        super(context);
        this.f6299a = fbSharedPreferences;
        this.f6300b = notificationSettingsUtil;
        this.f6304f = fbActionBarUtil.a();
        if (this.f6304f) {
            setWidgetLayoutResource(2130905719);
        }
        setDefaultValue(Boolean.valueOf(true));
        setKey(MessagingPrefKeys.E.a());
        setSummary(m5976a());
        setTitle(2131231391);
    }

    private String m5976a() {
        if (this.f6301c.c) {
            return null;
        }
        return this.f6300b.a(this.f6301c);
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        boolean z2 = true;
        this.f6303e = true;
        if (this.f6301c.c() == NotificationState.TemporarilyMuted) {
            z2 = false;
        }
        setChecked(z2);
    }

    public void setChecked(boolean z) {
        NotificationSetting notificationSetting;
        super.setChecked(z);
        if (z) {
            notificationSetting = NotificationSetting.a;
        } else {
            notificationSetting = NotificationSetting.a((System.currentTimeMillis() / 1000) + 28800);
        }
        if (this.f6303e) {
            this.f6303e = false;
            return;
        }
        if (this.f6302d != null) {
            this.f6301c.d();
            notificationSetting.d();
        }
        this.f6301c = notificationSetting;
        PrefKey a = this.f6305g != null ? MessagingPrefKeys.a(this.f6305g) : MessagingPrefKeys.F;
        Editor edit = this.f6299a.edit();
        edit.a(a, this.f6301c.a());
        edit.commit();
        setSummary(m5976a());
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        if (this.f6304f) {
            View findViewById = view.findViewById(2131564886);
            if (findViewById != null && (findViewById instanceof BetterSwitch)) {
                BetterSwitch betterSwitch = (BetterSwitch) findViewById;
                betterSwitch.setChecked(isChecked());
                betterSwitch.setOnCheckedChangeListener(new C09521(this));
            }
        }
    }
}
