package com.facebook.stickers.client;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.service.FetchStickerPacksByIdParams;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.stickers.service.FetchStickerPacksResult$Availability;
import com.facebook.stickers.service.FetchStickersParams;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.stickers.service.FetchStickersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: enable_on_all_classes */
public class StickerToPackMetadataLoader implements FbLoader<Params, Results, Throwable> {
    public static final Class<?> f16468a = StickerToPackMetadataLoader.class;
    public DefaultBlueServiceOperationFactory f16469b;
    public Executor f16470c;
    public StickerCache f16471d;
    public Callback<Params, Results, Throwable> f16472e;
    public FutureAndCallbackHolder f16473f;

    /* compiled from: enable_on_all_classes */
    public class Params {
        public final String f16465a;

        public Params(String str) {
            this.f16465a = str;
        }
    }

    /* compiled from: enable_on_all_classes */
    public class Results {
        public final StickerPack f16466a;
        public final FetchStickerPacksResult$Availability f16467b;

        public Results(StickerPack stickerPack, FetchStickerPacksResult$Availability fetchStickerPacksResult$Availability) {
            this.f16466a = stickerPack;
            this.f16467b = fetchStickerPacksResult$Availability;
        }
    }

    public static StickerToPackMetadataLoader m23942b(InjectorLike injectorLike) {
        return new StickerToPackMetadataLoader(StickerCache.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickerToPackMetadataLoader(StickerCache stickerCache, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        this.f16471d = stickerCache;
        this.f16469b = defaultBlueServiceOperationFactory;
        this.f16470c = executor;
    }

    public final void m23944a(Callback<Params, Results, Throwable> callback) {
        this.f16472e = callback;
    }

    public final void m23945a(final Params params) {
        if (this.f16472e != null) {
            Results results;
            Results results2;
            Callback callback;
            final SettableFuture f;
            Bundle bundle;
            ListenableFuture b;
            C11572 c11572;
            Sticker d = this.f16471d.d(params.f16465a);
            if (!(d == null || d.f4939b == null)) {
                StickerPack b2 = this.f16471d.b(d.f4939b);
                TriState c = this.f16471d.c(d.f4939b);
                if (b2 != null && c.isSet()) {
                    results = new Results(b2, c.asBoolean() ? FetchStickerPacksResult$Availability.DOWNLOADED : FetchStickerPacksResult$Availability.IN_STORE);
                    results2 = results;
                    if (results2 == null) {
                        this.f16472e.b(params, results2);
                    }
                    callback = this.f16472e;
                    f = SettableFuture.f();
                    bundle = new Bundle();
                    bundle.putParcelable("fetchStickersParams", new FetchStickersParams(ImmutableList.of(params.f16465a), StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED));
                    Tracer.b("fetchStickerAsync started");
                    b = Futures.b(BlueServiceOperationFactoryDetour.a(this.f16469b, "fetch_stickers", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 602674029).a(), new AsyncFunction<OperationResult, OperationResult>(this) {
                        final /* synthetic */ StickerToPackMetadataLoader f16461b;

                        public final ListenableFuture m23939a(Object obj) {
                            OperationResult operationResult = (OperationResult) obj;
                            Tracer.b("fetchStickerAsync done");
                            ImmutableList immutableList = ((FetchStickersResult) operationResult.h()).a;
                            int size = immutableList.size();
                            for (int i = 0; i < size; i++) {
                                if (((Sticker) immutableList.get(i)).f4938a.equals(params.f16465a)) {
                                    Parcelable fetchStickerPacksByIdParams = new FetchStickerPacksByIdParams(Lists.a(new String[]{((Sticker) immutableList.get(i)).f4939b}));
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("fetchStickerPacksByIdParams", fetchStickerPacksByIdParams);
                                    Tracer.b("fetchStickerPacksAsync started");
                                    return BlueServiceOperationFactoryDetour.a(this.f16461b.f16469b, "fetch_sticker_packs_by_id", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 513290894).a();
                                }
                            }
                            Tracer.b("fetchStickerAsync failed");
                            throw new RuntimeException("Sticker cannot be fetched.");
                        }
                    }, this.f16470c);
                    c11572 = new OperationResultFutureCallback(this) {
                        final /* synthetic */ StickerToPackMetadataLoader f16464c;

                        protected final void m23941a(Object obj) {
                            OperationResult operationResult = (OperationResult) obj;
                            this.f16464c.f16473f = null;
                            FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) operationResult.h();
                            StickerPack stickerPack = (StickerPack) ((ImmutableList) fetchStickerPacksResult.b.get()).get(0);
                            Results results = new Results(stickerPack, (FetchStickerPacksResult$Availability) fetchStickerPacksResult.a(stickerPack).get());
                            FutureDetour.a(f, results, 1652349303);
                            if (this.f16464c.f16472e != null) {
                                this.f16464c.f16472e.b(params, results);
                            }
                        }

                        protected final void m23940a(ServiceException serviceException) {
                            StickerToPackMetadataLoader stickerToPackMetadataLoader = this.f16464c;
                            Params params = params;
                            SettableFuture settableFuture = f;
                            BLog.b(StickerToPackMetadataLoader.f16468a, "fetchStickerPacksAsync failed", serviceException);
                            settableFuture.a(serviceException);
                            if (stickerToPackMetadataLoader.f16472e != null) {
                                stickerToPackMetadataLoader.f16472e.c(params, serviceException);
                            }
                        }
                    };
                    Futures.a(b, c11572, this.f16470c);
                    this.f16473f = FutureAndCallbackHolder.a(b, c11572);
                    callback.a(params, b);
                    return;
                }
            }
            results = null;
            results2 = results;
            if (results2 == null) {
                callback = this.f16472e;
                f = SettableFuture.f();
                bundle = new Bundle();
                bundle.putParcelable("fetchStickersParams", new FetchStickersParams(ImmutableList.of(params.f16465a), StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED));
                Tracer.b("fetchStickerAsync started");
                b = Futures.b(BlueServiceOperationFactoryDetour.a(this.f16469b, "fetch_stickers", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(getClass()), 602674029).a(), /* anonymous class already generated */, this.f16470c);
                c11572 = /* anonymous class already generated */;
                Futures.a(b, c11572, this.f16470c);
                this.f16473f = FutureAndCallbackHolder.a(b, c11572);
                callback.a(params, b);
                return;
            }
            this.f16472e.b(params, results2);
        }
    }

    public final void m23943a() {
        if (this.f16473f != null) {
            this.f16473f.a(true);
        }
    }
}
