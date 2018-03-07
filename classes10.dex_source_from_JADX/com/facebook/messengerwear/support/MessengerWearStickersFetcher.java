package com.facebook.messengerwear.support;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.client.FetchStickerCoordinator;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.ui.StickerUrls;
import com.facebook.ultralight.Inject;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

/* compiled from: photo_for_launcher_shortcut_size */
public class MessengerWearStickersFetcher {
    private static final Class f5074a = MessengerWearStickersFetcher.class;
    private static final CallerContext f5075b = CallerContext.a(MessengerWearStickersFetcher.class);
    @Inject
    private Provider<StickerCache> f5076c;
    @Inject
    private StickerUrls f5077d;
    @Inject
    private FetchStickerCoordinator f5078e;
    @BackgroundExecutorService
    @Inject
    private ExecutorService f5079f;
    @Inject
    private ImagePipeline f5080g;
    @Inject
    @ForUiThread
    private ExecutorService f5081h;
    @Inject
    private PlatformBitmapFactory f5082i;

    private static MessengerWearStickersFetcher m4562b(InjectorLike injectorLike) {
        MessengerWearStickersFetcher messengerWearStickersFetcher = new MessengerWearStickersFetcher();
        messengerWearStickersFetcher.m4561a(IdBasedProvider.a(injectorLike, 3445), StickerUrls.b(injectorLike), FetchStickerCoordinator.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
        return messengerWearStickersFetcher;
    }

    private void m4561a(Provider<StickerCache> provider, StickerUrls stickerUrls, FetchStickerCoordinator fetchStickerCoordinator, ExecutorService executorService, ImagePipeline imagePipeline, ExecutorService executorService2, PlatformBitmapFactory platformBitmapFactory) {
        this.f5076c = provider;
        this.f5077d = stickerUrls;
        this.f5078e = fetchStickerCoordinator;
        this.f5079f = executorService;
        this.f5080g = imagePipeline;
        this.f5081h = executorService2;
        this.f5082i = platformBitmapFactory;
    }
}
