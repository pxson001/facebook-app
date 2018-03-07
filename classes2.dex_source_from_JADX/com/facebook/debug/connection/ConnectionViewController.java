package com.facebook.debug.connection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

/* compiled from: php_profiling */
public class ConnectionViewController extends BaseController implements FragmentCreateDestroyCallbacks, ResumePauseCallbacks {
    public ActionReceiver f9878a;
    public final Lazy<FbBroadcastManager> f9879b;
    public ConnectionView f9880c;
    public final FbDataConnectionManager f9881d;
    private final FbSharedPreferences f9882e;
    public ConnectionQuality f9883f = this.f9881d.m3799b();
    public ConnectionQuality f9884g = this.f9881d.m3801c();
    public ConnectionQuality f9885h;
    public boolean f9886i;
    public Fragment f9887j;

    /* compiled from: php_profiling */
    class C04171 implements ActionReceiver {
        final /* synthetic */ ConnectionViewController f9888a;

        C04171(ConnectionViewController connectionViewController) {
            this.f9888a = connectionViewController;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 57413900);
            Bundle extras = intent.getExtras();
            this.f9888a.f9883f = (ConnectionQuality) extras.get(FbDataConnectionManager.f1877b);
            this.f9888a.f9885h = (ConnectionQuality) extras.get(FbDataConnectionManager.f1878c);
            this.f9888a.f9886i = extras.getBoolean(FbDataConnectionManager.f1879d);
            if (this.f9888a.f9883f == ConnectionQuality.UNKNOWN) {
                this.f9888a.f9884g = this.f9888a.f9881d.m3801c();
            }
            if (this.f9888a.f9880c != null) {
                this.f9888a.f9880c.invalidate();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2020066203, a);
        }
    }

    public static ConnectionViewController m14919a(InjectorLike injectorLike) {
        return new ConnectionViewController(IdBasedLazy.m1808a(injectorLike, 401), FbDataConnectionManager.m3787a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    @Inject
    public ConnectionViewController(Lazy<FbBroadcastManager> lazy, FbDataConnectionManager fbDataConnectionManager, FbSharedPreferences fbSharedPreferences) {
        this.f9882e = fbSharedPreferences;
        this.f9879b = lazy;
        this.f9881d = fbDataConnectionManager;
        this.f9886i = this.f9884g != ConnectionQuality.UNKNOWN;
        this.f9878a = new C04171(this);
    }

    public final void mo1264c() {
        if (this.f9882e.mo286a(DebugLoggingPrefKeys.f2808f, false)) {
            Context ao = ((FbFragment) this.f9887j).ao();
            if (this.f9880c == null) {
                this.f9880c = new ConnectionView(ao, this);
                ao.getWindow().addContentView(this.f9880c, new LayoutParams(100, 35, 3));
                ((BaseFbBroadcastManager) this.f9879b.get()).m2951a().mo506a(FbDataConnectionManager.f1876a, this.f9878a).mo503a().m3296b();
            }
        }
    }

    public final void mo1265d() {
    }

    public final void mo1949b() {
        this.f9887j = null;
    }

    public static int m14918a(ConnectionQuality connectionQuality) {
        if (connectionQuality == ConnectionQuality.POOR) {
            return -65536;
        }
        if (connectionQuality == ConnectionQuality.MODERATE) {
            return -39424;
        }
        if (connectionQuality == ConnectionQuality.GOOD) {
            return -256;
        }
        if (connectionQuality == ConnectionQuality.EXCELLENT) {
            return -16711936;
        }
        return -1;
    }
}
