package com.facebook.reaction.ui.datafetcher;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.showmore.ReactionShowMoreComponentsItemCollection;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreComponentsResultModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionMoreComponentsResultModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreDataFetcher.FetcherListener;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Unrecognized action type  */
public class ReactionShowMoreComponentsDataFetcher extends ReactionShowMoreDataFetcher<ReactionMoreComponentsResultModel, ReactionShowMoreComponentsItemCollection> {
    private final String f21111a;
    private final ReactionShowMoreComponentsItemCollection f21112b;
    private final FetcherListener f21113c;
    private final ReactionUtil f21114d;
    private final String f21115e;
    private final Surface f21116f;
    private final String f21117g;
    private final String f21118h;

    protected final DefaultPageInfoFields mo1151a(Object obj) {
        return ((ReactionMoreComponentsResultModel) obj).a().j();
    }

    protected final void mo1153b(Object obj) {
        ImmutableList a = ((ReactionMoreComponentsResultModel) obj).a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentModel a2 = ((EdgesModel) a.get(i)).a();
            if (a2 != null) {
                ReactionShowMoreComponentsItemCollection reactionShowMoreComponentsItemCollection = this.f21112b;
                reactionShowMoreComponentsItemCollection.f19503a.add(reactionShowMoreComponentsItemCollection.f19503a.size(), new ReactionUnitComponentNode(a2, this.f21117g, this.f21118h, this.f21115e));
            }
        }
        this.f21113c.mo1126d();
    }

    public final ReactionShowMoreComponentsItemCollection m24728a() {
        return this.f21112b;
    }

    protected final void mo1152a(String str, DisposableFutureCallback<GraphQLResult<ReactionMoreComponentsResultModel>> disposableFutureCallback) {
        this.f21114d.m22668b(str, (DisposableFutureCallback) disposableFutureCallback, 10, this.f21111a, this.f21116f);
    }

    @Inject
    public ReactionShowMoreComponentsDataFetcher(@Assisted String str, @Assisted FetcherListener fetcherListener, @Assisted ReactionSession reactionSession, @Assisted String str2, @Assisted String str3, @Assisted String str4, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ReactionShowMoreComponentsItemCollection reactionShowMoreComponentsItemCollection, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionUtil reactionUtil) {
        super(defaultAndroidThreadUtil, reactionAnalyticsLogger, reactionSession.f18658a, reactionSession.f18660c);
        this.f21111a = str;
        this.f21112b = reactionShowMoreComponentsItemCollection;
        this.f21113c = fetcherListener;
        this.f21114d = reactionUtil;
        this.f21115e = str2;
        this.f21116f = reactionSession.f18660c;
        this.f21117g = str3;
        this.f21118h = str4;
    }
}
