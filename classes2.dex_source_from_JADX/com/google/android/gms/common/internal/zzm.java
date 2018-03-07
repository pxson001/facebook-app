package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
    public final HashMap<zza, zzb> f18802a = new HashMap();
    public final Context f18803b;
    private final Handler f18804c;
    public final com.google.android.gms.common.stats.zzb f18805d;
    private final long f18806e;

    final class zza {
        private final String f19132a;
        private final ComponentName f19133b;

        public zza(ComponentName componentName) {
            this.f19132a = null;
            this.f19133b = (ComponentName) zzx.m104a((Object) componentName);
        }

        public zza(String str) {
            this.f19132a = zzx.m106a(str);
            this.f19133b = null;
        }

        public final Intent m26864a() {
            return this.f19132a != null ? new Intent(this.f19132a).setPackage("com.google.android.gms") : new Intent().setComponent(this.f19133b);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_common_internal_zzm_zza = (zza) obj;
            return zzw.m26867a(this.f19132a, com_google_android_gms_common_internal_zzm_zza.f19132a) && zzw.m26867a(this.f19133b, com_google_android_gms_common_internal_zzm_zza.f19133b);
        }

        public final int hashCode() {
            return zzw.m26865a(this.f19132a, this.f19133b);
        }

        public final String toString() {
            return this.f19132a == null ? this.f19133b.flattenToString() : this.f19132a;
        }
    }

    final class zzb {
        final /* synthetic */ zzm f19156a;
        private final zza f19157b = new zza(this);
        public final Set<ServiceConnection> f19158c = new HashSet();
        private int f19159d = 2;
        private boolean f19160e;
        private IBinder f19161f;
        public final zza f19162g;
        private ComponentName f19163h;

        public class zza implements ServiceConnection {
            final /* synthetic */ zzb f19164a;

            public zza(zzb com_google_android_gms_common_internal_zzm_zzb) {
                this.f19164a = com_google_android_gms_common_internal_zzm_zzb;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.f19164a.f19156a.f18802a) {
                    this.f19164a.f19161f = iBinder;
                    this.f19164a.f19163h = componentName;
                    for (ServiceConnection onServiceConnected : this.f19164a.f19158c) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.f19164a.f19159d = 1;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.f19164a.f19156a.f18802a) {
                    this.f19164a.f19161f = null;
                    this.f19164a.f19163h = componentName;
                    for (ServiceConnection onServiceDisconnected : this.f19164a.f19158c) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.f19164a.f19159d = 2;
                }
            }
        }

        public zzb(zzm com_google_android_gms_common_internal_zzm, zza com_google_android_gms_common_internal_zzm_zza) {
            this.f19156a = com_google_android_gms_common_internal_zzm;
            this.f19162g = com_google_android_gms_common_internal_zzm_zza;
        }

        public final void m26879a() {
            this.f19156a.f18805d.m26507a(this.f19156a.f18803b, this.f19157b);
            this.f19160e = false;
            this.f19159d = 2;
        }

        public final void m26880a(ServiceConnection serviceConnection) {
            this.f19156a.f18805d.m26511b(this.f19156a.f18803b, serviceConnection);
            this.f19158c.remove(serviceConnection);
        }

        public final void m26881a(ServiceConnection serviceConnection, String str) {
            this.f19156a.f18805d.m26508a(this.f19156a.f18803b, serviceConnection, str, this.f19162g.m26864a());
            this.f19158c.add(serviceConnection);
        }

        public final void m26882a(String str) {
            this.f19159d = 3;
            this.f19160e = this.f19156a.f18805d.m26510a(this.f19156a.f18803b, str, this.f19162g.m26864a(), this.f19157b, 129);
            if (!this.f19160e) {
                this.f19159d = 2;
                try {
                    this.f19156a.f18805d.m26507a(this.f19156a.f18803b, this.f19157b);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public final boolean m26883b() {
            return this.f19160e;
        }

        public final boolean m26884b(ServiceConnection serviceConnection) {
            return this.f19158c.contains(serviceConnection);
        }

        public final int m26885c() {
            return this.f19159d;
        }

        public final boolean m26886d() {
            return this.f19158c.isEmpty();
        }

        public final IBinder m26887e() {
            return this.f19161f;
        }

        public final ComponentName m26888f() {
            return this.f19163h;
        }
    }

    zzm(Context context) {
        this.f18803b = context.getApplicationContext();
        this.f18804c = new Handler(context.getMainLooper(), this);
        this.f18805d = com.google.android.gms.common.stats.zzb.m26500a();
        this.f18806e = 5000;
    }

    private boolean m26436a(zza com_google_android_gms_common_internal_zzm_zza, ServiceConnection serviceConnection, String str) {
        boolean b;
        zzx.m105a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f18802a) {
            zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) this.f18802a.get(com_google_android_gms_common_internal_zzm_zza);
            if (com_google_android_gms_common_internal_zzm_zzb != null) {
                this.f18804c.removeMessages(0, com_google_android_gms_common_internal_zzm_zzb);
                if (!com_google_android_gms_common_internal_zzm_zzb.m26884b(serviceConnection)) {
                    com_google_android_gms_common_internal_zzm_zzb.m26881a(serviceConnection, str);
                    switch (com_google_android_gms_common_internal_zzm_zzb.m26885c()) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzm_zzb.m26888f(), com_google_android_gms_common_internal_zzm_zzb.m26887e());
                            break;
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            com_google_android_gms_common_internal_zzm_zzb.m26882a(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + com_google_android_gms_common_internal_zzm_zza);
            }
            com_google_android_gms_common_internal_zzm_zzb = new zzb(this, com_google_android_gms_common_internal_zzm_zza);
            com_google_android_gms_common_internal_zzm_zzb.m26881a(serviceConnection, str);
            com_google_android_gms_common_internal_zzm_zzb.m26882a(str);
            this.f18802a.put(com_google_android_gms_common_internal_zzm_zza, com_google_android_gms_common_internal_zzm_zzb);
            b = com_google_android_gms_common_internal_zzm_zzb.m26883b();
        }
        return b;
    }

    private void m26437b(zza com_google_android_gms_common_internal_zzm_zza, ServiceConnection serviceConnection, String str) {
        zzx.m105a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f18802a) {
            zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) this.f18802a.get(com_google_android_gms_common_internal_zzm_zza);
            if (com_google_android_gms_common_internal_zzm_zzb == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + com_google_android_gms_common_internal_zzm_zza);
            } else if (com_google_android_gms_common_internal_zzm_zzb.m26884b(serviceConnection)) {
                com_google_android_gms_common_internal_zzm_zzb.m26880a(serviceConnection);
                if (com_google_android_gms_common_internal_zzm_zzb.m26886d()) {
                    this.f18804c.sendMessageDelayed(this.f18804c.obtainMessage(0, com_google_android_gms_common_internal_zzm_zzb), this.f18806e);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + com_google_android_gms_common_internal_zzm_zza);
            }
        }
    }

    public final boolean mo3038a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return m26436a(new zza(componentName), serviceConnection, str);
    }

    public final boolean mo3039a(String str, ServiceConnection serviceConnection, String str2) {
        return m26436a(new zza(str), serviceConnection, str2);
    }

    public final void mo3040b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        m26437b(new zza(componentName), serviceConnection, str);
    }

    public final void mo3041b(String str, ServiceConnection serviceConnection, String str2) {
        m26437b(new zza(str), serviceConnection, str2);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb com_google_android_gms_common_internal_zzm_zzb = (zzb) message.obj;
                synchronized (this.f18802a) {
                    if (com_google_android_gms_common_internal_zzm_zzb.m26886d()) {
                        if (com_google_android_gms_common_internal_zzm_zzb.m26883b()) {
                            com_google_android_gms_common_internal_zzm_zzb.m26879a();
                        }
                        this.f18802a.remove(com_google_android_gms_common_internal_zzm_zzb.f19162g);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
