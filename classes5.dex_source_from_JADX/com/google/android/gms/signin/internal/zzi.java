package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzj$zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzi extends zzj<zzf> implements zzsc {
    private final boolean f7174d;
    private final zzf f7175e;
    private final Bundle f7176f;
    private Integer f7177g;

    class zza extends com.google.android.gms.signin.internal.zzd.zza {
        private final zzsd f7172a;
        private final ExecutorService f7173b;

        public zza(zzsd com_google_android_gms_internal_zzsd, ExecutorService executorService) {
            this.f7172a = com_google_android_gms_internal_zzsd;
            this.f7173b = executorService;
        }

        public static GoogleApiClient$ServerAuthCodeCallbacks m13130a(zza com_google_android_gms_signin_internal_zzi_zza) {
            return com_google_android_gms_signin_internal_zzi_zza.f7172a.e;
        }

        public final void mo863a(final String str, final String str2, final zzf com_google_android_gms_signin_internal_zzf) {
            ExecutorDetour.a(this.f7173b, new Runnable(this) {
                final /* synthetic */ zza f7171d;

                public void run() {
                    try {
                        com_google_android_gms_signin_internal_zzf.mo862a(zza.m13130a(this.f7171d).m12138b());
                    } catch (Throwable e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
                    }
                }
            }, 2106525877);
        }

        public final void mo864a(final String str, final List<Scope> list, final zzf com_google_android_gms_signin_internal_zzf) {
            ExecutorDetour.a(this.f7173b, new Runnable(this) {
                final /* synthetic */ zza f7167d;

                public void run() {
                    try {
                        GoogleApiClient$ServerAuthCodeCallbacks a = zza.m13130a(this.f7167d);
                        Collections.unmodifiableSet(new HashSet(list));
                        CheckResult a2 = a.m12137a();
                        com_google_android_gms_signin_internal_zzf.mo859a(new CheckServerAuthResult(a2.m12135a(), a2.m12136b()));
                    } catch (Throwable e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
                    }
                }
            }, -327365756);
        }
    }

    public zzi(Context context, Looper looper, boolean z, zzf com_google_android_gms_common_internal_zzf, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.f7174d = z;
        this.f7175e = com_google_android_gms_common_internal_zzf;
        this.f7176f = bundle;
        this.f7177g = com_google_android_gms_common_internal_zzf.j;
    }

    public zzi(Context context, Looper looper, boolean z, zzf com_google_android_gms_common_internal_zzf, zzsd com_google_android_gms_internal_zzsd, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ExecutorService executorService) {
        this(context, looper, z, com_google_android_gms_common_internal_zzf, m13133a(com_google_android_gms_internal_zzsd, com_google_android_gms_common_internal_zzf.i(), executorService), connectionCallbacks, onConnectionFailedListener);
    }

    private static Bundle m13133a(zzsd com_google_android_gms_internal_zzsd, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", com_google_android_gms_internal_zzsd.b);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", com_google_android_gms_internal_zzsd.c);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", com_google_android_gms_internal_zzsd.d);
        if (com_google_android_gms_internal_zzsd.e != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(com_google_android_gms_internal_zzsd, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", com_google_android_gms_internal_zzsd.f);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", com_google_android_gms_internal_zzsd.g);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", com_google_android_gms_internal_zzsd.h);
        return bundle;
    }

    protected final IInterface m13134a(IBinder iBinder) {
        return com.google.android.gms.signin.internal.zzf.zza.m13129a(iBinder);
    }

    public final void mo865a(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set, zze com_google_android_gms_signin_internal_zze) {
        zzx.a(com_google_android_gms_signin_internal_zze, "Expecting a valid ISignInCallbacks");
        try {
            ((zzf) q()).mo856a(new AuthAccountRequest(com_google_android_gms_common_internal_zzp, set), com_google_android_gms_signin_internal_zze);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                com_google_android_gms_signin_internal_zze.mo837a(new ConnectionResult(8, null), new AuthAccountResult(8, null));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final void mo866a(zzp com_google_android_gms_common_internal_zzp, boolean z) {
        try {
            ((zzf) q()).mo858a(com_google_android_gms_common_internal_zzp, this.f7177g.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final void mo867a(zzt com_google_android_gms_common_internal_zzt) {
        zzx.a(com_google_android_gms_common_internal_zzt, "Expecting a valid IResolveAccountCallbacks");
        try {
            Account b = this.f7175e.b();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(b.name)) {
                googleSignInAccount = zzn.m12107a(l()).m12118a();
            }
            ((zzf) q()).mo857a(new ResolveAccountRequest(b, this.f7177g.intValue(), googleSignInAccount), com_google_android_gms_common_internal_zzt);
        } catch (Throwable e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                com_google_android_gms_common_internal_zzt.mo793a(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    public final boolean m13138c() {
        return this.f7174d;
    }

    protected final String m13139g() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String m13140h() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public final void mo868j() {
        a(new zzj$zzf(this));
    }

    protected final Bundle m13142n() {
        if (!this.d.getPackageName().equals(this.f7175e.g)) {
            this.f7176f.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f7175e.g);
        }
        return this.f7176f;
    }

    public final void o_() {
        try {
            ((zzf) q()).mo854a(this.f7177g.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }
}
