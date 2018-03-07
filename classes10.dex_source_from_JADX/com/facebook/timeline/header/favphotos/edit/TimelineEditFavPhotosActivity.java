package com.facebook.timeline.header.favphotos.edit;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.timeline.header.intro.IntroCardEditActivity;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQL.FavPhotosQueryString;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQLModels.FavPhotosQueryModel;
import com.facebook.timeline.header.intro.protocol.FavPhotosGraphQLModels.FavPhotosQueryModel.ProfileIntroCardModel;
import com.facebook.timeline.header.intro.protocol.FavPhotosQueryExecutor;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UriMatchPatterns
/* compiled from: fetch_product_group */
public class TimelineEditFavPhotosActivity extends IntroCardEditActivity<GraphQLResult<FavPhotosQueryModel>> {
    @Inject
    TimelineAnalyticsLogger f11784p;
    @Inject
    Lazy<FavPhotosQueryExecutor> f11785q;
    @Inject
    @LoggedInUserId
    Provider<String> f11786r;
    private long f11787u;

    private static <T extends Context> void m11848a(Class<T> cls, T t) {
        m11849a((Object) t, (Context) t);
    }

    public static void m11849a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineEditFavPhotosActivity) obj).m11847a(TimelineAnalyticsLogger.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 11280), IdBasedProvider.a(fbInjector, 4442));
    }

    private void m11847a(TimelineAnalyticsLogger timelineAnalyticsLogger, Lazy<FavPhotosQueryExecutor> lazy, Provider<String> provider) {
        this.f11784p = timelineAnalyticsLogger;
        this.f11785q = lazy;
        this.f11786r = provider;
    }

    protected final void mo534a(Object obj, Bundle bundle) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult != null && graphQLResult.e != null && ((FavPhotosQueryModel) graphQLResult.e).m11933a() != null) {
            ProfileIntroCardModel a = ((FavPhotosQueryModel) graphQLResult.e).m11933a();
            if (!(a.m11927a() == null || a.m11927a().m11923a() == null)) {
                FlatBufferModelHelper.a(bundle, "fav_photos_extra", ((FavPhotosQueryModel) graphQLResult.e).m11933a().m11927a().m11923a());
            }
            bundle.putBoolean("initial_is_feed_sharing_switch_checked", ((FavPhotosQueryModel) graphQLResult.e).m11933a().m11929j());
        }
    }

    protected final void mo535b(@Nullable Bundle bundle) {
        Class cls = TimelineEditFavPhotosActivity.class;
        m11849a((Object) this, (Context) this);
        this.f11787u = Long.parseLong((String) this.f11786r.get());
        super.mo535b(bundle);
    }

    protected final Fragment mo537i() {
        return new TimelineEditFavPhotosFragment();
    }

    protected final int mo538j() {
        return 2131235028;
    }

    protected final void mo539k() {
        m11850o();
    }

    protected final void mo540l() {
        m11850o();
    }

    protected final boolean mo541m() {
        return !StringUtil.c(getIntent().getStringExtra("profileId"));
    }

    protected final void mo536c(Bundle bundle) {
        bundle.putBoolean("should_open_new_timeline_activity_on_save_success", true);
        bundle.putBoolean("show_feed_sharing_switch_extra", true);
    }

    protected final ListenableFuture<GraphQLResult<FavPhotosQueryModel>> mo542n() {
        FavPhotosQueryExecutor favPhotosQueryExecutor = (FavPhotosQueryExecutor) this.f11785q.get();
        long j = this.f11787u;
        GraphQlQueryString favPhotosQueryString = new FavPhotosQueryString();
        favPhotosQueryString.a("profile_id", Long.valueOf(j));
        favPhotosQueryExecutor.f11849e.a(favPhotosQueryString, favPhotosQueryExecutor.f11848d.c());
        GraphQLRequest a = GraphQLRequest.a(favPhotosQueryString).a(RequestPriority.INTERACTIVE);
        a.f = FavPhotosQueryExecutor.f11845b;
        a = a;
        a.e = FavPhotosQueryExecutor.f11844a;
        return favPhotosQueryExecutor.f11847c.a(a.a(GraphQLCachePolicy.a).a(3600));
    }

    private void m11850o() {
        this.f11784p.n(this.f11787u);
    }
}
