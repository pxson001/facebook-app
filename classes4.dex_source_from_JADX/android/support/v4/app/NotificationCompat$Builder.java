package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Style;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* compiled from: 황보 */
public class NotificationCompat$Builder {
    Notification f0A;
    public Notification f1B = new Notification();
    public ArrayList<String> f2C;
    Context f3a;
    CharSequence f4b;
    CharSequence f5c;
    public PendingIntent f6d;
    PendingIntent f7e;
    RemoteViews f8f;
    public Bitmap f9g;
    CharSequence f10h;
    int f11i;
    public int f12j;
    boolean f13k = true;
    boolean f14l;
    Style f15m;
    public CharSequence f16n;
    int f17o;
    int f18p;
    boolean f19q;
    String f20r;
    boolean f21s;
    String f22t;
    ArrayList<Action> f23u = new ArrayList();
    public boolean f24v = false;
    public String f25w;
    public Bundle f26x;
    public int f27y = 0;
    public int f28z = 0;

    public NotificationCompat$Builder(Context context) {
        this.f3a = context;
        this.f1B.when = System.currentTimeMillis();
        this.f1B.audioStreamType = -1;
        this.f12j = 0;
        this.f2C = new ArrayList();
    }

    public final NotificationCompat$Builder m6a(long j) {
        this.f1B.when = j;
        return this;
    }

    public final NotificationCompat$Builder m2a(int i) {
        this.f1B.icon = i;
        return this;
    }

    public final NotificationCompat$Builder m13a(CharSequence charSequence) {
        this.f4b = m1f(charSequence);
        return this;
    }

    public final NotificationCompat$Builder m19b(CharSequence charSequence) {
        this.f5c = m1f(charSequence);
        return this;
    }

    public final NotificationCompat$Builder m17b(int i) {
        this.f11i = i;
        return this;
    }

    public final NotificationCompat$Builder m25d(CharSequence charSequence) {
        this.f10h = m1f(charSequence);
        return this;
    }

    public final NotificationCompat$Builder m4a(int i, int i2, boolean z) {
        this.f17o = i;
        this.f18p = i2;
        this.f19q = z;
        return this;
    }

    public final NotificationCompat$Builder m7a(PendingIntent pendingIntent) {
        this.f6d = pendingIntent;
        return this;
    }

    public final NotificationCompat$Builder m18b(PendingIntent pendingIntent) {
        this.f1B.deleteIntent = pendingIntent;
        return this;
    }

    public final NotificationCompat$Builder m8a(PendingIntent pendingIntent, boolean z) {
        this.f7e = pendingIntent;
        m0a(128, z);
        return this;
    }

    public final NotificationCompat$Builder m26e(CharSequence charSequence) {
        this.f1B.tickerText = m1f(charSequence);
        return this;
    }

    public final NotificationCompat$Builder m9a(Bitmap bitmap) {
        this.f9g = bitmap;
        return this;
    }

    public final NotificationCompat$Builder m10a(Uri uri) {
        this.f1B.sound = uri;
        this.f1B.audioStreamType = -1;
        return this;
    }

    public final NotificationCompat$Builder m16a(long[] jArr) {
        this.f1B.vibrate = jArr;
        return this;
    }

    public final NotificationCompat$Builder m3a(int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        this.f1B.ledARGB = i;
        this.f1B.ledOnMS = i2;
        this.f1B.ledOffMS = i3;
        if (this.f1B.ledOnMS == 0 || this.f1B.ledOffMS == 0) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        Notification notification = this.f1B;
        int i6 = this.f1B.flags & -2;
        if (i4 == 0) {
            i5 = 0;
        }
        notification.flags = i6 | i5;
        return this;
    }

    public final NotificationCompat$Builder m15a(boolean z) {
        m0a(2, z);
        return this;
    }

    public final NotificationCompat$Builder m20b(boolean z) {
        m0a(8, z);
        return this;
    }

    public final NotificationCompat$Builder m23c(boolean z) {
        m0a(16, z);
        return this;
    }

    public final NotificationCompat$Builder m14a(String str) {
        this.f25w = str;
        return this;
    }

    public final NotificationCompat$Builder m22c(int i) {
        this.f1B.defaults = i;
        if ((i & 4) != 0) {
            Notification notification = this.f1B;
            notification.flags |= 1;
        }
        return this;
    }

    private void m0a(int i, boolean z) {
        if (z) {
            Notification notification = this.f1B;
            notification.flags |= i;
            return;
        }
        notification = this.f1B;
        notification.flags &= i ^ -1;
    }

    public final NotificationCompat$Builder m24d(int i) {
        this.f12j = i;
        return this;
    }

    public final NotificationCompat$Builder m5a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.f23u.add(new Action(i, charSequence, pendingIntent));
        return this;
    }

    public final NotificationCompat$Builder m11a(Action action) {
        this.f23u.add(action);
        return this;
    }

    public final NotificationCompat$Builder m12a(Style style) {
        if (this.f15m != style) {
            this.f15m = style;
            if (this.f15m != null) {
                this.f15m.a(this);
            }
        }
        return this;
    }

    public final Notification m21c() {
        return NotificationCompat.a.a(this);
    }

    public static CharSequence m1f(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
