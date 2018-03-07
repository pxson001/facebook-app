package com.facebook.video.chromecast;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.RouteInfo;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.video.chromecast.callbacks.CastMediaRouterCallback;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.CastOptions;
import com.google.android.gms.cast.Cast.CastOptions.Builder;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* compiled from: mAppProvidedHashtag */
public abstract class BaseCastManager implements ConnectionCallbacks, OnConnectionFailedListener {
    public static final PrefKey f9582c;
    public static final PrefKey f9583d;
    public static final PrefKey f9584e = ((PrefKey) f9582c.a("ssid"));
    public static final PrefKey f9585f = ((PrefKey) f9582c.a("route-id"));
    public static final Class<?> f9586u = BaseCastManager.class;
    public ReconnectionStatus f9587a = ReconnectionStatus.IN_ACTIVE;
    public FbAsyncTask<Void, Integer, Boolean> f9588b;
    public FbSharedPreferences f9589g;
    protected FbNetworkManager f9590h;
    public Context f9591i;
    protected String f9592j;
    protected MediaRouter f9593k;
    public MediaRouteSelector f9594l;
    protected CastMediaRouterCallback f9595m;
    public CastDevice f9596n;
    public String f9597o;
    protected boolean f9598p;
    public boolean f9599q;
    protected String f9600r;
    public GoogleApiClient f9601s;
    public AbstractFbErrorReporter f9602t;
    public int f9603v;
    public SelfRegistrableReceiverImpl f9604w;
    public final BaseFbBroadcastManager f9605x;
    private boolean f9606y;

    /* compiled from: mAppProvidedHashtag */
    public class C10011 implements ActionReceiver {
        final /* synthetic */ BaseCastManager f9576a;

