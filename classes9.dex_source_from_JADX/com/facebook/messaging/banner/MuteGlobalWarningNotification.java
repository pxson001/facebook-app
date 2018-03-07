package com.facebook.messaging.banner;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BannerNotificationAnalyticsHelper;
import com.facebook.common.banner.BasicBannerNotificationView;
import com.facebook.common.banner.BasicBannerNotificationView.Params.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.notify.bridge.NotificationBridge;
import com.facebook.messaging.notify.bridge.NotificationBridgeMethodAutoProvider;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Date;
import javax.inject.Inject;

/* compiled from: open_more_tab */
public class MuteGlobalWarningNotification extends AbstractBannerNotification {
    public final NotificationBridge f8115a;
    public final BannerNotificationAnalyticsHelper f8116b;
    private final Context f8117c;
    public final FbSharedPreferences f8118d;
    private final LayoutInflater f8119e;
    public OnSharedPreferenceChangeListener f8120f = new C09141(this);

    /* compiled from: open_more_tab */
    class C09141 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ MuteGlobalWarningNotification f8113a;

        C09141(MuteGlobalWarningNotification muteGlobalWarningNotification) {
            this.f8113a = muteGlobalWarningNotification;
        }

        public final void m8367a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            MuteGlobalWarningNotification.m8369e(this.f8113a);
        }
    }

    /* compiled from: open_more_tab */
    class C09152 implements OnClickListener {
        final /* synthetic */ MuteGlobalWarningNotification f8114a;

        C09152(MuteGlobalWarningNotification muteGlobalWarningNotification) {
            this.f8114a = muteGlobalWarningNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1114786808);
            this.f8114a.f8116b.a("click", "android_button", "MuteGlobalWarningNotification");
            MuteGlobalWarningNotification muteGlobalWarningNotification = this.f8114a;
            muteGlobalWarningNotification.a.b(muteGlobalWarningNotification);
            Logger.a(2, EntryType.UI_INPUT_END, -1476739850, a);
        }
    }

    private static MuteGlobalWarningNotification m8368b(InjectorLike injectorLike) {
        return new MuteGlobalWarningNotification(BannerNotificationAnalyticsHelper.b(injectorLike), (Context) injectorLike.getInstance(Context.class), NotificationBridgeMethodAutoProvider.m13137a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MuteGlobalWarningNotification(BannerNotificationAnalyticsHelper bannerNotificationAnalyticsHelper, Context context, NotificationBridge notificationBridge, FbSharedPreferences fbSharedPreferences, LayoutInflater layoutInflater) {
        super("MuteGlobalWarningNotification");
        this.f8116b = bannerNotificationAnalyticsHelper;
        this.f8117c = context;
        this.f8115a = notificationBridge;
        this.f8118d = fbSharedPreferences;
        this.f8119e = layoutInflater;
    }

    public final View m8370a(ViewGroup viewGroup) {
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) this.f8119e.inflate(2130903387, viewGroup, false);
        String format = DateFormat.getTimeFormat(this.f8117c).format(new Date(this.f8115a.m13135c().d * 1000));
        CharSequence string = this.f8117c.getString(2131231530, new Object[]{format});
        Builder builder = new Builder();
        builder.a = string;
        Builder builder2 = builder;
        builder2.c = new ColorDrawable(this.f8117c.getResources().getColor(2131362401));
        builder2 = builder2;
        builder2.d = true;
        builder2 = builder2;
        builder2.e = this.f8117c.getString(2131231534);
        basicBannerNotificationView.setParams(builder2.a());
        basicBannerNotificationView.setOnBannerButtonClickListener(new C09152(this));
        return basicBannerNotificationView;
    }

    public static void m8369e(MuteGlobalWarningNotification muteGlobalWarningNotification) {
        Object obj;
        if (muteGlobalWarningNotification.f8115a.m13135c().b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            muteGlobalWarningNotification.a.a(muteGlobalWarningNotification);
        } else {
            muteGlobalWarningNotification.a.b(muteGlobalWarningNotification);
        }
    }

    public final void m8372c() {
        this.f8118d.b(MessagingPrefKeys.F, this.f8120f);
    }

    public final void m8371b() {
        this.f8118d.a(MessagingPrefKeys.F, this.f8120f);
        m8369e(this);
    }
}
