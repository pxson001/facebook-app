package com.facebook.messaging.media.loader;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.service.LocalMediaLoadResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mCommercePaymentEligible */
public class LocalMediaLoader extends AbstractListenableFutureFbLoader<LocalMediaLoaderParams, ImmutableList<MediaResource>> {
    private static final Class<?> f11650a = LocalMediaLoader.class;
    private static final CallerContext f11651b = CallerContext.a(LocalMediaLoader.class);
    private final DefaultBlueServiceOperationFactory f11652c;
    private final Executor f11653d;
    private final AbstractFbErrorReporter f11654e;
    private final ExtractMediaResourcesFunction f11655f = new ExtractMediaResourcesFunction();

    /* compiled from: mCommercePaymentEligible */
    class ExtractMediaResourcesFunction implements Function<OperationResult, ImmutableList<MediaResource>> {
        @Nullable
        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return null;
            }
            return ((LocalMediaLoadResult) operationResult.h()).f11820a;
        }
    }

    public static LocalMediaLoader m12315b(InjectorLike injectorLike) {
        return new LocalMediaLoader(DefaultBlueServiceOperationFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected final /* synthetic */ ListenableFuture m12318a(Object obj, LoaderResult loaderResult) {
        return m12316b((LocalMediaLoaderParams) obj);
    }

    protected final /* synthetic */ LoaderResult m12319b(Object obj) {
        return AbstractListenableFutureFbLoader.a;
    }

    @Inject
    public LocalMediaLoader(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor, Executor executor2) {
        super(executor2);
        this.f11652c = defaultBlueServiceOperationFactory;
        this.f11654e = abstractFbErrorReporter;
        this.f11653d = executor;
    }

    public final ImmutableList<MediaResource> m12317a(LocalMediaLoaderParams localMediaLoaderParams) {
        AbstractListenableFutureFbLoader.e();
        try {
            return (ImmutableList) FutureDetour.a(m12316b(localMediaLoaderParams), 478137620);
        } catch (Throwable e) {
            this.f11654e.a(f11650a.getSimpleName(), e);
            return ImmutableList.of();
        }
    }

    private ListenableFuture<ImmutableList<MediaResource>> m12316b(LocalMediaLoaderParams localMediaLoaderParams) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("loadVideos", localMediaLoaderParams.f11656a);
        bundle.putInt("limit", localMediaLoaderParams.f11657b);
        return Futures.a(BlueServiceOperationFactoryDetour.a(this.f11652c, "load_local_media", bundle, ErrorPropagation.BY_EXCEPTION, f11651b, -910188818).a(), this.f11655f, this.f11653d);
    }
}
