package com.facebook.timeline.header.bio.edit;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.timeline.header.intro.IntroCardEditActivity;
import com.facebook.timeline.header.intro.protocol.BioGraphQL.BioQueryString;
import com.facebook.timeline.header.intro.protocol.BioGraphQLModels.BioQueryModel;
import com.facebook.timeline.header.intro.protocol.BioGraphQLModels.BioQueryModel.ProfileIntroCardModel;
import com.facebook.timeline.header.intro.protocol.BioQueryExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UriMatchPatterns
/* compiled from: force_tabbed_dashboard */
public class TimelineBioEditActivity extends IntroCardEditActivity<GraphQLResult<BioQueryModel>> {
    @Inject
    Lazy<BioQueryExecutor> f11606p;
    @Inject
    @LoggedInUserId
    Provider<String> f11607q;

    private static <T extends Context> void m11641a(Class<T> cls, T t) {
        m11642a((Object) t, (Context) t);
    }

    public static void m11642a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TimelineBioEditActivity) obj).m11640a(IdBasedSingletonScopeProvider.b(fbInjector, 11279), IdBasedProvider.a(fbInjector, 4442));
    }

    private void m11640a(Lazy<BioQueryExecutor> lazy, Provider<String> provider) {
        this.f11606p = lazy;
        this.f11607q = provider;
    }

    protected final void mo534a(Object obj, Bundle bundle) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult != null && graphQLResult.e != null && ((BioQueryModel) graphQLResult.e).m11907a() != null) {
            ProfileIntroCardModel a = ((BioQueryModel) graphQLResult.e).m11907a();
            if (!(a.m11900a() == null || a.m11900a().a() == null)) {
                bundle.putString("initial_bio_text", ((BioQueryModel) graphQLResult.e).m11907a().m11900a().a());
            }
            bundle.putBoolean("initial_is_feed_sharing_switch_checked", ((BioQueryModel) graphQLResult.e).m11907a().m11903j());
        }
    }

    protected final void mo535b(@Nullable Bundle bundle) {
        Class cls = TimelineBioEditActivity.class;
        m11642a((Object) this, (Context) this);
        super.mo535b(bundle);
    }

    protected final Fragment mo537i() {
        return new TimelineBioEditFragment();
    }

    protected final int mo538j() {
        return 2131235016;
    }

    protected final void mo539k() {
    }

    protected final void mo540l() {
    }

    protected final boolean mo541m() {
        return !StringUtil.c(getIntent().getStringExtra("profileId"));
    }

    protected final void mo536c(Bundle bundle) {
        bundle.putBoolean("should_open_new_timeline_activity_on_save_success", true);
        bundle.putBoolean("show_feed_sharing_switch_extra", true);
    }

    protected final ListenableFuture<GraphQLResult<BioQueryModel>> mo542n() {
        BioQueryExecutor bioQueryExecutor = (BioQueryExecutor) this.f11606p.get();
        GraphQLRequest a = GraphQLRequest.a((BioQueryString) new BioQueryString().a("profile_id", Long.valueOf(Long.parseLong((String) this.f11607q.get())))).a(RequestPriority.INTERACTIVE);
        a.f = BioQueryExecutor.f11837b;
        a = a;
        a.e = BioQueryExecutor.f11836a;
        return bioQueryExecutor.f11839c.a(a.a(GraphQLCachePolicy.a).a(3600));
    }
}
