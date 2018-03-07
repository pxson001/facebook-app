package com.facebook.pages.identity.cards.photos;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQL.OwnedPagePhotosQueryString;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQL.UnownedLocalPagePhotosQueryString;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQL.UnownedNonLocalPagePhotosQueryString;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.OwnedPagePhotosQueryModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.OwnedPagePhotosQueryModel.PostedPhotosModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.PagePhotoWithAttributionModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.PagePhotoWithAttributionModel.OwnerModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.PagePhotoWithAttributionModel.PrivacyScopeModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.PagePhotoWithAttributionModel.PrivacyScopeModel.IconImageModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.UnownedLocalPagePhotosQueryModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.UnownedLocalPagePhotosQueryModel.PhotosTakenHereModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.UnownedNonLocalPagePhotosQueryModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLModels.UnownedNonLocalPagePhotosQueryModel.PhotosTakenOfModel;
import com.facebook.pages.data.graphql.cards.PagesCardsModelConversionHelper;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotosCardController.PhotoCollectionType;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotosCardController.TabbedPhotosetData;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacyOverride */
public class PageIdentityPhotosCardSpecification implements PageBatchFetchingCardSpecification {
    private final Resources f3584a;
    private final GraphQLImageHelper f3585b;
    private final SizeAwareImageUtil f3586c;
    private final ExecutorService f3587d;

