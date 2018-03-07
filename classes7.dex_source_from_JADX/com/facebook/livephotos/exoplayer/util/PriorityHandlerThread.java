package com.facebook.livephotos.exoplayer.util;

import android.os.HandlerThread;
import android.os.Process;

/* compiled from: open_album_actions */
public final class PriorityHandlerThread extends HandlerThread {
    private final int f7734a;

    public PriorityHandlerThread(String str, int i) {
        super(str);
        this.f7734a = i;
    }

    public final void run() {
        Process.setThreadPriority(this.f7734a);
        super.run();
    }
}
