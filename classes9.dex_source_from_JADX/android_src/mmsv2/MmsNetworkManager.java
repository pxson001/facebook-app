package android_src.mmsv2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: setRecipientEligibility */
public class MmsNetworkManager {
    private static final String[] f3781a = new String[]{"already active", "request started", "type not available", "request failed", "already inactive", "unknown"};
    private static volatile long f3782b = 180000;
    private final Context f3783c;
    private final ConnectivityManager f3784d;
    private boolean f3785e;
    public int f3786f;
    private int f3787g;
    public Timer f3788h;
    private final MmsHttpClient f3789i;
    private final IntentFilter f3790j;
    private final BroadcastReceiver f3791k = new C03401(this);

    /* compiled from: setRecipientEligibility */
    class C03401 extends BroadcastReceiver {
        final /* synthetic */ MmsNetworkManager f3779a;

        C03401(MmsNetworkManager mmsNetworkManager) {
            this.f3779a = mmsNetworkManager;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1567207005);
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int intExtra;
                if (VERSION.SDK_INT >= 17) {
                    intExtra = intent.getIntExtra("networkType", -1);
                } else {
                    NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    intExtra = networkInfo != null ? networkInfo.getType() : -1;
                }
                if (intExtra != 2) {
                    LogUtils.a(intent, 1381037692, a);
                    return;
                }
                this.f3779a.m3544f();
                LogUtils.a(intent, 2084667386, a);
                return;
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1627091227, a);
        }
    }

    /* compiled from: setRecipientEligibility */
    public class C03412 extends TimerTask {
        final /* synthetic */ MmsNetworkManager f3780a;

        public C03412(MmsNetworkManager mmsNetworkManager) {
            this.f3780a = mmsNetworkManager;
        }

        public void run() {
            synchronized (this) {
                if (this.f3780a.f3786f > 0) {
                    try {
                        MmsNetworkManager.m3547j(this.f3780a);
                    } catch (MmsNetworkException e) {
                    }
                }
            }
        }
    }

    MmsNetworkManager(Context context) {
        this.f3783c = context;
        this.f3784d = (ConnectivityManager) this.f3783c.getSystemService("connectivity");
        this.f3789i = new MmsHttpClient(this.f3783c);
        this.f3790j = new IntentFilter();
        this.f3790j.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f3786f = 0;
        this.f3787g = 0;
    }

    final ConnectivityManager m3553a() {
        return this.f3784d;
    }

    final MmsHttpClient m3554b() {
        return this.f3789i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m3555c() {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.f3786f;	 Catch:{ all -> 0x0029 }
        r0 = r0 + 1;
        r6.f3786f = r0;	 Catch:{ all -> 0x0029 }
        r0 = r6.f3787g;	 Catch:{ all -> 0x0029 }
        r0 = r0 + 1;
        r6.f3787g = r0;	 Catch:{ all -> 0x0029 }
        r0 = r6.f3787g;	 Catch:{ all -> 0x0029 }
        r1 = 1;
        if (r0 != r1) goto L_0x0015;
    L_0x0012:
        r6.m3550m();	 Catch:{ all -> 0x0029 }
    L_0x0015:
        r0 = f3782b;	 Catch:{ all -> 0x0029 }
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0029 }
    L_0x001b:
        r4 = r6.m3552o();	 Catch:{ all -> 0x0029 }
        if (r4 != 0) goto L_0x003b;
    L_0x0021:
        r0 = new android_src.mmsv2.MmsNetworkException;	 Catch:{ all -> 0x0029 }
        r1 = "Mobile data is disabled";
        r0.<init>(r1);	 Catch:{ all -> 0x0029 }
        throw r0;	 Catch:{ all -> 0x0029 }
    L_0x0029:
        r0 = move-exception;
        r1 = r6.f3787g;	 Catch:{ all -> 0x0038 }
        r1 = r1 + -1;
        r6.f3787g = r1;	 Catch:{ all -> 0x0038 }
        r1 = r6.f3787g;	 Catch:{ all -> 0x0038 }
        if (r1 != 0) goto L_0x0037;
    L_0x0034:
        r6.m3551n();	 Catch:{ all -> 0x0038 }
    L_0x0037:
        throw r0;	 Catch:{ all -> 0x0038 }
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r4 = m3547j(r6);	 Catch:{  }
        if (r4 == 0) goto L_0x0050;
    L_0x0041:
        r0 = r6.f3787g;	 Catch:{  }
        r0 = r0 + -1;
        r6.f3787g = r0;	 Catch:{  }
        r0 = r6.f3787g;	 Catch:{  }
        if (r0 != 0) goto L_0x004e;
    L_0x004b:
        r6.m3551n();	 Catch:{  }
    L_0x004e:
        monitor-exit(r6);	 Catch:{  }
    L_0x004f:
        return;
    L_0x0050:
        r4 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r0 = java.lang.Math.min(r0, r4);	 Catch:{ InterruptedException -> 0x007f }
        r4 = -1521277970; // 0xffffffffa55323ee float:-1.8313506E-16 double:NaN;
        com.facebook.tools.dextr.runtime.detour.ObjectDetour.a(r6, r0, r4);	 Catch:{ InterruptedException -> 0x007f }
    L_0x005c:
        r0 = f3782b;	 Catch:{  }
        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{  }
        r4 = r4 - r2;
        r0 = r0 - r4;
        r4 = 0;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x001b;
    L_0x006a:
        r0 = m3547j(r6);	 Catch:{  }
        if (r0 == 0) goto L_0x0088;
    L_0x0070:
        r0 = r6.f3787g;	 Catch:{  }
        r0 = r0 + -1;
        r6.f3787g = r0;	 Catch:{  }
        r0 = r6.f3787g;	 Catch:{  }
        if (r0 != 0) goto L_0x007d;
    L_0x007a:
        r6.m3551n();	 Catch:{  }
    L_0x007d:
        monitor-exit(r6);	 Catch:{  }
        goto L_0x004f;
    L_0x007f:
        r0 = move-exception;
        r1 = "MmsLib";
        r4 = "Unexpected exception";
        com.facebook.debug.log.BLog.a(r1, r4, r0);	 Catch:{  }
        goto L_0x005c;
    L_0x0088:
        r0 = new android_src.mmsv2.MmsNetworkException;	 Catch:{  }
        r1 = "Acquiring MMS network timed out";
        r0.<init>(r1);	 Catch:{  }
        throw r0;	 Catch:{  }
        */
        throw new UnsupportedOperationException("Method not decompiled: android_src.mmsv2.MmsNetworkManager.c():void");
    }

    final void m3556d() {
        synchronized (this) {
            this.f3786f--;
            if (this.f3786f == 0) {
                m3546i();
                m3549l();
            }
        }
    }

    final String m3557e() {
        NetworkInfo networkInfo = this.f3784d.getNetworkInfo(2);
        if (networkInfo != null) {
            return networkInfo.getExtraInfo();
        }
        return null;
    }

    private void m3544f() {
        if (this.f3786f > 0) {
            NetworkInfo networkInfo = this.f3784d.getNetworkInfo(2);
            if (networkInfo != null) {
                if (!"2GVoiceCallEnded".equals(networkInfo.getReason())) {
                    State state = networkInfo.getState();
                    if (state != State.CONNECTED && (state != State.DISCONNECTED || m3552o())) {
                        return;
                    }
                }
                m3545g();
            }
        }
    }

    private void m3545g() {
        synchronized (this) {
            ObjectDetour.c(this, 1260897525);
        }
    }

    private void m3546i() {
        if (this.f3788h != null) {
            this.f3788h.cancel();
            this.f3788h = null;
        }
    }

    public static boolean m3547j(MmsNetworkManager mmsNetworkManager) {
        int k = mmsNetworkManager.m3548k();
        if (k == 0) {
            if (mmsNetworkManager.f3788h != null) {
                return true;
            }
            mmsNetworkManager.f3788h = new Timer("mms_network_extension_timer", true);
            mmsNetworkManager.f3788h.schedule(new C03412(mmsNetworkManager), 30000);
            return true;
        } else if (k == 1) {
            return false;
        } else {
            mmsNetworkManager.m3546i();
            throw new MmsNetworkException("Cannot acquire MMS network: " + k + " - " + m3542a(k));
        }
    }

    private int m3548k() {
        try {
            Method method = this.f3784d.getClass().getMethod("startUsingNetworkFeature", new Class[]{Integer.TYPE, String.class});
            if (method != null) {
                return ((Integer) method.invoke(this.f3784d, new Object[]{Integer.valueOf(0), "enableMMS"})).intValue();
            }
        } catch (Exception e) {
            BLog.a("MmsLib", "ConnectivityManager.startUsingNetworkFeature failed " + e);
        }
        return 3;
    }

    private void m3549l() {
        try {
            Method method = this.f3784d.getClass().getMethod("stopUsingNetworkFeature", new Class[]{Integer.TYPE, String.class});
            if (method != null) {
                method.invoke(this.f3784d, new Object[]{Integer.valueOf(0), "enableMMS"});
            }
        } catch (Exception e) {
            BLog.a("MmsLib", "ConnectivityManager.stopUsingNetworkFeature failed " + e);
        }
    }

    private void m3550m() {
        if (!this.f3785e) {
            this.f3783c.registerReceiver(this.f3791k, this.f3790j);
            this.f3785e = true;
        }
    }

    private void m3551n() {
        if (this.f3785e) {
            this.f3783c.unregisterReceiver(this.f3791k);
            this.f3785e = false;
        }
    }

    private static String m3542a(int i) {
        if (i < 0 || i >= f3781a.length) {
            i = f3781a.length - 1;
        }
        return f3781a[i];
    }

    private boolean m3552o() {
        try {
            Method declaredMethod = this.f3784d.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(this.f3784d, new Object[0])).booleanValue();
        } catch (Throwable e) {
            BLog.a("MmsLib", "TelephonyManager.getMobileDataEnabled failed", e);
            return false;
        }
    }
}
