package com.facebook.multiprocess.peer.state;

import android.net.Uri;
import android.os.Bundle;
import java.util.Comparator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: time_last_weekend_photo_reminder_prompt_posted */
public abstract class PeerStateRole {
    static Comparator<PeerStateRole> f2852a = new C01811();
    public final Uri f2853b;
    public final int f2854c;

    /* compiled from: time_last_weekend_photo_reminder_prompt_posted */
    final class C01811 implements Comparator<PeerStateRole> {
        C01811() {
        }

        public final int compare(Object obj, Object obj2) {
            PeerStateRole peerStateRole = (PeerStateRole) obj;
            PeerStateRole peerStateRole2 = (PeerStateRole) obj2;
            if (peerStateRole.f2854c > peerStateRole2.f2854c) {
                return -1;
            }
            return peerStateRole.f2854c < peerStateRole2.f2854c ? 1 : Integer.valueOf(peerStateRole.hashCode()).compareTo(Integer.valueOf(peerStateRole2.hashCode()));
        }
    }

    public abstract void mo677a();

    public abstract void mo678a(Uri uri, QueryStateResult queryStateResult);

    public abstract void mo679a(Bundle bundle);

    public abstract boolean mo680a(Uri uri, @Nullable Object obj);

    public abstract void mo681b(Bundle bundle);

    protected PeerStateRole(Uri uri, int i) {
        this.f2853b = uri;
        this.f2854c = i;
    }

    public final int m4848b() {
        return this.f2854c;
    }

    public final Uri m4850c() {
        return this.f2853b;
    }
}
