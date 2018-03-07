package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationManagerCompat.Task;

/* compiled from: web_view */
class NotificationManagerCompat$NotifyTask implements Task {
    final String f185a;
    final int f186b;
    final String f187c;
    final Notification f188d;

    public NotificationManagerCompat$NotifyTask(String str, int i, String str2, Notification notification) {
        this.f185a = str;
        this.f186b = i;
        this.f187c = str2;
        this.f188d = notification;
    }

    public final void m192a(INotificationSideChannel iNotificationSideChannel) {
        iNotificationSideChannel.mo17a(this.f185a, this.f186b, this.f187c, this.f188d);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
        stringBuilder.append("packageName:").append(this.f185a);
        stringBuilder.append(", id:").append(this.f186b);
        stringBuilder.append(", tag:").append(this.f187c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
