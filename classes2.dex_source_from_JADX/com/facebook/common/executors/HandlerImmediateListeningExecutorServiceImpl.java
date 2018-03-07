package com.facebook.common.executors;

import android.os.Handler;

/* compiled from: user_image_url */
public class HandlerImmediateListeningExecutorServiceImpl extends HandlerListeningExecutorServiceImpl {
    public HandlerImmediateListeningExecutorServiceImpl(Handler handler) {
        super(handler);
    }

    public void execute(Runnable runnable) {
        if (this.f966a.getLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
