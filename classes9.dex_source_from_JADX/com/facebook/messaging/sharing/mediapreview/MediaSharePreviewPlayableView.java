package com.facebook.messaging.sharing.mediapreview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
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
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=null */
public class MediaSharePreviewPlayableView extends CustomFrameLayout {
    public static final Class<?> f17412i = MediaSharePreviewPlayableView.class;
    @Nullable
    public ErrorListener f17413a;
    @Nullable
    public MediaResourceListener f17414b;
    @Nullable
    FutureAndCallbackHolder<MediaResource> f17415c;
    @DefaultExecutorService
    @Inject
    ListeningExecutorService f17416d;
    @Inject
    AbstractFbErrorReporter f17417e;
    @Inject
    @ForUiThread
    ExecutorService f17418f;
    @Inject
    MediaResourceHelper f17419g;
    @Inject
    VideoStringsFormatter f17420h;
    private VideoScaleType f17421j;
    private Type f17422k;
    public InlineVideoView f17423l;
    public ImageView f17424m;
    public TextView f17425n;
    private boolean f17426o;

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=null */
    class C20712 extends AbstractDisposableFutureCallback<MediaResource> {
        final /* synthetic */ MediaSharePreviewPlayableView f17410a;

        C20712(MediaSharePreviewPlayableView mediaSharePreviewPlayableView) {
            this.f17410a = mediaSharePreviewPlayableView;
        }

        protected final void m17379a(Object obj) {
            MediaResource mediaResource = (MediaResource) obj;
            if (this.f17410a.f17414b != null) {
                this.f17410a.f17414b.mo697a();
            }
            if (mediaResource.d == Type.VIDEO) {
                MediaSharePreviewPlayableView.setupInlineVideo(this.f17410a, mediaResource);
            } else if (mediaResource.d == Type.AUDIO) {
                MediaSharePreviewPlayableView.setupAudioPlaceholder(this.f17410a, mediaResource);
            }
        }

        protected final void m17380a(Throwable th) {
            if (this.f17410a.f17424m != null) {
                this.f17410a.f17424m.setVisibility(4);
            }
            if (this.f17410a.f17423l != null) {
                this.f17410a.f17423l.setVisibility(4);
            }
            this.f17410a.f17425n.setVisibility(4);
            if (this.f17410a.f17413a != null) {
                this.f17410a.f17413a.mo698a();
            }
            this.f17410a.f17417e.a(MediaSharePreviewPlayableView.f17412i.getName(), "Failed to fetch media resource for playable", th);
        }
    }

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=null */
    public interface ErrorListener {
        void mo698a();
    }

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=null */
    public interface MediaResourceListener {
        void mo697a();
    }

    /* compiled from: composer/?%s=<share_link>&%s=<app_id>&%s=true&%s=<in_app>&%s=null&%s=null&%s=null&%s=null&%s=null */
    public enum VideoScaleType {
        CENTER_CROP,
        FIT_INSIDE
    }

    private static <T extends View> void m17391a(Class<T> cls, T t) {
        m17392a((Object) t, t.getContext());
    }

