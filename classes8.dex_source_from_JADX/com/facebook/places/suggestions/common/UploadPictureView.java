package com.facebook.places.suggestions.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: search_session_key */
public class UploadPictureView {
    Context f3814a;
    NotificationManager f3815b;
    int f3816c = 0;
    Builder f3817d;
    public PendingIntent f3818e;
    private PendingIntent f3819f;

    @Inject
    public UploadPictureView(Context context, NotificationManager notificationManager) {
        this.f3814a = context;
        this.f3815b = notificationManager;
        this.f3819f = PendingIntent.getActivity(this.f3814a, 0, new Intent(), 134217728);
    }

    public final void m3681a() {
        Builder a = new Builder(this.f3814a).a(17301640).a(this.f3814a.getString(2131235128));
        a.d = this.f3819f;
        this.f3817d = a.a(true).a(100, 0, false);
        this.f3815b.notify(m3680d(), this.f3817d.c());
    }

    public final void m3682a(int i) {
        Preconditions.checkNotNull(this.f3817d);
        if (i / 10 != this.f3816c / 10) {
            this.f3816c = i;
            this.f3817d.a(100, i, false);
            Builder builder = this.f3817d;
            builder.d = this.f3819f;
            this.f3815b.notify(m3680d(), builder.a(this.f3814a.getString(2131235128)).b("").d(null).a(17301640).a(true).a(100, this.f3816c, false).c());
        }
    }

    public final void m3683b() {
        Preconditions.checkNotNull(this.f3817d);
        this.f3817d.a(17301641);
        this.f3817d.b(this.f3814a.getString(2131235129));
        this.f3817d.a(0, 0, false);
        this.f3817d.a(false);
        this.f3815b.notify(m3680d(), this.f3817d.c());
    }

    public final void m3684c() {
        this.f3817d.a(0, 0, false);
        this.f3817d.a(false);
        this.f3817d.a(17301624);
        this.f3817d.b(this.f3814a.getString(2131235130));
        this.f3817d.d = this.f3818e;
        this.f3817d.c(true);
        this.f3815b.notify(m3680d(), this.f3817d.c());
    }

    private int m3680d() {
        return hashCode();
    }
}
