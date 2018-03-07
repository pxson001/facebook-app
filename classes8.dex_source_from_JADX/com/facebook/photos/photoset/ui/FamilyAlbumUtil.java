package com.facebook.photos.photoset.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMediaSetMediaConnection;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.albums.protocols.AlbumListQuery.FBFamilyNonUserMemberAlbumsQueryString;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.FBFamilyNonUserMemberAlbumsQueryModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.FBFamilyNonUserMemberAlbumsQueryModel.FamilyNonUserMembersModel.EdgesModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.FBFamilyNonUserMemberAlbumsQueryModel.FamilyNonUserMembersModel.EdgesModel.NodeModel.FamilyTaggedMediasetModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.FBFamilyNonUserMemberAlbumsQueryModel.FamilyNonUserMembersModel.EdgesModel.NodeModel.FamilyTaggedMediasetModel.MediaModel.MediaEdgesModel;
import com.facebook.photos.albums.protocols.AlbumListQueryModels.FBFamilyNonUserMemberAlbumsQueryModel.FamilyNonUserMembersModel.EdgesModel.NodeModel.FamilyTaggedMediasetModel.MediaModel.MediaEdgesModel.MediaEdgesNodeModel;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: cold */
public class FamilyAlbumUtil {
    private final SizeAwareImageUtil f17796a;
    public final Provider<Boolean> f17797b;
    public final Provider<String> f17798c;
    public Lazy<FbErrorReporter> f17799d;
    private Lazy<GraphQLQueryExecutor> f17800e;

    /* compiled from: cold */
    class C19072 implements FutureCallback<GraphQLAlbumsConnection> {
        final /* synthetic */ FamilyAlbumUtil f17795a;

        C19072(FamilyAlbumUtil familyAlbumUtil) {
            this.f17795a = familyAlbumUtil;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            ((AbstractFbErrorReporter) this.f17795a.f17799d.get()).a("fetchFamilyAlbum", th);
        }
    }

    public static FamilyAlbumUtil m21775b(InjectorLike injectorLike) {
        return new FamilyAlbumUtil(IdBasedLazy.a(injectorLike, 2164), SizeAwareImageUtil.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedProvider.a(injectorLike, 4253), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public FamilyAlbumUtil(Lazy<GraphQLQueryExecutor> lazy, SizeAwareImageUtil sizeAwareImageUtil, Lazy<FbErrorReporter> lazy2, Provider<Boolean> provider, Provider<String> provider2) {
        this.f17800e = lazy;
        this.f17796a = sizeAwareImageUtil;
        this.f17799d = lazy2;
        this.f17797b = provider;
        this.f17798c = provider2;
    }

    public final ListenableFuture<GraphQLAlbumsConnection> m21776a(int i, int i2, GraphQLCachePolicy graphQLCachePolicy, final Long l) {
        GraphQlQueryString fBFamilyNonUserMemberAlbumsQueryString = new FBFamilyNonUserMemberAlbumsQueryString();
        fBFamilyNonUserMemberAlbumsQueryString.a("targetId", Long.toString(l.longValue())).a("image_width", Integer.toString(i)).a("image_height", Integer.toString(i2));
        this.f17796a.a(fBFamilyNonUserMemberAlbumsQueryString);
        ListenableFuture<GraphQLAlbumsConnection> a = Futures.a(((GraphQLQueryExecutor) this.f17800e.get()).a(GraphQLRequest.a(fBFamilyNonUserMemberAlbumsQueryString).a(graphQLCachePolicy)), new Function<GraphQLResult<FBFamilyNonUserMemberAlbumsQueryModel>, GraphQLAlbumsConnection>(this) {
            final /* synthetic */ FamilyAlbumUtil f17794b;

            @Nullable
            public Object apply(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((FBFamilyNonUserMemberAlbumsQueryModel) graphQLResult.e).j() == null || ((FBFamilyNonUserMemberAlbumsQueryModel) graphQLResult.e).j().a() == null) {
                    return null;
                }
                int size = ((FBFamilyNonUserMemberAlbumsQueryModel) graphQLResult.e).j().a().size();
                ImmutableList a = ((FBFamilyNonUserMemberAlbumsQueryModel) graphQLResult.e).j().a();
                if (a.isEmpty()) {
                    return null;
                }
                Builder builder = new Builder();
                for (int i = 0; i < size; i++) {
                    GraphQLPhoto a2;
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    String k = edgesModel.a().k();
                    FamilyTaggedMediasetModel j = edgesModel.a().j();
                    if (j.a().j().size() > 0) {
                        MediaEdgesNodeModel a3 = ((MediaEdgesModel) j.a().j().get(0)).a();
                        GraphQLPhoto.Builder builder2 = new GraphQLPhoto.Builder();
                        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
                        builder3.g = a3.k().j();
                        builder3 = builder3;
                        builder3.h = a3.k().k();
                        builder3 = builder3;
                        builder3.d = a3.k().a();
                        builder2.ab = builder3.a();
                        builder2 = builder2;
                        builder2.aW = a3.k().j();
                        builder2 = builder2;
                        builder2.F = a3.j();
                        a2 = builder2.a();
                    } else {
                        a2 = null;
                    }
                    if (a2 != null || l.toString().equals(this.f17794b.f17798c.get())) {
                        GraphQLAlbum.Builder builder4 = new GraphQLAlbum.Builder();
                        builder4.d = a2;
                        GraphQLAlbum.Builder builder5 = builder4;
                        builder5.e = GraphQLPhotosAlbumAPIType.OTHER;
                        builder5 = builder5;
                        GraphQLMediaSetMediaConnection.Builder builder6 = new GraphQLMediaSetMediaConnection.Builder();
                        builder6.d = j.a().a();
                        builder5.q = builder6.a();
                        builder5 = builder5;
                        builder5.z = GraphQLHelper.a(j.j().a());
                        builder5 = builder5;
                        builder5.o = k;
                        builder5 = builder5;
                        builder5.v = "FamilyAlbum";
                        builder.c(builder5.a());
                    }
                }
                GraphQLAlbumsConnection.Builder builder7 = new GraphQLAlbumsConnection.Builder();
                builder7.d = builder.b();
                return builder7.a();
            }
        });
        Futures.a(a, new C19072(this));
        return a;
    }
}
