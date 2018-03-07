package com.facebook.stickers.search;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.StickerTag;
import com.facebook.stickers.service.FetchStickerTagsParams;
import com.facebook.stickers.service.FetchStickerTagsParams.TagType;
import com.facebook.stickers.service.FetchStickerTagsResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: edit_comment_ */
public class StickerTagsLoader extends AbstractListenableFutureFbLoader<Params, Results> {
    private static final CallerContext f16866a = CallerContext.a(StickerTagsLoader.class);
    private final StickerCache f16867b;
    private final DefaultBlueServiceOperationFactory f16868c;

    /* compiled from: edit_comment_ */
    class C11971 implements Function<OperationResult, Results> {
        final /* synthetic */ StickerTagsLoader f16863a;

        C11971(StickerTagsLoader stickerTagsLoader) {
            this.f16863a = stickerTagsLoader;
        }

        public Object apply(Object obj) {
            return new Results(((FetchStickerTagsResult) ((OperationResult) obj).h()).f16902a);
        }
    }

    /* compiled from: edit_comment_ */
    public class Params {
        public final TagType f16864a;

        public Params(TagType tagType) {
            this.f16864a = tagType;
        }
    }

    /* compiled from: edit_comment_ */
    public class Results {
        public final ImmutableList<StickerTag> f16865a;

        public Results(ImmutableList<StickerTag> immutableList) {
            this.f16865a = immutableList;
        }
    }

    public static StickerTagsLoader m24598b(InjectorLike injectorLike) {
        return new StickerTagsLoader(StickerCache.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected final ListenableFuture mo1286a(Object obj, LoaderResult loaderResult) {
        Params params = (Params) obj;
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerTagsParam", new FetchStickerTagsParams(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, params.f16864a));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f16868c, "fetch_sticker_tags", bundle, ErrorPropagation.BY_EXCEPTION, f16866a, 1467805134).a(), new C11971(this));
    }

    @Inject
    public StickerTagsLoader(StickerCache stickerCache, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        super(executor);
        this.f16867b = stickerCache;
        this.f16868c = defaultBlueServiceOperationFactory;
    }

    protected final LoaderResult mo1287b(Object obj) {
        ImmutableList g = this.f16867b.g();
        return g != null ? LoaderResult.m11050b(new Results(g)) : AbstractListenableFutureFbLoader.f7745a;
    }
}
