package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel;
import com.facebook.feed.awesomizer.data.FeedAwesomizerGraphQLModels.FeedAwesomizerDiscoverTopicQueryModel.SuggestedPagesModel.Builder;
import com.facebook.feed.awesomizer.ui.AwesomizerFragment.AwesomizerCards;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;

/* compiled from: gysc_feed */
public class DiscoverTopicFragment extends BaseAwesomizerFragment<FeedAwesomizerDiscoverTopicQueryModel> {
    public AwesomizerNetworkQueryHelper am;
    private String an;
    private String ao;

    public static void m13933a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        DiscoverTopicFragment discoverTopicFragment = (DiscoverTopicFragment) obj;
        AwesomizerNetworkQueryHelper b = AwesomizerNetworkQueryHelper.m13867b(injectorLike);
        DiscoverTopicAdapter discoverTopicAdapter = new DiscoverTopicAdapter(AwesomizerNetworkQueryHelper.m13867b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
        discoverTopicFragment.am = b;
        discoverTopicFragment.f11817h = discoverTopicAdapter;
    }

    public final void m13938c(Bundle bundle) {
        super.c(bundle);
        Class cls = DiscoverTopicFragment.class;
        m13933a(this, getContext());
        this.an = o().getIntent().getExtras().getString("topic_id");
        this.ao = o().getIntent().getExtras().getString("topic_name");
    }

    protected final void mo818b(View view) {
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(this.ao);
            hasTitleBar.c(true);
        }
    }

    protected final int mo815e() {
        return 2131625685;
    }

    protected final void mo809a(AbstractDisposableFutureCallback abstractDisposableFutureCallback) {
        String str;
        SuggestedPagesModel suggestedPagesModel = (SuggestedPagesModel) this.f11817h.f11803g;
        AwesomizerNetworkQueryHelper awesomizerNetworkQueryHelper = this.am;
        String str2 = this.an;
        int b = mo814b();
        int i = 5;
        int i2 = 26;
        if (suggestedPagesModel == null) {
            str = null;
        } else {
            str = suggestedPagesModel.m13648k().m13639a();
        }
        awesomizerNetworkQueryHelper.m13876a(abstractDisposableFutureCallback, str2, b, i, i2, str);
    }

    protected final void mo810a(GraphQLResult<FeedAwesomizerDiscoverTopicQueryModel> graphQLResult) {
        SuggestedPagesModel suggestedPagesModel;
        if (this.f11817h.f11803g != null) {
            SuggestedPagesModel a = ((FeedAwesomizerDiscoverTopicQueryModel) graphQLResult.e).m13652a();
            suggestedPagesModel = (SuggestedPagesModel) this.f11817h.f11803g;
            ImmutableList b = ImmutableList.builder().b(suggestedPagesModel.m13647j()).b(a.m13647j()).b();
            Builder a2 = Builder.m13618a(a);
            a2.f11652b = b;
            suggestedPagesModel = a2.m13619a();
        } else {
            suggestedPagesModel = ((FeedAwesomizerDiscoverTopicQueryModel) graphQLResult.e).m13652a();
        }
        this.f11817h.m13882a(suggestedPagesModel, suggestedPagesModel.m13648k().m13641j(), suggestedPagesModel.m13643a());
    }

    protected final int mo816g(int i) {
        return this.f11817h.mo817e(i) ? this.f11813d.c : 1;
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
        return 20;
    }
}
