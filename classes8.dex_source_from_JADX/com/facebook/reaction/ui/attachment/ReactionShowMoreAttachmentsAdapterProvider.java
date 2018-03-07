package com.facebook.reaction.ui.attachment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreAttachmentsDataFetcherProvider;

/* compiled from: WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID in the return intent */
public class ReactionShowMoreAttachmentsAdapterProvider extends AbstractAssistedProvider<ReactionShowMoreAttachmentsAdapter> {
    public final <VH extends ViewHolder> ReactionShowMoreAttachmentsAdapter<VH> m24432a(ReactionRecyclableAttachmentHandler<VH> reactionRecyclableAttachmentHandler, ReactionCardContainer reactionCardContainer, String str, Surface surface, String str2) {
        return new ReactionShowMoreAttachmentsAdapter(reactionRecyclableAttachmentHandler, reactionCardContainer, str, surface, str2, (ReactionShowMoreAttachmentsDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(ReactionShowMoreAttachmentsDataFetcherProvider.class));
    }
}
