package com.facebook.photos.prefetch;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: video_data_url */
public class BackgroundHandoffHelper {
    private final DefaultAndroidThreadUtil f375a;
    private final ExecutorService f376b;
    public final BackgroundHandoffConsumer f377c;
    public final Object f378d = new Object();
    private final BackgroundRunnable f379e = new BackgroundRunnable(this);
    @GuardedBy("mUiLock")
    public final List<PrefetchParams> f380f = new ArrayList(40);
    @GuardedBy("mUiLock")
    public final List<PrefetchParams> f381g = new ArrayList(40);
    private volatile boolean f382h = false;

    /* compiled from: video_data_url */
    public interface BackgroundHandoffConsumer {
        void mo21a(List<PrefetchParams> list, List<PrefetchParams> list2);
    }

    /* compiled from: video_data_url */
    class BackgroundRunnable implements Runnable {
        final /* synthetic */ BackgroundHandoffHelper f383a;
        private final List<PrefetchParams> f384b = new ArrayList(40);
        private final List<PrefetchParams> f385c = new ArrayList(40);

        public BackgroundRunnable(BackgroundHandoffHelper backgroundHandoffHelper) {
            this.f383a = backgroundHandoffHelper;
        }

        public void run() {
            synchronized (this.f383a.f378d) {
                BackgroundHandoffHelper.m646c(this.f383a.f380f, this.f384b);
                BackgroundHandoffHelper.m646c(this.f383a.f381g, this.f385c);
                this.f383a.f382h = false;
            }
            this.f383a.f377c.mo21a(this.f384b, this.f385c);
        }
    }

    @Inject
    public BackgroundHandoffHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, @Assisted ExecutorService executorService, @Assisted BackgroundHandoffConsumer backgroundHandoffConsumer) {
        this.f375a = defaultAndroidThreadUtil;
        this.f376b = executorService;
        this.f377c = backgroundHandoffConsumer;
    }

    public final void m647a(List<PrefetchParams> list, List<PrefetchParams> list2) {
        this.f375a.a();
        synchronized (this.f378d) {
            m646c(list, this.f380f);
            m646c(list2, this.f381g);
            if (this.f382h) {
                return;
            }
            ExecutorDetour.a(this.f376b, this.f379e, -47779072);
            this.f382h = true;
        }
    }

    public static <T> void m646c(List<T> list, List<T> list2) {
        list2.clear();
        list2.addAll(list);
    }
}
