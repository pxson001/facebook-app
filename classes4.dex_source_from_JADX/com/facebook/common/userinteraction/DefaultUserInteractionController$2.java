package com.facebook.common.userinteraction;

import java.util.concurrent.Semaphore;

/* compiled from: is_update */
class DefaultUserInteractionController$2 implements UserInteractionListener {
    final /* synthetic */ Semaphore f9783a;
    final /* synthetic */ DefaultUserInteractionController f9784b;

    DefaultUserInteractionController$2(DefaultUserInteractionController defaultUserInteractionController, Semaphore semaphore) {
        this.f9784b = defaultUserInteractionController;
        this.f9783a = semaphore;
    }

    public final void m10205a(boolean z) {
        if (!z) {
            this.f9783a.release();
        }
    }
}
