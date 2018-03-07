package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerSeefirstCardQueryModel.FollowedProfilesModel.Builder;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.feed.awesomizer.ui.AwesomizerNetworkQueryHelper.C12633;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.google.common.collect.ImmutableList;

/* compiled from: group_unconfirmed_member_send_reminder */
public class SeefirstFragment extends BaseAwesomizerFragment<FeedAwesomizerSeefirstCardQueryModel> {
    public AwesomizerNetworkQueryHelper am;

    public static void m13970a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SeefirstFragment seefirstFragment = (SeefirstFragment) obj;
        AwesomizerNetworkQueryHelper b = AwesomizerNetworkQueryHelper.m13867b(injectorLike);
        SeefirstAdapter seefirstAdapter = new SeefirstAdapter(AwesomizerNetworkQueryHelper.m13867b(injectorLike), ErrorDialogs.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
        seefirstFragment.am = b;
        seefirstFragment.f11817h = seefirstAdapter;
    }

    public final void m13973c(Bundle bundle) {
        super.c(bundle);
        Class cls = SeefirstFragment.class;
        m13970a(this, getContext());
    }

    protected final int mo815e() {
        return 2131625683;
    }

    protected final void mo809a(AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        String str;
        FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) this.f11817h.f11803g;
        AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper = this.am;
        int b = mo814b();
        if (followedProfilesModel == null) {
            str = null;
        } else {
            str = followedProfilesModel.m13739k().m13730a();
        }
        awesomizerNetworkQueryHelper.f11788f.a("QUERY_AWESOMIZER_SEEFIRST_TASK_ID", new C12633(awesomizerNetworkQueryHelper, b, str), abstractDisposableFutureCallback);
    }

    protected final int mo816g(int i) {
        return this.f11817h.mo817e(i) ? this.f11813d.c : 1;
    }

    protected final void aq() {
        this.f11814e.setAdapter(this.f11817h);
    }

    protected final void mo810a(GraphQLResult<FeedAwesomizerSeefirstCardQueryModel> graphQLResult) {
        FollowedProfilesModel a;
        if (this.f11817h.f11803g != null) {
            FollowedProfilesModel a2 = ((FeedAwesomizerSeefirstCardQueryModel) graphQLResult.e).m13742a();
            ImmutableList j = ((FollowedProfilesModel) this.f11817h.f11803g).m13738j();
            j = ImmutableList.builder().b(j).b(a2.m13738j()).b();
            Builder a3 = Builder.m13717a(a2);
            a3.f11705b = j;
            a = a3.m13718a();
        } else {
            a = ((FeedAwesomizerSeefirstCardQueryModel) graphQLResult.e).m13742a();
        }
        this.f11817h.m13882a(a, a.m13739k().m13732j(), a.m13734a());
    }

    protected final AwesomizerCards ar() {
        return AwesomizerCards.SEEFIRST;
    }

    protected final int as() {
        return 2131562041;
    }
}
