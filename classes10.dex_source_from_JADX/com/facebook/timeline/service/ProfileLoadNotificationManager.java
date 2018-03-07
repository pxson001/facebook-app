package com.facebook.timeline.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationManagerCompat;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.ultralight.Inject;
import javax.inject.Provider;

/* compiled from: extra_parent_group_name */
public class ProfileLoadNotificationManager {
    @Inject
    @LoggedInUserId
    Provider<String> f12682a;
    @Inject
    private Context f12683b;
    @Inject
    private Resources f12684c;
    @Inject
    private Provider<UriIntentMapper> f12685d;
    @Inject
    private Provider<TimelineAnalyticsLogger> f12686e;

    public static ProfileLoadNotificationManager m12626b(InjectorLike injectorLike) {
        ProfileLoadNotificationManager profileLoadNotificationManager = new ProfileLoadNotificationManager();
        profileLoadNotificationManager.m12623a((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2436), IdBasedProvider.a(injectorLike, 11293), IdBasedProvider.a(injectorLike, 4442));
        return profileLoadNotificationManager;
    }

    private void m12623a(Context context, Resources resources, Provider<UriIntentMapper> provider, Provider<TimelineAnalyticsLogger> provider2, Provider<String> provider3) {
        this.f12683b = context;
        this.f12684c = resources;
        this.f12685d = provider;
        this.f12686e = provider2;
        this.f12682a = provider3;
    }

    private Notification m12619a(long j, String str, @StringRes int i, boolean z, Bundle bundle) {
        boolean z2;
        Builder builder = new Builder(this.f12683b);
        builder.d = m12620a(j, bundle, z);
        Builder c = builder.a(this.f12684c.getString(2131235067)).b(this.f12684c.getString(i, new Object[]{str})).c(-1);
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        builder = c.c(z2).a(z);
        builder.j = 1;
        return builder.a(0, 0, z).a(2130843529).c();
    }

    public final void m12628a(long j, String str, Bundle bundle) {
        m12622a(m12619a(j, str, m12624a(j) ? 2131235071 : 2131235070, true, bundle), j);
    }

    public final void m12630b(long j, String str, Bundle bundle) {
        m12622a(m12619a(j, str, m12624a(j) ? 2131235069 : 2131235068, false, bundle), j);
        ((TimelineAnalyticsLogger) this.f12686e.get()).a(0, j);
    }

    public final void m12627a(long j, String str) {
        m12621a(j, str, m12624a(j) ? 2131235080 : 2131235079);
        ((TimelineAnalyticsLogger) this.f12686e.get()).a(1, j);
    }

    public final void m12629b(long j, String str) {
        m12621a(j, str, m12624a(j) ? 2131235084 : 2131235083);
    }

    private void m12621a(long j, String str, @StringRes int i) {
        PendingIntent activity = PendingIntent.getActivity(this.f12683b, 0, new Intent(), 134217728);
        Builder builder = new Builder(this.f12683b);
        builder.d = activity;
        Builder c = builder.a(this.f12684c.getString(2131235067)).b(this.f12684c.getString(i, new Object[]{str})).c(-1);
        c.j = 1;
        m12622a(c.a(2130843529).a(false).c(true).a(0, 0, false).c(), j);
    }

    private boolean m12624a(long j) {
        return this.f12682a.get() != null && Long.parseLong((String) this.f12682a.get()) == j;
    }

    private void m12622a(Notification notification, long j) {
        NotificationManagerCompat.a(this.f12683b).a(m12625b(j), notification);
    }

    private static int m12625b(long j) {
        return (int) ((j >>> 32) ^ j);
    }

    private PendingIntent m12620a(long j, Bundle bundle, boolean z) {
        Intent a = ((UriIntentMapper) this.f12685d.get()).a(this.f12683b, StringFormatUtil.a(FBLinks.aX, new Object[]{Long.valueOf(j)}));
        a.putExtras(bundle);
        if (!z) {
            a.putExtra("is_from_get_notified_notification", true);
        }
        return SecurePendingIntent.a(this.f12683b, m12625b(j), a, 134217728);
    }
}
