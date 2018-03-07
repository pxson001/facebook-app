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
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.notify.bridge.NotificationBridge;
import com.facebook.messaging.notify.bridge.NotificationBridgeMethodAutoProvider;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.util.Date;
import javax.inject.Inject;

/* compiled from: openURI() not supported yet */
public class MuteThreadWarningNotification extends AbstractBannerNotification {
    private final FbSharedPreferences f8123a;
    public final NotificationBridge f8124b;
    private final LayoutInflater f8125c;
    public final BannerNotificationAnalyticsHelper f8126d;
    private final Context f8127e;
    private final OnSharedPreferenceChangeListener f8128f = new C09161(this);
    public ThreadKey f8129g;
    private PrefKey f8130h;

    /* compiled from: openURI() not supported yet */
    class C09161 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ MuteThreadWarningNotification f8121a;

        C09161(MuteThreadWarningNotification muteThreadWarningNotification) {
            this.f8121a = muteThreadWarningNotification;
        }

        public final void m8373a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f8121a.m8381e();
        }
    }

    /* compiled from: openURI() not supported yet */
    class C09172 implements OnClickListener {
        final /* synthetic */ MuteThreadWarningNotification f8122a;

        C09172(MuteThreadWarningNotification muteThreadWarningNotification) {
            this.f8122a = muteThreadWarningNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1802208390);
            this.f8122a.f8126d.a("click", "android_button", "MuteThreadWarningNotification");
            MuteThreadWarningNotification muteThreadWarningNotification = this.f8122a;
            muteThreadWarningNotification.a.b(muteThreadWarningNotification);
            Logger.a(2, EntryType.UI_INPUT_END, 2046837275, a);
        }
    }

    public static MuteThreadWarningNotification m8374a(InjectorLike injectorLike) {
        return new MuteThreadWarningNotification((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), NotificationBridgeMethodAutoProvider.m13137a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), BannerNotificationAnalyticsHelper.b(injectorLike));
    }

    @Inject
    public MuteThreadWarningNotification(Context context, FbSharedPreferences fbSharedPreferences, NotificationBridge notificationBridge, LayoutInflater layoutInflater, BannerNotificationAnalyticsHelper bannerNotificationAnalyticsHelper) {
        super("MuteThreadWarningNotification");
        this.f8127e = context;
        this.f8123a = fbSharedPreferences;
        this.f8124b = notificationBridge;
        this.f8125c = layoutInflater;
        this.f8126d = bannerNotificationAnalyticsHelper;
    }

    public final void m8379b() {
        m8376i();
        m8381e();
    }

    public final void m8380c() {
        m8375h();
    }

    public final View m8377a(ViewGroup viewGroup) {
        CharSequence string;
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) this.f8125c.inflate(2130903387, viewGroup, false);
        NotificationSetting d = this.f8124b.m13136d();
        if (d == NotificationSetting.b) {
            string = this.f8127e.getString(2131231531);
        } else {
            String format = DateFormat.getTimeFormat(this.f8127e).format(new Date(d.d * 1000));
            string = this.f8127e.getString(2131231532, new Object[]{format});
        }
        Builder builder = new Builder();
        builder.a = string;
        Builder builder2 = builder;
        builder2.c = new ColorDrawable(this.f8127e.getResources().getColor(2131362401));
        builder2 = builder2;
        builder2.d = true;
        builder2 = builder2;
        builder2.e = this.f8127e.getString(2131231534);
        basicBannerNotificationView.setParams(builder2.a());
        basicBannerNotificationView.setOnBannerButtonClickListener(new C09172(this));
        return basicBannerNotificationView;
    }

    public final void m8381e() {
        Object obj;
        if (this.f8129g == null || this.f8124b.m13136d().b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.a.a(this);
        } else {
            this.a.b(this);
        }
    }

    public final void m8378a(ThreadKey threadKey) {
        if (this.f8130h != null) {
            m8375h();
        }
        this.f8129g = threadKey;
        if (threadKey != null) {
            this.f8130h = MessagingPrefKeys.a(this.f8129g);
            m8376i();
            return;
        }
        this.f8130h = null;
    }

    private void m8375h() {
        PrefKey prefKey = this.f8130h;
        if (prefKey != null) {
            this.f8123a.b(prefKey, this.f8128f);
        }
    }

    private void m8376i() {
        PrefKey prefKey = this.f8130h;
        if (prefKey != null) {
            this.f8123a.a(prefKey, this.f8128f);
        }
    }
}
