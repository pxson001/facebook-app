package com.facebook.bugreporter.scheduler;

import com.facebook.bugreporter.BugReportRetryManager;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: android.intent.extra.SUBJECT */
public class BugReportRetryInvoker {
    public final BugReportRetryManager f10764a;
    private final ListeningExecutorService f10765b;
    public final BugReportRetryScheduler f10766c;

    /* compiled from: android.intent.extra.SUBJECT */
    class C10491 implements Runnable {
        final /* synthetic */ BugReportRetryInvoker f10763a;

        C10491(BugReportRetryInvoker bugReportRetryInvoker) {
            this.f10763a = bugReportRetryInvoker;
        }

        public void run() {
            if (!this.f10763a.f10764a.m18561a()) {
                this.f10763a.f10766c.a(60);
            }
        }
    }

    public static BugReportRetryInvoker m18793b(InjectorLike injectorLike) {
        return new BugReportRetryInvoker(BugReportRetryManager.m18550a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), BugReportRetryScheduler.a(injectorLike));
    }

    @Inject
    public BugReportRetryInvoker(BugReportRetryManager bugReportRetryManager, ListeningExecutorService listeningExecutorService, BugReportRetryScheduler bugReportRetryScheduler) {
        this.f10764a = bugReportRetryManager;
        this.f10765b = listeningExecutorService;
        this.f10766c = bugReportRetryScheduler;
    }

    public final ListenableFuture<?> m18794a() {
        return this.f10765b.a(new C10491(this));
    }
}
