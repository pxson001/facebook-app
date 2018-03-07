package com.facebook.photos.pandora.common.futures;

import android.content.Context;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache.MemoryCacheEntryKey;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.futures.PandoraFutures.PandoraFunction;
import com.facebook.photos.pandora.common.futures.functions.PandoraMemoryCacheFunction;
import com.facebook.photos.pandora.common.futures.functions.PandoraRendererFunction;
import com.facebook.photos.pandora.common.futures.functions.PandoraRendererFunction.ParamWrapper;
import com.facebook.photos.pandora.common.futures.functions.PandoraResultConverterFunction;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.protocols.PandoraQuery.PandoraAlbumQueryString;
import com.facebook.photos.pandora.protocols.PandoraQuery.PandoraTaggedMediasetQueryString;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: commercial_break_skywalker_subscription_failure */
public class PandoraFuturesGenerator {
    private static PandoraFuturesGenerator f17382h;
    private static final Object f17383i = new Object();
    private final Lazy<ExecutorService> f17384a;
    public final Lazy<GraphQLQueryExecutor> f17385b;
    private final Lazy<PandoraResultConverterFunction> f17386c;
    private final Lazy<PandoraRendererFunction> f17387d;
    private final Lazy<PandoraMemoryCacheFunction> f17388e;
    private final Lazy<PandoraGraphQLParamImageHelper> f17389f;
    private final Lazy<AutomaticPhotoCaptioningUtils> f17390g;

