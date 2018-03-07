package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatBase.Action;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* compiled from: website_duplicate_report */
class NotificationCompatKitKat {

    /* compiled from: website_duplicate_report */
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private android.app.Notification.Builder f182a;
        private Bundle f183b;
        private List<Bundle> f184c = new ArrayList();

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            android.app.Notification.Builder lights = new android.app.Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f182a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f183b = new Bundle();
            if (bundle != null) {
                this.f183b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f183b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f183b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f183b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f183b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f183b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f183b.putString("android.support.sortKey", str2);
            }
        }

        public final void mo33a(Action action) {
            this.f184c.add(NotificationCompatJellybean.m185a(this.f182a, action));
        }

        public final android.app.Notification.Builder mo32a() {
            return this.f182a;
        }

        public final Notification m191b() {
            SparseArray a = NotificationCompatJellybean.m187a(this.f184c);
            if (a != null) {
                this.f183b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f182a.setExtras(this.f183b);
            return this.f182a.build();
        }
    }

    NotificationCompatKitKat() {
    }
}
