package com.facebook.messaging.connectivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BannerNotification;
import com.facebook.common.banner.BasicBannerNotificationView;
import com.facebook.common.banner.BasicBannerNotificationView.Params.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.trafficcontrol.pref.TrafficControlPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Date;
import javax.inject.Inject;

/* compiled from: is_most_visited */
public class NetworkEmpathyStatusNotification extends AbstractBannerNotification {
    private final Context f12036a;
    private final LayoutInflater f12037b;
    private final Resources f12038c = this.f12036a.getResources();
    public final FbSharedPreferences f12039d;
    private final OnSharedPreferenceChangeListener f12040e = new C07761(this);

    /* compiled from: is_most_visited */
    class C07761 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ NetworkEmpathyStatusNotification f12035a;

        C07761(NetworkEmpathyStatusNotification networkEmpathyStatusNotification) {
            this.f12035a = networkEmpathyStatusNotification;
        }

        public final void m18939a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            NetworkEmpathyStatusNotification.m18941e(this.f12035a);
        }
    }

    private static NetworkEmpathyStatusNotification m18940b(InjectorLike injectorLike) {
        return new NetworkEmpathyStatusNotification((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NetworkEmpathyStatusNotification(Context context, LayoutInflater layoutInflater, FbSharedPreferences fbSharedPreferences) {
        super("NetworkEmpathyStatusNotification");
        this.f12036a = context;
        this.f12037b = layoutInflater;
        this.f12039d = fbSharedPreferences;
    }

    public final void mo919b() {
        m18941e(this);
        this.f12039d.a(TrafficControlPrefKeys.b, this.f12040e);
    }

    public final void mo920c() {
        this.f12039d.b(TrafficControlPrefKeys.b, this.f12040e);
    }

    public final View mo1084a(ViewGroup viewGroup) {
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) this.f12037b.inflate(2130903387, viewGroup, false);
        String str = "";
        long a = this.f12039d.a(TrafficControlPrefKeys.e, 0);
        if (a > 0) {
            str = (str + " Until ") + DateFormat.getTimeFormat(this.f12036a).format(new Date(a));
        }
        Builder builder = new Builder();
        builder.a = "[FB-ONLY] 2G Empathy Enabled" + str;
        Builder builder2 = builder;
        builder2.c = this.f12038c.getDrawable(2131362399);
        builder2 = builder2;
        builder2.i = new ColorDrawable(this.f12038c.getColor(2131362400));
        basicBannerNotificationView.setParams(builder2.a());
        return basicBannerNotificationView;
    }

    public static void m18941e(NetworkEmpathyStatusNotification networkEmpathyStatusNotification) {
        if (networkEmpathyStatusNotification.f12039d.a(TrafficControlPrefKeys.b, false)) {
            networkEmpathyStatusNotification.f7685a.m11015a((BannerNotification) networkEmpathyStatusNotification);
        } else {
            networkEmpathyStatusNotification.f7685a.m11019b((BannerNotification) networkEmpathyStatusNotification);
        }
    }
}
