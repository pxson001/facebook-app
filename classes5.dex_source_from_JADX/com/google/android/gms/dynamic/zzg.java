package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;

public abstract class zzg<T> {
    private final String f6563a;
    private T f6564b;

    public class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.f6563a = str;
    }

    protected final T m12265a(Context context) {
        if (this.f6564b == null) {
            zzx.a(context);
            Context d = GooglePlayServicesUtil.d(context);
            if (d == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f6564b = mo742a((IBinder) d.getClassLoader().loadClass(this.f6563a).newInstance());
            } catch (Throwable e) {
                throw new zza("Could not load creator class.", e);
            } catch (Throwable e2) {
                throw new zza("Could not instantiate creator.", e2);
            } catch (Throwable e22) {
                throw new zza("Could not access creator.", e22);
            }
        }
        return this.f6564b;
    }

    protected abstract T mo742a(IBinder iBinder);
}
