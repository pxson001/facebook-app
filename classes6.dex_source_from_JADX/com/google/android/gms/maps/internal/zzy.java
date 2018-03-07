package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzy {
    private static Context f6716a;
    private static zzc f6717b;

    public static zzc m9641a(Context context) {
        zzx.a(context);
        if (f6717b != null) {
            return f6717b;
        }
        m9645b(context);
        f6717b = m9646c(context);
        try {
            f6717b.mo699a(zze.a(m9647d(context).getResources()), GooglePlayServicesUtil.a);
            return f6717b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static <T> T m9642a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static <T> T m9643a(ClassLoader classLoader, String str) {
        try {
            return m9642a(((ClassLoader) zzx.a(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static Class<?> m9644b() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void m9645b(Context context) {
        int a = GooglePlayServicesUtil.a(context);
        switch (a) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(a);
        }
    }

    private static zzc m9646c(Context context) {
        if (null != null) {
            Log.i(zzy.class.getSimpleName(), "Making Creator statically");
            return (zzc) m9642a(m9644b());
        }
        zzc com_google_android_gms_maps_internal_zzc;
        Log.i(zzy.class.getSimpleName(), "Making Creator dynamically");
        IBinder iBinder = (IBinder) m9643a(m9647d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl");
        if (iBinder == null) {
            com_google_android_gms_maps_internal_zzc = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            com_google_android_gms_maps_internal_zzc = (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zzc$zza$zza(iBinder) : (zzc) queryLocalInterface;
        }
        return com_google_android_gms_maps_internal_zzc;
    }

    private static Context m9647d(Context context) {
        if (f6716a == null) {
            if (null != null) {
                f6716a = context.getApplicationContext();
            } else {
                f6716a = GooglePlayServicesUtil.d(context);
            }
        }
        return f6716a;
    }
}
