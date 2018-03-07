package com.facebook.presence;

import com.facebook.user.model.UserKey;

/* compiled from: image_block_image */
class ThreadPresenceManager$5 implements Runnable {
    final /* synthetic */ UserKey f11194a;
    final /* synthetic */ ThreadPresenceManager f11195b;

    ThreadPresenceManager$5(ThreadPresenceManager threadPresenceManager, UserKey userKey) {
        this.f11195b = threadPresenceManager;
        this.f11194a = userKey;
    }

    public void run() {
        ThreadPresenceManager.h(this.f11195b, this.f11194a);
    }
}
