package com.facebook.facerec.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.facedetection.Tracker;
import com.facebook.facerec.job.TagSuggestFetchJob;
import com.facebook.facerec.manager.LocalSuggestionsStore.LocalSuggestionsInitRunnable;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: note */
public class FaceRecManager {
    public final boolean f9883a;
    public final DefaultAndroidThreadUtil f9884b;
    protected final PerformanceLogger f9885c;
    public final Tracker f9886d;
    public final Handler f9887e;
    private final AbstractFbErrorReporter f9888f;
    private final ApiMethodRunnerImpl f9889g;
    public final LocalSuggestionsStore f9890h;
    public final ResizeOptions f9891i;
    private final ListeningExecutorService f9892j;
    private final Looper f9893k;
    public final Handler f9894l;
    public final Map<Long, TagSuggestFetchJob> f9895m;

    /* compiled from: note */
    public class TagSuggestFetchCompletedListenerImpl {
        public final /* synthetic */ FaceRecManager f9880a;
        public final SettableFuture<List<List<TaggingProfile>>> f9881b;
        public final long f9882c;

        /* compiled from: note */
        public class C05992 implements Runnable {
            final /* synthetic */ boolean f9878a;
            final /* synthetic */ TagSuggestFetchCompletedListenerImpl f9879b;

            public C05992(TagSuggestFetchCompletedListenerImpl tagSuggestFetchCompletedListenerImpl, boolean z) {
                this.f9879b = tagSuggestFetchCompletedListenerImpl;
                this.f9878a = z;
            }

            public void run() {
                if (this.f9878a) {
                    this.f9879b.f9881b.a(new TagSuggestFetchTimeoutException());
                }
                this.f9879b.f9881b.cancel(true);
            }
        }

        public TagSuggestFetchCompletedListenerImpl(FaceRecManager faceRecManager, SettableFuture<List<List<TaggingProfile>>> settableFuture, long j) {
            this.f9880a = faceRecManager;
            this.f9881b = settableFuture;
            this.f9882c = j;
        }

        public final void m15620a(List<FaceBox> list) {
            final List a = Lists.a();
            for (FaceBox n : list) {
                a.add(n.mo1102n());
            }
            HandlerDetour.a(this.f9880a.f9887e, new Runnable(this) {
                final /* synthetic */ TagSuggestFetchCompletedListenerImpl f9877b;

                public void run() {
                    this.f9877b.f9880a.f9895m.remove(Long.valueOf(this.f9877b.f9882c));
                    FutureDetour.a(this.f9877b.f9881b, a, 456032);
                }
            }, -517388442);
        }
    }

    /* compiled from: note */
    public class TagSuggestFetchTimeoutException extends Exception {
        public TagSuggestFetchTimeoutException() {
            super("Tag suggestions fetch timed out");
        }
    }

    public FaceRecManager(Handler handler, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, ApiMethodRunnerImpl apiMethodRunnerImpl, ListeningExecutorService listeningExecutorService, Tracker tracker, PerformanceLogger performanceLogger, LocalSuggestionsStore localSuggestionsStore, FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f9890h = localSuggestionsStore;
        this.f9888f = abstractFbErrorReporter;
        this.f9884b = defaultAndroidThreadUtil;
        if (tracker.m15545a()) {
            this.f9883a = true;
            this.f9889g = apiMethodRunnerImpl;
            this.f9886d = tracker;
            this.f9885c = performanceLogger;
            fbHandlerThreadFactory.a("FaceRecManager_FD", ThreadPriority.BACKGROUND).start();
            HandlerThread a = fbHandlerThreadFactory.a("TagSuggestInterrupter", ThreadPriority.BACKGROUND);
            a.start();
            this.f9893k = a.getLooper();
            this.f9894l = new Handler(this.f9893k);
        } else {
            this.f9883a = false;
            this.f9889g = apiMethodRunnerImpl;
            this.f9886d = tracker;
            this.f9885c = null;
            this.f9893k = null;
            this.f9894l = null;
        }
        this.f9892j = listeningExecutorService;
        ExecutorDetour.a(this.f9892j, new LocalSuggestionsInitRunnable(localSuggestionsStore), 532702523);
        this.f9887e = handler;
        this.f9895m = Maps.c();
        this.f9891i = new ResizeOptions(this.f9886d.f9799a, this.f9886d.f9799a);
    }

    protected void finalize() {
        super.finalize();
        mo1025a();
    }

    public final ListenableFuture<List<List<TaggingProfile>>> m15621a(List<FaceBox> list, long j, String str) {
        SettableFuture f = SettableFuture.f();
        if (this.f9894l == null) {
            this.f9888f.a("FaceRecManager", "InterrupterHandler is not initialized.");
            FutureDetour.a(f, new ArrayList(), -657758232);
        } else {
            final Runnable tagSuggestFetchJob = new TagSuggestFetchJob(new TagSuggestFetchCompletedListenerImpl(this, f, j), this.f9884b, this.f9888f, this.f9889g, list, this.f9885c, this.f9890h, str, j);
            this.f9895m.put(Long.valueOf(j), tagSuggestFetchJob);
            this.f9894l.removeCallbacksAndMessages(null);
            HandlerDetour.b(this.f9894l, new Runnable(this) {
                final /* synthetic */ FaceRecManager f9873b;

                public void run() {
                    tagSuggestFetchJob.m15595a(false, true);
                }
            }, 10000, 1231145214);
            ExecutorDetour.a(this.f9892j, tagSuggestFetchJob, -614021639);
        }
        return f;
    }

    public void mo1025a() {
        if (this.f9895m != null) {
            for (final TagSuggestFetchJob tagSuggestFetchJob : this.f9895m.values()) {
                if (this.f9894l != null) {
                    HandlerDetour.a(this.f9894l, new Runnable(this) {
                        final /* synthetic */ FaceRecManager f9875b;

                        public void run() {
                            tagSuggestFetchJob.m15595a(false, false);
                        }
                    }, 1042381787);
                }
            }
        }
        if (this.f9893k != null) {
            this.f9893k.quit();
        }
    }
}
