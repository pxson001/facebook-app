package com.facebook.ads.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import com.facebook.ads.internal.util.C1983g;
import com.facebook.ads.internal.util.C1983g.C1982a;
import com.facebook.ads.internal.util.C1994r;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class C1934f {
    public static final String f14196a = C1934f.class.getSimpleName();
    private final String f14197b;
    private final boolean f14198c;

    final class C1932a implements IInterface {
        private IBinder f14193a;

        C1932a(IBinder iBinder) {
            this.f14193a = iBinder;
        }

        public final String m14348a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f14193a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.f14193a;
        }

        public final boolean m14349b() {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f14193a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    final class C1933b implements ServiceConnection {
        private AtomicBoolean f14194a = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> f14195b = new LinkedBlockingDeque();

        public final IBinder m14350a() {
            if (!this.f14194a.compareAndSet(true, true)) {
                return (IBinder) this.f14195b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f14195b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public C1934f(String str, boolean z) {
        this.f14197b = str;
        this.f14198c = z;
    }

    public static C1934f m14351a(Context context, C1982a c1982a) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (c1982a != null && !C1994r.m14486a(c1982a.f14328b)) {
            return new C1934f(c1982a.f14328b, c1982a.f14329c);
        } else {
            C1934f c1934f;
            Method a = C1983g.m14460a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (a == null) {
                c1934f = null;
            } else {
                Object a2 = C1983g.m14457a(null, a, context);
                if (a2 == null || ((Integer) a2).intValue() != 0) {
                    c1934f = null;
                } else {
                    a = C1983g.m14460a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
                    if (a == null) {
                        c1934f = null;
                    } else {
                        Object a3 = C1983g.m14457a(null, a, context);
                        if (a3 == null) {
                            c1934f = null;
                        } else {
                            a = C1983g.m14459a(a3.getClass(), "getId", new Class[0]);
                            Method a4 = C1983g.m14459a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                            c1934f = (a == null || a4 == null) ? null : new C1934f((String) C1983g.m14457a(a3, a, new Object[0]), ((Boolean) C1983g.m14457a(a3, a4, new Object[0])).booleanValue());
                        }
                    }
                }
            }
            C1934f c1934f2 = c1934f;
            return c1934f2 == null ? C1934f.m14352b(context) : c1934f2;
        }
    }

    private static C1934f m14352b(Context context) {
        ServiceConnection c1933b = new C1933b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (ServiceConnectionDetour.a(context, intent, c1933b, 1, 785476627)) {
            C1934f c1934f;
            try {
                C1932a c1932a = new C1932a(c1933b.m14350a());
                c1934f = new C1934f(c1932a.m14348a(), c1932a.m14349b());
            } catch (Throwable e) {
                Log.d(f14196a, "Unable to get advertising id from service", e);
            } finally {
                ServiceConnectionDetour.a(context, c1933b, 1480545046);
            }
            return c1934f;
        }
        return null;
    }

    public final String m14353a() {
        return this.f14197b;
    }

    public final boolean m14354b() {
        return this.f14198c;
    }
}
