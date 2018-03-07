package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzk.zza;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements com.google.android.gms.common.api.Api.zzb, zza {
    public static final String[] f18780c = new String[]{"service_esmobile", "service_googleme"};
    public final Handler f18781a;
    protected AtomicInteger f18782b;
    public final Context f18783d;
    private final zzf f18784e;
    public final Looper f18785f;
    private final zzl f18786g;
    private final GoogleApiAvailability f18787h;
    private final Object f18788i;
    public zzs f18789j;
    public GoogleApiClient.zza f18790k;
    private T f18791l;
    public final ArrayList<zzc<?>> f18792m;
    private zze f18793n;
    private int f18794o;
    public final Set<Scope> f18795p;
    private final Account f18796q;
    public final ConnectionCallbacks f18797r;
    public final OnConnectionFailedListener f18798s;
    private final int f18799t;

    final class zzb extends Handler {
        final /* synthetic */ zzj f18923a;

        public zzb(zzj com_google_android_gms_common_internal_zzj, Looper looper) {
            this.f18923a = com_google_android_gms_common_internal_zzj;
            super(looper);
        }

        private static void m26595a(Message message) {
            ((zzc) message.obj).c();
        }

        private static boolean m26596b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public final void handleMessage(Message message) {
            if (this.f18923a.f18782b.get() != message.arg1) {
                if (m26596b(message)) {
                    m26595a(message);
                }
            } else if ((message.what == 1 || message.what == 5 || message.what == 6) && !this.f18923a.m26413k()) {
                m26595a(message);
            } else if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, null);
                this.f18923a.f18790k.mo3083a(connectionResult);
                this.f18923a.m26401a(connectionResult);
            } else if (message.what == 4) {
                zzj.m26389a(this.f18923a, 4, null);
                if (this.f18923a.f18797r != null) {
                    this.f18923a.f18797r.mo38a(message.arg2);
                }
                int i = message.arg2;
                zzj.m26390a(this.f18923a, 4, 1, null);
            } else if (message.what == 2 && !this.f18923a.mo3032b()) {
                m26595a(message);
            } else if (m26596b(message)) {
                ((zzc) message.obj).b();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public final class zze implements ServiceConnection {
        final /* synthetic */ zzj f19130a;
        private final int f19131b;

        public zze(zzj com_google_android_gms_common_internal_zzj, int i) {
            this.f19130a = com_google_android_gms_common_internal_zzj;
            this.f19131b = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzs com_google_android_gms_common_internal_zzs;
            zzx.m105a((Object) iBinder, (Object) "Expecting a valid IBinder");
            zzj com_google_android_gms_common_internal_zzj = this.f19130a;
            if (iBinder == null) {
                com_google_android_gms_common_internal_zzs = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                com_google_android_gms_common_internal_zzs = (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new zzs.zza.zza(iBinder) : (zzs) queryLocalInterface;
            }
            com_google_android_gms_common_internal_zzj.f18789j = com_google_android_gms_common_internal_zzs;
            com_google_android_gms_common_internal_zzj = this.f19130a;
            com_google_android_gms_common_internal_zzj.f18781a.sendMessage(com_google_android_gms_common_internal_zzj.f18781a.obtainMessage(6, this.f19131b, -1, new zzh(com_google_android_gms_common_internal_zzj)));
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.f19130a.f18781a.sendMessage(this.f19130a.f18781a.obtainMessage(4, this.f19131b, 1));
        }
    }

    protected zzj(Context context, Looper looper, int i, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.m26431a(context), GoogleApiAvailability.m150a(), i, com_google_android_gms_common_internal_zzf, (ConnectionCallbacks) zzx.m104a((Object) connectionCallbacks), (OnConnectionFailedListener) zzx.m104a((Object) onConnectionFailedListener));
    }

    private zzj(Context context, Looper looper, zzl com_google_android_gms_common_internal_zzl, GoogleApiAvailability googleApiAvailability, int i, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.f18788i = new Object();
        this.f18792m = new ArrayList();
        this.f18794o = 1;
        this.f18782b = new AtomicInteger(0);
        this.f18783d = (Context) zzx.m105a((Object) context, (Object) "Context must not be null");
        this.f18785f = (Looper) zzx.m105a((Object) looper, (Object) "Looper must not be null");
        this.f18786g = (zzl) zzx.m105a((Object) com_google_android_gms_common_internal_zzl, (Object) "Supervisor must not be null");
        this.f18787h = (GoogleApiAvailability) zzx.m105a((Object) googleApiAvailability, (Object) "API availability must not be null");
        this.f18781a = new zzb(this, looper);
        this.f18799t = i;
        this.f18784e = (zzf) zzx.m104a((Object) com_google_android_gms_common_internal_zzf);
        this.f18796q = com_google_android_gms_common_internal_zzf.f18104a;
        this.f18795p = m26388a(com_google_android_gms_common_internal_zzf.f18106c);
        this.f18797r = connectionCallbacks;
        this.f18798s = onConnectionFailedListener;
    }

    private Set<Scope> m26388a(Set<Scope> set) {
        Set<Scope> set2 = set;
        if (set2 == null) {
            return set2;
        }
        for (Scope contains : set2) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return set2;
    }

    public static void m26389a(zzj com_google_android_gms_common_internal_zzj, int i, IInterface iInterface) {
        boolean z = true;
        if ((i == 3) != (iInterface != null)) {
            z = false;
        }
        zzx.m112b(z);
        synchronized (com_google_android_gms_common_internal_zzj.f18788i) {
            com_google_android_gms_common_internal_zzj.f18794o = i;
            com_google_android_gms_common_internal_zzj.f18791l = iInterface;
            switch (i) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    com_google_android_gms_common_internal_zzj.m26393t();
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    com_google_android_gms_common_internal_zzj.m26392s();
                    break;
            }
        }
    }

    public static boolean m26390a(zzj com_google_android_gms_common_internal_zzj, int i, int i2, IInterface iInterface) {
        boolean z;
        synchronized (com_google_android_gms_common_internal_zzj.f18788i) {
            if (com_google_android_gms_common_internal_zzj.f18794o != i) {
                z = false;
            } else {
                m26389a(com_google_android_gms_common_internal_zzj, i2, iInterface);
                z = true;
            }
        }
        return z;
    }

    private String mo3023r() {
        return this.f18784e.f18111h;
    }

    private void m26392s() {
        if (this.f18793n != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + mo3025g());
            this.f18786g.mo3041b(mo3025g(), this.f18793n, mo3023r());
            this.f18782b.incrementAndGet();
        }
        this.f18793n = new zze(this, this.f18782b.get());
        if (!this.f18786g.mo3039a(mo3025g(), this.f18793n, mo3023r())) {
            Log.e("GmsClient", "unable to connect to service: " + mo3025g());
            this.f18781a.sendMessage(this.f18781a.obtainMessage(3, this.f18782b.get(), 9));
        }
    }

    private void m26393t() {
        if (this.f18793n != null) {
            this.f18786g.mo3041b(mo3025g(), this.f18793n, mo3023r());
            this.f18793n = null;
        }
    }

    private Account m26394u() {
        return this.f18796q != null ? this.f18796q : new Account("<<default account>>", "com.google");
    }

    private static Bundle m26395v() {
        return null;
    }

    private static boolean m26396w() {
        return false;
    }

    protected abstract T mo3024a(IBinder iBinder);

    public void mo3022a() {
        this.f18782b.incrementAndGet();
        synchronized (this.f18792m) {
            int size = this.f18792m.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.f18792m.get(i)).d();
            }
            this.f18792m.clear();
        }
        m26389a(this, 1, null);
    }

    public final void m26399a(int i) {
        this.f18781a.sendMessage(this.f18781a.obtainMessage(4, this.f18782b.get(), i));
    }

    protected void m26400a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f18781a.sendMessage(this.f18781a.obtainMessage(1, i2, -1, new zzg(this, i, iBinder, bundle)));
    }

    protected void m26401a(ConnectionResult connectionResult) {
    }

    public final void mo3028a(GoogleApiClient.zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        this.f18790k = (GoogleApiClient.zza) zzx.m105a((Object) com_google_android_gms_common_api_GoogleApiClient_zza, (Object) "Connection progress callbacks cannot be null.");
        m26389a(this, 2, null);
    }

    public final void mo3029a(zzp com_google_android_gms_common_internal_zzp) {
        try {
            this.f18789j.a(new zzd(this, this.f18782b.get()), new ValidateAccountRequest(com_google_android_gms_common_internal_zzp, (Scope[]) this.f18795p.toArray(new Scope[this.f18795p.size()]), this.f18783d.getPackageName(), m26395v()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m26399a(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public final void mo3030a(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set) {
        try {
            GetServiceRequest a = new GetServiceRequest(this.f18799t).a(this.f18783d.getPackageName()).a(mo3027n());
            if (set != null) {
                a.a(set);
            }
            if (mo3033c()) {
                a.a(m26394u()).a(com_google_android_gms_common_internal_zzp);
            } else if (m26396w()) {
                a.a(this.f18796q);
            }
            this.f18789j.a(new zzd(this, this.f18782b.get()), a);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            m26399a(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public final void mo3031a(String str, PrintWriter printWriter) {
        synchronized (this.f18788i) {
            int i = this.f18794o;
            IInterface iInterface = this.f18791l;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                printWriter.print("DISCONNECTED");
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(mo3026h()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public final boolean mo3032b() {
        boolean z;
        synchronized (this.f18788i) {
            z = this.f18794o == 3;
        }
        return z;
    }

    public boolean mo3033c() {
        return false;
    }

    public final boolean mo3034d() {
        return false;
    }

    public final Intent mo3035e() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final IBinder mo3036f() {
        return this.f18789j == null ? null : this.f18789j.asBinder();
    }

    protected abstract String mo3025g();

    protected abstract String mo3026h();

    public final boolean m26413k() {
        boolean z;
        synchronized (this.f18788i) {
            z = this.f18794o == 2;
        }
        return z;
    }

    public final Context m26414l() {
        return this.f18783d;
    }

    protected Bundle mo3027n() {
        return new Bundle();
    }

    public final void m26416o() {
        if (!mo3032b()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle mo3037p() {
        return null;
    }

    public final void p_() {
        int a = GoogleApiAvailability.m148a(this.f18783d);
        if (a != 0) {
            m26389a(this, 1, null);
            this.f18790k = new zzf(this);
            this.f18781a.sendMessage(this.f18781a.obtainMessage(3, this.f18782b.get(), a));
            return;
        }
        mo3028a(new zzf(this));
    }

    public final T m26418q() {
        T t;
        synchronized (this.f18788i) {
            if (this.f18794o == 4) {
                throw new DeadObjectException();
            }
            m26416o();
            zzx.m109a(this.f18791l != null, (Object) "Client is connected but service is null");
            t = this.f18791l;
        }
        return t;
    }
}
