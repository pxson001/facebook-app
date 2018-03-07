package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.photos.creativeediting.swipeable.prompt.PromptsFramePackProvider;
import com.facebook.productionprompts.common.ProductionPromptsQueryFetchingHelper;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FramePackProvider implements MultiBindIndexedProvider<FramePackProvider>, Provider<Set<FramePackProvider>> {
    private final InjectorLike f13296a;

    public STATICDI_MULTIBIND_PROVIDER$FramePackProvider(InjectorLike injectorLike) {
        this.f13296a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f13296a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DefaultFramePackFetcher(GraphQLQueryExecutor.m10435a((InjectorLike) injector), C0055x2995691a.m1881a(injector), QeInternalImplMethodAutoProvider.m3744a(injector), FrameAssetsLoader.a(injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new PromptsFramePackProvider(ProductionPromptsQueryFetchingHelper.m18758b((InjectorLike) injector), GraphQLQueryExecutor.m10435a((InjectorLike) injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
