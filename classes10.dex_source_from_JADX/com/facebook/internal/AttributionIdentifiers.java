package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SENT_BY_ME_TO_SERVER */
public class AttributionIdentifiers {
    private static final String f23966a = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers f23967g;
    public String f23968b;
    public String f23969c;
    public String f23970d;
    public boolean f23971e;
    private long f23972f;

    /* compiled from: SENT_BY_ME_TO_SERVER */
    final class GoogleAdInfo implements IInterface {
        private IBinder f23963a;

        GoogleAdInfo(IBinder iBinder) {
            this.f23963a = iBinder;
        }

        public final IBinder asBinder() {
            return this.f23963a;
        }

        public final String m25232a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f23963a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                return readString;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean m25233b() {
            boolean z = true;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f23963a.transact(2, obtain, obtain2, 0);
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

    /* compiled from: SENT_BY_ME_TO_SERVER */
    final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean f23964a = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> f23965b = new LinkedBlockingDeque();

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23965b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public final IBinder m25234a() {
            if (!this.f23964a.compareAndSet(true, true)) {
                return (IBinder) this.f23965b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    private static AttributionIdentifiers m25237b(Context context) {
        AttributionIdentifiers c = m25238c(context);
        if (c != null) {
            return c;
        }
        c = m25239d(context);
        if (c == null) {
            return new AttributionIdentifiers();
        }
        return c;
    }

    private static AttributionIdentifiers m25238c(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            Method a = Utility.m25329a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (a == null) {
                return null;
            }
            Object a2 = Utility.m25321a(null, a, context);
            if (!(a2 instanceof Integer) || ((Integer) a2).intValue() != 0) {
                return null;
            }
            a = Utility.m25329a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            if (a == null) {
                return null;
            }
            Object a3 = Utility.m25321a(null, a, context);
            if (a3 == null) {
                return null;
            }
            a = Utility.m25328a(a3.getClass(), "getId", new Class[0]);
            Method a4 = Utility.m25328a(a3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (a == null || a4 == null) {
                return null;
            }
            AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
            attributionIdentifiers.f23969c = (String) Utility.m25321a(a3, a, new Object[0]);
            attributionIdentifiers.f23971e = ((Boolean) Utility.m25321a(a3, a4, new Object[0])).booleanValue();
            return attributionIdentifiers;
        } catch (Exception e) {
            Utility.m25338a("android_id", e);
            return null;
        }
    }

    private static AttributionIdentifiers m25239d(Context context) {
        ServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (ServiceConnectionDetour.a(context, intent, googleAdServiceConnection, 1, 1725711445)) {
            AttributionIdentifiers attributionIdentifiers;
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.m25234a());
                attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.f23969c = googleAdInfo.m25232a();
                attributionIdentifiers.f23971e = googleAdInfo.m25233b();
            } catch (Exception e) {
                Utility.m25338a("android_id", e);
            } finally {
                ServiceConnectionDetour.a(context, googleAdServiceConnection, 333031121);
            }
            return attributionIdentifiers;
        }
        return null;
    }

    public static AttributionIdentifiers m25235a(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        if (f23967g != null && System.currentTimeMillis() - f23967g.f23972f < 3600000) {
            return f23967g;
        }
        AttributionIdentifiers b = m25237b(context);
        try {
            Uri parse;
            String[] strArr = new String[]{"aid", "androidid", "limit_tracking"};
            if (context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0) != null) {
                parse = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            } else if (context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0) != null) {
                parse = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
            } else {
                parse = null;
            }
            String e2 = m25240e(context);
            if (e2 != null) {
                b.f23970d = e2;
            }
            if (parse == null) {
                return m25236a(b);
            }
            query = context.getContentResolver().query(parse, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("aid");
                        int columnIndex2 = query.getColumnIndex("androidid");
                        int columnIndex3 = query.getColumnIndex("limit_tracking");
                        b.f23968b = query.getString(columnIndex);
                        if (columnIndex2 > 0 && columnIndex3 > 0 && b.m25241b() == null) {
                            b.f23969c = query.getString(columnIndex2);
                            b.f23971e = Boolean.parseBoolean(query.getString(columnIndex3));
                        }
                        if (query != null) {
                            query.close();
                        }
                        return m25236a(b);
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Log.d(f23966a, "Caught unexpected exception in getAttributionId(): " + e.toString());
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            AttributionIdentifiers a = m25236a(b);
            if (query == null) {
                return a;
            }
            query.close();
            return a;
        } catch (Exception e4) {
            e = e4;
            query = null;
            Log.d(f23966a, "Caught unexpected exception in getAttributionId(): " + e.toString());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static AttributionIdentifiers m25236a(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.f23972f = System.currentTimeMillis();
        f23967g = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public final String m25241b() {
        return this.f23969c;
    }

    @Nullable
    private static String m25240e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }
}
