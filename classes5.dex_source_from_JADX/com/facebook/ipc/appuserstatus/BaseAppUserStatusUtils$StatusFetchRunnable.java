package com.facebook.ipc.appuserstatus;

import com.facebook.ipc.appuserstatus.BaseAppUserStatusUtils.UserStatus;

/* compiled from: TOO_LONG */
class BaseAppUserStatusUtils$StatusFetchRunnable implements Runnable {
    final /* synthetic */ BaseAppUserStatusUtils f13918a;
    private final String f13919b;

    public BaseAppUserStatusUtils$StatusFetchRunnable(BaseAppUserStatusUtils baseAppUserStatusUtils, String str) {
        this.f13918a = baseAppUserStatusUtils;
        this.f13919b = str;
    }

    public void run() {
        UserStatus b = BaseAppUserStatusUtils.b(this.f13918a, this.f13919b);
        synchronized (this.f13918a.f) {
            this.f13918a.f.put(this.f13919b, new BaseAppUserStatusUtils$StatusFetchResult(b, this.f13918a.e.now()));
        }
        synchronized (this.f13918a.g) {
            this.f13918a.g.remove(this.f13919b);
        }
    }
}
