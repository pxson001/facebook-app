package com.facebook.messages.ipc.peer;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.multiprocess.peer.state.PeerStateRole;
import com.facebook.multiprocess.peer.state.PeerStateRole.QueryStateResult;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: this method should be called while holding the lock */
public class ChatHeadPeerRole extends PeerStateRole {
    private final ActiveThreadsForPeerRole f3053b = new ActiveThreadsForPeerRole(MessageNotificationPeerContract.f2841g, "peer://msg_notification_chathead/active_threads");
    private boolean f3054c;
    private boolean f3055d;
    private boolean f3056e;
    private boolean f3057f;

    public ChatHeadPeerRole(int i) {
        super(MessageNotificationPeerContract.f2839e, i);
    }

    public final void mo679a(Bundle bundle) {
        this.f3053b.m5068a(bundle);
        bundle.putBoolean(MessageNotificationPeerContract.f2842h.getPath(), this.f3054c);
        bundle.putBoolean(MessageNotificationPeerContract.f2843i.getPath(), this.f3055d);
        bundle.putBoolean(MessageNotificationPeerContract.f2844j.getPath(), this.f3056e);
        bundle.putBoolean(MessageNotificationPeerContract.f2845k.getPath(), this.f3057f);
    }

    public final void mo681b(Bundle bundle) {
        this.f3053b.m5071b(bundle);
        this.f3054c = bundle.getBoolean(MessageNotificationPeerContract.f2842h.getPath(), false);
        this.f3055d = bundle.getBoolean(MessageNotificationPeerContract.f2843i.getPath(), false);
        this.f3056e = bundle.getBoolean(MessageNotificationPeerContract.f2844j.getPath(), false);
        this.f3057f = bundle.getBoolean(MessageNotificationPeerContract.f2845k.getPath(), false);
    }

    public final void mo677a() {
        this.f3053b.m5066a();
        this.f3054c = false;
        this.f3055d = false;
        this.f3056e = false;
        this.f3057f = false;
    }

    public final boolean mo680a(Uri uri, @Nullable Object obj) {
        if (MessageNotificationPeerContract.f2840f.equals(uri)) {
            mo677a();
            return true;
        } else if (this.f3053b.m5069a(uri)) {
            return this.f3053b.m5070a(uri, obj);
        } else {
            boolean z;
            if (MessageNotificationPeerContract.f2842h.equals(uri)) {
                z = this.f3054c;
                this.f3054c = Boolean.TRUE.equals(obj);
                if (z == this.f3054c) {
                    return false;
                }
                return true;
            } else if (MessageNotificationPeerContract.f2843i.equals(uri)) {
                z = this.f3055d;
                this.f3055d = Boolean.TRUE.equals(obj);
                if (z == this.f3055d) {
                    return false;
                }
                return true;
            } else if (MessageNotificationPeerContract.f2844j.equals(uri)) {
                z = this.f3056e;
                this.f3056e = Boolean.TRUE.equals(obj);
                if (z == this.f3056e) {
                    return false;
                }
                return true;
            } else if (!MessageNotificationPeerContract.f2845k.equals(uri)) {
                return false;
            } else {
                z = this.f3057f;
                this.f3057f = Boolean.TRUE.equals(obj);
                if (z == this.f3057f) {
                    return false;
                }
                return true;
            }
        }
    }

    public final void mo678a(Uri uri, QueryStateResult queryStateResult) {
        if (this.f3053b.m5069a(uri)) {
            this.f3053b.m5067a(uri, queryStateResult);
        } else if (MessageNotificationPeerContract.f2842h.equals(uri)) {
            queryStateResult.a = Boolean.valueOf(this.f3054c);
            if (this.f3054c) {
                queryStateResult.b = true;
            }
        } else if (MessageNotificationPeerContract.f2843i.equals(uri)) {
            queryStateResult.a = Boolean.valueOf(this.f3055d);
            if (this.f3055d) {
                queryStateResult.b = true;
            }
        } else if (MessageNotificationPeerContract.f2844j.equals(uri)) {
            queryStateResult.a = Boolean.valueOf(this.f3056e);
            if (this.f3056e) {
                queryStateResult.b = true;
            }
        } else if (MessageNotificationPeerContract.f2845k.equals(uri)) {
            queryStateResult.a = Boolean.valueOf(this.f3057f);
            if (this.f3057f) {
                queryStateResult.b = true;
            }
        }
    }
}
