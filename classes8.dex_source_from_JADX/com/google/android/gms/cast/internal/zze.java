package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzj<zzi> {
    public static final Object f10147A = new Object();
    public static final zzl f10148d = new zzl("CastClientImpl");
    public static final Object f10149z = new Object();
    public ApplicationMetadata f10150e;
    private final CastDevice f10151f;
    public final Listener f10152g;
    public final Map<String, MessageReceivedCallback> f10153h = new HashMap();
    private final long f10154i;
    private zzb f10155j;
    public String f10156k;
    public boolean f10157l;
    public boolean f10158m;
    public boolean f10159n;
    private boolean f10160o;
    public double f10161p;
    public int f10162q;
    public int f10163r;
    private final AtomicLong f10164s = new AtomicLong(0);
    public String f10165t;
    public String f10166u;
    private Bundle f10167v;
    public final Map<Long, com.google.android.gms.internal.zzlx.zzb<Status>> f10168w = new HashMap();
    public com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> f10169x;
    public com.google.android.gms.internal.zzlx.zzb<Status> f10170y;

    final class zza implements ApplicationConnectionResult {
        private final Status f10127a;
        private final ApplicationMetadata f10128b;
        private final String f10129c;
        private final String f10130d;
        private final boolean f10131e;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.f10127a = status;
            this.f10128b = applicationMetadata;
            this.f10129c = str;
            this.f10130d = str2;
            this.f10131e = z;
        }

        public final ApplicationMetadata mo635b() {
            return this.f10128b;
        }

        public final String mo636c() {
            return this.f10129c;
        }

        public final Status cp_() {
            return this.f10127a;
        }

        public final String mo637d() {
            return this.f10130d;
        }

        public final boolean mo638e() {
            return this.f10131e;
        }
    }

    public class zzb extends com.google.android.gms.cast.internal.zzj.zza {
        public final AtomicReference<zze> f10145a;
        private final Handler f10146b;

        public zzb(zze com_google_android_gms_cast_internal_zze) {
            this.f10145a = new AtomicReference(com_google_android_gms_cast_internal_zze);
            this.f10146b = new Handler(com_google_android_gms_cast_internal_zze.f);
        }

        private static void m11877a(zze com_google_android_gms_cast_internal_zze, long j, int i) {
            synchronized (com_google_android_gms_cast_internal_zze.f10168w) {
                com.google.android.gms.internal.zzlx.zzb com_google_android_gms_internal_zzlx_zzb = (com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_cast_internal_zze.f10168w.remove(Long.valueOf(j));
            }
            if (com_google_android_gms_internal_zzlx_zzb != null) {
                com_google_android_gms_internal_zzlx_zzb.a(new Status(i));
            }
        }

        private static boolean m11878a(zze com_google_android_gms_cast_internal_zze, int i) {
            synchronized (zze.f10147A) {
                if (com_google_android_gms_cast_internal_zze.f10170y != null) {
                    com_google_android_gms_cast_internal_zze.f10170y.a(new Status(i));
                    com_google_android_gms_cast_internal_zze.f10170y = null;
                    return true;
                }
                return false;
            }
        }

        public final zze m11879a() {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.getAndSet(null);
            if (com_google_android_gms_cast_internal_zze == null) {
                return null;
            }
            zze.m11901v(com_google_android_gms_cast_internal_zze);
            return com_google_android_gms_cast_internal_zze;
        }

        public final void mo649a(int i) {
            zze a = m11879a();
            if (a != null) {
                zze.f10148d.m11956b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    a.a(2);
                }
            }
        }

        public final void mo650a(long j) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                m11877a(com_google_android_gms_cast_internal_zze, j, 0);
            }
        }

        public final void mo651a(long j, int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                m11877a(com_google_android_gms_cast_internal_zze, j, i);
            }
        }

        public final void mo652a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.f10150e = applicationMetadata;
                com_google_android_gms_cast_internal_zze.f10165t = applicationMetadata.m11734b();
                com_google_android_gms_cast_internal_zze.f10166u = str2;
                synchronized (zze.f10149z) {
                    if (com_google_android_gms_cast_internal_zze.f10169x != null) {
                        com_google_android_gms_cast_internal_zze.f10169x.a(new zza(new Status(0), applicationMetadata, str, str2, z));
                        com_google_android_gms_cast_internal_zze.f10169x = null;
                    }
                }
            }
        }

        public final void mo653a(final ApplicationStatus applicationStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.f10148d.m11956b("onApplicationStatusChanged", new Object[0]);
                HandlerDetour.a(this.f10146b, new Runnable(this) {
                    final /* synthetic */ zzb f10140c;

                    public void run() {
                        boolean z;
                        zze com_google_android_gms_cast_internal_zze = com_google_android_gms_cast_internal_zze;
                        String str = applicationStatus.f10119b;
                        if (zzf.m11922a(str, com_google_android_gms_cast_internal_zze.f10156k)) {
                            z = false;
                        } else {
                            com_google_android_gms_cast_internal_zze.f10156k = str;
                            z = true;
                        }
                        zze.f10148d.m11956b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(com_google_android_gms_cast_internal_zze.f10158m));
                        if (com_google_android_gms_cast_internal_zze.f10152g != null && (z || com_google_android_gms_cast_internal_zze.f10158m)) {
                            com_google_android_gms_cast_internal_zze.f10152g.mo601a();
                        }
                        com_google_android_gms_cast_internal_zze.f10158m = false;
                    }
                }, 1572989968);
            }
        }

        public final void mo654a(final DeviceStatus deviceStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.f10148d.m11956b("onDeviceStatusChanged", new Object[0]);
                HandlerDetour.a(this.f10146b, new Runnable(this) {
                    final /* synthetic */ zzb f10137c;

                    public void run() {
                        boolean z;
                        zze com_google_android_gms_cast_internal_zze = com_google_android_gms_cast_internal_zze;
                        DeviceStatus deviceStatus = deviceStatus;
                        ApplicationMetadata applicationMetadata = deviceStatus.f10124e;
                        if (!zzf.m11922a(applicationMetadata, com_google_android_gms_cast_internal_zze.f10150e)) {
                            com_google_android_gms_cast_internal_zze.f10150e = applicationMetadata;
                        }
                        double d = deviceStatus.f10121b;
                        if (d == Double.NaN || Math.abs(d - com_google_android_gms_cast_internal_zze.f10161p) <= 1.0E-7d) {
                            z = false;
                        } else {
                            com_google_android_gms_cast_internal_zze.f10161p = d;
                            z = true;
                        }
                        boolean z2 = deviceStatus.f10122c;
                        if (z2 != com_google_android_gms_cast_internal_zze.f10157l) {
                            com_google_android_gms_cast_internal_zze.f10157l = z2;
                            z = true;
                        }
                        zze.f10148d.m11956b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(com_google_android_gms_cast_internal_zze.f10159n));
                        if (com_google_android_gms_cast_internal_zze.f10152g != null && (z || com_google_android_gms_cast_internal_zze.f10159n)) {
                            com_google_android_gms_cast_internal_zze.f10152g.mo603b();
                        }
                        int i = deviceStatus.f10123d;
                        if (i != com_google_android_gms_cast_internal_zze.f10162q) {
                            com_google_android_gms_cast_internal_zze.f10162q = i;
                            z = true;
                        } else {
                            z = false;
                        }
                        zze.f10148d.m11956b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(com_google_android_gms_cast_internal_zze.f10159n));
                        i = deviceStatus.f10125f;
                        if (i != com_google_android_gms_cast_internal_zze.f10163r) {
                            com_google_android_gms_cast_internal_zze.f10163r = i;
                            z = true;
                        } else {
                            z = false;
                        }
                        zze.f10148d.m11956b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(com_google_android_gms_cast_internal_zze.f10159n));
                        com_google_android_gms_cast_internal_zze.f10159n = false;
                    }
                }, -126911567);
            }
        }

        public final void mo655a(final String str, final String str2) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.f10148d.m11956b("Receive (type=text, ns=%s) %s", str, str2);
                HandlerDetour.a(this.f10146b, new Runnable(this) {
                    final /* synthetic */ zzb f10144d;

                    public void run() {
                        synchronized (com_google_android_gms_cast_internal_zze.f10153h) {
                            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) com_google_android_gms_cast_internal_zze.f10153h.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            com_google_android_gms_cast_internal_zze.f10151f;
                            messageReceivedCallback.mo604a(str, str2);
                            return;
                        }
                        zze.f10148d.m11956b("Discarded message for unknown namespace '%s'", str);
                    }
                }, -830270682);
            }
        }

        public final void mo656a(String str, byte[] bArr) {
            if (((zze) this.f10145a.get()) != null) {
                zze.f10148d.m11956b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public final void mo657b(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                synchronized (zze.f10149z) {
                    if (com_google_android_gms_cast_internal_zze.f10169x != null) {
                        com_google_android_gms_cast_internal_zze.f10169x.a(new zza(new Status(i)));
                        com_google_android_gms_cast_internal_zze.f10169x = null;
                    }
                }
            }
        }

        public final void mo658c() {
            zze.f10148d.m11956b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public final void mo659c(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                m11878a(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public final void mo660d(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                m11878a(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public final void mo661e(final int i) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.f10145a.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.f10165t = null;
                com_google_android_gms_cast_internal_zze.f10166u = null;
                m11878a(com_google_android_gms_cast_internal_zze, i);
                if (com_google_android_gms_cast_internal_zze.f10152g != null) {
                    HandlerDetour.a(this.f10146b, new Runnable(this) {
                        final /* synthetic */ zzb f10134c;

                        public void run() {
                            if (com_google_android_gms_cast_internal_zze.f10152g != null) {
                                com_google_android_gms_cast_internal_zze.f10152g.mo602a(i);
                            }
                        }
                    }, 277835148);
                }
            }
        }
    }

    public zze(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.f10151f = castDevice;
        this.f10152g = listener;
        this.f10154i = j;
        m11901v(this);
    }

    private void m11896a(com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        synchronized (f10149z) {
            if (this.f10169x != null) {
                this.f10169x.a(new zza(new Status(2002)));
            }
            this.f10169x = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult;
        }
    }

    private void m11899b(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        synchronized (f10147A) {
            if (this.f10170y != null) {
                com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status.a(new Status(2001));
                return;
            }
            this.f10170y = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
        }
    }

    public static void m11901v(zze com_google_android_gms_cast_internal_zze) {
        com_google_android_gms_cast_internal_zze.f10160o = false;
        com_google_android_gms_cast_internal_zze.f10162q = -1;
        com_google_android_gms_cast_internal_zze.f10163r = -1;
        com_google_android_gms_cast_internal_zze.f10150e = null;
        com_google_android_gms_cast_internal_zze.f10156k = null;
        com_google_android_gms_cast_internal_zze.f10161p = 0.0d;
        com_google_android_gms_cast_internal_zze.f10157l = false;
    }

    private void m11902w() {
        f10148d.m11956b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.f10153h) {
            this.f10153h.clear();
        }
    }

    private void m11903x() {
        if (this.f10160o && this.f10155j != null) {
            if ((this.f10155j.f10145a.get() == null ? 1 : null) == null) {
                return;
            }
        }
        throw new IllegalStateException("Not connected to a device");
    }

    protected final IInterface m11904a(IBinder iBinder) {
        zzi com_google_android_gms_cast_internal_zzi;
        if (iBinder == null) {
            com_google_android_gms_cast_internal_zzi = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            com_google_android_gms_cast_internal_zzi = (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new zzi$zza$zza(iBinder) : (zzi) queryLocalInterface;
        }
        return com_google_android_gms_cast_internal_zzi;
    }

    public final void m11905a() {
        Throwable e;
        f10148d.m11956b("disconnect(); ServiceListener=%s, isConnected=%b", this.f10155j, Boolean.valueOf(b()));
        zzb com_google_android_gms_cast_internal_zze_zzb = this.f10155j;
        this.f10155j = null;
        if (com_google_android_gms_cast_internal_zze_zzb == null || com_google_android_gms_cast_internal_zze_zzb.m11879a() == null) {
            f10148d.m11956b("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        m11902w();
        try {
            ((zzi) q()).mo662a();
            super.a();
        } catch (RemoteException e2) {
            e = e2;
            try {
                f10148d.m11955a(e, "Error while disconnecting the controller interface: %s", e.getMessage());
            } finally {
                super.a();
            }
        } catch (IllegalStateException e3) {
            e = e3;
            f10148d.m11955a(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        }
    }

    protected final void m11906a(int i, IBinder iBinder, Bundle bundle, int i2) {
        f10148d.m11956b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.f10160o = true;
            this.f10158m = true;
            this.f10159n = true;
        } else {
            this.f10160o = false;
        }
        if (i == 1001) {
            this.f10167v = new Bundle();
            this.f10167v.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            i = 0;
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void m11907a(ConnectionResult connectionResult) {
        super.a(connectionResult);
        m11902w();
    }

    public final void m11908a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.f10153h) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.f10153h.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzi) q()).mo675c(str);
            } catch (Throwable e) {
                f10148d.m11955a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public final void m11909a(String str, MessageReceivedCallback messageReceivedCallback) {
        zzf.m11921a(str);
        m11908a(str);
        if (messageReceivedCallback != null) {
            synchronized (this.f10153h) {
                this.f10153h.put(str, messageReceivedCallback);
            }
            ((zzi) q()).mo673b(str);
        }
    }

    public final void m11910a(String str, LaunchOptions launchOptions, com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        m11896a((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) q()).mo665a(str, launchOptions);
    }

    public final void m11911a(String str, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        m11899b(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
        ((zzi) q()).mo664a(str);
    }

    public final void m11912a(String str, String str2, JoinOptions joinOptions, com.google.android.gms.internal.zzlx.zzb<ApplicationConnectionResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        m11896a((com.google.android.gms.internal.zzlx.zzb) com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        if (joinOptions == null) {
            joinOptions = new JoinOptions();
        }
        ((zzi) q()).mo668a(str, str2, joinOptions);
    }

    public final void m11913a(String str, String str2, com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.m11921a(str);
            m11903x();
            long incrementAndGet = this.f10164s.incrementAndGet();
            try {
                this.f10168w.put(Long.valueOf(incrementAndGet), com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status);
                ((zzi) q()).mo667a(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.f10168w.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    protected final String m11914g() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected final String m11915h() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected final Bundle m11916n() {
        Bundle bundle = new Bundle();
        f10148d.m11956b("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.f10165t, this.f10166u);
        Object obj = this.f10151f;
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", obj);
        }
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f10154i);
        this.f10155j = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.f10155j.asBinder()));
        if (this.f10165t != null) {
            bundle.putString("last_application_id", this.f10165t);
            if (this.f10166u != null) {
                bundle.putString("last_session_id", this.f10166u);
            }
        }
        return bundle;
    }

    public final Bundle m11917p() {
        if (this.f10167v == null) {
            return super.p();
        }
        Bundle bundle = this.f10167v;
        this.f10167v = null;
        return bundle;
    }

    public final void m11918r() {
        ((zzi) q()).mo674c();
    }
}
