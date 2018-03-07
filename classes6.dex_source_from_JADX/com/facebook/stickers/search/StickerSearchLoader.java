package com.facebook.stickers.search;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerInterfaceTranslator;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.service.StickerSearchParams;
import com.facebook.stickers.service.StickerSearchResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: edit_gallery_ipc_bundle_extra_key */
public class StickerSearchLoader extends AbstractListenableFutureFbLoader<Params, Results> {
    private static final CallerContext f16860a = CallerContext.a(StickerSearchLoader.class);
    private final DefaultBlueServiceOperationFactory f16861b;
    private final Executor f16862c;

    /* compiled from: edit_gallery_ipc_bundle_extra_key */
    class C11961 implements Function<OperationResult, Results> {
        final /* synthetic */ StickerSearchLoader f16856a;

        C11961(StickerSearchLoader stickerSearchLoader) {
            this.f16856a = stickerSearchLoader;
        }

        public Object apply(Object obj) {
            return new Results(((StickerSearchResult) ((OperationResult) obj).h()).f16923a);
        }
    }

    /* compiled from: edit_gallery_ipc_bundle_extra_key */
    public class Params {
        public final String f16857a;
        public final StickerInterface f16858b;

        public Params(String str, StickerInterface stickerInterface) {
            this.f16857a = str;
            this.f16858b = stickerInterface;
        }
    }

    /* compiled from: edit_gallery_ipc_bundle_extra_key */
    public class Results {
        public final ImmutableList<Sticker> f16859a;

        public Results(ImmutableList<Sticker> immutableList) {
            this.f16859a = immutableList;
        }
    }

    public static StickerSearchLoader m24595b(InjectorLike injectorLike) {
        return new StickerSearchLoader(DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected final ListenableFuture mo1286a(Object obj, LoaderResult loaderResult) {
        Params params = (Params) obj;
        Bundle bundle = new Bundle();
        bundle.putParcelable("stickerSearchParams", new StickerSearchParams(params.f16857a, StickerInterfaceTranslator.m23958a(params.f16858b)));
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f16861b, "sticker_search", bundle, ErrorPropagation.BY_EXCEPTION, f16860a, 1564806055).a(), new C11961(this), this.f16862c);
    }

    @Inject
    public StickerSearchLoader(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Executor executor) {
        super(executor);
        this.f16861b = defaultBlueServiceOperationFactory;
        this.f16862c = executor;
    }

    protected final LoaderResult mo1287b(Object obj) {
        return AbstractListenableFutureFbLoader.f7745a;
    }
}
