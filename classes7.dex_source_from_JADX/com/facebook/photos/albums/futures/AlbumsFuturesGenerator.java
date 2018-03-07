package com.facebook.photos.albums.futures;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.albums.protocols.AlbumListQuery.AlbumListCanUploadOnlyQueryString;
import com.facebook.photos.albums.protocols.AlbumListQuery.AlbumListQueryString;
import com.facebook.photos.albums.protocols.AlbumListQuery.GroupAlbumListQueryString;
import com.facebook.photos.experiments.ExperimentsForPhotosExperimentsModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: magic_stories_kit_hide_asset */
public class AlbumsFuturesGenerator {
    private static AlbumsFuturesGenerator f9448g;
    private static final Object f9449h = new Object();
    private final Lazy<ExecutorService> f9450a;
    private final Lazy<GraphQLQueryExecutor> f9451b;
    private final Lazy<GraphQLImageHelper> f9452c;
    private final Lazy<AlbumsConverterFunction> f9453d;
    private final QeAccessor f9454e;
    private final GraphQLStoryHelper f9455f;

    private static AlbumsFuturesGenerator m11414b(InjectorLike injectorLike) {
        return new AlbumsFuturesGenerator(IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 2199), IdBasedSingletonScopeProvider.b(injectorLike, 9248), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GraphQLStoryHelper.a(injectorLike));
    }

    @Inject
    public AlbumsFuturesGenerator(Lazy<ExecutorService> lazy, Lazy<GraphQLQueryExecutor> lazy2, Lazy<GraphQLImageHelper> lazy3, Lazy<AlbumsConverterFunction> lazy4, QeAccessor qeAccessor, GraphQLStoryHelper graphQLStoryHelper) {
        this.f9450a = lazy;
        this.f9451b = lazy2;
        this.f9452c = lazy3;
        this.f9453d = lazy4;
        this.f9454e = qeAccessor;
        this.f9455f = graphQLStoryHelper;
    }

    public static AlbumsFuturesGenerator m11412a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumsFuturesGenerator b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9449h) {
                AlbumsFuturesGenerator albumsFuturesGenerator;
                if (a2 != null) {
                    albumsFuturesGenerator = (AlbumsFuturesGenerator) a2.a(f9449h);
                } else {
                    albumsFuturesGenerator = f9448g;
                }
                if (albumsFuturesGenerator == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11414b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9449h, b3);
                        } else {
                            f9448g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = albumsFuturesGenerator;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static Set<String> m11413a(String str) {
        return ImmutableSet.of("FetchPhotoAlbums" + str);
    }

    public final ListenableFuture<OperationResult> m11416a(String str, int i, GraphQLCachePolicy graphQLCachePolicy, @Nullable String str2, int i2) {
        return m11417a(str, i, graphQLCachePolicy, str2, i2, null);
    }

    public final ListenableFuture<OperationResult> m11417a(String str, int i, GraphQLCachePolicy graphQLCachePolicy, @Nullable String str2, int i2, @Nullable Set<String> set) {
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        GraphQLRequest a = GraphQLRequest.a((AlbumListQueryString) m11411a(new AlbumListQueryString(), str, i, str2, i2)).a(graphQLCachePolicy);
        if (set != null) {
            a.e = set;
        }
        return Futures.a(((GraphQLQueryExecutor) this.f9451b.get()).a(a), (Function) this.f9453d.get(), (Executor) this.f9450a.get());
    }

    public final ListenableFuture<OperationResult> m11415a(String str, int i) {
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        return Futures.a(((GraphQLQueryExecutor) this.f9451b.get()).a(GraphQLRequest.a(new AlbumListCanUploadOnlyQueryString()).a(GraphQLCachePolicy.d).a(((AlbumListCanUploadOnlyQueryString) m11410a(new AlbumListCanUploadOnlyQueryString(), str, i)).a)), (Function) this.f9453d.get(), (Executor) this.f9450a.get());
    }

    public final ListenableFuture<OperationResult> m11418b(String str, int i) {
        Preconditions.checkState(!Strings.isNullOrEmpty(str));
        return Futures.a(((GraphQLQueryExecutor) this.f9451b.get()).a(GraphQLRequest.a((GroupAlbumListQueryString) m11410a(new GroupAlbumListQueryString(), str, i)).a(GraphQLCachePolicy.d)), (Function) this.f9453d.get(), (Executor) this.f9450a.get());
    }

    private GraphQlQueryString m11410a(GraphQlQueryString graphQlQueryString, String str, int i) {
        return m11411a(graphQlQueryString, str, i, null, 100);
    }

    private GraphQlQueryString m11411a(GraphQlQueryString graphQlQueryString, String str, int i, @Nullable String str2, int i2) {
        graphQlQueryString.a("node_id", str);
        graphQlQueryString.a("first", Integer.valueOf(i2));
        if (str2 != null) {
            graphQlQueryString.a("after", str2);
        }
        this.f9452c.get();
        graphQlQueryString.a("image_width", String.valueOf(GraphQLImageHelper.a(i)));
        this.f9452c.get();
        graphQlQueryString.a("image_height", String.valueOf(GraphQLImageHelper.a(i)));
        graphQlQueryString.a("media_type", ((GraphQLImageHelper) this.f9452c.get()).a());
        graphQlQueryString.a("enable_album_feedback", Boolean.valueOf(this.f9454e.a(ExperimentsForPhotosExperimentsModule.a, false)));
        graphQlQueryString.a("profile_image_size", GraphQLStoryHelper.a());
        graphQlQueryString.a("max_comments", Integer.valueOf(25));
        graphQlQueryString.a("fetch_reshare_counts", Boolean.valueOf(this.f9454e.a(ExperimentsForFeedbackTestModule.T, false)));
        return graphQlQueryString;
    }
}
