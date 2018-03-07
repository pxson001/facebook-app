package com.facebook.reaction.ui.datafetcher;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryAttachmentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionMoreAttachmentsResultModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionMoreAttachmentsResultModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreDataFetcher.FetcherListener;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Unregistered callsite for display style  */
public class ReactionShowMoreAttachmentsDataFetcher<VH extends ViewHolder> extends ReactionShowMoreDataFetcher<ReactionMoreAttachmentsResultModel, List<ReactionStoryAttachmentFragment>> {
    private final ReactionRecyclableAttachmentHandler<VH> f21105a;
    public final List<ReactionStoryAttachmentFragment> f21106b = new ArrayList();
    private final FetcherListener f21107c;
    private final ReactionUtil f21108d;
    private final Surface f21109e;
    private final String f21110f;

    protected final DefaultPageInfoFields mo1151a(Object obj) {
        return ((ReactionMoreAttachmentsResultModel) obj).a().j();
    }

    protected final void mo1153b(Object obj) {
        ImmutableList a = ((ReactionMoreAttachmentsResultModel) obj).a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ReactionStoryAttachmentFragmentModel a2 = ((EdgesModel) a.get(i)).a();
            if (a2 != null && this.f21105a.mo1119b(a2)) {
                this.f21106b.add(a2);
            }
        }
        this.f21107c.mo1126d();
    }

    @Inject
    public ReactionShowMoreAttachmentsDataFetcher(@Assisted ReactionRecyclableAttachmentHandler<VH> reactionRecyclableAttachmentHandler, @Assisted String str, @Assisted FetcherListener fetcherListener, @Assisted String str2, @Assisted Surface surface, AndroidThreadUtil androidThreadUtil, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionUtil reactionUtil) {
        super(androidThreadUtil, reactionAnalyticsLogger, str2, surface);
        this.f21105a = reactionRecyclableAttachmentHandler;
        this.f21107c = fetcherListener;
        this.f21108d = reactionUtil;
        this.f21109e = surface;
        this.f21110f = str;
    }

    protected final void mo1152a(String str, DisposableFutureCallback<GraphQLResult<ReactionMoreAttachmentsResultModel>> disposableFutureCallback) {
        this.f21108d.m22663a(str, (DisposableFutureCallback) disposableFutureCallback, 10, this.f21110f, this.f21109e);
    }
}
