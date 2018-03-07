package com.facebook.ui.errors;

import com.facebook.base.broadcast.FbBroadcastManager.SelfRegistrableReceiver;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.network.OnConnectionChangedListener;
import java.util.List;
import javax.inject.Inject;

/* compiled from: nearby_places_fragment_view_state */
public class ConnectivityBannerController {
    public NetworkMonitor f5155a;
    public List<SelfRegistrableReceiver> f5156b;
    public OnConnectionChangedListener[] f5157c;

    /* compiled from: nearby_places_fragment_view_state */
    public class C06801 implements Runnable {
        final /* synthetic */ ConnectivityBannerController f5153a;

        public C06801(ConnectivityBannerController connectivityBannerController) {
            this.f5153a = connectivityBannerController;
        }

        public void run() {
            ConnectivityBannerController.m6407a(this.f5153a, State.CONNECTED, false);
        }
    }

    /* compiled from: nearby_places_fragment_view_state */
    public class C06812 implements Runnable {
        final /* synthetic */ ConnectivityBannerController f5154a;

        public C06812(ConnectivityBannerController connectivityBannerController) {
            this.f5154a = connectivityBannerController;
        }

        public void run() {
            ConnectivityBannerController.m6407a(this.f5154a, State.NO_INTERNET, false);
        }
    }

    @Inject
    public ConnectivityBannerController(NetworkMonitor networkMonitor) {
        this.f5155a = networkMonitor;
    }

    public final void m6408b() {
        m6407a(this, this.f5155a.a() ? State.CONNECTED : State.NO_INTERNET, true);
    }

    public static void m6407a(ConnectivityBannerController connectivityBannerController, State state, boolean z) {
        if (connectivityBannerController.f5157c != null) {
            for (int i = 0; i < connectivityBannerController.f5157c.length; i++) {
                boolean z2;
                if (state == State.CONNECTED) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z) {
                    connectivityBannerController.f5157c[i].b(z2);
                } else {
                    connectivityBannerController.f5157c[i].a(z2);
                }
            }
        }
    }
}
