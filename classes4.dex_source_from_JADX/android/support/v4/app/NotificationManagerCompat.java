package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.provider.Settings.Secure;
import android.support.v4.app.INotificationSideChannel.Stub.Proxy;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: settings/pichead */
public class NotificationManagerCompat {
    public static final int f2340a = f2346i.mo188a();
    private static final Object f2341b = new Object();
    private static String f2342c;
    private static Set<String> f2343d = new HashSet();
    private static final Object f2344g = new Object();
    private static SideChannelManager f2345h;
    private static final Impl f2346i;
    private final Context f2347e;
    private final NotificationManager f2348f = ((NotificationManager) this.f2347e.getSystemService("notification"));

    /* compiled from: settings/pichead */
    class ImplIceCreamSandwich extends ImplEclair {
        ImplIceCreamSandwich() {
        }

        public final int mo188a() {
            return 33;
        }
    }

    /* compiled from: settings/pichead */
    class ImplEclair extends ImplBase {
        public final void mo189a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(str, i);
        }

        public final void mo190a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(str, i, notification);
        }

        ImplEclair() {
        }
    }

    /* compiled from: settings/pichead */
    class ImplBase implements Impl {
        ImplBase() {
        }

        public void mo189a(NotificationManager notificationManager, String str, int i) {
            notificationManager.cancel(i);
        }

        public void mo190a(NotificationManager notificationManager, String str, int i, Notification notification) {
            notificationManager.notify(i, notification);
        }

        public int mo188a() {
            return 1;
        }
    }

    /* compiled from: settings/pichead */
    interface Impl {
        int mo188a();

        void mo189a(NotificationManager notificationManager, String str, int i);

        void mo190a(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    /* compiled from: settings/pichead */
    class CancelTask implements Task {
        final String f2827a;
        final int f2828b;
        final String f2829c;
        final boolean f2830d = false;

        public CancelTask(String str, int i, String str2) {
            this.f2827a = str;
            this.f2828b = i;
            this.f2829c = str2;
        }

        public final void mo258a(INotificationSideChannel iNotificationSideChannel) {
            if (this.f2830d) {
                iNotificationSideChannel.a(this.f2827a);
            } else {
                iNotificationSideChannel.a(this.f2827a, this.f2828b, this.f2829c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.f2827a);
            stringBuilder.append(", id:").append(this.f2828b);
            stringBuilder.append(", tag:").append(this.f2829c);
            stringBuilder.append(", all:").append(this.f2830d);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: settings/pichead */
    interface Task {
        void mo258a(INotificationSideChannel iNotificationSideChannel);
    }

    /* compiled from: settings/pichead */
    class SideChannelManager implements ServiceConnection, Callback {
        private final Context f2831a;
        private final HandlerThread f2832b;
        private final Handler f2833c;
        private final Map<ComponentName, ListenerRecord> f2834d = new HashMap();
        private Set<String> f2835e = new HashSet();

        public SideChannelManager(Context context) {
            this.f2831a = context;
            this.f2832b = new HandlerThread("NotificationManagerCompat");
            this.f2832b.start();
            this.f2833c = new Handler(this.f2832b.getLooper(), this);
        }

        public final void m3112a(Task task) {
            this.f2833c.obtainMessage(0, task).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    m3109b((Task) message.obj);
                    return true;
                case 1:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    m3105a(serviceConnectedEvent.a, serviceConnectedEvent.b);
                    return true;
                case 2:
                    m3104a((ComponentName) message.obj);
                    return true;
                case 3:
                    m3107b((ComponentName) message.obj);
                    return true;
                default:
                    return false;
            }
        }

        private void m3109b(Task task) {
            m3103a();
            for (ListenerRecord listenerRecord : this.f2834d.values()) {
                listenerRecord.d.add(task);
                m3111d(listenerRecord);
            }
        }

        private void m3105a(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f2834d.get(componentName);
            if (listenerRecord != null) {
                INotificationSideChannel iNotificationSideChannel;
                if (iBinder == null) {
                    iNotificationSideChannel = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof INotificationSideChannel)) {
                        iNotificationSideChannel = new Proxy(iBinder);
                    } else {
                        iNotificationSideChannel = (INotificationSideChannel) queryLocalInterface;
                    }
                }
                listenerRecord.c = iNotificationSideChannel;
                listenerRecord.e = 0;
                m3111d(listenerRecord);
            }
        }

        private void m3104a(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f2834d.get(componentName);
            if (listenerRecord != null) {
                m3108b(listenerRecord);
            }
        }

        private void m3107b(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.f2834d.get(componentName);
            if (listenerRecord != null) {
                m3111d(listenerRecord);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2833c.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2833c.obtainMessage(2, componentName).sendToTarget();
        }

        private void m3103a() {
            Set b = NotificationManagerCompat.m2555b(this.f2831a);
            if (!b.equals(this.f2835e)) {
                this.f2835e = b;
                List<ResolveInfo> queryIntentServices = this.f2831a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
                Set<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (b.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f2834d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f2834d.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator it = this.f2834d.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        m3108b((ListenerRecord) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        private boolean m3106a(ListenerRecord listenerRecord) {
            if (listenerRecord.b) {
                return true;
            }
            listenerRecord.b = ServiceConnectionDetour.a(this.f2831a, new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.a), this, NotificationManagerCompat.f2340a, 2077032985);
            if (listenerRecord.b) {
                listenerRecord.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + listenerRecord.a);
                ServiceConnectionDetour.a(this.f2831a, this, 583096951);
            }
            return listenerRecord.b;
        }

        private void m3108b(ListenerRecord listenerRecord) {
            if (listenerRecord.b) {
                ServiceConnectionDetour.a(this.f2831a, this, -1808198308);
                listenerRecord.b = false;
            }
            listenerRecord.c = null;
        }

        private void m3110c(ListenerRecord listenerRecord) {
            if (!this.f2833c.hasMessages(3, listenerRecord.a)) {
                listenerRecord.e++;
                if (listenerRecord.e > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + listenerRecord.d.size() + " tasks to " + listenerRecord.a + " after " + listenerRecord.e + " retries");
                    listenerRecord.d.clear();
                    return;
                }
                int i = (1 << (listenerRecord.e - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
                }
                this.f2833c.sendMessageDelayed(this.f2833c.obtainMessage(3, listenerRecord.a), (long) i);
            }
        }

        private void m3111d(ListenerRecord listenerRecord) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + listenerRecord.a + ", " + listenerRecord.d.size() + " queued tasks");
            }
            if (!listenerRecord.d.isEmpty()) {
                if (!m3106a(listenerRecord) || listenerRecord.c == null) {
                    m3110c(listenerRecord);
                    return;
                }
                while (true) {
                    Task task = (Task) listenerRecord.d.peek();
                    if (task == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + task);
                        }
                        task.mo258a(listenerRecord.c);
                        listenerRecord.d.remove();
                    } catch (DeadObjectException e) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + listenerRecord.a);
                        }
                    } catch (Throwable e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + listenerRecord.a, e2);
                    }
                }
                if (!listenerRecord.d.isEmpty()) {
                    m3110c(listenerRecord);
                }
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f2346i = new ImplIceCreamSandwich();
        } else if (VERSION.SDK_INT >= 5) {
            f2346i = new ImplEclair();
        } else {
            f2346i = new ImplBase();
        }
    }

    public static NotificationManagerCompat m2553a(Context context) {
        return new NotificationManagerCompat(context);
    }

    private NotificationManagerCompat(Context context) {
        this.f2347e = context;
    }

    public final void m2556a(int i) {
        m2558a(null, i);
    }

    public final void m2558a(String str, int i) {
        f2346i.mo189a(this.f2348f, str, i);
        if (VERSION.SDK_INT <= 19) {
            m2554a(new CancelTask(this.f2347e.getPackageName(), i, str));
        }
    }

    public final void m2557a(int i, Notification notification) {
        m2559a(null, i, notification);
    }

    public static Set<String> m2555b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        if (!(string == null || string.equals(f2342c))) {
            String[] split = string.split(":");
            Set hashSet = new HashSet(split.length);
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null) {
                    hashSet.add(unflattenFromString2.getPackageName());
                }
            }
            synchronized (f2341b) {
                f2343d = hashSet;
                f2342c = string;
            }
        }
        return f2343d;
    }

    private void m2554a(Task task) {
        synchronized (f2344g) {
            if (f2345h == null) {
                f2345h = new SideChannelManager(this.f2347e.getApplicationContext());
            }
        }
        f2345h.m3112a(task);
    }

    public final void m2559a(String str, int i, Notification notification) {
        Object obj;
        Bundle a = NotificationCompat.a.a(notification);
        if (a == null || !a.getBoolean("android.support.useSideChannel")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m2554a(new NotifyTask(this.f2347e.getPackageName(), i, str, notification));
            f2346i.mo189a(this.f2348f, str, i);
            return;
        }
        f2346i.mo190a(this.f2348f, str, i, notification);
    }
}