    private static void m17392a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MediaSharePreviewPlayableView) obj).m17390a(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), MediaResourceHelper.a(fbInjector), VideoStringsFormatter.a(fbInjector));
    }

    public MediaSharePreviewPlayableView(Context context) {
        super(context);
        m17388a(null);
    }

    public MediaSharePreviewPlayableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17388a(attributeSet);
    }

    public MediaSharePreviewPlayableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17388a(attributeSet);
    }

    private void m17388a(@Nullable AttributeSet attributeSet) {
        m17391a(MediaSharePreviewPlayableView.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MediaSharePreviewPlayableView);
            this.f17421j = VideoScaleType.values()[obtainStyledAttributes.getInt(0, 0)];
            obtainStyledAttributes.recycle();
        }
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.f17413a = errorListener;
    }

    public void setMediaResourceListener(MediaResourceListener mediaResourceListener) {
        this.f17414b = mediaResourceListener;
    }

    public final void m17397a(final MediaResource mediaResource, int i) {
        this.f17422k = mediaResource.d;
        if (this.f17422k == Type.AUDIO) {
            setContentView(i);
            this.f17425n = (TextView) c(2131565108);
        } else if (this.f17422k == Type.VIDEO) {
            setContentView(2130905846);
            this.f17425n = (TextView) c(2131563758);
        }
        this.f17425n.setVisibility(4);
        if (this.f17415c != null) {
            this.f17415c.a(true);
            this.f17415c = null;
        }
        ListenableFuture a = this.f17416d.a(new Callable<MediaResource>(this) {
            final /* synthetic */ MediaSharePreviewPlayableView f17409b;

            public Object call() {
                return this.f17409b.m17385a(mediaResource);
            }
        });
        C20712 c20712 = new C20712(this);
        this.f17415c = FutureAndCallbackHolder.a(a, c20712);
        Futures.a(a, c20712, this.f17418f);
    }

    private void m17390a(ListeningExecutorService listeningExecutorService, AbstractFbErrorReporter abstractFbErrorReporter, ExecutorService executorService, MediaResourceHelper mediaResourceHelper, VideoStringsFormatter videoStringsFormatter) {
        this.f17416d = listeningExecutorService;
        this.f17417e = abstractFbErrorReporter;
        this.f17418f = executorService;
        this.f17419g = mediaResourceHelper;
        this.f17420h = videoStringsFormatter;
    }

    private void m17389a(EventTriggerType eventTriggerType) {
        if (!this.f17423l.d() && this.f17426o) {
            this.f17423l.setVisibility(0);
            this.f17423l.b(eventTriggerType);
        }
    }

    private MediaResource m17385a(MediaResource mediaResource) {
        MediaResourceBuilder a = MediaResource.a().a(mediaResource);
        if (this.f17422k == Type.VIDEO) {
            a.c = Source.CAMERA;
        }
        this.f17419g.a(a);
        return a.C();
    }

    public static void setupAudioPlaceholder(MediaSharePreviewPlayableView mediaSharePreviewPlayableView, MediaResource mediaResource) {
        mediaSharePreviewPlayableView.f17424m = (ImageView) mediaSharePreviewPlayableView.c(2131565107);
        mediaSharePreviewPlayableView.f17425n.setText(m17387a(mediaResource.i));
        mediaSharePreviewPlayableView.f17425n.setVisibility(0);
    }

    private static String m17387a(long j) {
        int round = Math.round(((float) j) / 1000.0f);
        return StringFormatUtil.formatStrLocaleSafe("%d:%02d", Integer.valueOf(round / 60), Integer.valueOf(round % 60));
    }

    public static void setupInlineVideo(MediaSharePreviewPlayableView mediaSharePreviewPlayableView, MediaResource mediaResource) {
        mediaSharePreviewPlayableView.f17423l = (InlineVideoView) mediaSharePreviewPlayableView.c(2131563757);
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = mediaResource.c;
        newBuilder = newBuilder;
        newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(newBuilder.i());
        a.b = mediaResource.u;
        a = a;
        a.c = (int) mediaResource.i;
        a = a;
        a.g = true;
        mediaSharePreviewPlayableView.f17423l.setVideoData(a.m());
        mediaSharePreviewPlayableView.f17423l.a(true, EventTriggerType.BY_AUTOPLAY);
        mediaSharePreviewPlayableView.f17426o = true;
        mediaSharePreviewPlayableView.m17389a(EventTriggerType.BY_AUTOPLAY);
        switch (mediaSharePreviewPlayableView.f17421j) {
            case CENTER_CROP:
                mediaSharePreviewPlayableView.f17423l.setCenterCrop(mediaResource);
                break;
            case FIT_INSIDE:
                mediaSharePreviewPlayableView.f17423l.setFitInside(mediaResource);
                break;
        }
        mediaSharePreviewPlayableView.f17425n.setText(mediaSharePreviewPlayableView.f17420h.a((long) mediaResource.b()));
        mediaSharePreviewPlayableView.f17425n.setVisibility(0);
    }
}
