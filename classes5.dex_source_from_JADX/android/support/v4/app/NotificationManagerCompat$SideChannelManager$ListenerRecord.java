package android.support.v4.app;

import android.content.ComponentName;
import android.support.v4.app.NotificationManagerCompat.Task;
import java.util.LinkedList;

/* compiled from: web_view */
class NotificationManagerCompat$SideChannelManager$ListenerRecord {
    public final ComponentName f191a;
    public boolean f192b = false;
    public INotificationSideChannel f193c;
    public LinkedList<Task> f194d = new LinkedList();
    public int f195e = 0;

    public NotificationManagerCompat$SideChannelManager$ListenerRecord(ComponentName componentName) {
        this.f191a = componentName;
    }
}
