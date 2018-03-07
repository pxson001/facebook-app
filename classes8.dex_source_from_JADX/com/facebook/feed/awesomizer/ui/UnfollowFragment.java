package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerFollowingQueryModel.FollowedProfilesModel.Builder;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.AwesomizerNetworkQueryHelper.C12611;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.google.common.collect.ImmutableList;

/* compiled from: group_title */
public class UnfollowFragment extends BaseAwesomizerFragment<FeedAwesomizerFollowingQueryModel> {
    public AwesomizerNetworkQueryHelper am;

    public static void m13983a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        UnfollowFragment unfollowFragment = (UnfollowFragment) obj;
        AwesomizerNetworkQueryHelper b = AwesomizerNetworkQueryHelper.m13867b(injectorLike);
        UnfollowAdapter unfollowAdapter = new UnfollowAdapter(AwesomizerNetworkQueryHelper.m13867b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
        unfollowFragment.am = b;
        unfollowFragment.f11817h = unfollowAdapter;
    }

    public final void m13986c(Bundle bundle) {
        super.c(bundle);
        Class cls = UnfollowFragment.class;
        m13983a(this, getContext());
    }

    protected final int mo815e() {
        return 2131625681;
    }

    protected final void mo809a(AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        String str;
        FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) this.f11817h.f11803g;
        AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper = this.am;
        int b = mo814b();
        if (followedProfilesModel == null) {
            str = null;
        } else {
            str = followedProfilesModel.m13681k().m13672a();
        }
        awesomizerNetworkQueryHelper.f11788f.a("QUERY_AWESOMIZER_UNFOLLOWING_TASK_ID", new C12611(awesomizerNetworkQueryHelper, b, str), abstractDisposableFutureCallback);
    }

    protected final void mo810a(GraphQLResult<FeedAwesomizerFollowingQueryModel> graphQLResult) {
        FollowedProfilesModel a;
        if (this.f11817h.f11803g != null) {
            FollowedProfilesModel a2 = ((FeedAwesomizerFollowingQueryModel) graphQLResult.e).m13684a();
            ImmutableList j = ((FollowedProfilesModel) this.f11817h.f11803g).m13680j();
            j = ImmutableList.builder().b(j).b(a2.m13680j()).b();
            Builder a3 = Builder.m13657a(a2);
            a3.f11675b = j;
            a = a3.m13658a();
        } else {
            a = ((FeedAwesomizerFollowingQueryModel) graphQLResult.e).m13684a();
        }
        this.f11817h.m13882a(a, a.m13681k().m13674j(), a.m13676a());
    }

    protected final int mo816g(int i) {
        return this.f11817h.mo817e(i) ? this.f11813d.c : 1;
    }

    protected final void aq() {
        this.f11814e.setAdapter(this.f11817h);
    }

    protected final AwesomizerCards ar() {
        return AwesomizerCards.UNFOLLOW;
    }

    protected final int as() {
        return 2131562042;
    }
}
