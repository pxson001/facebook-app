package com.facebook.stickers.search;

import android.os.Bundle;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerInterfaceTranslator;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: editPost */
public class TrayStickerIdsLoader extends AbstractListenableFutureFbLoader<StickerInterface, Results> {
    private static final CallerContext f16878a = CallerContext.a(TrayStickerIdsLoader.class);
    public final ViewerContextManager f16879b;
    private final DefaultBlueServiceOperationFactory f16880c;

    /* compiled from: editPost */
    class C11991 implements Function<OperationResult, Results> {
        final /* synthetic */ TrayStickerIdsLoader f16876a;

        C11991(TrayStickerIdsLoader trayStickerIdsLoader) {
            this.f16876a = trayStickerIdsLoader;
        }

        public Object apply(Object obj) {
            FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) ((OperationResult) obj).h();
            Collection a = Lists.a();
            if (fetchStickerPacksResult.b.isPresent()) {
                ImmutableList immutableList = (ImmutableList) fetchStickerPacksResult.b.get();
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    a.addAll(((StickerPack) immutableList.get(i)).f4974t);
                }
                return new Results(ImmutableList.copyOf(a));
            }
            throw new RuntimeException("sticker db not initialized, try again later.");
        }
    }

    /* compiled from: editPost */
    public class Results {
        public final ImmutableList<String> f16877a;

        public Results(ImmutableList<String> immutableList) {
            this.f16877a = immutableList;
        }
    }

    public static TrayStickerIdsLoader m24604b(InjectorLike injectorLike) {
        return new TrayStickerIdsLoader(ViewerContextManagerProvider.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected final ListenableFuture mo1286a(Object obj, LoaderResult loaderResult) {
        StickerInterface stickerInterface = (StickerInterface) obj;
        Builder builder = new Builder(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.DO_NOT_CHECK_SERVER);
        builder.c = StickerInterfaceTranslator.m23958a(stickerInterface);
        FetchStickerPacksParams a = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a);
        bundle.putParcelable("overridden_viewer_context", this.f16879b.a());
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f16880c, "fetch_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, f16878a, 465613341).a(), new C11991(this));
    }

    @Inject
    public TrayStickerIdsLoader(ViewerContextManager viewerContextManager, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        super(executor);
        this.f16879b = viewerContextManager;
        this.f16880c = defaultBlueServiceOperationFactory;
    }

    protected final LoaderResult mo1287b(Object obj) {
        return AbstractListenableFutureFbLoader.f7745a;
    }
}
