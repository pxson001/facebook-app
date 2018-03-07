package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

/* compiled from: visibility_sentence */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f222a = new SparseArray();
    private static int f223b = 1;

    public static ComponentName m235a(Context context, Intent intent) {
        synchronized (f222a) {
            int i = f223b;
            int i2 = f223b + 1;
            f223b = i2;
            if (i2 <= 0) {
                f223b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f222a.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean m236a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f222a) {
            WakeLock wakeLock = (WakeLock) f222a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f222a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