    public static PageIdentityPhotosCardSpecification m4628b(InjectorLike injectorLike) {
        return new PageIdentityPhotosCardSpecification(ResourcesMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public static PageIdentityPhotosCardSpecification m4627a(InjectorLike injectorLike) {
        return m4628b(injectorLike);
    }

    @Inject
    public PageIdentityPhotosCardSpecification(Resources resources, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil, Lazy<FbErrorReporter> lazy, ExecutorService executorService) {
        this.f3584a = resources;
        this.f3585b = graphQLImageHelper;
        this.f3586c = sizeAwareImageUtil;
        this.f3587d = executorService;
    }

    public final boolean mo77a() {
        return true;
    }

    public final PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return new PageIdentityPhotosCardView(context);
    }

    public final PageCardType mo79b() {
        return PageCardType.PHOTOS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        final FetchPageHeaderQueryModel g = pageHeaderData.g();
        GraphQLRequest a = m4626a(j, pageHeaderData);
        if (a == null) {
            return Absent.withType();
        }
        a.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(a);
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final long j2 = j;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(b, new FutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ PageIdentityPhotosCardSpecification f3583g;

            public void onSuccess(@Nullable Object obj) {
                final GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult.e != null) {
                    pageCardsRenderScheduler2.m4244a(this.f3583g.mo79b(), new Runnable(this) {
                        final /* synthetic */ C04891 f3576b;

                        public void run() {
                            TabbedPhotosetData tabbedPhotosetData = null;
                            if (g.y()) {
                                TabbedPhotosetData tabbedPhotosetData2;
                                PostedPhotosModel a = ((OwnedPagePhotosQueryModel) graphQLResult.e).a();
                                if (a != null) {
                                    ImmutableList immutableList;
                                    ImmutableList<SizeAwareMediaModel> a2 = a.a();
                                    if (a2 == null || a2.isEmpty()) {
                                        immutableList = RegularImmutableList.a;
                                    } else {
                                        Builder builder = new Builder();
                                        for (SizeAwareMediaModel sizeAwareMediaModel : a2) {
                                            GraphQLPhoto graphQLPhoto = null;
                                            if (sizeAwareMediaModel != null) {
                                                GraphQLObjectType b = sizeAwareMediaModel.b();
                                                if (b != null && b.g() == 77090322) {
                                                    GraphQLPhoto.Builder builder2 = new GraphQLPhoto.Builder();
                                                    builder2.B = PhotosMetadataConversionHelper.a(sizeAwareMediaModel.c());
                                                    builder2.F = sizeAwareMediaModel.d();
                                                    builder2.G = PhotosMetadataConversionHelper.a(sizeAwareMediaModel.be_());
                                                    builder2.I = PhotosMetadataConversionHelper.a(sizeAwareMediaModel.g());
                                                    builder2.P = PhotosMetadataConversionHelper.a(sizeAwareMediaModel.bd_());
                                                    builder2.S = PhotosMetadataConversionHelper.a(sizeAwareMediaModel.bc_());
                                                    graphQLPhoto = builder2.a();
                                                }
                                            }
                                            builder.c(graphQLPhoto);
                                        }
                                        immutableList = builder.b();
                                    }
                                    tabbedPhotosetData2 = new TabbedPhotosetData(immutableList, PhotoCollectionType.PAGE_PHOTOS_BY);
                                } else {
                                    tabbedPhotosetData2 = null;
                                }
                                tabbedPhotosetData = tabbedPhotosetData2;
                            } else if (g.w()) {
                                PhotosTakenHereModel a3 = ((UnownedLocalPagePhotosQueryModel) graphQLResult.e).a();
                                if (a3 != null) {
                                    tabbedPhotosetData = new TabbedPhotosetData(PageIdentityPhotosCardSpecification.m4629d(a3.a()), PhotoCollectionType.PHOTOS_TAKEN_HERE);
                                }
                            } else {
                                PhotosTakenOfModel a4 = ((UnownedNonLocalPagePhotosQueryModel) graphQLResult.e).a();
                                if (a4 != null) {
                                    tabbedPhotosetData = new TabbedPhotosetData(PageIdentityPhotosCardSpecification.m4629d(a4.a()), PhotoCollectionType.PAGE_PHOTOS_OF);
                                }
                            }
                            if (tabbedPhotosetData != null && !tabbedPhotosetData.m4624b()) {
                                View view = pageViewPlaceHolder2.f3791d;
                                if (view == null) {
                                    view = (View) this.f3576b.f3583g.mo76a(layoutInflater2, context2);
                                    pageViewPlaceHolder2.m4758a(view);
                                }
                                ((PageIdentityPhotosCardView) view).m4646a(j2, g, tabbedPhotosetData);
                            }
                        }
                    });
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3587d);
        return Optional.of(b);
    }

    private GraphQLRequest<?> m4626a(long j, PageHeaderData pageHeaderData) {
        GraphQlQueryString ownedPagePhotosQueryString;
        String valueOf = String.valueOf(this.f3584a.getInteger(2131492909));
        if (pageHeaderData.e.y()) {
            ownedPagePhotosQueryString = new OwnedPagePhotosQueryString();
        } else if (pageHeaderData.e.w()) {
            ownedPagePhotosQueryString = new UnownedLocalPagePhotosQueryString();
        } else {
            ownedPagePhotosQueryString = new UnownedNonLocalPagePhotosQueryString();
        }
        ownedPagePhotosQueryString.a("page_id", String.valueOf(j)).a("page_photos_max_num", valueOf);
        this.f3586c.a(ownedPagePhotosQueryString, this.f3585b.c());
        GraphQLRequest a = GraphQLRequest.a(ownedPagePhotosQueryString);
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public static ImmutableList<GraphQLPhoto> m4629d(List<PagePhotoWithAttributionModel> list) {
        if (list == null || list.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        for (PagePhotoWithAttributionModel pagePhotoWithAttributionModel : list) {
            GraphQLPhoto graphQLPhoto;
            if (pagePhotoWithAttributionModel == null) {
                graphQLPhoto = null;
            } else {
                GraphQLVect2 graphQLVect2;
                GraphQLActor graphQLActor;
                GraphQLPrivacyScope graphQLPrivacyScope;
                GraphQLPhoto.Builder builder2 = new GraphQLPhoto.Builder();
                builder2.v = pagePhotoWithAttributionModel.j();
                DefaultVect2Fields c = pagePhotoWithAttributionModel.c();
                if (c == null) {
                    graphQLVect2 = null;
                } else {
                    GraphQLVect2.Builder builder3 = new GraphQLVect2.Builder();
                    builder3.d = c.a();
                    builder3.e = c.b();
                    graphQLVect2 = builder3.a();
                }
                builder2.B = graphQLVect2;
                builder2.F = pagePhotoWithAttributionModel.d();
                builder2.G = PagesCardsModelConversionHelper.a(pagePhotoWithAttributionModel.be_());
                builder2.I = PagesCardsModelConversionHelper.a(pagePhotoWithAttributionModel.g());
                builder2.P = PagesCardsModelConversionHelper.a(pagePhotoWithAttributionModel.bd_());
                builder2.S = PagesCardsModelConversionHelper.a(pagePhotoWithAttributionModel.bc_());
                OwnerModel k = pagePhotoWithAttributionModel.k();
                if (k == null) {
                    graphQLActor = null;
                } else {
                    GraphQLActor.Builder builder4 = new GraphQLActor.Builder();
                    builder4.aH = k.a();
                    builder4.V = k.b();
                    graphQLActor = builder4.a();
                }
                builder2.aA = graphQLActor;
                PrivacyScopeModel l = pagePhotoWithAttributionModel.l();
                if (l == null) {
                    graphQLPrivacyScope = null;
                } else {
                    GraphQLImage graphQLImage;
                    GraphQLPrivacyScope.Builder builder5 = new GraphQLPrivacyScope.Builder();
                    IconImageModel a = l.a();
                    if (a == null) {
                        graphQLImage = null;
                    } else {
                        GraphQLImage.Builder builder6 = new GraphQLImage.Builder();
                        builder6.e = a.a();
                        builder6.g = a.b();
                        graphQLImage = builder6.a();
                    }
                    builder5.h = graphQLImage;
                    graphQLPrivacyScope = builder5.a();
                }
                builder2.aM = graphQLPrivacyScope;
                graphQLPhoto = builder2.a();
            }
            builder.c(graphQLPhoto);
        }
        return builder.b();
    }
}
