package com.facebook.messages.ipc.peer;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.multiprocess.peer.state.PeerStateRole;
import com.facebook.multiprocess.peer.state.PeerStateRole.QueryStateResult;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: time_processing */
public class UserInteractionPeerRole extends PeerStateRole {
    private boolean f2851b;

    public UserInteractionPeerRole(int i) {
        super(MessageNotificationPeerContract.f2847m, i);
    }

    public final void mo679a(Bundle bundle) {
        bundle.putBoolean(MessageNotificationPeerContract.f2848n.getPath(), this.f2851b);
    }

    public final void mo681b(Bundle bundle) {
        this.f2851b = bundle.getBoolean(MessageNotificationPeerContract.f2848n.getPath(), false);
    }

    public final void mo677a() {
        this.f2851b = false;
    }

    public final boolean mo680a(Uri uri, @Nullable Object obj) {
        if (!MessageNotificationPeerContract.f2848n.equals(uri)) {
            return false;
        }
        boolean z = this.f2851b;
        this.f2851b = Boolean.TRUE.equals(obj);
        if (z != this.f2851b) {
            return true;
        }
        return false;
    }

    public final void mo678a(Uri uri, QueryStateResult queryStateResult) {
        if (MessageNotificationPeerContract.f2848n.equals(uri)) {
            queryStateResult.a = Boolean.valueOf(this.f2851b);
            if (this.f2851b) {
                queryStateResult.b = true;
            }
        }
    }
}
