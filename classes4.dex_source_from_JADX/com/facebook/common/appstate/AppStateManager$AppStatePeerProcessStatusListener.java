package com.facebook.common.appstate;

import com.facebook.common.appstate.AppStateManager.AppStateInfo;
import com.facebook.multiprocess.peer.PeerInfo;
import com.facebook.multiprocess.peer.PeerProcessStatusListener;
import com.facebook.multiprocess.peer.PeerProcessStatusListener.Direction;

/* compiled from: mutual_friends */
class AppStateManager$AppStatePeerProcessStatusListener implements PeerProcessStatusListener {
    final /* synthetic */ AppStateManager f7312a;

    public AppStateManager$AppStatePeerProcessStatusListener(AppStateManager appStateManager) {
        this.f7312a = appStateManager;
    }

    public final void m7646a(PeerInfo peerInfo, Direction direction) {
        synchronized (this.f7312a) {
            this.f7312a.X.put(peerInfo, new AppStateInfo());
            if (direction == Direction.Incoming) {
                AppStateManager.v(this.f7312a).a(peerInfo, AppStateManager.x(this.f7312a));
            }
            new StringBuilder("Peer process ").append(peerInfo.c).append(" connected to ").append(AppStateManager.v(this.f7312a).a().c);
        }
    }

    public final void m7645a(PeerInfo peerInfo) {
        AppStateInfo appStateInfo = (AppStateInfo) this.f7312a.X.get(peerInfo);
        if (appStateInfo != null) {
            if (appStateInfo.a) {
                AppStateManager.N(this.f7312a);
            }
            if (appStateInfo.b) {
                AppStateManager.L(this.f7312a);
            }
            synchronized (this.f7312a) {
                this.f7312a.X.remove(appStateInfo);
                new StringBuilder("Peer process ").append(peerInfo.c).append(" disconnected from ").append(AppStateManager.v(this.f7312a).a().c);
            }
        }
    }
}
