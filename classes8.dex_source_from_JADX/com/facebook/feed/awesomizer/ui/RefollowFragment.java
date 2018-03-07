package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel.UnfollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerUnfollowingQueryModel.UnfollowedProfilesModel.Builder;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.AwesomizerNetworkQueryHelper.C12622;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;

/* compiled from: group_user_invite_accept */
public class RefollowFragment extends BaseAwesomizerFragment<FeedAwesomizerUnfollowingQueryModel> {
    public AwesomizerNetworkQueryHelper am;

    public static void m13957a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        RefollowFragment refollowFragment = (RefollowFragment) obj;
        AwesomizerNetworkQueryHelper b = AwesomizerNetworkQueryHelper.m13867b(injectorLike);
        RefollowAdapter b2 = RefollowAdapter.m13951b(injectorLike);
        refollowFragment.am = b;
        refollowFragment.f11817h = b2;
    }

    public final void m13960c(Bundle bundle) {
        super.c(bundle);
        Class cls = RefollowFragment.class;
        m13957a(this, getContext());
    }

    protected final int mo815e() {
        return 2131625682;
    }

    protected final void mo809a(AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        String str;
        UnfollowedProfilesModel unfollowedProfilesModel = (UnfollowedProfilesModel) this.f11817h.f11803g;
        AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper = this.am;
        int b = mo814b();
        if (unfollowedProfilesModel == null) {
            str = null;
        } else {
            str = unfollowedProfilesModel.m13770k().m13761a();
        }
        awesomizerNetworkQueryHelper.f11788f.a("QUERY_AWESOMIZER_REFOLLOWING_TASK_ID", new C12622(awesomizerNetworkQueryHelper, b, str), abstractDisposableFutureCallback);
    }

    protected final void mo810a(GraphQLResult<FeedAwesomizerUnfollowingQueryModel> graphQLResult) {
        UnfollowedProfilesModel a;
        if (this.f11817h.f11803g != null) {
            UnfollowedProfilesModel a2 = ((FeedAwesomizerUnfollowingQueryModel) graphQLResult.e).m13772a();
            ImmutableList j = ((UnfollowedProfilesModel) this.f11817h.f11803g).m13769j();
            j = ImmutableList.builder().b(j).b(a2.m13769j()).b();
            Builder a3 = Builder.m13746a(a2);
            a3.f11716b = j;
            a = a3.m13747a();
        } else {
            a = ((FeedAwesomizerUnfollowingQueryModel) graphQLResult.e).m13772a();
        }
        this.f11817h.m13882a(a, a.m13770k().m13763j(), a.m13765a());
    }

    protected final int mo816g(int i) {
        return this.f11817h.mo817e(i) ? this.f11813d.c : 1;
    }

    protected final void aq() {
        this.f11814e.setAdapter(this.f11817h);
    }

    protected final AwesomizerCards ar() {
        return AwesomizerCards.REFOLLOW;
    }

    protected final int as() {
        return 2131562043;
    }
}
