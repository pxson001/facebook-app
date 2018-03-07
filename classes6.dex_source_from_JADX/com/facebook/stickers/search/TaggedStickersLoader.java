package com.facebook.stickers.search;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Assisted;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.service.FetchTaggedStickersParams;
import com.facebook.stickers.service.FetchTaggedStickersParams.FilterType;
import com.facebook.stickers.service.FetchTaggedStickersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: editReviewPrivacyParams */
public class TaggedStickersLoader extends AbstractListenableFutureFbLoader<Params, Results> {
    private static final CallerContext f16873a = CallerContext.a(TaggedStickersLoader.class);
    private final DefaultBlueServiceOperationFactory f16874b;
    private final StickerInterface f16875c;

    /* compiled from: editReviewPrivacyParams */
    public class Params {
        public final String f16871a;

        public Params(String str) {
            this.f16871a = str;
        }
    }

    /* compiled from: editReviewPrivacyParams */
    public class Results {
        public final ImmutableList<Sticker> f16872a;

        public Results(ImmutableList<Sticker> immutableList) {
            this.f16872a = immutableList;
        }
    }

    protected final ListenableFuture mo1286a(Object obj, LoaderResult loaderResult) {
        final Params params = (Params) obj;
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchTaggedStickerIdsParams", new FetchTaggedStickersParams(ImmutableList.of(params.f16871a), FilterType.AVAILABLE_STICKERS, this.f16875c));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f16874b, "fetch_tagged_sticker_ids", bundle, ErrorPropagation.BY_ERROR_CODE, f16873a, -1253330723).a(), new Function<OperationResult, Results>(this) {
            final /* synthetic */ TaggedStickersLoader f16870b;

            public Object apply(Object obj) {
                return new Results((ImmutableList) ((FetchTaggedStickersResult) ((OperationResult) obj).h()).f16907a.get(params.f16871a));
            }
        });
    }

    @Inject
    public TaggedStickersLoader(@Assisted StickerInterface stickerInterface, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        super(executor);
        this.f16875c = stickerInterface;
        this.f16874b = defaultBlueServiceOperationFactory;
    }

    protected final LoaderResult mo1287b(Object obj) {
        return AbstractListenableFutureFbLoader.f7745a;
    }
}
