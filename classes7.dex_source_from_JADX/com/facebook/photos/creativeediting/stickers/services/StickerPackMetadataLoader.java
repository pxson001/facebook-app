package com.facebook.photos.creativeediting.stickers.services;

import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collection;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: mPromptAnalytics */
public class StickerPackMetadataLoader implements FbLoader<Params, Results, Throwable> {
    public DefaultBlueServiceOperationFactory f9617a;
    public ViewerContextManager f9618b;
    private Executor f9619c;
    public StickerCache f9620d;
    public Callback<Params, Results, Throwable> f9621e;

    /* compiled from: mPromptAnalytics */
    public class Params {
        public final boolean f9615a;

        public Params(boolean z) {
            this.f9615a = z;
        }
    }

    /* compiled from: mPromptAnalytics */
    public class Results {
        public final ImmutableList<StickerPack> f9616a;

        public Results(ImmutableList<StickerPack> immutableList) {
            this.f9616a = immutableList;
        }
    }

    @Inject
    public StickerPackMetadataLoader(StickerCache stickerCache, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ViewerContextManager viewerContextManager, Executor executor) {
        this.f9620d = stickerCache;
        this.f9617a = defaultBlueServiceOperationFactory;
        this.f9618b = viewerContextManager;
        this.f9619c = executor;
    }

    public final void m11545a(Callback<Params, Results, Throwable> callback) {
        this.f9621e = callback;
    }

    public final void m11546a(Params params) {
        Object obj = null;
        Collection b = Lists.b();
        if (this.f9620d.a(StickerPackType.DOWNLOADED_PACKS)) {
            ImmutableList b2 = this.f9620d.b(StickerPackType.DOWNLOADED_PACKS);
            int size = b2.size();
            for (int i = 0; i < size; i++) {
                StickerPack stickerPack = (StickerPack) b2.get(i);
                if (stickerPack.n) {
                    b.add(stickerPack);
                }
            }
        }
        ImmutableList copyOf = ImmutableList.copyOf(b);
        if (this.f9621e != null) {
            if (copyOf == null || copyOf.size() <= 0 || params.f9615a) {
                obj = 1;
            } else {
                Lists.a().addAll(copyOf);
            }
            if (obj == null) {
                this.f9621e.b(params, new Results(copyOf));
            } else {
                this.f9621e.a(params, m11544b(params));
            }
        }
    }

    private ListenableFuture<Results> m11544b(final Params params) {
        DataFreshnessParam dataFreshnessParam;
        final SettableFuture f = SettableFuture.f();
        StickerPackType stickerPackType = StickerPackType.DOWNLOADED_PACKS;
        if (params.f9615a) {
            dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        } else {
            dataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
        }
        Builder builder = new Builder(stickerPackType, dataFreshnessParam);
        builder.c = InterfaceInputInterface.COMPOSER;
        FetchStickerPacksParams a = builder.a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a);
        bundle.putParcelable("overridden_viewer_context", this.f9618b.a());
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f9617a, "fetch_sticker_packs", bundle, 1754025181).a(), new FutureCallback<OperationResult>(this) {
            final /* synthetic */ StickerPackMetadataLoader f9614c;

            public void onSuccess(Object obj) {
                FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) ((OperationResult) obj).h();
                Collection b = Lists.b();
                if (fetchStickerPacksResult.b.isPresent()) {
                    ImmutableList immutableList = (ImmutableList) fetchStickerPacksResult.b.get();
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        StickerPack stickerPack = (StickerPack) immutableList.get(i);
                        if (stickerPack.n) {
                            b.add(stickerPack);
                        }
                    }
                }
                Results results = new Results(ImmutableList.copyOf(b));
                this.f9614c.f9621e.b(params, results);
                FutureDetour.a(f, results, -1646238046);
            }

            public void onFailure(Throwable th) {
                f.a(th);
                this.f9614c.f9621e.c(params, th);
            }
        }, this.f9619c);
        return f;
    }
}
