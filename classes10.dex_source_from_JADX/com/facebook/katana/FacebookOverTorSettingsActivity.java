package com.facebook.katana;

import android.content.Context;
import android.os.Bundle;
import com.facebook.http.onion.ui.FbTorSettingsActivity;
import com.facebook.inject.FbInjector;
import com.facebook.katana.settings.SettingsHelper;
import com.facebook.katana.useragent.UserAgent;
import com.facebook.katana.util.MutePushNotificationsHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import java.util.Arrays;
import javax.inject.Inject;

/* compiled from: via_chat_bar_search_result_section */
public class FacebookOverTorSettingsActivity extends FbTorSettingsActivity {
    private SettingsHelper f530b;
    private MutePushNotificationsHelper f531c;

    private static <T extends Context> void m622a(Class<T> cls, T t) {
        m623a((Object) t, (Context) t);
    }

    public static void m623a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FacebookOverTorSettingsActivity) obj).m621a(SettingsHelper.b(fbInjector), MutePushNotificationsHelper.b(fbInjector));
    }

    protected final void m625a(Bundle bundle) {
        super.a(bundle);
        requestWindowFeature(1);
    }

    @Inject
    private void m621a(SettingsHelper settingsHelper, MutePushNotificationsHelper mutePushNotificationsHelper) {
        this.f530b = settingsHelper;
        this.f531c = mutePushNotificationsHelper;
    }

    protected final void mo23c(Bundle bundle) {
        Class cls = FacebookOverTorSettingsActivity.class;
        m623a((Object) this, (Context) this);
        this.f530b.a(this);
        super.mo23c(bundle);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 678299226);
        super.onStart();
        this.f530b.b(this);
        this.f530b.a(2131236460);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -2003709720, a);
    }

    public final void mo22a(boolean z) {
        boolean z2;
        if (z || !this.f531c.a.a(NotificationsPreferenceConstants.i, true)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f531c.a(z2);
    }

    public final void mo21a() {
        Arrays.fill(UserAgent.f, null);
    }
}
