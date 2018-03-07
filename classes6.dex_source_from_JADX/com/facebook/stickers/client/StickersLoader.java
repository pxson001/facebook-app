package com.facebook.stickers.client;

import android.os.Bundle;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.service.FetchStickersParams;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.stickers.service.FetchStickersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: enable_delta_update */
public class StickersLoader implements FbLoader<Params, Results, Throwable> {
    private static final Class<?> f16478a = StickersLoader.class;
    private final StickerCache f16479b;
    private final DefaultBlueServiceOperationFactory f16480c;
    private final Executor f16481d;
    public Callback<Params, Results, Throwable> f16482e;
    private FutureAndCallbackHolder f16483f;

    /* compiled from: enable_delta_update */
    public class Params {
        public final List<String> f16476a;

        public Params(List<String> list) {
            this.f16476a = list;
        }
    }

    /* compiled from: enable_delta_update */
    public class Results {
        public final List<Sticker> f16477a;

        public Results(List<Sticker> list) {
            this.f16477a = list;
        }
    }

    public static StickersLoader m23949b(InjectorLike injectorLike) {
        return new StickersLoader(StickerCache.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickersLoader(StickerCache stickerCache, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        this.f16479b = stickerCache;
        this.f16480c = defaultBlueServiceOperationFactory;
        this.f16481d = executor;
    }

    public final void m23951a(Callback<Params, Results, Throwable> callback) {
        this.f16482e = callback;
    }

    public final void m23952a(final Params params) {
        ImmutableList a = this.f16479b.a(params.f16476a);
        if (a.size() != params.f16476a.size()) {
            FetchStickersParams fetchStickersParams = new FetchStickersParams(params.f16476a, StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED);
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchStickersParams", fetchStickersParams);
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a(this.f16480c, "fetch_stickers", bundle, 1545785954).a();
            C11581 c11581 = new AbstractDisposableFutureCallback<OperationResult>(this) {
                final /* synthetic */ StickersLoader f16475b;

                protected final void m23947a(Object obj) {
                    FetchStickersResult fetchStickersResult = (FetchStickersResult) ((OperationResult) obj).h();
                    if (this.f16475b.f16482e != null) {
                        this.f16475b.f16482e.b(params, new Results(fetchStickersResult.a));
                    }
                }

                protected final void m23948a(Throwable th) {
                    if (this.f16475b.f16482e != null) {
                        this.f16475b.f16482e.c(params, th);
                    }
                }
            };
            if (this.f16482e != null) {
                this.f16482e.a(params, a2);
            }
            Futures.a(a2, c11581, this.f16481d);
            this.f16483f = FutureAndCallbackHolder.a(a2, c11581);
        } else if (this.f16482e != null) {
            this.f16482e.b(params, new Results(a));
        }
    }

    public final void m23950a() {
        if (this.f16483f != null) {
            this.f16483f.a(true);
        }
    }
}
