package com.facebook.feed.ui.fullscreenvideoplayer.service;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: This catalyst instance has already been initialized */
public class VideoDeleteController {
    public static final CallerContext f22190a = CallerContext.a(VideoDeleteController.class);
    public final AbstractSingleMethodRunner f22191b;
    public final ListeningExecutorService f22192c;
    public final VideoDeleteMethod f22193d;

    /* compiled from: This catalyst instance has already been initialized */
    public class C18971 implements Callable<Void> {
        final /* synthetic */ VideoDeleteParams f22188a;
        final /* synthetic */ VideoDeleteController f22189b;

        public C18971(VideoDeleteController videoDeleteController, VideoDeleteParams videoDeleteParams) {
            this.f22189b = videoDeleteController;
            this.f22188a = videoDeleteParams;
        }

        public Object call() {
            this.f22189b.f22191b.a(this.f22189b.f22193d, this.f22188a, VideoDeleteController.f22190a);
            return null;
        }
    }

    public static VideoDeleteController m24839b(InjectorLike injectorLike) {
        return new VideoDeleteController((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), new VideoDeleteMethod());
    }

    @Inject
    public VideoDeleteController(AbstractSingleMethodRunner abstractSingleMethodRunner, ListeningExecutorService listeningExecutorService, VideoDeleteMethod videoDeleteMethod) {
        this.f22191b = abstractSingleMethodRunner;
        this.f22192c = listeningExecutorService;
        this.f22193d = videoDeleteMethod;
    }
}
