package com.facebook.orca.contacts.divebar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.prefs.PushPrefKeys;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.inject.Provider;

/* compiled from: one_page_nux */
public class DivebarAvailabilityDialogFragment extends FbDialogFragment {
    public FbSharedPreferences am;
    public AnalyticsLogger an;
    private Provider<Boolean> ao;

    public final void m5480a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1716491218);
        super.a(bundle);
        FbInjector fbInjector = FbInjector.get(getContext());
        this.am = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        this.an = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        this.ao = IdBasedProvider.a(fbInjector, 4296);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -581928932, a);
    }

    public final Dialog m5481c(Bundle bundle) {
        final boolean a = this.am.a(PushPrefKeys.a, ((Boolean) this.ao.get()).booleanValue());
        return new Builder(getContext()).a(2131231496).a(new CharSequence[]{b(2131231497)}, a ? 0 : -1, new OnClickListener(this) {
            final /* synthetic */ DivebarAvailabilityDialogFragment f5796b;

            public void onClick(DialogInterface dialogInterface, int i) {
                DivebarAvailabilityDialogFragment divebarAvailabilityDialogFragment = this.f5796b;
                boolean z = !a;
                if (z != divebarAvailabilityDialogFragment.am.a(PushPrefKeys.a, true)) {
                    HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
                    honeyClientEvent.d = "button";
                    honeyClientEvent = honeyClientEvent;
                    honeyClientEvent.e = "divebar_availability_dialog";
                    divebarAvailabilityDialogFragment.an.a(honeyClientEvent);
                    honeyClientEvent = new HoneyClientEvent("chat_bar_online_status_change");
                    honeyClientEvent.c = "chat_bar";
                    divebarAvailabilityDialogFragment.an.c(honeyClientEvent.a("state", true).b("source", "divebar_availability_dialog"));
                    divebarAvailabilityDialogFragment.am.edit().putBoolean(PushPrefKeys.a, z).commit();
                }
                this.f5796b.a();
            }
        }).a();
    }
}
