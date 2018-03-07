package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.firstparty.shared.zzd;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

public final class GoogleAuthUtil {
    public static final String f6351a = "callerUid";
    public static final String f6352b = "androidPackageName";
    public static final ComponentName f6353c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName f6354d = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    interface zza<T> {
        T mo734a(IBinder iBinder);
    }

    public final class C05611 implements zza<TokenData> {
        final /* synthetic */ Account f6346a;
        final /* synthetic */ String f6347b;
        final /* synthetic */ Bundle f6348c;

        public C05611(Account account, String str, Bundle bundle) {
            this.f6346a = account;
            this.f6347b = str;
            this.f6348c = bundle;
        }

        public final Object mo734a(IBinder iBinder) {
            TokenData tokenData;
            Bundle bundle = (Bundle) GoogleAuthUtil.m12059b(com.google.android.gms.internal.zzau.zza.m12728a(iBinder).mo813a(this.f6346a, this.f6347b, this.f6348c));
            bundle.setClassLoader(TokenData.class.getClassLoader());
            Bundle bundle2 = bundle.getBundle("tokenDetails");
            if (bundle2 == null) {
                tokenData = null;
            } else {
                bundle2.setClassLoader(TokenData.class.getClassLoader());
                tokenData = (TokenData) bundle2.getParcelable("TokenData");
            }
            TokenData tokenData2 = tokenData;
            if (tokenData2 != null) {
                return tokenData2;
            }
            String string = bundle.getString("Error");
            Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
            zzd zzbT = zzd.zzbT(string);
            if (zzd.zza(zzbT)) {
                throw new UserRecoverableAuthException(string, intent);
            } else if (zzd.zzc(zzbT)) {
                throw new IOException(string);
            } else {
                throw new GoogleAuthException(string);
            }
        }
    }

    final class C05622 implements zza<Void> {
        final /* synthetic */ String f6349a;
        final /* synthetic */ Bundle f6350b;

        C05622(String str, Bundle bundle) {
            this.f6349a = str;
            this.f6350b = bundle;
        }

        public final Object mo734a(IBinder iBinder) {
            Bundle bundle = (Bundle) GoogleAuthUtil.m12059b(com.google.android.gms.internal.zzau.zza.m12728a(iBinder).mo815a(this.f6349a, this.f6350b));
            String string = bundle.getString("Error");
            if (bundle.getBoolean("booleanResult")) {
                return null;
            }
            throw new GoogleAuthException(string);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        i = VERSION.SDK_INT;
    }

    private GoogleAuthUtil() {
    }

    public static <T> T m12055a(Context context, ComponentName componentName, zza<T> com_google_android_gms_auth_GoogleAuthUtil_zza_T) {
        Throwable e;
        ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
        zzl a = zzl.a(context);
        if (a.a(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil")) {
            try {
                T a2 = com_google_android_gms_auth_GoogleAuthUtil_zza_T.mo734a(com_google_android_gms_common_zza.m12453a());
                a.b(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil");
                return a2;
            } catch (RemoteException e2) {
                e = e2;
                try {
                    Log.i("GoogleAuthUtil", "Error on service connection.", e);
                    throw new IOException("Error on service connection.", e);
                } catch (Throwable th) {
                    a.b(componentName, com_google_android_gms_common_zza, "GoogleAuthUtil");
                }
            } catch (InterruptedException e3) {
                e = e3;
                Log.i("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            }
        }
        throw new IOException("Could not bind to service.");
    }

    public static String m12056a(Context context, Account account, String str) {
        Bundle bundle = new Bundle();
        zzx.c("Calling this from your main thread can lead to deadlock");
        m12057a(context);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(f6352b))) {
            bundle2.putString(f6352b, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return ((TokenData) m12055a(context, f6353c, new C05611(account, str, bundle2))).f6356b;
    }

    public static void m12057a(Context context) {
        try {
            GooglePlayServicesUtil.b(context.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.a(), e.getMessage(), e.b());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    public static void m12058a(Context context, String str) {
        zzx.c("Calling this from your main thread can lead to deadlock");
        m12057a(context);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(f6352b)) {
            bundle.putString(f6352b, str2);
        }
        m12055a(context, f6353c, new C05622(str, bundle));
    }

    public static <T> T m12059b(T t) {
        if (t != null) {
            return t;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}
