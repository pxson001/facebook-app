package com.facebook.pages.identity.cards.videos;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQL.VideoCardQueryString;
import com.facebook.pages.data.graphql.cards.VideoCardGraphQLModels.VideoCardQueryModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.cards.videos.PageIdentityVideosCardView.C05171;
import com.facebook.pages.identity.cards.videos.PageIdentityVideosCardView.C05182;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: places_render_priority_1 */
public class PageIdentityVideosCardSpecification implements PageBatchFetchingCardSpecification {
    private final Resources f3763a;
    private final ExecutorService f3764b;

    public static PageIdentityVideosCardSpecification m4745b(InjectorLike injectorLike) {
        return new PageIdentityVideosCardSpecification(ResourcesMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4743a(context);
    }

    public static PageIdentityVideosCardSpecification m4744a(InjectorLike injectorLike) {
        return m4745b(injectorLike);
    }

    @Inject
    public PageIdentityVideosCardSpecification(Resources resources, ExecutorService executorService) {
        this.f3763a = resources;
        this.f3764b = executorService;
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4743a(Context context) {
        return new PageIdentityVideosCardView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.VIDEOS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    private GraphQLRequest<VideoCardQueryModel> m4742a(long j) {
        GraphQLRequest a = GraphQLRequest.a((VideoCardQueryString) new VideoCardQueryString().a("page_id", String.valueOf(j)).a("page_videos_max_num", Integer.valueOf(this.f3763a.getInteger(2131492910))));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final Optional<ListenableFuture<GraphQLResult<VideoCardQueryModel>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().y()) {
            return Absent.withType();
        }
        GraphQLRequest a = m4742a(j);
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
        Futures.a(b, new FutureCallback<GraphQLResult<VideoCardQueryModel>>(this) {
            final /* synthetic */ PageIdentityVideosCardSpecification f3762f;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    int i;
                    final VideoCardQueryModel videoCardQueryModel = (VideoCardQueryModel) graphQLResult.e;
                    PageIdentityVideosCardSpecification pageIdentityVideosCardSpecification = this.f3762f;
                    if (videoCardQueryModel == null || videoCardQueryModel.c() == null || videoCardQueryModel.c().a() == null || videoCardQueryModel.c().a().isEmpty() || videoCardQueryModel.c().a().get(0) == null || ((VideoDetailFragmentModel) videoCardQueryModel.c().a().get(0)).F() == null || !videoCardQueryModel.b()) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        pageCardsRenderScheduler2.m4244a(this.f3762f.mo79b(), new Runnable(this) {
                            final /* synthetic */ C05161 f3756b;

                            public void run() {
                                boolean z;
                                View view = pageViewPlaceHolder2.f3791d;
                                if (view == null) {
                                    view = (View) PageIdentityVideosCardSpecification.m4743a(context2);
                                    pageViewPlaceHolder2.m4758a(view);
                                }
                                PageIdentityVideosCardView pageIdentityVideosCardView = (PageIdentityVideosCardView) view;
                                long j = j2;
                                VideoCardQueryModel videoCardQueryModel = videoCardQueryModel;
                                if (videoCardQueryModel.b() && videoCardQueryModel.a() != null) {
                                    pageIdentityVideosCardView.f3785o = videoCardQueryModel.a();
                                } else if (videoCardQueryModel.c() == null || videoCardQueryModel.c().a() == null || videoCardQueryModel.c().a().isEmpty()) {
                                    ((AbstractFbErrorReporter) pageIdentityVideosCardView.f3779h.get()).a(pageIdentityVideosCardView.getClass().getName(), "Unable to initialize video card - missing data");
                                    return;
                                } else {
                                    pageIdentityVideosCardView.f3785o = (VideoDetailFragmentModel) videoCardQueryModel.c().a().get(0);
                                }
                                if (!videoCardQueryModel.b() || videoCardQueryModel.d() == null || videoCardQueryModel.d().a() == null || videoCardQueryModel.d().a().a() <= 0) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                Preconditions.checkNotNull(pageIdentityVideosCardView.f3785o.F());
                                pageIdentityVideosCardView.f3781k.setController(((FbDraweeControllerBuilder) pageIdentityVideosCardView.f3773b.get()).a(PageIdentityVideosCardView.f3771i).a(pageIdentityVideosCardView.f3785o.F() != null ? pageIdentityVideosCardView.f3785o.F().b() : null).s());
                                pageIdentityVideosCardView.f3780j.setOnClickListener(new C05171(pageIdentityVideosCardView, z, j));
                                pageIdentityVideosCardView.f3782l.setOnClickListener(new C05182(pageIdentityVideosCardView));
                                pageIdentityVideosCardView.f3780j.setVisibility(0);
                                pageIdentityVideosCardView.f3782l.setVisibility(0);
                            }
                        });
                    }
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3764b);
        return Optional.of(b);
    }
}
