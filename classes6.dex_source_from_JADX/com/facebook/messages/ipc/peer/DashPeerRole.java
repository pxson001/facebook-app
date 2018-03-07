package com.facebook.messages.ipc.peer;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.multiprocess.peer.state.PeerStateRole;
import com.facebook.multiprocess.peer.state.PeerStateRole.QueryStateResult;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: visitor */
public class DashPeerRole extends PeerStateRole {
    private final ActiveThreadsForPeerRole f429b = new ActiveThreadsForPeerRole(MessageNotificationPeerContract.c, "peer://msg_notification_dash/active_threads");
    private boolean f430c;

    public DashPeerRole(int i) {
        super(MessageNotificationPeerContract.a, i);
    }

    public final void m381a(Bundle bundle) {
        bundle.putBoolean(MessageNotificationPeerContract.d.getPath(), this.f430c);
        this.f429b.a(bundle);
    }

    public final void m383b(Bundle bundle) {
        this.f430c = bundle.getBoolean(MessageNotificationPeerContract.d.getPath(), false);
        this.f429b.b(bundle);
    }

    public final void m379a() {
        this.f429b.a();
        this.f430c = false;
    }

    public final boolean m382a(Uri uri, Object obj) {
        boolean z = true;
        if (MessageNotificationPeerContract.b.equals(uri)) {
            a();
            return true;
        } else if (!MessageNotificationPeerContract.d.equals(uri)) {
            return this.f429b.a(uri) ? this.f429b.a(uri, obj) : false;
        } else {
            boolean equals = Boolean.TRUE.equals(obj);
            if (equals == this.f430c) {
                z = false;
            }
            this.f430c = equals;
            return z;
        }
    }

    public final void m380a(Uri uri, QueryStateResult queryStateResult) {
        if (MessageNotificationPeerContract.d.equals(uri)) {
            queryStateResult.a = Boolean.valueOf(this.f430c);
            if (this.f430c) {
                queryStateResult.b = true;
            }
        } else if (this.f429b.a(uri)) {
            this.f429b.a(uri, queryStateResult);
        }
    }
}
