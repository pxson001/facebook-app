package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverCardQueryModel;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.common.ComponentName_FragmentChromeActivityMethodAutoProvider;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;

/* compiled from: gysccta_click */
public class DiscoverFragment extends BaseAwesomizerFragment<FeedAwesomizerDiscoverCardQueryModel> {
    public AwesomizerNetworkQueryHelper am;

    public static void m13919a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        DiscoverFragment discoverFragment = (DiscoverFragment) obj;
        AwesomizerNetworkQueryHelper b = AwesomizerNetworkQueryHelper.m13867b(injectorLike);
        DiscoverAdapter discoverAdapter = new DiscoverAdapter((Context) injectorLike.getInstance(Context.class), AwesomizerNetworkQueryHelper.m13867b(injectorLike), ComponentName_FragmentChromeActivityMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
        discoverFragment.am = b;
        discoverFragment.f11817h = discoverAdapter;
    }

    public final void m13923c(Bundle bundle) {
        super.c(bundle);
        Class cls = DiscoverFragment.class;
        m13919a(this, getContext());
        DiscoverAdapter.f11826f = o().getIntent().getExtras().getString("session_id");
    }

    protected final int mo815e() {
        return 2131625684;
    }

    protected final void mo809a(AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        this.am.m13875a(abstractDisposableFutureCallback, mo814b(), 5, 5, 26);
    }

    protected final int mo816g(int i) {
        Object obj = (this.f11817h.mo817e(i) || this.f11817h.mo806f(i)) ? 1 : null;
        return obj != null ? this.f11813d.c : 1;
    }

    protected final void aq() {
        this.f11814e.setAdapter(this.f11817h);
    }

    protected final AwesomizerCards ar() {
        return AwesomizerCards.DISCOVER;
    }

    protected final int as() {
        return 2131562044;
    }

    protected final int mo814b() {
        return 5;
    }

    protected final void mo810a(GraphQLResult<FeedAwesomizerDiscoverCardQueryModel> graphQLResult) {
        this.f11817h.m13882a(((FeedAwesomizerDiscoverCardQueryModel) graphQLResult.e).m13615a(), false, this.f11817h.aZ_());
    }
}
