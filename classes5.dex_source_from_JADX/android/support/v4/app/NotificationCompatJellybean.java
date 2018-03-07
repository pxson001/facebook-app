package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatBase.Action;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* compiled from: webview_base_url */
class NotificationCompatJellybean {
    private static final Object f178a = new Object();
    private static Field f179b;
    private static boolean f180c;
    private static final Object f181d = new Object();

    /* compiled from: webview_base_url */
    public class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
        private android.app.Notification.Builder f175a;
        private final Bundle f176b;
        private List<Bundle> f177c = new ArrayList();

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            android.app.Notification.Builder lights = new android.app.Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOnlyAlertOnce(z5);
            if ((notification.flags & 16) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f175a = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f176b = new Bundle();
            if (bundle != null) {
                this.f176b.putAll(bundle);
            }
            if (z3) {
                this.f176b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f176b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f176b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f176b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f176b.putString("android.support.sortKey", str2);
            }
        }

        public final void mo33a(Action action) {
            this.f177c.add(NotificationCompatJellybean.m185a(this.f175a, action));
        }

        public final android.app.Notification.Builder mo32a() {
            return this.f175a;
        }

        public final Notification m184b() {
            Notification build = this.f175a.build();
            Bundle a = NotificationCompatJellybean.m186a(build);
            Bundle bundle = new Bundle(this.f176b);
            for (String str : this.f176b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = NotificationCompatJellybean.m187a(this.f177c);
            if (a2 != null) {
                NotificationCompatJellybean.m186a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            return build;
        }
    }

    NotificationCompatJellybean() {
    }

    public static void m188a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(notificationBuilderWithBuilderAccessor.mo32a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static SparseArray<Bundle> m187a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m186a(Notification notification) {
        synchronized (f178a) {
            if (f180c) {
                return null;
            }
            try {
                if (f179b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f179b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f180c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f179b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f179b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f180c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f180c = true;
                return null;
            }
        }
    }

    public static Bundle m185a(android.app.Notification.Builder builder, Action action) {
        builder.addAction(action.mo23a(), action.mo24b(), action.mo25c());
        Bundle bundle = new Bundle(action.mo26d());
        if (action.mo27e() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.m213a(action.mo27e()));
        }
        return bundle;
    }
}
