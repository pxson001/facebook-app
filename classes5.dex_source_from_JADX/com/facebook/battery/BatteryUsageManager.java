package com.facebook.battery;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.hardware.BatteryUsageInfo;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: subquestion_labels */
public class BatteryUsageManager {
    private static volatile BatteryUsageManager f2453p;
    private final boolean f2454a = Log.isLoggable("BatteryUsageMonitor", 3);
    private final Context f2455b;
    private final PackageManager f2456c;
    @GuardedBy("this")
    private BatteryUsageInfo f2457d;
    private long f2458e;
    private long f2459f;
    private long f2460g;
    private long f2461h;
    private long f2462i;
    private long f2463j;
    private long f2464k;
    private long f2465l;
    private long f2466m;
    private boolean f2467n;
    private boolean f2468o;

    public static com.facebook.battery.BatteryUsageManager m3571a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2453p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.battery.BatteryUsageManager.class;
        monitor-enter(r1);
        r0 = f2453p;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3579b(r0);	 Catch:{ all -> 0x0035 }
        f2453p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2453p;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.battery.BatteryUsageManager.a(com.facebook.inject.InjectorLike):com.facebook.battery.BatteryUsageManager");
    }

    private static BatteryUsageManager m3579b(InjectorLike injectorLike) {
        return new BatteryUsageManager((Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike));
    }

    @Inject
    public BatteryUsageManager(Context context, PackageManager packageManager, LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f2455b = context;
        this.f2456c = packageManager;
        if (loggedInUserSessionManager != null) {
            boolean z;
            User c = loggedInUserSessionManager.c();
            if (c == null || !c.o) {
                z = false;
            } else {
                z = true;
            }
            this.f2468o = z;
        }
    }

    @Nullable
    public final synchronized BatteryUsageInfo m3587a() {
        BatteryUsageInfo batteryUsageInfo = null;
        synchronized (this) {
            if (!this.f2467n) {
                m3581b();
                batteryUsageInfo = this.f2457d;
                this.f2457d = null;
            }
        }
        return batteryUsageInfo;
    }

    private void m3581b() {
        this.f2457d = new BatteryUsageInfo();
        try {
            if (this.f2468o) {
                m3584c();
            }
            if (this.f2467n || this.f2456c == null || this.f2455b == null || this.f2456c.checkPermission("android.permission.BATTERY_STATS", this.f2455b.getPackageName()) == 0) {
                ObjectNode objectNode;
                double d;
                double d2;
                Class cls = Class.forName("com.android.internal.app.IBatteryStats");
                Class cls2 = Class.forName("com.android.internal.app.IBatteryStats$Stub");
                Class cls3 = Class.forName("android.os.ServiceManager");
                Class cls4 = Class.forName("com.android.internal.os.BatteryStatsImpl");
                Class cls5 = Class.forName("com.android.internal.os.BatteryStatsImpl$Uid");
                Class cls6 = Class.forName("com.android.internal.os.PowerProfile");
                IBinder iBinder = (IBinder) cls3.getDeclaredMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"batteryinfo"});
                Object invoke = cls2.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
                Object newInstance = cls6.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f2455b});
                byte[] bArr = (byte[]) cls.getDeclaredMethod("getStatistics", new Class[0]).invoke(invoke, new Object[0]);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                Object createFromParcel = ((Creator) cls4.getDeclaredField("CREATOR").get(null)).createFromParcel(obtain);
                obtain.recycle();
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                long longValue = ((Long) cls4.getDeclaredMethod("computeBatteryRealtime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(createFromParcel, new Object[]{Long.valueOf(elapsedRealtime), Integer.valueOf(0)})).longValue();
                elapsedRealtime = SystemClock.uptimeMillis() * 1000;
                ((Long) cls4.getDeclaredMethod("computeBatteryUptime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(createFromParcel, new Object[]{Long.valueOf(elapsedRealtime), Integer.valueOf(0)})).longValue();
                cls4.getDeclaredMethod("distributeWorkLocked", new Class[]{Integer.TYPE}).invoke(createFromParcel, new Object[]{Integer.valueOf(0)});
                SparseArray sparseArray = (SparseArray) cls4.getDeclaredMethod("getUidStats", new Class[0]).invoke(createFromParcel, new Object[0]);
                int myUid = Process.myUid();
                if (this.f2468o) {
                    objectNode = new ObjectNode(JsonNodeFactory.a);
                } else {
                    objectNode = null;
                }
                double d3 = 0.0d;
                double d4 = 0.0d;
                this.f2460g = 0;
                this.f2461h = 0;
                this.f2462i = 0;
                this.f2463j = 0;
                this.f2464k = 0;
                this.f2465l = 0;
                this.f2466m = 0;
                int i = 0;
                int i2 = 0;
                Object obj = null;
                while (i < sparseArray.size()) {
                    Object valueAt = sparseArray.valueAt(i);
                    int intValue = ((Integer) cls5.getDeclaredMethod("getUid", new Class[0]).invoke(valueAt, new Object[0])).intValue();
                    ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                    Map a = m3572a(cls5, valueAt);
                    boolean z = m3575a(intValue, a) || this.f2468o;
                    double a2 = m3568a(objectNode2, cls5, valueAt, cls4, createFromParcel, cls6, newInstance, 0, longValue, z);
                    int i3 = i2;
                    for (Entry key : a.entrySet()) {
                        int i4;
                        String str = (String) key.getKey();
                        if (m3576a(str)) {
                            objectNode2.a("total_app_power", a2);
                            m3573a(objectNode2, intValue);
                            if (str.startsWith("com.facebook.katana")) {
                                this.f2457d.m3710a("katana", objectNode2);
                            } else if (str.startsWith("com.facebook.wakizashi")) {
                                this.f2457d.m3710a("wakizashi", objectNode2);
                            } else if (str.startsWith("com.facebook.orca")) {
                                this.f2457d.m3710a("orca", objectNode2);
                            } else if (str.startsWith("com.instagram")) {
                                this.f2457d.m3710a("instagram", objectNode2);
                            } else if (str.startsWith("com.facebook.phone")) {
                                this.f2457d.m3710a("phoneapp", objectNode2);
                            } else {
                                this.f2457d.m3710a(str + i3, objectNode2);
                            }
                            i4 = i3 + 1;
                        } else {
                            i4 = i3;
                        }
                        i3 = i4;
                    }
                    if (this.f2468o && !a.isEmpty()) {
                        objectNode.c(m3580b(intValue, a), objectNode2);
                    }
                    if (intValue == myUid) {
                        if (this.f2454a) {
                            new StringBuilder("Total FB power").append(a2);
                        }
                        d = a2;
                    } else {
                        d = d4;
                    }
                    d3 += a2;
                    i++;
                    d4 = d;
                    obj = valueAt;
                    i2 = i3;
                }
                if (this.f2468o) {
                    this.f2457d.m3710a("all_processes", objectNode);
                }
                this.f2457d.m3709a("apps_wakelock_power", this.f2460g);
                this.f2457d.m3709a("apps_cpu_power", this.f2461h);
                this.f2457d.m3709a("apps_sensor_power", this.f2462i);
                this.f2457d.m3709a("apps_tcp_bytes_recvd", this.f2463j);
                this.f2457d.m3709a("apps_tcp_bytes_sent", this.f2464k);
                this.f2457d.m3709a("apps_wifi_power", this.f2465l);
                this.f2457d.m3709a("apps_data_power", this.f2466m);
                if (this.f2454a) {
                    new StringBuilder("App power").append(d3);
                }
                this.f2457d.m3708a("app_power", d3);
                long elapsedRealtime2 = 1000 * SystemClock.elapsedRealtime();
                elapsedRealtime = SystemClock.uptimeMillis() * 1000;
                elapsedRealtime = (((Long) cls4.getDeclaredMethod("computeBatteryUptime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(createFromParcel, new Object[]{Long.valueOf(elapsedRealtime), Integer.valueOf(0)})).longValue() / 1000) - ((((Long) cls4.getDeclaredMethod("getScreenOnTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(createFromParcel, new Object[]{Long.valueOf(elapsedRealtime2), Integer.valueOf(0)})).longValue() / 1000) + this.f2459f);
                if (elapsedRealtime > 0) {
                    d = (((Double) cls6.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(newInstance, new Object[]{"cpu.awake"})).doubleValue() * ((double) elapsedRealtime)) / 1000.0d;
                    d2 = d3 + d;
                    if (this.f2454a) {
                        new StringBuilder("OS wakelock power").append(d);
                    }
                    this.f2457d.m3708a("device_wakelock_power", d);
                } else {
                    d2 = d3;
                }
                double d5 = m3585d(this.f2457d, cls4, createFromParcel, cls6, newInstance, 0, longValue) + (((((d2 + m3569a(cls4, createFromParcel, cls6, newInstance, 0, longValue)) + m3586e(this.f2457d, cls4, createFromParcel, cls6, newInstance, 0, longValue)) + m3564a(this.f2457d, cls4, createFromParcel, cls6, newInstance, 0, longValue)) + m3577b(this.f2457d, cls4, createFromParcel, cls6, newInstance, 0, longValue)) + m3582c(this.f2457d, cls4, createFromParcel, cls6, newInstance, 0, longValue));
                d2 = d5 > 0.0d ? (100.0d * d4) / d5 : 0.0d;
                this.f2457d.m3706a(d2);
                if (this.f2454a) {
                    new StringBuilder("Total FB percent used is").append(d2);
                    new StringBuilder("fb power is ").append(d4);
                    new StringBuilder("total power is ").append(d5);
                }
                this.f2457d.m3708a("total_device_power", d5);
                if (obj == null) {
                    BLog.a("BatteryUsageMonitor", "Failed to find Uid");
                    return;
                }
                return;
            }
            this.f2457d.m3707a("Package does not have permission to access battery stats");
        } catch (Throwable th) {
            m3574a(th, "Error in Initialization");
        }
    }

    private void m3584c() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        try {
            for (Entry entry : Thread.getAllStackTraces().entrySet()) {
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                Thread thread = (Thread) entry.getKey();
                objectNode2.a("thread_priority", thread.getPriority());
                objectNode2.a("thread_state", thread.getState().toString());
                objectNode2.a("thread_stack", Joiner.on("\n").join((Object[]) entry.getValue()));
                objectNode.c(thread.getName(), objectNode2);
            }
        } catch (Throwable e) {
            m3574a(e, "Error dumping stack trace");
        }
        this.f2457d.m3710a("stack_trace", objectNode);
    }

    private Map m3572a(Class cls, Object obj) {
        try {
            return (Map) cls.getDeclaredMethod("getProcessStats", new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable th) {
            m3574a(th, "Failed to extract CPU power stats");
            return Maps.c();
        }
    }

    private static boolean m3576a(String str) {
        return str.startsWith("com.facebook") || str.startsWith("com.instagram");
    }

    private boolean m3575a(int i, Map<String, Object> map) {
        if (i == 0) {
            return false;
        }
        for (Entry key : map.entrySet()) {
            if (m3576a((String) key.getKey())) {
                return true;
            }
        }
        return false;
    }

    private static String m3580b(int i, Map<String, Object> map) {
        if (i == 0) {
            return "system";
        }
        for (Entry key : map.entrySet()) {
            String str = (String) key.getKey();
            if (!str.contains(":")) {
                return str;
            }
        }
        return (String) map.keySet().iterator().next();
    }

    private void m3574a(Throwable th, String str) {
        Writer stringWriter = new StringWriter();
        stringWriter.write(str + "\n");
        th.printStackTrace(new PrintWriter(stringWriter));
        BLog.a("BatteryUsageMonitor", stringWriter.toString());
        this.f2457d.m3707a(stringWriter.toString());
    }

    private void m3573a(ObjectNode objectNode, int i) {
        try {
            String[] packagesForUid = this.f2456c.getPackagesForUid(i);
            if (packagesForUid.length > 0) {
                objectNode.a("version_name", this.f2456c.getPackageInfo(packagesForUid[0], 0).versionName);
            }
        } catch (Throwable th) {
            m3574a(th, "Unable to retrieve version number");
        }
    }

    private double m3568a(ObjectNode objectNode, Class cls, Object obj, Class cls2, Object obj2, Class cls3, Object obj3, int i, long j, boolean z) {
        return m3583c(objectNode, cls, obj, cls3, obj3, i, j, z) + ((((0.0d + m3565a(objectNode, cls, cls3, obj3, obj, i, z)) + m3567a(objectNode, cls, obj, cls3, obj3, i, j, z)) + m3566a(objectNode, cls, obj, cls2, cls3, obj3, obj2, i, z)) + m3578b(objectNode, cls, obj, cls3, obj3, i, j, z));
    }

    private double m3565a(ObjectNode objectNode, Class cls, Class cls2, Object obj, Object obj2, int i, boolean z) {
        double d = 0.0d;
        try {
            int i2;
            Object obj3 = obj;
            int intValue = ((Integer) cls2.getDeclaredMethod("getNumSpeedSteps", new Class[0]).invoke(obj3, new Object[0])).intValue();
            double[] dArr = new double[intValue];
            long[] jArr = new long[intValue];
            for (i2 = 0; i2 < intValue; i2++) {
                Class cls3 = cls2;
                dArr[i2] = ((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class, Integer.TYPE}).invoke(obj, new Object[]{"cpu.active", Integer.valueOf(i2)})).doubleValue();
            }
            Class cls4 = Class.forName("com.android.internal.os.BatteryStatsImpl$Uid$Proc");
            for (Entry entry : m3572a(cls, obj2).entrySet()) {
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                Object value = entry.getValue();
                long longValue = 10 * ((Long) cls4.getDeclaredMethod("getUserTime", new Class[]{Integer.TYPE}).invoke(value, new Object[]{Integer.valueOf(i)})).longValue();
                long longValue2 = 10 * ((Long) cls4.getDeclaredMethod("getSystemTime", new Class[]{Integer.TYPE}).invoke(value, new Object[]{Integer.valueOf(i)})).longValue();
                long longValue3 = 10 * ((Long) cls4.getDeclaredMethod("getForegroundTime", new Class[]{Integer.TYPE}).invoke(value, new Object[]{Integer.valueOf(i)})).longValue();
                if (z) {
                    objectNode2.a("user_time_ms", longValue);
                    objectNode2.a("system_time_ms", longValue2);
                    objectNode2.a("foreground_time_ms", longValue3);
                }
                longValue2 += longValue;
                int i3 = 0;
                objectNode2 = new ObjectNode(JsonNodeFactory.a);
                for (int i4 = 0; i4 < intValue; i4++) {
                    long longValue4 = ((Long) cls4.getDeclaredMethod("getTimeAtCpuSpeedStep", new Class[]{Integer.TYPE, Integer.TYPE}).invoke(value, new Object[]{Integer.valueOf(i4), Integer.valueOf(i)})).longValue();
                    jArr[i4] = longValue4;
                    i3 = (int) (((long) i3) + longValue4);
                    if (z) {
                        objectNode2.a(i4, longValue4);
                    }
                }
                if (i3 == 0) {
                    i2 = 1;
                } else {
                    i2 = i3;
                }
                double d2 = 0.0d;
                for (i3 = 0; i3 < intValue; i3++) {
                    d2 += ((((double) jArr[i3]) / ((double) i2)) * ((double) longValue2)) * dArr[i3];
                }
                double d3 = d2 / 1000.0d;
                d += d3;
                if (z) {
                    objectNode2.c("relative_time_at_speeds", objectNode2);
                    objectNode2.a("process_cpu_power", d3);
                    objectNode.c((String) entry.getKey(), objectNode2);
                    if (this.f2454a) {
                        new StringBuilder("Process CPU power").append((String) entry.getKey()).append("Power ").append(d);
                    }
                }
                this.f2461h = (long) (((double) this.f2461h) + d);
            }
            if (this.f2454a) {
                new StringBuilder("Total CPU power").append(d);
            }
            return d;
        } catch (Throwable th) {
            Throwable th2 = th;
            double d4 = 0.0d;
            m3574a(th2, "Failed to extract CPU power stats");
            return d4;
        }
    }

    private double m3567a(ObjectNode objectNode, Class cls, Object obj, Class cls2, Object obj2, int i, long j, boolean z) {
        double doubleValue;
        Throwable th;
        try {
            Class cls3 = Class.forName("com.android.internal.os.BatteryStatsImpl$Uid$Wakelock");
            Class cls4 = Class.forName("com.android.internal.os.BatteryStatsImpl$Timer");
            Object obj3 = obj;
            Map map = (Map) cls.getDeclaredMethod("getWakelockStats", new Class[0]).invoke(obj3, new Object[0]);
            ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
            long j2 = 0;
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Object invoke = cls3.getDeclaredMethod("getWakeTime", new Class[]{Integer.TYPE}).invoke(value, new Object[]{Integer.valueOf(0)});
                if (invoke != null) {
                    long longValue = ((Long) cls4.getDeclaredMethod("getTotalTimeLocked", new Class[]{Long.TYPE, Integer.TYPE}).invoke(invoke, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
                    j2 += longValue;
                    int intValue = ((Integer) cls4.getDeclaredMethod("getCountLocked", new Class[]{Integer.TYPE}).invoke(invoke, new Object[]{Integer.valueOf(i)})).intValue();
                    if (z) {
                        if (this.f2454a) {
                            Long.valueOf(longValue);
                            Integer.valueOf(intValue);
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "<empty>";
                        }
                        objectNode2.a(str, longValue);
                        objectNode2.a(str + "_count", intValue);
                    }
                }
                j2 = j2;
            }
            Class cls5 = cls2;
            doubleValue = (((Double) cls5.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"cpu.awake"})).doubleValue() * ((double) j2)) / 1000.0d;
            try {
                if (this.f2454a) {
                    new StringBuilder("Total wakelock power").append(doubleValue);
                }
                if (z) {
                    objectNode.c("wakelock_details", objectNode2);
                    objectNode.a("wakelock_power", doubleValue);
                    objectNode.a("wakelock_time_ms", j2);
                }
                this.f2459f = j2 + this.f2459f;
                this.f2460g = (long) (((double) this.f2460g) + doubleValue);
            } catch (Throwable th2) {
                th = th2;
                m3574a(th, "Failed to extract Wakelock power stats");
                return doubleValue;
            }
        } catch (Throwable th3) {
            th = th3;
            doubleValue = 0.0d;
            m3574a(th, "Failed to extract Wakelock power stats");
            return doubleValue;
        }
        return doubleValue;
    }

    private static double m3570a(Object obj, Class cls, Class cls2, Object obj2, int i) {
        double doubleValue = ((Double) cls2.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"wifi.active"})).doubleValue() / 3600.0d;
        double doubleValue2 = ((Double) cls2.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"radio.active"})).doubleValue() / 3600.0d;
        long longValue = ((Long) cls.getDeclaredMethod("getMobileTcpBytesReceived", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue();
        Class cls3 = cls;
        long longValue2 = (((Long) cls3.getDeclaredMethod("getTotalTcpBytesSent", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue() + ((Long) cls.getDeclaredMethod("getTotalTcpBytesReceived", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue()) - longValue;
        long longValue3 = ((Long) cls.getDeclaredMethod("getRadioDataUptime", new Class[0]).invoke(obj, new Object[0])).longValue() / 1000;
        double d = doubleValue2 / (((double) (longValue3 != 0 ? ((8 * longValue) * 1000) / longValue3 : 200000)) / 8.0d);
        doubleValue /= 125000.0d;
        if (longValue2 + longValue > 0) {
            return ((d * ((double) longValue)) + (doubleValue * ((double) longValue2))) / ((double) (longValue + longValue2));
        }
        return 0.0d;
    }

    private double m3566a(ObjectNode objectNode, Class cls, Object obj, Class cls2, Class cls3, Object obj2, Object obj3, int i, boolean z) {
        double d = 0.0d;
        try {
            Class cls4 = cls;
            long longValue = ((Long) cls4.getDeclaredMethod("getTcpBytesReceived", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue();
            cls4 = cls;
            long longValue2 = ((Long) cls4.getDeclaredMethod("getTcpBytesSent", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)})).longValue();
            if (z) {
                objectNode.a("tcp_bytes_recvd", longValue);
                objectNode.a("tcp_bytes_sent", longValue2);
            }
            this.f2463j += longValue;
            this.f2464k += longValue2;
            d = 0.0d + (((double) (longValue2 + longValue)) * m3570a(obj3, cls2, cls3, obj2, i));
            this.f2466m = (long) (((double) this.f2466m) + d);
        } catch (Throwable th) {
            m3574a(th, "Failed to extract data stats");
        }
        if (z) {
            if (this.f2454a) {
                new StringBuilder("Total data power").append(d);
            }
            objectNode.a("data_power", d);
        }
        return d;
    }

    private double m3578b(ObjectNode objectNode, Class cls, Object obj, Class cls2, Object obj2, int i, long j, boolean z) {
        double d = 0.0d;
        try {
            long longValue;
            Class cls3 = cls;
            long longValue2 = ((Long) cls3.getDeclaredMethod("getWifiRunningTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
            this.f2458e += longValue2;
            try {
                cls3 = cls;
                longValue = ((Long) cls3.getDeclaredMethod("getWifiScanTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
            } catch (NoSuchMethodException e) {
                longValue = 0;
            }
            cls3 = cls2;
            cls3 = cls2;
            d = (0.0d + ((((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"wifi.on"})).doubleValue() / 1000.0d) * ((double) longValue2))) + ((((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"wifi.scan"})).doubleValue() / 1000.0d) * ((double) longValue));
            if (z) {
                objectNode.a("wifi_running_time", longValue2);
                objectNode.a("wifi_scan_time", longValue);
            }
        } catch (Throwable th) {
            m3574a(th, "Unable to retrieve Data power stats");
        }
        if (z) {
            objectNode.a("wifi_power", d);
            if (this.f2454a) {
                new StringBuilder("Total wifi power").append(d);
            }
        }
        this.f2465l = (long) (((double) this.f2465l) + d);
        return d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double m3583c(com.fasterxml.jackson.databind.node.ObjectNode r22, java.lang.Class r23, java.lang.Object r24, java.lang.Class r25, java.lang.Object r26, int r27, long r28, boolean r30) {
        /*
        r21 = this;
        r4 = 0;
        r0 = r21;
        r2 = r0.f2455b;	 Catch:{ Throwable -> 0x0219 }
        r3 = "sensor";
        r2 = r2.getSystemService(r3);	 Catch:{ Throwable -> 0x0219 }
        r2 = (android.hardware.SensorManager) r2;	 Catch:{ Throwable -> 0x0219 }
        r3 = "com.android.internal.os.BatteryStatsImpl$Uid$Sensor";
        r10 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0219 }
        r3 = "com.android.internal.os.BatteryStatsImpl$Timer";
        r11 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0219 }
        r3 = "getSensorStats";
        r6 = 0;
        r6 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x0219 }
        r0 = r23;
        r3 = r0.getDeclaredMethod(r3, r6);	 Catch:{ Throwable -> 0x0219 }
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x0219 }
        r0 = r24;
        r3 = r3.invoke(r0, r6);	 Catch:{ Throwable -> 0x0219 }
        r3 = (java.util.Map) r3;	 Catch:{ Throwable -> 0x0219 }
        r6 = 0;
        r12 = new com.fasterxml.jackson.databind.node.ObjectNode;	 Catch:{ Throwable -> 0x0219 }
        r8 = com.fasterxml.jackson.databind.node.JsonNodeFactory.a;	 Catch:{ Throwable -> 0x0219 }
        r12.<init>(r8);	 Catch:{ Throwable -> 0x0219 }
        r3 = r3.entrySet();	 Catch:{ Throwable -> 0x0219 }
        r13 = r3.iterator();	 Catch:{ Throwable -> 0x0219 }
        r8 = r4;
    L_0x0042:
        r3 = r13.hasNext();	 Catch:{ Throwable -> 0x01e0 }
        if (r3 == 0) goto L_0x020f;
    L_0x0048:
        r3 = r13.next();	 Catch:{ Throwable -> 0x01e0 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ Throwable -> 0x01e0 }
        r5 = r3.getValue();	 Catch:{ Throwable -> 0x021b }
        r4 = "getHandle";
        r14 = 0;
        r14 = new java.lang.Class[r14];	 Catch:{ Throwable -> 0x021b }
        r4 = r10.getDeclaredMethod(r4, r14);	 Catch:{ Throwable -> 0x021b }
        r14 = 0;
        r14 = new java.lang.Object[r14];	 Catch:{ Throwable -> 0x021b }
        r4 = r4.invoke(r5, r14);	 Catch:{ Throwable -> 0x021b }
        r4 = (java.lang.Integer) r4;	 Catch:{ Throwable -> 0x021b }
        r14 = r4.intValue();	 Catch:{ Throwable -> 0x021b }
        r4 = "getSensorTime";
        r15 = 0;
        r15 = new java.lang.Class[r15];	 Catch:{ Throwable -> 0x021b }
        r4 = r10.getDeclaredMethod(r4, r15);	 Catch:{ Throwable -> 0x021b }
        r15 = 0;
        r15 = new java.lang.Object[r15];	 Catch:{ Throwable -> 0x021b }
        r5 = r4.invoke(r5, r15);	 Catch:{ Throwable -> 0x021b }
        r4 = "getTotalTimeLocked";
        r15 = 2;
        r15 = new java.lang.Class[r15];	 Catch:{ Throwable -> 0x021b }
        r16 = 0;
        r17 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x021b }
        r15[r16] = r17;	 Catch:{ Throwable -> 0x021b }
        r16 = 1;
        r17 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x021b }
        r15[r16] = r17;	 Catch:{ Throwable -> 0x021b }
        r4 = r11.getDeclaredMethod(r4, r15);	 Catch:{ Throwable -> 0x021b }
        r15 = 2;
        r15 = new java.lang.Object[r15];	 Catch:{ Throwable -> 0x021b }
        r16 = 0;
        r17 = java.lang.Long.valueOf(r28);	 Catch:{ Throwable -> 0x021b }
        r15[r16] = r17;	 Catch:{ Throwable -> 0x021b }
        r16 = 1;
        r17 = java.lang.Integer.valueOf(r27);	 Catch:{ Throwable -> 0x021b }
        r15[r16] = r17;	 Catch:{ Throwable -> 0x021b }
        r4 = r4.invoke(r5, r15);	 Catch:{ Throwable -> 0x021b }
        r4 = (java.lang.Long) r4;	 Catch:{ Throwable -> 0x021b }
        r16 = r4.longValue();	 Catch:{ Throwable -> 0x021b }
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r16 = r16 / r18;
        r4 = "getCountLocked";
        r15 = 1;
        r15 = new java.lang.Class[r15];	 Catch:{ Throwable -> 0x021b }
        r18 = 0;
        r19 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x021b }
        r15[r18] = r19;	 Catch:{ Throwable -> 0x021b }
        r4 = r11.getDeclaredMethod(r4, r15);	 Catch:{ Throwable -> 0x021b }
        r15 = 1;
        r15 = new java.lang.Object[r15];	 Catch:{ Throwable -> 0x021b }
        r18 = 0;
        r19 = java.lang.Integer.valueOf(r27);	 Catch:{ Throwable -> 0x021b }
        r15[r18] = r19;	 Catch:{ Throwable -> 0x021b }
        r4 = r4.invoke(r5, r15);	 Catch:{ Throwable -> 0x021b }
        r4 = (java.lang.Integer) r4;	 Catch:{ Throwable -> 0x021b }
        r15 = r4.intValue();	 Catch:{ Throwable -> 0x021b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x021b }
        r4.<init>();	 Catch:{ Throwable -> 0x021b }
        r4 = r4.append(r14);	 Catch:{ Throwable -> 0x021b }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x021b }
        r0 = r16;
        r12.a(r4, r0);	 Catch:{ Throwable -> 0x021b }
        switch(r14) {
            case -10000: goto L_0x0169;
            default: goto L_0x00e7;
        };	 Catch:{ Throwable -> 0x021b }
    L_0x00e7:
        r4 = r2.getDefaultSensor(r14);	 Catch:{ Throwable -> 0x021b }
        if (r4 == 0) goto L_0x012c;
    L_0x00ed:
        r5 = r4.getPower();	 Catch:{ Throwable -> 0x021b }
        r6 = (double) r5;	 Catch:{ Throwable -> 0x021b }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x021b }
        r5.<init>();	 Catch:{ Throwable -> 0x021b }
        r18 = r4.getName();	 Catch:{ Throwable -> 0x021b }
        r0 = r18;
        r5 = r5.append(r0);	 Catch:{ Throwable -> 0x021b }
        r18 = "_msec";
        r0 = r18;
        r5 = r5.append(r0);	 Catch:{ Throwable -> 0x021b }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x021b }
        r0 = r16;
        r12.a(r5, r0);	 Catch:{ Throwable -> 0x021b }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x021b }
        r5.<init>();	 Catch:{ Throwable -> 0x021b }
        r4 = r4.getName();	 Catch:{ Throwable -> 0x021b }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x021b }
        r5 = "_count";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x021b }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x021b }
        r12.a(r4, r15);	 Catch:{ Throwable -> 0x021b }
    L_0x012c:
        r4 = r6;
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01c0 }
        r6.<init>();	 Catch:{ Throwable -> 0x01c0 }
        r6 = r6.append(r14);	 Catch:{ Throwable -> 0x01c0 }
        r7 = "_msec";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x01c0 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x01c0 }
        r0 = r16;
        r12.a(r6, r0);	 Catch:{ Throwable -> 0x01c0 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01c0 }
        r6.<init>();	 Catch:{ Throwable -> 0x01c0 }
        r6 = r6.append(r14);	 Catch:{ Throwable -> 0x01c0 }
        r7 = "_count";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x01c0 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x01c0 }
        r12.a(r6, r15);	 Catch:{ Throwable -> 0x01c0 }
    L_0x015b:
        r0 = r16;
        r6 = (double) r0;
        r6 = r6 * r4;
        r14 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r6 = r6 / r14;
        r8 = r8 + r6;
        r6 = r4;
        goto L_0x0042;
    L_0x0169:
        r4 = "getAveragePower";
        r5 = 1;
        r5 = new java.lang.Class[r5];	 Catch:{  }
        r18 = 0;
        r19 = java.lang.String.class;
        r5[r18] = r19;	 Catch:{  }
        r0 = r25;
        r4 = r0.getDeclaredMethod(r4, r5);	 Catch:{  }
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{  }
        r18 = 0;
        r19 = "gps.on";
        r5[r18] = r19;	 Catch:{  }
        r0 = r26;
        r4 = r4.invoke(r0, r5);	 Catch:{  }
        r4 = (java.lang.Double) r4;	 Catch:{  }
        r4 = (java.lang.Double) r4;	 Catch:{  }
        r4 = r4.doubleValue();	 Catch:{  }
        r6 = new java.lang.StringBuilder;	 Catch:{  }
        r6.<init>();	 Catch:{  }
        r6 = r6.append(r14);	 Catch:{  }
        r7 = "_msec";
        r6 = r6.append(r7);	 Catch:{  }
        r6 = r6.toString();	 Catch:{  }
        r0 = r16;
        r12.a(r6, r0);	 Catch:{  }
        r6 = new java.lang.StringBuilder;	 Catch:{  }
        r6.<init>();	 Catch:{  }
        r6 = r6.append(r14);	 Catch:{  }
        r7 = "_count";
        r6 = r6.append(r7);	 Catch:{  }
        r6 = r6.toString();	 Catch:{  }
        r12.a(r6, r15);	 Catch:{  }
        goto L_0x015b;
    L_0x01c0:
        r6 = move-exception;
        r20 = r6;
        r6 = r4;
        r4 = r20;
    L_0x01c6:
        r5 = new java.lang.StringBuilder;	 Catch:{  }
        r14 = "Failed to extract stat of sensor ";
        r5.<init>(r14);	 Catch:{  }
        r3 = r3.getKey();	 Catch:{  }
        r3 = r5.append(r3);	 Catch:{  }
        r3 = r3.toString();	 Catch:{  }
        r0 = r21;
        r0.m3574a(r4, r3);	 Catch:{  }
        goto L_0x0042;
    L_0x01e0:
        r2 = move-exception;
        r4 = r8;
    L_0x01e2:
        r3 = "Unable to retrieve Sensor power stats";
        r0 = r21;
        r0.m3574a(r2, r3);
        r8 = r4;
    L_0x01ea:
        if (r30 == 0) goto L_0x0203;
    L_0x01ec:
        r2 = "sensor_power";
        r0 = r22;
        r0.a(r2, r8);
        r0 = r21;
        r2 = r0.f2454a;
        if (r2 == 0) goto L_0x0203;
    L_0x01f9:
        r2 = new java.lang.StringBuilder;
        r3 = "Total sensor power";
        r2.<init>(r3);
        r2.append(r8);
    L_0x0203:
        r0 = r21;
        r2 = r0.f2462i;
        r2 = (double) r2;
        r2 = r2 + r8;
        r2 = (long) r2;
        r0 = r21;
        r0.f2462i = r2;
        return r8;
    L_0x020f:
        if (r30 == 0) goto L_0x01ea;
    L_0x0211:
        r2 = "sensor_times_ms";
        r0 = r22;
        r0.c(r2, r12);	 Catch:{  }
        goto L_0x01ea;
    L_0x0219:
        r2 = move-exception;
        goto L_0x01e2;
    L_0x021b:
        r4 = move-exception;
        goto L_0x01c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.battery.BatteryUsageManager.c(com.fasterxml.jackson.databind.node.ObjectNode, java.lang.Class, java.lang.Object, java.lang.Class, java.lang.Object, int, long, boolean):double");
    }

    private double m3569a(Class cls, Object obj, Class cls2, Object obj2, int i, long j) {
        try {
            long longValue = ((Long) cls.getDeclaredMethod("getPhoneOnTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
            return ((((Double) cls2.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"radio.active"})).doubleValue() / 1000.0d) * ((double) longValue)) + 0.0d;
        } catch (Throwable th) {
            m3574a(th, "Unable to retrieve phone usage power stats");
            return 0.0d;
        }
    }

    private double m3564a(BatteryUsageInfo batteryUsageInfo, Class cls, Object obj, Class cls2, Object obj2, int i, long j) {
        double doubleValue;
        try {
            long j2;
            long longValue = (((Long) cls.getDeclaredMethod("getGlobalWifiRunningTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000) - this.f2458e;
            if (longValue < 0) {
                j2 = 0;
            } else {
                j2 = longValue;
            }
            doubleValue = ((((Double) cls2.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"wifi.on"})).doubleValue() / 1000.0d) * ((double) j2)) + 0.0d;
        } catch (Throwable th) {
            m3574a(th, "Unable to retrieve Wifi power stats");
            doubleValue = 0.0d;
        }
        if (this.f2454a) {
            new StringBuilder("Total wifi usage ").append(doubleValue);
        }
        batteryUsageInfo.m3708a("device_wifi_power", doubleValue);
        return doubleValue;
    }

    private double m3577b(BatteryUsageInfo batteryUsageInfo, Class cls, Object obj, Class cls2, Object obj2, int i, long j) {
        double doubleValue;
        try {
            Class cls3 = cls;
            long longValue = ((Long) cls3.getDeclaredMethod("getBluetoothOnTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
            cls3 = cls2;
            double doubleValue2 = ((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"bluetooth.on"})).doubleValue() / 1000.0d;
            Object obj3 = obj;
            long intValue = (long) ((Integer) cls.getDeclaredMethod("getBluetoothPingCount", new Class[0]).invoke(obj3, new Object[0])).intValue();
            cls3 = cls2;
            doubleValue = ((((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"bluetooth.at"})).doubleValue() / 1000.0d) * ((double) intValue)) + (0.0d + (((double) longValue) * doubleValue2));
        } catch (Throwable th) {
            m3574a(th, "Unable to retrieve bluetooth power stats");
            doubleValue = 0.0d;
        }
        if (this.f2454a) {
            new StringBuilder("Total bluetooth usage ").append(doubleValue);
        }
        batteryUsageInfo.m3708a("device_bluetooth_power", doubleValue);
        return doubleValue;
    }

    private double m3582c(BatteryUsageInfo batteryUsageInfo, Class cls, Object obj, Class cls2, Object obj2, int i, long j) {
        double doubleValue;
        try {
            long longValue = (j - ((Long) cls.getDeclaredMethod("getScreenOnTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue()) / 1000;
            doubleValue = ((((Double) cls2.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"cpu.idle"})).doubleValue() / 1000.0d) * ((double) longValue)) + 0.0d;
        } catch (Throwable th) {
            m3574a(th, "Unable to retrieve idle power stats");
            doubleValue = 0.0d;
        }
        if (this.f2454a) {
            new StringBuilder("Total Idle usage ").append(doubleValue);
        }
        batteryUsageInfo.m3708a("device_idle_power", doubleValue);
        return doubleValue;
    }

    private double m3585d(BatteryUsageInfo batteryUsageInfo, Class cls, Object obj, Class cls2, Object obj2, int i, long j) {
        Class cls3;
        double d;
        double d2 = 0.0d;
        int i2 = 0;
        while (i2 < 5) {
            try {
                cls3 = cls2;
                d2 += (((double) (((Long) cls.getDeclaredMethod("getPhoneSignalStrengthTime", new Class[]{Integer.TYPE, Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000)) * ((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class, Integer.TYPE}).invoke(obj2, new Object[]{"radio.on", Integer.valueOf(i2)})).doubleValue()) / 1000.0d;
                i2++;
            } catch (Throwable th) {
                Throwable th2 = th;
                d = d2;
                Throwable th3 = th2;
            }
        }
        long longValue = ((Long) cls.getDeclaredMethod("getPhoneSignalScanningTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
        cls3 = cls2;
        d = ((((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"radio.scanning"})).doubleValue() / 1000.0d) * ((double) longValue)) + d2;
        try {
            if (this.f2454a) {
                new StringBuilder("Total radio usage ").append(d);
            }
            batteryUsageInfo.m3708a("device_radio_power", d);
        } catch (Throwable th4) {
            th3 = th4;
            m3574a(th3, "Unable to retrieve radio power stats");
            return d;
        }
        return d;
    }

    private double m3586e(BatteryUsageInfo batteryUsageInfo, Class cls, Object obj, Class cls2, Object obj2, int i, long j) {
        double d;
        try {
            Class cls3 = cls;
            long longValue = ((Long) cls3.getDeclaredMethod("getScreenOnTime", new Class[]{Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000;
            cls3 = cls2;
            double doubleValue = 0.0d + (((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"screen.on"})).doubleValue() * ((double) longValue));
            cls3 = cls2;
            double doubleValue2 = ((Double) cls3.getDeclaredMethod("getAveragePower", new Class[]{String.class}).invoke(obj2, new Object[]{"screen.full"})).doubleValue();
            for (int i2 = 0; i2 < 5; i2++) {
                cls3 = cls;
                doubleValue += ((((double) (((float) i2) + 0.5f)) * doubleValue2) / 5.0d) * ((double) (((Long) cls3.getDeclaredMethod("getScreenBrightnessTime", new Class[]{Integer.TYPE, Long.TYPE, Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i)})).longValue() / 1000));
            }
            d = doubleValue / 1000.0d;
        } catch (Throwable th) {
            Throwable th2 = th;
            d = 0.0d;
            m3574a(th2, "Unable to retrieve screen power stats");
        }
        if (this.f2454a) {
            new StringBuilder("Total screen power ").append(d);
        }
        batteryUsageInfo.m3708a("device_screen_power", d);
        return d;
    }
}
