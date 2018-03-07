package com.facebook.video.engine.texview.exo;

import android.os.Process;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;
import java.util.concurrent.ThreadFactory;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$12 implements ThreadFactory {
    final /* synthetic */ ServiceListenerStub f18896a;

    ExoVideoPlayerClient$ServiceListenerStub$12(ServiceListenerStub serviceListenerStub) {
        this.f18896a = serviceListenerStub;
    }

    public Thread newThread(final Runnable runnable) {
        return ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ ExoVideoPlayerClient$ServiceListenerStub$12 f18895b;

            public void run() {
                try {
                    Process.setThreadPriority(-1);
                } catch (Throwable th) {
                    ExoVideoPlayerClient.F();
                }
                runnable.run();
            }
        }, "ExoVideoPlayerServiceListenerCallback-" + ExoVideoPlayerClient.V.incrementAndGet(), 1847386779);
    }
}