    private static PandoraFuturesGenerator m21381b(InjectorLike injectorLike) {
        return new PandoraFuturesGenerator(IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 9380), IdBasedSingletonScopeProvider.b(injectorLike, 9379), IdBasedSingletonScopeProvider.b(injectorLike, 9378), IdBasedSingletonScopeProvider.b(injectorLike, 9377), IdBasedLazy.a(injectorLike, 99));
    }

    @Inject
    public PandoraFuturesGenerator(Lazy<ExecutorService> lazy, Lazy<GraphQLQueryExecutor> lazy2, Lazy<PandoraResultConverterFunction> lazy3, Lazy<PandoraRendererFunction> lazy4, Lazy<PandoraMemoryCacheFunction> lazy5, Lazy<PandoraGraphQLParamImageHelper> lazy6, Lazy<AutomaticPhotoCaptioningUtils> lazy7) {
        this.f17384a = lazy;
        this.f17385b = lazy2;
        this.f17386c = lazy3;
        this.f17387d = lazy4;
        this.f17388e = lazy5;
        this.f17389f = lazy6;
        this.f17390g = lazy7;
    }

    public static PandoraFuturesGenerator m21380a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PandoraFuturesGenerator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17383i) {
                PandoraFuturesGenerator pandoraFuturesGenerator;
                if (a2 != null) {
                    pandoraFuturesGenerator = (PandoraFuturesGenerator) a2.a(f17383i);
                } else {
                    pandoraFuturesGenerator = f17382h;
                }
                if (pandoraFuturesGenerator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m21381b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17383i, b3);
                        } else {
                            f17382h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pandoraFuturesGenerator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ListenableFuture<OperationResult> m21382a(PandoraPhotoCollageFetchPhotosFutureGenerator pandoraPhotoCollageFetchPhotosFutureGenerator, PandoraInstanceId pandoraInstanceId, PandoraRendererConfiguration pandoraRendererConfiguration, @Nullable String str, @Nullable String str2, int i, MemoryCacheEntryKey memoryCacheEntryKey, boolean z) {
        return PandoraFutures.m21379a(PandoraFutures.m21379a(pandoraPhotoCollageFetchPhotosFutureGenerator.mo903a(str, str2, pandoraInstanceId, i, z), (PandoraFunction) this.f17388e.get(), memoryCacheEntryKey, (Executor) this.f17384a.get()), (PandoraFunction) this.f17387d.get(), new ParamWrapper(pandoraInstanceId, PandoraRequestSource.UPLOADED_MEDIA_SET, pandoraRendererConfiguration), (Executor) this.f17384a.get());
    }

    public final ListenableFuture<OperationResult> m21383a(String str, PandoraInstanceId pandoraInstanceId, @Nullable String str2, @Nullable String str3, int i, MemoryCacheEntryKey memoryCacheEntryKey) {
        GraphQlQueryString pandoraTaggedMediasetQueryString = new PandoraTaggedMediasetQueryString();
        pandoraTaggedMediasetQueryString.a("node_id", str);
        pandoraTaggedMediasetQueryString.a("count", String.valueOf(i));
        pandoraTaggedMediasetQueryString.a("automatic_photo_captioning_enabled", Boolean.toString(((AutomaticPhotoCaptioningUtils) this.f17390g.get()).a()));
        if (!Strings.isNullOrEmpty(str2)) {
            pandoraTaggedMediasetQueryString.a("before", str2);
        }
        if (!Strings.isNullOrEmpty(str3)) {
            pandoraTaggedMediasetQueryString.a("after", str3);
        }
        PandoraGraphQLParamImageHelper pandoraGraphQLParamImageHelper = (PandoraGraphQLParamImageHelper) this.f17389f.get();
        ((SizeAwareImageUtil) pandoraGraphQLParamImageHelper.f17403c.get()).a(pandoraTaggedMediasetQueryString);
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraGraphQLParamImageHelper.f17402b.get();
        pandoraTaggedMediasetQueryString.a("image_thumbnail_width", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17391d))).a("image_large_thumbnail_width", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17392e))).a("image_portrait_width", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17393f))).a("image_portrait_height", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17394g))).a("image_landscape_width", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17395h))).a("image_landscape_height", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17396i))).a("large_portrait_height", String.valueOf(GraphQLImageHelper.a(PandoraGraphQLParamImageHelper.f17397j))).a("media_type", ((GraphQLImageHelper) pandoraGraphQLParamImageHelper.f17402b.get()).a());
        return PandoraFutures.m21379a(PandoraFutures.m21379a(Futures.a(((GraphQLQueryExecutor) this.f17385b.get()).a(GraphQLRequest.a(pandoraTaggedMediasetQueryString).a(GraphQLCachePolicy.c).a(RequestPriority.INTERACTIVE)), (Function) this.f17386c.get(), (Executor) this.f17384a.get()), (PandoraFunction) this.f17388e.get(), memoryCacheEntryKey, (Executor) this.f17384a.get()), (PandoraFunction) this.f17387d.get(), new ParamWrapper(pandoraInstanceId, PandoraRequestSource.TAGGED_MEDIA_SET), (Executor) this.f17384a.get());
    }

    public final ListenableFuture<OperationResult> m21384a(String str, PandoraInstanceId pandoraInstanceId, String str2, String str3, int i, MemoryCacheEntryKey memoryCacheEntryKey, PandoraRendererConfiguration pandoraRendererConfiguration) {
        GraphQlQueryString pandoraAlbumQueryString = new PandoraAlbumQueryString();
        pandoraAlbumQueryString.a("node_id", str);
        pandoraAlbumQueryString.a("count", String.valueOf(i));
        pandoraAlbumQueryString.a("automatic_photo_captioning_enabled", Boolean.toString(((AutomaticPhotoCaptioningUtils) this.f17390g.get()).a()));
        if (!Strings.isNullOrEmpty(str2)) {
            pandoraAlbumQueryString.a("before", str2);
        }
        if (!Strings.isNullOrEmpty(str3)) {
            pandoraAlbumQueryString.a("after", str3);
        }
        ((PandoraGraphQLParamImageHelper) this.f17389f.get()).m21387a(pandoraAlbumQueryString);
        return PandoraFutures.m21379a(PandoraFutures.m21379a(Futures.a(((GraphQLQueryExecutor) this.f17385b.get()).a(GraphQLRequest.a(pandoraAlbumQueryString).a(GraphQLCachePolicy.c)), (Function) this.f17386c.get(), (Executor) this.f17384a.get()), (PandoraFunction) this.f17388e.get(), memoryCacheEntryKey, (Executor) this.f17384a.get()), (PandoraFunction) this.f17387d.get(), new ParamWrapper(pandoraInstanceId, PandoraRequestSource.ALBUM_MEDIA_SET, pandoraRendererConfiguration), (Executor) this.f17384a.get());
    }
}
