package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* compiled from: SEND_SKIPPED_FB_SHARE */
public class LockOnGetVariable<T> {
    private T f24004a;
    public CountDownLatch f24005b = new CountDownLatch(1);

    public LockOnGetVariable(final Callable<T> callable) {
        ExecutorDetour.a(FacebookSdk.m14050d(), new FutureTask(new Callable<Void>(this) {
            final /* synthetic */ LockOnGetVariable f24003b;

            public Object call() {
                try {
                    this.f24003b.f24004a = callable.call();
                    return null;
                } finally {
                    this.f24003b.f24005b.countDown();
                }
            }
        }), 658022235);
    }
}
