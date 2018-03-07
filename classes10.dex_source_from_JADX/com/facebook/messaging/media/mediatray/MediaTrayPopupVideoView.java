package com.facebook.messaging.media.mediatray;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.inject.FbInjector;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.formatting.VideoStringsFormatter;
import com.facebook.video.player.InlineVideoView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sections_cursor */
public class MediaTrayPopupVideoView extends CustomFrameLayout {
    public static final Class<?> f3134f = MediaTrayPopupVideoView.class;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f3135a;
    @Inject
    @ForUiThread
    ExecutorService f3136b;
    @Inject
    AbstractFbErrorReporter f3137c;
    @Inject
    MediaResourceHelper f3138d;
    @Inject
    VideoStringsFormatter f3139e;
    public TextView f3140g;
    public InlineVideoView f3141h;
    @Nullable
    public Listener f3142i;
    @Nullable
    private FutureAndCallbackHolder<MediaResource> f3143j;
    private boolean f3144k;
    private boolean f3145l;

    /* compiled from: sections_cursor */
    public interface Listener {
        void mo109a();
    }

    /* compiled from: sections_cursor */
    class C05142 extends AbstractDisposableFutureCallback<MediaResource> {
        final /* synthetic */ MediaTrayPopupVideoView f3133a;

        C05142(MediaTrayPopupVideoView mediaTrayPopupVideoView) {
            this.f3133a = mediaTrayPopupVideoView;
        }

        protected final void m3101a(Object obj) {
            MediaTrayPopupVideoView.setupInlineVideo(this.f3133a, (MediaResource) obj);
        }

        protected final void m3102a(Throwable th) {
            this.f3133a.f3140g.setVisibility(4);
            this.f3133a.f3141h.setVisibility(4);
            if (this.f3133a.f3142i != null) {
                this.f3133a.f3142i.mo109a();
            }
            this.f3133a.f3137c.a(MediaTrayPopupVideoView.f3134f.getName(), "Failed to fetch media resource for video", th);
        }
    }

    private static <T extends View> void m3106a(Class<T> cls, T t) {
        m3107a((Object) t, t.getContext());
    }

    private static void m3107a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MediaTrayPopupVideoView) obj).m3105a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), MediaResourceHelper.a(fbInjector), VideoStringsFormatter.a(fbInjector));
    }

    private void m3105a(ListeningExecutorService listeningExecutorService, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, MediaResourceHelper mediaResourceHelper, VideoStringsFormatter videoStringsFormatter) {
        this.f3135a = listeningExecutorService;
        this.f3136b = executorService;
        this.f3137c = abstractFbErrorReporter;
        this.f3138d = mediaResourceHelper;
        this.f3139e = videoStringsFormatter;
    }

    public MediaTrayPopupVideoView(Context context) {
        super(context);
        m3112e();
    }

    public MediaTrayPopupVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3112e();
    }

    public MediaTrayPopupVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3112e();
    }

    private void m3112e() {
        m3106a(MediaTrayPopupVideoView.class, (View) this);
        setContentView(2130905191);
        this.f3140g = (TextView) c(2131563758);
        this.f3141h = (InlineVideoView) c(2131563757);
    }

    public void setListener(Listener listener) {
        this.f3142i = listener;
    }

    public void setMediaResource(final MediaResource mediaResource) {
        Preconditions.checkArgument(mediaResource.d == Type.VIDEO);
        this.f3140g.setVisibility(4);
        this.f3141h.setVisibility(4);
        if (this.f3143j != null) {
            this.f3143j.a(true);
            this.f3143j = null;
        }
        ListenableFuture a = this.f3135a.a(new Callable<MediaResource>(this) {
            final /* synthetic */ MediaTrayPopupVideoView f3132b;

            public Object call() {
                MediaResourceBuilder a = MediaResource.a().a(mediaResource);
                this.f3132b.f3138d.a(a);
                return a.C();
            }
        });
        C05142 c05142 = new C05142(this);
        this.f3143j = FutureAndCallbackHolder.a(a, c05142);
        Futures.a(a, c05142, this.f3136b);
    }

    public final void m3114a(EventTriggerType eventTriggerType) {
        if (!this.f3141h.d()) {
            if (this.f3144k) {
                this.f3141h.setVisibility(0);
                this.f3141h.b(eventTriggerType);
                return;
            }
            this.f3145l = true;
        }
    }

    public final void m3115b(EventTriggerType eventTriggerType) {
        if (!this.f3141h.e()) {
            this.f3141h.d(eventTriggerType);
        }
    }

    public final void m3113a() {
        m3111c(EventTriggerType.BY_MEDIA_TRAY_DISMISS);
    }

    private void m3111c(EventTriggerType eventTriggerType) {
        if (this.f3141h.d()) {
            this.f3141h.c(eventTriggerType);
        }
    }

    public static void setupInlineVideo(MediaTrayPopupVideoView mediaTrayPopupVideoView, MediaResource mediaResource) {
        long j = mediaResource.s == -1 ? 0 : (long) mediaResource.s;
        long j2 = mediaResource.t == -2 ? mediaResource.i : (long) mediaResource.t;
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = mediaResource.c;
        newBuilder = newBuilder;
        newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(newBuilder.i());
        a.b = mediaResource.u;
        a = a;
        a.c = (int) (j2 - j);
        a = a;
        a.o = (int) j;
        a = a;
        a.p = (int) j2;
        a = a;
        a.g = true;
        mediaTrayPopupVideoView.f3141h.setVideoData(a.m());
        mediaTrayPopupVideoView.f3144k = true;
        if (mediaTrayPopupVideoView.f3145l) {
            mediaTrayPopupVideoView.m3114a(EventTriggerType.BY_AUTOPLAY);
        }
        mediaTrayPopupVideoView.f3141h.setCenterCrop(mediaResource);
        mediaTrayPopupVideoView.f3140g.setText(mediaTrayPopupVideoView.f3139e.a(j2 - j));
        mediaTrayPopupVideoView.f3140g.setVisibility(0);
        mediaTrayPopupVideoView.f3141h.a(true, EventTriggerType.BY_AUTOPLAY);
    }
}
