package com.facebook.common.appstate;

import android.os.Bundle;
import android.os.Message;
import com.facebook.common.appstate.AppStateManager.AppStateInfo;
import com.facebook.multiprocess.peer.PeerInfo;
import com.facebook.multiprocess.peer.PeerProcessMessageListener;

/* compiled from: mutual_friends */
class AppStateManager$AppStatePeerProcessMessageListener implements PeerProcessMessageListener {
    final /* synthetic */ AppStateManager f7313a;

    public AppStateManager$AppStatePeerProcessMessageListener(AppStateManager appStateManager) {
        this.f7313a = appStateManager;
    }

    public final void m7647a(PeerInfo peerInfo, Message message) {
        synchronized (this.f7313a) {
            AppStateInfo appStateInfo = (AppStateInfo) this.f7313a.X.get(peerInfo);
            if (appStateInfo == null) {
                new StringBuilder("The peer ").append(peerInfo.c).append(" wasn't registered");
                return;
            }
            Bundle data = message.getData();
            data.setClassLoader(AppStateInfo.class.getClassLoader());
            AppStateManager.a(this.f7313a, (AppStateInfo) data.getParcelable("app_state_info"), appStateInfo);
        }
    }
}
