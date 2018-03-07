package com.facebook.notifications.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.content.ContextCompat;
import com.facebook.common.build.BuildConstants;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: negativefeedback_guided_action */
public class SystemTrayNotificationBuilder {
    public static final long[] f8401a = new long[]{0, 250, 200, 250};
    public final FbSharedPreferences f8402b;
    public SystemTrayNotification f8403c;
    private Context f8404d;
    public boolean f8405e = true;
    public boolean f8406f = true;
    private boolean f8407g = true;
    private boolean f8408h = false;
    public boolean f8409i = false;
    public String f8410j = null;
    public Builder f8411k;

    public static SystemTrayNotificationBuilder m9987b(InjectorLike injectorLike) {
        return new SystemTrayNotificationBuilder((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public SystemTrayNotificationBuilder(Context context, FbSharedPreferences fbSharedPreferences) {
        this.f8404d = context;
        this.f8402b = fbSharedPreferences;
        this.f8411k = new Builder(context);
        this.f8411k.c(true);
        this.f8411k.j = 2;
        this.f8405e = this.f8402b.a(NotificationsPreferenceConstants.l, true);
        this.f8410j = this.f8402b.a(NotificationsPreferenceConstants.m, null);
        this.f8406f = this.f8402b.a(NotificationsPreferenceConstants.k, true);
    }

    public final SystemTrayNotificationBuilder m9988a() {
        this.f8405e = false;
        return this;
    }

    public final SystemTrayNotificationBuilder m9994b() {
        this.f8406f = false;
        return this;
    }

    public final SystemTrayNotificationBuilder m9996c() {
        this.f8407g = false;
        return this;
    }

    public final Notification m9998d() {
        if (this.f8405e) {
            this.f8411k.a(-16776961, 500, 2000);
        }
        if (this.f8407g && this.f8410j != null && this.f8410j.length() > 0) {
            Builder builder = this.f8411k;
            builder.B.sound = Uri.parse(this.f8410j);
            builder.B.audioStreamType = 2;
        }
        if (this.f8406f) {
            this.f8411k.a(f8401a);
        }
        return this.f8411k.c();
    }

    public final SystemTrayNotificationBuilder m9993a(CharSequence charSequence) {
        this.f8411k.b(charSequence);
        return this;
    }

    public final SystemTrayNotificationBuilder m9995b(CharSequence charSequence) {
        this.f8411k.n = Builder.f(charSequence);
        return this;
    }

    public final SystemTrayNotificationBuilder m9999d(CharSequence charSequence) {
        if (BuildConstants.i) {
            charSequence = String.format("%s - beta", new Object[]{charSequence});
        }
        this.f8411k.a(charSequence);
        return this;
    }

    public final SystemTrayNotificationBuilder m9997c(CharSequence charSequence) {
        this.f8411k.e(charSequence);
        return this;
    }

    public final SystemTrayNotificationBuilder m9989a(int i) {
        if (VERSION.SDK_INT >= 21) {
            this.f8411k.y = ContextCompat.b(this.f8404d, 2131361916);
        }
        this.f8411k.a(i);
        return this;
    }

    public final SystemTrayNotificationBuilder m9991a(long j) {
        this.f8411k.a(j);
        return this;
    }

    public final SystemTrayNotificationBuilder m9992a(WearableExtender wearableExtender) {
        wearableExtender.a(this.f8411k);
        return this;
    }

    public final SystemTrayNotificationBuilder m9990a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.f8411k.a(i, charSequence, pendingIntent);
        this.f8408h = true;
        return this;
    }
}
