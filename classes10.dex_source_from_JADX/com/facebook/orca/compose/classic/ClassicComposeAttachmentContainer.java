package com.facebook.orca.compose.classic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.SingleThreadedExecutorService;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.upload.MediaUploadStatusUtil;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.orca.compose.AttachmentContainer;
import com.facebook.orca.compose.AttachmentContainer.Callback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.videocodec.extract.VideoThumbnailExtractor;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.JdkFutureAdapters;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: openInNewWebView */
public class ClassicComposeAttachmentContainer extends CustomViewGroup implements AttachmentContainer {
    public static final Class<?> f5705h = ClassicComposeAttachmentContainer.class;
    private static final CallerContext f5706i = CallerContext.a(ClassicComposeAttachmentContainer.class, "search");
    @Inject
    LayoutInflater f5707a;
    @Inject
    MediaUploadStatusUtil f5708b;
    @Inject
    @SingleThreadedExecutorService
    ExecutorService f5709c;
    @Inject
    @ForUiThread
    ExecutorService f5710d;
    @Inject
    AbstractFbErrorReporter f5711e;
    @Inject
    VideoThumbnailExtractor f5712f;
    @Inject
    Provider<FbDraweeControllerBuilder> f5713g;
    private final FbDraweeControllerBuilder f5714j;
    private final LinkedHashMap<MediaResource, View> f5715k;
    private final LinearLayout f5716l;
    private final HorizontalScrollView f5717m;
    public Callback f5718n;
    private final int f5719o;

    private static <T extends View> void m5395a(Class<T> cls, T t) {
        m5396a((Object) t, t.getContext());
    }

    private static void m5396a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ClassicComposeAttachmentContainer) obj).m5394a(LayoutInflaterMethodAutoProvider.b(fbInjector), MediaUploadStatusUtil.a(fbInjector), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(fbInjector), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), VideoThumbnailExtractor.a(fbInjector), IdBasedProvider.a(fbInjector, 1117));
    }

    public ClassicComposeAttachmentContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m5394a(LayoutInflater layoutInflater, MediaUploadStatusUtil mediaUploadStatusUtil, ExecutorService executorService, ExecutorService executorService2, FbErrorReporter fbErrorReporter, VideoThumbnailExtractor videoThumbnailExtractor, Provider<FbDraweeControllerBuilder> provider) {
        this.f5707a = layoutInflater;
        this.f5708b = mediaUploadStatusUtil;
        this.f5709c = executorService;
        this.f5710d = executorService2;
        this.f5711e = fbErrorReporter;
        this.f5712f = videoThumbnailExtractor;
        this.f5713g = provider;
    }

    public ClassicComposeAttachmentContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5715k = Maps.d();
        m5395a(ClassicComposeAttachmentContainer.class, (View) this);
        this.f5714j = ((FbDraweeControllerBuilder) this.f5713g.get()).a(f5706i);
        setContentView(2130905588);
        this.f5716l = (LinearLayout) getView(2131564516);
        this.f5717m = (HorizontalScrollView) getView(2131564515);
        this.f5719o = getContext().getResources().getDimensionPixelSize(2131428538);
    }

    public void setAttachmentContainerCallback(Callback callback) {
        this.f5718n = callback;
    }

    public final void mo210a(final MediaResource mediaResource) {
        if (mediaResource.d == Type.PHOTO || mediaResource.d == Type.VIDEO) {
            View view;
            if (mediaResource.d == Type.VIDEO) {
                View inflate = this.f5707a.inflate(2130905639, this.f5716l, false);
                final ImageView imageView = (ImageView) inflate.findViewById(2131564690);
                Futures.a(JdkFutureAdapters.a(ExecutorDetour.a(this.f5709c, new Callable<Bitmap>(this) {
                    final /* synthetic */ ClassicComposeAttachmentContainer f5698b;

                    public Object call() {
                        return this.f5698b.f5712f.a(mediaResource.c, 3);
                    }
                }, 475974709)), new AbstractDisposableFutureCallback<Bitmap>(this) {
                    final /* synthetic */ ClassicComposeAttachmentContainer f5700b;

                    public final void m5391a(Object obj) {
                        imageView.setImageBitmap((Bitmap) obj);
                    }

                    public final void m5392a(Throwable th) {
                        this.f5700b.f5711e.a(ClassicComposeAttachmentContainer.f5705h.getName(), "Fetching video thumbnail failed", th);
                    }
                }, this.f5710d);
                this.f5716l.addView(inflate);
                this.f5717m.setVisibility(0);
                view = inflate;
            } else {
                View inflate2 = this.f5707a.inflate(2130905638, this.f5716l, false);
                FbDraweeView fbDraweeView = (FbDraweeView) inflate2.findViewById(2131560553);
                ImageRequestBuilder a = ImageRequestBuilder.a(mediaResource.c);
                a.d = new ResizeOptions(this.f5719o, this.f5719o);
                fbDraweeView.setController(((FbDraweeControllerBuilder) this.f5714j.c(a.m())).s());
                this.f5716l.addView(inflate2);
                this.f5717m.setVisibility(0);
                view = inflate2;
            }
            view.findViewById(2131560557).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ClassicComposeAttachmentContainer f5702b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1826562431);
                    this.f5702b.f5718n.mo143b(mediaResource);
                    Logger.a(2, EntryType.UI_INPUT_END, 1304145095, a);
                }
            });
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ClassicComposeAttachmentContainer f5704b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -471708206);
                    if (this.f5704b.f5718n != null) {
                        this.f5704b.f5718n.mo142a(mediaResource);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1676411622, a);
                }
            });
            this.f5715k.put(mediaResource, view);
            this.f5717m.setVisibility(0);
        }
    }

    public final void mo211b(MediaResource mediaResource) {
        if (!this.f5715k.isEmpty()) {
            View view = (View) this.f5715k.remove(mediaResource);
            if (view != null) {
                this.f5716l.removeView(view);
            }
            if (this.f5716l.getChildCount() == 0) {
                this.f5717m.setVisibility(8);
            }
        }
    }

    public final void mo208a() {
        this.f5715k.clear();
        this.f5716l.removeAllViews();
        this.f5717m.setVisibility(8);
    }

    public final void mo209a(Intent intent) {
        ProgressBar progressBar = null;
        MediaResource mediaResource = (MediaResource) intent.getParcelableExtra("resource");
        if (mediaResource != null) {
            MediaResource c = m5398c(mediaResource);
            if (c != null) {
                View findViewById;
                ProgressBar progressBar2;
                if (c.d == Type.PHOTO) {
                    progressBar2 = (ProgressBar) findViewById(2131564688);
                    progressBar = progressBar2;
                    findViewById = findViewById(2131564687);
                } else if (c.d == Type.VIDEO) {
                    progressBar2 = (ProgressBar) ((View) this.f5715k.get(c)).findViewById(2131564693);
                    progressBar = progressBar2;
                    findViewById = ((View) this.f5715k.get(c)).findViewById(2131564691);
                } else {
                    findViewById = null;
                }
                this.f5708b.a(intent, progressBar, findViewById);
            }
        }
    }

    private MediaResource m5398c(MediaResource mediaResource) {
        MediaUploadKey b = MediaUploadKey.b(mediaResource);
        for (MediaResource mediaResource2 : this.f5715k.keySet()) {
            if (Objects.equal(b, MediaUploadKey.b(mediaResource2))) {
                return mediaResource2;
            }
        }
        return null;
    }
}