        public C10011(BaseCastManager baseCastManager) {
            this.f9576a = baseCastManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1479741710);
            BaseCastManager.m11270w(this.f9576a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 367542087, a);
        }
    }

    /* compiled from: mAppProvidedHashtag */
    class C10022 implements ResultCallback<ApplicationConnectionResult> {
        final /* synthetic */ BaseCastManager f9577a;

        C10022(BaseCastManager baseCastManager) {
            this.f9577a = baseCastManager;
        }

        public final void m11259a(Result result) {
            ApplicationConnectionResult applicationConnectionResult = (ApplicationConnectionResult) result;
            if (applicationConnectionResult.cp_().e()) {
                Class cls = BaseCastManager.f9586u;
                applicationConnectionResult.toString();
                this.f9577a.mo607a(applicationConnectionResult.mo635b(), applicationConnectionResult.mo636c(), applicationConnectionResult.mo637d(), applicationConnectionResult.mo638e());
                return;
            }
            cls = BaseCastManager.f9586u;
            applicationConnectionResult.toString();
            BaseCastManager baseCastManager = this.f9577a;
            if (BaseCastManager.m11267a(12, 4)) {
                baseCastManager.f9589g.edit().a(BaseCastManager.f9583d).commit();
            }
            if (BaseCastManager.m11267a(12, 1)) {
                baseCastManager.f9589g.edit().a(BaseCastManager.f9585f).commit();
            }
            if (BaseCastManager.m11267a(12, 2)) {
                baseCastManager.f9589g.edit().a(BaseCastManager.f9584e).commit();
            }
            if (BaseCastManager.m11267a(12, 8)) {
                baseCastManager.mo614g();
            }
            this.f9577a.mo611c(applicationConnectionResult.cp_().g);
        }
    }

    /* compiled from: mAppProvidedHashtag */
    class C10033 implements ResultCallback<ApplicationConnectionResult> {
        final /* synthetic */ BaseCastManager f9578a;

        C10033(BaseCastManager baseCastManager) {
            this.f9578a = baseCastManager;
        }

        public final void m11260a(Result result) {
            ApplicationConnectionResult applicationConnectionResult = (ApplicationConnectionResult) result;
            if (applicationConnectionResult.cp_().e()) {
                Class cls = BaseCastManager.f9586u;
                applicationConnectionResult.toString();
                this.f9578a.mo607a(applicationConnectionResult.mo635b(), applicationConnectionResult.mo636c(), applicationConnectionResult.mo637d(), applicationConnectionResult.mo638e());
                return;
            }
            cls = BaseCastManager.f9586u;
            applicationConnectionResult.toString();
            this.f9578a.mo611c(applicationConnectionResult.cp_().g);
        }
    }

    /* compiled from: mAppProvidedHashtag */
    class C10044 implements ResultCallback<Status> {
        final /* synthetic */ BaseCastManager f9579a;

        C10044(BaseCastManager baseCastManager) {
            this.f9579a = baseCastManager;
        }

        public final void m11261a(Result result) {
            Status status = (Status) result;
            if (!status.e()) {
                BaseCastManager baseCastManager = this.f9579a;
                int i = status.g;
                baseCastManager.mo615k();
            }
        }
    }

    /* compiled from: mAppProvidedHashtag */
    public enum ReconnectionStatus {
        STARTED,
        IN_PROGRESS,
        FINALIZED,
        IN_ACTIVE
    }

    protected abstract void mo607a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z);

    public abstract void mo610b(boolean z);

    protected abstract void mo611c(int i);

    public abstract Builder mo612d();

    public abstract void mo613f();

    public abstract void mo614g();

    protected abstract void mo615k();

    protected abstract void mo616l();

    protected abstract void mo617m();

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.h.a("com/facebook/video/chromecast/");
        f9582c = prefKey;
        f9583d = (PrefKey) prefKey.a("session-id");
    }

    protected BaseCastManager(Context context, AbstractFbErrorReporter abstractFbErrorReporter, String str, FbSharedPreferences fbSharedPreferences, FbNetworkManager fbNetworkManager, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f9591i = context.getApplicationContext();
        this.f9602t = abstractFbErrorReporter;
        this.f9592j = str;
        this.f9589g = fbSharedPreferences;
        this.f9590h = fbNetworkManager;
        this.f9605x = baseFbBroadcastManager;
        this.f9603v = 24;
        this.f9593k = MediaRouter.a(this.f9591i);
        this.f9594l = new MediaRouteSelector.Builder().a(CastMediaControlIntent.m11768a(this.f9592j)).a();
        this.f9595m = new CastMediaRouterCallback(this);
        this.f9593k.a(this.f9594l, this.f9595m, 4);
    }

    private void mo618u() {
        if (this.f9604w == null) {
            this.f9604w = this.f9605x.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new C10011(this)).a();
        }
        this.f9606y = this.f9590h.d();
        this.f9604w.b();
    }

    public static void m11270w(BaseCastManager baseCastManager) {
        boolean d = baseCastManager.f9590h.d();
        if (d && !baseCastManager.f9606y) {
            baseCastManager.m11264a(10, baseCastManager.mo619x());
        }
        baseCastManager.f9606y = d;
    }

    private String mo619x() {
        WifiInfo o = this.f9590h.o();
        if (o != null) {
            return o.getSSID();
        }
        return null;
    }

    public void mo608a(CastDevice castDevice) {
        if (castDevice == null) {
            m11286j();
            return;
        }
        this.f9596n = castDevice;
        this.f9597o = this.f9596n.f9975e;
        if (this.f9601s == null) {
            Builder d = mo612d();
            GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.f9591i);
            Api api = Cast.f9968a;
            CastOptions castOptions = new CastOptions(d);
            zzx.a(api, "Api must not be null");
            zzx.a(castOptions, "Null options are not permitted for this Api");
            builder.j.put(api, castOptions);
            api.a();
            Collection b = zza.b();
            builder.c.addAll(b);
            builder.b.addAll(b);
            this.f9601s = builder.a(this).a(this).b();
            this.f9601s.c();
        } else if (!(this.f9601s.f() || this.f9601s.g())) {
            this.f9601s.c();
        }
        if (!m11292r()) {
            this.f9603v = 21;
        }
    }

    public final void m11282e() {
        this.f9593k.a(this.f9594l, this.f9595m, 4);
    }

    public final void m11275a(Bundle bundle) {
        Throwable e;
        if (this.f9598p) {
            this.f9598p = false;
            if (bundle == null || !bundle.getBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING")) {
                mo613f();
                return;
            } else {
                m11286j();
                return;
            }
        }
        this.f9603v = 22;
        this.f9589g.edit().a(f9584e, mo619x()).commit();
        mo618u();
        try {
            Cast.f9969b.mo631a(this.f9601s);
        } catch (IOException e2) {
            e = e2;
            this.f9602t.a(SoftError.a("CHROMECAST_CONNECTION_ERROR", "Exception : requestStatus()").a(e).g());
            mo620y();
        } catch (IllegalStateException e3) {
            e = e3;
            this.f9602t.a(SoftError.a("CHROMECAST_CONNECTION_ERROR", "Exception : requestStatus()").a(e).g());
            mo620y();
        }
        mo620y();
    }

    private void mo620y() {
        this.f9601s.toString();
        if (m11285h()) {
            try {
                if (this.f9587a == ReconnectionStatus.IN_PROGRESS) {
                    Cast.f9969b.mo633b(this.f9601s, this.f9592j, this.f9589g.a(f9583d, null)).a(new C10022(this));
                    return;
                }
                Cast.f9969b.mo630a(this.f9601s, this.f9592j, false).a(new C10033(this));
            } catch (Throwable e) {
                this.f9602t.a(SoftError.a("CHROMECAST_CONNECTION_ERROR", "Exception : launchApp()").a(e).g());
            }
        } else if (this.f9587a == ReconnectionStatus.IN_PROGRESS) {
            this.f9587a = ReconnectionStatus.IN_ACTIVE;
        }
    }

    public static boolean m11267a(int i, int i2) {
        return i == 0 || (i & i2) == i2;
    }

    public final boolean m11285h() {
        return this.f9601s != null && this.f9601s.f();
    }

    private boolean mo621z() {
        return this.f9601s != null && this.f9601s.g();
    }

    public final void m11286j() {
        if (m11285h() || mo621z()) {
            mo616l();
            m11266a(this.f9599q, true, true);
        }
    }

    private void mo605A() {
        if (m11285h() || mo621z()) {
            Cast.f9969b.mo628a(this.f9601s, this.f9600r).a(new C10044(this));
        }
    }

    private void m11266a(boolean z, boolean z2, boolean z3) {
        if (this.f9596n != null) {
            this.f9596n = null;
            this.f9597o = null;
            if (!this.f9598p && z2) {
                this.f9589g.a(this.f9589g.d(f9582c));
            }
            if (z) {
                mo605A();
            }
            this.f9603v = 24;
            mo617m();
            if (this.f9601s != null) {
                if (this.f9601s.f()) {
                    this.f9601s.e();
                }
                if (this.f9593k != null && z3) {
                    MediaRouter.a(MediaRouter.b());
                }
                this.f9601s = null;
            }
            this.f9600r = null;
        }
    }

    public void mo606a(int i) {
        this.f9598p = true;
        this.f9603v = 23;
    }

    public void mo609a(ConnectionResult connectionResult) {
        m11266a(this.f9599q, false, true);
        this.f9598p = false;
    }

    private void m11265a(RouteInfo routeInfo) {
        if (!m11285h()) {
            String a = this.f9589g.a(f9583d, null);
            String a2 = this.f9589g.a(f9585f, null);
            if (a != null && a2 != null) {
                this.f9587a = ReconnectionStatus.IN_PROGRESS;
                CastDevice b = CastDevice.m11767b(routeInfo.p);
                if (b != null) {
                    mo608a(b);
                }
            }
        }
    }

    public final void m11290p() {
        m11268d(10);
    }

    private void m11268d(int i) {
        m11264a(i, null);
    }

    private void m11264a(final int i, String str) {
        String a = this.f9589g.a(f9585f, null);
        if (!m11285h() && a != null) {
            Object obj = null;
            String a2 = this.f9589g.a(f9583d, null);
            String a3 = this.f9589g.a(f9585f, null);
            String a4 = this.f9589g.a(f9584e, null);
            if (!(a2 == null || a3 == null || (str != null && (a4 == null || !a4.equals(str))))) {
                obj = 1;
            }
            if (obj != null) {
                List<RouteInfo> a5 = MediaRouter.a();
                if (a5 != null) {
                    for (RouteInfo routeInfo : a5) {
                        if (routeInfo.c.equals(a)) {
                            break;
                        }
                    }
                }
                RouteInfo routeInfo2 = null;
                if (routeInfo2 != null) {
                    m11265a(routeInfo2);
                } else {
                    this.f9587a = ReconnectionStatus.STARTED;
                }
                if (!(this.f9588b == null || this.f9588b.isCancelled())) {
                    this.f9588b.cancel(true);
                }
                this.f9588b = new FbAsyncTask<Void, Integer, Boolean>(this) {
                    final /* synthetic */ BaseCastManager f9581b;

                    protected final Object m11262a(Object[] objArr) {
                        for (int i = 0; i < i; i++) {
                            if (isCancelled()) {
                                return Boolean.valueOf(true);
                            }
                            try {
                                if (this.f9581b.m11285h()) {
                                    cancel(true);
                                }
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                            }
                        }
                        return Boolean.valueOf(false);
                    }

                    protected void onPostExecute(Object obj) {
                        Boolean bool = (Boolean) obj;
                        if (bool == null || !bool.booleanValue()) {
                            this.f9581b.f9587a = ReconnectionStatus.IN_ACTIVE;
                            this.f9581b.mo608a(null);
                        }
                    }
                };
                this.f9588b.execute(new Void[0]);
            }
        }
    }

    public final boolean m11291q() {
        return MediaRouter.a(this.f9594l, 3);
    }

    public final boolean m11292r() {
        return this.f9587a != ReconnectionStatus.IN_ACTIVE;
    }

    public final String m11293s() {
        switch (this.f9603v) {
            case 21:
                return this.f9591i.getString(2131239000, new Object[]{this.f9597o});
            case 22:
                return this.f9591i.getString(2131238997, new Object[]{this.f9597o});
            case 23:
                return this.f9591i.getString(2131239001);
            case 24:
                return this.f9591i.getString(2131238998);
            default:
                return null;
        }
    }
}
