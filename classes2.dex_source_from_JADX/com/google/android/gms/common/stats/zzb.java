package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageItemInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzc.zza;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zzny;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {
    private static final Object f18828a = new Object();
    private static zzb f18829b;
    private static Integer f18830h;
    private final List<String> f18831c;
    private final List<String> f18832d;
    private final List<String> f18833e;
    private final List<String> f18834f;
    private zze f18835g;
    private zze f18836i;

    private zzb() {
        if (m26506c() == zzd.f18838b) {
            this.f18831c = Collections.EMPTY_LIST;
            this.f18832d = Collections.EMPTY_LIST;
            this.f18833e = Collections.EMPTY_LIST;
            this.f18834f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) zza.b.m321c();
        this.f18831c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.c.m321c();
        this.f18832d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.d.m321c();
        this.f18833e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) zza.e.m321c();
        this.f18834f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f18835g = new zze(1024, ((Long) zza.f.m321c()).longValue());
        this.f18836i = new zze(1024, ((Long) zza.f.m321c()).longValue());
    }

    public static zzb m26500a() {
        synchronized (f18828a) {
            if (f18829b == null) {
                f18829b = new zzb();
            }
        }
        return f18829b;
    }

    private static String m26501a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private static void m26502a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((m26506c() & zzd.f18842f) == 0 || i == 13)) {
            str6 = zzny.m352a(3, 5);
        }
        long j = 0;
        if ((m26506c() & zzd.f18844h) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.f18837a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m26503a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        Object obj = null;
        if (zzd.f66a && m26506c() != zzd.f18838b) {
            obj = 1;
        }
        if (obj != null && this.f18835g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                PackageItemInfo b = m26505b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = zzny.m353a(context);
                if (m26504a(str3, str2, str4, str5)) {
                    this.f18835g.a(str);
                } else {
                    return;
                }
            } else if (this.f18835g.b(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m26502a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m26504a(String str, String str2, String str3, String str4) {
        return (this.f18831c.contains(str) || this.f18832d.contains(str2) || this.f18833e.contains(str3) || this.f18834f.contains(str4) || (str3.equals(str) && (m26506c() & zzd.f18843g) != 0)) ? false : true;
    }

    private static ServiceInfo m26505b(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, HTTPTransportCallback.BODY_BYTES_RECEIVED);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzny.m352a(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzny.m352a(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    public static int m26506c() {
        if (f18830h == null) {
            try {
                f18830h = Integer.valueOf(zznk.m26512a() ? ((Integer) zza.a.m321c()).intValue() : zzd.f18838b);
            } catch (SecurityException e) {
                f18830h = Integer.valueOf(zzd.f18838b);
            }
        }
        return f18830h.intValue();
    }

    public final void m26507a(Context context, ServiceConnection serviceConnection) {
        ServiceConnectionDetour.a(context, serviceConnection, 1616355024);
        m26503a(context, m26501a(serviceConnection), null, null, 1);
    }

    public final void m26508a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m26503a(context, m26501a(serviceConnection), str, intent, 3);
    }

    public final boolean m26509a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m26510a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean m26510a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        boolean a = (component == null || (zzd.f66a && "com.google.android.gms".equals(component.getPackageName()))) ? false : zznk.m26513a(context, component.getPackageName());
        if (a) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean a2 = ServiceConnectionDetour.a(context, intent, serviceConnection, i, 478323757);
        if (a2) {
            m26503a(context, m26501a(serviceConnection), str, intent, 2);
        }
        return a2;
    }

    public final void m26511b(Context context, ServiceConnection serviceConnection) {
        m26503a(context, m26501a(serviceConnection), null, null, 4);
    }
}
