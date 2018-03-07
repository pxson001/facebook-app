package com.facebook.messaging.media.prefetch;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.AudioAttachmentData;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.audio.playback.FetchAudioExecutor;
import com.facebook.messaging.audio.playback.FetchAudioParams;
import com.facebook.messaging.media.retry.ExperimentsForMediaRetryModule;
import com.facebook.messaging.media.retry.MediaRetryQueue;
import com.facebook.messaging.model.messages.Message;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.service.FetchStickersParams;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.stickers.service.FetchStickersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: search_button_tapped */
public class MediaPrefetchHandler {
    public static final Class<?> f3186i = MediaPrefetchHandler.class;
    @Inject
    public AttachmentDataFactory f3187a;
    @Inject
    public FbNetworkManager f3188b;
    @Inject
    FetchAudioExecutor f3189c;
    @Inject
    ImagePipeline f3190d;
    @ForNonUiThread
    @Inject
    ExecutorService f3191e;
    @Inject
    public QeAccessor f3192f;
    @Inject
    DefaultBlueServiceOperationFactory f3193g;
    @Inject
    StickerCache f3194h;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaRetryQueue> f3195j = UltralightRuntime.b;

    public static MediaPrefetchHandler m3132b(InjectorLike injectorLike) {
        MediaPrefetchHandler mediaPrefetchHandler = new MediaPrefetchHandler();
        mediaPrefetchHandler.m3130a(AttachmentDataFactory.a(injectorLike), FbNetworkManager.a(injectorLike), FetchAudioExecutor.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), StickerCache.a(injectorLike), IdBasedLazy.a(injectorLike, 7924));
        return mediaPrefetchHandler;
    }

    private void m3130a(AttachmentDataFactory attachmentDataFactory, FbNetworkManager fbNetworkManager, FetchAudioExecutor fetchAudioExecutor, ImagePipeline imagePipeline, ExecutorService executorService, QeAccessor qeAccessor, BlueServiceOperationFactory blueServiceOperationFactory, StickerCache stickerCache, com.facebook.inject.Lazy<MediaRetryQueue> lazy) {
        this.f3187a = attachmentDataFactory;
        this.f3188b = fbNetworkManager;
        this.f3189c = fetchAudioExecutor;
        this.f3190d = imagePipeline;
        this.f3191e = executorService;
        this.f3192f = qeAccessor;
        this.f3193g = blueServiceOperationFactory;
        this.f3194h = stickerCache;
        this.f3195j = lazy;
    }

    public final void m3135a(Message message) {
        if (this.f3187a.a(message) && this.f3192f.a(Liveness.Cached, ExperimentsForMediaPrefetchModule.f3175c, false)) {
            int b = this.f3187a.b(message);
            ImmutableList f = this.f3187a.f(message);
            CallerContext a = CallerContext.a(MediaPrefetchHandler.class, "media_prefetch", "image_prefetch");
            int size = f.size();
            for (int i = 0; i < size; i++) {
                ImageAttachmentData imageAttachmentData = (ImageAttachmentData) f.get(i);
                m3131a(this, ThreadViewImageUriGetter.m3136a(b, imageAttachmentData.a), a);
                if (this.f3187a.c(message) && this.f3192f.a(Liveness.Cached, ExperimentsForMediaPrefetchModule.f3173a, false)) {
                    m3131a(this, ThreadViewImageUriGetter.m3136a(b, imageAttachmentData.b), a);
                }
            }
        }
        if (this.f3187a.e(message) && this.f3192f.a(Liveness.Cached, ExperimentsForMediaPrefetchModule.f3178f, false)) {
            m3131a(this, this.f3187a.j(message).g, CallerContext.a(MediaPrefetchHandler.class, "media_prefetch", "video_cover_prefetch"));
        }
        m3133d(message);
        m3134e(message);
    }

    private void m3133d(Message message) {
        if (!StringUtil.a(message.k) && this.f3194h.d(message.k) == null && this.f3192f.a(Liveness.Cached, ExperimentsForMediaPrefetchModule.f3176d, false)) {
            final CallerContext a = CallerContext.a(MediaPrefetchHandler.class, "media_prefetch", "sticker_prefetch");
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchStickersParams", new FetchStickersParams(new ArrayList(Arrays.asList(new String[]{message.k})), StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED));
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f3193g, "fetch_stickers", bundle, ErrorPropagation.BY_ERROR_CODE, a, -997501227).a(), new OperationResultFutureCallback(this) {
                final /* synthetic */ MediaPrefetchHandler f3180b;

                protected final void m3127a(Object obj) {
                    ImmutableList immutableList = ((FetchStickersResult) ((OperationResult) obj).h()).a;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        Sticker sticker = (Sticker) immutableList.get(i);
                        if (sticker.e != null) {
                            MediaPrefetchHandler.m3131a(this.f3180b, sticker.e, a);
                        } else if (sticker.c != null) {
                            MediaPrefetchHandler.m3131a(this.f3180b, sticker.c, a);
                        }
                    }
                }

                protected final void m3126a(ServiceException serviceException) {
                    BLog.b(MediaPrefetchHandler.f3186i, "Error prefetching stickers.", serviceException);
                }
            }, this.f3191e);
        }
    }

    private void m3134e(Message message) {
        AudioAttachmentData g = this.f3187a.g(message);
        if (g != null && this.f3192f.a(Liveness.Cached, ExperimentsForMediaPrefetchModule.f3174b, false)) {
            Uri uri = g.b;
            if (uri != null) {
                this.f3189c.a(new FetchAudioParams(uri));
            }
        }
    }

    public static void m3131a(MediaPrefetchHandler mediaPrefetchHandler, final Uri uri, final CallerContext callerContext) {
        if (UriUtil.a(uri)) {
            boolean d;
            if (mediaPrefetchHandler.f3192f.a(Liveness.Cached, ExperimentsForMediaPrefetchModule.f3177e, false)) {
                d = mediaPrefetchHandler.f3188b.d();
            } else {
                d = true;
            }
            if (d || !((MediaRetryQueue) mediaPrefetchHandler.f3195j.get()).m3148b()) {
                ExecutorDetour.a(mediaPrefetchHandler.f3191e, new Runnable(mediaPrefetchHandler) {
                    final /* synthetic */ MediaPrefetchHandler f3185c;

                    public void run() {
                        final ImageRequest a = ImageRequest.a(uri);
                        this.f3185c.f3190d.f(a, callerContext).a(new BaseDataSubscriber<Void>(this) {
                            final /* synthetic */ C05172 f3182b;

                            protected final void m3128e(DataSource<Void> dataSource) {
                            }

                            protected final void m3129f(DataSource<Void> dataSource) {
                                if (this.f3182b.f3185c.f3192f.a(Liveness.Cached, ExperimentsForMediaRetryModule.f3197b, false)) {
                                    ((MediaRetryQueue) this.f3182b.f3185c.f3195j.get()).m3147a(a);
                                }
                            }
                        }, this.f3185c.f3191e);
                    }
                }, 614239251);
            } else {
                ((MediaRetryQueue) mediaPrefetchHandler.f3195j.get()).m3147a(ImageRequest.a(uri));
            }
        }
    }
}
