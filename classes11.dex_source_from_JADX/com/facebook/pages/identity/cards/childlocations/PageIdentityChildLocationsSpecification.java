package com.facebook.pages.identity.cards.childlocations;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQL;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQL.ChildLocationQueryWithViewerLocationString;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQL.ChildLocationQueryWithoutViewerLocationString;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationConnectionFieldsModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationQueryWithViewerLocationModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationQueryWithoutViewerLocationModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.batching.PageCardsRenderScheduler;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
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

/* compiled from: privacy_checkup_profile_step_previous */
public class PageIdentityChildLocationsSpecification implements PageBatchFetchingCardSpecification {
    private static final String f3341a = PageIdentityChildLocationsSpecification.class.getSimpleName();
    private final Resources f3342b;
    private final FbLocationCache f3343c;
    private final GraphQLImageHelper f3344d;
    private final ExecutorService f3345e;
    public final int f3346f = this.f3342b.getInteger(2131492914);
    public final int f3347g = GraphQLImageHelper.a(this.f3342b.getDimensionPixelSize(2131429986)).intValue();
    public boolean f3348h;

    public static PageIdentityChildLocationsSpecification m4461b(InjectorLike injectorLike) {
        return new PageIdentityChildLocationsSpecification(ResourcesMethodAutoProvider.a(injectorLike), FbLocationCache.b(injectorLike), GraphQLImageHelper.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    public static PageIdentityChildLocationsSpecification m4460a(InjectorLike injectorLike) {
        return m4461b(injectorLike);
    }

    @Inject
    public PageIdentityChildLocationsSpecification(Resources resources, FbLocationCache fbLocationCache, GraphQLImageHelper graphQLImageHelper, ExecutorService executorService) {
        this.f3342b = resources;
        this.f3343c = fbLocationCache;
        this.f3344d = graphQLImageHelper;
        this.f3345e = executorService;
    }

    public final boolean mo77a() {
        return true;
    }

    public static PageSecondaryCardView m4459a(Context context) {
        return new PageIdentityChildLocationsCardView(context, null, 2130773402);
    }

    private GraphQLRequest<?> m4458a(long j, PageHeaderData pageHeaderData) {
        Location l;
        GraphQLRequest a;
        Location location = pageHeaderData.b;
        if (location == null) {
            ImmutableLocation a2 = this.f3343c.a(1800000);
            if (a2 != null) {
                l = a2.l();
                this.f3348h = l == null;
                if (this.f3348h) {
                    Preconditions.checkArgument(this.f3348h);
                    a = GraphQLRequest.a((ChildLocationQueryWithoutViewerLocationString) ChildLocationCardGraphQL.b().a("page_id", String.valueOf(j)).a("user_image_size", Integer.valueOf(this.f3347g)).a("max_child_locations", Integer.valueOf(this.f3346f)));
                    a.e = ImmutableSet.of("GraphQlPageCardTag");
                    return a.a(RequestPriority.INTERACTIVE);
                }
                Long valueOf = Long.valueOf(j);
                Preconditions.checkArgument(this.f3348h);
                a = GraphQLRequest.a((ChildLocationQueryWithViewerLocationString) ChildLocationCardGraphQL.a().a("page_id", String.valueOf(valueOf)).a("user_image_size", Integer.valueOf(this.f3347g)).a("viewer_latitude", Double.valueOf(l.getLatitude())).a("viewer_longitude", Double.valueOf(l.getLongitude())).a("max_child_locations", Integer.valueOf(this.f3346f)));
                a.e = ImmutableSet.of("GraphQlPageCardTag");
                return a.a(RequestPriority.INTERACTIVE);
            }
        }
        l = location;
        if (l == null) {
        }
        this.f3348h = l == null;
        if (this.f3348h) {
            if (this.f3348h) {
            }
            Preconditions.checkArgument(this.f3348h);
            a = GraphQLRequest.a((ChildLocationQueryWithoutViewerLocationString) ChildLocationCardGraphQL.b().a("page_id", String.valueOf(j)).a("user_image_size", Integer.valueOf(this.f3347g)).a("max_child_locations", Integer.valueOf(this.f3346f)));
            a.e = ImmutableSet.of("GraphQlPageCardTag");
            return a.a(RequestPriority.INTERACTIVE);
        }
        Long valueOf2 = Long.valueOf(j);
        Preconditions.checkArgument(this.f3348h);
        a = GraphQLRequest.a((ChildLocationQueryWithViewerLocationString) ChildLocationCardGraphQL.a().a("page_id", String.valueOf(valueOf2)).a("user_image_size", Integer.valueOf(this.f3347g)).a("viewer_latitude", Double.valueOf(l.getLatitude())).a("viewer_longitude", Double.valueOf(l.getLongitude())).a("max_child_locations", Integer.valueOf(this.f3346f)));
        a.e = ImmutableSet.of("GraphQlPageCardTag");
        return a.a(RequestPriority.INTERACTIVE);
    }

    public final PageCardType mo79b() {
        return PageCardType.CHILD_LOCATIONS;
    }

    public final FetchType mo80c() {
        return FetchType.SECONDARY;
    }

    public final Optional<? extends ListenableFuture<? extends GraphQLResult<?>>> mo81a(long j, GraphQLBatchRequest graphQLBatchRequest, PageViewPlaceHolder pageViewPlaceHolder, Context context, LayoutInflater layoutInflater, PageHeaderData pageHeaderData, GraphQLCachePolicy graphQLCachePolicy, PageCardsRenderScheduler pageCardsRenderScheduler) {
        if (!pageHeaderData.g().y()) {
            return Absent.withType();
        }
        GraphQLRequest a = m4458a(j, pageHeaderData);
        if (a == null) {
            return Absent.withType();
        }
        a.a(graphQLCachePolicy);
        ListenableFuture b = graphQLBatchRequest.b(a);
        final PageViewPlaceHolder pageViewPlaceHolder2 = pageViewPlaceHolder;
        final LayoutInflater layoutInflater2 = layoutInflater;
        final Context context2 = context;
        final long j2 = j;
        final PageHeaderData pageHeaderData2 = pageHeaderData;
        final PageCardsRenderScheduler pageCardsRenderScheduler2 = pageCardsRenderScheduler;
        Futures.a(b, new FutureCallback<GraphQLResult<?>>(this) {
            final /* synthetic */ PageIdentityChildLocationsSpecification f3340g;

            public void onSuccess(@Nullable Object obj) {
                final GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult != null && graphQLResult.e != null) {
                    pageCardsRenderScheduler2.m4244a(this.f3340g.mo79b(), new Runnable(this) {
                        final /* synthetic */ C04501 f3333b;

                        public void run() {
                            ChildLocationConnectionFieldsModel a;
                            if (this.f3333b.f3340g.f3348h) {
                                ChildLocationQueryWithViewerLocationModel childLocationQueryWithViewerLocationModel = (ChildLocationQueryWithViewerLocationModel) graphQLResult.e;
                                if (childLocationQueryWithViewerLocationModel.a() != null && !childLocationQueryWithViewerLocationModel.a().a().isEmpty()) {
                                    a = childLocationQueryWithViewerLocationModel.a();
                                } else {
                                    return;
                                }
                            }
                            ChildLocationQueryWithoutViewerLocationModel childLocationQueryWithoutViewerLocationModel = (ChildLocationQueryWithoutViewerLocationModel) graphQLResult.e;
                            if (childLocationQueryWithoutViewerLocationModel.a() != null && !childLocationQueryWithoutViewerLocationModel.a().a().isEmpty()) {
                                a = childLocationQueryWithoutViewerLocationModel.a();
                            } else {
                                return;
                            }
                            View view = pageViewPlaceHolder2.f3791d;
                            if (view == null) {
                                view = (View) PageIdentityChildLocationsSpecification.m4459a(context2);
                                pageViewPlaceHolder2.m4758a(view);
                            }
                            ((PageIdentityChildLocationsCardView) view).m4456a(j2, pageHeaderData2.e.D(), a.a());
                        }
                    });
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f3345e);
        return Optional.of(b);
    }
}
