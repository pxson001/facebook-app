package com.facebook.pages.identity.cards.vertexattribution;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAttributionEntry;
import com.facebook.graphql.model.GraphQLAttributionEntry.Builder;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLEntityCardContextItemIcon;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQL.VertexAttributionQueryString;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel.AttributionModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel.AttributionModel.AttributionAttributionModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel.AttributionModel.AttributionAttributionModel.RangesModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel.AttributionModel.AttributionAttributionModel.RangesModel.EntityModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel.AttributionModel.IconModel;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel.AttributionModel.IconModel.IconImageModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.vertex_attribution.PagesVertexAttributionView;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: places_render_priority_2 */
public class PageIdentityVertexAttributionCardSpecification implements PageBatchFetchingCardSpecification {
    private final ExecutorService f3753a;
    private float f3754b = 1.0f;

    /* compiled from: places_render_priority_2 */
    class AttributionToGraphQLFunction implements Function<AttributionModel, GraphQLAttributionEntry> {
        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLAttributionEntry graphQLAttributionEntry;
            AttributionModel attributionModel = (AttributionModel) obj;
            if (attributionModel == null) {
                graphQLAttributionEntry = null;
            } else {
                GraphQLTextWithEntities graphQLTextWithEntities;
                GraphQLEntityCardContextItemIcon graphQLEntityCardContextItemIcon;
                Builder builder = new Builder();
                AttributionAttributionModel a = attributionModel.a();
                if (a == null) {
                    graphQLTextWithEntities = null;
                } else {
                    GraphQLTextWithEntities.Builder builder2 = new GraphQLTextWithEntities.Builder();
                    if (a.a() != null) {
                        ImmutableList.Builder builder3 = ImmutableList.builder();
                        for (int i = 0; i < a.a().size(); i++) {
                            GraphQLEntityAtRange graphQLEntityAtRange;
                            RangesModel rangesModel = (RangesModel) a.a().get(i);
                            if (rangesModel == null) {
                                graphQLEntityAtRange = null;
                            } else {
                                GraphQLEntity graphQLEntity;
                                GraphQLEntityAtRange.Builder builder4 = new GraphQLEntityAtRange.Builder();
                                EntityModel a2 = rangesModel.a();
                                if (a2 == null) {
                                    graphQLEntity = null;
                                } else {
                                    GraphQLEntity.Builder builder5 = new GraphQLEntity.Builder();
                                    builder5.S = a2.a();
                                    builder5.P = a2.b();
                                    graphQLEntity = builder5.a();
                                }
                                builder4.d = graphQLEntity;
                                builder4.e = rangesModel.b();
                                builder4.f = rangesModel.c();
                                graphQLEntityAtRange = builder4.a();
                            }
                            builder3.c(graphQLEntityAtRange);
                        }
                        builder2.h = builder3.b();
                    }
                    builder2.i = a.b();
                    graphQLTextWithEntities = builder2.a();
                }
                builder.d = graphQLTextWithEntities;
                IconModel b = attributionModel.b();
                if (b == null) {
                    graphQLEntityCardContextItemIcon = null;
                } else {
                    GraphQLImage graphQLImage;
                    GraphQLEntityCardContextItemIcon.Builder builder6 = new GraphQLEntityCardContextItemIcon.Builder();
                    IconImageModel a3 = b.a();
                    if (a3 == null) {
                        graphQLImage = null;
                    } else {
                        GraphQLImage.Builder builder7 = new GraphQLImage.Builder();
                        builder7.d = a3.a();
                        builder7.g = a3.b();
                        builder7.h = a3.c();
                        graphQLImage = builder7.a();
                    }
                    builder6.d = graphQLImage;
                    graphQLEntityCardContextItemIcon = new GraphQLEntityCardContextItemIcon(builder6);
                }
                builder.e = graphQLEntityCardContextItemIcon;
                builder.g = attributionModel.c();
                graphQLAttributionEntry = builder.a();
            }
            return graphQLAttributionEntry;
        }
    }

    public static PageIdentityVertexAttributionCardSpecification m4736b(InjectorLike injectorLike) {
        return new PageIdentityVertexAttributionCardSpecification((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public static PageIdentityVertexAttributionCardSpecification m4734a(InjectorLike injectorLike) {
        return m4736b(injectorLike);
    }

    public final /* bridge */ /* synthetic */ PageCardView mo76a(LayoutInflater layoutInflater, Context context) {
        return m4733a(context);
    }

    @Inject
    public PageIdentityVertexAttributionCardSpecification(ExecutorService executorService) {
        this.f3753a = executorService;
    }

    private GraphQLRequest<VertexAttributionQueryModel> m4732a(long j) {
        GraphQLRequest a = GraphQLRequest.a((VertexAttributionQueryString) new VertexAttributionQueryString().a("page_id", String.valueOf(j)).a("size", "16").a("pixel_ratio", String.valueOf(this.f3754b)));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4733a(Context context) {
        return new PagesVertexAttributionView(context, null, 2130773402);
    }

    public final PageCardType mo79b() {
        return PageCardType.VERTEX_ATTRIBUTION;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (pageHeaderData.g().y()) {
            return Absent.withType();
        }
        this.f3754b = m4735b(context);
        GraphQLRequest a = m4732a(j);
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
        Futures.a(b, new FutureCallback<GraphQLResult<VertexAttributionQueryModel>>(this) {
            final /* synthetic */ PageIdentityVertexAttributionCardSpecification f3752f;

            public void onSuccess(@Nullable Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null) {
                    final VertexAttributionQueryModel vertexAttributionQueryModel = (VertexAttributionQueryModel) graphQLResult.e;
                    if (vertexAttributionQueryModel != null && vertexAttributionQueryModel.a() != null && !vertexAttributionQueryModel.a().isEmpty()) {
                        pageCardsRenderScheduler2.m4244a(this.f3752f.mo79b(), new Runnable(this) {
                            final /* synthetic */ C05141 f3746b;

                            public void run() {
                                ImmutableList copyOf = ImmutableList.copyOf(Lists.a(vertexAttributionQueryModel.a(), new AttributionToGraphQLFunction()));
                                View view = pageViewPlaceHolder2.f3791d;
                                if (view == null) {
                                    view = (View) PageIdentityVertexAttributionCardSpecification.m4733a(context2);
                                    pageViewPlaceHolder2.m4758a(view);
                                }
                                ((PagesVertexAttributionView) view).setAttribtutions(copyOf);
                            }
                        });
                    }
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3753a);
        return Optional.of(b);
    }

    private static float m4735b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return (float) (displayMetrics.densityDpi / 160);
    }
}
